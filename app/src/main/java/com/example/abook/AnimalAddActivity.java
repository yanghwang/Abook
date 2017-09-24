package com.example.abook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by 김성질 on 2017-09-06.
 */

public class AnimalAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_add);

        Spinner spinnerYear = (Spinner)findViewById(R.id.yearSpinner);
        ArrayAdapter<CharSequence> arrayYear = ArrayAdapter.createFromResource(this,R.array.year, R.layout.support_simple_spinner_dropdown_item);
        spinnerYear.setAdapter(arrayYear);

        Spinner spinnerMonth = (Spinner)findViewById(R.id.monthSpinner);
        ArrayAdapter<CharSequence> arrayMonth = ArrayAdapter.createFromResource(this,R.array.month, R.layout.support_simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(arrayMonth);

        Spinner spinnerDay = (Spinner)findViewById(R.id.daySpinner);
        ArrayAdapter<CharSequence> arrayDay = ArrayAdapter.createFromResource(this,R.array.day, R.layout.support_simple_spinner_dropdown_item);
        spinnerDay.setAdapter(arrayDay);

        Button btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.9), (int)(height*0.72));
    }
}
