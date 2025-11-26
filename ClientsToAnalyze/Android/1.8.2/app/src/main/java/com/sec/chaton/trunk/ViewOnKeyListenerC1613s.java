package com.sec.chaton.trunk;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.trunk.database.EnumC1588d;
import com.sec.chaton.trunk.p053e.EnumC1599h;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.s */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1613s implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ C1609o f5738a;

    /* renamed from: b */
    private View f5739b;

    /* renamed from: c */
    private String f5740c;

    /* renamed from: d */
    private EnumC1588d f5741d;

    /* renamed from: e */
    private String f5742e;

    /* renamed from: f */
    private EnumC1599h f5743f;

    public ViewOnKeyListenerC1613s(C1609o c1609o, View view, String str, EnumC1588d enumC1588d, String str2, EnumC1599h enumC1599h) {
        this.f5738a = c1609o;
        Log.i("Prashant", "OnKeyItemListener constructor");
        this.f5739b = view;
        this.f5740c = str;
        this.f5741d = enumC1588d;
        this.f5742e = str2;
        this.f5743f = enumC1599h;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Log.i("Prashant", "onKey");
        if (66 != i || keyEvent.getAction() != 1) {
            return false;
        }
        Log.i("Prashant", "onKey method and enter key pressed");
        this.f5738a.f5724g.mo5350b(this.f5739b, this.f5740c, this.f5741d, this.f5742e, this.f5743f);
        return true;
    }
}
