package com.cache.datasource

import com.cache.mapper.CategoryCacheEntityListMapper
import com.cache.room.CookBookDB
import com.data.datasource.cache.CategoryCacheDataSource
import com.data.entity.CategoryEntity
import javax.inject.Inject

class CategoryCacheDataSourceImpl @Inject constructor(
    private val dataBase: CookBookDB,
    private val mapper: CategoryCacheEntityListMapper
) : CategoryCacheDataSource {

    override fun putCategoryList(categoryList: List<CategoryEntity>) {
        dataBase.categoryDAO().bulkInsert(mapper.reverseMap(categoryList))
    }

    override fun getCategoryList(): List<CategoryEntity>? {
        return mapper.map(dataBase.categoryDAO().getAllCategories())
    }

    override fun clear() {
        //not implemented
    }

}