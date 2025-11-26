package com.sec.chaton.account;

import android.content.Context;
import com.sec.chaton.p035io.entry.inner.Buddy;
import java.util.ArrayList;

/* compiled from: ContactAccountTask.java */
/* renamed from: com.sec.chaton.account.h */
/* loaded from: classes.dex */
public class RunnableC0422h implements Runnable {

    /* renamed from: a */
    private Context f1475a;

    /* renamed from: b */
    private ArrayList<Buddy> f1476b;

    public RunnableC0422h(Context context, ArrayList<Buddy> arrayList) {
        this.f1475a = context;
        this.f1476b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0423i.m3047b(this.f1475a, this.f1476b);
    }
}
