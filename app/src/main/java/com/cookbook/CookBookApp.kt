package com.cookbook

import android.app.Activity
import android.app.Application
import com.appbase.di.AppInjector
import com.cookbook.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class CookBookApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector:
            DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        AppInjector.initAutoInjection(this)

    }
}