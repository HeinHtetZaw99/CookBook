package com.cookbook.mealsdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appbase.recyclerview.BaseRecyclerAdapter
import com.cookbook.R
import com.domain.model.IngredientsVO

class IngredientAdapter(private val context: Context) :
    BaseRecyclerAdapter<IngredientsVO, IngredientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return IngredientViewHolder(
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.cardview_ingredients,
                parent,
                false
            )
        )
    }

}