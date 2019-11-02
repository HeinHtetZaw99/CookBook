package com.cookbook.category

import androidx.lifecycle.ViewModel
import com.appbase.di.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class CategoryFeatureModule {

    @ContributesAndroidInjector
    abstract fun mainactivity(): CategoryActivity

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun categoryViewModel(
        categoryViewModel: CategoryViewModel
    ): ViewModel
}