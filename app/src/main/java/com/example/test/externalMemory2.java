package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class externalMemory2 extends AppCompatActivity {
    TextView TextView;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_memory2);

        TextView = (TextView) findViewById(R.id.textView24);
        String external22[] = getBaseContext().getResources().getStringArray(R.array.inext2);
        int arraySize = external22.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(external22[i]);
            TextView.append("\n\n");
            //potential faade
        }

        home =findViewById(R.id.button49);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }
    public void openHomePage(){
        Intent intent = new Intent(externalMemory2.this, Home.class);
        startActivity(intent);
    }
}
