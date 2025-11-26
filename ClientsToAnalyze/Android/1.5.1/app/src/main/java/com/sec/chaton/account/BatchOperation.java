package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BatchOperation {

    /* renamed from: a */
    ArrayList f323a = new ArrayList();

    /* renamed from: b */
    private final ContentResolver f324b;

    public BatchOperation(Context context, ContentResolver contentResolver) {
        this.f324b = contentResolver;
    }

    /* renamed from: a */
    public int m396a() {
        return this.f323a.size();
    }

    /* renamed from: a */
    public void m397a(ContentProviderOperation contentProviderOperation) {
        this.f323a.add(contentProviderOperation);
    }

    /* renamed from: b */
    public void m398b() throws RemoteException, OperationApplicationException {
        if (this.f323a.size() == 0) {
            return;
        }
        try {
            this.f324b.applyBatch("com.android.contacts", this.f323a);
        } catch (OperationApplicationException e) {
            ChatONLogWriter.m3501a(e, getClass().getName());
        } catch (RemoteException e2) {
            ChatONLogWriter.m3501a(e2, getClass().getName());
        }
        this.f323a.clear();
    }
}
