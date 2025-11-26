package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.trunk.database.EnumC1588d;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC1612r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1609o f5734a;

    /* renamed from: b */
    private View f5735b;

    /* renamed from: c */
    private String f5736c;

    /* renamed from: d */
    private EnumC1588d f5737d;

    public ViewOnClickListenerC1612r(C1609o c1609o, View view, String str, EnumC1588d enumC1588d) {
        this.f5734a = c1609o;
        this.f5735b = view;
        this.f5736c = str;
        this.f5737d = enumC1588d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5734a.f5723f.mo5347a(this.f5735b, this.f5736c, this.f5737d, null, null);
    }
}
