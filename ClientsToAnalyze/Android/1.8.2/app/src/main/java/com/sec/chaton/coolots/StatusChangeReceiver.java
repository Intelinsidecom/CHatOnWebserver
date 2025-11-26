package com.sec.chaton.coolots;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.account.C0210g;
import com.sec.chaton.for3rd.AddonStatusService;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class StatusChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("Received action : " + intent.getAction(), C0210g.class.getSimpleName());
        if (intent.getAction().equals("com.coolots.chaton.calllog.CALLEND_LOGINFO")) {
            String stringExtra = intent.getStringExtra("callLog_calldate");
            long longExtra = intent.getLongExtra("callLog_calldate_gmttime", 0L);
            int intExtra = intent.getIntExtra("callLog_duration", 0);
            int intExtra2 = intent.getIntExtra("callLog_calllogtype", 0);
            int intExtra3 = intent.getIntExtra("callLog_callmethod", 0);
            String stringExtra2 = intent.getStringExtra("callLog_msisdn");
            String stringExtra3 = intent.getStringExtra("callLog_phoneno");
            String stringExtra4 = intent.getStringExtra("callLog_countrycode");
            String stringExtra5 = intent.getStringExtra("callLog_rejectmsg");
            String stringExtra6 = intent.getStringExtra("callLog_sessionid");
            C1786r.m6061b("-------Call Log", "StatusChangeReceiver");
            C1786r.m6061b("callDate=" + stringExtra, "StatusChangeReceiver");
            C1786r.m6061b("callDateGMT=" + longExtra, "StatusChangeReceiver");
            C1786r.m6061b("callDuration=" + intExtra, "StatusChangeReceiver");
            C1786r.m6061b("callType=" + intExtra2, "StatusChangeReceiver");
            C1786r.m6061b("callMethod=" + intExtra3, "StatusChangeReceiver");
            C1786r.m6061b("msisdn=" + stringExtra2, "StatusChangeReceiver");
            C1786r.m6061b("phoneNumber=" + stringExtra3, "StatusChangeReceiver");
            C1786r.m6061b("countryCode=" + stringExtra4, "StatusChangeReceiver");
            C1786r.m6061b("rejectMsg=" + stringExtra5, "StatusChangeReceiver");
            C1786r.m6061b("sessionId=" + stringExtra6, "StatusChangeReceiver");
            return;
        }
        if (intent.getAction().equals("com.coolots.chaton.account.ACCOUNT_RESULTINFO")) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            int intExtra4 = intent.getIntExtra("group_voice_call_max_count", 4);
            int intExtra5 = intent.getIntExtra("group_video_call_max_count", 4);
            C1786r.m6061b("------- Account Info " + booleanExtra + ", max count=" + intExtra4 + "/" + intExtra5, "StatusChangeReceiver");
            C1789u.m6077a("group_voice_call_max_count", Integer.valueOf(intExtra4));
            C1789u.m6077a("group_video_call_max_count", Integer.valueOf(intExtra5));
            if (!C1789u.m6075a().contains("uid")) {
                C1786r.m6061b("------- Account Info ChatON does not have UID.", "StatusChangeReceiver");
                return;
            }
            return;
        }
        if (intent.getAction().equals("com.coolots.chaton.SERVICE_POLICY_INFO")) {
            boolean booleanExtra2 = intent.getBooleanExtra("enable_voice_call", false);
            boolean booleanExtra3 = intent.getBooleanExtra("enable_video_call", false);
            C1786r.m6061b("------- SERVICE_POLICY_INFO isPossibleVoice:" + booleanExtra2 + ", isPossibleVideo=" + booleanExtra3, "StatusChangeReceiver");
            C1789u.m6077a("enable_voice_call", Integer.valueOf(booleanExtra2 ? C0529i.f2152e : C0529i.f2153f));
            C1789u.m6077a("enable_video_call", Integer.valueOf(booleanExtra3 ? C0529i.f2152e : C0529i.f2153f));
            Intent intent2 = new Intent(context, (Class<?>) AddonStatusService.class);
            intent2.putExtra("package_name", "com.coolots.chaton");
            intent2.putExtra("need_update", true);
            context.startService(intent2);
        }
    }
}
