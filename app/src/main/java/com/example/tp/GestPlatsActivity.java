package com.example.tp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Iterator;

public class GestPlatsActivity extends AppCompatActivity {

    private EditText et_nouveau;
    private Button b_ajouter, b_modifier, b_supprimer;
    private LinearLayout ll_listeCheckbox;
    private ArrayList<CheckBox> lstCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestplats);

        ll_listeCheckbox=findViewById(R.id.ll_listeCheckbox);
        b_supprimer = findViewById(R.id.b_supprimer_gest);
        b_modifier = findViewById(R.id.b_modifier_gest);
        b_ajouter = findViewById(R.id.b_ajouter_gest);
        et_nouveau = findViewById(R.id.et_nouveau);
        lstCheck = new ArrayList<CheckBox>();
        Modele.initEntrees();
        Modele.initPlats();
        Modele.initDesserts();
        afficherChk();

        b_ajouter = (Button) findViewById(R.id.b_ajouter_gest);
        b_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = et_nouveau.getText().toString();
                Modele.lesPlats.add(nom);
                afficherChk();
            }
    });

        b_supprimer = (Button) findViewById(R.id.b_supprimer_gest);
        b_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i < lstCheck.size() ; i++) {

                    //TODO
                }
            }
        });

    }

    private void afficherChk(){
        ll_listeCheckbox.removeAllViewsInLayout();
        lstCheck.clear();
        for(String unPlat : Modele.lesPlats){
            CheckBox uneChk = new CheckBox(this);
            uneChk.setText(unPlat);
            lstCheck.add(uneChk);
            ll_listeCheckbox.addView(uneChk);
        }
    }
}
