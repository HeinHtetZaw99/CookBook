package com.data.datasource.network

import com.domain.model.MealSnapshotVO

interface MealSnapShotNetworkDataSource {
    fun getMealsSnapshot(categoryName: String): List<MealSnapshotVO>
}