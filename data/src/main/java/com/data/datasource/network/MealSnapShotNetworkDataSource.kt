package com.data.datasource.network

import com.domain.model.MealSnapshotVO

interface MealSnapShotNetworkDataSource {
    fun getMealsSnapshot(apiKey : String , categoryName : String): List<MealSnapshotVO>
}