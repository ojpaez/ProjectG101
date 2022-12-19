package com.example.proyectog101.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.proyectog101.Entidades.Branch;

public class DBHelperBranch extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;

    public DBHelperBranch(Context context){
        super(context, "G101Branch.db", null, 1);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE BRANCHES(" +
                "id TEXT PRIMARY KEY," +
                "image TEXT," +
                "name TEXT," +
                "description TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS BRANCHES");
    }
    public void insertData(Branch branch){
        String sql = "INSERT INTO BRANCHES VALUES(?, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, branch.getId());
        statement.bindString(2, branch.getImage());
        statement.bindString(3, branch.getName());
        statement.bindString(4, branch.getDescription());

        statement.executeInsert();
    }
    public Cursor getData(){
        Cursor cursor = sqLiteDatabase.rawQuery( "SELECT * FROM BRANCHES",null);
        return cursor;
    }
}
