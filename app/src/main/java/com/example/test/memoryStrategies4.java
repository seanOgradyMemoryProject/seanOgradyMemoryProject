package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class memoryStrategies4 extends AppCompatActivity {
    TextView TextView;
    private Button memstrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_strategies4);

        memstrat = findViewById(R.id.button31);
        memstrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMemstrats5Page();
            }
        });



        TextView = findViewById(R.id.textView10);
        String attention33[] = getBaseContext().getResources().getStringArray(R.array.attention3);
        int arraySize = attention33.length;
        for (int i = 0; i < arraySize; i++) {
            TextView.append(attention33[i]);
            TextView.append("\n\n");
            //potential faade
        }



    }


    public void openMemstrats5Page(){
        Intent intent = new Intent(memoryStrategies4.this, memoryStrategies5.class);
        startActivity(intent);
    }



}
