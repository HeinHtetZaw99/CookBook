package com.data.datasource.cache

import com.data.entity.CategoryEntity

interface CategoryCacheDataSource {
    fun putCategoryList(categoryList: List<CategoryEntity>)
    fun getCategoryList(): List<CategoryEntity>?
    fun clear()
}