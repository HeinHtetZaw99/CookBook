package com.domain.model

data class MealDetailsVO(
    var mealID : String? = null ,
    var category: String? = null,
    var area: String? = null,
    var tags: String? = null,
    var instructions: String? = null,
    var mealThumbnail: String? = null,
    var youtubeLink: String? = null,
    var mealName: String? = null,
    var dateModified: String? = null,
    var drinkAlternate: String? = null,
    var source: String? = null,
    var ingredientList : List<IngredientsVO>? = null ,
    var ingredientsWithMeasurement: HashMap<String, String>? = null
)