package com.network.datasource

import android.util.Log
import com.data.datasource.network.MealNetworkDatasource
import com.domain.model.MealDetailsVO
import com.network.mapper.MealDetailsMapper
import com.network.service.RecipeService
import javax.inject.Inject

class MealNetworkDataSourceImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val mealMapper: MealDetailsMapper
) : MealNetworkDatasource {
    override fun getMealDetails(apiKey: String, mealID: String): MealDetailsVO? {
        return try {
            mealMapper.map(
                recipeService.getMealDetails(apiKey, mealID).execute().body()!!.meals?.get(0)!!
            )
        } catch (npe: NullPointerException) {
            Log.e("APP_TAG", "NPE occurred @ MealNetworkDataSourceImpl \n ${npe.message}")
            null
        }
    }
}