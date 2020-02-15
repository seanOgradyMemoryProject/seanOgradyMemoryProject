package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stmemoryStrategies1 extends AppCompatActivity {
    TextView TextView;
    private Button buttonStrategies2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stmemory_strategies1);

        TextView = (TextView) findViewById(R.id.textView14);
        String stStrategy11[] = getBaseContext().getResources().getStringArray(R.array.shortTerm1);
        int arraySize = stStrategy11.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(stStrategy11[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonStrategies2 =findViewById(R.id.button34);
        buttonStrategies2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategies2Page();
            }
        });

    }

    public void openStrategies2Page(){
        Intent intent = new Intent(stmemoryStrategies1.this, stmemoryStrategies2.class);
        startActivity(intent);
    }


}
