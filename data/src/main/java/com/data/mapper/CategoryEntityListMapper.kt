package com.data.mapper

import com.data.entity.CategoryEntity
import com.domain.mapper.BidirectionalMap
import com.domain.model.CategoryVO
import javax.inject.Inject

@Suppress("LABEL_NAME_CLASH")
class CategoryEntityListMapper @Inject constructor() :
    BidirectionalMap<List<CategoryVO>, List<CategoryEntity>> {
    override fun reverseMap(data: List<CategoryEntity>): List<CategoryVO> {
        return data.map {
            return@map CategoryVO(
                categoryName = it.categoryName,
                categoryThumbnail = it.categoryThumbnail,
                categoryID = it.categoryID,
                categoryDescription = it.categoryDescription
            )
        }
    }

    override fun map(data: List<CategoryVO>): List<CategoryEntity> {
        return data.map {
            return@map CategoryEntity(
                categoryName = it.categoryName,
                categoryThumbnail = it.categoryThumbnail,
                categoryID = it.categoryID,
                categoryDescription = it.categoryDescription
            )
        }
    }


}