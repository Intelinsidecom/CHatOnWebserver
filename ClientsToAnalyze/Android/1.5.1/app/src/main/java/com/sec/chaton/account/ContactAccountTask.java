package com.sec.chaton.account;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ContactAccountTask implements Runnable {

    /* renamed from: a */
    private Context f329a;

    /* renamed from: b */
    private ArrayList f330b;

    public ContactAccountTask(Context context, ArrayList arrayList) {
        this.f329a = context;
        this.f330b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        ContactManager.m406b(this.f329a, this.f330b);
    }
}
