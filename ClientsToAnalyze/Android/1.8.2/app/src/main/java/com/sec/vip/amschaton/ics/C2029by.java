package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.by */
/* loaded from: classes.dex */
class C2029by implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7317a;

    C2029by(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7317a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.f7317a.f7234o[0];
        if (i < this.f7317a.f7234o.length) {
            i2 = this.f7317a.f7234o[i];
        }
        if (i2 >= 1000) {
            this.f7317a.f7232m = (i2 + this.f7317a.f7239t.m6402b()) - 1000;
        } else {
            this.f7317a.f7232m = this.f7317a.f7239t.m6408d(i2);
        }
        this.f7317a.m7154m();
    }
}
