package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class prospectiveMemory2 extends AppCompatActivity {
    TextView TextView;
    private Button buttonProspective3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospective_memory2);

        TextView = (TextView) findViewById(R.id.textView21);
        String prospective22[] = getBaseContext().getResources().getStringArray(R.array.prospective2);
        int arraySize = prospective22.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(prospective22[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonProspective3 =findViewById(R.id.button46);
        buttonProspective3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProspective3Page();
            }
        });
    }

    public void openProspective3Page(){
        Intent intent = new Intent(prospectiveMemory2.this, prospectiveMemory3.class);
        startActivity(intent);
    }



}
