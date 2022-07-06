package com.alpha.remote.utils

sealed class ApiResponse<out T> {
    data class Success<out Y>(val data: Y): ApiResponse<Y>()
    data class Error(val errorMessage: String?): ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}