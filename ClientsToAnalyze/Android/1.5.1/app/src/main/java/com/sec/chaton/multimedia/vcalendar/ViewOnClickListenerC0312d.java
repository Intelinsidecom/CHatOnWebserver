package com.sec.chaton.multimedia.vcalendar;

import android.view.View;
import com.sec.chaton.multimedia.vcalendar.VCalendarStruct;

/* renamed from: com.sec.chaton.multimedia.vcalendar.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0312d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2263a;

    /* renamed from: b */
    final /* synthetic */ String f2264b;

    /* renamed from: c */
    final /* synthetic */ String f2265c;

    /* renamed from: d */
    final /* synthetic */ String f2266d;

    /* renamed from: e */
    final /* synthetic */ String f2267e;

    /* renamed from: f */
    final /* synthetic */ VcalendarDetailActivity f2268f;

    ViewOnClickListenerC0312d(VcalendarDetailActivity vcalendarDetailActivity, String str, String str2, String str3, String str4, String str5) {
        this.f2268f = vcalendarDetailActivity;
        this.f2263a = str;
        this.f2264b = str2;
        this.f2265c = str3;
        this.f2266d = str4;
        this.f2267e = str5;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2268f.f2250a = new VCalendarStruct();
        VCalendarStruct.EventStruct eventStruct = new VCalendarStruct.EventStruct();
        eventStruct.f2244i = this.f2263a;
        eventStruct.f2238c = this.f2264b;
        eventStruct.f2237b = this.f2265c;
        eventStruct.f2245j = this.f2266d;
        eventStruct.f2236a = this.f2267e;
        this.f2268f.f2250a.m2601a(eventStruct);
        if (eventStruct.f2244i != null) {
            String unused = VcalendarDetailActivity.f2249d = eventStruct.f2244i;
        }
        this.f2268f.showDialog(0);
        new Thread((ThreadGroup) null, this.f2268f.f2259k).start();
    }
}
