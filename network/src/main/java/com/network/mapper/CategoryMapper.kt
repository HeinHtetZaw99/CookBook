package com.network.mapper

import com.domain.mapper.UnidirectionalMap
import com.domain.model.CategoryVO
import com.network.entity.CategoriesItem
import javax.inject.Inject

class CategoryMapper @Inject constructor() :
    UnidirectionalMap<List<CategoriesItem>, List<CategoryVO>> {
    override fun map(data: List<CategoriesItem>): List<CategoryVO> {
        val categoryList = ArrayList<CategoryVO>()

        for (categoryItem in data) {
            val categoryData = CategoryVO(
                categoryName = categoryItem.strCategory,
                categoryID = categoryItem.idCategory,
                categoryDescription = categoryItem.strCategoryDescription,
                categoryThumbnail = categoryItem.strCategoryThumb
            )
            categoryList.add(categoryData)
        }
        return categoryList
    }

}