package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showAllActivity extends AppCompatActivity {
    private Button Home;
    TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        Home =findViewById(R.id.button30);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        TextView = (TextView) findViewById(R.id.textView2);
        String tipsy[] = getBaseContext().getResources().getStringArray(R.array.tipsy);
        int arraySize = tipsy.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(tipsy[i]);
            TextView.append("\n\n");
            //potential faade
        }


    }


    public void openHomePage(){
        Intent intent = new Intent(showAllActivity.this, Home.class);
        startActivity(intent);
    }

}
