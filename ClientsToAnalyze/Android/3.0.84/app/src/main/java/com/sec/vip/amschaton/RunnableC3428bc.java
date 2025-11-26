package com.sec.vip.amschaton;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.bc */
/* loaded from: classes.dex */
class RunnableC3428bc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f12560a;

    /* renamed from: b */
    final /* synthetic */ C3424az f12561b;

    RunnableC3428bc(C3424az c3424az, View view) {
        this.f12561b = c3424az;
        this.f12560a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12561b.m12237a(this.f12560a, this.f12561b.m12242e().getResources().getDimensionPixelSize(R.dimen.ams_tool_pen_popup_width), this.f12561b.m12242e().getResources().getDimensionPixelSize(R.dimen.ams_tool_text_popup_height));
    }
}
