package com.domain.repository

import com.domain.model.CategoryVO
import io.reactivex.Single

interface CategoryRepository {
    fun getMealCategory(): Single<List<CategoryVO>>
}