package com.data.repository

import com.data.datasource.cache.MealCacheDataSource
import com.data.datasource.network.MealNetworkDatasource
import com.data.mapper.MealsDetailsEntityMapper
import com.domain.model.MealDetailsVO
import com.domain.repository.MealDetailsRepository
import io.reactivex.Single
import javax.inject.Inject

class MealDetailsRepositoryImpl @Inject constructor(
    private val mealNetworkDataSource: MealNetworkDatasource,
    private val mealCacheDataSource: MealCacheDataSource,
    private val mealsDetailsEntityMapper: MealsDetailsEntityMapper
) : MealDetailsRepository {
    override fun getMealDetails(apiKey: String, mealID: String): Single<MealDetailsVO> {
        return Single.fromCallable {
            mealNetworkDataSource.getMealDetails(apiKey, mealID)!!
        }.doOnError {
            mealsDetailsEntityMapper.reverseMap(mealCacheDataSource.getMeal(mealID)!!)
        }
    }

}