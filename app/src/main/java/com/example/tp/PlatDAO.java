package com.example.tp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class PlatDAO extends SQLiteOpenHelper {

    public PlatDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Param.base, null, Param.version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table plat ("
                + "idP INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "libelleP TEXT NOT NULL,"
                + "idTP INTEGER, "
                + "FOREIGN KEY (idTP) REFERENCES plat(idTP)) ;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}