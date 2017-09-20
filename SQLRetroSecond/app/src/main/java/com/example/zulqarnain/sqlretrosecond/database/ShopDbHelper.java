package com.example.zulqarnain.sqlretrosecond.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.zulqarnain.sqlretrosecond.Model.ShopProducts;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/20/2017.
 */


public class ShopDbHelper extends SQLiteOpenHelper {

    private final static String PRODUCT_TABLE_NAME = "product";
    private final static String PRODUCT_ID = "pid";
    private final static String PRODUCT_NAME = "pName";
    private final static String PRODUCT_PRICE = "pPrice";
    private final static String DB_NAME = "shoppDb.db";
    private final static int DB_VERSION = 1;

    private final static String CREATE_PRODUCT_TABLE = " CREATE TABLE IF NOT EXISTS " +
            PRODUCT_TABLE_NAME + "(" +PRODUCT_ID+ " INTEGER PRIMARY KEY ," +
            PRODUCT_NAME + " VARCHAR(100)," +
            PRODUCT_PRICE + " INTEGER(100) " +
            ")";

    private Context context;

    public ShopDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PRODUCT_TABLE);
        Log.d("cra", "onCreate: called");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insert (ShopProducts shopProducts){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT_ID,shopProducts.product_id);
        contentValues.put(PRODUCT_NAME,shopProducts.product_name);
        contentValues.put(PRODUCT_PRICE,shopProducts.product_price);

       return db.insert(PRODUCT_TABLE_NAME,null,contentValues);
    }

    public ArrayList<ShopProducts> getProduct(int id){
        ArrayList<ShopProducts> product_list= new ArrayList<ShopProducts>();

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from product where pid ="+id,null);
        cursor.moveToNext();
        while (cursor.isAfterLast()==false){
            product_list.add(new ShopProducts(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        return product_list;
    }
    public ArrayList<ShopProducts> getAllProducts(){
        ArrayList<ShopProducts> product_list= new ArrayList<ShopProducts>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+PRODUCT_TABLE_NAME,null);
        res.moveToNext();
        while (res.isAfterLast()==false){
            product_list.add(new ShopProducts(res.getInt(0),res.getString(1),res.getInt(2)));
            res.moveToNext();
        }
        return product_list;
    }
}


