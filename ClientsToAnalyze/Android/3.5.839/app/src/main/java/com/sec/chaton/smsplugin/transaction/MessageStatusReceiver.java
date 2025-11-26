package com.sec.chaton.smsplugin.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsMessage;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* loaded from: classes.dex */
public class MessageStatusReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String[] f14564a = {"_id"};

    /* renamed from: b */
    private static final Uri f14565b = Uri.parse("content://sms/status");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SmsMessage smsMessageM15517a;
        if (!"com.sec.chaton.smsplugin.transaction.MessageStatusReceiver.MESSAGE_STATUS_RECEIVED".equals(intent.getAction()) || (smsMessageM15517a = m15517a(context, intent.getData(), (byte[]) intent.getExtra("pdu"), intent.getStringExtra("format"))) == null || smsMessageM15517a.getStatus() < 32) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008c A[Catch: all -> 0x00a4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a4, blocks: (B:7:0x0018, B:9:0x001e, B:11:0x0043, B:12:0x0070, B:16:0x008c), top: B:22:0x0018 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.telephony.SmsMessage m15517a(android.content.Context r9, android.net.Uri r10, byte[] r11, java.lang.String r12) {
        /*
            r8 = this;
            r4 = 0
            android.telephony.SmsMessage r7 = android.telephony.SmsMessage.createFromPdu(r11, r12)
            if (r7 != 0) goto L8
        L7:
            return r4
        L8:
            android.content.ContentResolver r1 = r9.getContentResolver()
            java.lang.String[] r3 = com.sec.chaton.smsplugin.transaction.MessageStatusReceiver.f14564a
            r0 = r9
            r2 = r10
            r5 = r4
            r6 = r4
            android.database.Cursor r6 = android.database.sqlite.SqliteWrapper.query(r0, r1, r2, r3, r4, r5, r6)
            if (r6 == 0) goto L8c
            boolean r0 = r6.moveToFirst()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L8c
            r0 = 0
            int r0 = r6.getInt(r0)     // Catch: java.lang.Throwable -> La4
            android.net.Uri r1 = com.sec.chaton.smsplugin.transaction.MessageStatusReceiver.f14565b     // Catch: java.lang.Throwable -> La4
            long r2 = (long) r0     // Catch: java.lang.Throwable -> La4
            android.net.Uri r2 = android.content.ContentUris.withAppendedId(r1, r2)     // Catch: java.lang.Throwable -> La4
            int r0 = r7.getStatus()     // Catch: java.lang.Throwable -> La4
            boolean r1 = r7.isStatusReportMessage()     // Catch: java.lang.Throwable -> La4
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch: java.lang.Throwable -> La4
            r4 = 1
            r3.<init>(r4)     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = "Mms"
            java.lang.String r5 = com.sec.chaton.smsplugin.p111h.C3890m.f13992a     // Catch: java.lang.Throwable -> La4
            boolean r4 = com.sec.chaton.smsplugin.p111h.C3890m.m15000f(r4, r5)     // Catch: java.lang.Throwable -> La4
            if (r4 == 0) goto L70
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            r4.<init>()     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = "updateMessageStatus: msgUrl="
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = ", status="
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = ", isStatusReport="
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La4
            r8.m15519b(r1)     // Catch: java.lang.Throwable -> La4
        L70:
            java.lang.String r1 = "status"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> La4
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> La4
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> La4
            r4 = 0
            r5 = 0
            r0 = r9
            android.database.sqlite.SqliteWrapper.update(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La4
        L84:
            if (r6 == 0) goto L89
            r6.close()
        L89:
            r4 = r7
            goto L7
        L8c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            r0.<init>()     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "Can't find message for status update: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La4
            r8.m15518a(r0)     // Catch: java.lang.Throwable -> La4
            goto L84
        La4:
            r0 = move-exception
            if (r6 == 0) goto Laa
            r6.close()
        Laa:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.MessageStatusReceiver.m15517a(android.content.Context, android.net.Uri, byte[], java.lang.String):android.telephony.SmsMessage");
    }

    /* renamed from: a */
    private void m15518a(String str) {
        C3890m.m14999e("MessageStatusReceiver", "[MessageStatusReceiver] " + str);
    }

    /* renamed from: b */
    private void m15519b(String str) {
        C3890m.m14996b("MessageStatusReceiver", "[MessageStatusReceiver] " + str);
    }
}
