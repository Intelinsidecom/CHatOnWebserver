package com.sds.coolots.common.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.sds.coolots.common.controller.a */
/* loaded from: classes.dex */
public abstract class AbstractC1241a extends SQLiteOpenHelper {
    public AbstractC1241a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    /* renamed from: a */
    public abstract void mo2843a(SQLiteDatabase sQLiteDatabase);

    /* renamed from: b */
    public abstract void mo2844b(SQLiteDatabase sQLiteDatabase);
}
