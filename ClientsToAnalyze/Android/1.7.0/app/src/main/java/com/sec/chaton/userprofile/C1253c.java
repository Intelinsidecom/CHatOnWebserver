package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.c */
/* loaded from: classes.dex */
class C1253c implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4350a;

    C1253c(MyPageFragment myPageFragment) {
        this.f4350a = myPageFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f4350a.f4141c = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
        this.f4350a.f4141c = null;
    }
}
