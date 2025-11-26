package com.sec.chaton.multimedia.vcalendar;

/* compiled from: VCalendarDetailActivity2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.d */
/* loaded from: classes.dex */
class RunnableC1024d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f3756a;

    RunnableC1024d(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f3756a = vCalendarDetailActivity2;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String strM3981a = "";
        try {
            strM3981a = new C1021a().m3981a(this.f3756a.f3728l, 1);
        } catch (C1022b e) {
        }
        if (strM3981a != null) {
            this.f3756a.m3967a(strM3981a);
        } else {
            this.f3756a.finish();
        }
    }
}
