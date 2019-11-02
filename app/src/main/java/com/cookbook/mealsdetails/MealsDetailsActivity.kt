package com.cookbook.mealsdetails

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.appbase.BaseActivity
import com.appbase.setVisible
import com.appbase.show
import com.cookbook.R
import com.domain.model.MealDetailsVO
import kotlinx.android.synthetic.main.activity_meals_details.*
import kotlinx.android.synthetic.main.content_meals_details.*

class MealsDetailsActivity : BaseActivity<MealsDetailsViewModel>() {
    override val layoutResId: Int
        get() = R.layout.activity_meals_details

    override val viewModel: MealsDetailsViewModel by contractedViewModels()
    private val mAdapter: IngredientAdapter by lazy { IngredientAdapter(this) }

    override fun loadData() {
        val mealID = intent.getStringExtra(MEAL_ID)
        if (mealID != null && mealID != "")
            viewModel.getMealDetails(mealID)
        else
            onError()
    }

    override fun onError() {

    }

    override fun retry() {
    }


    fun setData(data: MealDetailsVO) {
        mealImageView.show(data.mealThumbnail!!)
        mealNameTv.text = data.mealName
        mealCategoryTv.text = data.category
        mealAreaTv.text = data.area
        mealTagTv.text = data.tags
        mealInstructionTv.text = data.instructions
//        videoView.loadUrl(data.youtubeLink)
        if (data.ingredientList != null)
            mAdapter.appendNewData(data.ingredientList!!)
        else {
            mealIngredientsTitleTv.setVisible(false)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setUpWebSettings() {
        val webSettings = videoView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ingredientsRv.layoutManager = GridLayoutManager(this, 3)
        ingredientsRv.adapter = mAdapter
        setUpWebSettings()

        fetchDataFromNetwork(contentMealDetails, null)

        viewModel.mealDetailsLD.observe(this, androidx.lifecycle.Observer {
            setData(it)
        })

    }

    companion object {
        private const val MEAL_ID = "MEAL_ID"

        fun newIntent(context: Context, mealID: String): Intent =
            Intent(context, MealsDetailsActivity::class.java).putExtra(
                MEAL_ID, mealID
            )
    }
}
