package com.sec.chaton.smsplugin.p112ui;

import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bv */
/* loaded from: classes.dex */
class RunnableC4140bv implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f15413a;

    /* renamed from: b */
    final /* synthetic */ C4132bn f15414b;

    RunnableC4140bv(C4132bn c4132bn, String str) {
        this.f15414b = c4132bn;
        this.f15413a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f15414b.f15386b, this.f15414b.f15386b.getString(R.string.saved_label) + this.f15413a, 1).show();
    }
}
