package com.cookbook.mealsmenu

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.appbase.recyclerview.BaseRecyclerAdapter
import com.cookbook.R
import com.domain.model.MealSnapshotVO

class MenuAdapter(private val context: Context) :
    BaseRecyclerAdapter<MealSnapshotVO, MenuViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
       val delegate = context as MenuDelegate
       return MenuViewHolder(
            DataBindingUtil.inflate(
                mLayoutInflator,
                R.layout.cardview_menu, parent, false
            ),delegate
        )
    }

    interface MenuDelegate {
        fun goToMealsDetails(id: String)
    }
}