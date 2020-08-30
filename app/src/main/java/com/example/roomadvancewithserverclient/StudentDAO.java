package com.example.roomadvancewithserverclient;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface StudentDAO {

    @Insert
    Long insertTask(Student student);

    @Update
    void updateTask(Student student);


    @Delete

    void delete(Student student);

}
