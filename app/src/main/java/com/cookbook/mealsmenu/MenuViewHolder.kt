package com.cookbook.mealsmenu

import android.view.View
import com.appbase.recyclerview.BaseViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cookbook.databinding.CardviewMenuBinding
import com.domain.model.MealSnapshotVO

class MenuViewHolder(
    private val binding: CardviewMenuBinding,
    private val delegate: MenuAdapter.MenuDelegate
) :
    BaseViewHolder<MealSnapshotVO>(binding.root) {
    lateinit var mealData: MealSnapshotVO

    override fun setData(mData: MealSnapshotVO) {
        binding.menuData = mData
        mealData = mData
        Glide.with(binding.menuImageView)
            .load(mData.mealThumbnail)
            .apply(RequestOptions.centerCropTransform())
            .into(binding.menuImageView)
        binding.menuImageView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        delegate.goToMealsDetails(mealData.mealID.toString())
    }

}