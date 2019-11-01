package com.appbase.exception

import android.content.Context
import com.appbase.R
import com.domain.exception.GenericErrorMessageFactory
import com.network.exception.NetworkException
import com.network.exception.NetworkExceptionMessageFactory
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class GenericErrorMessageFactoryImpl @Inject constructor(
    private val context: Context,
    private val networkExceptionMessageFactory: NetworkExceptionMessageFactory
) : GenericErrorMessageFactory {
    override fun getErrorMessage(throwable: Throwable): CharSequence {
        return when (throwable) {
            is UnknownHostException -> networkExceptionMessageFactory.getErrorMessage(throwable)
            is SocketTimeoutException -> networkExceptionMessageFactory.getErrorMessage(throwable)
            is ConnectException -> networkExceptionMessageFactory.getErrorMessage(throwable)
            is NetworkException -> networkExceptionMessageFactory.getErrorMessage(throwable)
            else -> {
                throwable.message ?: context.getString(R.string.error_generic)
            }

        }
    }
}