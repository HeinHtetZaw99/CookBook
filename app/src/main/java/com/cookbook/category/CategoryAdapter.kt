package com.cookbook.category

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appbase.recyclerview.BaseRecyclerAdapter
import com.cookbook.R
import com.domain.model.CategoryVO

class CategoryAdapter(private val context: Context) :
    BaseRecyclerAdapter<CategoryVO, CategoryViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val delegate = context as CategoryDelegate
        return CategoryViewHolder(
            DataBindingUtil.inflate(
                mLayoutInflator,
                R.layout.cardview_category, parent, false
            )
            , delegate
        )
    }

    interface CategoryDelegate {
        fun goToMenu(categoryName: String)
    }

}