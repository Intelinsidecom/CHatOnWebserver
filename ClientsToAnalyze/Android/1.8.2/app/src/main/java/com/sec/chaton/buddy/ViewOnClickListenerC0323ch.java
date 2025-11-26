package com.sec.chaton.buddy;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.buddy.p010a.C0257c;
import java.util.ArrayList;

/* compiled from: BuddyGroupEditAdapter.java */
/* renamed from: com.sec.chaton.buddy.ch */
/* loaded from: classes.dex */
class ViewOnClickListenerC0323ch implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f1458a;

    /* renamed from: b */
    final /* synthetic */ int f1459b;

    /* renamed from: c */
    final /* synthetic */ C0322cg f1460c;

    ViewOnClickListenerC0323ch(C0322cg c0322cg, int i, int i2) {
        this.f1460c = c0322cg;
        this.f1458a = i;
        this.f1459b = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        ((CheckBox) view).setChecked(zIsChecked);
        ((C0257c) ((ArrayList) this.f1460c.f1452k.get(this.f1458a)).get(this.f1459b)).m2322a(zIsChecked);
        this.f1460c.m2402a(((C0257c) ((ArrayList) this.f1460c.f1452k.get(this.f1458a)).get(this.f1459b)).m2318a(), zIsChecked);
        this.f1460c.f1444c.invalidateViews();
        this.f1460c.m2398a(this.f1460c.f1450i);
    }
}
