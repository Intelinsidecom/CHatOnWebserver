package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0885o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3280a;

    DialogInterfaceOnClickListenerC0885o(RecordAudio recordAudio) {
        this.f3280a = recordAudio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3280a.f3243m = true;
        this.f3280a.f3244n = false;
        this.f3280a.f3245o = false;
        this.f3280a.f3248r = false;
        this.f3280a.f3249s.setProgress(0);
        this.f3280a.f3249s.setPressed(false);
        dialogInterface.cancel();
    }
}
