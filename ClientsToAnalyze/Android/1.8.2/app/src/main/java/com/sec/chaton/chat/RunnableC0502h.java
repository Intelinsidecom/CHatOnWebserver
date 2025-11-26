package com.sec.chaton.chat;

import android.content.res.Configuration;
import com.sec.chaton.util.C1786r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.h */
/* loaded from: classes.dex */
class RunnableC0502h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0501g f2099a;

    RunnableC0502h(C0501g c0501g) {
        this.f2099a = c0501g;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2099a.f2098b.getActivity() != null) {
            if (this.f2099a.f2098b.f1841bD == 1) {
                this.f2099a.f2098b.f1846bI.showSoftInput(this.f2099a.f2098b.f1800aO, 0);
                this.f2099a.f2098b.f1910x = true;
                return;
            }
            Configuration configuration = this.f2099a.f2098b.getResources().getConfiguration();
            if (configuration.orientation == 2) {
                this.f2099a.f2098b.f1846bI.showSoftInput(this.f2099a.f2098b.f1800aO, 0);
            } else if (configuration.orientation == 1) {
                this.f2099a.f2098b.f1846bI.showSoftInput(this.f2099a.f2098b.f1800aO, 1);
            }
            this.f2099a.f2098b.f1910x = true;
            return;
        }
        C1786r.m6054a("setEditTextShow - Activity is null", getClass().getSimpleName());
    }
}
