package com.example.roomadvancewithserverclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Student> studentArrayList, studentArrayList_Search;
    EditText searchText;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        searchText = findViewById(R.id.search_id);
        recyclerView = findViewById(R.id.my_recView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String text=charSequence.toString();
                Filter(text);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        new LoadDataTask().execute();




    }

    class LoadDataTask extends AsyncTask<Void, Void, Void> {
        StudentRepository studentRepository;
        List<Student> studentList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            studentRepository = new StudentRepository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentList = studentRepository.getStudents();
            studentArrayList = new ArrayList<>();
            studentArrayList_Search = new ArrayList<>();//for search

            for (int i = 0; i < studentList.size(); i++) {
                studentArrayList.add(studentList.get(i));
                studentArrayList_Search.add(studentList.get(i));//for search
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            customAdapter = new CustomAdapter(studentArrayList, ViewActivity.this);
            recyclerView.setAdapter(customAdapter);
        }
    }
    ////////==========================FILTER METHODS==========================================////////////////////////

    public void Filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        Log.d("filter", charText + "");

        studentArrayList.clear();

        if (charText.length() == 0) {
            studentArrayList.addAll(studentArrayList_Search);
            Log.d("load data", "all");
        } else {
            Log.d("load data", "filtter");
            for (Student student : studentArrayList_Search) {
                if (student.student_name.toLowerCase(Locale.getDefault()).contains(charText)||student.contanctno.toLowerCase(Locale.getDefault()).contains(charText)) {
                    studentArrayList.add(student);
                }
            }

        }
        customAdapter.notifyDataSetChanged();
    }

    ////////==========================FILTER METHODS==========================================////////////////////////


    @Override
    protected void onRestart() {
        super.onRestart();
        new LoadDataTask().execute();
    }
}