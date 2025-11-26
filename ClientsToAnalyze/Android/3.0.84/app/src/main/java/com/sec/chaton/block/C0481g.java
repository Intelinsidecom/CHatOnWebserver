package com.sec.chaton.block;

import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3228cp;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.g */
/* loaded from: classes.dex */
class C0481g implements InterfaceC0479e {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1593a;

    C0481g(BlockFragment blockFragment) {
        this.f1593a = blockFragment;
    }

    @Override // com.sec.chaton.block.InterfaceC0479e
    /* renamed from: a */
    public void mo3129a(EnumC1587o enumC1587o) {
        if (enumC1587o == EnumC1587o.NO_CONTENT && this.f1593a.f1553n != null && this.f1593a.f1548i != null) {
            this.f1593a.f1548i.clear();
            this.f1593a.f1553n.setTitle(this.f1593a.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1593a.f1548i.size()) + ")");
            if (this.f1593a.f1555p != null) {
                this.f1593a.f1555p.setEnabled(false);
                C3228cp.m11343a(this.f1593a.f1555p);
            }
            this.f1593a.f1551l.setVisibility(0);
        }
        this.f1593a.f1548i = this.f1593a.f1550k.f1570a;
        if (this.f1593a.f1553n != null && this.f1593a.f1548i != null) {
            this.f1593a.f1553n.setTitle(this.f1593a.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1593a.f1548i.size()) + ")");
            if (this.f1593a.f1548i.size() == 0) {
                if (this.f1593a.f1555p != null) {
                    this.f1593a.f1555p.setEnabled(false);
                    C3228cp.m11343a(this.f1593a.f1555p);
                }
                this.f1593a.f1551l.setVisibility(0);
            } else {
                if (this.f1593a.f1555p != null) {
                    this.f1593a.f1555p.setEnabled(true);
                    C3228cp.m11343a(this.f1593a.f1555p);
                }
                this.f1593a.f1551l.setVisibility(8);
            }
            if (this.f1593a.f1554o != null) {
                if (C1360d.m6034b(this.f1593a.f1553n.getContentResolver()) - C1360d.m6041c(this.f1593a.f1553n.getContentResolver()) <= 0) {
                    this.f1593a.f1554o.setEnabled(false);
                } else {
                    this.f1593a.f1554o.setEnabled(true);
                }
                C3228cp.m11343a(this.f1593a.f1554o);
            }
        }
    }
}
