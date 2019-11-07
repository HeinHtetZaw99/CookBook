package com.cookbook.category

import android.view.View
import com.appbase.recyclerview.BaseViewHolder
import com.appbase.show
import com.cookbook.databinding.CardviewCategoryBinding
import com.domain.model.CategoryVO

class CategoryViewHolder(
    private val binding: CardviewCategoryBinding,
    private val delegate: CategoryAdapter.CategoryDelegate
) :

    BaseViewHolder<CategoryVO>(binding.root) {
    lateinit var categoryData: CategoryVO
    override fun setData(mData: CategoryVO) {
        binding.categoryData = mData
        categoryData = mData
        binding.categoryImageView.show(mData.categoryThumbnail!!)
//        binding.overLayLayout.setOnClickListener(this)
        binding.categoryImageView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        delegate.goToMenu(categoryData.categoryName.toString())
    }
}
