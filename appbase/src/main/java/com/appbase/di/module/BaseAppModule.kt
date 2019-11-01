package com.appbase.di.module

import android.app.Application
import com.appbase.UIThread
import com.appbase.di.viewModel.ViewModelFactoryModule
import com.appbase.exception.GenericErrorMessageFactoryImpl
import com.appbase.exception.NetworkExceptionMessageFactoryImpl
import com.data.JobExecutor
import com.domain.exception.GenericErrorMessageFactory
import com.domain.executor.PostExecutionThread
import com.domain.executor.ThreadExecutor
import com.network.exception.NetworkExceptionMessageFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [BaseAppModule.Provider::class, ViewModelFactoryModule::class, RepositoryModule::class])
abstract class BaseAppModule {

    @Binds
    abstract fun threadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    abstract fun postExecutionThread(uiThread: UIThread): PostExecutionThread

    @Binds
    abstract fun genericErrorMessageFactory(genericErrorMessageFactory: GenericErrorMessageFactoryImpl): GenericErrorMessageFactory

    @Binds
    abstract fun networkErrorMessageFactory(networkExceptionMessageFactory: NetworkExceptionMessageFactoryImpl): NetworkExceptionMessageFactory

    @Module
    object Provider {
        @Provides
        @JvmStatic
        @Singleton
        fun providesContext(application: Application) = application.applicationContext
    }

}