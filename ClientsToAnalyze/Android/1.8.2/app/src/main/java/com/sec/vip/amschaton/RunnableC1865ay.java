package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.ay */
/* loaded from: classes.dex */
class RunnableC1865ay implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f6836a;

    /* renamed from: b */
    final /* synthetic */ C1862av f6837b;

    RunnableC1865ay(C1862av c1862av, View view) {
        this.f6837b = c1862av;
        this.f6836a = view;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (this.f6837b.f6813b) {
            int measuredWidth = this.f6836a.getMeasuredWidth() - this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_text_popup_width);
            int dimensionPixelSize = this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height);
            this.f6837b.m6439a(this.f6836a, measuredWidth, dimensionPixelSize, (this.f6836a.getMeasuredWidth() / 2) - (this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), dimensionPixelSize + this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), true);
            return;
        }
        if (this.f6837b.f6812a) {
            this.f6837b.m6439a(this.f6836a, (this.f6836a.getMeasuredWidth() / 2) - (this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_width) / 2), this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height), (this.f6836a.getMeasuredWidth() / 2) - (this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height) - this.f6837b.m6443e().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), false);
            return;
        }
        this.f6837b.m6442b(this.f6836a, this.f6836a.getMeasuredWidth(), -this.f6836a.getMeasuredHeight(), false);
    }
}
