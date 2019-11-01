package com.cache.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.cache.entity.CategoryCacheEntity

@Dao
interface CategoryDAO : BaseDAO<CategoryCacheEntity> {
    @Query(value = "SELECT * FROM category")
    fun getAllCategories(): List<CategoryCacheEntity>

}