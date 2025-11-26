package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: BatchOperation.java */
/* renamed from: com.sec.chaton.account.a */
/* loaded from: classes.dex */
public class C0994a {

    /* renamed from: a */
    ArrayList<ContentProviderOperation> f3253a = new ArrayList<>();

    /* renamed from: b */
    private final ContentResolver f3254b;

    public C0994a(Context context, ContentResolver contentResolver) {
        this.f3254b = contentResolver;
    }

    /* renamed from: a */
    public int m6041a() {
        return this.f3253a.size();
    }

    /* renamed from: a */
    public void m6042a(ContentProviderOperation contentProviderOperation) {
        this.f3253a.add(contentProviderOperation);
    }

    /* renamed from: b */
    public void m6043b() throws RemoteException, OperationApplicationException {
        if (this.f3253a.size() != 0) {
            try {
                this.f3254b.applyBatch("com.android.contacts", this.f3253a);
            } catch (OperationApplicationException e) {
                C4904y.m18635a(e, getClass().getName());
            } catch (RemoteException e2) {
                C4904y.m18635a(e2, getClass().getName());
            }
            this.f3253a.clear();
        }
    }
}
