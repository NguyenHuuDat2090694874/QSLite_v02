package com.example.qslite_v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context){ super(context,"TodoDatabase", null, 3);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE TODO(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TITLE TEXT,CONTENT TEXT, DATE TEXT ,TYPE TEXT ,STATUS INTEGER)";
        sqLiteDatabase.execSQL(sql);

        String data = "INSERT INTO TODO VALUES (1, 'Học Java' ,'Học Java cơ bản','27/2/2023','Bình thường', 1)," +
                "(2, 'Học React Native' ,'Học React Native cơ bản','24/3/2023','Khó', 0)," +
                "(3, 'Học Kotlin' ,'Học Kotlin cơ bản','1/4/2023','Dễ', 0)" ;
        sqLiteDatabase.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        if(i != i1)
        {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TODO");
            onCreate(sqLiteDatabase);
        }
    }
}
