package com.network.service

import com.network.entity.MealCategoryResponse
import com.network.entity.MealSearchResponse
import com.network.entity.MealsByCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("v1/{api_key}/categories.php")
    fun getMealsCategory(
        @Path("api_key") apiKey: String
    ): Call<MealCategoryResponse>

    @GET("v1/{api_key}/filter.php")
    fun getFilteredListByCategory(
        @Path("api_key") apiKey: String,
        @Query("c") categoryName: String
    ): Call<MealsByCategoryResponse>

    @GET("v1/{api_key}/search.php")
    fun searchMeal(
        @Path("api_key") apiKey: String,
        @Query("s") mealName: String
    ): Call<MealSearchResponse>

    @GET("v1/{api_key}/lookup.php")
    fun getMealDetails(
        @Path("api_key") apiKey: String,
        @Query("i") mealID: String
    ): Call<MealSearchResponse>
}