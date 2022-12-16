package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectog101.Adaptadores.BranchAdapter;
import com.example.proyectog101.Entidades.Branch;

import java.util.ArrayList;

public class BranchActivity extends AppCompatActivity {
    private ListView listViewBranches;
    private BranchAdapter branchAdapter;
    private ArrayList<Branch> arrayBranches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        listViewBranches = (ListView) findViewById(R.id.listViewBranches);
        arrayBranches = new ArrayList<>();

        Branch branch1 = new Branch(R.drawable.splash_sucursales_copia,"Bogotá","Cll. 10 # 18 - Las Nieves");
        Branch branch2 = new Branch(R.drawable.splash_sucursales_copia,"Cali","Cll. 5 # 65 - El Refugio");
        Branch branch3 = new Branch(R.drawable.splash_sucursales_copia,"Ibagué","Cra. 2 # 9 - Plaza de Bolivar Centro ");

        arrayBranches.add(branch1);
        arrayBranches.add(branch2);
        arrayBranches.add(branch3);

        branchAdapter = new BranchAdapter(this,arrayBranches);
        listViewBranches.setAdapter(branchAdapter);
    }
}