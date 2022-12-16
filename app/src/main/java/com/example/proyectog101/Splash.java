package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private ImageView imgSplashProducts;
    private ImageView imgSplashServices;
    private ImageView imgSplashBranch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgSplashProducts = (ImageView) findViewById(R.id.imgSplashProducts);
        imgSplashProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        imgSplashServices = (ImageView) findViewById(R.id.imgSplashServices);
        imgSplashServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
                startActivity(intent);
            }
        });

        imgSplashBranch = (ImageView) findViewById(R.id.imgSplashBranch);
        imgSplashBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BranchActivity.class);
                startActivity(intent);
            }
        });
    }
}