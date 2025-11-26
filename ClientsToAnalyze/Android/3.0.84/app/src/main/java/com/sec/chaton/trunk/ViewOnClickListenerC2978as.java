package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3197bl;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.as */
/* loaded from: classes.dex */
class ViewOnClickListenerC2978as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f10778a;

    ViewOnClickListenerC2978as(TrunkFullView trunkFullView) {
        this.f10778a = trunkFullView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a() && !this.f10778a.f10562x && !this.f10778a.f10561w && this.f10778a.f10555q == EnumC3026g.IMAGE && this.f10778a.f10543e != null) {
            this.f10778a.f10543e.mo10360a(this.f10778a.f10555q, this.f10778a.f10559u);
        }
    }
}
