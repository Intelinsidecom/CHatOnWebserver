package com.sec.chaton.p027e.p028a;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* compiled from: NotifyingAsyncQueryHandler.java */
/* renamed from: com.sec.chaton.e.a.u */
/* loaded from: classes.dex */
public class C1377u extends AsyncQueryHandler {

    /* renamed from: a */
    private WeakReference<InterfaceC1378v> f5162a;

    public C1377u(ContentResolver contentResolver, InterfaceC1378v interfaceC1378v) {
        super(contentResolver);
        m6201a(interfaceC1378v);
    }

    /* renamed from: a */
    public void m6201a(InterfaceC1378v interfaceC1378v) {
        this.f5162a = new WeakReference<>(interfaceC1378v);
    }

    /* renamed from: a */
    public void m6200a() {
        this.f5162a = null;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        InterfaceC1378v interfaceC1378v = this.f5162a == null ? null : this.f5162a.get();
        if (interfaceC1378v != null) {
            interfaceC1378v.onQueryComplete(i, obj, cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onInsertComplete(int i, Object obj, Uri uri) {
        InterfaceC1378v interfaceC1378v = this.f5162a == null ? null : this.f5162a.get();
        if (interfaceC1378v != null) {
            interfaceC1378v.onInsertComplete(i, obj, uri);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onUpdateComplete(int i, Object obj, int i2) {
        InterfaceC1378v interfaceC1378v = this.f5162a == null ? null : this.f5162a.get();
        if (interfaceC1378v != null) {
            interfaceC1378v.onUpdateComplete(i, obj, i2);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        InterfaceC1378v interfaceC1378v = this.f5162a == null ? null : this.f5162a.get();
        if (interfaceC1378v != null) {
            interfaceC1378v.onDeleteComplete(i, obj, i2);
        }
    }
}
