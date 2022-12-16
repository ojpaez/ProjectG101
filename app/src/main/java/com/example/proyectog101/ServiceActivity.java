package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectog101.Adaptadores.ServiceAdapter;
import com.example.proyectog101.Entidades.Service;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {
    private ListView listViewServices;
    private ServiceAdapter serviceAdapter;
    private ArrayList<Service> arrayServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        listViewServices = (ListView) findViewById(R.id.listViewServices);
        arrayServices = new ArrayList<>();

        Service service1 = new Service(R.drawable.service_arrangements,"* Arreglos Locativos.","* Todo tipo de arreglos locativos en su hogar o empresa.","* El costo varía según lo requerido.");
        Service service2 = new Service(R.drawable.service_electricity,"* Trabajos de Electricidad.","* Hacemos los trabajos ele´ctricos que requiera.","* El costo se indica en una visita de revisión.");
        Service service3 = new Service(R.drawable.service_tubes,"* Servicio de Plomería.","* Todo trabajo relacionado con redes de acuedcuto y alcantarillado locativo.","* El costo varía según la actividad requerida.");
        Service service4 = new Service(R.drawable.service_keys,"* Copia de LLaves.","* Hacemos copias de numerosos tipos de llaves disponibles en el mercado.","* El csoto varía según la llave que requiera.");

        arrayServices.add(service1);
        arrayServices.add(service2);
        arrayServices.add(service3);
        arrayServices.add(service4);

        serviceAdapter = new ServiceAdapter(this, arrayServices);
        listViewServices.setAdapter(serviceAdapter);
    }
}