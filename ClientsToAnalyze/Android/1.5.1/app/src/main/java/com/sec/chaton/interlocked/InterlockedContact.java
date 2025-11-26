package com.sec.chaton.interlocked;

import android.content.Intent;

/* loaded from: classes.dex */
public class InterlockedContact implements InterlockWithNative {

    /* renamed from: a */
    private Intent f1911a;

    public InterlockedContact(Intent intent) {
        this.f1911a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    @Override // com.sec.chaton.interlocked.InterlockWithNative
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.HandleIntent.IntentDest mo2391a() throws java.lang.Throwable {
        /*
            r8 = this;
            r7 = 0
            r2 = 0
            android.content.Intent r0 = r8.f1911a
            java.lang.String r1 = "content_type"
            com.sec.chaton.database.ChatONContract$MessageTable$MsgContentType r3 = com.sec.chaton.database.ChatONContract.MessageTable.MsgContentType.CONTACT
            int r3 = r3.m2197a()
            r0.putExtra(r1, r3)
            android.content.Intent r0 = r8.f1911a
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r1 = "android.intent.extra.STREAM"
            java.lang.Object r1 = r0.get(r1)
            android.net.Uri r1 = (android.net.Uri) r1
            java.lang.String r6 = ""
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m2387e()
            android.content.ContentResolver r0 = r0.getContentResolver()
            r3 = r2
            r4 = r2
            r5 = r2
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L7f
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L75
            if (r2 == 0) goto L7f
            r2 = 0
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L75
        L3b:
            if (r0 == 0) goto L40
            r0.close()
        L40:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L7c
            android.content.Intent r0 = r8.f1911a
            java.lang.String r3 = "callForward"
            r4 = 1
            r0.putExtra(r3, r4)
            android.content.Intent r0 = r8.f1911a
            java.lang.String r3 = "sub_content"
            java.lang.String r4 = "."
            int r4 = r2.lastIndexOf(r4)
            java.lang.String r4 = r2.substring(r7, r4)
            r0.putExtra(r3, r4)
            java.lang.String r0 = "vcf"
            android.net.Uri r0 = com.sec.chaton.interlocked.InterlockedIntentSort.m2393a(r1, r2, r0)
            if (r0 == 0) goto L7c
            android.content.Intent r1 = r8.f1911a
            java.lang.String r2 = "download_uri"
            java.lang.String r0 = r0.toString()
            r1.putExtra(r2, r0)
            com.sec.chaton.HandleIntent$IntentDest r0 = com.sec.chaton.HandleIntent.IntentDest.FORWARD
        L74:
            return r0
        L75:
            r1 = move-exception
            if (r0 == 0) goto L7b
            r0.close()
        L7b:
            throw r1
        L7c:
            com.sec.chaton.HandleIntent$IntentDest r0 = com.sec.chaton.HandleIntent.IntentDest.HOME
            goto L74
        L7f:
            r2 = r6
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.interlocked.InterlockedContact.mo2391a():com.sec.chaton.HandleIntent$IntentDest");
    }
}
