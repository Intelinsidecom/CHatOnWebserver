package com.sec.chaton.trunk;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.trunk.p043c.EnumC1152a;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.l */
/* loaded from: classes.dex */
class C1186l implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f4055a;

    C1186l(TrunkView trunkView) {
        this.f4055a = trunkView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        int iOrdinal = EnumC1152a.Recent.ordinal();
        int iOrdinal2 = EnumC1152a.UnreadComment.ordinal();
        if (i != this.f4055a.f3848q.ordinal()) {
            this.f4055a.f3849r = true;
            if (i == iOrdinal) {
                this.f4055a.m4062a(true, true, EnumC1152a.Recent);
            } else if (i == iOrdinal2) {
                this.f4055a.m4062a(true, true, EnumC1152a.UnreadComment);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
