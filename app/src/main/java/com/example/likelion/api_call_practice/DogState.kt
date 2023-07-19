package com.example.likelion.api_call_practice

data class DogState(
    val dog: Dog = Dog("", ""),
    val loading: Boolean = false,
    val error: String = ""
)