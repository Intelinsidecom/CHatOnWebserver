package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.aw */
/* loaded from: classes.dex */
class C2435aw implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C2434av f9295a;

    C2435aw(C2434av c2434av) {
        this.f9295a = c2434av;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            this.f9295a.f9294a.f9013r = 0;
        } else {
            this.f9295a.f9294a.f9013r = 1;
        }
    }
}
