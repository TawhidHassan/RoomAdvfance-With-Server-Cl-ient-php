package com.example.roomadvancewithserverclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText rollNo,name,gender,contacNo;
    RadioButton male,female;
    Button submit;

    String rollNot,namet,gendert="Male",contacnoT;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        rollNo=findViewById(R.id.rollnoId);
        name=findViewById(R.id.namId);
        male=findViewById(R.id.rdbtn_male);
        female=findViewById(R.id.rdbtn_female);
        contacNo=findViewById(R.id.contactnoId);
        submit=findViewById(R.id.submitbtnId);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rollNo.getText().toString().isEmpty()||name.getText().toString().isEmpty()||contacNo.getText().toString().isEmpty())
                {
                    Toast.makeText(InsertActivity.this, "please fill all details", Toast.LENGTH_SHORT).show();
                }else {
                    rollNot=rollNo.getText().toString().trim();
                    namet=name.getText().toString();
                    if (female.isChecked())
                    {
                        gendert="FeMale";
                    }else if (male.isChecked())
                    {
                        gendert="Male";
                    }
                    contacnoT=contacNo.getText().toString();

                    StudentRepository studentRepository=new StudentRepository(getApplicationContext());
                    Student student=new Student(Integer.parseInt(rollNot),namet,contacnoT,gendert);
                    studentRepository.InsertTask(student);

                    rollNo.setText("");
                    name.setText("");
                    contacNo.setText("");
                }
            }
        });

    }
}