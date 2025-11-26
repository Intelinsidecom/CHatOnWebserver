package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: BlockImpl.java */
/* renamed from: com.sec.chaton.block.p */
/* loaded from: classes.dex */
class C0490p implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0487m f1617a;

    C0490p(MenuItemOnMenuItemClickListenerC0487m menuItemOnMenuItemClickListenerC0487m) {
        this.f1617a = menuItemOnMenuItemClickListenerC0487m;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1617a.f1602d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f1617a.f1602d = null;
    }
}
