package com.sec.chaton.multimedia.vcalendar;

/* compiled from: VCalendarDetailFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.d */
/* loaded from: classes.dex */
class RunnableC1919d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailFragment f7332a;

    RunnableC1919d(VCalendarDetailFragment vCalendarDetailFragment) {
        this.f7332a = vCalendarDetailFragment;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String strM7817a = new C1916a().m7817a(this.f7332a.f7305j, 1);
        if (strM7817a == null) {
            if (this.f7332a.f7309n != null) {
                this.f7332a.f7309n.finish();
                return;
            }
            return;
        }
        this.f7332a.m7796a(strM7817a);
    }
}
