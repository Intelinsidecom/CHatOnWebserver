package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;

/* compiled from: HandleIntent.java */
/* renamed from: com.sec.chaton.bk */
/* loaded from: classes.dex */
public class C1071bk {

    /* renamed from: a */
    public static String f3367a = "receiver";

    /* renamed from: b */
    public static String f3368b = "intent_data1";

    /* renamed from: c */
    public static String f3369c = "file";

    /* renamed from: d */
    public static String f3370d = "intent_data2";

    /* renamed from: p */
    private static String f3382p = "chaton";

    /* renamed from: q */
    private static String f3383q = "android.intent.action.SPELL";

    /* renamed from: e */
    public static String f3371e = "intent_from";

    /* renamed from: r */
    private static String f3384r = Config.CHATON_PACKAGE_NAME;

    /* renamed from: s */
    private static String f3385s = "authorize";

    /* renamed from: f */
    public static String f3372f = "/buddy/dialog";

    /* renamed from: g */
    public static String f3373g = "/buddy/page";

    /* renamed from: h */
    public static String f3374h = "com.sec.chaton.action.VIEW_BUDDY";

    /* renamed from: i */
    public static String f3375i = "com.sec.chaton.action.CREATE_ACCOUNT_CHATONV";

    /* renamed from: j */
    public static String f3376j = "auto_backup";

    /* renamed from: k */
    public static String f3377k = "register_noti";

    /* renamed from: l */
    public static String f3378l = "com.sec.chaton.action.VOICE_CHAT";

    /* renamed from: m */
    public static String f3379m = "com.sec.chaton.action.VIDEO_CHAT";

    /* renamed from: n */
    public static String f3380n = "com.sec.chaton.action.VOICE_GROUP_CHAT";

    /* renamed from: o */
    public static String f3381o = "com.sec.chaton.action.VIDEO_GROUP_CHAT";

