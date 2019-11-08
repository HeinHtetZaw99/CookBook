package com.network.datasource

import android.util.Log
import com.data.datasource.network.CategoryNetworkDataSource
import com.domain.model.CategoryVO
import com.network.entity.CategoriesItem
import com.network.mapper.CategoryMapper
import com.network.service.RecipeService
import javax.inject.Inject
import javax.inject.Named

@Suppress("UNCHECKED_CAST")
class CategoryNetworkDataSourceImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val categoryMapper: CategoryMapper,
    @Named("api_key") private val apiKey: String
) : CategoryNetworkDataSource {
    override fun getMealsCategory(): List<CategoryVO> {
        return try {
            categoryMapper.map(
                (recipeService.getMealsCategory(apiKey).execute().body()!!.categories as List<CategoriesItem>?)!!
            )
        }catch (npe : NullPointerException){
            Log.e("APP_TAG", "NPE occurred @ CategoryNetworkDataSourceImpl \n ${npe.message}")
            emptyList()
        }
    }

}