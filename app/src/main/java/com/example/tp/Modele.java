package com.example.tp;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Modele {
    public static ArrayList<Commande> lesCommandes = new ArrayList<Commande>();

    public static int newCommande() {
        Commande uneCommande = new Commande();
        lesCommandes.add(uneCommande);
        return lesCommandes.indexOf(uneCommande);
    }



    public static ArrayList<String> lesEntrees = new ArrayList<String>();

    public static void initEntrees() {
        lesEntrees.add("Aucun");
        lesEntrees.add("Foie gras fait maison");
        lesEntrees.add("Saumon fumé");
        lesEntrees.add("Salade verte");
        lesEntrees.add("Gambas poêlées");
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

    public static ArrayList<String> lesDesserts = new ArrayList<String>();

    public static void initDesserts() {
        lesDesserts.add("Aucun");
        lesDesserts.add("Tiramisu maison");
        lesDesserts.add("Iles flottantes");
        lesDesserts.add("Crème brûlée maison");
        lesDesserts.add("Salade de fruits frais");
        lesDesserts.add("Mousse au chocolat");;
    }
}