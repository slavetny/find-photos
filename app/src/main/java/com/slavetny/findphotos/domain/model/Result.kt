package com.slavetny.findphotos.domain.model

data class Result(
    val alt_description: String,
    val blur_hash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val promoted_at: Any,
    val sponsorship: Any,
    val updated_at: String,
    val urls: UrlsX,
    val width: Int
)