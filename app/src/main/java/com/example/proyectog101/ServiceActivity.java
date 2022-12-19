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

import com.example.proyectog101.Adaptadores.ServiceAdapter;
import com.example.proyectog101.BD.DBFirebaseService;
import com.example.proyectog101.BD.DBHelperService;
import com.example.proyectog101.Entidades.Service;
import com.example.proyectog101.Servicios.ServiceService;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {
    private DBHelperService dbHelperService;
    private DBFirebaseService dbFirebaseService;
    private ServiceService serviceService;
    private ListView listViewServices;
    private ServiceAdapter serviceAdapter;
    private ArrayList<Service> arrayServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        arrayServices = new ArrayList<>();
        serviceService = new ServiceService();

        try{
            dbHelperService = new DBHelperService(this);
            dbFirebaseService = new DBFirebaseService();
        }catch (Exception e){
            Log.e("Error DB", e.toString());
        }

        listViewServices = (ListView) findViewById(R.id.listViewServices);

        /*
        Service service1 = new Service("","* Arreglos Locativos.","* Todo tipo de arreglos locativos en su hogar o empresa.","* El costo varía según lo requerido.");
        Service service2 = new Service("","* Trabajos de Electricidad.","* Hacemos los trabajos ele´ctricos que requiera.","* El costo se indica en una visita de revisión.");
        Service service3 = new Service("","* Servicio de Plomería.","* Todo trabajo relacionado con redes de acuedcuto y alcantarillado locativo.","* El costo varía según la actividad requerida.");
        Service service4 = new Service("","* Copia de LLaves.","* Hacemos copias de numerosos tipos de llaves disponibles en el mercado.","* El csoto varía según la llave que requiera.");

        dbHelperService.insertData(service1);
        dbHelperService.insertData(service2);
        dbHelperService.insertData(service3);
        dbHelperService.insertData(service4);
        */

        //arrayServices = serviceService.cursorToArrayList(dbHelperService.getData());

        /*
        arrayServices.add(service1);
        arrayServices.add(service2);
        arrayServices.add(service3);
        arrayServices.add(service4);
        */

        serviceAdapter = new ServiceAdapter(this, arrayServices);
        listViewServices.setAdapter(serviceAdapter);
        dbFirebaseService.getData(serviceAdapter, arrayServices);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.service, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAddService:
                Intent intent = new Intent(getApplicationContext(), ServiceForm.class);
                startActivity(intent);
                return true;
            case R.id.itemFavoriteService:
                Toast.makeText(getApplicationContext(), "Favoritos",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemShareService:
                Toast.makeText(getApplicationContext(), "Compartir",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}