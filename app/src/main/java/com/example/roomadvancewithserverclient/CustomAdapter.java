package com.example.roomadvancewithserverclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private ArrayList<Student> dataset;
    Context context;

    public CustomAdapter(ArrayList<Student> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_student,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView tv_rolN0=holder.tv_rolN0;
        TextView tv_name=holder.tv_name;
        TextView tv_contactNo=holder.tv_contactNo;
        ImageView genderImage=holder.genderImage;
        ImageView callImage=holder.callImage;
        Button title_btn=holder.title_btn;

        tv_rolN0.setText(dataset.get(position).rollno+"");
        tv_name.setText(dataset.get(position).student_name);
        tv_contactNo.setText(dataset.get(position).contanctno);

        if (dataset.get(position).gender.equals("male"))
        {
            genderImage.setImageResource(R.drawable.male);
        }else if (dataset.get(position).gender.equals("FeMale"))
        {
            genderImage.setImageResource(R.drawable.female);
        }

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    //////=============my view Holde============////////
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_rolN0,tv_name,tv_contactNo;
        ImageView genderImage,callImage;
        Button title_btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_rolN0=itemView.findViewById(R.id.tv_rollno);
            tv_name=itemView.findViewById(R.id.tv_studentName);
            tv_contactNo=itemView.findViewById(R.id.tv_contectNo);
            genderImage=itemView.findViewById(R.id.img_genderId);
            callImage=itemView.findViewById(R.id.img_call);
            title_btn=itemView.findViewById(R.id.btn_title);

        }
    }

    //////=============my view Holde============////////
}
