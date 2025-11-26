package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: SoundDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.de */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2619de implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SoundDownloads f9844a;

    DialogInterfaceOnClickListenerC2619de(SoundDownloads soundDownloads) {
        this.f9844a = soundDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9844a.f9598g != null) {
            if (this.f9844a.f9598g.m9624a()) {
                this.f9844a.f9598g.m9626b();
            }
            this.f9844a.f9598g.m9628c();
        }
        if (this.f9844a.f9598g != null && this.f9844a.f9598g.m9624a()) {
            C3641ai.m13211a(this.f9844a.f9593b, this.f9844a.f9593b.getString(R.string.download_stopped), 0).show();
            this.f9844a.f9593b.finish();
        }
    }
}
