package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.multimedia.audio.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0271b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2078a;

    DialogInterfaceOnClickListenerC0271b(RecordAudio recordAudio) {
        this.f2078a = recordAudio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2078a.f2063m = true;
        this.f2078a.f2064n = false;
        this.f2078a.f2065o = false;
        this.f2078a.f2068r = false;
        this.f2078a.f2069s.setProgress(0);
        dialogInterface.cancel();
    }
}
