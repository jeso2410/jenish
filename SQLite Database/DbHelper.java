package com.radhey.myapplication.SQLiteHelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "demo_db";
    private static final int VERSION = 2;
    private static final String TABLE_NAME = "register";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_QUERY = "CREATE TABLE register (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name TEXT NOT NULL,\n" +
                "    email TEXT UNIQUE NOT NULL,\n" +
                "    password TEXT NOT NULL,\n" +
                "    gender TEXT CHECK(gender IN ('Male', 'Female', 'Other')),\n" +
                "    phone_no TEXT UNIQUE NOT NULL\n" +
                ");";
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // ✅ Improved: Handle unique constraint errors and return success status
    public boolean registerUserHelper(String name, String email, String password, String gender, String phone_no) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("gender", gender);
        contentValues.put("phone_no", phone_no);

        try {
            long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            sqLiteDatabase.close();
            return result != -1;  // ✅ If -1, insertion failed
        } catch (Exception e) {
            Log.e("DB_ERROR", "Error inserting user: " + e.getMessage());
            return false;  // ✅ Return false on failure
        }
    }

}
