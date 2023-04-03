package com.example.contact.SQLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.contact.Model.FavModel;

import java.util.ArrayList;

public class SqliteHelper extends SQLiteOpenHelper {

    //Database Variable
    private static final String DB_NAME = "emp_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Fav_contact";


    //Employee Variable
    private static final String emp_id = "id";
    private static final String name = "name";
    private static final String number = "number";


    public SqliteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + emp_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + name + " TEXT,"
                + number + " TEXT)";

        db.execSQL(query);

    }

    public void add(String name1, String number1){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(name, name1);
        values.put(number, number1);

        
        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<FavModel> readEmp() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorEmp = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<FavModel> empList = new ArrayList<>();

        if (cursorEmp.moveToFirst()) {
            do {
                empList.add(new FavModel(cursorEmp.getString(1),
                        cursorEmp.getString(2)));
            } while (cursorEmp.moveToNext());
        }
        cursorEmp.close();
        return empList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//    public Cursor fetchdatabyfilter(String inputText,String filtercolumn) throws SQLException {
//        Cursor row = null;
//        String query = "SELECT * FROM "+ SqliteHelper.TABLE_NAME;
//        if (inputText == null  ||  inputText.length () == 0)  {
//            //row =datbase.rawQuery(query, null);
//        }else {
//            query = "SELECT * FROM "+SqliteHelper.TABLE_NAME+" WHERE "+filtercolumn+" like '%"+inputText+"%'";
//           // row = database.rawQuery(query, null);
//        }
//        if (row != null) {
//            row.moveToFirst();
//        }
//        return row;
//    }
}
