package com.sec.chaton.smsplugin.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: MmsVCalendarDetailActivity2.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.vcalendar.a */
/* loaded from: classes.dex */
class C3937a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MmsVCalendarDetailActivity2 f14198a;

    C3937a(MmsVCalendarDetailActivity2 mmsVCalendarDetailActivity2) {
        this.f14198a = mmsVCalendarDetailActivity2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), MmsVCalendarDetailActivity2.class.getSimpleName());
        this.f14198a.m15188i();
    }
}
