package com.example.abook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btnLogin = (TextView) findViewById(R.id.btnLogin);
        TextView btnNewMember = (TextView)findViewById(R.id.btnNewMember);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnNewMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MembershipActivity.class);
                startActivity(intent);
            }
        });

    }
}
