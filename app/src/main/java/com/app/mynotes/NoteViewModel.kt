package com.app.mynotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//made fifth(after NoteRepository)
class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val repository:NoteRepository
    val allNotes:LiveData<List<Note>>
    init {
        val dao=NoteDatabase.getDatabase(application).getNoteDao()
        repository=NoteRepository(dao)
        allNotes=repository.allNotes
    }
    fun deleteNote(note:Note){
        viewModelScope.launch (Dispatchers.IO){//used coroutines to call suspend function
            repository.delete(note)
        }
    }
    fun addNote(note:Note){
        viewModelScope.launch(Dispatchers.IO) {
          repository.insert(note)
        }
    }
    //We have added addNote and deleteNote cause we have to access these in MainActivity, as it only talks with NoteViewModel 
}