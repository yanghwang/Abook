package com.example.abook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.abook.R.layout.fragment_user_information;

public class UserInformationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView_UserInfo = (ViewGroup)inflater.inflate(fragment_user_information,container,false);

        final Button btnEdtProfile = (Button)rootView_UserInfo.findViewById(R.id.btnEdtProfile);
        final Button btnChk = (Button)rootView_UserInfo.findViewById(R.id.btnChk);
        final TextView textID = (TextView)rootView_UserInfo.findViewById(R.id.textID);
        final TextView textName = (TextView)rootView_UserInfo.findViewById(R.id.textName);
        final EditText edtTel = (EditText)rootView_UserInfo.findViewById(R.id.edtTel);
        final EditText editRoad = (EditText)rootView_UserInfo.findViewById(R.id.edtRoad);


        final Spinner spinnerCity = (Spinner)rootView_UserInfo.findViewById(R.id.citySpinner);
        ArrayAdapter<CharSequence> arraycityhead = ArrayAdapter.createFromResource(rootView_UserInfo.getContext(), R.array.city, R.layout.support_simple_spinner_dropdown_item);
        spinnerCity.setAdapter(arraycityhead);

        final Spinner spinnerGu = (Spinner)rootView_UserInfo.findViewById(R.id.guSpinner);
        ArrayAdapter<CharSequence> arrayguhead = ArrayAdapter.createFromResource(rootView_UserInfo.getContext(), R.array.gu, R.layout.support_simple_spinner_dropdown_item);
        spinnerGu.setAdapter(arrayguhead);

        spinnerCity.setEnabled(false); spinnerGu.setEnabled(false);

        btnEdtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEdtProfile.setEnabled(false);
                btnChk.setVisibility(rootView_UserInfo.VISIBLE);
                spinnerCity.setEnabled(true);
                spinnerGu.setEnabled(true);
                edtTel.setEnabled(true);
                editRoad.setEnabled(true);
            }
        });

        btnChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEdtProfile.setEnabled(true);
                btnChk.setVisibility(rootView_UserInfo.GONE);
                spinnerCity.setEnabled(false);
                spinnerGu.setEnabled(false);
                edtTel.setEnabled(false);
                editRoad.setEnabled(false);
            }
        });

        return rootView_UserInfo;
    }
}
