package com.data.datasource.network

import com.domain.model.CategoryVO

interface CategoryNetworkDataSource {
    fun getMealsCategory(): List<CategoryVO>
}