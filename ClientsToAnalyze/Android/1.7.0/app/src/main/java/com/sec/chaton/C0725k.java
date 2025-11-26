package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.sec.chaton.access_token.AccessTokenProvider;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p028e.C0682i;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: HandleIntent.java */
/* renamed from: com.sec.chaton.k */
/* loaded from: classes.dex */
public class C0725k {

    /* renamed from: a */
    public static String f2450a = "receiver";

    /* renamed from: b */
    public static String f2451b = "intent_data1";

    /* renamed from: c */
    public static String f2452c = "file";

    /* renamed from: d */
    public static String f2453d = "intent_data2";

    /* renamed from: e */
    private static String f2454e = "chaton";

    /* renamed from: a */
    public static EnumC0250am m3124a(Intent intent, Context context) {
        Cursor cursorQuery;
        EnumC0250am enumC0250amM3123a;
        if (C1323bs.m4575a().contains("uid")) {
            if ((intent.getFlags() & 1048576) == 1048576) {
                return EnumC0250am.HOME;
            }
            if ("android.intent.action.SEND".equals(intent.getAction()) && intent.getExtras() != null) {
                C1341p.m4660c("Interlocked With " + intent.getExtras().toString() + " / Type : " + intent.getType(), C0725k.class.getSimpleName());
                EnumC0250am enumC0250amMo3045a = C0682i.m3048a(intent).mo3045a();
                if (f2454e.equals(intent.getScheme())) {
                    C1341p.m4660c("ChatON specific data=" + intent.getData(), C0725k.class.getSimpleName());
                    if (intent.getExtras().containsKey(f2450a)) {
                        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                        if (stringArrayExtra == null && intent.getExtras().containsKey(f2450a)) {
                            stringArrayExtra = new String[]{intent.getStringExtra(f2450a)};
                        }
                        if (stringArrayExtra != null && (intent.getExtras().containsKey("android.intent.extra.TEXT") || intent.getExtras().containsKey("android.intent.extra.STREAM"))) {
                            C1341p.m4660c("If both receiver and content are given, proper access token is required.", C0725k.class.getSimpleName());
                            if (!AccessTokenProvider.m884a(context, intent.getExtras())) {
                                C1341p.m4651a("Access token is incorrect.", C0725k.class.getSimpleName());
                                return EnumC0250am.HOME;
                            }
                        }
                        intent.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                        intent.putExtra("callChatList", true);
                        enumC0250amMo3045a = m3123a(context, intent, null, null, stringArrayExtra);
                    }
                    intent.putExtra(f2451b, intent.getData().getHost());
                }
                if (enumC0250amMo3045a == EnumC0250am.HOME) {
                    C1619g.m5889a(context, context.getString(R.string.toast_supported_format), 0).show();
                    return enumC0250amMo3045a;
                }
                return enumC0250amMo3045a;
            }
            if (intent.getAction() != null && intent.getAction().equals("android.intent.action.VIEW") && intent.getData() != null) {
                C1341p.m4660c("Shocrcut from contact", C0725k.class.getSimpleName());
                cursorQuery = context.getContentResolver().query(intent.getData(), null, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        intent.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                        intent.putExtra("callChatList", true);
                        enumC0250amM3123a = m3123a(context, intent, string, null, null);
                    } else {
                        C1619g.m5889a(context, context.getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                        enumC0250amM3123a = EnumC0250am.HOME;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                    return enumC0250amM3123a;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (extras.containsKey("callRestart") || extras.containsKey("finish") || extras.containsKey("callUpgradeDialog")) {
                    return EnumC0250am.HOME;
                }
                String string2 = extras.getString("inboxNO");
                String[] stringArray = extras.getStringArray("receivers");
                int i = extras.getInt("chatType");
                String string3 = extras.getString("buddyNO");
                if (i == EnumC0665r.ONETOONE.m3012a()) {
                    return m3123a(context, intent, string3, string2, stringArray);
                }
                if (extras.containsKey("fromPush")) {
                    if (extras.containsKey("buddyNO")) {
                        intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                        intent.removeExtra("buddyNO");
                    }
                    return EnumC0250am.CHATROOM;
                }
                if (string2 != null) {
                    cursorQuery = context.getContentResolver().query(C0671x.f2315a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{string2}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() != 0) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                intent.putExtra("inboxNO", string2);
                                C1341p.m4660c("Shocrcut from homescreen", C0725k.class.getSimpleName());
                                return EnumC0250am.CHATROOM;
                            }
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    C1619g.m5889a(context, context.getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                    EnumC0250am enumC0250am = EnumC0250am.HOME;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return enumC0250am;
                    }
                    return enumC0250am;
                }
                return EnumC0250am.CHATROOM;
            }
            return EnumC0250am.HOME;
        }
        return EnumC0250am.HOME;
    }

    /* renamed from: a */
    private static EnumC0250am m3123a(Context context, Intent intent, String str, String str2, String[] strArr) {
        Bundle extras = intent.getExtras();
        if (str2 == null && ((strArr == null || strArr.length == 0) && str == null)) {
            C1341p.m4662e("ONEtoONE / fail to find", C0725k.class.getSimpleName());
            return EnumC0250am.HOME;
        }
        if (str == null && strArr != null && strArr.length > 0) {
            str = strArr[0];
        } else if (str == null) {
            str = str2;
            str2 = "";
        }
        if (extras.containsKey("fromPush")) {
            if (extras.containsKey("buddyNO")) {
                intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                intent.removeExtra("buddyNO");
            }
            return EnumC0250am.CHATROOM;
        }
        boolean zM3125a = m3125a(context, intent, str);
        if (str2 == null) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder(str2);
        boolean zM3126a = m3126a(str, sb, context);
        String string = sb.toString();
        if (!zM3125a && !zM3126a) {
            C1619g.m5889a(context, context.getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
            return EnumC0250am.HOME;
        }
        if (zM3125a) {
            intent.putExtra("receivers", new String[]{str});
        }
        if (zM3126a) {
            intent.putExtra("inboxNO", string);
        } else if (intent.hasExtra("inboxNO")) {
            intent.removeExtra("inboxNO");
        }
        return EnumC0250am.CHATROOM;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m3125a(android.content.Context r8, android.content.Intent r9, java.lang.String r10) {
        /*
            r5 = 0
            r4 = 2
            r7 = 0
            r6 = 1
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L93
            android.content.ContentResolver r0 = r8.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p025d.C0667t.f2310a
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
            if (r2 == 0) goto L90
            int r0 = r2.getCount()     // Catch: java.lang.Throwable -> L89
            if (r0 <= 0) goto L90
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L89
            r0 = 1
            int r0 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L89
            r1 = 2
            java.lang.String r5 = r2.getString(r1)     // Catch: java.lang.Throwable -> L89
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
            java.lang.Class<com.sec.chaton.k> r3 = com.sec.chaton.C0725k.class
            java.lang.String r3 = r3.getSimpleName()
            com.sec.chaton.util.C1341p.m4658b(r2, r3)
            java.lang.String r2 = "showPhoneNumber"
            r9.putExtra(r2, r0)
            java.lang.String r0 = "extraInfo"
            r9.putExtra(r0, r5)
            return r1
        L89:
            r0 = move-exception
            if (r2 == 0) goto L8f
            r2.close()
        L8f:
            throw r0
        L90:
            r0 = r6
            r1 = r7
            goto L3f
        L93:
            r0 = r6
            r1 = r7
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C0725k.m3125a(android.content.Context, android.content.Intent, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m3126a(java.lang.String r9, java.lang.StringBuilder r10, android.content.Context r11) {
        /*
            r5 = 0
            r7 = 1
            r6 = 0
            java.lang.String r8 = r10.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L39
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p025d.C0671x.f2315a
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
            android.net.Uri r1 = com.sec.chaton.p025d.C0671x.f2315a
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C0725k.m3126a(java.lang.String, java.lang.StringBuilder, android.content.Context):boolean");
    }
}
