package com.cookbook.di

import com.appbase.di.module.BaseAppModule
import com.cookbook.feature.CategoryFeatureModule
import dagger.Module

@Module(
    includes = [
        BaseAppModule::class,
        CategoryFeatureModule::class
    ]
)
abstract class AppModule {

}