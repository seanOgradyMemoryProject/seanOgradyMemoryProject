package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    EditText emailID, password;
    Button btnSignIn;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.editText7);
        password = findViewById(R.id.editText9);
        btnSignIn = findViewById(R.id.button);

        /* 'More information' button */
        button =findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInformation();
            }
        });

        button2 =findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(mFirebaseUser != null){
                    Toast.makeText(MainActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, introPage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please log in", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSignIn.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(MainActivity.this, "Fields are empty", LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                        mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> Task){
                        if(!Task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login error occurred!", LENGTH_SHORT).show();
                        }
                        else{
                            Intent inToHome = new Intent(MainActivity.this, introPage.class);
                            startActivity(inToHome);
                        }
                    }
                    });
            }
            else{
                    Toast.makeText(MainActivity.this, "error occurred!", LENGTH_SHORT).show();
            }
        }




        });
    }

    public void openActivityInformation(){
        Intent intent = new Intent(MainActivity.this, Information.class);
        startActivity(intent);
    }

    public void openSignUpPage(){
        Intent intent = new Intent(MainActivity.this, signUp.class);
        startActivity(intent);
    }

    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}
