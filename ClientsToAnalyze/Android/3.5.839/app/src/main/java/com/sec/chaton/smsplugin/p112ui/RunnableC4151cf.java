package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cf */
/* loaded from: classes.dex */
final class RunnableC4151cf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f15448a;

    RunnableC4151cf(Context context) {
        this.f15448a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f15448a, R.string.compressing, 0).show();
    }
}
