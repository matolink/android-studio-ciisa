package com.example.todociisa;

import static kotlinx.coroutines.CoroutineScopeKt.CoroutineScope;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import kotlinx.coroutines.Dispatchers;
import roomDatabase.entity.Tarea;

public class ListAdapter extends ArrayAdapter<Tarea> {
    public ListAdapter(@NonNull Context context, ArrayList<Tarea> tareas) {
        super(context, 0, tareas);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tarea tarea = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elemento_de_lista_tarea, parent, false);
        }
        TextView tarea_ame = (TextView) convertView.findViewById(R.id.textView3);
        tarea_ame.setText(tarea.getTarea());


//        Button btButton = (Button) convertView.findViewById(R.id.tarea_delete);
//        btButton.setTag(position);
//        btButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = (Integer) view.getTag();
//                Tarea tarea = getItem(position);
//                Log.d("TEST: ", tarea.toString());
//            }
//        });

        return convertView;
    }
}
