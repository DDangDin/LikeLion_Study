package com.example.likelion.api_call_practice

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException

class DogViewModel: ViewModel() {

    private val _state = mutableStateOf(DogState())
    val state: State<DogState> = _state

    init {
        getDogImage()
    }

    fun getDogImage() {
        viewModelScope.launch {
            try {
                _state.value = DogState(
                    loading = true
                )
                val dog = Constants.dogApi.getDogImage()
                _state.value = DogState(
                    dog = Dog(dog.message, dog.status),
                    loading = false
                )
                Log.d("DogViewModel_Log", dog.message)
            } catch (e: IOException) {
                _state.value = DogState(
                    error = e.localizedMessage ?: "Internet ERROR",
                    loading = false
                )
                Log.d("DogViewModel_Log", e.localizedMessage)
            }
        }
    }
}