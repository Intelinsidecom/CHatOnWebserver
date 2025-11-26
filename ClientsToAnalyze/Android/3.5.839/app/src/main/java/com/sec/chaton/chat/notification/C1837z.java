package com.sec.chaton.chat.notification;

import android.net.Uri;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.z */
/* loaded from: classes.dex */
class C1837z implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6959a;

    C1837z(ScreenNotification2 screenNotification2) {
        this.f6959a = screenNotification2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[Catch: Exception -> 0x0069, all -> 0x00a1, TRY_ENTER, TryCatch #1 {Exception -> 0x0069, blocks: (B:5:0x0006, B:7:0x000c, B:8:0x0011, B:10:0x001d, B:11:0x002b, B:16:0x005a, B:15:0x004d), top: B:30:0x0006, outer: #0 }] */
    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7100a(int r9, java.lang.Object r10, android.database.Cursor r11) {
        /*
            r8 = this;
            r0 = 101(0x65, float:1.42E-43)
            if (r9 != r0) goto L4c
            if (r11 == 0) goto L4d
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            if (r0 == 0) goto L4d
            r0 = 0
            long r3 = r11.getLong(r0)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
        L11:
            com.sec.chaton.chat.notification.ScreenNotification2 r0 = r8.f6959a     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.s r0 = com.sec.chaton.chat.notification.ScreenNotification2.m8849h(r0)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            int r0 = r0.f6943q     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            int r1 = com.sec.chaton.chat.notification.C1828q.f6915c     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            if (r0 != r1) goto L5a
            android.net.Uri r0 = android.provider.Telephony.Sms.CONTENT_URI     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.ScreenNotification2 r1 = r8.f6959a     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.s r1 = com.sec.chaton.chat.notification.ScreenNotification2.m8849h(r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            long r1 = r1.f6940n     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            android.net.Uri r2 = android.content.ContentUris.withAppendedId(r0, r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
        L2b:
            com.sec.chaton.smsplugin.provider.a r0 = new com.sec.chaton.smsplugin.provider.a     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            android.content.Context r1 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            r0.<init>(r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.ScreenNotification2 r1 = r8.f6959a     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            android.os.Handler r1 = r1.f6776u     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.ScreenNotification2 r5 = r8.f6959a     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.s r6 = com.sec.chaton.chat.notification.ScreenNotification2.m8849h(r5)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            r7 = 0
            r5 = r9
            r0.m15241a(r1, r2, r3, r5, r6, r7)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            if (r11 == 0) goto L4c
        L49:
            r11.close()
        L4c:
            return
        L4d:
            com.sec.chaton.chat.notification.ScreenNotification2 r0 = r8.f6959a     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.s r0 = com.sec.chaton.chat.notification.ScreenNotification2.m8849h(r0)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            java.lang.String r0 = r0.f6931e     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            long r3 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            goto L11
        L5a:
            android.net.Uri r0 = android.provider.Telephony.Mms.CONTENT_URI     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.ScreenNotification2 r1 = r8.f6959a     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.s r1 = com.sec.chaton.chat.notification.ScreenNotification2.m8849h(r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            long r1 = r1.f6940n     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            android.net.Uri r2 = android.content.ContentUris.withAppendedId(r0, r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La1
            goto L2b
        L69:
            r0 = move-exception
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Throwable -> La1
            if (r0 == 0) goto L78
            java.lang.String r0 = "Failed to query thread ID"
            java.lang.String r1 = com.sec.chaton.chat.notification.ScreenNotification2.m8857o()     // Catch: java.lang.Throwable -> La1
            com.sec.chaton.util.C4904y.m18641c(r0, r1)     // Catch: java.lang.Throwable -> La1
        L78:
            com.sec.chaton.chat.notification.ScreenNotification2 r0 = r8.f6959a     // Catch: java.lang.Throwable -> La1
            android.widget.ProgressBar r0 = com.sec.chaton.chat.notification.ScreenNotification2.m8868u(r0)     // Catch: java.lang.Throwable -> La1
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.ScreenNotification2 r0 = r8.f6959a     // Catch: java.lang.Throwable -> La1
            android.widget.LinearLayout r0 = com.sec.chaton.chat.notification.ScreenNotification2.m8853l(r0)     // Catch: java.lang.Throwable -> La1
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> La1
            com.sec.chaton.chat.notification.ScreenNotification2 r0 = r8.f6959a     // Catch: java.lang.Throwable -> La1
            android.content.Context r0 = com.sec.chaton.chat.notification.ScreenNotification2.m8870v(r0)     // Catch: java.lang.Throwable -> La1
            r1 = 2131427878(0x7f0b0226, float:1.8477385E38)
            r2 = 0
            android.widget.Toast r0 = com.sec.widget.C5179v.m19810a(r0, r1, r2)     // Catch: java.lang.Throwable -> La1
            r0.show()     // Catch: java.lang.Throwable -> La1
            if (r11 == 0) goto L4c
            goto L49
        La1:
            r0 = move-exception
            if (r11 == 0) goto La7
            r11.close()
        La7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.notification.C1837z.mo7100a(int, java.lang.Object, android.database.Cursor):void");
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        if (i == 0 && this.f6959a.f6750W != null) {
            if (this.f6959a.f6750W.f6942p == EnumC2301u.LIVE) {
                C1813b.m8906b().m8923a(this.f6959a.f6750W.f6931e, C1813b.f6838g, false, false);
            } else {
                C1813b.m8906b().m8922a(this.f6959a.f6750W.f6931e, C1813b.f6838g);
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
