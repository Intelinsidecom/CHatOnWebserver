package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.v */
/* loaded from: classes.dex */
class ViewOnClickListenerC0785v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlayAudio f2683a;

    ViewOnClickListenerC0785v(PlayAudio playAudio) {
        this.f2683a = playAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(ChatFragment.f1727b, this.f2683a.f2612h);
        this.f2683a.setResult(-1, intent);
        this.f2683a.finish();
    }
}
