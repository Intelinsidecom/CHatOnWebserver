package com.sec.chaton.chat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.R;
import com.sec.chaton.api.access_token.AccessTokenProvider;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p062h.C2362h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4811ac;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: HandleIntentForChat.java */
/* renamed from: com.sec.chaton.chat.hf */
/* loaded from: classes.dex */
public class C1760hf {

    /* renamed from: f */
    private static String f6610f = "chaton";

    /* renamed from: g */
    private static String f6611g = "receiver";

    /* renamed from: a */
    public static String f6605a = "intent_from";

    /* renamed from: b */
    public static String f6606b = "intent_data1";

    /* renamed from: c */
    public static String f6607c = "file";

    /* renamed from: d */
    public static String f6608d = "intent_data2";

    /* renamed from: e */
    public static String f6609e = "intent_chat_for_tablet";

    /* renamed from: a */
    public static EnumC1761hg m8731a(Intent intent, Context context) {
        if (!C4809aa.m18104a().m18129b("uid") && !C2349a.m10301a("sms_feature")) {
            return EnumC1761hg.UNKNOWN;
        }
        if (m8734a(intent)) {
            return EnumC1761hg.CHATLIST;
        }
        if (intent == null) {
            return EnumC1761hg.UNKNOWN;
        }
        if ("android.intent.action.SEND".equals(intent.getAction())) {
            return m8744f(intent, context);
        }
        if ("android.intent.action.VIEW".equals(intent.getAction()) && intent.getData() != null) {
            return m8743e(intent, context);
        }
        if (m8739b(intent)) {
            return m8738b(intent, context);
        }
        if (C4811ac.m18137a(intent)) {
            return m8740c(intent, context);
        }
        return m8742d(intent, context);
    }

    /* renamed from: a */
    private static boolean m8734a(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("callChatTab");
    }

    /* renamed from: b */
    private static boolean m8739b(Intent intent) {
        return intent.hasExtra("fromPush");
    }

    /* renamed from: b */
    private static EnumC1761hg m8738b(Intent intent, Context context) {
        if (intent.hasExtra("buddyNO")) {
            intent.putExtra("receivers", new String[]{intent.getStringExtra("buddyNO")});
            intent.removeExtra("buddyNO");
        }
        return EnumC1761hg.CHATROOM;
    }

