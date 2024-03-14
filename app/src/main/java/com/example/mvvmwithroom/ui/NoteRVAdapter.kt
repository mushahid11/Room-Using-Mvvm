package com.example.mvvmwithroom.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithroom.R
import com.example.mvvmwithroom.data.local.db.Quote


class NoteRVAdapter() :
    RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    //on below line we are creating a variable for our all notes list.
    private val allNotes = ArrayList<Quote>()

    //on below line we are creating a view holder class.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //on below line we are creating an initializing all our variables which we have added in layout file.
        val noteTV: TextView = itemView.findViewById(R.id.idTVText)
        val dateTV: TextView = itemView.findViewById(R.id.idTVAuthor)
        val deleteIV: TextView = itemView.findViewById(R.id.idIVId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflating our layout file for each item of recycler view.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.note_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //on below line we are setting data to item of recycler view.
        holder.noteTV.text = allNotes[position].text
        holder.dateTV.text = allNotes[position].author
        //on below line we are adding click listner to our delete image view icon.
        holder.deleteIV.text = allNotes[position].id.toString()


    }

    override fun getItemCount(): Int {
        //on below line we are returning our list size.
        return allNotes.size
    }

    fun updateList(newList: List<Quote>) {
        //on below line we are clearing our notes array list/
        allNotes.clear()
        //on below line we are adding a new list to our all notes list.
        allNotes.addAll(newList)
        //on below line we are calling notify data change method to notify our adapter.
        notifyDataSetChanged()
    }


}

