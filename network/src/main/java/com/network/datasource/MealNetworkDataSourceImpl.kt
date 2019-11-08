package com.network.datasource

import android.util.Log
import com.data.datasource.network.MealNetworkDatasource
import com.domain.model.MealDetailsVO
import com.network.mapper.MealDetailsMapper
import com.network.service.RecipeService
import javax.inject.Inject
import javax.inject.Named

class MealNetworkDataSourceImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val mealMapper: MealDetailsMapper,
    @Named("api_key") private val apiKey: String
) : MealNetworkDatasource {
    override fun getMealDetails(mealID: String): MealDetailsVO? {
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