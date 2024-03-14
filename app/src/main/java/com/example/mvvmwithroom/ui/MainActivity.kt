package com.example.mvvmwithroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithroom.QuoteRepo
import com.example.mvvmwithroom.R
import com.example.mvvmwithroom.data.local.db.Quote
import com.example.mvvmwithroom.data.local.db.QuoteDao
import com.example.mvvmwithroom.data.local.db.QuoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    lateinit var notesRV: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //on below line we are initializing all our variables.
        notesRV = findViewById(R.id.notesRV)

        val dao = QuoteDatabase.getDatabase(applicationContext).getDao()
        val repo = QuoteRepo(dao)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(repo)
        )[MainViewModel::class.java]


        notesRV.layoutManager = LinearLayoutManager(this)
        val noteRVAdapter = NoteRVAdapter()
        //on below line we are setting adapter to our recycler view.
        notesRV.adapter = noteRVAdapter

        viewModel.data.observe(this, Observer {
            noteRVAdapter.updateList(it)
        })



        viewModel.insertQuote(Quote(0, "Mushahid", "hello"))


    }
}