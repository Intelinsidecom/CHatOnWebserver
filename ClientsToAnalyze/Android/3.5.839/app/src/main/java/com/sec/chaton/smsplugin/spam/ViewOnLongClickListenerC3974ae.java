package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ae */
/* loaded from: classes.dex */
class ViewOnLongClickListenerC3974ae implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ C4017bu f14410a;

    /* renamed from: b */
    final /* synthetic */ C3971ab f14411b;

    ViewOnLongClickListenerC3974ae(C3971ab c3971ab, C4017bu c4017bu) {
        this.f14411b = c3971ab;
        this.f14410a = c4017bu;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f14411b.f14402a.f14301b.size() || ((C4017bu) this.f14411b.f14402a.f14301b.get(i)).m15458c().equals(this.f14410a.m15458c())) {
                break;
            }
            i2 = i + 1;
        }
        this.f14411b.f14402a.m15329b(" i = " + i + " mScreenType = " + this.f14411b.f14402a.f14305f);
        this.f14411b.f14402a.f14306g = i;
        this.f14411b.f14402a.removeDialog(100);
        this.f14411b.f14402a.showDialog(100);
        return true;
    }
}
