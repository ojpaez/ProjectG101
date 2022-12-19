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

import com.example.proyectog101.Adaptadores.ProductAdapter;
import com.example.proyectog101.BD.DBFirebase;
import com.example.proyectog101.BD.DBHelper;
import com.example.proyectog101.Entidades.Product;
import com.example.proyectog101.Servicios.ProductService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private DBFirebase dbFirebase;
    private ProductService productService;
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> arrayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayProducts = new ArrayList<>();
        productService = new ProductService();

        try{
            dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();
        }catch (Exception e){
            Log.e("Error DB", e.toString());
        }

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);

        /*
        Product product1 = new Product("", "Flexómetro 3 metros", "Flexometro de 3 metros genérico",15000);
        Product product2 = new Product("", "Alicates 6 pulgadas", "Alicates de 6 pulgadas trabajo liviano",12000);
        Product product3 = new Product("", "Tornillo Aglomerado x150 un ", "Tornillo en acero rosca ordinaria",16000);
        Product product4 = new Product("", "Juego de destonilladores", "Juego de destonilladores punta intercambiable",38900);
        Product product5 = new Product("", "Pinza 5 pulgadas", "Pinza de 6 pulgadas cortante",7500);
        Product product6 = new Product("", "Llave combinada 14mm", "Llave de boca combinada 14mm",18900);

        dbHelper.insertData(product1);
        dbHelper.insertData(product2);
        dbHelper.insertData(product3);
        dbHelper.insertData(product4);
        dbHelper.insertData(product5);
        dbHelper.insertData(product6);
        */
        //dbHelper.getData();

        /*Usar método de productservice */

        //arrayProducts = productService.cursorToArrayList(dbHelper.getData());

        /*
        arrayProducts.add(product1);
        arrayProducts.add(product2);
        arrayProducts.add(product3);
        arrayProducts.add(product4);
        arrayProducts.add(product5);
        arrayProducts.add(product6);
        */
        productAdapter = new ProductAdapter(this, arrayProducts);
        listViewProducts.setAdapter(productAdapter);
        dbFirebase.getData(productAdapter, arrayProducts);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAdd:
                Intent intent = new Intent(getApplicationContext(), ProductForm.class);
                startActivity(intent);
                return true;
            case R.id.itemFavorite:
                Toast.makeText(getApplicationContext(), "Favoritos",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemShare:
                Toast.makeText(getApplicationContext(), "Compartir",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}