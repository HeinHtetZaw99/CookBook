package com.cookbook.category

import androidx.lifecycle.MutableLiveData
import com.appbase.BaseViewModel
import com.appbase.ErrorVO
import com.appbase.components.SingleEventLiveData
import com.appbase.showLogE
import com.domain.interactors.GetCategories
import com.domain.model.CategoryVO
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val getCategories: GetCategories
) : BaseViewModel() {

    val categoryLD = MutableLiveData<List<CategoryVO>>()
    val categoryErrorLD = SingleEventLiveData<ErrorVO>()

    fun getCategoryListData() {
        getCategories.execute(GetCategories.Params("1"))
            .subscribeBy(
                onSuccess = {
                    categoryLD.postValue(it)
                },
                onError = {
                    categoryErrorLD.postValue(ErrorVO(it.message, ErrorVO.TYPE.ERROR))
                    this.javaClass.showLogE(it)
                }
            ).addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}