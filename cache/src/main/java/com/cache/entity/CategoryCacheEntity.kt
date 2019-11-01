package com.cache.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryCacheEntity(
    var categoryName: String? = null,

    var categoryDescription: String? = null,

    @PrimaryKey
    @NonNull
    var categoryID: String = "",

    var categoryThumbnail: String? = null
)