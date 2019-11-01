package com.cache.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cache.room.typeconverters.HashMapTypeConverter

@Entity(tableName = "meals_details")
data class MealDetailsCacheEntity(
    @PrimaryKey
    @NonNull
    var mealID: String = "",
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

    @TypeConverters(HashMapTypeConverter::class)
    var ingredientsWithMeasurement: HashMap<String, String>? = null
)