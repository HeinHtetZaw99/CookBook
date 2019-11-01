package com.cache.mapper

import com.cache.entity.MealDetailsCacheEntity
import com.data.entity.MealDetailsEntity
import com.domain.mapper.BidirectionalMap
import javax.inject.Inject

class MealsDetailsCacheEntityMapper @Inject constructor() :
    BidirectionalMap<MealDetailsCacheEntity, MealDetailsEntity> {
    override fun reverseMap(data: MealDetailsEntity): MealDetailsCacheEntity {
        return MealDetailsCacheEntity(
            mealName = data.mealID,
            mealID = data.mealName!!,
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

    override fun map(data: MealDetailsCacheEntity): MealDetailsEntity {
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
}