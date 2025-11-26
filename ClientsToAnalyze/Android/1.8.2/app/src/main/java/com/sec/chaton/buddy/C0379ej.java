package com.sec.chaton.buddy;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ej */
/* loaded from: classes.dex */
class C0379ej implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1537a;

    C0379ej(GroupProfileFragment groupProfileFragment) {
        this.f1537a = groupProfileFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1537a.f1228q.getOnItemSelectedListener().onItemSelected(adapterView, view, i, j);
        this.f1537a.f1228q.setVisibility(8);
    }
}
