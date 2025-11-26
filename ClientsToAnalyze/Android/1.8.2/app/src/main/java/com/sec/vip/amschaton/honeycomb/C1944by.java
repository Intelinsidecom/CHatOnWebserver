package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.by */
/* loaded from: classes.dex */
class C1944by implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7088a;

    C1944by(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7088a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.f7088a.f7008p[0];
        if (i < this.f7088a.f7008p.length) {
            i2 = this.f7088a.f7008p[i];
        }
        if (i2 >= 1000) {
            this.f7088a.f7006n = (i2 + this.f7088a.f7013u.m6402b()) - 1000;
        } else {
            this.f7088a.f7006n = this.f7088a.f7013u.m6408d(i2);
        }
        this.f7088a.m6839m();
    }
}
