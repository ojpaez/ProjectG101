package com.example.proyectog101.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.proyectog101.Entidades.Service;

public class DBHelperService extends SQLiteOpenHelper{
    private SQLiteDatabase sqLiteDatabase;

    public DBHelperService(Context context){
        super(context, "G101Service.db", null, 1);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE SERVICES(" +
                "id TEXT PRIMARY KEY," +
                "image TEXT," +
                "name TEXT," +
                "description TEXT," +
                "price TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS SERVICES");
    }

    public void insertData(Service service){
        String sql = "INSERT INTO SERVICES VALUES(?, ?, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, service.getId());
        statement.bindString(2, service.getImage());
        statement.bindString(3, service.getName());
        statement.bindString(4, service.getDescription());
        statement.bindString(5, service.getPrice());

        statement.executeInsert();
    }
    public Cursor getData(){
        Cursor cursor = sqLiteDatabase.rawQuery( "SELECT * FROM SERVICES",null);
        return cursor;
    }
}
