package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;

/* compiled from: FragmentAlertTypeView.java */
/* renamed from: com.sec.chaton.settings.bo */
/* loaded from: classes.dex */
class C1263bo implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentAlertTypeView f4804a;

    C1263bo(FragmentAlertTypeView fragmentAlertTypeView) {
        this.f4804a = fragmentAlertTypeView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1786r.m6063c("position = " + i, getClass().getSimpleName());
        this.f4804a.f4589e = i;
        switch (this.f4804a.f4589e) {
            case 0:
                SettingFragment.m4702a(this.f4804a.f4588d[0]);
                break;
            case 1:
                SettingFragment.m4702a(this.f4804a.f4588d[1]);
                break;
            case 2:
                SettingFragment.m4702a(this.f4804a.f4588d[2]);
                break;
            case 3:
                SettingFragment.m4702a(this.f4804a.f4588d[3]);
                break;
        }
    }
}
