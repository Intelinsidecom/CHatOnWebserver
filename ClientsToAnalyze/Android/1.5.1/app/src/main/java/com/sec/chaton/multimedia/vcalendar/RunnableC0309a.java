package com.sec.chaton.multimedia.vcalendar;

/* renamed from: com.sec.chaton.multimedia.vcalendar.a */
/* loaded from: classes.dex */
class RunnableC0309a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f2260a;

    RunnableC0309a(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f2260a = vCalendarDetailActivity2;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String strM2558a;
        try {
            strM2558a = new VCalComposer().m2558a(this.f2260a.f2196k, 1);
        } catch (VCalException e) {
            strM2558a = "";
        }
        if (strM2558a != null) {
            this.f2260a.m2580a(strM2558a);
        } else {
            this.f2260a.finish();
        }
    }
}
