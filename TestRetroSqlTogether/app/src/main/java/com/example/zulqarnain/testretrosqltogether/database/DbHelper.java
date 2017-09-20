package com.example.zulqarnain.testretrosqltogether.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;

import com.example.zulqarnain.testretrosqltogether.ShopProduct;
import com.example.zulqarnain.testretrosqltogether.database.DbSchema.Table;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/18/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 3;
    private static final String DB_NAME="shoopDb";
    private final static String UID = "_id";

    private final static String DB_CREATE = "CREATE TABLE "
            + DbSchema.Table.PRD_TABLE + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            +DbSchema.Table.cols.PRD_ID + " INTEGER(200), "
            + DbSchema.Table.cols.PRD_NAME+" VARCHAR(255));";

    Context context;
    public DbHelper(Context context) {
        super(context,DB_NAME , null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DB_CREATE);
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }

    public ArrayList<ShopProduct> getProducts(){
        //select * from table
        ArrayList<ShopProduct> products= new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(Table.PRD_TABLE,null,null,null,null,null,null);

        while (cursor.moveToNext()){
            String pName = cursor.getColumnName(cursor.getColumnIndex(Table.cols.PRD_NAME));
            String pPrice = cursor.getColumnName(cursor.getColumnIndex(Table.cols.PRD_PRICE));

            ShopProduct shopProduct = new ShopProduct();
            shopProduct.setName(pName);
            shopProduct.setPrice(pPrice);
            products.add(shopProduct);
        }
        return products;
    }
    public long insert(String id,String name,String price){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Table.cols.PRD_ID , "1");
        contentValues.put(Table.cols.PRD_NAME , "name");
        return getWritableDatabase().insert(Table.PRD_TABLE,null,contentValues);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL(DB_CREATE);
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
}
