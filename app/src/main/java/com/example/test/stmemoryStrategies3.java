package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stmemoryStrategies3 extends AppCompatActivity {
    TextView TextView;
    private Button buttonStrategies2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stmemory_strategies3);

        TextView = (TextView) findViewById(R.id.textView16);
        String stStrategy33[] = getBaseContext().getResources().getStringArray(R.array.shortTerm3);
        int arraySize = stStrategy33.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(stStrategy33[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonStrategies2 =findViewById(R.id.button36);
        buttonStrategies2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategiesPage();
            }
        });


    }

    public void openStrategiesPage(){
        Intent intent = new Intent(stmemoryStrategies3.this, memoryStrategies.class);
        startActivity(intent);
    }
}
