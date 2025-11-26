package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;

/* renamed from: com.sec.chaton.multimedia.audio.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC0285p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlayAudio f2095a;

    ViewOnClickListenerC0285p(PlayAudio playAudio) {
        this.f2095a = playAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(ChatFragment.f723b, this.f2095a.f2044h);
        this.f2095a.setResult(-1, intent);
        this.f2095a.finish();
    }
}
