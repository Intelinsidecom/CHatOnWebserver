package com.sec.vip.amschaton;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.ar */
/* loaded from: classes.dex */
class RunnableC3416ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f12517a;

    /* renamed from: b */
    final /* synthetic */ C3412an f12518b;

    RunnableC3416ar(C3412an c3412an, View view) {
        this.f12518b = c3412an;
        this.f12517a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12518b.m12237a(this.f12517a, this.f12518b.m12242e().getResources().getDimensionPixelSize(R.dimen.ams_tool_pen_popup_width), this.f12518b.m12242e().getResources().getDimensionPixelSize(R.dimen.ams_tool_pen_popup_height));
    }
}
