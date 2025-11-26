package com.sec.chaton.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: VCalendarDetailActivity2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.c */
/* loaded from: classes.dex */
class C1918c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f7331a;

    C1918c(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f7331a = vCalendarDetailActivity2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), VCalendarDetailActivity2.class.getSimpleName());
        this.f7331a.m7786d();
    }
}
