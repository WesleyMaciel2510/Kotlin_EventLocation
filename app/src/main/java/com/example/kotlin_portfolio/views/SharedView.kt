package com.example.kotlin_portfolio.views

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CodeInfoViewModel : ViewModel() {
    private val _codeInfo = mutableStateOf("")
    val codeInfo = _codeInfo

    fun updateCodeInfo(newCodeInfo: String) {
        _codeInfo.value = newCodeInfo
    }
}