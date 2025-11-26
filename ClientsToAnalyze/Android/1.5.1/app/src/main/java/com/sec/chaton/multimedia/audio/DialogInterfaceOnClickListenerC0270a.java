package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.chat.ChatFragment;

/* renamed from: com.sec.chaton.multimedia.audio.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0270a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2077a;

    DialogInterfaceOnClickListenerC0270a(RecordAudio recordAudio) {
        this.f2077a = recordAudio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IllegalStateException {
        this.f2077a.f2064n = false;
        this.f2077a.f2065o = false;
        this.f2077a.f2056f.setClickable(true);
        this.f2077a.f2070t.stop();
        this.f2077a.f2070t.release();
        Intent intent = new Intent(this.f2077a.f2055e, (Class<?>) PlayAudio.class);
        intent.putExtra("recordtime", Integer.toString(this.f2077a.f2074x));
        intent.putExtra(ChatFragment.f723b, this.f2077a.f2072v);
        intent.putExtra(PlayAudio.f2036a, PlayAudio.f2037b);
        this.f2077a.startActivityForResult(intent, 0);
        this.f2077a.f2056f.setClickable(true);
    }
}
