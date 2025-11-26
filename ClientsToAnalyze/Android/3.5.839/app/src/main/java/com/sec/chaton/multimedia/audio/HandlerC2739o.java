package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: VoiceListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.audio.o */
/* loaded from: classes.dex */
class HandlerC2739o extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2737m f9831a;

    HandlerC2739o(C2737m c2737m) {
        this.f9831a = c2737m;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f9831a.f9826r != null) {
                    ((ImageView) this.f9831a.f9826r).setImageResource(R.drawable.chat_attach_btn_pause);
                    break;
                }
                break;
            case 2:
                if (this.f9831a.f9826r != null) {
                    ((ImageView) this.f9831a.f9826r).setImageResource(R.drawable.chat_attach_btn_play);
                }
                this.f9831a.f9826r = null;
                this.f9831a.f9827s = null;
                break;
        }
    }
}
