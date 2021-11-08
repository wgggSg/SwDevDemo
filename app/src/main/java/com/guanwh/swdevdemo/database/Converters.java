package com.guanwh.swdevdemo.database;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {
    @TypeConverter
    public Date fromTimestamp(long time){
        return new Date(time);
    }

    @TypeConverter
    public long dataToTimestamp(Date date){
        return date.getTime();
    }
}
