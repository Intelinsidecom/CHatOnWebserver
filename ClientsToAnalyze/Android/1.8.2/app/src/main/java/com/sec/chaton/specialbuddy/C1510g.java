package com.sec.chaton.specialbuddy;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SpecialBuddyInfo.java */
/* renamed from: com.sec.chaton.specialbuddy.g */
/* loaded from: classes.dex */
class C1510g implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyInfo f5428a;

    C1510g(SpecialBuddyInfo specialBuddyInfo) {
        this.f5428a = specialBuddyInfo;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                this.f5428a.m5209e();
                break;
        }
        this.f5428a.f5417q.setVisibility(8);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
