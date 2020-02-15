package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ltmemoryStrategies2 extends AppCompatActivity {
    TextView TextView;
    private Button buttonStrategies2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltmemory_strategies2);

        TextView = (TextView) findViewById(R.id.textView18);
        String ltStrategy22[] = getBaseContext().getResources().getStringArray(R.array.longTerm2);
        int arraySize = ltStrategy22.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(ltStrategy22[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonStrategies2 =findViewById(R.id.button39);
        buttonStrategies2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategies3Page();
            }
        });

    }

    public void openStrategies3Page(){
        Intent intent = new Intent(ltmemoryStrategies2.this, ltmemoryStrategies3.class);
        startActivity(intent);
    }


}
