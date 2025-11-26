package com.sec.chaton.smsplugin;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: SuggestionsProvider.java */
/* renamed from: com.sec.chaton.smsplugin.h */
/* loaded from: classes.dex */
class C3874h implements CrossProcessCursor {

    /* renamed from: a */
    Cursor f13936a;

    /* renamed from: b */
    int f13937b;

    /* renamed from: c */
    int f13938c;

    /* renamed from: e */
    final /* synthetic */ SuggestionsProvider f13940e;

    /* renamed from: d */
    ArrayList<C3904i> f13939d = new ArrayList<>();

    /* renamed from: f */
    private String[] f13941f = {"suggest_intent_data", "suggest_intent_action", "suggest_intent_extra_data", "suggest_text_1"};

    public C3874h(SuggestionsProvider suggestionsProvider, Cursor cursor, String str) {
        this.f13940e = suggestionsProvider;
        this.f13936a = cursor;
        this.f13937b = cursor.getColumnCount();
        try {
            m14949a();
        } catch (SQLiteException e) {
            this.f13939d.clear();
        }
    }

    @Override // android.database.Cursor
    public int getCount() {
        return this.f13939d.size();
    }

    /* renamed from: a */
    private void m14949a() {
        int columnIndex = this.f13936a.getColumnIndex("snippet");
        int count = this.f13936a.getCount();
        String str = null;
        int i = 0;
        while (i < count) {
            this.f13936a.moveToPosition(i);
            String string = this.f13936a.getString(columnIndex);
            if (TextUtils.equals(str, string)) {
                string = str;
            } else {
                this.f13939d.add(new C3904i(this, i, string));
            }
            i++;
            str = string;
        }
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i, CursorWindow cursorWindow) {
        int count = getCount();
        if (i >= 0 && i <= count + 1) {
            cursorWindow.acquireReference();
            try {
                int position = getPosition();
                cursorWindow.clear();
                cursorWindow.setStartPosition(i);
                int columnCount = getColumnCount();
                cursorWindow.setNumColumns(columnCount);
                while (moveToPosition(i) && cursorWindow.allocRow()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        }
                        String string = getString(i2);
                        if (string != null) {
                            if (cursorWindow.putString(string, i, i2)) {
                                i2++;
                            } else {
                                cursorWindow.freeLastRow();
                                break;
                            }
                        } else if (cursorWindow.putNull(i, i2)) {
                            i2++;
                        } else {
                            cursorWindow.freeLastRow();
                            break;
                        }
                    }
                    i++;
                }
                moveToPosition(position);
            } catch (IllegalStateException e) {
            } catch (Throwable th) {
                cursorWindow.releaseReference();
                throw th;
            }
            cursorWindow.releaseReference();
        }
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return ((CrossProcessCursor) this.f13936a).onMove(i, i2);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return this.f13937b + this.f13941f.length;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        for (int i = 0; i < this.f13941f.length; i++) {
            if (this.f13941f[i].equals(str)) {
                return i + this.f13937b;
            }
        }
        return this.f13936a.getColumnIndex(str);
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        String[] columnNames = this.f13936a.getColumnNames();
        String[] strArr = new String[columnNames.length + this.f13941f.length];
        for (int i = 0; i < columnNames.length; i++) {
            strArr[i] = columnNames[i];
        }
        for (int i2 = 0; i2 < this.f13941f.length; i2++) {
            strArr[columnNames.length + i2] = this.f13941f[i2];
        }
        return strArr;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i) {
        if (i < 0 || i >= this.f13939d.size()) {
            return false;
        }
        this.f13938c = i;
        this.f13936a.moveToPosition(this.f13939d.get(i).f14024c);
        return true;
    }

    @Override // android.database.Cursor
    public boolean move(int i) {
        return moveToPosition(this.f13938c + i);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        return moveToPosition(this.f13939d.size() - 1);
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        return moveToPosition(this.f13938c + 1);
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        return moveToPosition(this.f13938c - 1);
    }

    @Override // android.database.Cursor
    public String getString(int i) {
        if (i < this.f13937b) {
            return this.f13936a.getString(i);
        }
        C3904i c3904i = this.f13939d.get(this.f13938c);
        switch (i - this.f13937b) {
            case 0:
                return Uri.parse("content://mms-sms/search").buildUpon().appendQueryParameter("pattern", c3904i.m15077a()).build().toString();
            case 1:
                return "android.intent.action.SEARCH";
            case 2:
                return c3904i.m15077a();
            case 3:
                return c3904i.m15077a();
            default:
                return null;
        }
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13936a.close();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        this.f13936a.copyStringToBuffer(i, charArrayBuffer);
    }

    @Override // android.database.Cursor
    public void deactivate() {
        this.f13936a.deactivate();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i) {
        return null;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        return 0;
    }

    @Override // android.database.Cursor
    public String getColumnName(int i) {
        return null;
    }

    @Override // android.database.Cursor
    public double getDouble(int i) {
        return 0.0d;
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public float getFloat(int i) {
        return 0.0f;
    }

    @Override // android.database.Cursor
    public int getInt(int i) {
        return 0;
    }

    @Override // android.database.Cursor
    public long getLong(int i) {
        return 0L;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return this.f13938c;
    }

    @Override // android.database.Cursor
    public short getShort(int i) {
        return (short) 0;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        return this.f13938c >= this.f13939d.size();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        return this.f13938c < 0;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.f13936a.isClosed();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return this.f13938c == 0;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return this.f13938c == this.f13939d.size() + (-1);
    }

    @Override // android.database.Cursor
    public int getType(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isNull(int i) {
        return false;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.f13936a.registerContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f13936a.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        return false;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return this.f13936a.respond(bundle);
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.f13936a.setNotificationUri(contentResolver, uri);
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.f13936a.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f13936a.unregisterDataSetObserver(dataSetObserver);
    }
}