    /* renamed from: a */
    public static EnumC1072bl m6178a(Intent intent, Context context) {
        if (C4809aa.m18104a().m18129b("uid") || C2349a.m10301a("sms_feature")) {
            EnumC1072bl enumC1072blM6182b = EnumC1072bl.HOME;
            if (("android.intent.action.SEND".equals(intent.getAction()) || f3383q.equals(intent.getAction())) && (intent.getExtras() != null || f3382p.equals(intent.getScheme()))) {
                if (f3383q.equals(intent.getAction())) {
                    enumC1072blM6182b = m6182b(intent, context);
                    if (enumC1072blM6182b.equals(EnumC1072bl.CHATROOM)) {
                        return enumC1072blM6182b;
                    }
                } else {
                    C4904y.m18641c("ChatON specific data=" + intent.getData(), C1071bk.class.getSimpleName());
                }
                if (enumC1072blM6182b == EnumC1072bl.HOME) {
                    C5179v.m19811a(context, context.getString(R.string.toast_supported_format), 0).show();
                    return enumC1072blM6182b;
                }
                if (intent.getData() != null) {
                    intent.putExtra(f3368b, intent.getData().getHost());
                    return enumC1072blM6182b;
                }
                return enumC1072blM6182b;
            }
            if (intent.getAction() != null && intent.getAction().equals("android.intent.action.VIEW") && intent.getData() != null) {
                EnumC1072bl enumC1072bl = EnumC1072bl.HOME;
                if ((intent.hasCategory("android.intent.category.BROWSABLE") && f3382p.equals(intent.getScheme())) || f3382p.equals(intent.getScheme())) {
                    intent.getData().getHost();
                    return EnumC1072bl.HOME;
                }
            }
            if (intent.getAction() != null && intent.getAction().equals(f3375i)) {
                if (C4859bx.m18386a(context)) {
                    if (!new C0416a().m1495d(context)) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ChatONV be started to register", C1071bk.class.getSimpleName());
                        }
                        return EnumC1072bl.CHATONV;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("ChatONV already registerd", C1071bk.class.getSimpleName());
                        return enumC1072blM6182b;
                    }
                    return enumC1072blM6182b;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("ChatONV was not available", C1071bk.class.getSimpleName());
                    return enumC1072blM6182b;
                }
                return enumC1072blM6182b;
            }
            if (intent.getAction() != null && intent.getAction().equals(f3378l)) {
                return EnumC1072bl.VOICE_CHAT;
            }
            if (intent.getAction() != null && intent.getAction().equals(f3379m)) {
                return EnumC1072bl.VIDEO_CHAT;
            }
            if (intent.getAction() != null && intent.getAction().equals(f3380n)) {
                return EnumC1072bl.VOICE_GROUP_CHAT;
            }
            if (intent.getAction() != null && intent.getAction().equals(f3381o)) {
                return EnumC1072bl.VIDEO_GROUP_CHAT;
            }
            if (intent.getAction() != null && intent.getAction().equals(f3376j)) {
                return EnumC1072bl.AUTO_BACKUP;
            }
            if (intent.getAction() != null && intent.getAction().equals(f3377k)) {
                return EnumC1072bl.REGISTER_NOTI;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (extras.containsKey("callChatTab")) {
                    return EnumC1072bl.CHATLIST;
                }
                if (extras.containsKey("callRestart") || extras.containsKey("finish") || extras.containsKey("callUpgradeDialog")) {
                    return EnumC1072bl.HOME;
                }
                String string = extras.getString("inboxNO");
                String[] stringArray = extras.getStringArray("receivers");
                int i = extras.getInt("chatType");
                String string2 = extras.getString("buddyNO");
                if (i == EnumC2300t.ONETOONE.m10210a()) {
                    return m6177a(context, intent, string2, string, stringArray);
                }
                if (extras.containsKey("fromPush")) {
                    if (extras.containsKey("buddyNO")) {
                        intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                        intent.removeExtra("buddyNO");
                    }
                    return EnumC1072bl.CHATROOM;
                }
                if (string != null) {
                    Cursor cursorQuery = context.getContentResolver().query(C2299s.f8209a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{string}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() != 0) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                intent.putExtra("inboxNO", string);
                                C4904y.m18641c("Shocrcut from homescreen", C1071bk.class.getSimpleName());
                                return EnumC1072bl.CHATROOM;
                            }
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_group_broadcast_chat_room_closed), 0).show();
                    EnumC1072bl enumC1072bl2 = EnumC1072bl.HOME;
                }
                return EnumC1072bl.CHATROOM;
            }
            return EnumC1072bl.HOME;
        }
        return EnumC1072bl.HOME;
    }

    /* renamed from: b */
    private static EnumC1072bl m6182b(Intent intent, Context context) {
        EnumC1072bl enumC1072bl = EnumC1072bl.HOME;
        if (intent.getExtras() != null) {
            String string = intent.getExtras().getString("mQuery");
            String string2 = intent.getExtras().getString("chatonmessage");
            String string3 = intent.getExtras().getString("chatonbuddy");
            if (string3 != null || string == null || string.length() <= 0) {
                string = string3;
            }
            if (string != null && string.length() > 0 && string2 == null) {
                intent.putExtra("null", string);
                enumC1072bl = EnumC1072bl.FORWARD;
            } else if (string2 != null && string2.length() > 0 && string == null) {
                intent.putExtra("download_uri", string2);
                enumC1072bl = EnumC1072bl.FORWARD;
            } else if (string != null && string.length() > 0 && string2 != null && string2.length() > 0) {
                intent.putExtra("download_uri", string2);
                if (m6179a(context, intent, string)) {
                    intent.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    intent.putExtra("callChatList", true);
                }
                enumC1072bl = EnumC1072bl.CHATROOM;
            }
            intent.putExtra("callForward", true);
            intent.putExtra("content_type", EnumC2214ab.TEXT.m10076a());
            intent.putExtra(f3371e, EnumC1094bm.API);
        }
        return enumC1072bl;
    }

    /* renamed from: a */
    private static EnumC1072bl m6177a(Context context, Intent intent, String str, String str2, String[] strArr) {
        String str3;
        boolean z;
        boolean zM6183b;
        boolean zM6181a;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            if (C4904y.f17875e) {
                C4904y.m18634a("checkIsBuddyAndIsInBox(), abnormal status !!!!", C1071bk.class.getSimpleName());
            }
            return EnumC1072bl.HOME;
        }
        EnumC1094bm enumC1094bm = (EnumC1094bm) extras.get(f3371e);
        if (str2 == null && ((strArr == null || strArr.length == 0) && str == null)) {
            C4904y.m18646e("ONEtoONE / fail to find", C1071bk.class.getSimpleName());
            return EnumC1072bl.HOME;
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
            C4904y.m18646e("ONEtoONE / fail to find.", C1071bk.class.getSimpleName());
            return EnumC1072bl.HOME;
        }
        if (str2 != null) {
            boolean zStartsWith = str2.startsWith("0999");
            if (C4904y.f17872b) {
                C4904y.m18639b("checkIsBuddyAndIsInBox(), spbd_intent, exist special buddy table : " + zStartsWith + "/" + str2.toString(), C1071bk.class.getSimpleName());
            }
            z = zStartsWith;
        } else {
            z = false;
        }
        if (z) {
            zM6183b = C2186al.m9774c(context.getContentResolver(), str2);
            intent.putExtra("specialbuddy", z);
        } else {
            zM6183b = false;
        }
        if (!z) {
            zM6183b = m6183b(context, intent, str2);
        }
        if (extras.containsKey("fromPush")) {
            if (extras.containsKey("buddyNO")) {
                intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                intent.removeExtra("buddyNO");
            }
            return EnumC1072bl.CHATROOM;
        }
        if (str3 == null) {
            str3 = "";
        }
        StringBuilder sb = new StringBuilder(str3);
        EnumC2300t enumC2300tM10207a = EnumC2300t.UNKNOWN;
        if (extras != null && extras.containsKey("chatType")) {
            enumC2300tM10207a = EnumC2300t.m10207a(extras.getInt("chatType", -1));
        }
        if (enumC2300tM10207a != EnumC2300t.BROADCAST) {
            EnumC2301u enumC2301u = EnumC2301u.NORMAL;
            if (extras.containsKey("roomType")) {
                intent.putExtra("roomType", EnumC2301u.m10211a(extras.getInt("roomType")).m10212a());
            }
            zM6181a = m6181a(str2, sb, context);
        } else {
            zM6181a = false;
        }
        String string = sb.toString();
        if (z) {
            boolean zM6180a = zM6181a ? m6180a(context, sb) : false;
            if (!zM6183b && !zM6180a) {
                C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
                return EnumC1072bl.HOME;
            }
        } else if (!zM6183b && !zM6181a && enumC1094bm != EnumC1094bm.API) {
            C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
            return EnumC1072bl.HOME;
        }
        if (zM6183b) {
            intent.putExtra("receivers", new String[]{str2});
        }
        if (zM6181a) {
            intent.putExtra("inboxNO", string);
        } else if (intent.hasExtra("inboxNO")) {
            intent.removeExtra("inboxNO");
        }
        return EnumC1072bl.CHATROOM;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m6179a(android.content.Context r8, android.content.Intent r9, java.lang.String r10) {
        /*
            r6 = 0
            r7 = 1
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L59
            android.content.ContentResolver r0 = r8.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a
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
            if (r1 == 0) goto L57
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L50
            if (r0 != r7) goto L57
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = "buddy_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = "receivers"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L50
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L50
            r9.putExtra(r2, r3)     // Catch: java.lang.Throwable -> L50
            r0 = r7
        L4a:
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            return r0
        L50:
            r0 = move-exception
            if (r1 == 0) goto L56
            r1.close()
        L56:
            throw r0
        L57:
            r0 = r6
            goto L4a
        L59:
            r0 = r6
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C1071bk.m6179a(android.content.Context, android.content.Intent, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m6183b(android.content.Context r9, android.content.Intent r10, java.lang.String r11) {
        /*
            r8 = 3
            r4 = 2
            r5 = 0
            r7 = 1
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto Lc0
            android.content.ContentResolver r0 = r9.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a
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
            if (r2 == 0) goto Lbd
            int r0 = r2.getCount()     // Catch: java.lang.Throwable -> Lb6
            if (r0 <= 0) goto Lbd
            r2.moveToFirst()     // Catch: java.lang.Throwable -> Lb6
            r0 = 1
            int r6 = r2.getInt(r0)     // Catch: java.lang.Throwable -> Lb6
            r0 = 2
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> Lb6
            r1 = 3
            java.lang.String r5 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb6
            r1 = r6
            r6 = r7
        L4f:
            if (r2 == 0) goto L54
            r2.close()
        L54:
            boolean r2 = com.sec.chaton.util.C4904y.f17872b
            if (r2 == 0) goto L9d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "addExtrasToIntent"
            r2.append(r3)
            if (r11 == 0) goto L68
            r2.append(r11)
        L68:
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
            if (r0 == 0) goto L90
            r2.append(r0)
        L90:
            java.lang.String r2 = r2.toString()
            java.lang.Class<com.sec.chaton.bk> r3 = com.sec.chaton.C1071bk.class
            java.lang.String r3 = r3.getSimpleName()
            com.sec.chaton.util.C4904y.m18639b(r2, r3)
        L9d:
            java.lang.String r2 = "showPhoneNumber"
            r10.putExtra(r2, r1)
            java.lang.String r1 = "extraInfo"
            r10.putExtra(r1, r0)
            java.lang.String r0 = "msisdns"
            r10.putExtra(r0, r5)
            java.lang.String r0 = "is_buddy"
            r10.putExtra(r0, r6)
            return r6
        Lb6:
            r0 = move-exception
            if (r2 == 0) goto Lbc
            r2.close()
        Lbc:
            throw r0
        Lbd:
            r0 = r5
            r1 = r6
            goto L4f
        Lc0:
            r0 = r5
            r1 = r6
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C1071bk.m6183b(android.content.Context, android.content.Intent, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m6181a(java.lang.String r9, java.lang.StringBuilder r10, android.content.Context r11) {
        /*
            r5 = 0
            r7 = 1
            r6 = 0
            java.lang.String r8 = r10.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L3b
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r3 = "inbox_no"
            r2[r6] = r3
            java.lang.String r3 = "inbox_no = ?"
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r6] = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L99
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L34
            if (r0 <= 0) goto L99
            r0 = r7
        L2e:
            if (r1 == 0) goto L33
            r1.close()
        L33:
            return r0
        L34:
            r0 = move-exception
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            throw r0
        L3b:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L97
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a
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
            if (r1 == 0) goto L95
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L8e
            if (r0 <= 0) goto L95
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L8e
            r0 = 0
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L8e
            r2 = 0
            r10.setLength(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = "inbox_last_chat_type"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8e
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L8e
            r3 = 12
            if (r2 != r3) goto L89
            r0 = r6
        L83:
            if (r1 == 0) goto L33
            r1.close()
            goto L33
        L89:
            r10.append(r0)     // Catch: java.lang.Throwable -> L8e
            r0 = r7
            goto L83
        L8e:
            r0 = move-exception
            if (r1 == 0) goto L94
            r1.close()
        L94:
            throw r0
        L95:
            r0 = r6
            goto L83
        L97:
            r0 = r6
            goto L33
        L99:
            r0 = r6
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.C1071bk.m6181a(java.lang.String, java.lang.StringBuilder, android.content.Context):boolean");
    }

    /* renamed from: a */
    public static boolean m6180a(Context context, StringBuilder sb) {
        Cursor cursorQuery = context.getContentResolver().query(C2306z.f8229a, null, "message_inbox_no=?", new String[]{sb.toString()}, null);
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
