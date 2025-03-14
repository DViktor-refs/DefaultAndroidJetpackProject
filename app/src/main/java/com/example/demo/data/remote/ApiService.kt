package com.example.demo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String
)

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Response<Post>

    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): Response<List<User>>
}