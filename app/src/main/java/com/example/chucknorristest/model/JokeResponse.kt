package com.example.chucknorristest.model

data class JokeResponse(
    val type: String,
    val value: JokeItem
)

data class JokeResponseList(
    val type: String,
    val value: List<JokeItem>
)

data class JokeItem(
    val id: Int,
    val joke: String,
    val categories: List<String>
)