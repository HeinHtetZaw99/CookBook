package com.cookbook.feature

import com.appbase.recyclerview.BaseViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cookbook.databinding.CardviewCategoryBinding
import com.domain.model.CategoryVO

class CategoryViewHolder(private val binding: CardviewCategoryBinding) :
    BaseViewHolder<CategoryVO>(binding.root) {
    override fun setData(mData: CategoryVO) {
        binding.categoryData = mData
        Glide.with(binding.categoryImageView)
            .load(mData.categoryThumbnail)
            .apply(RequestOptions.centerCropTransform())
            .into(binding.categoryImageView)
    }

}
