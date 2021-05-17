package com.app.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

//made sixth(after NoteViewModel)
class MainActivity : AppCompatActivity(), NoteItemClicked {
    lateinit var viewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=NotesRVAdapter(this)
        recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let{
                adapter.updateList(list)
            }
        })
    }

    override fun onIemClicked(item: Note) {
        viewModel.deleteNote(item)
        Toast.makeText(this,"${item.text} deleted",Toast.LENGTH_LONG)
    }

    fun submitData(view: View) {
        val noteText=input.editableText.toString()
        if(noteText.isNotEmpty()){
            viewModel.addNote(Note(noteText))
            Toast.makeText(this,"${noteText} inserted",Toast.LENGTH_LONG)
        }
    }
}