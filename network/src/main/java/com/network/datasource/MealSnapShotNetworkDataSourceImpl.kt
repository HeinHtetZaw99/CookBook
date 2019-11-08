package com.network.datasource

import android.util.Log
import com.data.datasource.network.MealSnapShotNetworkDataSource
import com.domain.model.MealSnapshotVO
import com.network.entity.MealsItem
import com.network.mapper.MealSnapShotMapper
import com.network.service.RecipeService
import javax.inject.Inject
import javax.inject.Named

@Suppress("UNCHECKED_CAST")
class MealSnapShotNetworkDataSourceImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val mealSnapShotMapper: MealSnapShotMapper,
    @Named("api_key") private val apiKey: String
) : MealSnapShotNetworkDataSource {
    override fun getMealsSnapshot(categoryName: String): List<MealSnapshotVO> {
        return try {
            mealSnapShotMapper.map(
                (recipeService.getFilteredListByCategory(
                    apiKey,
                    categoryName
                ).execute().body()!!.meals as List<MealsItem>?)!!
            )
        } catch (npe: NullPointerException) {
            Log.e("APP_TAG", "NPE occurred @ MealSnapShotNetworkDataSourceImpl \n ${npe.message}")
            emptyList()
        }
    }

}