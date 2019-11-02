package com.cookbook.feature

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appbase.recyclerview.BaseRecyclerAdapter
import com.cookbook.R
import com.domain.model.CategoryVO

class CategoryAdapter(context: Context) :
    BaseRecyclerAdapter<CategoryVO, CategoryViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(
        DataBindingUtil.inflate(
            mLayoutInflator,
            R.layout.cardview_category, parent, false
        )
    )

}