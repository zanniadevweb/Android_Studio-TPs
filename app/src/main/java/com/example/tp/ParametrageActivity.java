package com.example.tp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class ParametrageActivity extends AppCompatActivity {


    private Spinner s_entrees;
    private Spinner s_plats;
    private Spinner s_desserts;
    //private Spinner s_qte;
    private Spinner s_selected;
    //private EditText et_remarques;
    private Button b_ajouterElement, b_modifierElement;
    private EditText et_nomAjout,et_nomMod;
    private RadioButton rb_entree,rb_plat,rb_dessert;
    /*
    private Button b_annuler;
    private Button b_enregistrer;
    private TextView tv_recap;
    private RadioButton rb_omni;
    private RadioButton rb_vege;
    private RadioButton rb_veg;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);
      /*
        s_entrees = findViewById(R.id.s_entrees);
        s_plats = findViewById(R.id.s_plats);
        s_desserts = findViewById(R.id.s_dessert);
        s_qte = findViewById(R.id.s_qte);
        et_remarques = findViewById(R.id.et_remarques) ;*/
        b_modifierElement = findViewById(R.id.b_modifierElement);
        b_ajouterElement = findViewById(R.id.b_ajouterElement);
        et_nomAjout = findViewById(R.id.et_nomAjout);
        rb_entree = findViewById(R.id.rb_entree);
        rb_plat = findViewById(R.id.rb_plat);
        rb_dessert = findViewById(R.id.rb_dessert);
        /*
        b_annuler = findViewById(R.id.b_annuler);
        b_enregistrer = findViewById(R.id.b_enregistrer);
        tv_recap = findViewById(R.id.tv_recap);
        rb_omni = findViewById(R.id.rb_omni);
        rb_vege = findViewById(R.id.rb_vege);
        rb_veg = findViewById(R.id.rb_veg);*/

        b_ajouterElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
            String nomAjout = et_nomAjout.getText().toString();
            Log.d("nomAjout", "nomAjout" + nomAjout);
*/

            String nomAjout="";
                if (rb_entree.isChecked()){
                nomAjout = "entrée";
            }
                if (rb_plat.isChecked()){
                nomAjout = "plat";
            }
                if (rb_dessert.isChecked()){
                nomAjout = "dessert";
            }
            String nom = et_nomAjout.getText().toString();
                Log.d("testLog",nomAjout + " - "+nom);
            }
        });

        s_entrees = findViewById(R.id.s_entreesMod);
        s_plats= findViewById(R.id.s_platMod);
        s_desserts = findViewById(R.id.s_dessertMod);
        et_nomMod = findViewById(R.id.et_nomMod);

        s_desserts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s_desserts.getSelectedItemPosition()!=0) {// pour eviter qu'il ne se déclenche lorsqu'il est modifié par un autre spinner
                    s_plats.setSelection(0);
                    s_entrees.setSelection(0);
                    et_nomMod.setText((getResources().getStringArray(R.array.desserts))[position]);
                    s_selected = s_desserts;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s_plats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s_plats.getSelectedItemPosition()!=0) {// pour eviter qu'il ne se déclenche lorsqu'il est modifié par un autre spinner
                    s_desserts.setSelection(0);
                    s_entrees.setSelection(0);
                    et_nomMod.setText((getResources().getStringArray(R.array.plats))[position]);
                    s_selected=s_plats;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s_entrees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s_entrees.getSelectedItemPosition()!=0){// pour eviter qu'il ne se déclenche lorsqu'il est modifié par un autre spinner
                    s_plats.setSelection(0);
                    s_desserts.setSelection(0);
                    et_nomMod.setText((getResources().getStringArray(R.array.entrees))[position]);
                    s_selected=s_entrees;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b_modifierElement = findViewById(R.id.b_modifierElement);
        b_modifierElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_selected!=null){
                    if (et_nomMod.getText().toString().equals(s_selected.getSelectedItem())){
                        Log.d("testLog","Le nouveau texte est le même");
                    }
                    else{
                        Log.d("testLog","Le nouveau texte est different");
                    }
                }
            }
        });
    }
}
