package com.cookbook.di

import androidx.lifecycle.ViewModel
import com.appbase.di.module.BaseAppModule
import com.appbase.di.viewModel.ViewModelKey
import com.cookbook.category.CategoryActivity
import com.cookbook.category.CategoryViewModel
import com.cookbook.mealsdetails.MealsDetailsActivity
import com.cookbook.mealsdetails.MealsDetailsViewModel
import com.cookbook.mealsmenu.MenuActivity
import com.cookbook.mealsmenu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        BaseAppModule::class
//        CategoryFeatureModule::class
    ]
)
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun mainactivity(): CategoryActivity

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun categoryViewModel(
        categoryViewModel: CategoryViewModel
    ): ViewModel


    @ContributesAndroidInjector
    abstract fun menuActivity(): MenuActivity

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun menuViewModel(
        menuViewModel: MenuViewModel
    ): ViewModel


    @ContributesAndroidInjector
    abstract fun mealDetailsActivity(): MealsDetailsActivity

    @Binds
    @IntoMap
    @ViewModelKey(MealsDetailsViewModel::class)
    abstract fun mealDetailsViewModel(
        mealsDetailsViewModel: MealsDetailsViewModel
    ): ViewModel


}