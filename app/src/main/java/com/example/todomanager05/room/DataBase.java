package com.example.todomanager05.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todomanager05.ui.create.TaskModel;

@Database(entities = {TaskModel.class},version = 1)
public abstract class DataBase  extends RoomDatabase {
    public abstract TaskDao taskDao();
}
