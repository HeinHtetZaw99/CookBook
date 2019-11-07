package com.cache.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealSnapshotCacheEntity(
    var mealThumbnail: String? = null,

    @PrimaryKey
    @NonNull
    var mealID: String = "",

    var mealCategory: String? = null,

    var mealName: String? = null
)