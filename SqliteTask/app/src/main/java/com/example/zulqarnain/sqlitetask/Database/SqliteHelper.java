package com.example.zulqarnain.sqlitetask.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.zulqarnain.sqlitetask.model.Student;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/24/2017.
 */

public class SqliteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mydb";
    private static final String DB_TABLE = "table_name";
    private static final int DB_VERSION = 2;
    private static final String NAME = "name";
    private static final String CLASS = "class";
    private static final String TABLE_VERSION = "version";
    private static final String TIMESPAM= "time";
    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            NAME + " VARCHAR(100) , " +
            CLASS + " VARCHAR(100) ," +
            TABLE_VERSION+ " VARCHAR(20), "+
            TIMESPAM+ "  VARCHAR(20) "+
            ")";

    //create table tablename(integer autoincrement ,name varchar(100));
        public SqliteHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Log.d("database", "onCreate: called");
        } catch (Exception e) {
            Log.d("database ", "onCreate: " + e);
        }
    }

    public long insetData(String name,String mclass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NAME, name);
        content.put(CLASS, mclass);
        content.put(TABLE_VERSION,0);
        content.put(TIMESPAM,getUnixTime());
        return db.insert(DB_TABLE, null, content);

    }

    public void updateRecord(String name,String id){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int version =getVersion(id);

        contentValues.put(NAME,name);
        contentValues.put(TABLE_VERSION,++version);
        db.update(DB_TABLE,contentValues," _id ="+id,null);
    }
    public ArrayList<Student> getStudentData(){
        ArrayList<Student> studentList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DB_TABLE,null);
        while (cursor.moveToNext()){
            int id= cursor.getInt(0);
            String name = cursor.getString(1);
            String mClass = cursor.getString(2);
            Student std =new Student(id,name,mClass);
            studentList.add(std);
        }
        return studentList;
    }

    public void delData(String name){
        SQLiteDatabase db =getWritableDatabase();
//        db.rawQuery("delete from "+DB_TABLE+" where "+NAME+" ="+name,null);
        db.delete(DB_TABLE," _id "+"=?",new String[]{name});
    }

    public String getUnixTime(){
        return String.valueOf(System.currentTimeMillis()/1000L);
    }
    public int getVersion(String id){
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor = db.rawQuery("select version from "+DB_TABLE+" where _id =?",new String[]{id});
        cursor.moveToNext();
        int version = cursor.getInt(0);
        return  version;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
