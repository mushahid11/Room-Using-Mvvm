package com.example.mvvmwithroom.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithroom.QuoteRepo
import com.example.mvvmwithroom.data.local.db.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repo: QuoteRepo) : ViewModel() {

    // live data runs on background thread automatically
    val data = repo.getQuotes()


    fun insertQuote(quote: Quote) {

        viewModelScope.launch {
            repo.insertQuote(quote)
        }

    }


}