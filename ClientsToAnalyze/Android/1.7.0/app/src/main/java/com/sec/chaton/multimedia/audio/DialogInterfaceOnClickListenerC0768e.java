package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.chat.ChatFragment;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0768e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2663a;

    DialogInterfaceOnClickListenerC0768e(RecordAudio recordAudio) {
        this.f2663a = recordAudio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IllegalStateException {
        this.f2663a.f2641n = false;
        this.f2663a.f2642o = false;
        this.f2663a.f2634g.setClickable(true);
        this.f2663a.f2647t.stop();
        this.f2663a.f2647t.release();
        Intent intent = new Intent(this.f2663a.f2633f, (Class<?>) PlayAudio.class);
        intent.putExtra("recordtime", Integer.toString(this.f2663a.f2651x));
        intent.putExtra(ChatFragment.f1727b, this.f2663a.f2649v);
        intent.putExtra(PlayAudio.f2604a, PlayAudio.f2605b);
        this.f2663a.startActivityForResult(intent, 0);
        this.f2663a.f2634g.setClickable(true);
    }
}
