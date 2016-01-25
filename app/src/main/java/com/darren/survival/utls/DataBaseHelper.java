package com.darren.survival.utls;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Darren on 2016/1/5 0005.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_RECIPE = "create table recipe (" +
            "id integer primary key autoincrement, " +
            "target text, " +
            "targetID text, " +
            "materialIDs text, " +
            "materialAmounts text" +
            "toolIDs text, " +
            "needFire integer)";

    private Context context;
    private CraftingManager craftingManager;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RECIPE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
            initDataBase();
        }
    }

    private void initDataBase() {
    }
}
