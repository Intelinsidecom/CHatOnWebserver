package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2520k;

/* compiled from: FontDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2562bb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FontDetail f9741a;

    DialogInterfaceOnClickListenerC2562bb(FontDetail fontDetail) {
        this.f9741a = fontDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2520k(this.f9741a.getActivity(), true).execute(this.f9741a.f9498c);
    }
}
