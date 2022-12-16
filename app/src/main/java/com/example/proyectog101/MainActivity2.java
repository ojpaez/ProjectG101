package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button btnInfo;
    private TextView textNameInfo, textDescriptionInfo, textPriceInfo;
    private ImageView imgInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnInfo = (Button) findViewById(R.id.btnInfo);
        textNameInfo = (TextView) findViewById((R.id.textNameInfo));
        textDescriptionInfo = (TextView) findViewById((R.id.textDescriptionInfo));
        textPriceInfo = (TextView) findViewById((R.id.textPriceInfo));
        imgInfo = (ImageView) findViewById(R.id.imageInfo);

        Intent intentIn = getIntent();
        textNameInfo.setText(intentIn.getStringExtra("name"));
        textDescriptionInfo.setText(intentIn.getStringExtra("description"));
        textPriceInfo.setText(String.valueOf(intentIn.getIntExtra("price",0)));
        imgInfo.setImageResource(intentIn.getIntExtra("image",0));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}