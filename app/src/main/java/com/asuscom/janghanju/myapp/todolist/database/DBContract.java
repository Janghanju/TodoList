package com.asuscom.janghanju.myapp.todolist.database;

import android.provider.BaseColumns;

/**
 * Created by MacBook on 2018. 1. 18..
 */

public class DBContract {
    public static final String DB_NAME = "mymemo.db";
    public static final String DB_TABLE = "mymemo_table";

    public static class DBColumn implements BaseColumns {
        public static final String MEMO_DATE = "memo_date";
        public static final String MEMO_TIME = "memo_time";
        public static final String MEMO_TEXT = "memo_text";
    }

    public static class DBCreate implements BaseColumns {
        public static final String DB_CREATE =
                " CREATE TABLE IF WOT EXISTS "
                + DB_TABLE + " ( "
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DBColumn.MEMO_DATE + " TEXT NOT NULL, "
                + DBColumn.MEMO_TIME + " TEXT NOT NULL, "
                + DBColumn.MEMO_TEXT + " TEXT NOT NULL ) " ;
    }
}
