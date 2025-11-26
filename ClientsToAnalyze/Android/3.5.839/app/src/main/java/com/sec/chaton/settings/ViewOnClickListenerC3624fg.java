package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.p061g.C2346e;

/* compiled from: FreeSmsInfoPreference.java */
/* renamed from: com.sec.chaton.settings.fg */
/* loaded from: classes.dex */
class ViewOnClickListenerC3624fg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FreeSmsInfoPreference f13171a;

    ViewOnClickListenerC3624fg(FreeSmsInfoPreference freeSmsInfoPreference) {
        this.f13171a = freeSmsInfoPreference;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f13171a.f12788i.startActivityForResult(C2346e.m10270a(this.f13171a.f12788i), 98345);
    }
}
