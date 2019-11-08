package com.data.repository

import com.data.datasource.cache.MealSnapShotCacheDataSource
import com.data.datasource.network.MealSnapShotNetworkDataSource
import com.data.mapper.MealSnapShotEntityMapper
import com.domain.model.MealSnapshotVO
import com.domain.repository.MealSnapShotRepository
import io.reactivex.Single
import javax.inject.Inject

class MealSnapShotRepositoryImpl @Inject constructor(
    private val mealSnapShotNetworkDataSource: MealSnapShotNetworkDataSource,
    private val mealSnapShotCacheDataSource: MealSnapShotCacheDataSource,
    private val mealSnapShotEntityMapper: MealSnapShotEntityMapper
) : MealSnapShotRepository {
    override fun getMealSnapShotsByCategory(
        category: String
    ): Single<List<MealSnapshotVO>> {
        return Single.fromCallable {
            mealSnapShotNetworkDataSource.getMealsSnapshot(category)
        }.doOnError {
            val menuList = mealSnapShotCacheDataSource.getMealSnapShotList(category)

            if (menuList != null)
                mealSnapShotEntityMapper.reverseMap(menuList)
        }
    }

}