package com.domain.repository

import com.domain.model.MealDetailsVO
import io.reactivex.Single

interface MealDetailsRepository {
    fun getMealDetails(
        mealID : String
    ) : Single<MealDetailsVO>
}