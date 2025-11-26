package com.sec.chaton.for3rd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.coolots.C0613d;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class PackageInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("PackageInstallReceiver", getClass().getSimpleName());
        if (C1323bs.m4575a().contains("uid") && !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
            boolean zEquals = intent.getAction().equals("android.intent.action.PACKAGE_ADDED");
            boolean zEquals2 = intent.getAction().equals("android.intent.action.PACKAGE_REMOVED");
            String strSubstring = intent.getDataString().substring("package:".length());
            if (strSubstring.equals("com.coolots.chaton")) {
                if (zEquals || zEquals2) {
                    C1323bs.m4577a("enable_voice_call", Integer.valueOf(C0613d.f2154b));
                    C1323bs.m4577a("enable_video_call", Integer.valueOf(C0613d.f2154b));
                    C1323bs.m4577a("group_voice_call_max_count", Integer.valueOf(C0613d.f2154b));
                    C1323bs.m4577a("group_video_call_max_count", Integer.valueOf(C0613d.f2154b));
                }
                Intent intent2 = new Intent(context, (Class<?>) AddonStatusService.class);
                intent2.putExtra("package_name", strSubstring);
                intent2.putExtra("is_installed", zEquals);
                intent2.putExtra("is_removed", zEquals2);
                context.startService(intent2);
            }
        }
    }
}
