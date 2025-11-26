package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.br */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3527br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13015a;

    DialogInterfaceOnClickListenerC3527br(ActivityNoti2 activityNoti2) {
        this.f13015a = activityNoti2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f13015a.f12546F = "ALL";
        switch (i) {
            case 0:
                this.f13015a.f12546F = "MELODY";
                this.f13015a.f12568r.setEnabled(true);
                this.f13015a.m13428a(this.f13015a.f12568r.getSummary().toString(), this.f13015a.f12568r, true);
                break;
            case 1:
                this.f13015a.f12546F = "VIBRATION";
                this.f13015a.f12568r.setEnabled(false);
                this.f13015a.m13428a(this.f13015a.f12568r.getSummary().toString(), this.f13015a.f12568r, false);
                break;
            case 2:
                this.f13015a.f12546F = "ALL";
                this.f13015a.f12568r.setEnabled(true);
                this.f13015a.m13428a(this.f13015a.f12568r.getSummary().toString(), this.f13015a.f12568r, true);
                break;
            case 3:
                this.f13015a.f12546F = "OFF";
                this.f13015a.f12568r.setEnabled(false);
                this.f13015a.m13428a(this.f13015a.f12568r.getSummary().toString(), this.f13015a.f12568r, false);
                break;
        }
        this.f13015a.m13428a(this.f13015a.m13425a(this.f13015a.f12546F), this.f13015a.f12567q, true);
        this.f13015a.f12557g.m18128b("Set Type", this.f13015a.f12546F);
        this.f13015a.m13426a();
        dialogInterface.dismiss();
    }
}
