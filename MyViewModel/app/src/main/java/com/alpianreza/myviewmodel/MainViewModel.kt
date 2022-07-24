package com.alpianreza.myviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val result = 0

    fun calculate(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }
}