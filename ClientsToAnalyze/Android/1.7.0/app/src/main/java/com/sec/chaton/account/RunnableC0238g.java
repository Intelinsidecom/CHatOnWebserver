package com.sec.chaton.account;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: ContactAccountTask.java */
/* renamed from: com.sec.chaton.account.g */
/* loaded from: classes.dex */
public class RunnableC0238g implements Runnable {

    /* renamed from: a */
    private Context f582a;

    /* renamed from: b */
    private ArrayList f583b;

    public RunnableC0238g(Context context, ArrayList arrayList) {
        this.f582a = context;
        this.f583b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0239h.m910b(this.f582a, this.f583b);
    }
}
