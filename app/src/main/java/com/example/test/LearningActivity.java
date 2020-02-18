package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LearningActivity extends AppCompatActivity {
    TextView TextView;
    private Button button;
    private Button toWebsite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        button =findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

         toWebsite = findViewById(R.id.button50);

        toWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://amp.smh.com.au/lifestyle/health-and-wellness/lifting-weights-protects-the-brain-from-long-term-degeneration-20200210-p53ze3.html"));
                startActivity(intent);
            }
        });

        TextView = (TextView) findViewById(R.id.textView8);
        String stStrategy22 = getBaseContext().getResources().getString(R.string.learnMore);
        TextView.append(stStrategy22);
    }

    //Go to home page
    public void openHomePage(){
        Intent intent = new Intent(LearningActivity.this, Home.class);
        startActivity(intent);
    }
}
