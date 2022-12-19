package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.proyectog101.BD.DBFirebaseService;
import com.example.proyectog101.BD.DBHelperService;
import com.example.proyectog101.Entidades.Service;


public class ServiceForm extends AppCompatActivity {
    private DBHelperService dbHelperService;
    private DBFirebaseService dbFirebaseService;
    private Button btnServiceForm;
    private ImageView imgServiceForm;
    private EditText editNameServiceForm, editDescriptionServiceForm, editPriceServiceForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_form);

        btnServiceForm = (Button) findViewById(R.id.btnServiceForm);
        imgServiceForm = (ImageView) findViewById(R.id.imgServiceForm);
        editNameServiceForm = (EditText) findViewById(R.id.editNameServiceForm);
        editDescriptionServiceForm = (EditText) findViewById(R.id.editDescriptionServiceForm);
        editPriceServiceForm = (EditText) findViewById(R.id.editPriceServiceForm);

        try {
            dbHelperService = new DBHelperService(this);
            dbFirebaseService = new DBFirebaseService();
        }catch (Exception e){
            Log.e("Error DB", e.toString());
        }

        btnServiceForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service service = new Service(
                        "",
                        "",
                        editNameServiceForm.getText().toString(),
                        editDescriptionServiceForm.getText().toString(),
                        editPriceServiceForm.getText().toString().trim()
                );
                //dbHelper.insertData(product);
                dbFirebaseService.insertData(service);
                Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}