package com.guanwh.swdevdemo.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoListDao {
    @Query("SELECT * FROM TodoList")
    List<TodoList> loadAll();
    @Query("SELECT ifnull(MAX(id),0) FROM todolist")
    Long getMaxId();
    @Update
    void update(TodoList todoList);
    @Insert
    void insertAll(TodoList... todoLists);
    @Delete
    void delete(TodoList todoList);
}
