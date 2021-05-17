package com.app.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*

//made second(after Note class)
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //will ignore if same entry inserted again
    suspend fun insert(note:Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes():LiveData<List<Note>>
}
//suspend -> task done in background thread, so that app does not lag due to these I/O operations
//suspend functions can only be called by other suspend functions
//Livedata means an activity can observe any changes made to Live data in real time