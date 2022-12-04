package com.example.proyecto_g101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnOk, btn2;
    private TextView textName, textLastName, textAge, textTitle, textTitle2;
    private EditText editName, editLastName, editAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Referencia
        //bottons
        btnOk = (Button) findViewById(R.id.btnOk);
        btn2 = (Button) findViewById(R.id.btn2);

        //textViews
        textName = (TextView) findViewById(R.id.textName);
        textLastName = (TextView) findViewById(R.id.textLastName);
        textAge = (TextView) findViewById(R.id.textAge);
        textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle2 = (TextView) findViewById(R.id.textTitle2);

        //editTexts
        editName = (EditText) findViewById(R.id.editName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        editAge = (EditText) findViewById(R.id.editAge);

        //
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String lastName = editLastName.getText().toString();
                String age = editAge.getText().toString();
                String fullName = name +" "+ lastName;
                String complementAge = " tiene "+ age +" años";
                textTitle.setText(fullName);
                textTitle2.setText(complementAge);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Pulse Volver Para la Página Principal",Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                return false;
            }
        });

        };
    }
