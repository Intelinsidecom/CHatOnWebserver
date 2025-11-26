package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class PlatformBroadCastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f11516a = PlatformBroadCastReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            if (action.equals("com.sec.chaton.util.ACTION_VIDEO_RECORDING_START")) {
                C4904y.m18639b("Video recording start", f11516a);
                C4809aa.m18104a().m18125b("Video Recording ON", (Boolean) true);
            } else if (action.equals("com.sec.chaton.util.ACTION_VIDEO_RECORDING_STOP")) {
                C4904y.m18639b("Video recording stop", f11516a);
                C4809aa.m18104a().m18125b("Video Recording ON", (Boolean) false);
            }
            if (action.equals("com.sec.android.app.camera.ACTION_START_COVER_CAMERA")) {
                C4904y.m18639b("Camera preview start", f11516a);
                C4809aa.m18104a().m18125b("Camera Preview ON", (Boolean) true);
            } else if (action.equals("com.sec.android.app.camera.ACTION_STOP_COVER_CAMERA")) {
                C4904y.m18639b("Camera preview stop", f11516a);
                C4809aa.m18104a().m18125b("Camera Preview ON", (Boolean) false);
            }
        }
    }
}
