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
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.tsppsp.Other.Conexion;
import com.example.worldskills.tsppsp.Other.Variables;


public class DefectsInjectedFragment extends Fragment {
    TextView plan,dld,code,compile,ut,pm;
    View view;

    String fases[]={"PLAN","DLD","CODE","COMPILE","UT","PM"};
    int totalPlan=0;
    int totalDld=0;
    int totalCode=0;
    int totalCompile=0;
    int totalUt=0;
    int totalPm=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_defects_injected, container, false);

        plan=view.findViewById(R.id.planNumber);
        dld=view.findViewById(R.id.dldNumber);
        compile=view.findViewById(R.id.compileNumber);
        ut=view.findViewById(R.id.utNumber);
        pm=view.findViewById(R.id.pmNumber);
        code=view.findViewById(R.id.codeNumber);

        cargarResultados();
        return view;
    }

    private void cargarResultados() {

        for (int i=0; i< fases.length; i++){
            try{
                String sql="select count(id) from defectlog where phaseinjected='"+fases[i]+"' and idproject="+ Variables.id;
                Conexion conexion=new Conexion(getActivity());
                SQLiteDatabase db=conexion.getReadableDatabase();
                Cursor cursor=db.rawQuery(sql,null);
                if (cursor!=null){
                    cursor.moveToNext();
                    plan.setText(cursor.getString(0));
                }
            }catch (Exception e){
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public interface OnFragmentInteractionListener {
    }
}
