package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.p135a.C5097t;

/* compiled from: RetryScheduler.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.transaction.z */
/* loaded from: classes.dex */
public class C4090z implements InterfaceC4084t {

    /* renamed from: d */
    private static C4090z f14724d;

    /* renamed from: a */
    private final Context f14725a;

    /* renamed from: b */
    private final ContentResolver f14726b;

    /* renamed from: c */
    private boolean f14727c = false;

    /* renamed from: e */
    private final BroadcastReceiver f14728e = new C4050aa(this);

    private C4090z(Context context) {
        this.f14725a = context;
        this.f14726b = context.getContentResolver();
        if (C3847e.m14657aH() && C3847e.m14621E()) {
            this.f14725a.registerReceiver(this.f14728e, new IntentFilter("IMS_REGISTRATION"));
        }
    }

    /* renamed from: a */
    public void m15715a() {
        if (C3847e.m14657aH()) {
            try {
                this.f14725a.unregisterReceiver(this.f14728e);
            } catch (IllegalArgumentException e) {
                C3890m.m14997c("RetryScheduler", "Reciever is not registered");
            }
        }
    }

    /* renamed from: a */
    public static C4090z m15708a(Context context) {
        if (f14724d == null) {
            f14724d = new C4090z(context);
        }
        return f14724d;
    }

    @Override // com.sec.chaton.smsplugin.transaction.InterfaceC4084t
    /* renamed from: a */
    public void mo15595a(AbstractC4083s abstractC4083s) {
        Uri uriM15644b;
        try {
            AbstractC4059aj abstractC4059aj = (AbstractC4059aj) abstractC4083s;
            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                C3890m.m14994a("RetryScheduler", "[RetryScheduler] update " + abstractC4083s);
            }
            if ((abstractC4059aj instanceof RunnableC4082r) || (abstractC4059aj instanceof RunnableC4089y) || (abstractC4059aj instanceof C4088x) || (abstractC4059aj instanceof RunnableC4051ab)) {
                try {
                    C4065ap c4065apM15619e = abstractC4059aj.m15619e();
                    if (c4065apM15619e.m15641a() == 2 && (uriM15644b = c4065apM15619e.m15644b()) != null) {
                        m15709a(uriM15644b);
                    }
                } finally {
                    abstractC4059aj.m15696b(this);
                }
            }
        } finally {
            m15714b(this.f14725a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x01ac, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01b0, code lost:
    
        throw r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b5 A[Catch: all -> 0x01ac, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x01ac, all -> 0x01f0, blocks: (B:4:0x0033, B:6:0x003a, B:8:0x0040, B:11:0x0072, B:13:0x007c, B:15:0x0081, B:20:0x0094, B:21:0x00b9, B:24:0x00c1, B:26:0x00d1, B:27:0x0105, B:29:0x0111, B:30:0x011c, B:47:0x01b5, B:52:0x01df, B:53:0x01e2, B:56:0x01f1, B:57:0x01f4, B:38:0x0184, B:40:0x018e, B:49:0x01d5, B:51:0x01db), top: B:61:0x0033 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m15709a(android.net.Uri r17) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.C4090z.m15709a(android.net.Uri):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m15707a(long r9) {
        /*
            r8 = this;
            r3 = 0
            r7 = 0
            android.content.Context r0 = r8.f14725a
            android.content.ContentResolver r1 = r8.f14726b
            android.net.Uri r2 = android.provider.Telephony.Mms.Outbox.CONTENT_URI
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "_id="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            r5 = r3
            r6 = r3
            android.database.Cursor r1 = android.database.sqlite.SqliteWrapper.query(r0, r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L5e
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L5e
            java.lang.String r0 = "resp_st"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L57
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L57
        L35:
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            if (r0 == 0) goto L56
            java.lang.String r1 = "RetryScheduler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Response status is: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14999e(r1, r2)
        L56:
            return r0
        L57:
            r0 = move-exception
            if (r1 == 0) goto L5d
            r1.close()
        L5d:
            throw r0
        L5e:
            r0 = r7
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.C4090z.m15707a(long):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m15712b(long r9) {
        /*
            r8 = this;
            r3 = 0
            r7 = 0
            android.content.Context r0 = r8.f14725a
            android.content.ContentResolver r1 = r8.f14726b
            android.net.Uri r2 = android.provider.Telephony.Mms.Inbox.CONTENT_URI
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "_id="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            r5 = r3
            r6 = r3
            android.database.Cursor r1 = android.database.sqlite.SqliteWrapper.query(r0, r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L69
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L69
            java.lang.String r0 = "resp_st"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L62
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L62
        L35:
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            if (r0 == 0) goto L61
            java.lang.String r1 = "Mms:transaction"
            java.lang.String r2 = com.sec.chaton.smsplugin.p111h.C3890m.f13993b
            boolean r1 = com.sec.chaton.smsplugin.p111h.C3890m.m15000f(r1, r2)
            if (r1 == 0) goto L61
            java.lang.String r1 = "RetryScheduler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Retrieve status is: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14994a(r1, r2)
        L61:
            return r0
        L62:
            r0 = move-exception
            if (r1 == 0) goto L68
            r1.close()
        L68:
            throw r0
        L69:
            r0 = r7
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.C4090z.m15712b(long):int");
    }

    /* renamed from: b */
    public static void m15714b(Context context) {
        Cursor cursorM19443a = C5097t.m19426a(context).m19443a(Long.MAX_VALUE);
        if (cursorM19443a != null) {
            try {
                if (cursorM19443a.moveToFirst()) {
                    long j = cursorM19443a.getLong(cursorM19443a.getColumnIndexOrThrow("due_time"));
                    ((AlarmManager) context.getSystemService("alarm")).set(1, j, PendingIntent.getService(context, 0, new Intent("android.intent.action.ACTION_ONALARM", null, context, TransactionService.class), 1073741824));
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("RetryScheduler", "Next retry is scheduled at" + (j - System.currentTimeMillis()) + "ms from now");
                    }
                }
            } finally {
                cursorM19443a.close();
            }
        }
    }
}
