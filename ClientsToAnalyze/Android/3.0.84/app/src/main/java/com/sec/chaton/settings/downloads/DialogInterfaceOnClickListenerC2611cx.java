package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2533x;

/* compiled from: SoundDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.cx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2611cx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SoundDetail f9836a;

    DialogInterfaceOnClickListenerC2611cx(SoundDetail soundDetail) {
        this.f9836a = soundDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2533x(this.f9836a.getActivity(), true).execute(this.f9836a.f9572d);
    }
}
