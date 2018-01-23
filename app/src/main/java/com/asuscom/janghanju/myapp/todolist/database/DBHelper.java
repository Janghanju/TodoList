package com.asuscom.janghanju.myapp.todolist.database;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.asuscom.janghanju.myapp.todolist.MemoVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MacBook on 2018. 1. 18..
 */

public class DBHelper extends SQLiteOpenHelper {

    public  DBHelper(Context context) {
        super(context, DBContract.DB_NAME, null, 1);

    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.DBCreate.DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long saveMemo(MemoVO vo) {

        SQLiteDatabase dbConn = this.getWritableDatabase();
        ContentValues sqlValues = new ContentValues();

        sqlValues.put(DBContract.DBColumn.MEMO_DATE, vo.getStrDate());
        sqlValues.put(DBContract.DBColumn.MEMO_TIME, vo.getStrTime());
        sqlValues.put(DBContract.DBColumn.MEMO_TEXT, vo.getStrMemo());

        long newId = dbConn.insert(DBContract.DB_TABLE, null, sqlValues);
        return newId;

    }

    public List<MemoVO> getAllList() {

        List<MemoVO> memos = new ArrayList<MemoVO>();

        SQLiteDatabase dbConn = this.getReadableDatabase();

        String[] projection = {
                DBContract.DBColumn._ID,
                DBContract.DBColumn.MEMO_DATE,
                DBContract.DBColumn.MEMO_TIME,
                DBContract.DBColumn.MEMO_TEXT
        };

        Cursor cursor = dbConn.query(
                DBContract.DB_TABLE,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()) {

            MemoVO vo = new MemoVO(
                    cursor.getString(cursor.getColumnIndex(DBContract.DBColumn.MEMO_DATE)),
                    cursor.getString(cursor.getColumnIndex(DBContract.DBColumn.MEMO_TIME)),
                    cursor.getString(cursor.getColumnIndex(DBContract.DBColumn.MEMO_TEXT))
            );
        }
        return memos;
    }

    // id를 삭제
    public void delete(long id) {

        SQLiteDatabase dbConn = this.getWritableDatabase();

        String[] deleteArgs = new String[] {String.valueOf(id)};

        dbConn.delete(DBContract.DB_TABLE,
                DBContract.DBColumn._ID + " = ?",
                deleteArgs);

    }

}
