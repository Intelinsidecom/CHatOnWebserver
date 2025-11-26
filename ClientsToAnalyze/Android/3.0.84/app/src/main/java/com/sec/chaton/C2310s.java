package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: HandleIntent.java */
/* renamed from: com.sec.chaton.s */
/* loaded from: classes.dex */
public class C2310s {

    /* renamed from: a */
    public static String f8617a = "receiver";

    /* renamed from: b */
    public static String f8618b = "intent_data1";

    /* renamed from: c */
    public static String f8619c = "file";

    /* renamed from: d */
    public static String f8620d = "intent_data2";

    /* renamed from: m */
    private static String f8629m = "chaton";

    /* renamed from: n */
    private static String f8630n = "android.intent.action.SPELL";

    /* renamed from: e */
    public static String f8621e = "intent_from";

    /* renamed from: o */
    private static String f8631o = "com.sec.chaton";

    /* renamed from: p */
    private static String f8632p = "com.sec.chaton.action.ADD_BUDDY";

    /* renamed from: f */
    public static String f8622f = "com.sec.chaton.action.VIEW_BUDDY";

    /* renamed from: g */
    public static String f8623g = "com.sec.chaton.action.CREATE_ACCOUNT_CHATONV";

    /* renamed from: h */
    public static String f8624h = "auto_backup";

    /* renamed from: i */
    public static String f8625i = "com.sec.chaton.action.VOICE_CHAT";

    /* renamed from: j */
    public static String f8626j = "com.sec.chaton.action.VIDEO_CHAT";

    /* renamed from: k */
    public static String f8627k = "com.sec.chaton.action.VOICE_GROUP_CHAT";

    /* renamed from: l */
    public static String f8628l = "com.sec.chaton.action.VIDEO_GROUP_CHAT";

    /* JADX WARN: Removed duplicated region for block: B:135:0x036c A[Catch: all -> 0x0388, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0388, blocks: (B:130:0x033e, B:132:0x0344, B:135:0x036c), top: B:249:0x033e }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sec.chaton.EnumC2947t m8680a(android.content.Intent r10, android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 1418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C2310s.m8680a(android.content.Intent, android.content.Context):com.sec.chaton.t");
    }

    /* renamed from: b */
    private static EnumC2947t m8685b(Intent intent, Context context) {
        EnumC2947t enumC2947t = EnumC2947t.HOME;
        if (intent.getExtras() != null) {
            String string = intent.getExtras().getString("mQuery");
            String string2 = intent.getExtras().getString("chatonmessage");
            String string3 = intent.getExtras().getString("chatonbuddy");
            if (string3 != null || string == null || string.length() <= 0) {
                string = string3;
            }
            if (string != null && string.length() > 0 && string2 == null) {
                intent.putExtra("null", string);
                enumC2947t = EnumC2947t.FORWARD;
            } else if (string2 != null && string2.length() > 0 && string == null) {
                intent.putExtra("download_uri", string2);
                enumC2947t = EnumC2947t.FORWARD;
            } else if (string != null && string.length() > 0 && string2 != null && string2.length() > 0) {
                intent.putExtra("download_uri", string2);
                if (m8681a(context, intent, string)) {
                    intent.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                    intent.putExtra("callChatList", true);
                }
                enumC2947t = EnumC2947t.CHATROOM;
            }
            intent.putExtra("callForward", true);
            intent.putExtra("content_type", EnumC1455w.TEXT.m6364a());
            intent.putExtra(f8621e, EnumC3073u.API);
        }
        return enumC2947t;
    }

