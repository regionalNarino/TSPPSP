package com.example.worldskills.tsppsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class OpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button1:
                Intent uno=new Intent(OpcionesActivity.this,TimeLogActivity.class);
                startActivity(uno);
                break;
            case R.id.button2:
                Intent dos=new Intent(OpcionesActivity.this,DefectLogActivity.class);
                startActivity(dos);
                break;
            case R.id.button3:
                Intent intent=new Intent(OpcionesActivity.this,Main2Activity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
