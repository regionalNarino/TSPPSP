package com.example.worldskills.tsppsp.Other;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {
    public Conexion(Context context) {
        super(context, "tsp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table proyecto(id integer primary key autoincrement, nombre text, tiempo text)");
        db.execSQL("create table timelog(id integer primary key autoincrement, phase text, start text, interruption text, stop text, delta text, comments text, idproject text)");
        db.execSQL("create table defectlog(id integer primary key autoincrement, date text, type text, phaseinjected text, phaseremoved text, fixtime text, defectdescription text, idproject text)");

        db.execSQL("insert into proyecto(nombre) values('android')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
