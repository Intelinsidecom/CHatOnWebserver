package com.sec.chaton.multimedia.vcalendar;

import android.os.HandlerThread;

/* compiled from: VCalendarDetailFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.d */
/* loaded from: classes.dex */
class HandlerThreadC2888d extends HandlerThread {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailFragment f10653a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC2888d(VCalendarDetailFragment vCalendarDetailFragment, String str) {
        super(str);
        this.f10653a = vCalendarDetailFragment;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() throws Throwable {
        String strM12047a = C2885a.m12044a().m12047a(this.f10653a.f10626j, 1);
        if (strM12047a == null) {
            if (this.f10653a.f10630n != null) {
                this.f10653a.f10630n.finish();
                return;
            }
            return;
        }
        this.f10653a.m12024a(strM12047a);
    }
}
