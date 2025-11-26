package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dd */
/* loaded from: classes.dex */
class C2207dd extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8500a;

    C2207dd(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8500a = fragmentNonSelfSMS;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object[] objArr;
        int iIndexOf;
        Bundle extras = intent.getExtras();
        if (extras != null && (objArr = (Object[]) extras.get("pdus")) != null && objArr.length != 0) {
            String displayMessageBody = "";
            for (Object obj : objArr) {
                SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                if (smsMessageCreateFromPdu == null) {
                    break;
                }
                displayMessageBody = smsMessageCreateFromPdu.getDisplayMessageBody();
                C3250y.m11450b("received verification Code :" + displayMessageBody, getClass().getSimpleName());
            }
            if (displayMessageBody != null && displayMessageBody.contains(": ") && (iIndexOf = displayMessageBody.indexOf(": ")) != -1) {
                int length = iIndexOf + ": ".length();
                if (displayMessageBody.length() < length + 4) {
                    if (C3250y.f11735c) {
                        C3250y.m11453c("receviced code is less than excepted code", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                String strSubstring = displayMessageBody.substring(length, length + 4);
                C3250y.m11450b("final received verification Code:" + strSubstring, getClass().getSimpleName());
                if (strSubstring != null) {
                    this.f8500a.f8239g.setText("");
                    this.f8500a.f8239g.append(strSubstring);
                    C3159aa.m10966a("authnum", strSubstring);
                }
            }
        }
    }
}
