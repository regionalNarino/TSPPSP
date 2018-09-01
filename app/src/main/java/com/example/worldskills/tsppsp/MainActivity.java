package com.example.worldskills.tsppsp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listProjects;
    EditText nameProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProjects=findViewById(R.id.listProjects);
        nameProject=findViewById(R.id.txtNameProject);

        cargarList();

    }

    private void cargarList() {

    }

    public void onClick(View view) {
        adicionar();
    }

    private void adicionar() {
    }
}
