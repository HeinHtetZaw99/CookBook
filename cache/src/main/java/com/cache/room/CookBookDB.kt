package com.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cache.entity.CategoryCacheEntity
import com.cache.entity.MealDetailsCacheEntity
import com.cache.entity.MealSnapshotCacheEntity
import com.cache.room.daos.CategoryDAO
import com.cache.room.daos.MealDetailsDAO
import com.cache.room.daos.MealSnapShotsDAO
import com.cache.room.typeconverters.HashMapTypeConverter

@Database(entities = [CategoryCacheEntity::class, MealDetailsCacheEntity::class, MealSnapshotCacheEntity::class], version = 1 , exportSchema = false)
@TypeConverters(HashMapTypeConverter::class)
abstract class CookBookDB : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO
    abstract fun mealsDetailsDAO(): MealDetailsDAO
    abstract fun mealsSnapshotDAO(): MealSnapShotsDAO

}