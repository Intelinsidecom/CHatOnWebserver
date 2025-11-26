package com.sec.chaton.settings.theme;

import android.os.Handler;

/* renamed from: com.sec.chaton.settings.theme.c */
/* loaded from: classes.dex */
class HandlerC0512c extends Handler implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CarouselAdapter f3287a;

    private HandlerC0512c(CarouselAdapter carouselAdapter) {
        this.f3287a = carouselAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3287a.f3234l) {
            post(this);
        } else {
            this.f3287a.m3243m();
        }
    }
}
