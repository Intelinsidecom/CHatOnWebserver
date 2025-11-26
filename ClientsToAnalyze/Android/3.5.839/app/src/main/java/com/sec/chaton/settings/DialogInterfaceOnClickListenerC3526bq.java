package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3526bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13014a;

    DialogInterfaceOnClickListenerC3526bq(ActivityNoti2 activityNoti2) {
        this.f13014a = activityNoti2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f13014a.f12544D = i;
        String str = this.f13014a.f12575y[this.f13014a.f12544D];
        if (this.f13014a.f12544D == 0) {
            this.f13014a.f12557g.m18125b("Setting is simple popup", (Boolean) true);
        } else {
            this.f13014a.f12557g.m18125b("Setting is simple popup", (Boolean) false);
        }
        this.f13014a.m13428a(str, this.f13014a.f12565o, true);
        dialogInterface.dismiss();
    }
}
