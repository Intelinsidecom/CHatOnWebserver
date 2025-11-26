package com.sec.chaton.settings.downloads;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.an */
/* loaded from: classes.dex */
class C2547an implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDownloads f9693a;

    C2547an(AniconPackageDownloads aniconPackageDownloads) {
        this.f9693a = aniconPackageDownloads;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String strM9478a = this.f9693a.f9485g.m9478a(view);
        if (!TextUtils.isEmpty(strM9478a)) {
            this.f9693a.m9333a(strM9478a);
        }
    }
}
