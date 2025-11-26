package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.x */
/* loaded from: classes.dex */
class C1542x implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5372a;

    C1542x(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5372a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.f5372a.f5266n[0];
        if (i < this.f5372a.f5266n.length) {
            i2 = this.f5372a.f5266n[i];
        }
        if (i2 >= 1000) {
            this.f5372a.f5264b = (i2 + this.f5372a.f5271s.m5662b()) - 1000;
        } else {
            this.f5372a.f5264b = this.f5372a.f5271s.m5668d(i2);
        }
        this.f5372a.m5597m();
    }
}
