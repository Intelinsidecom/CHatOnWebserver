package com.sec.chaton.hide;

import android.widget.ListAdapter;
import com.sec.chaton.R;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.q */
/* loaded from: classes.dex */
class C1526q implements InterfaceC1524o {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f5614a;

    C1526q(HideListFragment hideListFragment) {
        this.f5614a = hideListFragment;
    }

    @Override // com.sec.chaton.hide.InterfaceC1524o
    /* renamed from: b */
    public void mo6519b() {
        if (this.f5614a.f5553h != null && this.f5614a.f5553h.isChecked()) {
            this.f5614a.f5553h.setChecked(false);
        }
    }

    @Override // com.sec.chaton.hide.InterfaceC1524o
    /* renamed from: a */
    public void mo6518a() {
        if (this.f5614a.f5553h != null && !this.f5614a.f5553h.isChecked()) {
            this.f5614a.f5553h.setChecked(true);
        }
    }

    @Override // com.sec.chaton.hide.InterfaceC1524o
    /* renamed from: c */
    public void mo6520c() {
        this.f5614a.f5551f = this.f5614a.f5552g.f5602a;
        this.f5614a.f5552g = new C1523n(this.f5614a.f5555j, R.layout.list_item_common_6, this.f5614a.f5551f);
        this.f5614a.f5552g.m6516a(this.f5614a.f5554i);
        this.f5614a.f5550e.setAdapter((ListAdapter) this.f5614a.f5552g);
        if (this.f5614a.f5551f != null && this.f5614a.f5553h != null && this.f5614a.f5551f.size() == 0) {
            this.f5614a.getActivity().finish();
        }
        if (this.f5614a.f5553h != null) {
            this.f5614a.f5553h.setChecked(false);
        }
        this.f5614a.f5552g.m6517a(false);
        this.f5614a.f5556k.setEnabled(false);
    }

    @Override // com.sec.chaton.hide.InterfaceC1524o
    public void onClick() {
        if (this.f5614a.f5552g.f5603b.size() == 0) {
            this.f5614a.f5556k.setEnabled(false);
        } else {
            this.f5614a.f5556k.setEnabled(true);
        }
    }
}
