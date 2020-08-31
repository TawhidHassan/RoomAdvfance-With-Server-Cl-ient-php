package com.example.roomadvancewithserverclient;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    Long insertTask(Student student);

    @Update
    void updateTask(Student student);


    @Delete
    void delete(Student student);

    @Query("select * from student order by rollno asc")
    List<Student> getAll();

}
