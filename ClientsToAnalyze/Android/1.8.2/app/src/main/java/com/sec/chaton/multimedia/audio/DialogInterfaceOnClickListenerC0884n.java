package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.chat.ChatFragment;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0884n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3279a;

    DialogInterfaceOnClickListenerC0884n(RecordAudio recordAudio) {
        this.f3279a = recordAudio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IllegalStateException {
        this.f3279a.f3244n = false;
        this.f3279a.f3245o = false;
        this.f3279a.f3237g.setClickable(true);
        this.f3279a.f3250t.stop();
        this.f3279a.f3250t.release();
        Intent intent = new Intent(this.f3279a.f3236f, (Class<?>) PlayAudio.class);
        intent.putExtra("recordtime", Integer.toString(this.f3279a.f3254x));
        intent.putExtra(ChatFragment.f1748d, this.f3279a.f3252v);
        intent.putExtra(PlayAudio.f3207a, PlayAudio.f3208b);
        this.f3279a.startActivityForResult(intent, 0);
        this.f3279a.f3237g.setClickable(true);
    }
}
