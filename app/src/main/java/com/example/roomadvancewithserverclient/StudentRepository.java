package com.example.roomadvancewithserverclient;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

public class StudentRepository {
    private String DB_NAME="student_db";
    StudentDatabase studentDatabase;
    Context context;

    public StudentRepository(Context context) {
        this.context = context;
        studentDatabase= Room.databaseBuilder(context,StudentDatabase.class,DB_NAME).build();
        Toast.makeText(context, "Your dataBAse ready", Toast.LENGTH_SHORT).show();
    }
}
