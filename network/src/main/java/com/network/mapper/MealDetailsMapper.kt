package com.network.mapper

import com.domain.mapper.UnidirectionalMap
import com.domain.model.IngredientsVO
import com.domain.model.MealDetailsVO
import com.network.entity.MealsDetailItem
import javax.inject.Inject

class MealDetailsMapper @Inject constructor() : UnidirectionalMap<MealsDetailItem, MealDetailsVO> {
    override fun map(data: MealsDetailItem): MealDetailsVO {
        val ingredientsWithPortionsList = HashMap<String, String>()
        val ingredientList = ArrayList<IngredientsVO>()

        if (isValidData(data.strIngredient1, data.strMeasure1))
            ingredientsWithPortionsList[data.strIngredient1!!] = data.strMeasure1!!

        if (isValidData(data.strIngredient2, data.strMeasure2))
            ingredientsWithPortionsList[data.strIngredient2!!] = data.strMeasure2!!

        if (isValidData(data.strIngredient3, data.strMeasure3))
            ingredientsWithPortionsList[data.strIngredient3!!] = data.strMeasure3!!

        if (isValidData(data.strIngredient4, data.strMeasure4))
            ingredientsWithPortionsList[data.strIngredient4!!] = data.strMeasure4!!

        if (isValidData(data.strIngredient5, data.strMeasure5))
            ingredientsWithPortionsList[data.strIngredient5!!] = data.strMeasure5!!

        if (isValidData(data.strIngredient6, data.strMeasure6))
            ingredientsWithPortionsList[data.strIngredient6!!] = data.strMeasure6!!

        if (isValidData(data.strIngredient7, data.strMeasure7))
            ingredientsWithPortionsList[data.strIngredient7!!] = data.strMeasure7!!

        if (isValidData(data.strIngredient8, data.strMeasure8))
            ingredientsWithPortionsList[data.strIngredient8!!] = data.strMeasure8!!

        if (isValidData(data.strIngredient9, data.strMeasure9))
            ingredientsWithPortionsList[data.strIngredient9!!] = data.strMeasure9!!

        if (isValidData(data.strIngredient10, data.strMeasure10))
            ingredientsWithPortionsList[data.strIngredient10!!] = data.strMeasure10!!

        if (isValidData(data.strIngredient11, data.strMeasure11))
            ingredientsWithPortionsList[data.strIngredient11!!] = data.strMeasure11!!

        if (isValidData(data.strIngredient12, data.strMeasure12))
            ingredientsWithPortionsList[data.strIngredient12!!] = data.strMeasure12!!

        if (isValidData(data.strIngredient13, data.strMeasure13))
            ingredientsWithPortionsList[data.strIngredient13!!] = data.strMeasure13!!

        if (isValidData(data.strIngredient14, data.strMeasure14))
            ingredientsWithPortionsList[data.strIngredient14!!] = data.strMeasure14!!

        if (isValidData(data.strIngredient15, data.strMeasure15))
            ingredientsWithPortionsList[data.strIngredient15!!] = data.strMeasure15!!

        if (isValidData(data.strIngredient16, data.strMeasure16))
            ingredientsWithPortionsList[data.strIngredient16!!] = data.strMeasure16!!

        if (isValidData(data.strIngredient17, data.strMeasure17))
            ingredientsWithPortionsList[data.strIngredient17!!] = data.strMeasure17!!

        if (isValidData(data.strIngredient18, data.strMeasure18))
            ingredientsWithPortionsList[data.strIngredient18!!] = data.strMeasure18!!

        if (isValidData(data.strIngredient19, data.strMeasure19))
            ingredientsWithPortionsList[data.strIngredient19!!] = data.strMeasure19!!

        if (isValidData(data.strIngredient20, data.strMeasure20))
            ingredientsWithPortionsList[data.strIngredient20!!] = data.strMeasure20!!

        for (entry in ingredientsWithPortionsList) {
            val ingredients = IngredientsVO(entry.key, entry.value)
            ingredientList.add(ingredients)
        }



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
            ingredientList = ingredientList,
            tags = data.strTags
        )
    }

    private fun isValidData(ingredient: String?, measure: String?) =
        ingredient != null && measure != null && ingredient != "" && measure != ""

}