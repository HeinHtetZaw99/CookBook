package com.cookbook.mealsmenu

import androidx.lifecycle.MutableLiveData
import com.appbase.BaseViewModel
import com.appbase.ErrorVO
import com.appbase.components.SingleEventLiveData
import com.appbase.showLogE
import com.domain.interactors.GetMealSnapShots
import com.domain.model.MealSnapshotVO
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getMealSnapShots: GetMealSnapShots
) : BaseViewModel() {
    val menuLD = MutableLiveData<List<MealSnapshotVO>>()
    val menuErrorLD = SingleEventLiveData<ErrorVO>()

    fun getCategoryListData(categoryName: String) {
        getMealSnapShots.execute(GetMealSnapShots.Params("1", categoryName))
            .subscribeBy(
                onSuccess = {
                    menuLD.postValue(it)
                },
                onError = {
                    menuErrorLD.postValue(ErrorVO(it.message, ErrorVO.TYPE.ERROR))
                    this.javaClass.showLogE(it)
                }
            ).addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}