package com.example.roomadvancewithserverclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button insertBtn, viewBtn,btnSync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertBtn=findViewById(R.id.inserbtnId);
        viewBtn=findViewById(R.id.viewbtnId);
        btnSync=findViewById(R.id.btnSyncId);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,InsertActivity.class);
                startActivity(intent);
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ViewActivity.class);
                startActivity(intent);
            }
        });
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sync_students sync_students=new Sync_students(MainActivity.this);
            }
        });


        StudentRepository studentRepository=new StudentRepository(getApplicationContext());
    }
}