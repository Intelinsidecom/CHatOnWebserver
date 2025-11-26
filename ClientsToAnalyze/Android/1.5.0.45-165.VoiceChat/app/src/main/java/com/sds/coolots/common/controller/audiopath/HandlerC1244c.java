package com.sds.coolots.common.controller.audiopath;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.view.DisposeInterface;

/* renamed from: com.sds.coolots.common.controller.audiopath.c */
/* loaded from: classes.dex */
class HandlerC1244c extends Handler implements DisposeInterface {

    /* renamed from: a */
    final /* synthetic */ C1242a f2971a;

    /* renamed from: b */
    private boolean f2972b = false;

    HandlerC1244c(C1242a c1242a) {
        this.f2971a = c1242a;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.f2972b = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2972b) {
            return;
        }
        if (message.what == 1000) {
            this.f2971a.m2855b("SpeakerDelayHandler: MSG_CALL_START_SPEAKER_SET_DELAYED");
            this.f2971a.m2855b("haeri= SpeakerDelayHandler: (Boolean)msg.obj :" + ((Boolean) message.obj) + "/ mISpeakerOn :" + this.f2971a.f2957b);
            if (this.f2971a.f2957b == ((Boolean) message.obj).booleanValue()) {
                this.f2971a.m2872a(((Boolean) message.obj).booleanValue());
            }
            this.f2971a.f2967x.removeMessages(1000);
            return;
        }
        if (message.what != 3000) {
            if (message.what == 3001) {
                this.f2971a.m2855b("SpeakerDelayHandler: MSG_BT_SPEAKER_SET_DELAYED_SECOND");
                this.f2971a.m2870a();
                return;
            }
            return;
        }
        this.f2971a.m2855b("SpeakerDelayHandler: MSG_BT_SPEAKER_SET_DELAYED_FIRST");
        if (this.f2971a.f2964i == null) {
            this.f2971a.f2964i = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this.f2971a.f2964i.isBluetoothScoOn()) {
            this.f2971a.m2855b("SpeakerDelayHandler: Now SCO is on, it needs to extend the delay time.");
            this.f2971a.m2871a(3001);
        } else {
            this.f2971a.m2855b("SpeakerDelayHandler: Now SCO is off");
            this.f2971a.m2870a();
        }
    }
}
