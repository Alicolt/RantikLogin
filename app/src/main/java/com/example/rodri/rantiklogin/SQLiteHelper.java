package com.example.rodri.rantiklogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    //DATABASE NAME
    public static final String DATABASE_NAME = "usuarios";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    //TABLE NAME
    public static final String TABLE_USERS = "usuarios";

    public static final String KEY_ID = "id";


    public static final String KEY_NOMBRE= "nombre";


    public static final String KEY_APELLIDOS= "apellido";

    public static final String KEY_USUARIO= "usuario";
    //COLUMN password
    public static final String KEY_PASSWORD = "password";

    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_NOMBRE + " TEXT, "
            + KEY_APELLIDOS + " TEXT, "
            + KEY_USUARIO + " TEXT, "
            + KEY_PASSWORD + " TEXT "
            + " ) ";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }

    //using this method we can add users to user table
    public void addUser(Usuario user) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        values.put(KEY_NOMBRE, user.nombre);
        values.put(KEY_APELLIDOS, user.apellido);
        values.put(KEY_USUARIO, user.usuario);
        values.put(KEY_PASSWORD, user.contraseña);

        // insert row
        long todo_id = db.insert(TABLE_USERS, null, values);
    }

    public Usuario Authenticate(Usuario user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_NOMBRE, KEY_APELLIDOS, KEY_USUARIO, KEY_PASSWORD},//Selecting columns want to query
                KEY_USUARIO + "=?",
                new String[]{user.usuario},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            Usuario user1 = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

            //Match both passwords check they are same or not
            if (user.contraseña.equalsIgnoreCase(user1.contraseña)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean UserExiste(String usuario) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_NOMBRE, KEY_APELLIDOS, KEY_USUARIO, KEY_PASSWORD},//Selecting columns want to query
                KEY_USUARIO + "=?",
                new String[]{usuario},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }
}
