package com.example.worldskills.tsppsp;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.tsppsp.Other.Conexion;
import com.example.worldskills.tsppsp.Other.Variables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLogActivity extends AppCompatActivity {
    EditText txtStart,txtInterruption,txtStop,txtDelta,txtComments;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtStart=findViewById(R.id.txtStarTimeLog);
        txtInterruption=findViewById(R.id.txtInterruption);
        txtStop=findViewById(R.id.txtStopTimeLog);
        txtDelta=findViewById(R.id.txtDeltaTimeLog);
        txtComments=findViewById(R.id.txtCommentsTimeLog);
        spinner=findViewById(R.id.spinnerTimeLog);

        txtStop.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                cargarDelta();
                return false;
            }
        });

        cargarSpinner();
    }

    private void cargarSpinner() {
        String opciones[]={"PLAN","DLD","CODE","COMPILE","UT","PM"};
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones));
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
            case R.id.btnStartTimeLog:
                cargarFechaStart();
                break;

            case R.id.btnStopTimeLog:
                cargarFechaStop();
                break;

            case R.id.btnGuardarTimeLog:
                guardarDatos(view);
                break;
        }
    }

    private void guardarDatos(View view) {
        if (txtStart.getText().toString().length()>0){
            if (txtInterruption.getText().toString().length()>0){
                if (txtStop.getText().toString().length()>0){
                    if (txtDelta.getText().toString().length()>0){
                        adicionar(view);
                    }else{
                        Snackbar.make(view,"Corrija los datos porfavor",Snackbar.LENGTH_SHORT).show();
                    }
                }else{
                    Snackbar.make(view,"Corrija los datos porfavor",Snackbar.LENGTH_SHORT).show();
                }
            }else{
                Snackbar.make(view,"Corrija los datos porfavor",Snackbar.LENGTH_SHORT).show();
            }
        }else{
            Snackbar.make(view,"Corrija los datos porfavor",Snackbar.LENGTH_SHORT).show();
        }
    }

    private void adicionar(View view) {
        try{
            String sql="insert into timelog(phase,start, interruption,stop, delta, comments, idproject) values" +
                    "('"+spinner.getSelectedItem().toString()+"','"+txtStart.getText()+"','"+txtInterruption.getText()+"','"+txtStop.getText()+"','"+txtDelta.getText()+"'" +
                    ",'"+txtComments.getText()+"','"+ Variables.id+"')";
            Conexion conexion=new Conexion(this);
            SQLiteDatabase db=conexion.getWritableDatabase();
            db.execSQL(sql);
            Snackbar.make(view,"Corrija los datos porfavor",Snackbar.LENGTH_SHORT).show();
            limiparFormulario();
        }catch (Exception e){
            Snackbar.make(view,"Corrija los datos porfavor",Snackbar.LENGTH_SHORT).show();
        }
    }

    private void limiparFormulario() {
        txtStart.setText("");
        txtInterruption.setText("");
        txtStop.setText("");
        txtDelta.setText("");
        txtComments.setText("");
    }


    private void cargarFechaStop() {
        SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date=new Date();
        String fecha=formato.format(date);
        txtStop.setText(fecha);
        cargarDelta();

    }

    private void cargarDelta() {
        SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        int interrupcion;
        if (txtInterruption.getText().toString().length()>0){
            interrupcion=Integer.parseInt(txtInterruption.getText().toString());
        }else{
            txtInterruption.setText("0");
            interrupcion=0;
        }
        try {
            Date fechaStart=formato.parse(txtStart.getText().toString());
            Date fechaStop=formato.parse(txtStop.getText().toString());

            long diferencia=fechaStop.getTime()-fechaStart.getTime();
            int minutos= (int) (diferencia/1000/60)-interrupcion;
            txtDelta.setText(Integer.toString(minutos));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private void cargarFechaStart() {
        SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date=new Date();
        String fecha=formato.format(date);
        txtStart.setText(fecha);
    }
}
