package com.sec.chaton.chat;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.C0892ds;
import com.sec.chaton.p046a.C0919es;
import com.sec.chaton.p046a.C0935fh;
import com.sec.chaton.p046a.C0963gi;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2219ag;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2297q;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.chat.gz */
/* loaded from: classes.dex */
public class C1753gz {

    /* renamed from: a */
    private static final String f6580a = C1753gz.class.getSimpleName();

    /* renamed from: b */
    private static C1753gz f6581b;

    /* renamed from: a */
    public static synchronized C1753gz m8698a() {
        if (f6581b == null) {
            f6581b = new C1753gz();
        }
        return f6581b;
    }

    private C1753gz() {
    }

    /* renamed from: a */
    public void m8706a(String str, String str2, long j) {
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        if (j == 0) {
            long jM9914a = C2198l.m9914a(contentResolver, str);
            if (jM9914a == 0) {
                j = System.currentTimeMillis();
            } else {
                j = jM9914a + 1;
            }
        }
        C2198l.m9907a(contentResolver, str2, j);
        C2198l.m9907a(contentResolver, C4809aa.m18104a().m18121a("chaton_id", ""), j);
        if (C2176ab.m9682b(contentResolver, str) > 1) {
            C2176ab.m9692d(contentResolver, str, C4809aa.m18104a().m18121a("chaton_id", ""));
        }
        C2204r.m10046b(contentResolver, str);
        if (C4904y.f17873c) {
            C4904y.m18641c("7001(SESSION_DEACTIVATED) - time : " + j, f6580a);
        }
    }

