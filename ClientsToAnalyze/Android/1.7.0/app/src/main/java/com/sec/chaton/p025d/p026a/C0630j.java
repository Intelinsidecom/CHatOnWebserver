package com.sec.chaton.p025d.p026a;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* compiled from: NotifyingAsyncQueryHandler.java */
/* renamed from: com.sec.chaton.d.a.j */
/* loaded from: classes.dex */
public class C0630j extends AsyncQueryHandler {

    /* renamed from: a */
    private WeakReference f2195a;

    public C0630j(ContentResolver contentResolver, InterfaceC0626f interfaceC0626f) {
        super(contentResolver);
        m2859a(interfaceC0626f);
    }

    /* renamed from: a */
    public void m2859a(InterfaceC0626f interfaceC0626f) {
        this.f2195a = new WeakReference(interfaceC0626f);
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        InterfaceC0626f interfaceC0626f = this.f2195a == null ? null : (InterfaceC0626f) this.f2195a.get();
        if (interfaceC0626f != null) {
            interfaceC0626f.mo880a(i, obj, cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onInsertComplete(int i, Object obj, Uri uri) {
        InterfaceC0626f interfaceC0626f = this.f2195a == null ? null : (InterfaceC0626f) this.f2195a.get();
        if (interfaceC0626f != null) {
            interfaceC0626f.mo881a(i, obj, uri);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onUpdateComplete(int i, Object obj, int i2) {
        InterfaceC0626f interfaceC0626f = this.f2195a == null ? null : (InterfaceC0626f) this.f2195a.get();
        if (interfaceC0626f != null) {
            interfaceC0626f.mo879a(i, obj, i2);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        InterfaceC0626f interfaceC0626f = this.f2195a == null ? null : (InterfaceC0626f) this.f2195a.get();
        if (interfaceC0626f != null) {
            interfaceC0626f.mo882b(i, obj, i2);
        }
    }
}
