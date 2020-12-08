package com.example.endterm

import com.example.endterm.Model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("posts/")
    fun getPosts(): Call<MutableList<Post>>


    @GET("posts/{id}/")
    fun getPostById(@Path("id") postId: Int): Call<Post>

//    @GET("comments/{id}")
//    fun getComments(@Path("id") postId: Int): Call<Comment>
}