package com.network.entity

import com.google.gson.annotations.SerializedName

data class MealsItem(
	@field:SerializedName("strMealThumb")
	var strMealThumb: String? = null,
	@field:SerializedName("idMeal")
	var idMeal: String? = null,
	@field:SerializedName("strMeal")
	var strMeal: String? = null
)