    /* renamed from: a */
    public void m8704a(Handler handler, String str, EnumC2300t enumC2300t, C0935fh c0935fh) {
        try {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
            C0919es c0919esM5235j = c0935fh.m5235j();
            if (enumC2300t == EnumC2300t.ONETOONE) {
                String strM9960m = C2198l.m9960m(contentResolver, m8703a(arrayList, contentResolver, str, c0919esM5235j));
                if (!TextUtils.isEmpty(strM9960m)) {
                    Message message = new Message();
                    message.what = 107;
                    message.obj = new C0788l(true, 7100);
                    handler.sendMessage(message);
                    if (C4904y.f17873c) {
                        C4904y.m18641c("merge(new inbox to old) start - old:" + str + ",new:" + strM9960m, f6580a);
                    }
                    m8707a(arrayList, contentResolver, str, strM9960m);
                    Message message2 = new Message();
                    message2.what = 107;
                    message2.obj = new C0788l(true, 7101);
                    handler.sendMessage(message2);
                    if (C4904y.f17873c) {
                        C4904y.m18641c("merge(new inbox to old) finish - old:" + str + ",new:" + c0919esM5235j, f6580a);
                    }
                }
                m8708a(arrayList, c0919esM5235j, str);
                m8710b(arrayList, c0919esM5235j, str);
            }
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            if (C4904y.f17873c) {
                C4904y.m18641c("7006(NON_WEB_USER_DETECTED) - inboxNo" + str, f6580a);
            }
            new C2128i(null).m9495a();
        } catch (OperationApplicationException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f6580a);
            }
        } catch (RemoteException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f6580a);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m8701a(android.os.Handler r12, java.lang.String r13, com.sec.chaton.p046a.C0935fh r14) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1753gz.m8701a(android.os.Handler, java.lang.String, com.sec.chaton.a.fh):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m8702a(java.lang.String r10, com.sec.chaton.p046a.C0935fh r11) {
        /*
            r9 = this;
            r6 = 0
            com.sec.chaton.d.w r7 = com.sec.chaton.p055d.C2142w.m9606c(r10)
            if (r7 != 0) goto L26
            boolean r0 = com.sec.chaton.util.C4904y.f17872b
            if (r0 == 0) goto L24
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleSessionTransited(), messageControl is null !!! inboxNo : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = com.sec.chaton.chat.C1753gz.f6580a
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
        L24:
            r0 = r6
        L25:
            return r0
        L26:
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: android.content.OperationApplicationException -> Lb0 android.os.RemoteException -> Lc4
            android.content.ContentResolver r2 = r0.getContentResolver()     // Catch: android.content.OperationApplicationException -> Lb0 android.os.RemoteException -> Lc4
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.OperationApplicationException -> Lb0 android.os.RemoteException -> Lc4
            r1.<init>()     // Catch: android.content.OperationApplicationException -> Lb0 android.os.RemoteException -> Lc4
            com.sec.chaton.a.gi r4 = r11.m5233h()     // Catch: android.content.OperationApplicationException -> Lb0 android.os.RemoteException -> Lc4
            r5 = 0
            r0 = r9
            r3 = r10
            com.sec.chaton.chat.ha r0 = r0.m8700a(r1, r2, r3, r4, r5)     // Catch: android.content.OperationApplicationException -> Lb0 android.os.RemoteException -> Lc4
            if (r0 == 0) goto Lcc
            java.lang.String r6 = r0.f6584b     // Catch: android.content.OperationApplicationException -> Lb0 android.os.RemoteException -> Lc4
            r7.m9640a(r0)     // Catch: android.content.OperationApplicationException -> Lbe android.os.RemoteException -> Lc8
            r0 = r6
        L46:
            com.sec.chaton.util.ab r3 = com.sec.chaton.util.C4809aa.m18104a()     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            java.lang.String r5 = "chaton_id"
            java.lang.String r6 = ""
            java.lang.String r3 = r3.m18121a(r5, r6)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            android.content.ContentProviderOperation r3 = com.sec.chaton.p057e.p058a.C2176ab.m9683b(r10, r3)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r1.add(r3)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r9.m8713d(r1, r4, r10)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r9.m8714e(r1, r4, r10)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            long r5 = r4.m5621d()     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            android.content.ContentProviderOperation r3 = com.sec.chaton.p057e.p058a.C2198l.m9918a(r10, r5)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r1.add(r3)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            java.lang.String r3 = "com.sec.chaton.provider"
            r2.applyBatch(r3, r1)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r7.mo9266b(r5)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            if (r1 != 0) goto L7e
            com.sec.chaton.msgsend.C2716x.m11384a(r10, r0)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
        L7e:
            r1 = 0
            java.lang.String r2 = r7.m9650h()     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r7 = 0
            com.sec.chaton.p055d.C2134o.m9570a(r1, r10, r2, r7)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            boolean r1 = com.sec.chaton.util.C4904y.f17873c     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            if (r1 == 0) goto L25
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r1.<init>()     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            java.lang.String r2 = "7003(SESSION_MERGED) - SessionMerge timestap : "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            java.lang.String r1 = r1.toString()     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            r9.m8705a(r1, r4)     // Catch: android.os.RemoteException -> La4 android.content.OperationApplicationException -> Lc2
            goto L25
        La4:
            r1 = move-exception
        La5:
            boolean r2 = com.sec.chaton.util.C4904y.f17875e
            if (r2 == 0) goto L25
            java.lang.String r2 = com.sec.chaton.chat.C1753gz.f6580a
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            goto L25
        Lb0:
            r0 = move-exception
            r1 = r0
            r0 = r6
        Lb3:
            boolean r2 = com.sec.chaton.util.C4904y.f17875e
            if (r2 == 0) goto L25
            java.lang.String r2 = com.sec.chaton.chat.C1753gz.f6580a
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            goto L25
        Lbe:
            r0 = move-exception
            r1 = r0
            r0 = r6
            goto Lb3
        Lc2:
            r1 = move-exception
            goto Lb3
        Lc4:
            r0 = move-exception
            r1 = r0
            r0 = r6
            goto La5
        Lc8:
            r0 = move-exception
            r1 = r0
            r0 = r6
            goto La5
        Lcc:
            r0 = r6
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1753gz.m8702a(java.lang.String, com.sec.chaton.a.fh):java.lang.String");
    }

    /* renamed from: a */
    public void m8705a(String str, C0963gi c0963gi) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(", CurrentMemberList : ");
        Iterator<String> it = c0963gi.m5622e().iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        sb.append("MembershipChangesList : ");
        for (C0892ds c0892ds : c0963gi.m5624g()) {
            String strM4668d = c0892ds.m4668d();
            sb.append("(old:").append(strM4668d).append(",new:").append(c0892ds.m4670f()).append("), ");
        }
        C4904y.m18641c(sb.toString(), f6580a);
    }

    /* renamed from: a */
    public void m8707a(ArrayList<ContentProviderOperation> arrayList, ContentResolver contentResolver, String str, String str2) {
        C2201o c2201oM9951e = C2198l.m9951e(contentResolver, str);
        if (c2201oM9951e == null) {
            C4904y.m18634a("mergeToOldInbox - oldInboxData is null", f6580a);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            C4904y.m18634a("mergeToOldInbox - newInboxNo is empty", f6580a);
            return;
        }
        Uri uri = C2299s.f8209a;
        arrayList.add(ContentProviderOperation.newDelete(uri).withSelection("inbox_no=?", new String[]{str}).build());
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_old_session_id", c2201oM9951e.f7846i);
        if (TextUtils.isEmpty(c2201oM9951e.f7857t)) {
            contentValues.put("inbox_old_no", str2);
        } else {
            contentValues.put("inbox_old_no", c2201oM9951e.f7857t + "," + str2);
        }
        arrayList.add(ContentProviderOperation.newUpdate(uri).withSelection("inbox_no=?", new String[]{str2}).withValues(contentValues).build());
        Uri uri2 = C2306z.f8229a;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("message_inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri2).withSelection("message_inbox_no=?", new String[]{str2}).withValues(contentValues2).build());
        Uri uri3 = C2220ah.f7942a;
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("participants_inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri3).withSelection("participants_inbox_no=?", new String[]{str2}).withValues(contentValues3).build());
        Uri uri4 = C2297q.f8207a;
        ContentValues contentValues4 = new ContentValues();
        contentValues4.put("inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri4).withSelection("inbox_no =?", new String[]{str2}).withValues(contentValues4).build());
    }

    /* renamed from: a */
    public C1755ha m8700a(ArrayList<ContentProviderOperation> arrayList, ContentResolver contentResolver, String str, C0963gi c0963gi, boolean z) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        String str5 = "";
        Uri uri = C2219ag.f7941a;
        sb.append("update mapping_participant : ");
        for (C0892ds c0892ds : c0963gi.m5624g()) {
            String strM4668d = c0892ds.m4668d();
            String strM4670f = c0892ds.m4670f();
            if (strM4670f.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                if (z) {
                    sb.append("(old:").append(strM4668d).append(",new:").append(strM4670f).append(") -> transited to my number - invalid,");
                    str2 = str5;
                    str3 = str4;
                } else {
                    arrayList.add(C2176ab.m9683b(str, strM4668d));
                    sb.append("(old:").append(strM4668d).append(",new:").append(strM4670f).append(") -> delete my number,");
                    str2 = str5;
                    str3 = str4;
                }
            } else {
                arrayList.add(C2176ab.m9684b(str, strM4668d, strM4670f));
                sb.append("(old:").append(strM4668d).append(",new:").append(strM4670f).append(") -> update");
                str2 = strM4670f;
                str3 = strM4668d;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("participants_buddy_no", strM4670f);
            contentValues.put("participants_old_buddy_no", strM4668d);
            arrayList.add(ContentProviderOperation.newInsert(uri).withValues(contentValues).build());
            str4 = str3;
            str5 = str2;
        }
        C4904y.m18641c(sb.toString(), f6580a);
        return new C1755ha(str4, str5);
    }

    /* renamed from: a */
    public void m8709a(ArrayList<ContentProviderOperation> arrayList, C0963gi c0963gi, String str) {
        for (C0892ds c0892ds : c0963gi.m5624g()) {
            String strM4668d = c0892ds.m4668d();
            String strM4670f = c0892ds.m4670f();
            String[] strArr = {strM4668d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("buddy_no", strM4670f);
            arrayList.add(C2198l.m9938b("buddy_no=? AND inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: a */
    public String m8703a(ArrayList<ContentProviderOperation> arrayList, ContentResolver contentResolver, String str, C0919es c0919es) {
        String str2;
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        Uri uri = C2219ag.f7941a;
        sb.append("update mapping_participant : ");
        for (C0892ds c0892ds : c0919es.m4985c()) {
            String strM4668d = c0892ds.m4668d();
            String strM4670f = c0892ds.m4670f();
            if (strM4670f.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                sb.append("(old:").append(strM4668d).append(",new:").append(strM4670f).append(") -> transited to my number - invalid,");
                str2 = str3;
            } else {
                arrayList.add(C2176ab.m9684b(str, strM4668d, strM4670f));
                sb.append("(old:").append(strM4668d).append(",new:").append(strM4670f).append(") -> update");
                str2 = strM4670f;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("participants_buddy_no", strM4670f);
            contentValues.put("participants_old_buddy_no", strM4668d);
            arrayList.add(ContentProviderOperation.newInsert(uri).withValues(contentValues).build());
            str3 = str2;
        }
        C4904y.m18641c(sb.toString(), f6580a);
        return str3;
    }

    /* renamed from: a */
    public void m8708a(ArrayList<ContentProviderOperation> arrayList, C0919es c0919es, String str) {
        for (C0892ds c0892ds : c0919es.m4985c()) {
            String strM4668d = c0892ds.m4668d();
            String strM4670f = c0892ds.m4670f();
            String[] strArr = {strM4668d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("buddy_no", strM4670f);
            arrayList.add(C2198l.m9938b("buddy_no=? AND inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: b */
    public void m8710b(ArrayList<ContentProviderOperation> arrayList, C0919es c0919es, String str) {
        for (C0892ds c0892ds : c0919es.m4985c()) {
            String strM4668d = c0892ds.m4668d();
            String strM4670f = c0892ds.m4670f();
            String[] strArr = {strM4668d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", strM4670f);
            arrayList.add(C2204r.m10011a("message_sender=? AND message_inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: b */
    public void m8711b(ArrayList<ContentProviderOperation> arrayList, C0963gi c0963gi, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_session_id", c0963gi.m5626i());
        arrayList.add(C2198l.m9920a("inbox_no=?", new String[]{str}, contentValues));
    }

    /* renamed from: c */
    public void m8712c(ArrayList<ContentProviderOperation> arrayList, C0963gi c0963gi, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_session_id", c0963gi.m5626i());
        arrayList.add(C2204r.m10011a("message_inbox_no=?", new String[]{str}, contentValues));
    }

    /* renamed from: d */
    public void m8713d(ArrayList<ContentProviderOperation> arrayList, C0963gi c0963gi, String str) {
        for (C0892ds c0892ds : c0963gi.m5624g()) {
            String strM4668d = c0892ds.m4668d();
            String strM4670f = c0892ds.m4670f();
            String[] strArr = {strM4668d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", strM4670f);
            arrayList.add(C2204r.m10011a("message_sender=? AND message_inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: e */
    public void m8714e(ArrayList<ContentProviderOperation> arrayList, C0963gi c0963gi, String str) {
        int iM5623f = c0963gi.m5623f() - 1;
        String[] strArr = {C4809aa.m18104a().m18121a("chaton_id", ""), str};
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_read_status", Integer.valueOf(iM5623f));
        arrayList.add(C2204r.m10011a("message_sender=? AND message_inbox_no =? AND message_read_status > " + iM5623f, strArr, contentValues));
    }
}
