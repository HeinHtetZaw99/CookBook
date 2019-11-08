package com.network.mapper

import com.domain.mapper.UnidirectionalMap
import com.domain.model.MealSnapshotVO
import com.network.entity.MealsItem
import javax.inject.Inject

@Suppress("LABEL_NAME_CLASH")
class MealSnapShotMapper @Inject constructor() :
    UnidirectionalMap<List<MealsItem>, List<MealSnapshotVO>> {
    override fun map(data: List<MealsItem>): List<MealSnapshotVO> {
        return data.map {
            return@map MealSnapshotVO(
                mealID = it.idMeal,
                mealThumbnail = it.strMealThumb,
                mealName = it.strMeal
            )
        }
    }

}