package com.example.zulqarnain.testretrosqltogether.database;

/**
 * Created by Zul Qarnain on 9/18/2017.
 */

public class DbSchema {
    public static class Table{
        public static final String PRD_TABLE="products";
        public static class cols{
            public static final String PRD_ID="pid";
            public static final String PRD_NAME="product_name";
            public static final String PRD_PRICE="product_price";
        }
    }
}
