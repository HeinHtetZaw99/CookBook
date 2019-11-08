package com.domain.repository

import com.domain.model.MealSnapshotVO
import io.reactivex.Single

interface MealSnapShotRepository {
    fun getMealSnapShotsByCategory(
        category: String
    ): Single<List<MealSnapshotVO>>
}