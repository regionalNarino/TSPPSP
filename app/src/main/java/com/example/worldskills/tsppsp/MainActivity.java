package com.example.worldskills.tsppsp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.worldskills.tsppsp.Other.Conexion;
import com.example.worldskills.tsppsp.Other.Variables;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listProjects;
    EditText nameProject;
    List<String> datos;
    List<String> ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProjects=findViewById(R.id.listProjects);
        nameProject=findViewById(R.id.txtNameProject);

        cargarList();
        listProjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Variables.id=ids.get(position);
                Intent intent=new Intent(MainActivity.this,OpcionesActivity.class);
                startActivity(intent);
            }
        });

    }

    private void cargarList() {
        Conexion conexion=new Conexion(this);
        SQLiteDatabase db=conexion.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from proyecto",null);
        datos=new ArrayList<>();
        ids=new ArrayList<>();
        if (cursor!=null){
            while (cursor.moveToNext()){
                ids.add(cursor.getString(0));
                datos.add(cursor.getString(1));
            }
        }
        listProjects.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos));
    }

    public void onClick(View view) {
        adicionar();
    }

    private void adicionar() {
        if (nameProject.getText().length()>0){
            Conexion conexion=new Conexion(this);
            SQLiteDatabase db=conexion.getWritableDatabase();
            db.execSQL("insert into proyecto(nombre,tiempo) values('"+nameProject.getText()+"','false')");
            nameProject.setText("");
            cargarList();
        }
    }
}
