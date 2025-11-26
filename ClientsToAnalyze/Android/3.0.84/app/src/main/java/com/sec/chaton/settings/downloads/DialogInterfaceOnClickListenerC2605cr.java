package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: SkinListView.java */
/* renamed from: com.sec.chaton.settings.downloads.cr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2605cr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SkinListView f9832a;

    DialogInterfaceOnClickListenerC2605cr(SkinListView skinListView) {
        this.f9832a = skinListView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9832a.f9564h != null) {
            if (this.f9832a.f9564h.m9560a()) {
                this.f9832a.f9564h.m9561b();
            }
            this.f9832a.f9564h.m9562c();
        }
        if (this.f9832a.f9564h != null && this.f9832a.f9564h.m9560a()) {
            C3641ai.m13211a(this.f9832a.f9558b, this.f9832a.getString(R.string.download_stopped), 0).show();
            this.f9832a.f9558b.finish();
        }
    }
}
