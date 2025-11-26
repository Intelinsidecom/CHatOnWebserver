package com.sec.chaton.smsplugin.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: MmsVCalendarListFragment.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.vcalendar.e */
/* loaded from: classes.dex */
class C3941e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MmsVCalendarListFragment f14202a;

    C3941e(MmsVCalendarListFragment mmsVCalendarListFragment) {
        this.f14202a = mmsVCalendarListFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), MmsVCalendarListFragment.f14180a);
        this.f14202a.m15214f();
    }
}
