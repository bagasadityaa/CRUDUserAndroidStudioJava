package com.kelompok2.pesanantar.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //nama database
    public static final String DATABASE_NAME = "pesanantar.db";
    //nama table
    public static final String TABLE_NAME = "pesanantar_table";
    //versi database
    private static final int DATABASE_VERSION = 1;
    //table field
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "EMAIL";


    private SQLiteDatabase myDb;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase myDb = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase myDb) {
        myDb.execSQL("create table pesanantar_table(id integer primary key autoincrement," + "name text null," + "password text null,"+"email integer null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void open() throws SQLException {
        myDb = this.getWritableDatabase();
    }
    //metode untuk tambah data

    public boolean insertData(String id,String name, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,password);
        contentValues.put(COL_4,email);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == 0)
            return false;
        else
            return true;
    }


    //metode untuk mengambil data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from pesanantar_table", null);
        return res;
    }



    //metode untuk merubah data
    public boolean updateData(String id,String name,String password,String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,password);
        contentValues.put(COL_4,email);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
        return true;
    }

    //metode untuk menghapus data
    public int deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }

    public boolean checkUser(String name, String password){
        String[] columns = {COL_1};
        SQLiteDatabase db =  getReadableDatabase();
        String selection = COL_4 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { name, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }
}
