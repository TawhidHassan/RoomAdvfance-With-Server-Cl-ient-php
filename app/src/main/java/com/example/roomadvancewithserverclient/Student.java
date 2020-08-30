package com.example.roomadvancewithserverclient;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey
    public int rollno;

    @ColumnInfo(name = "student_name")
    public String student_name;

    @ColumnInfo(name = "contanctno")
    public String contanctno;

    @ColumnInfo(name = "gender")
    public String gender;

    public Student(int rollno, String student_name, String contanctno, String gender) {
        this.rollno = rollno;
        this.student_name = student_name;
        this.contanctno = contanctno;
        this.gender = gender;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getContanctno() {
        return contanctno;
    }

    public void setContanctno(String contanctno) {
        this.contanctno = contanctno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
