package com.guanwh.swdevdemo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = {TodoList.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    private static final Object sLock = new Object();

    public abstract TodoListDao todoListDao();

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(
                                context.getApplicationContext(),
                                AppDatabase.class,
                                "todoList.db")
                                .allowMainThreadQueries()
                                .build();
            }
            return INSTANCE;
        }
    }
}
