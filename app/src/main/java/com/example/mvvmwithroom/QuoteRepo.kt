package com.example.mvvmwithroom

import androidx.lifecycle.LiveData
import com.example.mvvmwithroom.data.local.db.Quote
import com.example.mvvmwithroom.data.local.db.QuoteDao

class QuoteRepo(private val dao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>> {
        return dao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote) {

        dao.insertQuote(quote)
    }

}