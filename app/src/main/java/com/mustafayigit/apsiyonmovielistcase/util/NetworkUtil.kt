package com.mustafayigit.apsiyonmovielistcase.util

import okio.IOException
import retrofit2.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

enum class ErrorType {
    GENERIC_ERROR,
    NETWORK_ERROR
}

sealed class ResponseWrapper<out T : Any> {
    object Loading : ResponseWrapper<Nothing>()
    data class Error(val errorType: ErrorType) : ResponseWrapper<Nothing>()
    data class Success<out T : Any>(val data: T) : ResponseWrapper<T>()
}

suspend fun <T : Any> safeCatch(call: suspend () -> T): ResponseWrapper<T> {
    return runCatching { call.invoke() }
        .fold(
            { ResponseWrapper.Success(it) },
            {
                handleException(it as Exception)
                ResponseWrapper.Error(getErrorType(it))
            },
        )

}

fun getErrorType(err: Throwable): ErrorType {
    return when (err) {
        is IOException,
        is SocketException,
        is SocketTimeoutException,
        is SecurityException,
        is UnknownHostException -> ErrorType.NETWORK_ERROR
        else -> ErrorType.GENERIC_ERROR
    }
}

fun handleException(e: Exception) {
    val logMessage = when (e) {
        is HttpException -> {
            "Code: ${e.code()} -- Cause: ${e.message}"
        }
        else -> "Cause: ${e.cause} -- Message: ${e.message} -- Detail: ${e.cause?.cause}"
    }

    "handleException --> $logMessage".safeLog()
}