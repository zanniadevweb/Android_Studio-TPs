package com.example.tp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GestPlatsActivity extends AppCompatActivity {

    private Button b_supprimer;
    private EditText et_nouveau;
    private Button b_ajouter;
    private LinearLayout ll_listeCheckbox;
    private ArrayList<CheckBox> lstCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestplats);

        ll_listeCheckbox=findViewById(R.id.ll_listeCheckbox);
        b_supprimer = findViewById(R.id.b_supprimer);
        b_ajouter = findViewById(R.id.b_ajouter);
        et_nouveau = findViewById(R.id.et_nouveau);
        lstCheck = new ArrayList<CheckBox>();
        Modele.initPlats();
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
