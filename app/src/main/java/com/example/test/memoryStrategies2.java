package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class memoryStrategies2 extends AppCompatActivity {
    private Button buttonStrategies3;
    TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_strategies2);

        buttonStrategies3 =findViewById(R.id.button15);
        buttonStrategies3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategies3Page();
            }
        });

        TextView = (TextView) findViewById(R.id.textView7);
        String attention11[] = getBaseContext().getResources().getStringArray(R.array.attention1);
        int arraySize = attention11.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(attention11[i]);
            TextView.append("\n\n");
            //potential faade
        }

    }

    public void openStrategies3Page(){
        Intent intent = new Intent(memoryStrategies2.this, memoryStrategies3.class);
        startActivity(intent);
    }

}
