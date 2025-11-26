package com.sec.chaton.p017e.p018a;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* compiled from: NotifyingAsyncQueryHandler.java */
/* renamed from: com.sec.chaton.e.a.j */
/* loaded from: classes.dex */
public class C0666j extends AsyncQueryHandler {

    /* renamed from: a */
    private WeakReference f2555a;

    public C0666j(ContentResolver contentResolver, InterfaceC0667k interfaceC0667k) {
        super(contentResolver);
        m3075a(interfaceC0667k);
    }

    /* renamed from: a */
    public void m3075a(InterfaceC0667k interfaceC0667k) {
        this.f2555a = new WeakReference(interfaceC0667k);
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        InterfaceC0667k interfaceC0667k = this.f2555a == null ? null : (InterfaceC0667k) this.f2555a.get();
        if (interfaceC0667k != null) {
            interfaceC0667k.onQueryComplete(i, obj, cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onInsertComplete(int i, Object obj, Uri uri) {
        InterfaceC0667k interfaceC0667k = this.f2555a == null ? null : (InterfaceC0667k) this.f2555a.get();
        if (interfaceC0667k != null) {
            interfaceC0667k.onInsertComplete(i, obj, uri);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onUpdateComplete(int i, Object obj, int i2) {
        InterfaceC0667k interfaceC0667k = this.f2555a == null ? null : (InterfaceC0667k) this.f2555a.get();
        if (interfaceC0667k != null) {
            interfaceC0667k.onUpdateComplete(i, obj, i2);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        InterfaceC0667k interfaceC0667k = this.f2555a == null ? null : (InterfaceC0667k) this.f2555a.get();
        if (interfaceC0667k != null) {
            interfaceC0667k.onDeleteComplete(i, obj, i2);
        }
    }
}
