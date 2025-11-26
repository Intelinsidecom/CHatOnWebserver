package com.android.common.content;

import android.content.ContentProvider;
import android.database.sqlite.SQLiteTransactionListener;

/* loaded from: classes.dex */
public abstract class SQLiteContentProvider extends ContentProvider implements SQLiteTransactionListener {

    /* renamed from: a */
    private final ThreadLocal<Boolean> f866a = new ThreadLocal<>();
}
