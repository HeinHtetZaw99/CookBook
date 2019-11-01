package com.data.repository

import com.data.datasource.cache.CategoryCacheDataSource
import com.data.datasource.network.CategoryNetworkDataSource
import com.data.mapper.CategoryEntityListMapper
import com.domain.model.CategoryVO
import com.domain.repository.CategoryRepository
import io.reactivex.Single
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryNetworkDataSource: CategoryNetworkDataSource,
    private val categoryCacheDataSource: CategoryCacheDataSource,
    private val categoryEntityListMapper: CategoryEntityListMapper
) : CategoryRepository {
    override fun getMealCategory(apiKey: String): Single<List<CategoryVO>> {
        return Single.fromCallable {
            categoryNetworkDataSource.getMealsCategory(apiKey)
        }.doOnError {
            categoryEntityListMapper.reverseMap(categoryCacheDataSource.getCategoryList()!!)
        }
    }

}