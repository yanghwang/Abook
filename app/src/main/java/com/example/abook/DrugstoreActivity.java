package com.example.abook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.abook.R.id.txtDrugstoreName_search;
import static com.example.abook.R.id.txtMedicine_search;

public class DrugstoreActivity extends AppCompatActivity {
    ArrayList<drugstore_search> arrayList = new ArrayList<drugstore_search>();
    ListView listView;
    InputMethodManager inputMethodManager;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugstore);

        editText = (EditText)findViewById(R.id.edtSearch_drugstore);
        inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        arrayList.add(new drugstore_search("약국이름1","약1"));
        arrayList.add(new drugstore_search("약국이름2","약2"));

        MyAdapter adapter = new MyAdapter(this,R.layout.drugstore_search,arrayList);
        listView = (ListView)findViewById(R.id.listView_drugstore_search);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrugstoreActivity.this,DrugstoreInformationActivity.class);
                startActivity(intent);
            }
        });
    }
    public void linearOnClick(View v){
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        ArrayList<drugstore_search> arrayList;
        LayoutInflater inflater;

        public MyAdapter(Context context, int layout, ArrayList<drugstore_search> arrayList){
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
            TextView tvDrugstoreName = (TextView) convertView.findViewById(txtDrugstoreName_search);
            TextView tvMedicine = (TextView) convertView.findViewById(txtMedicine_search);

            drugstore_search d = arrayList.get(position);
            tvDrugstoreName.setText(d.name);
            tvMedicine.setText(d.list);

            return convertView;
        }
    }

    class drugstore_search {
        String name="";
        String list="";

        public drugstore_search(String name, String list){
            this.list = list;
            this.name = name;
        }
        public drugstore_search(){}
    }

}
