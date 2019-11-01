package com.cookbook.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.appbase.BaseActivity
import com.appbase.components.EmptyLoadingViewPod
import com.cookbook.R
import dagger.android.AndroidInjector
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<CategoryViewModel>(), EmptyLoadingViewPod.OnRefreshListener {
    override fun onRefreshButtonClicked() {
        fetchDataFromNetwork(categoryRv, emptyLoadingViewPod)
    }

    override val layoutResId: Int
        get() = R.layout.activity_main

    lateinit var emptyLoadingViewPod: EmptyLoadingViewPod

    override fun retry() {

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override val viewModel: CategoryViewModel by contractedViewModels()

    override fun loadData() {
        viewModel.getCategoryListData()
    }

    override fun onError() {
        (emptyViewPod as EmptyLoadingViewPod).setCurrentState(EmptyLoadingViewPod.EmptyViewState.UNEXPECTED_ERROR)
    }

    private val mAdapter: CategoryAdapter by lazy { CategoryAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        emptyLoadingViewPod = emptyViewPod as EmptyLoadingViewPod
        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = mAdapter
        (emptyLoadingViewPod).setOnRefreshListener(this)
        categoryRv.setEmptyView(emptyLoadingViewPod)

        onRefreshButtonClicked()

        viewModel.categoryLD.observe(this, Observer {
            mAdapter.appendNewData(it)
        })

        viewModel.categoryErrorLD.observe(this, Observer {
            showSnackBar(categoryRv, it, "OK")
            onError()
        })

    }


}
