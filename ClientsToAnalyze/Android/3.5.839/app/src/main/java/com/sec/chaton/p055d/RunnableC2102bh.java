package com.sec.chaton.p055d;

import android.widget.Toast;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: SNSBuddyControl.java */
/* renamed from: com.sec.chaton.d.bh */
/* loaded from: classes.dex */
class RunnableC2102bh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7630a;

    /* renamed from: b */
    final /* synthetic */ C2101bg f7631b;

    RunnableC2102bh(C2101bg c2101bg, String str) {
        this.f7631b = c2101bg;
        this.f7630a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(GlobalApplication.m18732r(), this.f7630a, 2).show();
    }
}
