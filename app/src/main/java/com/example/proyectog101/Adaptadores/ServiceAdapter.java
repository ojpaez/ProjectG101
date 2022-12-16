package com.example.proyectog101.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectog101.Entidades.Service;
import com.example.proyectog101.R;

import java.util.ArrayList;

public class ServiceAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Service> arrayServices;

    public ServiceAdapter(Context context, ArrayList<Service> arrayServices) {
        this.context = context;
        this.arrayServices = arrayServices;
    }

    @Override
    public int getCount() {
        return arrayServices.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayServices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(R.layout.service_template,null);

        Service service = arrayServices.get(position);

        ImageView imgService = (ImageView) convertView.findViewById(R.id.imgService);
        TextView tvNameService = (TextView) convertView.findViewById(R.id.tvNameService);
        TextView tvDescriptionService = (TextView) convertView.findViewById(R.id.tvDescriptionService);
        TextView tvPriceService = (TextView) convertView.findViewById(R.id.tvPriceService);
        //Button btnService = (Button) convertView.findViewById(R.id.btnService);

        imgService.setImageResource(service.getImage());
        tvNameService.setText(service.getName());
        tvDescriptionService.setText(service.getDescription());
        tvPriceService.setText(String.valueOf(service.getPrice()));

        imgService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return convertView;

    }
}
