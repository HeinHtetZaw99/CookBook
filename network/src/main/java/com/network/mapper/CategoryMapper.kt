package com.network.mapper

import com.domain.mapper.UnidirectionalMap
import com.domain.model.CategoryVO
import com.network.entity.CategoriesItem
import javax.inject.Inject

@Suppress("LABEL_NAME_CLASH")
class CategoryMapper @Inject constructor() :
    UnidirectionalMap<List<CategoriesItem>, List<CategoryVO>> {
    override fun map(data: List<CategoriesItem>): List<CategoryVO> {
        return data.map {
            return@map CategoryVO(
                categoryName = it.strCategory,
                categoryID = it.idCategory,
                categoryDescription = it.strCategoryDescription,
                categoryThumbnail = it.strCategoryThumb
            )
        }
    }

}