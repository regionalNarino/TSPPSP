package com.example.worldskills.tsppsp;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefectLogActivity extends AppCompatActivity {
    EditText txtDate,txtDescription;
    Chronometer chronometer;
    Spinner spinnerType,spinnerInjected,spinnerRemoved;
    long tiempoPause;
    boolean pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtDate=findViewById(R.id.txtDateDefect);
        txtDescription=findViewById(R.id.txtDescriptionDefectLog);
        chronometer=findViewById(R.id.chronometer);
        spinnerType=findViewById(R.id.spinnerType);
        spinnerInjected=findViewById(R.id.spinnerPhaseInjected);
        spinnerRemoved=findViewById(R.id.spinnerPhaseRemoved);
        cargarSpinnerType();
        cargarSpinnerOther();
    }

    private void cargarSpinnerType() {
        String opciones[]={"Documentation","Syntax","Build","Package","Assigment","Interface","Checking","Data","Function","System","Environment"};
        spinnerType.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones));
    }

    private void cargarSpinnerOther() {
        String opciones [] ={"PLAN","DLD","CODE","COMPILE","UT","PM"};
        spinnerRemoved.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones));
        spinnerInjected.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGenerarDate:
                cargarFechaActual();
                break;

            case R.id.btnStartChronometer:
                iniciar();
                break;

            case R.id.btnStopChronometer:
                detener();
                break;

            case R.id.btnResetChronometer:
                resetear();
                break;
        }
    }

    private void resetear() {
        chronometer.setBase(tiempoPause-SystemClock.elapsedRealtime());
        chronometer.start();
        pause=true;
    }

    private void detener() {
        if (pause){
            chronometer.stop();
            tiempoPause=SystemClock.elapsedRealtime()-chronometer.getBase();
            pause=false;
        }
    }

    private void iniciar() {
        if (!pause){
            chronometer.setBase(SystemClock.elapsedRealtime()-tiempoPause);
            chronometer.start();
            pause=true;
        }
    }

    private void cargarFechaActual() {
        SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date=new Date();
        String fecha=formato.format(date);
        txtDate.setText(fecha);
    }
}
