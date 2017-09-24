package com.example.abook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QnAContentActivity extends AppCompatActivity {
   ArrayList<contents> al = new ArrayList<contents>();
   ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qna_content);

        al.add(new contents("Yangyang","2017.9.21","ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ그냥 핫타임마다 쫄짝열심히 돌려서?^^아참 오늘 각성시켰어"));

        MyAdapter adapter = new MyAdapter(QnAContentActivity.this,R.layout.qna_content_answer,al);
        lv = (ListView)findViewById(R.id.listView_qna_content);
        lv.setAdapter(adapter);

        //Button btn = (Button)findViewById(R.id.btnGoHospital);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QnAContentActivity.this,QnAAddActivity.class);
                startActivity(intent);
            }
        });*/
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        ArrayList<contents> al;
        LayoutInflater inf;

        public MyAdapter(Context context, int layout, ArrayList<contents> al){
            this.context = context;
            this.layout = layout;
            this.al = al;
            this.inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int position) {
            return al.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) convertView = inf.inflate(layout, null);
            TextView tvID = (TextView) convertView.findViewById(R.id.txtDoctorID_qna_content);
            TextView tvDay = (TextView) convertView.findViewById(R.id.txtADay_qna_content);
            TextView tvContent = (TextView) convertView.findViewById(R.id.txtAContent_qna_content);

            contents c = al.get(position);
            tvID.setText(c.id);
            tvDay.setText(c.day);
            tvContent.setText(c.content);

            Button btn = (Button)convertView.findViewById(R.id.btnGoHospital);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QnAContentActivity.this,SampleActivity.class);
                    startActivity(intent);
                }
            });

            return convertView;
        }
    }

    class contents {
        String id ="";
        String day ="";
        String content ="";

        public contents(String id, String day, String content){
            this.id = id;
            this.day = day;
            this.content = content;
        }

        public contents(){}
    }
}
