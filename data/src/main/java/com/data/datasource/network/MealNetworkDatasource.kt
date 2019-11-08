package com.data.datasource.network

import com.domain.model.MealDetailsVO

interface MealNetworkDatasource {
    fun getMealDetails(mealID: String): MealDetailsVO?
}
