package com.app.mynotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//made first(after MainActivity)
@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "text") val text: String){
    @PrimaryKey(autoGenerate = true) var id=0
}
// we have made a table with primary key id and a column named text
