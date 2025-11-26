package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.l */
/* loaded from: classes.dex */
class C2736l implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2731g f9820a;

    C2736l(AsyncTaskC2731g asyncTaskC2731g) {
        this.f9820a = asyncTaskC2731g;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
            case -1:
                this.f9820a.f9798e = true;
                break;
        }
    }
}
