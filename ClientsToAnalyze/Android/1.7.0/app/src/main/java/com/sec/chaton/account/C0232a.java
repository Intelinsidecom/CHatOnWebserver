package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: BatchOperation.java */
/* renamed from: com.sec.chaton.account.a */
/* loaded from: classes.dex */
public class C0232a {

    /* renamed from: a */
    ArrayList f573a = new ArrayList();

    /* renamed from: b */
    private final ContentResolver f574b;

    public C0232a(Context context, ContentResolver contentResolver) {
        this.f574b = contentResolver;
    }

    /* renamed from: a */
    public int m894a() {
        return this.f573a.size();
    }

    /* renamed from: a */
    public void m895a(ContentProviderOperation contentProviderOperation) {
        this.f573a.add(contentProviderOperation);
    }

    /* renamed from: b */
    public void m896b() throws RemoteException, OperationApplicationException {
        if (this.f573a.size() != 0) {
            try {
                this.f574b.applyBatch("com.android.contacts", this.f573a);
            } catch (OperationApplicationException e) {
                C1341p.m4653a(e, getClass().getName());
            } catch (RemoteException e2) {
                C1341p.m4653a(e2, getClass().getName());
            }
            this.f573a.clear();
        }
    }
}
