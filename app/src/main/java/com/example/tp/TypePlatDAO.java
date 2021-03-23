package com.example.tp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class TypePlatDAO extends SQLiteOpenHelper {

    public TypePlatDAO(@Nullable Context context) {
        super(context, Param.base, null, Param.version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table typeplat ("
                + "idTP INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "libelleTP TEXT NOT NULL) ;");

        sqLiteDatabase.execSQL("insert into TypePlat (libelleTP) values('entrée'), ('plat'), ('dessert')");

        // OU

        /*
        ContentValues valeurs = new ContentValues();
        valeurs.put("libelleTP", "entrée");
        valeurs.put("libelleTP", "plat");
        valeurs.put("libelleTP", "dessert");
        sqLiteDatabase.insert("typeplat", null, valeurs);
         */

        sqLiteDatabase.execSQL("create table plat ("
                + "idP INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "libelleP TEXT NOT NULL,"
                + "idTP INTEGER, "
                + "FOREIGN KEY (idTP) REFERENCES plat(idTP)) ;");

        sqLiteDatabase.execSQL("insert into Plat (libelleP, idTP) values('Aucun',1), ('Foie gras fait maison',1), " +
                "('Saumon fumé',1), ('Salade verte',1), ('Gambas pôelées',1) ");

        sqLiteDatabase.execSQL("insert into Plat (libelleP, idTP) values('Aucun',2), ('Tournedos de boeuf rossini',2), " +
                "('Filet de canard',2), ('Magret de canard',2), ('Faux filet',2), ('Risottos aux legumes et parmesan',2), ('Lasagnes à la ratatouille',2) ");

        sqLiteDatabase.execSQL("insert into Plat (libelleP, idTP) values('Aucun',3), ('Tiramisu maison',3), " +
                "('Iles flottantes',3), ('Crème brûlée maison',3), ('Salade de fruits frais',3), ('Mousse au chocolat',3) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /*
    public ArrayList<TypePlat> getPlats () {
        ArrayList<TypePlat> uneListePlats = null;
        Cursor curseur;
        curseur = this.getReadableDatabase().rawQuery("select * from typeplat", null);
        uneListePlats = cursorToTypePlatArrayList(curseur);

        return uneListePlats;
    }

    private ArrayList<TypePlat> cursorToTypePlatArrayList(Cursor curseur) {
        ArrayList<TypePlat> uneListePlats = new ArrayList<TypePlat>();
        long idTP;
        String libelleTP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idTP = curseur.getLong(0);
            libelleTP = curseur.getString(1);
            uneListePlats.add(new TypePlat(idTP, libelleTP));
            curseur.moveToNext();
        }
        return uneListePlats;
    }
    */

}