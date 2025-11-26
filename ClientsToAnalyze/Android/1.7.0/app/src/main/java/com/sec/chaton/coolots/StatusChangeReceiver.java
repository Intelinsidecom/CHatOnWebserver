package com.sec.chaton.coolots;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.account.C0239h;
import com.sec.chaton.for3rd.AddonStatusService;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class StatusChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("Received action : " + intent.getAction(), C0239h.class.getSimpleName());
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
            C1341p.m4658b("-------Call Log", "StatusChangeReceiver");
            C1341p.m4658b("callDate=" + stringExtra, "StatusChangeReceiver");
            C1341p.m4658b("callDateGMT=" + longExtra, "StatusChangeReceiver");
            C1341p.m4658b("callDuration=" + intExtra, "StatusChangeReceiver");
            C1341p.m4658b("callType=" + intExtra2, "StatusChangeReceiver");
            C1341p.m4658b("callMethod=" + intExtra3, "StatusChangeReceiver");
            C1341p.m4658b("msisdn=" + stringExtra2, "StatusChangeReceiver");
            C1341p.m4658b("phoneNumber=" + stringExtra3, "StatusChangeReceiver");
            C1341p.m4658b("countryCode=" + stringExtra4, "StatusChangeReceiver");
            C1341p.m4658b("rejectMsg=" + stringExtra5, "StatusChangeReceiver");
            C1341p.m4658b("sessionId=" + stringExtra6, "StatusChangeReceiver");
            return;
        }
        if (intent.getAction().equals("com.coolots.chaton.account.ACCOUNT_RESULTINFO")) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            int intExtra4 = intent.getIntExtra("group_voice_call_max_count", 1);
            int intExtra5 = intent.getIntExtra("group_video_call_max_count", 1);
            C1341p.m4658b("------- Account Info " + booleanExtra + ", max count=" + intExtra4 + "/" + intExtra5, "StatusChangeReceiver");
            C1323bs.m4577a("group_voice_call_max_count", Integer.valueOf(intExtra4));
            C1323bs.m4577a("group_video_call_max_count", Integer.valueOf(intExtra5));
            if (!C1323bs.m4575a().contains("uid")) {
                C1341p.m4658b("------- Account Info ChatON does not have UID.", "StatusChangeReceiver");
                return;
            }
            return;
        }
        if (intent.getAction().equals("com.coolots.chaton.SERVICE_POLICY_INFO")) {
            boolean booleanExtra2 = intent.getBooleanExtra("enable_voice_call", false);
            boolean booleanExtra3 = intent.getBooleanExtra("enable_video_call", false);
            C1341p.m4658b("------- SERVICE_POLICY_INFO isPossibleVoice:" + booleanExtra2 + ", isPossibleVideo=" + booleanExtra3, "StatusChangeReceiver");
            C1323bs.m4577a("enable_voice_call", Integer.valueOf(booleanExtra2 ? C0613d.f2153a : C0613d.f2154b));
            C1323bs.m4577a("enable_video_call", Integer.valueOf(booleanExtra3 ? C0613d.f2153a : C0613d.f2154b));
            Intent intent2 = new Intent(context, (Class<?>) AddonStatusService.class);
            intent2.putExtra("package_name", "com.coolots.chaton");
            intent2.putExtra("need_update", true);
            context.startService(intent2);
        }
    }
}
