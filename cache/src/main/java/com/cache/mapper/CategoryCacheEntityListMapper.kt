package com.cache.mapper

import com.cache.entity.CategoryCacheEntity
import com.data.entity.CategoryEntity
import com.domain.mapper.BidirectionalMap
import javax.inject.Inject

class CategoryCacheEntityListMapper @Inject constructor() :
    BidirectionalMap<List<CategoryCacheEntity>, List<CategoryEntity>> {
    override fun map(data: List<CategoryCacheEntity>): List<CategoryEntity> {
        val reverseMappedList = ArrayList<CategoryEntity>()
        for (entry in data) {
            val categoryEntity = CategoryEntity(
                categoryName = entry.categoryName,
                categoryThumbnail = entry.categoryThumbnail,
                categoryID = entry.categoryID,
                categoryDescription = entry.categoryDescription
            )
            reverseMappedList.add(categoryEntity)
        }
        return reverseMappedList
    }

    override fun reverseMap(data: List<CategoryEntity>): List<CategoryCacheEntity> {
        val mappedList = ArrayList<CategoryCacheEntity>()
        for (entry in data) {
            val categoryEntity = CategoryCacheEntity(
                categoryName = entry.categoryName,
                categoryThumbnail = entry.categoryThumbnail,
                categoryID = entry.categoryID!!,
                categoryDescription = entry.categoryDescription
            )
            mappedList.add(categoryEntity)
        }
        return mappedList
    }


}