package com.example.proyectog101.BD;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectog101.Adaptadores.ServiceAdapter;
import com.example.proyectog101.Entidades.Service;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebaseService {
    private FirebaseFirestore db;

    public DBFirebaseService() {
        this.db = FirebaseFirestore.getInstance();
    }

    public void insertData(Service product) {
        // Create a new user with a first and last name
        Map<String, Object> serv = new HashMap<>();
        serv.put("id", product.getId());
        serv.put("image", product.getImage());
        serv.put("name", product.getName());
        serv.put("description", product.getDescription());
        serv.put("price", product.getPrice());

// Add a new document with a generated ID
        db.collection("services").add(serv);

    }

    public void getData(ServiceAdapter adapter, ArrayList<Service> list) {
        db.collection("services")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Service service = new Service(
                                        document.getData().get("id").toString(),
                                        document.getData().get("image").toString(),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        document.getData().get("price").toString()
                                );
                                list.add(service);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.e("Error Document", "Error getting documents.", task.getException());
                        }
                    }
                });
    }


}
