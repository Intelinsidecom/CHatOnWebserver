package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dc */
/* loaded from: classes.dex */
class C3215dc extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11980a;

    C3215dc(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11980a = fragmentNonSelfSMS;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object[] objArr;
        String str;
        Bundle extras = intent.getExtras();
        if (extras != null && (objArr = (Object[]) extras.get("pdus")) != null && objArr.length != 0) {
            String displayMessageBody = "";
            for (Object obj : objArr) {
                SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                if (smsMessageCreateFromPdu == null) {
                    break;
                }
                displayMessageBody = smsMessageCreateFromPdu.getDisplayMessageBody();
                C4904y.m18639b("received verification Code :" + displayMessageBody, getClass().getSimpleName());
            }
            if (displayMessageBody != null) {
                if (displayMessageBody.contains("ChatON : ")) {
                    str = "ChatON : ";
                } else if (displayMessageBody.contains(": ")) {
                    str = ": ";
                } else {
                    return;
                }
                int iIndexOf = displayMessageBody.indexOf(str);
                if (iIndexOf != -1) {
                    int length = str.length() + iIndexOf;
                    if (displayMessageBody.length() < length + 4) {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("receviced code is less than excepted code", getClass().getSimpleName());
                            return;
                        }
                        return;
                    }
                    String strSubstring = displayMessageBody.substring(length, length + 4);
                    C4904y.m18639b("final received verification Code:" + strSubstring, getClass().getSimpleName());
                    if (strSubstring != null) {
                        this.f11980a.f11685g.setText("");
                        this.f11980a.f11685g.append(strSubstring);
                        C4809aa.m18108a("authnum", strSubstring);
                    }
                }
            }
        }
    }
}
