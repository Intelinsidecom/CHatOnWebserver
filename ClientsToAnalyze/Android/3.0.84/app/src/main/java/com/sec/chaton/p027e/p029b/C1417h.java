package com.sec.chaton.p027e.p029b;

import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.common.CommonApplication;
import java.util.Collection;

/* compiled from: BuddyGroupAddBuddyTask.java */
/* renamed from: com.sec.chaton.e.b.h */
/* loaded from: classes.dex */
public class C1417h extends AbstractC1410a {

    /* renamed from: c */
    private int f5258c;

    /* renamed from: d */
    private Collection<String> f5259d;

    /* renamed from: e */
    private boolean f5260e;

    public C1417h(InterfaceC1413d interfaceC1413d, int i, Collection<String> collection, boolean z) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5258c = i;
        this.f5259d = collection;
        this.f5260e = z;
    }

    @Override // com.sec.chaton.p027e.p029b.AbstractC1410a
    /* renamed from: a */
    public Object mo6263a() throws RemoteException, OperationApplicationException {
        C1362f.m6062a(CommonApplication.m11493l().getContentResolver(), this.f5258c, this.f5259d, this.f5260e);
        return true;
    }
}
