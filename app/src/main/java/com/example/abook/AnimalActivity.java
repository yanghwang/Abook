package com.example.abook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.abook.R.layout.activity_animal;

public class AnimalActivity extends AppCompatActivity {

    ArrayList<animals> arrayList = new ArrayList<animals>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_animal);

        FloatingActionButton fab_add = (FloatingActionButton)findViewById(R.id.fab_add);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalActivity.this,AnimalAddActivity.class);
                startActivity(intent);
            }
        });

        arrayList.add(new animals(R.drawable.dog1,"비숑"));
        arrayList.add(new animals(R.drawable.dog2,"포메라니안"));
        arrayList.add(new animals(R.drawable.dog4,"퍼그"));
        arrayList.add(new animals(R.drawable.dog9,"시바견"));
        arrayList.add(new animals(R.drawable.dog7,"요크셔테리어"));
        arrayList.add(new animals(R.drawable.dog8,"닥스훈트"));

        MyAdapter adapter = new MyAdapter(this,R.layout.animal,arrayList);
        listView = (ListView)findViewById(R.id.listView_animal);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AnimalActivity.this,AnimalDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    class MyAdapter extends BaseAdapter{
        Context context;
        int layout;
        ArrayList<animals> arrayList;
        LayoutInflater inflater;

        public MyAdapter(Context context, int layout, ArrayList<animals> arrayList){
            this.context = context;
            this.layout = layout;
            this.arrayList = arrayList;
            this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {return arrayList.size();}

        @Override
        public Object getItem(int position) {return arrayList.get(position);}

        @Override
        public long getItemId(int position) {return position;}

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) convertView = inflater.inflate(layout, null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView tvAnimalName = (TextView) convertView.findViewById(R.id.tvAnimalName);

            animals a = arrayList.get(position);
            imageView.setImageResource(a.img);
            tvAnimalName.setText(a.name);

            return convertView;
        }
    }

    class animals {
        int img;
        String name ="";

        public animals(int img, String name){
            this.img = img;
            this.name = name;
        }
        public animals(){}
    }
}
