package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.sec.vip.amschaton.C3410al;

/* compiled from: AMSEmoticonSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.as */
/* loaded from: classes.dex */
class C3471as implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSEmoticonSelectionFragment f12833a;

    C3471as(AMSEmoticonSelectionFragment aMSEmoticonSelectionFragment) {
        this.f12833a = aMSEmoticonSelectionFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int iM12196e = C3410al.m12173a().m12196e();
        if (i >= 0 && i < iM12196e) {
            this.f12833a.m12522b(i);
        }
    }
}
