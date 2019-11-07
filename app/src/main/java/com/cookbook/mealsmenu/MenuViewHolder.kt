package com.cookbook.mealsmenu

import android.view.View
import com.appbase.recyclerview.BaseViewHolder
import com.appbase.show
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
        binding.menuImageView.show(mData.mealThumbnail!!)
        binding.menuImageView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        delegate.goToMealsDetails(mealData.mealID.toString())
    }

}