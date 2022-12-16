package com.example.proyectog101.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectog101.Entidades.Branch;
import com.example.proyectog101.R;

import java.util.ArrayList;

public class BranchAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Branch> arrayBranches;

    public BranchAdapter(Context context, ArrayList<Branch> arrayBranches){
        this.context = context;
        this.arrayBranches = arrayBranches;
    }

    @Override
    public int getCount() {
        return arrayBranches.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayBranches.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(R.layout.branch_template,null);

        Branch branch = arrayBranches.get(position);

        ImageView imgBranch = (ImageView) convertView.findViewById(R.id.imgBranch);
        TextView tvNameBranch = (TextView) convertView.findViewById(R.id.tvNameBranch);
        TextView tvDescriptionBranch = (TextView) convertView.findViewById(R.id.tvDescriptionBranch);

        imgBranch.setImageResource(branch.getImage());
        tvNameBranch.setText(branch.getName());
        tvDescriptionBranch.setText(branch.getDescription());

        imgBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        return convertView;
    }
}
