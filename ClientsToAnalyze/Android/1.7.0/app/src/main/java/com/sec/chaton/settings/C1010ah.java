package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1341p;

/* compiled from: FragmentAlertTypeView.java */
/* renamed from: com.sec.chaton.settings.ah */
/* loaded from: classes.dex */
class C1010ah implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentAlertTypeView f3614a;

    C1010ah(FragmentAlertTypeView fragmentAlertTypeView) {
        this.f3614a = fragmentAlertTypeView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1341p.m4660c("position = " + i, getClass().getSimpleName());
        this.f3614a.f3481e = i;
        switch (this.f3614a.f3481e) {
            case 0:
                C1057ca.m3934a(this.f3614a.f3480d[0]);
                break;
            case 1:
                C1057ca.m3934a(this.f3614a.f3480d[1]);
                break;
            case 2:
                C1057ca.m3934a(this.f3614a.f3480d[2]);
                break;
            case 3:
                C1057ca.m3934a(this.f3614a.f3480d[3]);
                break;
        }
    }
}
