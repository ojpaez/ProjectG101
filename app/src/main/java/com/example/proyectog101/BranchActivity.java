package com.example.proyectog101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectog101.Adaptadores.BranchAdapter;
import com.example.proyectog101.BD.DBFirebaseBranch;
import com.example.proyectog101.BD.DBHelperBranch;
import com.example.proyectog101.Entidades.Branch;
import com.example.proyectog101.Servicios.BranchService;

import java.util.ArrayList;

public class BranchActivity extends AppCompatActivity {
    private DBHelperBranch dbHelperBranch;
    private DBFirebaseBranch dbFirebaseBranch;
    private BranchService branchService;
    private ListView listViewBranches;
    private BranchAdapter branchAdapter;
    private ArrayList<Branch> arrayBranches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        arrayBranches = new ArrayList<>();
        branchService = new BranchService();

        try{
            dbHelperBranch = new DBHelperBranch(this);
            dbFirebaseBranch = new DBFirebaseBranch();
        }catch (Exception e){
            Log.e("Error DB", e.toString());
        }

        listViewBranches = (ListView) findViewById(R.id.listViewBranches);
        /*
        Branch branch1 = new Branch("","Bogotá","Cll. 10 # 18 - Las Nieves");
        Branch branch2 = new Branch("","Cali","Cll. 5 # 65 - El Refugio");
        Branch branch3 = new Branch("","Ibagué","Cra. 2 # 9 - Plaza de Bolivar Centro ");
        */
        /*
        dbHelperBranch.insertData(branch1);
        dbHelperBranch.insertData(branch2);
        dbHelperBranch.insertData(branch3);
        */

        //arrayBranches = branchService.cursorToArrayList(dbHelperBranch.getData());

        /*
        arrayBranches.add(branch1);
        arrayBranches.add(branch2);
        arrayBranches.add(branch3);
        */
        branchAdapter = new BranchAdapter(this,arrayBranches);
        listViewBranches.setAdapter(branchAdapter);
        dbFirebaseBranch.getData(branchAdapter, arrayBranches);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.branch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAddBranch:
                Intent intent = new Intent(getApplicationContext(), BranchForm.class);
                startActivity(intent);
                return true;
            case R.id.itemFavoriteBranch:
                Toast.makeText(getApplicationContext(), "Favoritos",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemShareBranch:
                Toast.makeText(getApplicationContext(), "Compartir",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}