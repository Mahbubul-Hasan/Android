package com.example.mahbubul.quizcompetition;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsersDB extends SQLiteOpenHelper {

    private static String DB_NAME = "quiz_Competition";
    private static String TABLE_NAME = "users";
    private static String COLUMN_ID = "ID";
    private static String COLUMN_NAME = "userName";
    private static String COLUMN_FULL_NAME = "fullName";
    private static String COLUMN_EMAIL = "email";
    private static String COLUMN_PASSWORD = "password";

    private static int version = 1;

    public UsersDB(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +
                TABLE_NAME + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_FULL_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean create(Users users){
        boolean result = true;
        try{
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_NAME, users.getUserName());
            contentValues.put(COLUMN_FULL_NAME, users.getFullName());
            contentValues.put(COLUMN_EMAIL, users.getEmail());
            contentValues.put(COLUMN_PASSWORD, users.getPassword());

            result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues) > 0;
        } catch (Exception e){
            result = false;
        }
        return result;
    }

    public  Users signIn(String userName, String password){
        Users users = null;

        try{
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE USERNAME = ? AND PASSWORd = ?", new String[]{userName, password});

            if (cursor.moveToFirst()){
                users = new Users();
                users.setID(cursor.getInt(0));
                users.setUserName(cursor.getString(1));
                users.setFullName(cursor.getString(2));
                users.setEmail(cursor.getString(3));
                users.setPassword(cursor.getString(4));

            }
        }catch (Exception e){

        }
        return users;
    }


    public  Users checkUserName(String userName){
        Users users = null;

        try{
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE USERNAME = ?", new String[]{userName});

            if (cursor.moveToFirst()){
                users = new Users();
                users.setID(cursor.getInt(0));
                users.setUserName(cursor.getString(1));
                users.setFullName(cursor.getString(2));
                users.setEmail(cursor.getString(3));
                users.setPassword(cursor.getString(4));

            }
        }catch (Exception e){

        }
        return users;
    }
}
