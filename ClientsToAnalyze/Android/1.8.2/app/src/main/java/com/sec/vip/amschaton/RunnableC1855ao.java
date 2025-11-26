package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.ao */
/* loaded from: classes.dex */
class RunnableC1855ao implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f6806a;

    /* renamed from: b */
    final /* synthetic */ C1851ak f6807b;

    RunnableC1855ao(C1851ak c1851ak, View view) {
        this.f6807b = c1851ak;
        this.f6806a = view;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (this.f6807b.f6813b) {
            int measuredWidth = (this.f6806a.getMeasuredWidth() / 2) - (this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_width) / 2);
            int dimensionPixelSize = this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height);
            this.f6807b.m6439a(this.f6806a, measuredWidth, dimensionPixelSize, (this.f6806a.getMeasuredWidth() / 2) - (this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), dimensionPixelSize + this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), true);
            return;
        }
        if (this.f6807b.f6812a) {
            this.f6807b.m6439a(this.f6806a, (this.f6806a.getMeasuredWidth() / 2) - (this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_width) / 2), this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height), (this.f6806a.getMeasuredWidth() / 2) - (this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height) - this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), false);
            return;
        }
        this.f6807b.m6442b(this.f6806a, this.f6806a.getMeasuredWidth(), ((this.f6806a.getMeasuredHeight() * 3) / 4) - this.f6807b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_height), false);
    }
}
