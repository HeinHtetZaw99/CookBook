package com.domain.model

data class MealSnapshotVO(
    var mealThumbnail: String? = null,
    var mealID: String? = null,
    var mealName: String? = null,
    var categoryName: String? = null
) {
    override fun toString(): String {
        return "MealSnapshotVO(mealThumbnail=$mealThumbnail, mealID=$mealID, mealName=$mealName, categoryName=$categoryName)"
    }
}