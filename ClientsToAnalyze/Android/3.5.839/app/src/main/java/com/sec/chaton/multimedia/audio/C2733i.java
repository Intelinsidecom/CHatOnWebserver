package com.sec.chaton.multimedia.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.i */
/* loaded from: classes.dex */
class C2733i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2731g f9815a;

    C2733i(AsyncTaskC2731g asyncTaskC2731g) {
        this.f9815a = asyncTaskC2731g;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceive : " + intent.getAction(), AsyncTaskC2731g.f9794a);
        }
        this.f9815a.m11481d();
    }
}
