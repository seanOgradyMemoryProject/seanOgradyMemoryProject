package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    private Button button;
    TextView TextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        button =findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        TextView = findViewById(R.id.textView25);
        String info = getBaseContext().getResources().getString(R.string.moreInfo);
        TextView.append(info);


    }
    //Back to home button
    public void openHomePage(){
        Intent intent = new Intent(Information.this, MainActivity.class);
        startActivity(intent);
    }
}
