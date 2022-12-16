package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectog101.Adaptadores.ProductAdapter;
import com.example.proyectog101.Entidades.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> arrayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProducts = new ArrayList<>();

        Product product1 = new Product(R.drawable.product_meter, "Flexómetro 3 metros", "Flexometro de 3 metros genérico",15000);
        Product product2 = new Product(R.drawable.product_pliers, "Alicates 6 pulgadas", "Alicates de 6 pulgadas trabajo liviano",12000);
        Product product3 = new Product(R.drawable.product_screws, "Tornillo Aglomerado x150 un ", "Tornillo en acero rosca ordinaria",16000);
        Product product4 = new Product(R.drawable.product_screwdriver, "Juego de destonilladores", "Juego de destonilladores punta intercambiable",38900);
        Product product5 = new Product(R.drawable.product_tweezers, "Pinza 5 pulgadas", "Pinza de 6 pulgadas cortante",7500);
        Product product6 = new Product(R.drawable.product_wrench, "Llave combinada 14mm", "Llave de boca combinada 14mm",18900);

        arrayProducts.add(product1);
        arrayProducts.add(product2);
        arrayProducts.add(product3);
        arrayProducts.add(product4);
        arrayProducts.add(product5);
        arrayProducts.add(product6);

        productAdapter = new ProductAdapter(this, arrayProducts);
        listViewProducts.setAdapter(productAdapter);

    }
}