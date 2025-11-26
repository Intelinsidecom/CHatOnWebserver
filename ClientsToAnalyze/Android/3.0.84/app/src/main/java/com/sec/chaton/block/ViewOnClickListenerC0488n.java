package com.sec.chaton.block;

import android.view.View;

/* compiled from: BlockImpl.java */
/* renamed from: com.sec.chaton.block.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0488n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0487m f1615a;

    ViewOnClickListenerC0488n(MenuItemOnMenuItemClickListenerC0487m menuItemOnMenuItemClickListenerC0487m) {
        this.f1615a = menuItemOnMenuItemClickListenerC0487m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1615a.f1611m.getFragmentManager().popBackStack();
    }
}
