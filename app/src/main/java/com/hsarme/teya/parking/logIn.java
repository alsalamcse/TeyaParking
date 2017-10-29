package com.hsarme.teya.parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class logIn extends AppCompatActivity {
private EditText etEmail;
    private EditText etPassword;
    private Button btIn,btnup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btIn=(Button) findViewById(R.id.btIn);
        btIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getBaseContext(),MainPage.class);
                startActivity(i);
            }
        });
        btnup=(Button) findViewById(R.id.btnup);
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getBaseContext(),Signup.class);
                startActivity(i);
            }
        });

    }
    }

