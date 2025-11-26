package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2552as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDownloads f9699a;

    DialogInterfaceOnClickListenerC2552as(AniconPackageDownloads aniconPackageDownloads) {
        this.f9699a = aniconPackageDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9699a.f9485g != null) {
            if (this.f9699a.f9485g.m9481a()) {
                this.f9699a.f9485g.m9482b();
            }
            this.f9699a.f9485g.m9483c();
        }
        if (this.f9699a.f9485g != null && this.f9699a.f9485g.m9481a()) {
            C3641ai.m13211a(this.f9699a.f9480b, this.f9699a.f9480b.getString(R.string.download_stopped), 0).show();
            this.f9699a.f9480b.finish();
        }
    }
}
