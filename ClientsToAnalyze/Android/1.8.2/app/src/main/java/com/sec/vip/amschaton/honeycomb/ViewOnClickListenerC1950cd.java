package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.ListAdapter;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.cd */
/* loaded from: classes.dex */
class ViewOnClickListenerC1950cd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7094a;

    ViewOnClickListenerC1950cd(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7094a = aMSStampSelectionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7094a.f7016x = !this.f7094a.f7016x;
        if (this.f7094a.f7016x) {
            this.f7094a.m6817b(true);
        } else {
            this.f7094a.m6817b(false);
            if (this.f7094a.f7011s != null) {
                this.f7094a.f7012t = null;
                this.f7094a.f7012t = new C1951ce(this.f7094a);
                this.f7094a.f7011s.setAdapter((ListAdapter) this.f7094a.f7012t);
                if (AMSStampSelectionActivity.f7004l) {
                    this.f7094a.f7011s.setSelection(0);
                } else {
                    this.f7094a.f7011s.setSelection(this.f7094a.f7013u.m6402b());
                }
            }
        }
        this.f7094a.m6837l();
    }
}
