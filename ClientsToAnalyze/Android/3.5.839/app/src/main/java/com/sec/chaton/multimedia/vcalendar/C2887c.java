package com.sec.chaton.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: VCalendarDetailActivity2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.c */
/* loaded from: classes.dex */
class C2887c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f10652a;

    C2887c(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f10652a = vCalendarDetailActivity2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), VCalendarDetailActivity2.class.getSimpleName());
        this.f10652a.m12015i();
    }
}
