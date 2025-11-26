package com.sec.chaton.hide;

import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4880cr;

/* compiled from: HideFragment.java */
/* renamed from: com.sec.chaton.hide.g */
/* loaded from: classes.dex */
class C2372g implements InterfaceC2370e {

    /* renamed from: a */
    final /* synthetic */ HideFragment f8448a;

    C2372g(HideFragment hideFragment) {
        this.f8448a = hideFragment;
    }

    @Override // com.sec.chaton.hide.InterfaceC2370e
    /* renamed from: a */
    public void mo10355a(EnumC2464o enumC2464o) throws Throwable {
        if (enumC2464o == EnumC2464o.NO_CONTENT && this.f8448a.f8411p != null && this.f8448a.f8403h != null) {
            this.f8448a.f8403h.clear();
            this.f8448a.f8411p.setTitle(this.f8448a.getResources().getString(R.string.settings_hided_contacts) + " (" + Integer.toString(this.f8448a.f8403h.size()) + ")");
            if (this.f8448a.f8413r != null) {
                this.f8448a.f8413r.setEnabled(false);
                C4880cr.m18523a(this.f8448a.f8413r);
            }
        }
        this.f8448a.f8403h = this.f8448a.f8405j.f8432a;
        if (this.f8448a.f8411p != null && this.f8448a.f8403h != null) {
            this.f8448a.f8411p.setTitle(this.f8448a.getResources().getString(R.string.settings_hided_contacts) + " (" + Integer.toString(this.f8448a.f8403h.size()) + ")");
            if (this.f8448a.f8403h.size() == 0) {
                if (this.f8448a.f8413r != null) {
                    this.f8448a.f8413r.setEnabled(false);
                    C4880cr.m18523a(this.f8448a.f8413r);
                }
                this.f8448a.m10327b();
            } else if (this.f8448a.f8413r != null) {
                this.f8448a.f8413r.setEnabled(true);
                C4880cr.m18523a(this.f8448a.f8413r);
            }
            if (this.f8448a.f8412q != null) {
                if ((C2190d.m9798a(this.f8448a.f8411p.getContentResolver()) - C2190d.m9825c(this.f8448a.f8411p.getContentResolver())) - C2190d.m9817b(this.f8448a.f8411p.getContentResolver()) <= 0) {
                    this.f8448a.f8412q.setEnabled(false);
                } else {
                    this.f8448a.f8412q.setEnabled(true);
                }
                C4880cr.m18523a(this.f8448a.f8412q);
            }
        }
    }
}
