package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;


import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static android.widget.Toast.LENGTH_SHORT;


public class signUp extends AppCompatActivity {
    EditText emailID, password;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    private Button backToHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.editText7);
        password = findViewById(R.id.editText9);
        btnSignUp = findViewById(R.id.button7);
        backToHome = findViewById(R.id.button8);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty()){
                    emailID.setError("Please enter your email");
                    emailID.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(signUp.this, "Fields are empty", LENGTH_SHORT).show();
                }

                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(signUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(signUp.this, "SignUp Unsuccessful", LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(signUp.this, MainActivity.class));
                            }
                        }

                    });
                }

                else{
                    Toast.makeText(signUp.this, "Error occurred!", LENGTH_SHORT).show();
                }

            }

        });
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signUp.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}