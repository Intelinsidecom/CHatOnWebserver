package com.sec.chaton.for3rd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.coolots.C0529i;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class PackageInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("PackageInstallReceiver", getClass().getSimpleName());
        if (C1789u.m6075a().contains("uid") && !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
            boolean zEquals = intent.getAction().equals("android.intent.action.PACKAGE_ADDED");
            boolean zEquals2 = intent.getAction().equals("android.intent.action.PACKAGE_REMOVED");
            String strSubstring = intent.getDataString().substring("package:".length());
            if (strSubstring.equals("com.coolots.chaton")) {
                if (zEquals || zEquals2) {
                    C1789u.m6077a("enable_voice_call", Integer.valueOf(C0529i.f2153f));
                    C1789u.m6077a("enable_video_call", Integer.valueOf(C0529i.f2153f));
                    C1789u.m6077a("group_voice_call_max_count", Integer.valueOf(C0529i.f2153f));
                    C1789u.m6077a("group_video_call_max_count", Integer.valueOf(C0529i.f2153f));
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
