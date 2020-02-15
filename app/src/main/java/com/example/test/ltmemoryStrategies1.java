package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ltmemoryStrategies1 extends AppCompatActivity {
    TextView TextView;
    private Button buttonStrategies2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltmemory_strategies1);

        TextView = (TextView) findViewById(R.id.textView17);
        String ltStrategy11[] = getBaseContext().getResources().getStringArray(R.array.longTerm1);
        int arraySize = ltStrategy11.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(ltStrategy11[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonStrategies2 =findViewById(R.id.button38);
        buttonStrategies2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategies2Page();
            }
        });


    }

    public void openStrategies2Page(){
        Intent intent = new Intent(ltmemoryStrategies1.this, ltmemoryStrategies2.class);
        startActivity(intent);
    }



}
