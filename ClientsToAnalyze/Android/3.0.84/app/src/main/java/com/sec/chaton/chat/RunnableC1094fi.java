package com.sec.chaton.chat;

import com.sec.chaton.multimedia.emoticon.ams.EnumC1807d;
import com.sec.common.CommonApplication;
import com.sec.vip.amschaton.p071a.C3398f;

/* compiled from: ChatUtil.java */
/* renamed from: com.sec.chaton.chat.fi */
/* loaded from: classes.dex */
class RunnableC1094fi implements Runnable {

    /* renamed from: a */
    String f4356a;

    /* renamed from: b */
    int f4357b;

    public RunnableC1094fi(String str, EnumC1807d enumC1807d) {
        this.f4356a = str;
        if (enumC1807d == EnumC1807d.Basic) {
            this.f4357b = 2000;
        } else if (enumC1807d == EnumC1807d.User) {
            this.f4357b = 2001;
        } else {
            this.f4357b = 2002;
        }
    }

    public RunnableC1094fi(String str, int i) {
        this.f4356a = str;
        this.f4357b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4356a != null) {
            C3398f c3398f = new C3398f(CommonApplication.m11493l());
            c3398f.m12126b();
            c3398f.m12123a(this.f4356a, String.valueOf(this.f4357b), String.valueOf(System.currentTimeMillis()));
            c3398f.mo12098a();
        }
    }
}
