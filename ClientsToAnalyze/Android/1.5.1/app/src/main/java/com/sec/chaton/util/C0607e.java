package com.sec.chaton.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.sec.chaton.C0062R;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* renamed from: com.sec.chaton.util.e */
/* loaded from: classes.dex */
final class C0607e extends BroadcastReceiver {
    C0607e() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws InvalidKeyException {
        ChatONLogWriter.m3506b("mSmsTelephonyReceiver action=" + intent.getAction() + ", extras=" + intent.getExtras() + ", result=" + getResultCode() + ", isOrderedBroadcast=" + isOrderedBroadcast(), "SmsMessager2");
        SmsMessager2.f3741a = context;
        String str = "";
        boolean unused = SmsMessager2.f3750j = true;
        SmsMessager2.m3670b(SmsMessager2.f3741a);
        SmsMessager2.f3753m.dismiss();
        SmsMessager2.m3664a(context);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            int length = objArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i]);
                str2 = str2 + smsMessageCreateFromPdu.getDisplayMessageBody();
                byte[] userData = smsMessageCreateFromPdu.getUserData();
                i++;
                str = new String(userData, 0, 0, userData.length);
            }
            ArrayList arrayList = new ArrayList();
            if (str.contains(SmsMessager2.f3741a.getResources().getString(C0062R.string.app_name))) {
                StringTokenizer unused2 = SmsMessager2.f3749i = new StringTokenizer(str, "\n");
                while (SmsMessager2.f3749i.hasMoreTokens()) {
                    arrayList.add(SmsMessager2.f3749i.nextElement());
                }
                byte[] unused3 = SmsMessager2.f3748h = SmsMessager2.m3666a((String) arrayList.get(1));
                try {
                    SmsMessager2.f3745e.init(2, SmsMessager2.f3746f);
                    String unused4 = SmsMessager2.f3747g = new String(SmsMessager2.f3745e.doFinal(SmsMessager2.f3748h));
                    if (SmsMessager2.f3747g.equals(SmsMessager2.f3742b)) {
                        ChatONLogWriter.m3506b("Verification Success !", "SmsMessager2");
                        Intent intent2 = new Intent();
                        intent2.putExtra("MSISDN", SmsMessager2.f3744d);
                        SmsMessager2.f3752l.setResult(-1, intent2);
                        SmsMessager2.f3752l.finish();
                    } else {
                        ChatONLogWriter.m3506b("Verification Failure !", "SmsMessager2");
                        SmsMessager2.f3752l.finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
