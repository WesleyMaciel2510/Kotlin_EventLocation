package com.example.kotlin_portfolio.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kotlin_portfolio.utils.AllEventsItem

/*
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
}*/

class FilteredListViewModel : ViewModel() {
    private val _filteredList = mutableStateOf<List<AllEventsItem>>(emptyList())
    val filteredList: State<List<AllEventsItem>> = _filteredList

    fun updateFilteredList(eventsToShow: List<AllEventsItem>) {
        _filteredList.value = eventsToShow
    }
}