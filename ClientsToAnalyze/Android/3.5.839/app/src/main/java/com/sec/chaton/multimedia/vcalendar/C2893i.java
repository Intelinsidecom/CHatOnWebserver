package com.sec.chaton.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.i */
/* loaded from: classes.dex */
class C2893i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f10668a;

    C2893i(VCalendarListFragment vCalendarListFragment) {
        this.f10668a = vCalendarListFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), VCalendarListFragment.f10631a);
        this.f10668a.m12041f();
    }
}
