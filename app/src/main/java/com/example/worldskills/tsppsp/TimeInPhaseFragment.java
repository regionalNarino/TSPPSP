package com.example.worldskills.tsppsp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.tsppsp.Other.Conexion;
import com.example.worldskills.tsppsp.Other.Variables;

import org.w3c.dom.Text;


public class TimeInPhaseFragment extends Fragment {
    Button guardarTiempo;
    EditText tiempo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_time_in_phase, container, false);

        guardarTiempo=view.findViewById(R.id.btnGuardarTiempo);
        tiempo=view.findViewById(R.id.txtTiempoFragment);


        return view;
    }



    public interface OnFragmentInteractionListener {
    }
}
