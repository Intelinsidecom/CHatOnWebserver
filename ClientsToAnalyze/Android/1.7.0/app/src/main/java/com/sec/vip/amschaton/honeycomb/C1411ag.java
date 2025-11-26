package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ag */
/* loaded from: classes.dex */
class C1411ag implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5040a;

    C1411ag(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5040a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.f5040a.f5021n[0];
        if (i < this.f5040a.f5021n.length) {
            i2 = this.f5040a.f5021n[i];
        }
        if (i2 >= 1000) {
            this.f5040a.f5019b = (i2 + this.f5040a.f5026s.m5662b()) - 1000;
        } else {
            this.f5040a.f5019b = this.f5040a.f5026s.m5668d(i2);
        }
        this.f5040a.m5267m();
    }
}
