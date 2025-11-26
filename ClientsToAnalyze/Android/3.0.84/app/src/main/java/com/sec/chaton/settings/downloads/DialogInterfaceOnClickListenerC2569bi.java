package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: FontDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2569bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FontDownloads f9749a;

    DialogInterfaceOnClickListenerC2569bi(FontDownloads fontDownloads) {
        this.f9749a = fontDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9749a.f9529h != null) {
            if (this.f9749a.f9529h.m9536a()) {
                this.f9749a.f9529h.m9537b();
            }
            this.f9749a.f9529h.m9538c();
        }
        if (this.f9749a.f9529h != null && this.f9749a.f9529h.m9536a()) {
            C3641ai.m13211a(this.f9749a.f9524c, this.f9749a.f9524c.getString(R.string.download_stopped), 0).show();
            this.f9749a.f9524c.finish();
        }
    }
}
