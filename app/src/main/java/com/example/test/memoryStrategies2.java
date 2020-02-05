package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class memoryStrategies2 extends AppCompatActivity {
    private Button buttonStrategies3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_strategies2);

        buttonStrategies3 =findViewById(R.id.button12);
        buttonStrategies3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategies3Page();
            }
        });

    }

    public void openStrategies3Page(){
        Intent intent = new Intent(memoryStrategies2.this, memoryStrategies3.class);
        startActivity(intent);
    }


}
