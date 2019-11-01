package com.data.mapper

import com.data.entity.MealDetailsEntity
import com.domain.mapper.BidirectionalMap
import com.domain.model.MealDetailsVO
import javax.inject.Inject

class MealsDetailsEntityMapper @Inject constructor() :
    BidirectionalMap<MealDetailsVO, MealDetailsEntity> {
    override fun map(data: MealDetailsVO): MealDetailsEntity {
        return MealDetailsEntity(
            mealName = data.mealID,
            mealID = data.mealName,
            mealThumbnail = data.mealThumbnail,
            dateModified = data.dateModified,
            drinkAlternate = data.drinkAlternate,
            instructions = data.instructions,
            area = data.area,
            youtubeLink = data.youtubeLink,
            source = data.source,
            ingredientsWithMeasurement = data.ingredientsWithMeasurement,
            tags = data.tags
        )
    }

    override fun reverseMap(data: MealDetailsEntity): MealDetailsVO {
        return MealDetailsVO(
            mealName = data.mealID,
            mealID = data.mealName,
            mealThumbnail = data.mealThumbnail,
            dateModified = data.dateModified,
            drinkAlternate = data.drinkAlternate,
            instructions = data.instructions,
            area = data.area,
            youtubeLink = data.youtubeLink,
            source = data.source,
            ingredientsWithMeasurement = data.ingredientsWithMeasurement,
            tags = data.tags
        )
    }
}