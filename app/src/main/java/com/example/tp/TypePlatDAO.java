package com.example.tp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class TypePlatDAO extends SQLiteOpenHelper {

    public TypePlatDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Param.base, null, Param.version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table typeplat ("
                + "idTP INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "libelleTP TEXT NOT NULL) ;");

        sqLiteDatabase.execSQL("insert into typeplat (libelleTP) values('entrée', 'plat', 'dessert')");

        // OU

        /*
        ContentValues valeurs = new ContentValues();
        valeurs.put("libelleTP", "entrée");
        valeurs.put("libelleTP", "plat");
        valeurs.put("libelleTP", "dessert");
        sqLiteDatabase.insert("typeplat", null, valeurs);
         */
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private ArrayList<TypePlat> getPlats () {
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
}