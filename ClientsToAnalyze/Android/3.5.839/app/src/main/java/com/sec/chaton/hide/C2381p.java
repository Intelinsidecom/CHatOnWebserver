package com.sec.chaton.hide;

import android.widget.ListAdapter;
import com.sec.chaton.R;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.p */
/* loaded from: classes.dex */
class C2381p implements InterfaceC2379n {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f8468a;

    C2381p(HideListFragment hideListFragment) {
        this.f8468a = hideListFragment;
    }

    @Override // com.sec.chaton.hide.InterfaceC2379n
    /* renamed from: a */
    public void mo10364a() {
        if (this.f8468a.f8423i != null && !this.f8468a.f8423i.isChecked()) {
            this.f8468a.f8423i.setChecked(true);
        }
        this.f8468a.f8422h.m10363b();
    }

    @Override // com.sec.chaton.hide.InterfaceC2379n
    /* renamed from: b */
    public void mo10365b() {
        this.f8468a.f8421g = this.f8468a.f8422h.f8453a;
        this.f8468a.f8422h = new C2377l(this.f8468a.f8425k, R.layout.list_item_common_6, this.f8468a.f8421g);
        this.f8468a.f8422h.m10361a(this.f8468a.f8424j);
        this.f8468a.f8420f.setAdapter((ListAdapter) this.f8468a.f8422h);
        if (this.f8468a.f8421g != null && this.f8468a.f8423i != null && this.f8468a.f8421g.size() == 0) {
            this.f8468a.getActivity().finish();
        }
        if (this.f8468a.f8423i != null) {
            this.f8468a.f8423i.setChecked(false);
        }
        this.f8468a.f8422h.m10362a(false);
        this.f8468a.f8426l.setEnabled(false);
    }

    @Override // com.sec.chaton.hide.InterfaceC2379n
    public void onClick() {
        if (this.f8468a.f8426l != null) {
            if (this.f8468a.f8422h.f8454b.size() == 0) {
                this.f8468a.f8426l.setEnabled(false);
            } else {
                this.f8468a.f8426l.setEnabled(true);
            }
        }
        this.f8468a.f8422h.m10363b();
    }

    @Override // com.sec.chaton.hide.InterfaceC2379n
    /* renamed from: c */
    public void mo10366c() {
        this.f8468a.f8425k.finish();
    }
}
