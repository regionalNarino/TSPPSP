package com.example.worldskills.tsppsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button3:
                Intent intent=new Intent(OpcionesActivity.this,Main2Activity.class);
                startActivity(intent);
        }
    }
}