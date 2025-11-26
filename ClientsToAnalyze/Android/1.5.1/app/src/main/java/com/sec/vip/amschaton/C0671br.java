package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: com.sec.vip.amschaton.br */
/* loaded from: classes.dex */
class C0671br implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BackgroundMemoSelectionActivity f4292a;

    C0671br(BackgroundMemoSelectionActivity backgroundMemoSelectionActivity) {
        this.f4292a = backgroundMemoSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f4292a.f4133g = i;
        this.f4292a.f4135i.m4162a();
        if (this.f4292a.f4133g == 0) {
            this.f4292a.m4156c();
        }
    }
}