    /* renamed from: c */
    private static EnumC1761hg m8740c(Intent intent, Context context) {
        if (intent.hasExtra("groupId")) {
            String stringExtra = intent.getStringExtra("groupId");
            if (C2191e.m9859b(context.getContentResolver(), Integer.valueOf(stringExtra).intValue()) != 1) {
                C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
                return EnumC1761hg.HOME;
            }
            String strM9960m = C2198l.m9960m(context.getContentResolver(), stringExtra);
            if (TextUtils.isEmpty(strM9960m)) {
                return EnumC1761hg.CHATROOM;
            }
            intent.putExtra("inboxNO", strM9960m);
            intent.removeExtra("groupId");
            ArrayList<String> arrayListM9852a = C2191e.m9852a(context.getContentResolver(), Integer.valueOf(stringExtra).intValue());
            intent.putExtra("receivers", (String[]) arrayListM9852a.toArray(new String[arrayListM9852a.size()]));
            return EnumC1761hg.CHATROOM;
        }
        String stringExtra2 = intent.getStringExtra("inboxNO");
        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
        int intExtra = intent.getIntExtra("chatType", EnumC2300t.UNKNOWN.m10210a());
        String stringExtra3 = intent.getStringExtra("buddyNO");
        if (intExtra == EnumC2300t.ONETOONE.m10210a()) {
            return m8729a(context, intent, stringExtra3, stringExtra2, stringArrayExtra);
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            return EnumC1761hg.CHATROOM;
        }
        if (!C2198l.m9965r(context.getContentResolver(), stringExtra2)) {
            C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_group_broadcast_chat_room_closed), 0).show();
            return EnumC1761hg.HOME;
        }
        intent.putExtra("inboxNO", stringExtra2);
        if (C4904y.f17873c) {
            C4904y.m18641c("Shocrcut from homescreen", C1071bk.class.getSimpleName());
        }
        return EnumC1761hg.CHATROOM;
    }

    /* renamed from: d */
    private static EnumC1761hg m8742d(Intent intent, Context context) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return EnumC1761hg.UNKNOWN;
        }
        if (extras.containsKey("callChatTab")) {
            return EnumC1761hg.CHATLIST;
        }
        if (extras.containsKey("callRestart") || extras.containsKey("finish") || extras.containsKey("callUpgradeDialog")) {
            return EnumC1761hg.UNKNOWN;
        }
        String string = extras.getString("inboxNO");
        String[] stringArray = extras.getStringArray("receivers");
        int i = extras.getInt("chatType");
        String string2 = extras.getString("buddyNO");
        if (i == EnumC2300t.ONETOONE.m10210a()) {
            return m8729a(context, intent, string2, string, stringArray);
        }
        if (extras.containsKey("fromPush")) {
            if (extras.containsKey("buddyNO")) {
                intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                intent.removeExtra("buddyNO");
            }
            return EnumC1761hg.CHATROOM;
        }
        if (TextUtils.isEmpty(string)) {
            return EnumC1761hg.CHATROOM;
        }
        if (!C2198l.m9965r(context.getContentResolver(), string)) {
            C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_group_broadcast_chat_room_closed), 0).show();
            return EnumC1761hg.UNKNOWN;
        }
        intent.putExtra("inboxNO", string);
        C4904y.m18641c("Shocrcut from homescreen", C1071bk.class.getSimpleName());
        return EnumC1761hg.CHATROOM;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0074 A[DONT_GENERATE, PHI: r0
  0x0074: PHI (r0v13 com.sec.chaton.chat.hg) = (r0v10 com.sec.chaton.chat.hg), (r0v17 com.sec.chaton.chat.hg) binds: [B:15:0x0072, B:18:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078 A[Catch: all -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:12:0x0048, B:14:0x004e, B:17:0x0078), top: B:25:0x0048 }] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.sec.chaton.chat.EnumC1761hg m8743e(android.content.Intent r6, android.content.Context r7) {
        /*
            r2 = 0
            java.lang.String r0 = "android.intent.category.BROWSABLE"
            boolean r0 = r6.hasCategory(r0)
            if (r0 == 0) goto L16
            java.lang.String r0 = com.sec.chaton.chat.C1760hf.f6610f
            java.lang.String r1 = r6.getScheme()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L22
        L16:
            java.lang.String r0 = com.sec.chaton.chat.C1760hf.f6610f
            java.lang.String r1 = r6.getScheme()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L2b
        L22:
            com.sec.chaton.h.a r0 = com.sec.chaton.p062h.C2362h.m10319a(r6)
            com.sec.chaton.chat.hg r0 = r0.mo10310a()
        L2a:
            return r0
        L2b:
            java.lang.String r0 = "Shocrcut from contact"
            java.lang.Class<com.sec.chaton.bk> r1 = com.sec.chaton.C1071bk.class
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C4904y.m18641c(r0, r1)
            android.content.ContentResolver r0 = r7.getContentResolver()
            android.net.Uri r1 = r6.getData()
            r3 = r2
            r4 = r2
            r5 = r2
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L78
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L78
            java.lang.String r0 = "data1"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L90
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "chatType"
            com.sec.chaton.e.t r3 = com.sec.chaton.p057e.EnumC2300t.ONETOONE     // Catch: java.lang.Throwable -> L90
            int r3 = r3.m10210a()     // Catch: java.lang.Throwable -> L90
            r6.putExtra(r2, r3)     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "callChatList"
            r3 = 1
            r6.putExtra(r2, r3)     // Catch: java.lang.Throwable -> L90
            r2 = 0
            r3 = 0
            com.sec.chaton.chat.hg r0 = m8729a(r7, r6, r0, r2, r3)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L2a
        L74:
            r1.close()
            goto L2a
        L78:
            android.content.res.Resources r0 = r7.getResources()     // Catch: java.lang.Throwable -> L90
            r2 = 2131427880(0x7f0b0228, float:1.8477389E38)
            java.lang.String r0 = r0.getString(r2)     // Catch: java.lang.Throwable -> L90
            r2 = 0
            android.widget.Toast r0 = com.sec.widget.C5179v.m19811a(r7, r0, r2)     // Catch: java.lang.Throwable -> L90
            r0.show()     // Catch: java.lang.Throwable -> L90
            com.sec.chaton.chat.hg r0 = com.sec.chaton.chat.EnumC1761hg.HOME     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L2a
            goto L74
        L90:
            r0 = move-exception
            if (r1 == 0) goto L96
            r1.close()
        L96:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1760hf.m8743e(android.content.Intent, android.content.Context):com.sec.chaton.chat.hg");
    }

    /* renamed from: f */
    private static EnumC1761hg m8744f(Intent intent, Context context) throws Throwable {
        if (intent.getExtras() == null && !f6610f.equals(intent.getScheme())) {
            return EnumC1761hg.UNKNOWN;
        }
        if (!C4822an.m18218a() && intent.getExtras().containsKey(f6605a) && ((EnumC1094bm) intent.getExtras().get(f6605a)) == EnumC1094bm.API) {
            return EnumC1761hg.UNKNOWN;
        }
        EnumC1761hg enumC1761hg = EnumC1761hg.UNKNOWN;
        if (C4904y.f17873c) {
            C4904y.m18641c("ChatON specific data=" + intent.getData(), C1071bk.class.getSimpleName());
        }
        EnumC1761hg enumC1761hgMo10310a = C2362h.m10319a(intent).mo10310a();
        if (C4904y.f17873c) {
            C4904y.m18641c("Interlocked With " + intent.getExtras().toString() + " / Type : " + intent.getType(), C1071bk.class.getSimpleName());
        }
        String[] strArrM8741c = m8741c(intent);
        if (strArrM8741c != null) {
            if (C4809aa.m18104a().m18121a("uid", "").equals(strArrM8741c[0])) {
                C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
                return EnumC1761hg.HOME;
            }
            if (intent.getExtras().containsKey("android.intent.extra.TEXT") || intent.getExtras().containsKey("android.intent.extra.STREAM")) {
                C4904y.m18641c("If both receiver and content are given, proper access token is required.", C1071bk.class.getSimpleName());
                if (!AccessTokenProvider.m6135a(context, intent.getExtras())) {
                    C4904y.m18634a("Access token is incorrect.", C1071bk.class.getSimpleName());
                    return EnumC1761hg.HOME;
                }
            }
            intent.putExtra("callChatList", true);
            if (strArrM8741c.length > 1) {
                Bundle extras = intent.getExtras();
                EnumC1094bm enumC1094bm = EnumC1094bm.UKNOWN;
                if (extras != null && extras.containsKey(f6605a)) {
                    enumC1094bm = (EnumC1094bm) extras.get(f6605a);
                }
                if (enumC1094bm == EnumC1094bm.API) {
                    enumC1761hgMo10310a = m8737b(context, intent, strArrM8741c);
                } else {
                    enumC1761hgMo10310a = m8730a(context, intent, strArrM8741c);
                }
            } else {
                if (!intent.hasExtra("chatType")) {
                    intent.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                }
                enumC1761hgMo10310a = m8729a(context, intent, null, null, strArrM8741c);
            }
            if (enumC1761hgMo10310a == EnumC1761hg.HOME || enumC1761hgMo10310a == EnumC1761hg.UNKNOWN) {
                return enumC1761hgMo10310a;
            }
        } else if (intent.getExtras().containsKey("inboxNO")) {
            if (m8735a(null, new StringBuilder(intent.getStringExtra("inboxNO")), context, intent)) {
                intent.putExtra("callChatList", true);
                enumC1761hgMo10310a = EnumC1761hg.CHATROOM;
            } else {
                enumC1761hgMo10310a = EnumC1761hg.HOME;
            }
        }
        if (enumC1761hgMo10310a == EnumC1761hg.HOME) {
            C5179v.m19811a(context, context.getString(R.string.toast_supported_format), 0).show();
            return enumC1761hgMo10310a;
        }
        if (intent.getData() != null) {
            intent.putExtra(f6606b, intent.getData().getHost());
            return enumC1761hgMo10310a;
        }
        return enumC1761hgMo10310a;
    }

    /* renamed from: a */
    private static EnumC1761hg m8730a(Context context, Intent intent, String[] strArr) {
        String[] strArrM8736a = m8736a(context, strArr);
        if (!intent.hasExtra("chatType")) {
            intent.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
        }
        intent.putExtra("receivers", strArrM8736a);
        return EnumC1761hg.CHATROOM;
    }

    /* renamed from: b */
    private static EnumC1761hg m8737b(Context context, Intent intent, String[] strArr) {
        boolean z;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (!TextUtils.isEmpty(strArr[i])) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
            return EnumC1761hg.HOME;
        }
        if (!intent.hasExtra("chatType")) {
            intent.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
        }
        String strM9926a = C2198l.m9926a(EnumC2300t.GROUPCHAT, strArr);
        if (!TextUtils.isEmpty(strM9926a)) {
            intent.putExtra("inboxNO", strM9926a);
        }
        intent.putExtra("receivers", strArr);
        return EnumC1761hg.CHATROOM;
    }

    /* renamed from: c */
    private static String[] m8741c(Intent intent) {
        if (!intent.getExtras().containsKey(f6611g) && !intent.getExtras().containsKey("receivers")) {
            return null;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
        if (stringArrayExtra == null && intent.getExtras().containsKey(f6611g)) {
            return new String[]{intent.getStringExtra(f6611g)};
        }
        return stringArrayExtra;
    }

    /* renamed from: a */
    private static String[] m8736a(Context context, String[] strArr) {
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
            cursorQuery = context.getContentResolver().query(C2289i.f8196a, new String[]{"buddy_no"}, sb.toString(), null, null);
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
    private static EnumC1761hg m8729a(Context context, Intent intent, String str, String str2, String[] strArr) throws Throwable {
        String str3;
        boolean z;
        boolean zM9774c;
        boolean zM8735a;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            if (C4904y.f17875e) {
                C4904y.m18634a("checkIsBuddyAndIsInBox(), abnormal status !!!!", C1071bk.class.getSimpleName());
            }
            return EnumC1761hg.UNKNOWN;
        }
        if (str2 == null && ((strArr == null || strArr.length == 0) && str == null)) {
            C4904y.m18646e("ONEtoONE / fail to find", C1760hf.class.getSimpleName());
            return EnumC1761hg.UNKNOWN;
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
            C4904y.m18646e("ONEtoONE / fail to find.", C1760hf.class.getSimpleName());
            return EnumC1761hg.UNKNOWN;
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
            zM9774c = C2186al.m9774c(context.getContentResolver(), str2);
            intent.putExtra("specialbuddy", z);
        } else {
            zM9774c = false;
        }
        boolean zM8732a = !z ? m8732a(context, intent, str2) : zM9774c;
        if (extras.containsKey("fromPush")) {
            if (extras.containsKey("buddyNO")) {
                intent.putExtra("receivers", new String[]{extras.getString("buddyNO")});
                intent.removeExtra("buddyNO");
            }
            return EnumC1761hg.CHATROOM;
        }
        StringBuilder sb = new StringBuilder(str3 == null ? "" : str3);
        EnumC2300t enumC2300tM10207a = EnumC2300t.UNKNOWN;
        if (extras != null && extras.containsKey("chatType")) {
            enumC2300tM10207a = EnumC2300t.m10207a(extras.getInt("chatType", -1));
        }
        if (enumC2300tM10207a != EnumC2300t.BROADCAST) {
            EnumC2301u enumC2301u = EnumC2301u.NORMAL;
            if (extras.containsKey("roomType")) {
                intent.putExtra("roomType", EnumC2301u.m10211a(extras.getInt("roomType")).m10212a());
            }
            zM8735a = m8735a(str2, sb, context, intent);
        } else {
            zM8735a = false;
        }
        String string = sb.toString();
        if (z) {
            boolean zM8733a = zM8735a ? m8733a(context, sb) : false;
            if (!zM8732a && !zM8733a) {
                C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
                return EnumC1761hg.HOME;
            }
        } else {
            EnumC1094bm enumC1094bm = (EnumC1094bm) extras.get(f6605a);
            if (!zM8732a && !zM8735a && enumC1094bm != EnumC1094bm.API) {
                C5179v.m19811a(context, context.getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
                return EnumC1761hg.HOME;
            }
        }
        if (zM8732a) {
            intent.putExtra("receivers", new String[]{str2});
        }
        if (zM8735a) {
            intent.putExtra("inboxNO", string);
        } else if (intent.hasExtra("inboxNO")) {
            intent.removeExtra("inboxNO");
        }
        return EnumC1761hg.CHATROOM;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m8735a(java.lang.String r10, java.lang.StringBuilder r11, android.content.Context r12, android.content.Intent r13) throws java.lang.Throwable {
        /*
            r7 = 0
            r8 = 1
            r6 = 0
            java.lang.String r5 = r11.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L5b
            android.content.ContentResolver r0 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L53
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a     // Catch: java.lang.Throwable -> L53
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L53
            r3 = 0
            java.lang.String r4 = "inbox_no"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L53
            r3 = 1
            java.lang.String r4 = "inbox_room_type"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = "inbox_no = ?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L53
            r9 = 0
            r4[r9] = r5     // Catch: java.lang.Throwable -> L53
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto Lc0
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Lba
            if (r0 <= 0) goto Lc0
            r1.moveToFirst()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r0 = "inbox_room_type"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lba
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r2 = "roomType"
            r13.putExtra(r2, r0)     // Catch: java.lang.Throwable -> Lba
            r0 = r8
        L4d:
            if (r1 == 0) goto L52
            r1.close()
        L52:
            return r0
        L53:
            r0 = move-exception
            r1 = r7
        L55:
            if (r1 == 0) goto L5a
            r1.close()
        L5a:
            throw r0
        L5b:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto Lbe
            android.content.ContentResolver r0 = r12.getContentResolver()     // Catch: java.lang.Throwable -> Lb3
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a     // Catch: java.lang.Throwable -> Lb3
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lb3
            r3 = 0
            java.lang.String r4 = "inbox_no"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lb3
            r3 = 1
            java.lang.String r4 = "inbox_last_chat_type"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r3 = "inbox_no= ( SELECT inbox_no FROM inbox_buddy_relation WHERE buddy_no = ? )"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lb3
            r5 = 0
            r4[r5] = r10     // Catch: java.lang.Throwable -> Lb3
            r5 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb3
            if (r7 == 0) goto Lbc
            int r0 = r7.getCount()     // Catch: java.lang.Throwable -> Lb3
            if (r0 <= 0) goto Lbc
            r7.moveToFirst()     // Catch: java.lang.Throwable -> Lb3
            r0 = 0
            java.lang.String r0 = r7.getString(r0)     // Catch: java.lang.Throwable -> Lb3
            r1 = 0
            r11.setLength(r1)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r1 = "inbox_last_chat_type"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Lb3
            int r1 = r7.getInt(r1)     // Catch: java.lang.Throwable -> Lb3
            r2 = 12
            if (r1 != r2) goto Lae
            r0 = r6
        La8:
            if (r7 == 0) goto L52
            r7.close()
            goto L52
        Lae:
            r11.append(r0)     // Catch: java.lang.Throwable -> Lb3
            r0 = r8
            goto La8
        Lb3:
            r0 = move-exception
            if (r7 == 0) goto Lb9
            r7.close()
        Lb9:
            throw r0
        Lba:
            r0 = move-exception
            goto L55
        Lbc:
            r0 = r6
            goto La8
        Lbe:
            r0 = r6
            goto L52
        Lc0:
            r0 = r6
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1760hf.m8735a(java.lang.String, java.lang.StringBuilder, android.content.Context, android.content.Intent):boolean");
    }

    /* renamed from: a */
    public static boolean m8733a(Context context, StringBuilder sb) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(C2306z.f8229a, null, "message_inbox_no=?", new String[]{sb.toString()}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m8732a(android.content.Context r10, android.content.Intent r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            r6 = 0
            r8 = 1
            r7 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto Lcb
            android.content.ContentResolver r0 = r10.getContentResolver()     // Catch: java.lang.Throwable -> Lbe
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Throwable -> Lbe
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lbe
            r3 = 0
            java.lang.String r4 = "buddy_no"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lbe
            r3 = 1
            java.lang.String r4 = "buddy_show_phone_number"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lbe
            r3 = 2
            java.lang.String r4 = "buddy_extra_info"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lbe
            r3 = 3
            java.lang.String r4 = "buddy_msisdns"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r3 = "buddy_no=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lbe
            r5 = 0
            r4[r5] = r12     // Catch: java.lang.Throwable -> Lbe
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lbe
            if (r2 == 0) goto Lc8
            int r0 = r2.getCount()     // Catch: java.lang.Throwable -> Lc5
            if (r0 <= 0) goto Lc8
            r2.moveToFirst()     // Catch: java.lang.Throwable -> Lc5
            r0 = 1
            int r7 = r2.getInt(r0)     // Catch: java.lang.Throwable -> Lc5
            r0 = 2
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> Lc5
            r1 = 3
            java.lang.String r6 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lc5
            r1 = r7
            r7 = r8
            r9 = r6
            r6 = r0
            r0 = r9
        L57:
            if (r2 == 0) goto L5c
            r2.close()
        L5c:
            boolean r2 = com.sec.chaton.util.C4904y.f17872b
            if (r2 == 0) goto La5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "addExtrasToIntent"
            r2.append(r3)
            if (r12 == 0) goto L70
            r2.append(r12)
        L70:
            java.lang.String r3 = ", "
            java.lang.StringBuilder r3 = r2.append(r3)
            java.lang.String r4 = "extras="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = ", "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r4 = ", "
            r3.append(r4)
            if (r6 == 0) goto L98
            r2.append(r6)
        L98:
            java.lang.String r2 = r2.toString()
            java.lang.Class<com.sec.chaton.bk> r3 = com.sec.chaton.C1071bk.class
            java.lang.String r3 = r3.getSimpleName()
            com.sec.chaton.util.C4904y.m18639b(r2, r3)
        La5:
            java.lang.String r2 = "showPhoneNumber"
            r11.putExtra(r2, r1)
            java.lang.String r1 = "extraInfo"
            r11.putExtra(r1, r6)
            java.lang.String r1 = "msisdns"
            r11.putExtra(r1, r0)
            java.lang.String r0 = "is_buddy"
            r11.putExtra(r0, r7)
            return r7
        Lbe:
            r0 = move-exception
        Lbf:
            if (r6 == 0) goto Lc4
            r6.close()
        Lc4:
            throw r0
        Lc5:
            r0 = move-exception
            r6 = r2
            goto Lbf
        Lc8:
            r0 = r6
            r1 = r7
            goto L57
        Lcb:
            r0 = r6
            r1 = r7
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1760hf.m8732a(android.content.Context, android.content.Intent, java.lang.String):boolean");
    }
}
