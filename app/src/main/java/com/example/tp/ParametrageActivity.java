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
    private Spinner s_entrees_suppr;
    private Spinner s_plats_suppr;
    private Spinner s_desserts_suppr;
    private Spinner s_selected;
    private Button b_ajouterElement, b_modifierElement, b_supprimerElement;
    private EditText et_nomAjout, et_nomMod, et_nomSuppr;
    private RadioButton rb_entree,rb_plat,rb_dessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);

        rb_entree = findViewById(R.id.rb_entree);
        rb_plat = findViewById(R.id.rb_plat);
        rb_dessert = findViewById(R.id.rb_dessert);

        /*______________________________________________________________________________________________________________________________________________________*/
        /*--------------------------------------------------------------------- AJOUT --------------------------------------------------------------------------*/
        /*______________________________________________________________________________________________________________________________________________________*/

        b_ajouterElement = findViewById(R.id.b_ajouterElement);
        et_nomAjout = findViewById(R.id.et_nomAjout);

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

        /*______________________________________________________________________________________________________________________________________________________*/
        /*--------------------------------------------------------------------- SUPPRESSION --------------------------------------------------------------------*/
        /*______________________________________________________________________________________________________________________________________________________*/

        b_supprimerElement = findViewById(R.id.b_supprimerElement);
        et_nomSuppr = findViewById(R.id.et_nomSuppr);

        s_entrees_suppr = findViewById(R.id.s_entreesSuppr);
        s_plats_suppr= findViewById(R.id.s_platSuppr);
        s_desserts_suppr = findViewById(R.id.s_dessertSuppr);

        s_desserts_suppr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s_desserts_suppr.getSelectedItemPosition()!=0) {// pour eviter qu'il ne se déclenche lorsqu'il est modifié par un autre spinner
                    s_plats_suppr.setSelection(0);
                    s_entrees_suppr.setSelection(0);
                    et_nomSuppr.setText((getResources().getStringArray(R.array.desserts))[position]);
                    s_selected = s_desserts_suppr;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s_plats_suppr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s_plats_suppr.getSelectedItemPosition()!=0) {// pour eviter qu'il ne se déclenche lorsqu'il est modifié par un autre spinner
                    s_desserts_suppr.setSelection(0);
                    s_entrees_suppr.setSelection(0);
                    et_nomSuppr.setText((getResources().getStringArray(R.array.plats))[position]);
                    s_selected=s_plats_suppr;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s_entrees_suppr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s_entrees.getSelectedItemPosition()!=0){// pour eviter qu'il ne se déclenche lorsqu'il est modifié par un autre spinner
                    s_plats_suppr.setSelection(0);
                    s_desserts_suppr.setSelection(0);
                    et_nomSuppr.setText((getResources().getStringArray(R.array.entrees))[position]);
                    s_selected=s_entrees_suppr;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b_supprimerElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomSuppr="";
                if (rb_entree.isChecked()){
                    nomSuppr = "entrée";
                }
                if (rb_plat.isChecked()){
                    nomSuppr = "plat";
                }
                if (rb_dessert.isChecked()){
                    nomSuppr = "dessert";
                }
                String nom = et_nomSuppr.getText().toString();
                Log.d("testLog",nomSuppr + " - "+nom);
            }
        });


        /*______________________________________________________________________________________________________________________________________________________*/
        /*--------------------------------------------------------------------- MODIFICATION -------------------------------------------------------------------*/
        /*______________________________________________________________________________________________________________________________________________________*/

        b_modifierElement = findViewById(R.id.b_modifierElement);
        et_nomMod = findViewById(R.id.et_nomMod);

        s_entrees = findViewById(R.id.s_entreesMod);
        s_plats= findViewById(R.id.s_platMod);
        s_desserts = findViewById(R.id.s_dessertMod);

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
