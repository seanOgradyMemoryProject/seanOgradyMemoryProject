package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class memoryStrategies3 extends AppCompatActivity {
    private Button Home;
    TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_strategies3);

        Home = findViewById(R.id.button16);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMemstrats4Page();
            }
        });


        TextView = findViewById(R.id.textView9);
        String attention22[] = getBaseContext().getResources().getStringArray(R.array.attention2);
        int arraySize = attention22.length;
        for (int i = 0; i < arraySize; i++) {
            TextView.append(attention22[i]);
            TextView.append("\n\n");
            //potential faade
        }

    }

    public void openMemstrats4Page(){
        Intent intent = new Intent(memoryStrategies3.this, memoryStrategies4.class);
        startActivity(intent);
    }

}