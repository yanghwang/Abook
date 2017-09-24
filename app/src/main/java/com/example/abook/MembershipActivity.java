package com.example.abook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MembershipActivity extends AppCompatActivity {
    EditText edtID, edtPW, edtPWChk, edtName, edtTel, edtRoad;
    TextView txtPW, btnOK_membership, btnIDChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        edtID = (EditText)findViewById(R.id.editID);
        edtPW = (EditText)findViewById(R.id.editPW);
        edtPWChk = (EditText)findViewById(R.id.editPWCheck);
        edtName = (EditText)findViewById(R.id.editName);
        edtTel = (EditText)findViewById(R.id.editTel);
        edtRoad = (EditText)findViewById(R.id.editRoad);
        txtPW = (TextView)findViewById(R.id.textPW);
        btnIDChk = (TextView)findViewById(R.id.btnIDCheck);
        btnOK_membership = (TextView) findViewById(R.id.btnOK_membership);


        final Spinner spinnerCity = (Spinner)findViewById(R.id.citySpinner);
        ArrayAdapter<CharSequence> arraycityhead = ArrayAdapter.createFromResource(this, R.array.city, R.layout.support_simple_spinner_dropdown_item);
        spinnerCity.setAdapter(arraycityhead);

        final Spinner spinnerGu = (Spinner)findViewById(R.id.guSpinner);
        ArrayAdapter<CharSequence> arrayguhead = ArrayAdapter.createFromResource(this, R.array.gu, R.layout.support_simple_spinner_dropdown_item);
        spinnerGu.setAdapter(arrayguhead);

        edtPWChk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();
                if (!password.equals(edtPW.getText().toString())) {
                    txtPW.setVisibility(View.VISIBLE);
                    txtPW.setText("비밀번호가 일치하지 않습니다.");
                } else {
                    txtPW.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        btnOK_membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
