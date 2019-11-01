package com.network.mapper

import com.domain.mapper.UnidirectionalMap
import com.domain.model.MealSnapshotVO
import com.network.entity.MealsItem
import javax.inject.Inject

class MealSnapShotMapper @Inject constructor() :
    UnidirectionalMap<List<MealsItem>, List<MealSnapshotVO>> {
    override fun map(data: List<MealsItem>): List<MealSnapshotVO> {
        val mappedList = ArrayList<MealSnapshotVO>()

        for (entry in data) {
            val mealSnapshotVO = MealSnapshotVO(
                mealID = entry.idMeal,
                mealThumbnail = entry.strMealThumb,
                mealName = entry.strMeal
            )
            mappedList.add(mealSnapshotVO)
        }
        return mappedList
    }

}