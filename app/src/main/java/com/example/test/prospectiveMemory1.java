package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class prospectiveMemory1 extends AppCompatActivity {
    TextView TextView;
    private Button buttonProspective2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospective_memory1);

        TextView = (TextView) findViewById(R.id.textView20);
        String prospective11[] = getBaseContext().getResources().getStringArray(R.array.prospective1);
        int arraySize = prospective11.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(prospective11[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonProspective2 =findViewById(R.id.button45);
        buttonProspective2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProspective2Page();
            }
        });

    }
    public void openProspective2Page(){
        Intent intent = new Intent(prospectiveMemory1.this, prospectiveMemory2.class);
        startActivity(intent);
    }
}
