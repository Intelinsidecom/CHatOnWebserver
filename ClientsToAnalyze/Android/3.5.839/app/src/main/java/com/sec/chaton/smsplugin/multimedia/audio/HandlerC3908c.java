package com.sec.chaton.smsplugin.multimedia.audio;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: MmsVoiceListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.audio.c */
/* loaded from: classes.dex */
class HandlerC3908c extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3906a f14045a;

    HandlerC3908c(C3906a c3906a) {
        this.f14045a = c3906a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f14045a.f14040r != null) {
                    ((ImageView) this.f14045a.f14040r).setImageResource(R.drawable.chat_attach_btn_pause);
                    break;
                }
                break;
            case 2:
                if (this.f14045a.f14040r != null) {
                    ((ImageView) this.f14045a.f14040r).setImageResource(R.drawable.chat_attach_btn_play);
                }
                this.f14045a.f14040r = null;
                this.f14045a.f14041s = null;
                break;
        }
    }
}
