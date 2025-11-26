package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0767d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2662a;

    DialogInterfaceOnClickListenerC0767d(RecordAudio recordAudio) {
        this.f2662a = recordAudio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2662a.f2640m = true;
        this.f2662a.f2641n = false;
        this.f2662a.f2642o = false;
        this.f2662a.f2645r = false;
        this.f2662a.f2646s.setProgress(0);
        this.f2662a.f2646s.setPressed(false);
        dialogInterface.cancel();
    }
}
