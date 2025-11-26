package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.trunk.database.EnumC1588d;
import com.sec.chaton.trunk.p053e.EnumC1599h;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC1611q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1609o f5728a;

    /* renamed from: b */
    private View f5729b;

    /* renamed from: c */
    private String f5730c;

    /* renamed from: d */
    private EnumC1588d f5731d;

    /* renamed from: e */
    private String f5732e;

    /* renamed from: f */
    private EnumC1599h f5733f;

    public ViewOnClickListenerC1611q(C1609o c1609o, View view, String str, EnumC1588d enumC1588d, String str2, EnumC1599h enumC1599h) {
        this.f5728a = c1609o;
        this.f5729b = view;
        this.f5730c = str;
        this.f5731d = enumC1588d;
        this.f5732e = str2;
        this.f5733f = enumC1599h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5728a.f5723f.mo5347a(this.f5729b, this.f5730c, this.f5731d, this.f5732e, this.f5733f);
    }
}
