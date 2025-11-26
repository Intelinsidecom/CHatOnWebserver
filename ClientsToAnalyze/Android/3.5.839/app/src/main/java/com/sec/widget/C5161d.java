package com.sec.widget;

import android.widget.PopupWindow;
import com.sec.chaton.util.C4904y;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.d */
/* loaded from: classes.dex */
class C5161d implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f18884a;

    C5161d(DropPanelMenu dropPanelMenu) {
        this.f18884a = dropPanelMenu;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C4904y.m18639b("DropPanelMenu::onDismiss()", getClass().getSimpleName());
        if (this.f18884a.f18741i.isSelected()) {
            this.f18884a.f18741i.setSelected(false);
        }
        this.f18884a.f18744l.mo19747a();
    }
}
