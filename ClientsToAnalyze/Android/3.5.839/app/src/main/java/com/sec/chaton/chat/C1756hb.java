package com.sec.chaton.chat;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.p046a.C0867cu;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ForwardMessageHandler.java */
/* renamed from: com.sec.chaton.chat.hb */
/* loaded from: classes.dex */
public class C1756hb {

    /* renamed from: a */
    private static HashMap<String, ArrayList<C0864cr>> f6585a;

    /* renamed from: b */
    private static C1756hb f6586b;

    /* renamed from: c */
    private boolean f6587c = true;

    /* renamed from: a */
    public static synchronized C1756hb m8715a() {
        if (f6586b == null) {
            f6586b = new C1756hb();
        }
        return f6586b;
    }

    private C1756hb() {
        f6585a = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0012  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.chat.C1758hd m8716a(boolean r25, com.sec.chaton.p046a.C0864cr r26, java.lang.String r27, java.lang.String r28, com.sec.chaton.p057e.EnumC2300t r29, java.util.ArrayList<com.sec.chaton.p046a.C0864cr> r30, java.util.ArrayList<com.sec.chaton.p046a.C0864cr> r31, java.util.List<com.sec.chaton.p046a.C0867cu> r32, java.util.ArrayList<com.sec.chaton.chat.C1739gl> r33, java.util.ArrayList<java.lang.Long> r34) {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1756hb.m8716a(boolean, com.sec.chaton.a.cr, java.lang.String, java.lang.String, com.sec.chaton.e.t, java.util.ArrayList, java.util.ArrayList, java.util.List, java.util.ArrayList, java.util.ArrayList):com.sec.chaton.chat.hd");
    }

    /* renamed from: a */
    public void m8719a(String str, EnumC2300t enumC2300t, String str2, C0864cr c0864cr) {
        KeyguardManager keyguardManager = (KeyguardManager) CommonApplication.m18732r().getSystemService("keyguard");
        C2201o c2201oM9951e = C2198l.m9951e(GlobalApplication.m18732r().getContentResolver(), str);
        if (c2201oM9951e == null) {
            C4904y.m18634a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return;
        }
        String strM9695f = C2176ab.m9695f(GlobalApplication.m18732r().getContentResolver(), c0864cr.m4150d());
        if ((!C1813b.m8906b().m8931a(str) || keyguardManager.inKeyguardRestrictedInputMode()) && !c0864cr.m4150d().equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            EnumC2214ab enumC2214abM10020a = C2204r.m10020a(c0864cr.m4156j(), c0864cr.m4160n().getNumber());
            String strM4156j = c0864cr.m4156j();
            EnumC2301u enumC2301u = EnumC2301u.NORMAL;
            if (c0864cr.m4150d().startsWith("0999")) {
                enumC2301u = EnumC2301u.LIVE;
            }
            if (C2349a.m10301a("active_connection_feature") && c2201oM9951e.f7855r) {
                c2201oM9951e.f7855r = this.f6587c;
            }
            C1813b.m8906b().m8926a(c0864cr.m4150d(), strM4156j, str, c0864cr.m4154h(), enumC2214abM10020a, enumC2300t.m10210a(), str2, strM9695f, c2201oM9951e.f7855r, c0864cr.m4158l(), c2201oM9951e.f7852o, c2201oM9951e.f7853p, c2201oM9951e.f7845h, c2201oM9951e.f7856s, "N", enumC2301u);
        }
    }

    /* renamed from: a */
    public void m8718a(String str, int i, C0864cr c0864cr, C2201o c2201o) {
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        if (c0864cr != null) {
            String strM9695f = C2176ab.m9695f(contentResolver, c0864cr.m4150d());
            if (c0864cr.m4158l() >= c2201o.f7844g) {
                StringBuilder sb = new StringBuilder();
                if (c0864cr.m4150d().equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                    sb.append(1).append(Config.KEYVALUE_SPLIT);
                } else {
                    sb.append(2).append(Config.KEYVALUE_SPLIT);
                }
                sb.append(C2204r.m10020a(c0864cr.m4156j(), c0864cr.m4160n().getNumber()).m10076a()).append(Config.KEYVALUE_SPLIT);
                String strM8632a = C1736gi.m8632a(c0864cr.m4156j());
                C4904y.m18639b("onPreExecute - (lastmsg) last msg sender : " + c0864cr.m4150d().toString(), getClass().getSimpleName());
                if (c0864cr.m4150d().startsWith("0999")) {
                    try {
                        sb.append(new JSONObject(strM8632a).getString("push_message")).append(Config.KEYVALUE_SPLIT);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    sb.append(strM8632a).append(Config.KEYVALUE_SPLIT);
                }
                sb.append(C1736gi.m8632a(strM9695f));
                c2201o.f7842e = sb.toString();
                c2201o.f7847j = c0864cr.m4154h();
                c2201o.f7848k = c0864cr.m4150d();
                c2201o.f7844g = c0864cr.m4158l();
            }
        }
        if (C1813b.m8906b().m8931a(str)) {
            i = 0;
        }
        C2198l.m9908a(contentResolver, str, c2201o, i);
    }

    /* renamed from: a */
    public void m8724a(boolean z, List<C0867cu> list, EnumC2300t enumC2300t, String str, String str2) {
        if (!z && !C1813b.m8906b().m8931a(str2)) {
            C4904y.m18639b("requestReadMessage - isForce(" + z + "), isFrontInbox(" + C1813b.m8906b().m8931a(str2) + ")", "ForwardMessageHandler");
            return;
        }
        C2142w c2142wM9593a = C2142w.m9593a(str2, enumC2300t);
        if (c2142wM9593a != null) {
            c2142wM9593a.m9630a(list, enumC2300t, str);
        } else {
            C4904y.m18639b("ForwardMessageHandler - updateInbox() : message control is null", "ForwardMessageHandler");
        }
    }

    /* renamed from: a */
    public void m8723a(boolean z, ArrayList<C0864cr> arrayList, String str) {
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        m8715a().m8720a(str, arrayList);
        if (!z) {
            C4904y.m18639b("processNotiTypeMessage() break : isFirstMsgOfFullMsg(" + z + ")", "ForwardMessageHandler");
            return;
        }
        Iterator<C0864cr> it = m8715a().m8717a(str).iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            C0864cr next = it.next();
            String[] strArrSplit = next.m4156j().split("\n");
            StringBuilder sb = new StringBuilder();
            boolean z3 = z2;
            for (String str2 : strArrSplit) {
                String[] strArrM8650b = C1736gi.m8650b(str2, ",", 3);
                if (strArrM8650b.length > 2) {
                    if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.SESSION_TITLE_UPDATED) {
                        String str3 = strArrM8650b[1];
                        C2198l.m9936b(contentResolver, str, strArrM8650b[2]);
                    } else {
                        String str4 = strArrM8650b[1];
                        String strM9685b = C2176ab.m9685b(contentResolver, str4, strArrM8650b[2]);
                        boolean zM9681a = C2176ab.m9681a(contentResolver, str4, str);
                        EnumC2231as enumC2231as = EnumC2231as.UNKNOWN;
                        if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.ENTER) {
                            if (!zM9681a) {
                                if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(str4)) {
                                    C2176ab.m9676a(contentResolver, str, str4, strM9685b);
                                }
                                if (C4809aa.m18104a().m18121a("chaton_id", "").equals(next.m4150d())) {
                                    enumC2231as = EnumC2231as.INVITE;
                                } else {
                                    enumC2231as = EnumC2231as.ENTER;
                                    z3 = true;
                                }
                            }
                        } else if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.LEAVE && zM9681a) {
                            C2176ab.m9692d(contentResolver, str, str4);
                            enumC2231as = EnumC2231as.LEAVE;
                            z3 = true;
                        }
                        if (enumC2231as != EnumC2231as.UNKNOWN) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC2231as.m10100a()), str4, C1736gi.m8632a(strM9685b))).append(Config.KEYVALUE_SPLIT);
                        }
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                C2204r.m10013a(contentResolver, str, string, next.m4158l(), Long.toString(next.m4154h()), C2176ab.m9697g(contentResolver, next.m4150d()));
            }
            z2 = z3;
        }
        if (z2 && m8715a().m8717a(str).size() > 0) {
            C2198l.m9957j(contentResolver, str);
        }
        m8715a().m8725b(str);
    }

    /* renamed from: a */
    public void m8721a(ArrayList<C0864cr> arrayList) {
        Iterator<C0864cr> it = arrayList.iterator();
        while (it.hasNext()) {
            C0864cr next = it.next();
            C2204r.m10029a(next.m4154h(), next.m4150d());
        }
    }

    /* renamed from: a */
    public void m8722a(boolean z) {
        this.f6587c = z;
    }

    /* renamed from: a */
    public void m8720a(String str, ArrayList<C0864cr> arrayList) {
        if (f6585a.containsKey(str)) {
            arrayList.addAll(f6585a.get(str));
        }
        f6585a.put(str, arrayList);
        Iterator<C0864cr> it = arrayList.iterator();
        while (it.hasNext()) {
            for (String str2 : it.next().m4156j().split("\n")) {
                String[] strArrM8650b = C1736gi.m8650b(str2, ",", 3);
                if (strArrM8650b.length > 2) {
                    C4904y.m18641c("Insert noti msg, status: " + strArrM8650b[0] + ", number: " + strArrM8650b[1] + ", name: " + strArrM8650b[2], "ForwardMessageHandler");
                }
            }
        }
    }

    /* renamed from: a */
    public ArrayList<C0864cr> m8717a(String str) {
        return f6585a.get(str);
    }

    /* renamed from: b */
    public void m8725b(String str) {
        f6585a.get(str).clear();
    }
}
