package com.sec.chaton.multimedia.vcalendar;

/* compiled from: VCalendarDetailActivity2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.d */
/* loaded from: classes.dex */
class RunnableC0814d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f2802a;

    RunnableC0814d(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f2802a = vCalendarDetailActivity2;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String strM3350a = "";
        try {
            strM3350a = new C0819i().m3350a(this.f2802a.f2761k, 1);
        } catch (C0818h e) {
        }
        if (strM3350a != null) {
            this.f2802a.m3322a(strM3350a);
        } else {
            this.f2802a.finish();
        }
    }
}
