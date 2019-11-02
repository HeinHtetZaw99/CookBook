package com.cookbook.mealsdetails

import com.appbase.recyclerview.BaseViewHolder
import com.appbase.show
import com.appbase.showLogE
import com.cookbook.databinding.CardviewIngredientsBinding
import com.domain.model.IngredientsVO

class IngredientViewHolder(private val binding: CardviewIngredientsBinding) :
    BaseViewHolder<IngredientsVO>(binding.root) {

    override fun setData(mData: IngredientsVO) {
        binding.ingredientData = mData
        showLogE(
            "Images", mData
                .getThumbnailPic()
        )
        binding.menuImageView.show(mData.getThumbnailPic())
    }

}