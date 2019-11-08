package com.cookbook.mealsmenu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appbase.recyclerview.BaseRecyclerAdapter
import com.cookbook.R
import com.domain.model.MealSnapshotVO

class MenuAdapter(private val context: Context) :
    BaseRecyclerAdapter<MealSnapshotVO, MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
       val delegate = context as MenuDelegate
        val layoutInflater = LayoutInflater.from(context)
       return MenuViewHolder(
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.cardview_menu, parent, false
            ),delegate
        )
    }

    interface MenuDelegate {
        fun goToMealsDetails(adapterPosition: Int)
    }
}