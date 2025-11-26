package com.sec.widget;

import android.view.View;
import android.widget.PopupMenu;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.ag */
/* loaded from: classes.dex */
class C1610ag implements PopupMenu.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ View f5703a;

    /* renamed from: b */
    final /* synthetic */ C1632t f5704b;

    C1610ag(C1632t c1632t, View view) {
        this.f5704b = c1632t;
        this.f5703a = view;
    }

    @Override // android.widget.PopupMenu.OnDismissListener
    public void onDismiss(PopupMenu popupMenu) {
        this.f5704b.f5757f = false;
        this.f5703a.setSelected(false);
    }
}
