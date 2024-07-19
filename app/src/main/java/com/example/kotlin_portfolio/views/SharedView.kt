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

class ItemSelectedViewModel : ViewModel() {
    private val _itemSelected = mutableStateOf("")
    val ItemSelected = _itemSelected

    fun updateCodeInfo(newItemSelected: String) {
        _itemSelected.value = newItemSelected
    }
}