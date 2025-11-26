package com.sec.chaton.block;

import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4880cr;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.f */
/* loaded from: classes.dex */
class C1078f implements InterfaceC1076d {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f3458a;

    C1078f(BlockFragment blockFragment) {
        this.f3458a = blockFragment;
    }

    @Override // com.sec.chaton.block.InterfaceC1076d
    /* renamed from: a */
    public void mo6222a(EnumC2464o enumC2464o) throws Throwable {
        if (enumC2464o == EnumC2464o.NO_CONTENT && this.f3458a.f3421q != null && this.f3458a.f3412h != null) {
            this.f3458a.f3412h.clear();
            this.f3458a.f3421q.setTitle(this.f3458a.getResources().getString(R.string.settings_blocked_contacts) + " (" + Integer.toString(this.f3458a.f3412h.size()) + ")");
            if (this.f3458a.f3423s != null) {
                this.f3458a.f3423s.setEnabled(false);
                C4880cr.m18523a(this.f3458a.f3423s);
            }
        }
        this.f3458a.f3412h = this.f3458a.f3414j.f3442a;
        if (this.f3458a.f3421q != null && this.f3458a.f3412h != null) {
            this.f3458a.f3421q.setTitle(this.f3458a.getResources().getString(R.string.settings_blocked_contacts) + " (" + Integer.toString(this.f3458a.f3412h.size()) + ")");
            if (this.f3458a.f3412h.size() == 0) {
                if (this.f3458a.f3423s != null) {
                    this.f3458a.f3423s.setEnabled(false);
                    C4880cr.m18523a(this.f3458a.f3423s);
                }
                this.f3458a.m6188b();
            } else if (this.f3458a.f3423s != null) {
                this.f3458a.f3423s.setEnabled(true);
                C4880cr.m18523a(this.f3458a.f3423s);
            }
            if (this.f3458a.f3422r != null) {
                if ((C2190d.m9798a(this.f3458a.f3421q.getContentResolver()) - C2190d.m9825c(this.f3458a.f3421q.getContentResolver())) - C2190d.m9817b(this.f3458a.f3421q.getContentResolver()) <= 0) {
                    this.f3458a.f3422r.setEnabled(false);
                } else {
                    this.f3458a.f3422r.setEnabled(true);
                }
                C4880cr.m18523a(this.f3458a.f3422r);
            }
        }
    }
}
