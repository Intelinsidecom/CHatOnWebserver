package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: AmsItemDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2636k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AmsItemDownloads f9879a;

    DialogInterfaceOnClickListenerC2636k(AmsItemDownloads amsItemDownloads) {
        this.f9879a = amsItemDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9879a.f9436h != null) {
            if (this.f9879a.f9436h.m9426a()) {
                this.f9879a.f9436h.m9427b();
            }
            this.f9879a.f9436h.m9429c();
        }
        if (this.f9879a.f9439k != null) {
            C3641ai.m13211a(this.f9879a.f9430b, this.f9879a.getString(R.string.download_stopped), 0).show();
            this.f9879a.f9430b.finish();
        }
    }
}
