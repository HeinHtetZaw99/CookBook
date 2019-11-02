package com.appbase

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun showLogD(text: String) {
    if (BuildConfig.DEBUG)
        Log.d("APP_TAG", text)
}

fun showLogD(text: String, customTag: String) {
    if (BuildConfig.DEBUG)
        Log.d(customTag, text)
}

fun <T> Class<T>.showLogE(text: String) {
    if (BuildConfig.DEBUG)
        Log.e(this.name, text)
}

fun showLogE(text: String) {
    if (BuildConfig.DEBUG)
        Log.e("APP_TAG", text)
}

fun showLogE(text: String, customTag: String) {
    if (BuildConfig.DEBUG)
        Log.e(customTag, text)
}


fun showLogE(throwable: Throwable) {
    if (BuildConfig.DEBUG)
        Log.e(throwable.javaClass.name, throwable.message.toString())
}

fun <T> Class<T>.showLogE(throwable: Throwable) {
    if (BuildConfig.DEBUG)
        Log.e(
            this.simpleName,
            throwable.javaClass.name + "\t\t\t:\t\t\t" + throwable.message.toString()
        )
}

fun View.setVisible(isVisible: Boolean) {
    if (isVisible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

//Extension Function for showing image
fun ImageView.show(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .apply(RequestOptions.centerCropTransform())
        .into(this)
}

fun Array<View>.setVisible(isVisible: Boolean) {

    val visibility = if (isVisible) {
        android.view.View.VISIBLE
    } else {
        android.view.View.GONE
    }

    this.forEach {
        it.visibility = visibility
    }
}

fun ViewGroup.inflater(): LayoutInflater {
    return LayoutInflater.from(this.context)
}

fun ComponentActivity.showShortToast(message: CharSequence) {
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}

fun ComponentActivity.showShortToast(@StringRes resId: Int) {
    Toast.makeText(applicationContext, resId, Toast.LENGTH_SHORT).show()
}

fun ComponentActivity.showLongToast(message: CharSequence) {
    Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
}

fun ComponentActivity.showLongToast(@StringRes resId: Int) {
    Toast.makeText(applicationContext, resId, Toast.LENGTH_LONG).show()
}

fun Fragment.showShortToast(message: CharSequence) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showShortToast(@StringRes resId: Int) {
    Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()
}

fun Fragment.showLongToast(message: CharSequence) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun Fragment.showLongToast(@StringRes resId: Int) {
    Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
}