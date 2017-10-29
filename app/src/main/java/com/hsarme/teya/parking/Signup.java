package com.hsarme.teya.parking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity implements View.OnClickListener{
    private EditText etname,phone,email,etpas;
    private Button btnsave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etname = (EditText) findViewById(R.id.etname);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        etpas = (EditText) findViewById(R.id.etpas);
        btnsave = (Button) findViewById(R.id.btnsave);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }

    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Signup.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();

                    finish();
                } else {
                    Toast.makeText(Signup.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
        FirebaseAuth.getInstance().signOut();


    }

    private void dataHandler() {
        String stemail = email.getText().toString();
        String stPaswword = etpas.getText().toString();
        String name = etname.getText().toString();
        String ephone = phone.getText().toString();

        boolean isOk = true;
        if (stemail.length() == 0 || stemail.indexOf('@') < 1) {
            email.setError("wrong email");
            isOk = false;
        }
        if (stPaswword.length() < 8) {
            etpas.setError("bad password");
            isOk = false;
        }
        if (isOk) {
            creatAcount(stemail, stPaswword);

        }
    }

    @Override
    public void onClick(View view) {
        dataHandler();
    }
}
