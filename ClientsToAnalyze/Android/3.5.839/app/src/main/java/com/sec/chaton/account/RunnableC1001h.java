package com.sec.chaton.account;

import android.content.Context;
import com.sec.chaton.p065io.entry.inner.Buddy;
import java.util.ArrayList;

/* compiled from: ContactAccountTask.java */
/* renamed from: com.sec.chaton.account.h */
/* loaded from: classes.dex */
public class RunnableC1001h implements Runnable {

    /* renamed from: a */
    private Context f3265a;

    /* renamed from: b */
    private ArrayList<Buddy> f3266b;

    /* renamed from: a */
    public static RunnableC1001h m6053a(Context context, ArrayList<Buddy> arrayList) {
        return new RunnableC1001h(context, arrayList);
    }

    private RunnableC1001h(Context context, ArrayList<Buddy> arrayList) {
        this.f3265a = context;
        this.f3266b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1002i.m6067b(this.f3265a, this.f3266b);
    }
}
