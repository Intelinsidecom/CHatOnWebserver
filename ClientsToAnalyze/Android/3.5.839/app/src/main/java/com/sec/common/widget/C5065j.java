package com.sec.common.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.j */
/* loaded from: classes.dex */
class C5065j implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f18499a;

    C5065j(IcsListPopupWindow icsListPopupWindow) {
        this.f18499a = icsListPopupWindow;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        C5066k c5066k;
        if (i == -1 || (c5066k = this.f18499a.f18448d) == null) {
            return;
        }
        c5066k.f18500a = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
