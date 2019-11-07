package com.cookbook.category

import androidx.lifecycle.MutableLiveData
import com.appbase.BaseViewModel
import com.appbase.ErrorVO
import com.appbase.components.SingleEventLiveData
import com.appbase.showLogE
import com.cookbook.R
import com.data.datasource.cache.CategoryCacheDataSource
import com.data.mapper.CategoryEntityListMapper
import com.domain.interactors.GetCategories
import com.domain.model.CategoryVO
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val getCategories: GetCategories,
    private val categoryCacheDataSource: CategoryCacheDataSource,
    private val mapper: CategoryEntityListMapper
) : BaseViewModel() {

    val categoryLD = MutableLiveData<List<CategoryVO>>()
    val categoryErrorLD = SingleEventLiveData<ErrorVO>()

    fun getCategoryListData() {
        getCategories.execute(GetCategories.Params("1"))
            .subscribeBy(
                onSuccess = {
                    categoryLD.postValue(it)
                    categoryCacheDataSource.putCategoryList(mapper.map(it))
                },
                onError = {
                    val dataList = categoryCacheDataSource.getCategoryList()
                    if (dataList != null && dataList.isNotEmpty()) {
                        categoryLD.postValue(mapper.reverseMap(dataList))
                        categoryErrorLD.postValue(
                            ErrorVO(
                                R.string.snackbar_msg_offline,
                                ErrorVO.TYPE.POSITIVE
                            )
                        )
                    } else {
                        categoryErrorLD.postValue(
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