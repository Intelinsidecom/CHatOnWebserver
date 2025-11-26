package com.sec.widget;

import android.widget.PopupWindow;
import com.sec.chaton.util.C3250y;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.q */
/* loaded from: classes.dex */
class C3683q implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f13593a;

    C3683q(DropPanelMenu dropPanelMenu) {
        this.f13593a = dropPanelMenu;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C3250y.m11450b("DropPanelMenu::onDismiss()", getClass().getSimpleName());
        if (this.f13593a.f13374i.isSelected()) {
            this.f13593a.f13374i.setSelected(false);
        }
        this.f13593a.f13377l.mo13262a();
    }
}
