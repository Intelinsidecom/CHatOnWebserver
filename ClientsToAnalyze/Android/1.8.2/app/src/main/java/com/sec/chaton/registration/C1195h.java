package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.h */
/* loaded from: classes.dex */
class C1195h extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f4410a;

    C1195h(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f4410a = nonSelfSMSFragment;
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
                C1786r.m6061b("received verification Code :" + displayMessageBody, getClass().getSimpleName());
            }
            if (displayMessageBody != null && displayMessageBody.startsWith("ChatON: ")) {
                String strSubstring = displayMessageBody.substring("ChatON: ".length(), "ChatON: ".length() + 4);
                C1786r.m6061b("final received verification Code:" + strSubstring, getClass().getSimpleName());
                if (strSubstring != null) {
                    this.f4410a.f4188h.setText("");
                    this.f4410a.f4188h.append(strSubstring);
                    C1789u.m6079a("authnum", strSubstring);
                    if (this.f4410a.f4176D) {
                        this.f4410a.m4348d();
                    }
                }
            }
        }
    }
}
