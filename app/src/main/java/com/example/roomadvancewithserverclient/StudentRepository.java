package com.example.roomadvancewithserverclient;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
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


    //================InsertTask start====================//

    public void InsertTask(final Student student){

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                studentDatabase.studentDAO().insertTask(student);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, student.student_name+" is inserted", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    //================InsertTask end====================//
}
