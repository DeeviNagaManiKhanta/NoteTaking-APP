package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table") //table
class Note(@ColumnInfo(name="text")val text:String){                     //create column name
    @PrimaryKey(autoGenerate = true )var id:Int=0                       //no need to pass id , it generate automatically

}