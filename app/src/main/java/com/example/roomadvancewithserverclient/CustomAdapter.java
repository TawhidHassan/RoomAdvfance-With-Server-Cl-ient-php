package com.example.roomadvancewithserverclient;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.JetPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        TextView tv_rolN0=holder.tv_rolN0;
        TextView tv_name=holder.tv_name;
        TextView tv_contactNo=holder.tv_contactNo;
        ImageView genderImage=holder.genderImage;
        ImageView callImage=holder.callImage;
        Button title_btn=holder.title_btn;
        LinearLayout studen_card=holder.card_student;

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
        ////==============logic for title==============///
        title_btn.setText(dataset.get(position).student_name.toUpperCase().charAt(0)+"");
        //random color logic
        Random random=new Random();
        int red=random.nextInt(255);
        int green=random.nextInt(255);
        int blue=random.nextInt(255);

        title_btn.setBackgroundColor(Color.rgb(red,green,blue));

        ////==============logic for title==============///

        ///========set logic for when click on call icon got to phone call=======================///////////////////////
        if (dataset.get(position).contanctno.length()>10){
            callImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+dataset.get(position).contanctno));
                    context.startActivity(intent);
                }
            });
        }else
        {
            Toast.makeText(context, "Number is invalide", Toast.LENGTH_SHORT).show();
        }

        studen_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rollNo=dataset.get(position).rollno;
                String studenName=dataset.get(position).student_name;
                String contact=dataset.get(position).contanctno;
                String gender=dataset.get(position).gender;
//                Toast.makeText(context, rollNo+"", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,StudentDetailsActivity.class);
                intent.putExtra("rollNo",rollNo);
                intent.putExtra("studen_name",studenName);
                intent.putExtra("contactNo",contact);
                intent.putExtra("gender",gender);
                context.startActivity(intent);
            }
        });
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
        LinearLayout card_student;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_rolN0=itemView.findViewById(R.id.tv_rollno);
            tv_name=itemView.findViewById(R.id.tv_studentName);
            tv_contactNo=itemView.findViewById(R.id.tv_contectNo);
            genderImage=itemView.findViewById(R.id.img_genderId);
            callImage=itemView.findViewById(R.id.img_call);
            title_btn=itemView.findViewById(R.id.btn_title);
            card_student=itemView.findViewById(R.id.card_studentId);

        }
    }

    //////=============my view Holde============////////
}
