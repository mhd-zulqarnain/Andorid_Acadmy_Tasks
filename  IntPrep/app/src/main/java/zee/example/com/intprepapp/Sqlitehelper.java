package zee.example.com.intprepapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Zul Qarnain on 3/6/2018.
 */

public class Sqlitehelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test";
    private static final String TABLE_NAME = "my_table";
    private static final String NAME = "name";
    private static final String ROLL = "roll";
    private static final int DB_VERSION = 4 ;

   /* private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS" + TABLE_NAME + " ( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            NAME + "VARCHAR(100)," +
            ROLL + "VARCHAR(100))";*/

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
             " rid INTEGER PRIMARY KEY AUTOINCREMENT , " +
            NAME + " VARCHAR(100) ," +
            ROLL + " VARCHAR(100) " +
            ") ";

    public Sqlitehelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Log.d("TAG", "oCreate: DB Created");

        } catch (Exception e) {
            Log.d("TAG", "onCreate: Exception"+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertData(String name, String roll) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NAME, name);
        content.put(ROLL, roll);
        return db.insert(TABLE_NAME, null, content);
    }
}
