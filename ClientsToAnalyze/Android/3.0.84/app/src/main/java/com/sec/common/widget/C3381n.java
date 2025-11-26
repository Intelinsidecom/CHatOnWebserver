package com.sec.common.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.n */
/* loaded from: classes.dex */
class C3381n implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f12253a;

    C3381n(IcsListPopupWindow icsListPopupWindow) {
        this.f12253a = icsListPopupWindow;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        C3382o c3382o;
        if (i == -1 || (c3382o = this.f12253a.f12178d) == null) {
            return;
        }
        c3382o.f12254a = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
