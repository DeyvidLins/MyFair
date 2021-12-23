package com.example.myfair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.view.View;

public class FragmentMercearia extends Fragment {

    private CheckBox checkBox;
    private View view;
    private Dados dao;
    private Compra comp = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_mercearia, container, false);

        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        boolean isMyValueChecked = sharedPref.getBoolean("checkbox", false);
        checkBox = (CheckBox) view.findViewById(R.id.checkBox2);
        dao = new Dados(this.getActivity());

        Intent intent = new Intent(getContext(),FragmentMercearia.class);


        checkBox.setChecked(isMyValueChecked);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer result = new StringBuffer();//
                SharedPreferences.Editor editor = sharedPref.edit(); // SharedPreferences - Consiste em uma interface que permite acessar e modificar dados de preferência de usuário.
                editor.putBoolean("checkbox", ((CheckBox) view).isChecked());
                editor.commit();
                if (checkBox.isChecked()) {
                    result.append(checkBox.getText().toString()).append("\n");
                    Toast.makeText(getActivity(), String.format("O item Selecionado foi: %s",result), Toast.LENGTH_LONG).show();//Toas - Mensagem na Tela
                    if (intent.hasExtra("compra")) {
                        comp = intent.getExtras().getParcelable("compra");
                        comp.nome = String.format("%s",result);


                    }
                }

                if (comp == null) {
                    comp = new Compra();
                    comp.setNome(checkBox.getText().toString());
                    long id = dao.insert(comp);

                }

            }
        });


        return view;

    }

}