package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.spam.C4015bs;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class PrivilegedSmsReceiver extends SmsReceiver {
    @Override // com.sec.chaton.smsplugin.transaction.SmsReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean zM18255w = C4822an.m18255w();
        boolean zM18201K = C4822an.m18201K();
        if (!zM18255w && !zM18201K) {
            C3896s.m15044b("This user does not agree to use SMS [didMappingSamsungAccout=" + zM18255w + " acceptedDisclaimer=" + zM18201K, "PrivilegedSmsReceiver");
            return;
        }
        if (C2349a.m10301a("sms_feature") && C4809aa.m18104a().m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at())).booleanValue() && context != null && intent != null && intent.getAction() != null) {
            SmsMessage smsMessage = Telephony.Sms.Intents.getMessagesFromIntent(intent)[0];
            String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
            boolean zM15442a = C4015bs.m15442a(context, displayOriginatingAddress, smsMessage.getMessageBody());
            boolean zBooleanValue = C4809aa.m18104a().m18119a("Setting Notification", (Boolean) true).booleanValue();
            if (!C3847e.m14686ar() && !zBooleanValue && !zM15442a) {
                if (TextUtils.isEmpty(displayOriginatingAddress)) {
                    displayOriginatingAddress = context.getString(R.string.unknown_sender);
                }
                long orCreateThreadId = Telephony.Threads.getOrCreateThreadId(context, displayOriginatingAddress);
                int iM15535a = m15535a(context, orCreateThreadId);
                intent.putExtra("extra_thread_id", orCreateThreadId);
                intent.putExtra("extra_recv_time", iM15535a);
            }
            m15545a(context, intent, true, zBooleanValue, zM15442a);
        }
    }

    /* renamed from: a */
    private int m15535a(Context context, long j) {
        Uri.Builder builderAppendId = ContentUris.appendId(Telephony.Threads.CONTENT_URI.buildUpon(), j);
        builderAppendId.appendPath("subject");
        Cursor cursorQuery = context.getContentResolver().query(builderAppendId.build(), new String[]{"message_count"}, null, null, null);
        if (cursorQuery == null) {
            return 0;
        }
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
        }
    }
}
