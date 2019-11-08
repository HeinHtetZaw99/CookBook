package com.cookbook.mealsdetails

import androidx.lifecycle.MutableLiveData
import com.appbase.BaseViewModel
import com.appbase.ErrorVO
import com.appbase.components.SingleEventLiveData
import com.cookbook.R
import com.data.datasource.cache.MealCacheDataSource
import com.data.mapper.MealsDetailsEntityMapper
import com.domain.interactors.GetMealDetails
import com.domain.model.MealDetailsVO
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MealsDetailsViewModel @Inject constructor(
    private val getMealDetails: GetMealDetails,
    private val mealDetailsCacheDataSource: MealCacheDataSource,
    private val mapper: MealsDetailsEntityMapper
) : BaseViewModel() {

    val mealDetailsLD: MutableLiveData<MealDetailsVO> by lazy { MutableLiveData<MealDetailsVO>() }
    val errorLD: SingleEventLiveData<ErrorVO> by lazy { SingleEventLiveData<ErrorVO>() }

    fun getMealDetails(mealID: String) {
        getMealDetails.execute(GetMealDetails.Params(mealID))
            .subscribeBy(
                onSuccess = {
                    mealDetailsLD.postValue(it)
                    mealDetailsCacheDataSource.putMeal(mapper.map(it))
                },
                onError = {
                    val data = mealDetailsCacheDataSource.getMeal(mealID)

                    if (data == null) {
//                        errorLD.postValue(ErrorVO(it.message, ErrorVO.TYPE.ERROR))
                        errorLD.postValue(
                            ErrorVO(
                                R.string.snackbar_msg_no_data,
                                ErrorVO.TYPE.ERROR
                            )
                        )
                    } else {
                        mealDetailsLD.postValue(mapper.reverseMap(data))
                        errorLD.postValue(
                            ErrorVO(
                                R.string.snackbar_msg_offline,
                                ErrorVO.TYPE.ERROR
                            )
                        )
                    }
                }
            ).addTo(compositeDisposable)
    }

}