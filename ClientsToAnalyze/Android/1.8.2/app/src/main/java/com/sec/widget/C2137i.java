package com.sec.widget;

import android.view.View;
import android.widget.PopupMenu;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.i */
/* loaded from: classes.dex */
class C2137i implements PopupMenu.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ View f7785a;

    /* renamed from: b */
    final /* synthetic */ C2134f f7786b;

    C2137i(C2134f c2134f, View view) {
        this.f7786b = c2134f;
        this.f7785a = view;
    }

    @Override // android.widget.PopupMenu.OnDismissListener
    public void onDismiss(PopupMenu popupMenu) {
        this.f7785a.setSelected(false);
    }
}
