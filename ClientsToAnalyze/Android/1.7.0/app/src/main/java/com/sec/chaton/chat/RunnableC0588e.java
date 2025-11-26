package com.sec.chaton.chat;

import android.content.res.Configuration;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.e */
/* loaded from: classes.dex */
class RunnableC0588e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0607x f2020a;

    RunnableC0588e(C0607x c0607x) {
        this.f2020a = c0607x;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2020a.f2141b.f1831bc == 1) {
            this.f2020a.f2141b.f1834bf.hideSoftInputFromWindow(ChatFragment.f1726aC.getWindowToken(), 0);
            this.f2020a.f2141b.f1859r = true;
            return;
        }
        Configuration configuration = this.f2020a.f2141b.getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f2020a.f2141b.f1834bf.showSoftInput(ChatFragment.f1726aC, 0);
        } else if (configuration.orientation == 1) {
            this.f2020a.f2141b.f1834bf.showSoftInput(ChatFragment.f1726aC, 1);
        }
        this.f2020a.f2141b.f1859r = true;
    }
}
