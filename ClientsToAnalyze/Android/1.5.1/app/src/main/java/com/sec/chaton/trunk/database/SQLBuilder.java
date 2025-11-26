package com.sec.chaton.trunk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SQLBuilder {
    private StringBuilder selection = new StringBuilder();
    private ArrayList selectionArgs = new ArrayList();
    private String table;

    private String getSelection() {
        return this.selection.toString();
    }

    private String[] getSelectionArgs() {
        return (String[]) this.selectionArgs.toArray(new String[this.selectionArgs.size()]);
    }

    public int delete(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.delete(this.table, getSelection(), getSelectionArgs());
    }

    public long insert(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insertOrThrow(this.table, null, contentValues);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        return sQLiteDatabase.query(this.table, null, getSelection(), getSelectionArgs(), str, str2, str3);
    }

    public SQLBuilder table(String str) {
        this.table = str;
        return this;
    }

    public int update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.update(this.table, contentValues, getSelection(), getSelectionArgs());
    }

    public SQLBuilder where(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || strArr.length == 0) {
            return this;
        }
        if (this.selection.length() > 0) {
            this.selection.append(" AND ");
        }
        this.selection.append(str);
        for (String str2 : strArr) {
            this.selectionArgs.add(str2);
        }
        return this;
    }
}
