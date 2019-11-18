package com.example.kotlinandroid.Post

class Post(
    val author: String,
    val content: String,
    val created: String,
    val createdTime: Int,
//-----------------------------
    val likeMe: Boolean = false,
    val commentMe: Boolean = false,
    val repostMe: Boolean =false,
//-----------------------------
    val numberOfLike:Int = 0,
    val numberOfComment:Int =0,
    val numberOfRepost:Int =0
)