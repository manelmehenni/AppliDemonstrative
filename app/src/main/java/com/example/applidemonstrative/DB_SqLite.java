package com.example.applidemonstrative;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB_SqLite extends SQLiteOpenHelper {
    public static final String DBname="data.db";

    public DB_SqLite(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table utilisateur(id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, mdp TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS utilisateur");
        onCreate(db);
    }

    public boolean insertData(String nom, String mdp){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom", nom);
        contentValues.put("mdp", mdp);
        long result= db.insert("utilisateur", null, contentValues);
        if (result== -1)
            return false;
        else
            return true;
    }

    public ArrayList getAllRecord(){
        ArrayList arrayList= new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res= db.rawQuery("select * from utilisateur", null);
        ((Cursor) res).moveToFirst();
        while(res.isAfterLast()==false){
            String t1=res.getString(0);
            String t2=res.getString(1);
            String t3=res.getString(2);

            arrayList.add(t1 +" - "+t2+" : "+t3);
            res.moveToNext();


        }

        return arrayList;
    }


}
