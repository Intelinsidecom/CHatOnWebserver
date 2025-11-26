package com.sec.chaton.samsungaccount;

import android.support.v4.view.InterfaceC0196cc;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bo */
/* loaded from: classes.dex */
class C3363bo implements InterfaceC0196cc {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12301a;

    C3363bo(MainActivity mainActivity) {
        this.f12301a = mainActivity;
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) {
        if (i == 0) {
            this.f12301a.f12206P.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_02));
            this.f12301a.f12207Q.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f12301a.f12208R.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_01));
        } else if (i == 1) {
            this.f12301a.f12206P.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f12301a.f12207Q.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_02));
            this.f12301a.f12208R.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_01));
        } else if (i == 2) {
            this.f12301a.f12206P.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f12301a.f12207Q.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f12301a.f12208R.setImageDrawable(this.f12301a.getResources().getDrawable(R.drawable.device_page_indicator_02));
        }
        C4904y.m18639b("Flick count " + this.f12301a.f12217aa, this.f12301a.f12209S);
        MainActivity.m13178h(this.f12301a);
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
