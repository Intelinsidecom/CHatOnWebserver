package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.sec.chaton.util.C1786r;

/* compiled from: HandleIntent.java */
/* renamed from: com.sec.chaton.l */
/* loaded from: classes.dex */
public class C0835l {

    /* renamed from: a */
    public static String f3055a = "receiver";

    /* renamed from: b */
    public static String f3056b = "intent_data1";

    /* renamed from: c */
    public static String f3057c = "file";

    /* renamed from: d */
    public static String f3058d = "intent_data2";

    /* renamed from: e */
    private static String f3059e = "chaton";

    /* JADX WARN: Removed duplicated region for block: B:76:0x0244 A[Catch: all -> 0x0297, TryCatch #0 {all -> 0x0297, blocks: (B:74:0x023e, B:76:0x0244, B:78:0x024c, B:81:0x0262), top: B:95:0x023e }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sec.chaton.EnumC0836m m3481a(android.content.Intent r9, android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C0835l.m3481a(android.content.Intent, android.content.Context):com.sec.chaton.m");
    }

    /* renamed from: a */
    private static EnumC0836m m3480a(Context context, Intent intent, String str, String str2, String[] strArr) {
        boolean zM3482a;
        Bundle extras = intent.getExtras();
        if (str2 == null && ((strArr == null || strArr.length == 0) && str == null)) {
            C1786r.m6066e("ONEtoONE / fail to find", C0835l.class.getSimpleName());
            return EnumC0836m.HOME;
        }
        if (str == null && strArr != null && strArr.length > 0) {
            str = strArr[0];
        } else if (str == null) {
            str = str2;
            str2 = "";
        }
        boolean zStartsWith = str.startsWith("0999");
        C1786r.m6061b("checkIsBuddyAndIsInBox(), spbd_intent, exist special buddy table : " + zStartsWith + "/" + str.toString(), C0835l.class.getSimpleName());
        if (zStartsWith) {
            intent.putExtra("specialbuddy", zStartsWith);
            zM3482a = true;
        } else {
            zM3482a = false;
        }
        if (!zStartsWith) {
            zM3482a = m3482a(context, intent, str);
        }
        if (extras.containsKey("fromPush")) {
            if (extras.containsKey("buddyNO")) {
                intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                intent.removeExtra("buddyNO");
            }
            return EnumC0836m.CHATROOM;
        }
        if (str2 == null) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder(str2);
        boolean zM3483a = m3483a(str, sb, context);
        String string = sb.toString();
        if (!zM3482a && !zM3483a) {
            Toast.makeText(context, context.getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
            return EnumC0836m.HOME;
        }
        intent.putExtra("receivers", new String[]{str});
        if (zM3483a) {
            intent.putExtra("inboxNO", string);
        } else if (intent.hasExtra("inboxNO")) {
            intent.removeExtra("inboxNO");
        }
        return EnumC0836m.CHATROOM;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m3482a(android.content.Context r8, android.content.Intent r9, java.lang.String r10) {
        /*
            r5 = 0
            r4 = 2
            r7 = 0
            r6 = 1
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto La6
            android.content.ContentResolver r0 = r8.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p017e.C0688c.f2606a
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "buddy_no"
            r2[r7] = r3
            java.lang.String r3 = "buddy_show_phone_number"
            r2[r6] = r3
            java.lang.String r3 = "buddy_extra_info"
            r2[r4] = r3
            java.lang.String r3 = "buddy_no=?"
            java.lang.String[] r4 = new java.lang.String[r6]
            r4[r7] = r10
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)
            if (r2 == 0) goto La3
            int r0 = r2.getCount()     // Catch: java.lang.Throwable -> L9c
            if (r0 <= 0) goto La3
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L9c
            r0 = 1
            int r0 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L9c
            r1 = 2
            java.lang.String r5 = r2.getString(r1)     // Catch: java.lang.Throwable -> L9c
            r1 = r6
        L3f:
            if (r2 == 0) goto L44
            r2.close()
        L44:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "addExtrasToIntent "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.String r3 = ", extras="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = ", "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = ", "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.Class<com.sec.chaton.l> r3 = com.sec.chaton.C0835l.class
            java.lang.String r3 = r3.getSimpleName()
            com.sec.chaton.util.C1786r.m6061b(r2, r3)
            java.lang.String r2 = "showPhoneNumber"
            r9.putExtra(r2, r0)
            java.lang.String r0 = "extraInfo"
            r9.putExtra(r0, r5)
            android.os.Bundle r0 = r9.getExtras()
            java.lang.String r2 = "shortcut_from_chat_screen"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L9b
            java.lang.String r0 = "shortcut_from_chat_screen"
            java.lang.String r2 = "shortcut_from_chat_screen"
            r9.putExtra(r0, r2)
        L9b:
            return r1
        L9c:
            r0 = move-exception
            if (r2 == 0) goto La2
            r2.close()
        La2:
            throw r0
        La3:
            r0 = r6
            r1 = r7
            goto L3f
        La6:
            r0 = r6
            r1 = r7
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C0835l.m3482a(android.content.Context, android.content.Intent, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m3483a(java.lang.String r9, java.lang.StringBuilder r10, android.content.Context r11) {
        /*
            r5 = 0
            r7 = 1
            r6 = 0
            java.lang.String r8 = r10.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L39
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p017e.C0694i.f2616a
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r3 = "inbox_no"
            r2[r6] = r3
            java.lang.String r3 = "inbox_no = ?"
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r6] = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L7e
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L32
            if (r0 <= 0) goto L7e
            r0 = r7
        L2c:
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r0
        L32:
            r0 = move-exception
            if (r1 == 0) goto L38
            r1.close()
        L38:
            throw r0
        L39:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L7c
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p017e.C0694i.f2616a
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r3 = "inbox_no"
            r2[r6] = r3
            java.lang.String r3 = "inbox_no= ( SELECT inbox_no FROM inbox_buddy_relation WHERE buddy_no = ? )"
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r6] = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L7a
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L73
            if (r0 <= 0) goto L7a
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L73
            r0 = 0
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L73
            r2 = 0
            r10.setLength(r2)     // Catch: java.lang.Throwable -> L73
            r10.append(r0)     // Catch: java.lang.Throwable -> L73
            r0 = r7
        L6d:
            if (r1 == 0) goto L31
            r1.close()
            goto L31
        L73:
            r0 = move-exception
            if (r1 == 0) goto L79
            r1.close()
        L79:
            throw r0
        L7a:
            r0 = r6
            goto L6d
        L7c:
            r0 = r6
            goto L31
        L7e:
            r0 = r6
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C0835l.m3483a(java.lang.String, java.lang.StringBuilder, android.content.Context):boolean");
    }
}
