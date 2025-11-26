package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.i */
/* loaded from: classes.dex */
class C3556i implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12986a;

    C3556i(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12986a = aMSBgSelectionFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f12986a.f12645u == 5000) {
            this.f12986a.f12650z = j;
            this.f12986a.getActivity().openContextMenu(this.f12986a.f12635b);
        } else if (i != 0 && i != 1 && ((i < this.f12986a.m12409n() + 2 || i >= this.f12986a.m12409n() + this.f12986a.m12411o() + 2) && i != this.f12986a.m12409n() + this.f12986a.m12411o() + 2 && this.f12986a.f12646v == 3001)) {
            this.f12986a.f12649y = i;
            this.f12986a.getActivity().openContextMenu(this.f12986a.f12635b);
        }
        return true;
    }
}
