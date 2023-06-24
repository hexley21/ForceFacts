package org.hxl.cache.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object RoomDBFactory {
    fun <T: RoomDatabase> createRoomInstance(context: Context, clazz: Class<T>, dbName: String): T {
        return Room.databaseBuilder(
            context,
            clazz,
            dbName
        ).build()
    }
}