    /* renamed from: a */
    private static EnumC2947t m8679a(Context context, Intent intent, String str, String str2, String[] strArr) {
        String str3;
        boolean z;
        boolean zM8686b;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            if (C3250y.f11737e) {
                C3250y.m11442a("checkIsBuddyAndIsInBox(), abnormal status !!!!", C2310s.class.getSimpleName());
            }
            return EnumC2947t.HOME;
        }
        EnumC3073u enumC3073u = (EnumC3073u) extras.get(f8621e);
        if (str2 == null && ((strArr == null || strArr.length == 0) && str == null)) {
            C3250y.m11456e("ONEtoONE / fail to find", C2310s.class.getSimpleName());
            return EnumC2947t.HOME;
        }
        if (str == null && strArr != null && strArr.length > 0) {
            str3 = str2;
            str2 = strArr[0];
        } else if (str == null) {
            str3 = "";
        } else {
            str3 = str2;
            str2 = str;
        }
        if (str2 == null) {
            C3250y.m11456e("ONEtoONE / fail to find.", C2310s.class.getSimpleName());
            return EnumC2947t.HOME;
        }
        if (str2 != null) {
            boolean zStartsWith = str2.startsWith("0999");
            if (C3250y.f11734b) {
                C3250y.m11450b("checkIsBuddyAndIsInBox(), spbd_intent, exist special buddy table : " + zStartsWith + "/" + str2.toString(), C2310s.class.getSimpleName());
            }
            z = zStartsWith;
        } else {
            z = false;
        }
        if (z) {
            zM8686b = C1357af.m5997c(context.getContentResolver(), str2);
            intent.putExtra("specialbuddy", z);
        } else {
            zM8686b = false;
        }
        if (!z) {
            zM8686b = m8686b(context, intent, str2);
        }
        if (extras.containsKey("fromPush")) {
            if (extras.containsKey("buddyNO")) {
                intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                intent.removeExtra("buddyNO");
            }
            return EnumC2947t.CHATROOM;
        }
        if (str3 == null) {
            str3 = "";
        }
        StringBuilder sb = new StringBuilder(str3);
        EnumC1450r enumC1450rM6339a = EnumC1450r.UNKNOWN;
        if (extras != null && extras.containsKey("chatType")) {
            enumC1450rM6339a = EnumC1450r.m6339a(extras.getInt("chatType", -1));
        }
        boolean zM8683a = enumC1450rM6339a != EnumC1450r.BROADCAST ? m8683a(str2, sb, context) : false;
        String string = sb.toString();
        if (z) {
            boolean zM8682a = zM8683a ? m8682a(context, sb) : false;
            if (!zM8686b && !zM8682a) {
                C3641ai.m13211a(context, context.getResources().getString(R.string.shortcut_buddy_blocked_or_notfound), 0).show();
                return EnumC2947t.HOME;
            }
        } else if (!zM8686b && !zM8683a && enumC3073u != EnumC3073u.API) {
            C3641ai.m13211a(context, context.getResources().getString(R.string.shortcut_buddy_blocked_or_notfound), 0).show();
            return EnumC2947t.HOME;
        }
        if (zM8686b) {
            intent.putExtra("receivers", new String[]{str2});
        }
        if (zM8683a) {
            intent.putExtra("inboxNO", string);
        } else if (intent.hasExtra("inboxNO")) {
            intent.removeExtra("inboxNO");
        }
        return EnumC2947t.CHATROOM;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m8681a(android.content.Context r8, android.content.Intent r9, java.lang.String r10) {
        /*
            r6 = 0
            r7 = 1
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L54
            android.content.ContentResolver r0 = r8.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p027e.C1441i.f5369a
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "buddy_no"
            r2[r6] = r3
            java.lang.String r3 = "buddy_name"
            r2[r7] = r3
            java.lang.String r3 = "buddy_name=?"
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r6] = r10
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L52
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L4b
            if (r0 != r7) goto L52
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r0 = "buddy_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "receivers"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L4b
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L4b
            r9.putExtra(r2, r3)     // Catch: java.lang.Throwable -> L4b
            r0 = r7
        L45:
            if (r1 == 0) goto L4a
            r1.close()
        L4a:
            return r0
        L4b:
            r0 = move-exception
            if (r1 == 0) goto L51
            r1.close()
        L51:
            throw r0
        L52:
            r0 = r6
            goto L45
        L54:
            r0 = r6
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C2310s.m8681a(android.content.Context, android.content.Intent, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m8686b(android.content.Context r9, android.content.Intent r10, java.lang.String r11) {
        /*
            r8 = 3
            r4 = 2
            r5 = 0
            r7 = 1
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto Lb2
            android.content.ContentResolver r0 = r9.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p027e.C1441i.f5369a
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "buddy_no"
            r2[r6] = r3
            java.lang.String r3 = "buddy_show_phone_number"
            r2[r7] = r3
            java.lang.String r3 = "buddy_extra_info"
            r2[r4] = r3
            java.lang.String r3 = "buddy_msisdns"
            r2[r8] = r3
            java.lang.String r3 = "buddy_no=?"
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r6] = r11
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)
            if (r2 == 0) goto Laf
            int r0 = r2.getCount()     // Catch: java.lang.Throwable -> La8
            if (r0 <= 0) goto Laf
            r2.moveToFirst()     // Catch: java.lang.Throwable -> La8
            r0 = 1
            int r6 = r2.getInt(r0)     // Catch: java.lang.Throwable -> La8
            r0 = 2
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> La8
            r1 = 3
            java.lang.String r5 = r2.getString(r1)     // Catch: java.lang.Throwable -> La8
            r1 = r6
            r6 = r7
        L4a:
            if (r2 == 0) goto L4f
            r2.close()
        L4f:
            boolean r2 = com.sec.chaton.util.C3250y.f11734b
            if (r2 == 0) goto L93
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "addExtrasToIntent"
            r2.append(r3)
            if (r11 == 0) goto L62
            r2.append(r11)
        L62:
            java.lang.String r3 = ", "
            java.lang.StringBuilder r3 = r2.append(r3)
            java.lang.String r4 = "extras="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r4 = ", "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r4 = ", "
            r3.append(r4)
            if (r0 == 0) goto L86
            r2.append(r0)
        L86:
            java.lang.String r2 = r2.toString()
            java.lang.Class<com.sec.chaton.s> r3 = com.sec.chaton.C2310s.class
            java.lang.String r3 = r3.getSimpleName()
            com.sec.chaton.util.C3250y.m11450b(r2, r3)
        L93:
            java.lang.String r2 = "showPhoneNumber"
            r10.putExtra(r2, r1)
            java.lang.String r1 = "extraInfo"
            r10.putExtra(r1, r0)
            java.lang.String r0 = "msisdns"
            r10.putExtra(r0, r5)
            java.lang.String r0 = "is_buddy"
            r10.putExtra(r0, r6)
            return r6
        La8:
            r0 = move-exception
            if (r2 == 0) goto Lae
            r2.close()
        Lae:
            throw r0
        Laf:
            r0 = r5
            r1 = r6
            goto L4a
        Lb2:
            r0 = r5
            r1 = r6
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C2310s.m8686b(android.content.Context, android.content.Intent, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m8683a(java.lang.String r9, java.lang.StringBuilder r10, android.content.Context r11) {
        /*
            r5 = 0
            r7 = 1
            r6 = 0
            java.lang.String r8 = r10.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L39
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p027e.C1449q.f5381a
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r3 = "inbox_no"
            r2[r6] = r3
            java.lang.String r3 = "inbox_no = ?"
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r6] = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L93
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L32
            if (r0 <= 0) goto L93
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
            if (r0 != 0) goto L91
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p027e.C1449q.f5381a
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "inbox_no"
            r2[r6] = r3
            java.lang.String r3 = "inbox_last_chat_type"
            r2[r7] = r3
            java.lang.String r3 = "inbox_no= ( SELECT inbox_no FROM inbox_buddy_relation WHERE buddy_no = ? )"
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r6] = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L8f
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L88
            if (r0 <= 0) goto L8f
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L88
            r0 = 0
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L88
            r2 = 0
            r10.setLength(r2)     // Catch: java.lang.Throwable -> L88
            java.lang.String r2 = "inbox_last_chat_type"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L88
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L88
            r3 = 12
            if (r2 != r3) goto L83
            r0 = r6
        L7d:
            if (r1 == 0) goto L31
            r1.close()
            goto L31
        L83:
            r10.append(r0)     // Catch: java.lang.Throwable -> L88
            r0 = r7
            goto L7d
        L88:
            r0 = move-exception
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            throw r0
        L8f:
            r0 = r6
            goto L7d
        L91:
            r0 = r6
            goto L31
        L93:
            r0 = r6
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C2310s.m8683a(java.lang.String, java.lang.StringBuilder, android.content.Context):boolean");
    }

    /* renamed from: a */
    private static String[] m8684a(Context context, String[] strArr) {
        Cursor cursorQuery = null;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            sb2.append("'").append(str).append("'").append(",");
        }
        sb2.setLength(sb2.length() - 1);
        sb.append("buddy_no").append(" IN ").append("( ").append(sb2.toString()).append(" )");
        try {
            cursorQuery = context.getContentResolver().query(C1441i.f5369a, new String[]{"buddy_no"}, sb.toString(), null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: a */
    public static boolean m8682a(Context context, StringBuilder sb) {
        Cursor cursorQuery = context.getContentResolver().query(C1454v.f5393a, null, "message_inbox_no=?", new String[]{sb.toString()}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }
}
