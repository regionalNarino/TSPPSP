package com.example.worldskills.tsppsp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TimeInPhaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_time_in_phase, container, false);
        TextView texto=view.findViewById(R.id.saludo);
        texto.setText("hola amiogo");

        return view;
    }

    public interface OnFragmentInteractionListener {
    }
}
