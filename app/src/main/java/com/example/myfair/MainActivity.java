package com.example.myfair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.SortedSet;


import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        Adapter adp = new Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adp.addFragment(new FragmentMercearia(), "Mercearia");
        adp.addFragment(new Fragment2(), "Laticínios");
        adp.addFragment(new FragmentCarne(), "Carnes");
        adp.addFragment(new FragmentBebida(), "Bebidas");
        adp.addFragment(new FragmentFrutaVerduraLegume(), "Fruta/Verdura");
        adp.addFragment(new FragmentHigiene(), "Higiene");
        adp.addFragment(new FragmentHigiene(), "Limpeza");


        viewPager.setAdapter(adp);

    }
}

/*package com.example.myfair;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.SortedSet;


public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private Dados dao;
    private Compra comp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        boolean isMyValueChecked = sharedPref.getBoolean("checkbox", false);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        dao = new Dados(MainActivity.this);

        Intent intent = getIntent();
        if (intent.hasExtra("compra")) {
            comp = intent.getExtras().getParcelable("compra");
            comp.nome = "Arroz";


        }

        checkBox.setChecked(isMyValueChecked);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer result = new StringBuffer();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("checkbox", ((CheckBox) view).isChecked());
                editor.commit();
                if (checkBox.isChecked()) {

                    result.append(checkBox.getText().toString()).append("\n"); //Pega o valor do texto do checkbox
                    Toast.makeText(MainActivity.this, String.format("%s", result), Toast.LENGTH_LONG).show();//Toas - Mensagem na Tela
                    startService(new Intent(MainActivity.this, MainActivity.class));


                } else {
                    stopService(new Intent(MainActivity.this, MainActivity.class));
                }


                if (comp == null) {
                    comp = new Compra();
                    comp.setNome(checkBox.getText().toString());
                    long id = dao.insert(comp);

                }
            }
        });

    }
}*/