package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bf */
/* loaded from: classes.dex */
class C3485bf implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12854a;

    C3485bf(AMSListFragment aMSListFragment) {
        this.f12854a = aMSListFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12854a.f12722A = false;
        if (this.f12854a.f12739u == 4000) {
            this.f12854a.f12730c = j;
            this.f12854a.getActivity().openContextMenu(this.f12854a.f12731m);
        } else if (i != 0 && this.f12854a.f12728a != 2002) {
            if (i >= this.f12854a.m12571h() + this.f12854a.m12574i() + 1 && i < this.f12854a.m12571h() + this.f12854a.m12574i() + this.f12854a.m12576j() + 1) {
                this.f12854a.f12722A = true;
            }
            this.f12854a.f12729b = i;
            this.f12854a.getActivity().openContextMenu(this.f12854a.f12731m);
        }
        return true;
    }
}
