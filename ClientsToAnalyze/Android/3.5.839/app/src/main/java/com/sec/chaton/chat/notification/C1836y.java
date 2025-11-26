package com.sec.chaton.chat.notification;

import android.support.v4.view.InterfaceC0196cc;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4904y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.y */
/* loaded from: classes.dex */
class C1836y implements InterfaceC0196cc {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6958a;

    C1836y(ScreenNotification2 screenNotification2) {
        this.f6958a = screenNotification2;
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) {
        this.f6958a.f6749V = i;
        this.f6958a.f6750W = this.f6958a.f6735H.m8958a(i);
        this.f6958a.f6738K.setText(this.f6958a.f6750W.f6928b);
        this.f6958a.f6739L.setText("" + (i + 1) + "/" + this.f6958a.m8863r());
        boolean zStartsWith = this.f6958a.f6750W.f6927a.startsWith("0999");
        if (!zStartsWith || this.f6958a.f6750W.f6933g != EnumC2214ab.LIVECONTENTS.m10076a()) {
            this.f6958a.f6748U.setVisibility(0);
            if (this.f6958a.f6742O.isShown()) {
                this.f6958a.f6742O.setEnabled(true);
            }
            if (this.f6958a.f6741N.isShown()) {
                this.f6958a.f6741N.setEnabled(true);
            }
        } else {
            this.f6958a.f6748U.setVisibility(8);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[onPageSelected] current index:" + this.f6958a.f6749V + " isSpecialbuddy:" + zStartsWith, ScreenNotification2.f6727v);
        }
        if (this.f6958a.f6768ao != null) {
            this.f6958a.f6768ao.removeCallbacks(this.f6958a.f6758ae);
            if (!this.f6958a.f6736I) {
                this.f6958a.f6768ao.postDelayed(this.f6958a.f6758ae, this.f6958a.f6757ad);
            }
        }
        int i2 = this.f6958a.f6763aj <= 99 ? this.f6958a.f6763aj : 99;
        if (i == 0) {
            this.f6958a.m8835a(EnumC1809ap.SHOW_RIGHT);
        } else if (i == i2 - 1) {
            this.f6958a.m8835a(EnumC1809ap.SHOW_LEFT);
        } else {
            this.f6958a.m8835a(EnumC1809ap.SHOW_LEFTRIGHT);
        }
        if (C2349a.m10301a("sms_feature")) {
            if (this.f6958a.f6750W.f6943q != C1828q.f6914b) {
                this.f6958a.f6756ac.setBackgroundResource(R.drawable.actionbar_ic_chaton_sns_lite);
                this.f6958a.f6744Q.setVisibility(0);
            } else {
                this.f6958a.f6756ac.setBackgroundResource(R.drawable.actionbar_ic_chaton);
                this.f6958a.f6744Q.setVisibility(8);
            }
        }
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo620a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: b */
    public void mo622b(int i) {
    }
}
