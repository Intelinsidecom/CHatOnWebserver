package com.sec.chaton.block;

import android.widget.ListAdapter;
import com.sec.chaton.R;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.w */
/* loaded from: classes.dex */
class C0497w implements InterfaceC0495u {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f1635a;

    C0497w(BlockListFragment blockListFragment) {
        this.f1635a = blockListFragment;
    }

    @Override // com.sec.chaton.block.InterfaceC0495u
    /* renamed from: b */
    public void mo3161b() {
        if (this.f1635a.f1566j != null && this.f1635a.f1566j.isChecked()) {
            this.f1635a.f1566j.setChecked(false);
        }
        this.f1635a.f1565i.m3159b();
    }

    @Override // com.sec.chaton.block.InterfaceC0495u
    /* renamed from: a */
    public void mo3160a() {
        if (this.f1635a.f1566j != null && !this.f1635a.f1566j.isChecked()) {
            this.f1635a.f1566j.setChecked(true);
        }
        this.f1635a.f1565i.m3159b();
    }

    @Override // com.sec.chaton.block.InterfaceC0495u
    /* renamed from: c */
    public void mo3162c() {
        this.f1635a.f1563g = this.f1635a.f1565i.f1620a;
        this.f1635a.f1565i = new C0493s(this.f1635a.f1568l, R.layout.list_item_common_6, this.f1635a.f1563g);
        this.f1635a.f1565i.m3157a(this.f1635a.f1567k);
        this.f1635a.f1562f.setAdapter((ListAdapter) this.f1635a.f1565i);
        if (this.f1635a.f1563g != null && this.f1635a.f1566j != null && this.f1635a.f1563g.size() == 0) {
            this.f1635a.getActivity().finish();
        }
        if (this.f1635a.f1566j != null) {
            this.f1635a.f1566j.setChecked(false);
        }
        this.f1635a.f1565i.m3158a(false);
        this.f1635a.f1569m.setEnabled(false);
    }

    @Override // com.sec.chaton.block.InterfaceC0495u
    public void onClick() {
        if (this.f1635a.f1565i.f1621b.size() == 0) {
            this.f1635a.f1569m.setEnabled(false);
        } else {
            this.f1635a.f1569m.setEnabled(true);
        }
        this.f1635a.f1565i.m3159b();
    }

    @Override // com.sec.chaton.block.InterfaceC0495u
    /* renamed from: d */
    public void mo3163d() {
        this.f1635a.f1568l.finish();
    }
}
