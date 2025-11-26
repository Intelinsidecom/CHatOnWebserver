package com.sec.chaton.block;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3228cp;

/* compiled from: BlockImpl.java */
/* renamed from: com.sec.chaton.block.o */
/* loaded from: classes.dex */
class C0489o implements InterfaceC0479e {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0487m f1616a;

    C0489o(MenuItemOnMenuItemClickListenerC0487m menuItemOnMenuItemClickListenerC0487m) {
        this.f1616a = menuItemOnMenuItemClickListenerC0487m;
    }

    @Override // com.sec.chaton.block.InterfaceC0479e
    /* renamed from: a */
    public void mo3129a(EnumC1587o enumC1587o) {
        if (enumC1587o == EnumC1587o.NO_CONTENT && this.f1616a.f1611m != null && this.f1616a.f1606h != null) {
            this.f1616a.f1606h.clear();
            if (!GlobalApplication.m6456e()) {
                this.f1616a.f1611m.setTitle(this.f1616a.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1616a.f1606h.size()) + ")");
            } else {
                this.f1616a.f1614p.setText(this.f1616a.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1616a.f1606h.size()) + ")");
            }
            if (this.f1616a.f1612n != null) {
                if (!GlobalApplication.m6456e()) {
                    this.f1616a.f1612n.setVisible(false);
                } else {
                    this.f1616a.f1612n.setEnabled(false);
                    C3228cp.m11343a(this.f1616a.f1612n);
                }
            }
            this.f1616a.f1609k.setVisibility(0);
        }
        this.f1616a.f1606h = this.f1616a.f1608j.f1570a;
        if (this.f1616a.f1611m != null && this.f1616a.f1606h != null) {
            if (!GlobalApplication.m6456e()) {
                this.f1616a.f1611m.setTitle(this.f1616a.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1616a.f1606h.size()) + ")");
            } else {
                this.f1616a.f1614p.setText(this.f1616a.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1616a.f1606h.size()) + ")");
            }
            if (this.f1616a.f1606h.size() == 0) {
                if (this.f1616a.f1612n != null) {
                    if (!GlobalApplication.m6456e()) {
                        this.f1616a.f1612n.setVisible(false);
                    } else {
                        this.f1616a.f1612n.setEnabled(false);
                        C3228cp.m11343a(this.f1616a.f1612n);
                    }
                }
                this.f1616a.f1609k.setVisibility(0);
                return;
            }
            if (this.f1616a.f1612n != null) {
                if (!GlobalApplication.m6456e()) {
                    this.f1616a.f1612n.setVisible(true);
                } else {
                    this.f1616a.f1612n.setEnabled(true);
                    C3228cp.m11343a(this.f1616a.f1612n);
                }
            }
            this.f1616a.f1609k.setVisibility(8);
        }
    }
}
