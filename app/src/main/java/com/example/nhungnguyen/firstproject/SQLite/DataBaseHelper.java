package com.example.nhungnguyen.firstproject.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nhungnguyen.firstproject.Models.ItemList;
import com.example.nhungnguyen.firstproject.Models.UserItem;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 30;
    private static final String DATABASE_NAME = "abc";
    private static final String TABLE_USER = "user";
    private static final String USER_ID = "id";
    private static final String USER_NAME = "name";
    private static final String USER_AGE = "age";
    private static final String USER_CONTENT = "content";
    private static final String USER_IMAGE = "image";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " ("
                + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_NAME + " TEXT,"
                + USER_AGE + " TEXT," + USER_CONTENT + " TEXT," + USER_IMAGE + " TEXT " + ")";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    // Adding new contact
    public void addUser(UserItem userItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, userItem.getTvUser());
        values.put(USER_AGE, userItem.getTvAge());
        values.put(USER_CONTENT, userItem.getTvContent());
        values.put(USER_IMAGE, userItem.getImgPerson());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    // Getting All Contacts
    public List<ItemList> getAllUsers() {
        List<ItemList> userItemList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UserItem userItem = new UserItem();
                userItem.setId(cursor.getString(0));
                userItem.setTvUser(cursor.getString(1));
                userItem.setTvAge(cursor.getString(2));
                userItem.setTvContent(cursor.getString(3));
                userItem.setImgPerson(cursor.getString(4));
                Log.d("11111", "getAllUsers: " + userItem.getImgPerson());
                userItemList.add(userItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userItemList;
    }


    // Updating single contact
    public int updateUser(UserItem userItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, userItem.getTvUser());
        values.put(USER_AGE, userItem.getTvAge());
        values.put(USER_CONTENT, userItem.getTvContent());
        values.put(USER_IMAGE, userItem.getImgPerson());

        return db.update(TABLE_USER, values, USER_ID + " =?",
                new String[]{String.valueOf(userItem.getId())});
    }

    // Deleting single contact
    public void deleteUser(UserItem userItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, USER_ID + " =?",
                new String[]{String.valueOf(userItem.getId())});
        db.close();
    }


}
