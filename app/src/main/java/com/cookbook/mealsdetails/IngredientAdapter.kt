package com.cookbook.mealsdetails

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appbase.recyclerview.BaseRecyclerAdapter
import com.cookbook.R
import com.domain.model.IngredientsVO

class IngredientAdapter(context: Context) :
    BaseRecyclerAdapter<IngredientsVO, IngredientViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
        IngredientViewHolder(
            DataBindingUtil.inflate(
                mLayoutInflator,
                R.layout.cardview_ingredients,
                parent,
                false
            )
        )

}