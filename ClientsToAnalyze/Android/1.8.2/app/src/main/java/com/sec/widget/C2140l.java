package com.sec.widget;

import android.widget.PopupWindow;
import com.sec.chaton.util.C1786r;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.l */
/* loaded from: classes.dex */
class C2140l implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f7788a;

    C2140l(DropPanelMenu dropPanelMenu) {
        this.f7788a = dropPanelMenu;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C1786r.m6061b("DropPanelMenu::onDismiss()", getClass().getSimpleName());
        if (this.f7788a.f7705i.isSelected()) {
            this.f7788a.f7705i.setSelected(false);
        }
        this.f7788a.f7708l.mo7493a();
    }
}
