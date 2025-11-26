package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.ba */
/* loaded from: classes.dex */
class RunnableC1391ba implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f4883a;

    /* renamed from: b */
    final /* synthetic */ C1369af f4884b;

    RunnableC1391ba(C1369af c1369af, View view) {
        this.f4884b = c1369af;
        this.f4883a = view;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (this.f4884b.f5416b) {
            int measuredWidth = (this.f4883a.getMeasuredWidth() / 2) - (this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_width) / 2);
            int dimensionPixelSize = this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height);
            this.f4884b.m5647a(this.f4883a, measuredWidth, dimensionPixelSize, (this.f4883a.getMeasuredWidth() / 2) - (this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), dimensionPixelSize + this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), true);
            return;
        }
        if (this.f4884b.f5415a) {
            this.f4884b.m5647a(this.f4883a, (this.f4883a.getMeasuredWidth() / 2) - (this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_width) / 2), this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height), (this.f4883a.getMeasuredWidth() / 2) - (this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height) - this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), false);
            return;
        }
        this.f4884b.m5651b(this.f4883a, this.f4883a.getMeasuredWidth(), ((this.f4883a.getMeasuredHeight() * 3) / 4) - this.f4884b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_height), false);
    }
}
