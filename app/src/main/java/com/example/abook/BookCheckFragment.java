package com.example.abook;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.abook.R.id.dayTextView;
import static com.example.abook.R.id.timeTextView;
import static com.example.abook.R.layout.fragment_book_check;


public class BookCheckFragment extends Fragment {

    ArrayList<books> al = new ArrayList<books>();
    ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView_Bookcheck = (ViewGroup)inflater.inflate(fragment_book_check,container,false);

        al.add(new books(R.drawable.dog6,"슈나우저","(미용)","명전동물병원","2017.5.17","15:00"));
        al.add(new books(R.drawable.dog10,"비글","(미용)","명전동물병원","2017.5.18","16:00"));
        al.add(new books(R.drawable.dog1,"비숑","(진료)","명전동물병원","2017.5.19","8:00"));
        al.add(new books(R.drawable.dog5,"휘핏","(진료)","명전동물병원","2017.5.20","11:00"));
        al.add(new books(R.drawable.dog11,"푸들","(미용)","명전동물병원","2017.5.21","13:00"));
        al.add(new books(R.drawable.dog2,"포메라니안","(미용)","명전동물병원","2017.5.22","14:00"));

        MyAdapter adapter = new MyAdapter(rootView_Bookcheck.getContext(),R.layout.book,al);
        lv = (ListView) rootView_Bookcheck.findViewById(R.id.listView_bookchk);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int p = position;

                AlertDialog.Builder dlg = new AlertDialog.Builder(rootView_Bookcheck.getContext());
                dlg.setTitle("abook");
                dlg.setMessage("정말 삭제하시겠습니까?");

                //대화상자에 확인 버튼을 클릭한 경우
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(rootView_Bookcheck.getContext(),"삭제되었습니다",Toast.LENGTH_SHORT).show();
                    }
                });

                //대화상자에 취소 버튼을 클릭한 경우
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dlg.show();
                return false;
            }
        });

        return rootView_Bookcheck;
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        ArrayList<books> al;
        LayoutInflater inf;

        public MyAdapter(Context context, int layout, ArrayList<books> al){
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
            ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
            TextView tvName = (TextView) convertView.findViewById(R.id.nameTextView);
            TextView tvType = (TextView) convertView.findViewById(R.id.typeTextView);
            TextView tvHospital = (TextView) convertView.findViewById(R.id.hospitalTextView);
            TextView tvDay = (TextView) convertView.findViewById(dayTextView);
            TextView tvTime = (TextView) convertView.findViewById(timeTextView);

            books b = al.get(position);
            iv.setImageResource(b.img);
            tvName.setText(b.name);
            tvType.setText(b.type);
            tvHospital.setText(b.hospital);
            tvDay.setText(b.day);
            tvTime.setText(b.time);

            return convertView;
        }
    }

    class books {
        int img;
        String name = "";
        String type ="";
        String hospital = "";
        String day = "";
        String time = "";

        public books(int img, String name, String type, String hospital, String day, String time){
            this.img = img;
            this.name = name;
            this.type = type;
            this.hospital = hospital;
            this.day = day;
            this.time = time;
        }

        public books(){}
    }
}
