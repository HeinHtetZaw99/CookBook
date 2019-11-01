package com.data.mapper

import com.data.entity.CategoryEntity
import com.domain.mapper.BidirectionalMap
import com.domain.model.CategoryVO
import javax.inject.Inject

class CategoryEntityListMapper @Inject constructor() :
    BidirectionalMap<List<CategoryVO>, List<CategoryEntity>> {
    override fun reverseMap(data: List<CategoryEntity>): List<CategoryVO> {
        val reverseMappedList = ArrayList<CategoryVO>()
        for (entry in data) {
            val categoryVO = CategoryVO(
                categoryName = entry.categoryName,
                categoryThumbnail = entry.categoryThumbnail,
                categoryID = entry.categoryID,
                categoryDescription = entry.categoryDescription
            )
            reverseMappedList.add(categoryVO)
        }
        return reverseMappedList
    }

    override fun map(data: List<CategoryVO>): List<CategoryEntity> {
        val mappedList = ArrayList<CategoryEntity>()
        for (entry in data) {
            val categoryEntity = CategoryEntity(
                categoryName = entry.categoryName,
                categoryThumbnail = entry.categoryThumbnail,
                categoryID = entry.categoryID,
                categoryDescription = entry.categoryDescription
            )
            mappedList.add(categoryEntity)
        }
        return mappedList
    }


}