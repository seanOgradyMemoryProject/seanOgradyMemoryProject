package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class externalMemory1 extends AppCompatActivity {
    TextView TextView;
    private Button buttonExternal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_memory1);

        TextView = (TextView) findViewById(R.id.textView23);
        String external11[] = getBaseContext().getResources().getStringArray(R.array.inext1);
        int arraySize = external11.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(external11[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonExternal2 =findViewById(R.id.button48);
        buttonExternal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExternal2Page();
            }
        });
    }

    public void openExternal2Page(){
        Intent intent = new Intent(externalMemory1.this, externalMemory2.class);
        startActivity(intent);
    }
}
