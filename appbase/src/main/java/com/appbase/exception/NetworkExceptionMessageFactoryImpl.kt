package com.appbase.exception

import android.content.Context
import com.appbase.R
import com.appbase.showLogE
import com.network.exception.NetworkException
import com.network.exception.NetworkExceptionMessageFactory
import okhttp3.ResponseBody
import org.json.JSONObject
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class NetworkExceptionMessageFactoryImpl @Inject constructor(
    private val context: Context
) : NetworkExceptionMessageFactory {
    override fun getErrorMessage(networkException: NetworkException): CharSequence {
        when (networkException.errorCode) {
            400 -> return parseMessageFromErrorBody(networkException.errorBody)
            401 -> return parseMessageFromErrorBody(networkException.errorBody)
            422 -> return parseMessageFromErrorBody(networkException.errorBody)
            403 -> return parseMessageFromErrorBody(networkException.errorBody)
            404 -> return context.getString(R.string.error_server_404)
            500 -> return context.getString(R.string.error_server_500)
        }

        return context.getString(R.string.error_generic)
    }

    private fun parseMessageFromErrorBody(errorBody: ResponseBody?): CharSequence {

        if (errorBody == null) {
            return context.getString(R.string.error_generic)
        }

        val errorBodyInString = errorBody.string()
        this.javaClass.showLogE("error body in string : $errorBodyInString")

        try {
            val errorBodyJson = JSONObject(errorBodyInString)

            return errorBodyJson.getString("message")
        } catch (exception: Exception) {
            this.javaClass.showLogE("Error in parsing error message body ${exception.message}")
        }

        return context.getString(R.string.error_generic)
    }

    override fun getErrorMessage(unknownHostException: UnknownHostException): CharSequence {
        return context.getString(R.string.error_no_internet)
    }

    override fun getErrorMessage(socketTimeoutException: SocketTimeoutException): CharSequence {
        return context.getString(R.string.error_socket_timeout)
    }

    override fun getErrorMessage(connectException: ConnectException): CharSequence {
        return context.getString(R.string.error_no_internet)
    }


}