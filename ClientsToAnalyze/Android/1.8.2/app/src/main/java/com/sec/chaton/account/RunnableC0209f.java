package com.sec.chaton.account;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: ContactAccountTask.java */
/* renamed from: com.sec.chaton.account.f */
/* loaded from: classes.dex */
public class RunnableC0209f implements Runnable {

    /* renamed from: a */
    private Context f745a;

    /* renamed from: b */
    private ArrayList f746b;

    public RunnableC0209f(Context context, ArrayList arrayList) {
        this.f745a = context;
        this.f746b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0210g.m1814b(this.f745a, this.f746b);
    }
}
