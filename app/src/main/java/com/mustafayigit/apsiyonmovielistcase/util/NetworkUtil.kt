package com.mustafayigit.apsiyonmovielistcase.util

import androidx.annotation.StringRes
import retrofit2.HttpException

enum class ErrorType{
    GENERIC_ERROR
}

sealed class ResponseWrapper<out T : Any> {
    object Loading : ResponseWrapper<Nothing>()
    data class Error(val errorType: ErrorType) : ResponseWrapper<Nothing>()
    data class Success<out T : Any>(val data: T) : ResponseWrapper<T>()
}

suspend fun <T> safeCatch(call: suspend () -> T): T? {
    return runCatching { call.invoke() }
        .fold(
            { it },
            {
                handleException(it as Exception)
                null
            })

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