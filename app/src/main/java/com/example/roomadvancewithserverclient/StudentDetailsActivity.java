package com.example.roomadvancewithserverclient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class StudentDetailsActivity extends AppCompatActivity {
    EditText rollNo,name,contacNo;
    RadioButton male,female;
    Button submit;
    Button deleteBtn;

    int rollNoT;
    String nameT="",genderT="",contacnoT="";

    String rollNo_to_update="",name_to_update="",gender_to_update="",contacno_to_update="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        rollNo=findViewById(R.id.rollnoId);
        name=findViewById(R.id.namId);
        male=findViewById(R.id.rdbtn_male);
        female=findViewById(R.id.rdbtn_female);
        contacNo=findViewById(R.id.contactnoId);
        submit=findViewById(R.id.submitbtnId);
        deleteBtn=findViewById(R.id.deleteBtnId);


        ///===================get data from inten=================================//////////
        Bundle data=getIntent().getExtras();
        if (data!=null){
            rollNoT=data.getInt("rollNo");
            nameT=data.getString("studen_name");
            contacnoT=data.getString("contactNo");
            genderT=data.getString("gender");
        }
        ///===================get data from inten=================================//////////
        rollNo.setText(rollNoT+"");
        name.setText(nameT);
        contacNo.setText(contacnoT);
        if (genderT.equals("male"))
        {
            male.setChecked(true);
        }else  if (genderT.equals("FeMale"))
        {
            female.setChecked(true);
        }
        ///===================get data and set value in edittext=================================//////////

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollNo_to_update=rollNo.getText().toString().trim();
                name_to_update=name.getText().toString();
                if (female.isChecked())
                {
                    gender_to_update="FeMale";
                }else if (male.isChecked())
                {
                    gender_to_update="Male";
                }
                contacno_to_update=contacNo.getText().toString();

                StudentRepository studentRepository=new StudentRepository(getApplicationContext());
                Student student=new Student(Integer.parseInt(rollNo_to_update),name_to_update,contacno_to_update,gender_to_update);
                studentRepository.UpdateTask(student);
                finish();
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollNo_to_update=rollNo.getText().toString().trim();
                name_to_update=name.getText().toString();
                if (female.isChecked())
                {
                    gender_to_update="FeMale";
                }else if (male.isChecked())
                {
                    gender_to_update="Male";
                }
                contacno_to_update=contacNo.getText().toString();


                Student student=new Student(Integer.parseInt(rollNo_to_update),name_to_update,contacno_to_update,gender_to_update);
                genarate_dlete_toDelete(student);
            }
        });
    }

    ///custom dialog
    ///=========================Gernarate aleart dialog for delete==========================////////////////////
    public void genarate_dlete_toDelete(final Student student)
    {
        final  Student student_about_delete=student;

        AlertDialog.Builder builder=new AlertDialog.Builder(StudentDetailsActivity.this,R.style.AppCompactAleartDialogStyle);
        builder.setTitle("Warrning");
        builder.setMessage("Are you ssure to dlete this data "+student_about_delete.student_name );
        builder.setIcon(android.R.drawable.ic_delete);

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StudentRepository studentRepository=new StudentRepository(getApplicationContext());
                studentRepository.DeleteTask(student_about_delete);
                Toast.makeText(StudentDetailsActivity.this, "Data Was Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog deleteDialog =builder.create();
        deleteDialog.show();



    }
    ///=========================Gernarate aleart dialog for delete==========================////////////////////
}