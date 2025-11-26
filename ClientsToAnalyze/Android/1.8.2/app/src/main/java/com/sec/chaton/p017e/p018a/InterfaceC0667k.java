package com.sec.chaton.p017e.p018a;

import android.database.Cursor;
import android.net.Uri;

/* compiled from: NotifyingAsyncQueryHandler.java */
/* renamed from: com.sec.chaton.e.a.k */
/* loaded from: classes.dex */
public interface InterfaceC0667k {
    void onDeleteComplete(int i, Object obj, int i2);

    void onInsertComplete(int i, Object obj, Uri uri);

    void onQueryComplete(int i, Object obj, Cursor cursor);

    void onUpdateComplete(int i, Object obj, int i2);
}
