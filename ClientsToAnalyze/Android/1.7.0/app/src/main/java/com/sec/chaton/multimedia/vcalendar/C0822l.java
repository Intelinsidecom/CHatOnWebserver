package com.sec.chaton.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1341p;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.l */
/* loaded from: classes.dex */
class C0822l extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f2821a;

    C0822l(VCalendarListFragment vCalendarListFragment) {
        this.f2821a = vCalendarListFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("onReceive : " + intent.getAction(), VCalendarListFragment.f2770a);
        this.f2821a.m3338f();
    }
}
