package com.example.tp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class PlatDAO extends SQLiteOpenHelper {

    public PlatDAO(@Nullable Context context) {
        super(context, Param.base, null, Param.version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //TODO : une seule classe DAO porte tous les OnCreate de table = c'est là qu'est créée la base de données, mais dans l'idéal il faudrait...
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public ArrayList<Plat> getPlats () {
        ArrayList<Plat> unPlat = null;
        Cursor curseur;
        curseur = this.getReadableDatabase().rawQuery("select * from plat", null);
        unPlat = cursorToPlatArrayList(curseur);

        return unPlat;
    }

    private ArrayList<Plat> cursorToPlatArrayList(Cursor curseur) {
        ArrayList<Plat> unPlat = new ArrayList<Plat>();
        long idP;
        String libelleP;
        long idTP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idP = curseur.getLong(0);
            libelleP = curseur.getString(1);
            idTP = curseur.getLong(2);
            unPlat.add(new Plat(idP, libelleP, idTP));
            curseur.moveToNext();
        }
        return unPlat;
    }

}