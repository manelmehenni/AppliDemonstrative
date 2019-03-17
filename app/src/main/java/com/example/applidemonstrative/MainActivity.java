package com.example.applidemonstrative;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DB_SqLite db= new DB_SqLite(this);
    EditText nom, mdp;
    ListView list;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom= findViewById(R.id.nom);
        mdp= findViewById(R.id.mdp);
        list= findViewById(R.id.list);
        ShowData();



    }

    public void btn_saisie(View view) {
        String Nom= nom.getText().toString();
        String Mdp= mdp.getText().toString();

        Boolean result= db.insertData(Nom, Mdp);
        if( result==true){
            Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            nom.setText("");
            mdp.setText("");

        }
        else{
            Toast.makeText(MainActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
        }
    }


    public void ShowData()

    {

        ArrayList<String> listData = db.getAllRecord();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listData);
        list.setAdapter(arrayAdapter);
    }


    public void btn_afficher(View view) {
        ShowData();
    }

}
