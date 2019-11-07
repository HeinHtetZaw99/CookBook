package com.cookbook.mealsmenu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.appbase.BaseActivity
import com.appbase.ErrorVO
import com.appbase.components.EmptyLoadingViewPod
import com.cookbook.R
import com.cookbook.mealsdetails.MealsDetailsActivity
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : BaseActivity<MenuViewModel>(), EmptyLoadingViewPod.OnRefreshListener,
    MenuAdapter.MenuDelegate {
    override fun goToMealsDetails(id: String) {
        startActivity(MealsDetailsActivity.newIntent(this, id))
    }

    override fun onRefreshButtonClicked() {
        fetchDataFromNetwork(menuRv, emptyLoadingViewPod)
    }

    override val layoutResId: Int
        get() = R.layout.activity_menu

    override val viewModel: MenuViewModel by contractedViewModels()

    private val mAdapter: MenuAdapter by lazy { MenuAdapter(this) }
    lateinit var emptyLoadingViewPod: EmptyLoadingViewPod

    override fun loadData() {
        val categoryID = intent.getStringExtra(CATEGORY_ID)
        if (categoryID != null && categoryID != "")
            viewModel.getCategoryListData(categoryID)
        else
            onError()
    }

    override fun onError() {
        showSnackBar(menuRv, ErrorVO("NO Data To Display", ErrorVO.TYPE.ERROR), "OK")
        emptyLoadingViewPod.setCurrentState(EmptyLoadingViewPod.EmptyViewState.UNEXPECTED_ERROR)
    }

    override fun retry() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        emptyLoadingViewPod = emptyViewPod as EmptyLoadingViewPod
        menuRv.adapter = mAdapter
        menuRv.layoutManager = GridLayoutManager(this, 2)
        menuRv.setEmptyView(emptyLoadingViewPod)
        emptyLoadingViewPod.setOnRefreshListener(this)

        onRefreshButtonClicked()

        viewModel.menuLD.observe(this, Observer {
            mAdapter.appendNewData(it)
        })

        viewModel.menuErrorLD.observe(this, Observer {
            showSnackBar(menuRv, it, "OK")

            if (it.errorType == ErrorVO.TYPE.ERROR)
                onError()
        })

    }

    companion object {
        private const val CATEGORY_ID = "CATEGORY_ID"
        fun newIntent(context: Context, categoryID: String) =
            Intent(context, MenuActivity::class.java).putExtra(
                CATEGORY_ID, categoryID
            )
    }
}
