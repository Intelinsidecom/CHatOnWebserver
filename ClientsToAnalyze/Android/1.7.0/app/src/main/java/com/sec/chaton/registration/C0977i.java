package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.i */
/* loaded from: classes.dex */
class C0977i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f3374a;

    C0977i(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f3374a = nonSelfSMSFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object[] objArr;
        Bundle extras = intent.getExtras();
        if (extras != null && (objArr = (Object[]) extras.get("pdus")) != null && objArr.length != 0) {
            String displayMessageBody = "";
            for (Object obj : objArr) {
                SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                if (smsMessageCreateFromPdu == null) {
                    break;
                }
                displayMessageBody = smsMessageCreateFromPdu.getDisplayMessageBody();
                C1341p.m4658b("received verification Code :" + displayMessageBody, getClass().getSimpleName());
            }
            if (displayMessageBody != null && displayMessageBody.startsWith("ChatON: ")) {
                String strSubstring = displayMessageBody.substring("ChatON: ".length());
                C1341p.m4658b("final received verification Code:" + strSubstring, getClass().getSimpleName());
                if (strSubstring != null) {
                    this.f3374a.f3160f.setText("");
                    this.f3374a.f3160f.append(strSubstring);
                    C1323bs.m4579a("authnum", strSubstring);
                    if (this.f3374a.f3153B) {
                        this.f3374a.m3659a();
                    }
                }
            }
        }
    }
}
