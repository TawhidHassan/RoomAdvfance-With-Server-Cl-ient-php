package com.example.roomadvancewithserverclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button insertBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertBtn=findViewById(R.id.inserbtnId);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,InsertActivity.class);
                startActivity(intent);
            }
        });


        StudentRepository studentRepository=new StudentRepository(getApplicationContext());
    }
}