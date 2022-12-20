package com.example.proyectog101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectog101.BD.DBFirebaseBranch;
import com.example.proyectog101.BD.DBHelperBranch;
import com.example.proyectog101.Entidades.Branch;

import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.views.overlay.Marker;


public class BranchForm extends AppCompatActivity {
    private DBHelperBranch dbHelperBranch;
    private DBFirebaseBranch dbFirebaseBranch;
    private Button btnBranchForm;
    private ImageView imgBranchForm;
    private EditText editNameBranchForm, editDescriptionBranchForm;
    private String latitud, longitud;
    private MapView map;
    private MapController mapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_form);

        latitud = "0";
        longitud = "0";
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

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        map = (MapView) findViewById(R.id.mapBranchForm);
        map.setBuiltInZoomControls(true);
        mapController = (MapController) map.getController();

        GeoPoint Colombia = new GeoPoint(4.570868,-74.297333);
        mapController.setCenter(Colombia);
        mapController.setZoom(7);
        map.setMultiTouchControls(true);

        MapEventsReceiver mapEventsReceiver = new MapEventsReceiver() {
            @Override
            public boolean singleTapConfirmedHelper(GeoPoint p) {
                Marker marker = new Marker(map);
                marker.setPosition(p);
                map.getOverlays().add(marker);
                latitud = String.valueOf(p.getLatitude());
                longitud = String.valueOf(p.getLongitude());
                return false;
            }

            @Override
            public boolean longPressHelper(GeoPoint p) {
                return false;
            }
        };
        MapEventsOverlay mapEventsOverlay = new MapEventsOverlay(this, mapEventsReceiver);
        map.getOverlays().add(mapEventsOverlay);

        btnBranchForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Branch branch = new Branch(
                        "",
                        "",
                        editNameBranchForm.getText().toString(),
                        editDescriptionBranchForm.getText().toString(),
                        latitud,
                        longitud
                );
                //dbHelper.insertData(product);
                dbFirebaseBranch.insertData(branch);
                Intent intent = new Intent(getApplicationContext(), BranchActivity.class);
                startActivity(intent);
            }
        });

    }
}