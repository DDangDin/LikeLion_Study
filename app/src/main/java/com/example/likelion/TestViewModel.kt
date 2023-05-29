package com.example.likelion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {

    private val _title = mutableStateOf("")
    val title: State<String> = _title
}