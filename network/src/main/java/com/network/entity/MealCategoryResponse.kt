package com.network.entity

import com.google.gson.annotations.SerializedName

data class MealCategoryResponse(

    @field:SerializedName("categories")
    val categories: List<CategoriesItem?>? = null
)