package com.example.mvvmwithroom.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(@PrimaryKey(autoGenerate = true) val id: Int, val author: String, val text: String)
