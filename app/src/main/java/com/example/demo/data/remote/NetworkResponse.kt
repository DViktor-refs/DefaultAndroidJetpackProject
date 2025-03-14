package com.example.demo.data.remote

import retrofit2.Response

sealed class NetworkResponse<out T> {
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Error(val message: String, val errorCode: Int? = null) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
}

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResponse<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                NetworkResponse.Success(it)
            } ?: NetworkResponse.Error("Some response error")
        } else {
            NetworkResponse.Error("Network error: ${response.message()}", response.code())
        }
    } catch (e: Exception) {
        NetworkResponse.Error("Exception: ${e.localizedMessage}")
    }
}