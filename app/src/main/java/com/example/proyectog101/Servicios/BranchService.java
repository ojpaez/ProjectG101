package com.example.proyectog101.Servicios;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.proyectog101.Entidades.Branch;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class BranchService {
    public byte[] imageViewToByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public ArrayList<Branch> cursorToArrayList(Cursor cursor){
        ArrayList<Branch> list = new ArrayList<>();
        if(cursor.getCount() != 0){
            while (cursor.moveToNext()){
                Branch branch = new Branch(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                );
                list.add(branch);
            }
        }
        return list;
    }

}
