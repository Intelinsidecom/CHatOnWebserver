package com.sec.chaton.chat;

import android.view.WindowManager;
import android.widget.TextView;
import com.sec.chaton.util.C1786r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ae */
/* loaded from: classes.dex */
class RunnableC0463ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0462ad f1930a;

    RunnableC0463ae(C0462ad c0462ad) {
        this.f1930a = c0462ad;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1930a.f1929b.m2511a(this.f1930a.f1929b.f1786aA, TextView.BufferType.NORMAL);
        try {
            ((WindowManager) this.f1930a.f1929b.getActivity().getSystemService("window")).getDefaultDisplay();
        } catch (Exception e) {
            C1786r.m6056a(e, ChatFragment.f1742a);
        }
    }
}
