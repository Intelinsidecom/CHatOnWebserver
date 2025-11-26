package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cl */
/* loaded from: classes.dex */
class C3518cl implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12916a;

    C3518cl(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12916a = aMSStampSelectionFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f12916a.f12763v != 5000 && i != 0 && i <= this.f12916a.m12645m() + this.f12916a.m12651p() + this.f12916a.m12647n() && this.f12916a.f12754m == 2001) {
            this.f12916a.f12758q = i;
            this.f12916a.getActivity().openContextMenu(this.f12916a.f12752b);
        }
        return true;
    }
}
