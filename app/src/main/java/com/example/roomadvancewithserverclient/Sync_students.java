package com.example.roomadvancewithserverclient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class Sync_students {



    InputStream is=null;
    JSONObject jobj=null;
    static  String json="";
    JSONObject getobject=null;


    String  current_ip="", url_get_student_all="";
    Context ctx;

    public Sync_students(Context ctx) {
        this.ctx=ctx;
        current_ip=ctx.getResources().getString(R.string.current_ip);
        url_get_student_all=ctx.getResources().getString(R.string.ws_get_all_students);

        new ParseSyncStudent().execute();
    }


    class ParseSyncStudent extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            make_url_request();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            parse(json);
//            Toast.makeText(ctx, json+"", Toast.LENGTH_SHORT).show();
        }
    }

    void make_url_request()
    {
        try
        {
            String url="http://"+current_ip+url_get_student_all;
            Log.d("url=====>",url+"");
            HttpHandler httpHandler=new HttpHandler();
            json=httpHandler.makeServiceCall(url);
        }catch (Exception e)
        {
            e.printStackTrace();
            Log.e("error",e+"");
        }
    }

    public void parse(String refjson)
    {
        String stringjson=refjson;

        try {
            jobj=new JSONObject(stringjson);
            JSONArray jsonArray=jobj.getJSONArray("data");
            if (jsonArray.length()>0)
            {
                for (int i=0;i<jsonArray.length();i++)
                {
                    String rollno=jsonArray.getJSONObject(i).getString("rollno");
                    String student_name=jsonArray.getJSONObject(i).getString("student_name");
                    String contanctno=jsonArray.getJSONObject(i).getString("contanctno");
                    String gender=jsonArray.getJSONObject(i).getString("gender");
                    Toast.makeText(ctx, gender+" "+student_name+" "+contanctno, Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
