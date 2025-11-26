package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSBgColorSelectionDialog.java */
/* renamed from: com.sec.vip.amschaton.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC1889f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1888e f6895a;

    ViewOnClickListenerC1889f(DialogC1888e dialogC1888e) {
        this.f6895a = dialogC1888e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f6895a.f6890b[i] == view) {
                this.f6895a.m6519a(this.f6895a.m6522b(this.f6895a.f6889a), false);
                this.f6895a.m6527a(this.f6895a.getContext().getResources().getColor(this.f6895a.f6892d[i]));
                if (this.f6895a.f6893e != null) {
                    this.f6895a.f6893e.mo6436d_();
                }
                this.f6895a.dismiss();
                return;
            }
        }
    }
}
