package com.sec.chaton.block;

import android.widget.ListAdapter;
import com.sec.chaton.R;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.o */
/* loaded from: classes.dex */
class C1087o implements InterfaceC1085m {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f3478a;

    C1087o(BlockListFragment blockListFragment) {
        this.f3478a = blockListFragment;
    }

    @Override // com.sec.chaton.block.InterfaceC1085m
    /* renamed from: a */
    public void mo6231a() {
        if (this.f3478a.f3434j != null && !this.f3478a.f3434j.isChecked()) {
            this.f3478a.f3434j.setChecked(true);
        }
        this.f3478a.f3433i.m6230b();
    }

    @Override // com.sec.chaton.block.InterfaceC1085m
    /* renamed from: b */
    public void mo6232b() {
        this.f3478a.f3431g = this.f3478a.f3433i.f3463a;
        this.f3478a.f3433i = new C1083k(this.f3478a.f3436l, R.layout.list_item_common_6, this.f3478a.f3431g);
        this.f3478a.f3433i.m6228a(this.f3478a.f3435k);
        this.f3478a.f3430f.setAdapter((ListAdapter) this.f3478a.f3433i);
        if (this.f3478a.f3431g != null && this.f3478a.f3434j != null && this.f3478a.f3431g.size() == 0) {
            this.f3478a.getActivity().finish();
        }
        if (this.f3478a.f3434j != null) {
            this.f3478a.f3434j.setChecked(false);
        }
        this.f3478a.f3433i.m6229a(false);
        this.f3478a.f3437m.setEnabled(false);
    }

    @Override // com.sec.chaton.block.InterfaceC1085m
    public void onClick() {
        if (this.f3478a.f3437m != null) {
            if (this.f3478a.f3433i.f3464b.size() == 0) {
                this.f3478a.f3437m.setEnabled(false);
            } else {
                this.f3478a.f3437m.setEnabled(true);
            }
        }
        this.f3478a.f3433i.m6230b();
    }

    @Override // com.sec.chaton.block.InterfaceC1085m
    /* renamed from: c */
    public void mo6233c() {
        this.f3478a.f3436l.finish();
    }
}
