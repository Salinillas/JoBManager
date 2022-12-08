package com.example.jobmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {super(context, "Login.db", null, 1);
    }
    //Creamos las bases de datos
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, oficina INTEGER, hora_entrada TEXT, hora_salida TEXT, trabajando TEXT)");
        MyDB.execSQL("create Table admin(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }
    //registro de usuario
    public Boolean insertData(String username, String password, int oficina){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("oficina", oficina);

        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public void insertEntrada(String username, String entrada){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("hora_entrada", entrada);
        String a[] = new String[0];
        MyDB.update("users", contentValues, username, a);
    }
    public void insertSalida(String username, String salida){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("hora_salida", salida);
        String a[] = new String[0];
        MyDB.update("users", contentValues, username, a);
    }
    //chequea el nombre de usuario
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    //chequea la contraseña
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public String getHora_entrada(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor horaEntrada = MyDB.rawQuery("Select hora_entrada from users where username = ?", new String[] {username});
        return horaEntrada.getString(0);
    }
    public String getHora_salida(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor horaSalida = MyDB.rawQuery("Select hora_salida from users where username = ?", new String[]{username});
        return horaSalida.getString(0);
    }
    public int getDiff(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor diff = MyDB.rawQuery("Select julianday(hora_entrada)- julianday(hora_salida) from users where username = ?", new String[]{username});
        return Integer.parseInt(diff.getString(0));
    }

}