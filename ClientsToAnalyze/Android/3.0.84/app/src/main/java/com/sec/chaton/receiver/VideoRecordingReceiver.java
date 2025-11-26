package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class VideoRecordingReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f8073a = VideoRecordingReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.sec.chaton.util.ACTION_VIDEO_RECORDING_START")) {
            C3250y.m11450b("Video recording start", f8073a);
            C3159aa.m10962a().m10983b("Video Recording ON", (Boolean) true);
        } else if (action.equals("com.sec.chaton.util.ACTION_VIDEO_RECORDING_STOP")) {
            C3250y.m11450b("Video recording stop", f8073a);
            C3159aa.m10962a().m10983b("Video Recording ON", (Boolean) false);
        }
    }
}
