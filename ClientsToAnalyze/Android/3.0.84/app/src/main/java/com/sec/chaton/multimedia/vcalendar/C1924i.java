package com.sec.chaton.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.i */
/* loaded from: classes.dex */
class C1924i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f7347a;

    C1924i(VCalendarListFragment vCalendarListFragment) {
        this.f7347a = vCalendarListFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), VCalendarListFragment.f7311a);
        this.f7347a.m7812f();
    }
}
