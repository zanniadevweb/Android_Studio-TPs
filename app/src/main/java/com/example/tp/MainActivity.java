package com.example.tp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner s_entrees;
    private Spinner s_plats;
    private Spinner s_desserts;
    private Spinner s_qte;
    private EditText et_qte;
    private EditText et_remarques;
    private Button b_ajouter;
    private Button b_annuler;
    private Button b_enregistrer;
    private TextView tv_recap;
    private RadioButton rb_omni;
    private RadioButton rb_vege;
    private RadioButton rb_veg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s_entrees = findViewById(R.id.s_entrees);
        s_plats = findViewById(R.id.s_plats);
        s_desserts = findViewById(R.id.s_dessert);
        s_qte = findViewById(R.id.s_qte);
        et_qte = findViewById(R.id.et_qte);
        et_remarques = findViewById(R.id.et_remarques) ;
        b_ajouter = findViewById(R.id.b_ajouter);
        b_annuler = findViewById(R.id.b_annuler);
        b_enregistrer = findViewById(R.id.b_enregistrer);
        tv_recap = findViewById(R.id.tv_recap);
        rb_omni = findViewById(R.id.rb_omni);
        rb_vege = findViewById(R.id.rb_vege);
        rb_veg = findViewById(R.id.rb_veg);

        s_qte.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object quantite = s_qte.getSelectedItem();
                et_qte.setText(quantite.toString());
                //et_qte.setText((getResources().getStringArray(R.array.quantity[position])));   ---- NE MARCHE PAS ----
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO
            }
        });

        et_qte.addTextChangedListener (new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //TODO
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //TODO
            }
            @Override
            public void afterTextChanged(Editable editable) {
                String[] stringArray = getResources().getStringArray(R.array.quantity);

                for (int i=0; i < stringArray.length; i++){
                    if ( editable.toString().equals(stringArray[i])) {
                        s_qte.setSelection(i);
                    }
                    /*
                    if (!editable.toString().equals(stringArray[i])) {
                        s_qte.setSelection(stringArray.length-1);
                    }*/
                }
            }
        });

    }
}
