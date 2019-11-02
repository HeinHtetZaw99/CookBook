package com.cookbook.mealsdetails

import androidx.lifecycle.MutableLiveData
import com.appbase.BaseViewModel
import com.appbase.ErrorVO
import com.appbase.components.SingleEventLiveData
import com.domain.interactors.GetMealDetails
import com.domain.model.MealDetailsVO
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MealsDetailsViewModel @Inject constructor(
    private val getMealDetails: GetMealDetails
) : BaseViewModel() {

    val mealDetailsLD: MutableLiveData<MealDetailsVO> by lazy { MutableLiveData<MealDetailsVO>() }
    val errorLD: SingleEventLiveData<ErrorVO> by lazy { SingleEventLiveData<ErrorVO>() }

    fun getMealDetails(mealID: String) {
        getMealDetails.execute(GetMealDetails.Params("1", mealID))
            .subscribeBy(
                onSuccess = {
                    mealDetailsLD.postValue(it)
                },
                onError = {
                    errorLD.postValue(ErrorVO(it.message, ErrorVO.TYPE.ERROR))

                }
            ).addTo(compositeDisposable)
    }

}