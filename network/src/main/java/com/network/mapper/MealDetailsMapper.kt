package com.network.mapper

import com.domain.mapper.UnidirectionalMap
import com.domain.model.MealDetailsVO
import com.network.entity.MealsDetailItem
import javax.inject.Inject

class MealDetailsMapper @Inject constructor() : UnidirectionalMap<MealsDetailItem, MealDetailsVO> {
    override fun map(data: MealsDetailItem): MealDetailsVO {
        val ingredientsWithPortionsList = HashMap<String, String>()
        if (data.strIngredient1 != null && data.strMeasure1 != null)
            ingredientsWithPortionsList[data.strIngredient1] = data.strMeasure1

        if (data.strIngredient2 != null && data.strMeasure2 != null)
            ingredientsWithPortionsList[data.strIngredient2] = data.strMeasure2

        if (data.strIngredient3 != null && data.strMeasure3 != null)
            ingredientsWithPortionsList[data.strIngredient3] = data.strMeasure3

        if (data.strIngredient4 != null && data.strMeasure4 != null)
            ingredientsWithPortionsList[data.strIngredient4] = data.strMeasure4

        if (data.strIngredient5 != null && data.strMeasure5 != null)
            ingredientsWithPortionsList[data.strIngredient5] = data.strMeasure5

        if (data.strIngredient6 != null && data.strMeasure6 != null)
            ingredientsWithPortionsList[data.strIngredient6] = data.strMeasure6

        if (data.strIngredient7 != null && data.strMeasure7 != null)
            ingredientsWithPortionsList[data.strIngredient7] = data.strMeasure7

        if (data.strIngredient8 != null && data.strMeasure8 != null)
            ingredientsWithPortionsList[data.strIngredient8] = data.strMeasure8

        if (data.strIngredient9 != null && data.strMeasure9 != null)
            ingredientsWithPortionsList[data.strIngredient9] = data.strMeasure9

        if (data.strIngredient10 != null && data.strMeasure10 != null)
            ingredientsWithPortionsList[data.strIngredient10] = data.strMeasure10

        if (data.strIngredient11 != null && data.strMeasure11 != null)
            ingredientsWithPortionsList[data.strIngredient11] = data.strMeasure11

        if (data.strIngredient12 != null && data.strMeasure12 != null)
            ingredientsWithPortionsList[data.strIngredient12] = data.strMeasure12

        if (data.strIngredient13 != null && data.strMeasure13 != null)
            ingredientsWithPortionsList[data.strIngredient13] = data.strMeasure13

        if (data.strIngredient14 != null && data.strMeasure14 != null)
            ingredientsWithPortionsList[data.strIngredient14] = data.strMeasure14

        if (data.strIngredient15 != null && data.strMeasure15 != null)
            ingredientsWithPortionsList[data.strIngredient15] = data.strMeasure15

        if (data.strIngredient16 != null && data.strMeasure16 != null)
            ingredientsWithPortionsList[data.strIngredient16] = data.strMeasure16

        if (data.strIngredient17 != null && data.strMeasure17 != null)
            ingredientsWithPortionsList[data.strIngredient17] = data.strMeasure17

        if (data.strIngredient18 != null && data.strMeasure18 != null)
            ingredientsWithPortionsList[data.strIngredient18] = data.strMeasure18

        if (data.strIngredient19 != null && data.strMeasure19 != null)
            ingredientsWithPortionsList[data.strIngredient19] = data.strMeasure19

        if (data.strIngredient20 != null && data.strMeasure20 != null)
            ingredientsWithPortionsList[data.strIngredient20] = data.strMeasure20

        return MealDetailsVO(
            mealName = data.strMeal,
            mealID = data.idMeal,
            mealThumbnail = data.strMealThumb,
            dateModified = data.dateModified,
            drinkAlternate = data.strDrinkAlternate,
            instructions = data.strInstructions,
            area = data.strArea,
            youtubeLink = data.strYoutube,
            source = data.strSource,
            ingredientsWithMeasurement = ingredientsWithPortionsList,
            tags = data.strTags
        )
    }

}