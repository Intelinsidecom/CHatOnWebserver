package com.sec.chaton.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1341p;

/* compiled from: VCalendarDetailActivity2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.c */
/* loaded from: classes.dex */
class C0813c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f2801a;

    C0813c(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f2801a = vCalendarDetailActivity2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("onReceive : " + intent.getAction(), VCalendarDetailActivity2.f2751a);
        this.f2801a.m3313d();
    }
}
