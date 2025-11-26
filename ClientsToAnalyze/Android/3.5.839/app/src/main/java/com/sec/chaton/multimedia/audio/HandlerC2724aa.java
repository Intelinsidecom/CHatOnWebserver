package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;

/* compiled from: VoiceRecordDialog.java */
/* renamed from: com.sec.chaton.multimedia.audio.aa */
/* loaded from: classes.dex */
class HandlerC2724aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC2747w f9761a;

    HandlerC2724aa(DialogC2747w dialogC2747w) {
        this.f9761a = dialogC2747w;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        switch (message.what) {
            case 1:
                this.f9761a.f9854c.setImageResource(R.drawable.chat_attach_btn_pause);
                if (this.f9761a.f9856e != null) {
                    int iM11510c = this.f9761a.f9856e.m11510c();
                    this.f9761a.f9868q = iM11510c / 60000;
                    this.f9761a.f9869r = (iM11510c / 1000) % 60;
                    this.f9761a.f9867p.setMax(iM11510c);
                    this.f9761a.f9867p.setProgress(0);
                    this.f9761a.m11515a(this.f9761a.f9868q, this.f9761a.f9869r, 0, 0);
                    break;
                }
                break;
            case 2:
                this.f9761a.f9854c.setImageResource(R.drawable.chat_attach_btn_play);
                this.f9761a.f9860i.setImageResource(R.drawable.chat_none_recoding);
                this.f9761a.f9867p.setProgress(0);
                this.f9761a.m11515a(this.f9761a.f9868q, this.f9761a.f9869r, 0, 0);
                break;
            case 3:
                if (message.obj != null) {
                    try {
                        int i = Integer.parseInt(message.obj.toString());
                        this.f9761a.f9867p.setProgress(i);
                        this.f9761a.m11515a(this.f9761a.f9868q, this.f9761a.f9869r, i / 60000, (i / 1000) % 60);
                        break;
                    } catch (NumberFormatException e) {
                        return;
                    }
                }
                break;
        }
    }
}
