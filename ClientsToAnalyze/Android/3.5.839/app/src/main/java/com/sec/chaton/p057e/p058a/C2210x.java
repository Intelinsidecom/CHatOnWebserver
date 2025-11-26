package com.sec.chaton.p057e.p058a;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* compiled from: NotifyingAsyncQueryHandler.java */
/* renamed from: com.sec.chaton.e.a.x */
/* loaded from: classes.dex */
public class C2210x extends AsyncQueryHandler {

    /* renamed from: a */
    private WeakReference<InterfaceC2211y> f7897a;

    public C2210x(ContentResolver contentResolver, InterfaceC2211y interfaceC2211y) {
        super(contentResolver);
        m10065a(interfaceC2211y);
    }

    /* renamed from: a */
    public void m10065a(InterfaceC2211y interfaceC2211y) {
        this.f7897a = new WeakReference<>(interfaceC2211y);
    }

    /* renamed from: a */
    public void m10064a() {
        this.f7897a = null;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        InterfaceC2211y interfaceC2211y = this.f7897a == null ? null : this.f7897a.get();
        if (interfaceC2211y != null) {
            interfaceC2211y.mo7100a(i, obj, cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onInsertComplete(int i, Object obj, Uri uri) {
        InterfaceC2211y interfaceC2211y = this.f7897a == null ? null : this.f7897a.get();
        if (interfaceC2211y != null) {
            interfaceC2211y.mo7101a(i, obj, uri);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onUpdateComplete(int i, Object obj, int i2) {
        InterfaceC2211y interfaceC2211y = this.f7897a == null ? null : this.f7897a.get();
        if (interfaceC2211y != null) {
            interfaceC2211y.mo7099a(i, obj, i2);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        InterfaceC2211y interfaceC2211y = this.f7897a == null ? null : this.f7897a.get();
        if (interfaceC2211y != null) {
            interfaceC2211y.mo7102b(i, obj, i2);
        }
    }
}
