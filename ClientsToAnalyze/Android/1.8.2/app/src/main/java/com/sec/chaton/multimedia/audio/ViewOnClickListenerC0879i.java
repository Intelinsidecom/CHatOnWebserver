package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0879i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlayAudio f3273a;

    ViewOnClickListenerC0879i(PlayAudio playAudio) {
        this.f3273a = playAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(ChatFragment.f1748d, this.f3273a.f3215h);
        this.f3273a.setResult(-1, intent);
        this.f3273a.finish();
    }
}
