package com.example.pedro.motosapi.Ui.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pedro.motosapi.Model.Motos;
import com.example.pedro.motosapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pedro on 06/11/2016.
 */
public class MotosAdapter extends ArrayAdapter<Motos>{

public MotosAdapter(Context context, List<Motos> motos) {
        super(context, 0, motos);
        }

@NonNull
@Override
public View getView(int position, View convertView, ViewGroup parent) {
       Motos motos = getItem(position);//pegando o objeto da lista

        if (convertView == null){//carregando o arquivo de layout
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_moto, parent, false);
        }
        ImageView imgPoster = (ImageView)convertView.findViewById(R.id.moto_poster);//preenchendo o layout
        TextView txtMarca = (TextView)convertView.findViewById(R.id.moto_marca);
        TextView txtModelo = (TextView)convertView.findViewById(R.id.moto_modelo);
        TextView txtAno = (TextView)convertView.findViewById(R.id.moto_ano);

        if (motos.poster != ""){
        Picasso.with(getContext())
            .load(motos.poster)
            .into(imgPoster);
        txtMarca.setText(motos.marca);
        txtModelo.setText(motos.modelo);
        txtAno.setText(motos.ano);
        }else{
        imgPoster.setImageResource(R.mipmap.ic_launcher);
        }
        return convertView; //retornando o layout preenchido
        }
        }