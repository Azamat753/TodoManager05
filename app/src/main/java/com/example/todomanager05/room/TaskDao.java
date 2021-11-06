package com.example.todomanager05.room;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todomanager05.ui.create.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM taskmodel")
    List<TaskModel> getAll();

    @Insert
    void insert(TaskModel taskModel);
}