package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.ai */
/* loaded from: classes.dex */
class RunnableC1372ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f4816a;

    /* renamed from: b */
    final /* synthetic */ C1395be f4817b;

    RunnableC1372ai(C1395be c1395be, View view) {
        this.f4817b = c1395be;
        this.f4816a = view;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (this.f4817b.f5416b) {
            int measuredWidth = this.f4816a.getMeasuredWidth() - this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_text_popup_width);
            int dimensionPixelSize = this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height);
            this.f4817b.m5647a(this.f4816a, measuredWidth, dimensionPixelSize, (this.f4816a.getMeasuredWidth() / 2) - (this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), dimensionPixelSize + this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), true);
            return;
        }
        if (this.f4817b.f5415a) {
            this.f4817b.m5647a(this.f4816a, (this.f4816a.getMeasuredWidth() / 2) - (this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_pen_popup_width) / 2), this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height), (this.f4816a.getMeasuredWidth() / 2) - (this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_width) / 2), this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_height) - this.f4817b.m5646a().getResources().getDimensionPixelSize(R.dimen.ams_ics2_tool_popup_pointer_margin), false);
            return;
        }
        this.f4817b.m5651b(this.f4816a, this.f4816a.getMeasuredWidth(), -this.f4816a.getMeasuredHeight(), false);
    }
}
