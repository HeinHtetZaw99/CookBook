package com.domain.exception

interface GenericErrorMessageFactory {
    fun getErrorMessage(throwable: Throwable): CharSequence
}