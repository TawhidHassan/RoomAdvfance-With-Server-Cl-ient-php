package com.example.roomadvancewithserverclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Student> studentArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView=findViewById(R.id.my_recView);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       new  LoadDataTask().execute();

    }

    class LoadDataTask extends AsyncTask<Void,Void,Void>
    {
        StudentRepository studentRepository;
        List<Student> studentList;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            studentRepository=new StudentRepository(getApplicationContext());

        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentList=studentRepository.getStudents();
            studentArrayList=new ArrayList<>();

            for (int i=0;i<studentList.size();i++)
            {
                studentArrayList.add(studentList.get(i));
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            CustomAdapter customAdapter=new CustomAdapter(studentArrayList,ViewActivity.this);
            recyclerView.setAdapter(customAdapter);
        }
    }

}