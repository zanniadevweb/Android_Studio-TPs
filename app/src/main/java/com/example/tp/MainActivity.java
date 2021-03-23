package com.example.tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

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
    private Button b_gestionplats;
    int ind;

    private TypePlatDAO unTypePlatDAO;
    private PlatDAO unPlatDAO;
    public ArrayList<Plat> listePlatsRecherche;

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
        b_gestionplats = findViewById(R.id.b_gestionplats);

        Modele.initEntrees();
        Modele.initPlats();
        Modele.initDesserts();
        affSpinnerEntree();
        affSpinnerPlat();
        affSpinnerDessert();

        ind = Modele.newCommande();

        // ------------------------ Méthode de récupération liste plats par base de données
        // -___________________________________________TypePlat______________________________-

        unTypePlatDAO = new TypePlatDAO(this); // Table typePlat créée en premier lieu

        // -___________________________________________Plat______________________________-

        unPlatDAO = new PlatDAO(this); // Table Plat créée en second lieu

        listePlatsRecherche = unPlatDAO.getPlats();

        for (Plat unPlat : listePlatsRecherche ) {
            Log.d("onCreate", unPlat.toString());
        }

        Log.d("onCreate", unPlatDAO.getPlats().toString());

        // ------------------------ Méthode de récupération liste plats par base de données

        s_qte.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               //et_qte.setText(position  + "");
               //Log.d("testLog",""+position);
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

                        if (editable.toString().length() > 0) {

                            int valeurEntiere = Integer.parseInt(editable.toString())-1;

                            if (valeurEntiere > 10) {
                                s_qte.setSelection(stringArray.length-1);
                            }
                            else {
                                s_qte.setSelection(valeurEntiere);
                            }
                        }

               // OU


                /*if (editable.toString().length() > 0) {

                    int indice = Integer.parseInt(editable.toString());
                    if (indice <= 10 && indice > 0) {
                        s_qte.setSelection(Integer.parseInt(editable.toString())-1);
                    } else {
                        s_qte.setSelection(0);
                    }
                }*/
                }
        });

        b_gestionplats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent ouvertureActivity = new Intent(MainActivity.this,GestPlatsActivity.class);
                startActivity(ouvertureActivity);
            }
        });


        b_ajouter = (Button) findViewById(R.id.b_ajouter);
        b_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantite = Integer.parseInt(et_qte.getText().toString());
                if (quantite > 0) {
                    int indice_entree = s_entrees.getSelectedItemPosition();
                    if (indice_entree > 0) {
                        String entree = (getResources().getStringArray(R.array.entrees))[indice_entree];
                        Modele.lesCommandes.get(ind).getLesEntrees().put(entree, quantite);
                    }

                    int indice_plat = s_plats.getSelectedItemPosition();
                    if (indice_plat > 0) {
                        String plat = (getResources().getStringArray(R.array.plats))[indice_plat];
                        Modele.lesCommandes.get(ind).getLesPlats().put(plat, quantite);
                    }

                    int indice_dessert = s_desserts.getSelectedItemPosition();
                    if (indice_dessert > 0) {
                        String dessert = (getResources().getStringArray(R.array.desserts))[indice_dessert];
                        Modele.lesCommandes.get(ind).getLesDesserts().put(dessert, quantite);
                    }

                }

                tv_recap.setText("");
                // parcours du Hashtable entrées :
                Iterator iterateur = Modele.lesCommandes.get(ind).getLesEntrees().keySet().iterator();
                String cle;

                while (iterateur.hasNext()) {
                    cle = (String) iterateur.next();
                    tv_recap.append(cle + " : " + Modele.lesCommandes.get(ind).getLesEntrees().get(cle) + "\n");
                }
                // parcours du Hashtable plats :
                iterateur = Modele.lesCommandes.get(ind).getLesPlats().keySet().iterator();
                while (iterateur.hasNext()) {
                    cle = (String) iterateur.next();
                    tv_recap.append(cle + " : " + Modele.lesCommandes.get(ind).getLesPlats().get(cle) + "\n");
                }
                // parcours du Hashtable desserts :
                iterateur = Modele.lesCommandes.get(ind).getLesDesserts().keySet().iterator();
                while (iterateur.hasNext()) {
                    cle = (String) iterateur.next();
                    tv_recap.append(cle + " : " + Modele.lesCommandes.get(ind).getLesDesserts().get(cle) + "\n");
                }

                s_entrees.setSelection(0);
                s_plats.setSelection(0);
                s_desserts.setSelection(0);

            }
        });


        s_entrees = (Spinner) findViewById(R.id.s_entrees);
        s_entrees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("testLog", ((TextView) view).getText().toString());
                Log.d("testLog", (getResources().getStringArray(R.array.entrees))[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void affSpinnerEntree() {

        // Méthode Modèle
        ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1);
        for (int i=0; i < Modele.lesEntrees.size() ; i++) {
            adapter.add(Modele.lesEntrees.get(i));
        }
        s_entrees.setAdapter(adapter);

    }

    public void affSpinnerPlat() {
        // Méthode Modèle
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1);
        for (int i=0; i < Modele.lesPlats.size() ; i++) {
            adapter.add(Modele.lesPlats.get(i));
        }
        s_plats.setAdapter(adapter);*/

        // Méthode Base de données
        listePlatsRecherche = unPlatDAO.getPlats();

        ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1);
        for (int i=0; i < listePlatsRecherche.size() ; i++) {
            adapter.add(listePlatsRecherche.get(i).getLibelleP());
        }
        /*for (Plat unPlat : listePlatsRecherche ) {
            adapter.add(unPlat.toString());
        }*/
        s_entrees.setAdapter(adapter);
    }

    public void affSpinnerDessert() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1);
        for (int i=0; i < Modele.lesDesserts.size() ; i++) {
            adapter.add(Modele.lesDesserts.get(i));
        }
        s_desserts.setAdapter(adapter);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_parametrage:
                Intent ouvertureParametrage = new Intent(MainActivity.this, ParametrageActivity.class);
                startActivity(ouvertureParametrage);
                break;

        }
        return super.onOptionsItemSelected(item);
    }*/

    //}
}
