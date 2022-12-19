package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.proyectog101.BD.DBFirebaseBranch;
import com.example.proyectog101.BD.DBHelperBranch;
import com.example.proyectog101.Entidades.Branch;


public class BranchForm extends AppCompatActivity {
    private DBHelperBranch dbHelperBranch;
    private DBFirebaseBranch dbFirebaseBranch;
    private Button btnBranchForm;
    private ImageView imgBranchForm;
    private EditText editNameBranchForm, editDescriptionBranchForm, editPriceBranchForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_form);

        btnBranchForm = (Button) findViewById(R.id.btnBranchForm);
        imgBranchForm = (ImageView) findViewById(R.id.imgBranchForm);
        editNameBranchForm = (EditText) findViewById(R.id.editNameBranchForm);
        editDescriptionBranchForm = (EditText) findViewById(R.id.editDescriptionBranchForm);

        try {
            dbHelperBranch = new DBHelperBranch(this);
            dbFirebaseBranch = new DBFirebaseBranch();
        }catch (Exception e){
            Log.e("Error DB", e.toString());
        }

        btnBranchForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Branch branch = new Branch(
                        "",
                        "",
                        editNameBranchForm.getText().toString(),
                        editDescriptionBranchForm.getText().toString()
                );
                //dbHelper.insertData(product);
                dbFirebaseBranch.insertData(branch);
                Intent intent = new Intent(getApplicationContext(), BranchActivity.class);
                startActivity(intent);
            }
        });

    }
}