package com.slavetny.findphotos.domain.model

data class Photo(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)