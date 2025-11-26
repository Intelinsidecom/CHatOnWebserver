package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: BatchOperation.java */
/* renamed from: com.sec.chaton.account.a */
/* loaded from: classes.dex */
public class C0204a {

    /* renamed from: a */
    ArrayList f736a = new ArrayList();

    /* renamed from: b */
    private final ContentResolver f737b;

    public C0204a(Context context, ContentResolver contentResolver) {
        this.f737b = contentResolver;
    }

    /* renamed from: a */
    public int m1802a() {
        return this.f736a.size();
    }

    /* renamed from: a */
    public void m1803a(ContentProviderOperation contentProviderOperation) {
        this.f736a.add(contentProviderOperation);
    }

    /* renamed from: b */
    public void m1804b() throws RemoteException, OperationApplicationException {
        if (this.f736a.size() != 0) {
            try {
                this.f737b.applyBatch("com.android.contacts", this.f736a);
            } catch (OperationApplicationException e) {
                C1786r.m6056a(e, getClass().getName());
            } catch (RemoteException e2) {
                C1786r.m6056a(e2, getClass().getName());
            }
            this.f736a.clear();
        }
    }
}
