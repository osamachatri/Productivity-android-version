package com.oussama_chatri.productivity.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oussama_chatri.productivity.features.notes.data.local.NoteDao
import com.oussama_chatri.productivity.features.notes.data.local.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class LocatDataBase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        @Volatile
        private var INSTANCE: LocatDataBase? = null

        fun getInstance(context: Context): LocatDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocatDataBase::class.java,
                    "productivity_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}