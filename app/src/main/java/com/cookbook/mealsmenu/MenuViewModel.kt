package com.cookbook.mealsmenu

import androidx.lifecycle.MutableLiveData
import com.appbase.BaseViewModel
import com.appbase.ErrorVO
import com.appbase.components.SingleEventLiveData
import com.appbase.showLogD
import com.appbase.showLogE
import com.cookbook.R
import com.data.datasource.cache.MealSnapShotCacheDataSource
import com.data.mapper.MealSnapShotEntityMapper
import com.domain.interactors.GetMealSnapShots
import com.domain.model.MealSnapshotVO
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getMealSnapShots: GetMealSnapShots,
    private val menuDataSource: MealSnapShotCacheDataSource,
    private val mapper: MealSnapShotEntityMapper
) : BaseViewModel() {
    val menuLD = MutableLiveData<List<MealSnapshotVO>>()
    val menuErrorLD = SingleEventLiveData<ErrorVO>()

    fun getCategoryListData(categoryName: String) {
        getMealSnapShots.execute(GetMealSnapShots.Params("1", categoryName))
            .subscribeBy(
                onSuccess = {
                    menuLD.postValue(it)
                    for (entry in it) {
                        entry.categoryName = categoryName
                    }
                    showLogD(" Meal list stored in DB : $it")
                    menuDataSource.putMealSnapShotList(mapper.map(it))
                },
                onError = {
                    val data = menuDataSource.getMealSnapShotList(categoryName)
                    if (data != null && data.isNotEmpty()) {
                        menuLD.postValue(mapper.reverseMap(data))
                        menuErrorLD.postValue(
                            ErrorVO(
                                R.string.snackbar_msg_offline,
                                ErrorVO.TYPE.ERROR
                            )
                        )
                    } else {
                        menuErrorLD.postValue(
                            ErrorVO(
                                R.string.snackbar_msg_no_data,
                                ErrorVO.TYPE.ERROR
                            )
                        )
                    }
                    this.javaClass.showLogE(it)
                }
            ).addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}