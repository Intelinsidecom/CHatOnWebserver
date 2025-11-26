package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: VoiceListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.audio.s */
/* loaded from: classes.dex */
class HandlerC1787s extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1785q f6623a;

    HandlerC1787s(C1785q c1785q) {
        this.f6623a = c1785q;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f6623a.f6618f != null) {
                    ((ImageView) this.f6623a.f6618f).setImageResource(R.drawable.chat_attach_btn_pause);
                    break;
                }
                break;
            case 2:
                if (this.f6623a.f6618f != null) {
                    ((ImageView) this.f6623a.f6618f).setImageResource(R.drawable.chat_attach_btn_play);
                }
                this.f6623a.f6618f = null;
                this.f6623a.f6619g = null;
                break;
        }
    }
}
