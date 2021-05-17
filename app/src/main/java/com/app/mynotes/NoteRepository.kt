package com.app.mynotes

import androidx.lifecycle.LiveData

//made fourth(after NoteDatabase)
class NoteRepository(private val noteDao:NoteDao){
    val allNotes:LiveData<List<Note>> = noteDao.getAllNotes()
    suspend fun insert(note:Note){
        noteDao.insert(note)
    }
    suspend fun delete(note:Note){
        noteDao.delete(note)
    }
}