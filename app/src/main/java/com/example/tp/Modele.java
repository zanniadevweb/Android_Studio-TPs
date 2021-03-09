package com.example.tp;

import java.util.ArrayList;

public class Modele {


    public static ArrayList<Commande> lesCommandes = new ArrayList<Commande>();

    public static int newCommande() {
        Commande uneCommande = new Commande();
        lesCommandes.add(uneCommande);
        return lesCommandes.indexOf(uneCommande);
    }

    public static ArrayList<String> lesPlats = new ArrayList<String>();

    public static void initPlats() {
        lesPlats.add("Aucun");
        lesPlats.add("Tournedos de boeuf rossini");
        lesPlats.add("Filet de canard");
        lesPlats.add("Magret de canard");
        lesPlats.add("Faux filet");
        lesPlats.add("Risottos aux legumes et parmesan");
        lesPlats.add("Lasagnes à la ratatouille");
    }
}