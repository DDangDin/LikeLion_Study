package com.example.likelion.api_call_practice

data class DogState(
    val dog: Dog = Dog("", ""),
    val loading: Boolean = true,
    val error: String = ""
)