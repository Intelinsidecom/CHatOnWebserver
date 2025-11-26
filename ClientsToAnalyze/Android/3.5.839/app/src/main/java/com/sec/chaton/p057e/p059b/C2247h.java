package com.sec.chaton.p057e.p059b;

import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.common.CommonApplication;
import java.util.Collection;

/* compiled from: BuddyGroupAddBuddyTask.java */
/* renamed from: com.sec.chaton.e.b.h */
/* loaded from: classes.dex */
public class C2247h extends AbstractC2240a {

    /* renamed from: c */
    private int f7998c;

    /* renamed from: d */
    private Collection<String> f7999d;

    /* renamed from: e */
    private boolean f8000e;

    public C2247h(InterfaceC2243d interfaceC2243d, int i, Collection<String> collection, boolean z) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f7998c = i;
        this.f7999d = collection;
        this.f8000e = z;
    }

    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    public Object mo8896a() throws RemoteException, OperationApplicationException {
        C2191e.m9855a(CommonApplication.m18732r().getContentResolver(), this.f7998c, this.f7999d, this.f8000e);
        return true;
    }
}
