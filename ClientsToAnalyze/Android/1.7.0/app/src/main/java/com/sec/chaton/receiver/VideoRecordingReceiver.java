package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class VideoRecordingReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3136a = VideoRecordingReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.sec.chaton.util.ACTION_VIDEO_RECORDING_START")) {
            C1341p.m4658b("Video recording start", f3136a);
            C1323bs.m4575a().edit().putBoolean("Video Recording ON", true).commit();
        } else if (action.equals("com.sec.chaton.util.ACTION_VIDEO_RECORDING_STOP")) {
            C1341p.m4658b("Video recording stop", f3136a);
            C1323bs.m4575a().edit().putBoolean("Video Recording ON", false).commit();
        }
    }
}
