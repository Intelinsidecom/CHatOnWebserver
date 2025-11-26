package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: BatchOperation.java */
/* renamed from: com.sec.chaton.account.a */
/* loaded from: classes.dex */
public class C0415a {

    /* renamed from: a */
    ArrayList<ContentProviderOperation> f1463a = new ArrayList<>();

    /* renamed from: b */
    private final ContentResolver f1464b;

    public C0415a(Context context, ContentResolver contentResolver) {
        this.f1464b = contentResolver;
    }

    /* renamed from: a */
    public int m3023a() {
        return this.f1463a.size();
    }

    /* renamed from: a */
    public void m3024a(ContentProviderOperation contentProviderOperation) {
        this.f1463a.add(contentProviderOperation);
    }

    /* renamed from: b */
    public void m3025b() throws RemoteException, OperationApplicationException {
        if (this.f1463a.size() != 0) {
            try {
                this.f1464b.applyBatch("com.android.contacts", this.f1463a);
            } catch (OperationApplicationException e) {
                C3250y.m11443a(e, getClass().getName());
            } catch (RemoteException e2) {
                C3250y.m11443a(e2, getClass().getName());
            }
            this.f1463a.clear();
        }
    }
}
