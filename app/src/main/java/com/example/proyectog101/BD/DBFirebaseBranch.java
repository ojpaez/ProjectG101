package com.example.proyectog101.BD;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectog101.Adaptadores.BranchAdapter;
import com.example.proyectog101.Entidades.Branch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebaseBranch {
    private FirebaseFirestore db;

    public DBFirebaseBranch() {
        this.db = FirebaseFirestore.getInstance();
    }

    public void insertData(Branch branch) {
        // Create a new user with a first and last name
        Map<String, Object> bran = new HashMap<>();
        bran.put("id", branch.getId());
        bran.put("image", branch.getImage());
        bran.put("name", branch.getName());
        bran.put("description", branch.getDescription());
        bran.put("latitud", branch.getLatitud());
        bran.put("longitud", branch.getLongitud());

// Add a new document with a generated ID
        db.collection("branches").add(bran);

    }

    public void getData(BranchAdapter adapter, ArrayList<Branch> list) {
        db.collection("branches")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Branch branch = new Branch(
                                        document.getData().get("id").toString(),
                                        document.getData().get("image").toString(),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        document.getData().get("latitud").toString(),
                                        document.getData().get("longitud").toString()
                                );
                                list.add(branch);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.e("Error Document", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
