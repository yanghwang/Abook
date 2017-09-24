package com.example.abook;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.abook.R.id.dayTextView;
import static com.example.abook.R.id.timeTextView;
import static com.example.abook.R.layout.fragment_animal_detail_beauty;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnimalDetailBeauty.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnimalDetailBeauty#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalDetailBeauty extends Fragment {
    ArrayList<beauty> al = new ArrayList<beauty>();
    ListView lv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AnimalDetailBeauty() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalDetailBeauty.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalDetailBeauty newInstance(String param1, String param2) {
        AnimalDetailBeauty fragment = new AnimalDetailBeauty();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView_beauty = (ViewGroup)inflater.inflate(fragment_animal_detail_beauty,container,false);

        al.add(new beauty("(미용)","명전동물병원","2017.5.17","15:00"));
        al.add(new beauty("(미용)","명전동물병원","2017.5.17","15:00"));


        MyAdapter adapter = new MyAdapter(rootView_beauty.getContext(),R.layout.animal_detail,al);
        lv = (ListView) rootView_beauty.findViewById(R.id.listView_beauty);
        lv.setAdapter(adapter);

        return rootView_beauty;
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        ArrayList<beauty> al;
        LayoutInflater inf;

        public MyAdapter(Context context, int layout, ArrayList<beauty> al){
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
            TextView tvType = (TextView) convertView.findViewById(R.id.typeTextView);
            TextView tvHospital = (TextView) convertView.findViewById(R.id.hospitalTextView);
            TextView tvDay = (TextView) convertView.findViewById(dayTextView);
            TextView tvTime = (TextView) convertView.findViewById(timeTextView);

            beauty b= al.get(position);
            tvType.setText(b.type);
            tvHospital.setText(b.hospital);
            tvDay.setText(b.day);
            tvTime.setText(b.time);

            return convertView;
        }
    }

    class beauty {
        String type ="";
        String hospital = "";
        String day = "";
        String time = "";

        public beauty(String type, String hospital, String day, String time){
            this.type = type;
            this.hospital = hospital;
            this.day = day;
            this.time = time;
        }

        public beauty(){}
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
