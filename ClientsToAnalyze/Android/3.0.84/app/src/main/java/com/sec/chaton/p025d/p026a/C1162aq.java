package com.sec.chaton.p025d.p026a;

import android.app.KeyguardManager;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.sec.chaton.chat.C1072en;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1077es;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C1821k;
import com.sec.chaton.p016a.C0307bd;
import com.sec.chaton.p016a.C0310bg;
import com.sec.chaton.p016a.C0311bh;
import com.sec.chaton.p016a.C0312bi;
import com.sec.chaton.p016a.C0333cc;
import com.sec.chaton.p016a.p017a.C0266c;
import com.sec.chaton.p016a.p017a.EnumC0275l;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1444l;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1372p;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p033i.p034a.C1534c;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings.downloads.EnumC2651z;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.d.a.aq */
/* loaded from: classes.dex */
public class C1162aq extends AbstractC1199c {

    /* renamed from: h */
    public static final String f4605h = C1162aq.class.getSimpleName();

    /* renamed from: i */
    C0333cc f4606i;

    /* renamed from: j */
    ArrayList<C0333cc> f4607j;

    /* renamed from: k */
    private String f4608k;

    /* renamed from: l */
    private C0307bd f4609l;

    /* renamed from: m */
    private ContentResolver f4610m;

    /* renamed from: n */
    private C1077es f4611n;

    /* renamed from: o */
    private int f4612o;

    /* renamed from: p */
    private ArrayList<String> f4613p;

    /* renamed from: q */
    private boolean f4614q;

    public C1162aq(Handler handler, String str, C0307bd c0307bd, C1337o c1337o) {
        super(handler);
        this.f4612o = 0;
        this.f4614q = false;
        this.f4608k = str;
        this.f4609l = c0307bd;
        this.f4610m = CommonApplication.m11493l().getContentResolver();
        this.f4703g = c1337o;
        this.f4612o = 0;
        this.f4613p = new ArrayList<>();
        this.f4606i = null;
        this.f4607j = new ArrayList<>();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() throws Throwable {
        boolean z;
        C0333cc c0333cc;
        int i;
        String str;
        boolean z2;
        boolean z3;
        int i2;
        String strM5906o = this.f4608k;
        if (this.f4703g.m5904m()) {
            strM5906o = this.f4703g.m5906o();
        }
        this.f4611n = C1077es.m5329b(strM5906o);
        EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(this.f4609l.m1728f().getNumber());
        C1072en.m5300a(this.f4608k, this.f4609l, getClass().getSimpleName());
        C1372p c1372pM6140d = C1370n.m6140d(this.f4610m, strM5906o);
        if (c1372pM6140d == null) {
            C3250y.m11442a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return null;
        }
        C0311bh c0311bhM1803b = C0310bg.newBuilder().m1800a(C3159aa.m10962a().m10979a("uid", "")).m1803b(100);
        if (!TextUtils.isEmpty(this.f4609l.m1736n())) {
            c0311bhM1803b.m1805b(this.f4609l.m1736n());
            this.f4614q = true;
        }
        C1534c c1534c = new C1534c();
        c1534c.m11829d(String.format("%04d%s", 6, "0001"));
        StringBuilder sb = new StringBuilder();
        ArrayList<C0312bi> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C0333cc c0333cc2 : this.f4609l.m1729g()) {
            arrayList2.add(c0333cc2);
            sb.append(c0333cc2.m2047h()).append(", ");
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        c1534c.m6525a(sb.toString());
        Log.wtf("CH", c1534c.toString());
        Collections.sort(arrayList2, new C1163ar(this));
        ArrayList<C0333cc> arrayList3 = new ArrayList<>();
        int i3 = 0;
        C0333cc c0333cc3 = null;
        HashMap map = new HashMap();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C0333cc c0333cc4 = (C0333cc) it.next();
            switch (c0333cc4.m2053n().getNumber()) {
                case 0:
                case 1:
                case 4:
                    EnumC1455w enumC1455wM6174a = C1373q.m6174a(c0333cc4.m2049j(), c0333cc4.m2053n().getNumber());
                    String[] strArrSplit = c0333cc4.m2049j().split("\n");
                    if (enumC1455wM6174a.m6365b() && strArrSplit.length < 5) {
                        if (C3250y.f11734b) {
                            c0333cc4.m2049j();
                            long jM2047h = c0333cc4.m2047h();
                            C3250y.m11450b("[throw away message] this one is not valid to process and show", f4605h);
                            C3250y.m11450b(" message id : " + jM2047h, f4605h);
                            c0333cc = c0333cc3;
                            i = i3;
                        }
                    } else {
                        if (enumC1455wM6174a == EnumC1455w.ANICON) {
                            String strM9664c = C2646u.m9664c(strArrSplit[2]);
                            if (!TextUtils.isEmpty(strM9664c)) {
                                EnumC2651z enumC2651zM9673i = C2646u.m9673i(GlobalApplication.m11493l(), strM9664c);
                                if (C1103a.m5432a(GlobalApplication.m11493l()).m5458a(strM5906o)) {
                                    if (enumC2651zM9673i != EnumC2651z.NORMAL) {
                                        C1821k.m7478a().m7482a(strM9664c);
                                    } else {
                                        C2646u.f9891a.put(strM9664c, true);
                                    }
                                } else {
                                    C2646u.f9891a.clear();
                                    C2646u.f9891a.put(strM9664c, true);
                                }
                            }
                        }
                        C0333cc c0333cc5 = c0333cc3 == null ? c0333cc4 : c0333cc3;
                        if ((enumC1455wM6174a == EnumC1455w.CONTACT || enumC1455wM6174a == EnumC1455w.CALENDAR || enumC1455wM6174a == EnumC1455w.DOCUMENT || enumC1455wM6174a == EnumC1455w.FILE) && strArrSplit.length >= 6) {
                            str = strArrSplit[5];
                        } else {
                            str = null;
                        }
                        if (enumC1455wM6174a == EnumC1455w.IMAGE && C2646u.m9661b(c0333cc4.m2049j())) {
                            enumC1455wM6174a = EnumC1455w.ANICON;
                        }
                        String strM6227h = C1381y.m6227h(this.f4610m, c0333cc4.m2043d());
                        String strM6150n = C1370n.m6150n(GlobalApplication.m11493l().getContentResolver(), this.f4608k);
                        String strM6151o = C1370n.m6151o(GlobalApplication.m11493l().getContentResolver(), this.f4608k);
                        if (!C1370n.m6149m(GlobalApplication.m11493l().getContentResolver(), this.f4608k)) {
                            strM6150n = null;
                            strM6151o = null;
                        }
                        EnumC1444l enumC1444lM6171a = C1373q.m6171a(this.f4610m, this.f4609l.m1726d(), enumC1455wM6174a, c0333cc4, strM5906o, strM6227h, str, enumC1450rM6339a, strM6151o, strM6150n, null);
                        if (enumC1444lM6171a == EnumC1444l.INSERT) {
                            z2 = true;
                            this.f4612o++;
                            this.f4613p.add(strM6227h);
                            z3 = false;
                        } else if (enumC1444lM6171a != EnumC1444l.UPDATE) {
                            z2 = false;
                            z3 = false;
                        } else {
                            z3 = true;
                            z2 = false;
                        }
                        if (enumC1455wM6174a != EnumC1455w.TEXT && (enumC1455wM6174a == EnumC1455w.IMAGE || enumC1455wM6174a == EnumC1455w.AMS || enumC1455wM6174a == EnumC1455w.AUDIO)) {
                            if ((z2 || z3) && strArrSplit.length >= 5) {
                                String str2 = strArrSplit[2];
                                String str3 = strArrSplit[3];
                                long jM2047h2 = c0333cc4.m2047h();
                                Handler handler = new Handler(Looper.getMainLooper());
                                handler.post(new RunnableC1164as(this, enumC1455wM6174a, jM2047h2, handler, c0333cc4.m2049j(), strM5906o, enumC1450rM6339a, strM6227h, str2, str3));
                            } else if (strArrSplit.length >= 4) {
                                C3250y.m11450b("No need to update and insert: " + strArrSplit[3], getClass().getName());
                            } else {
                                C3250y.m11442a("Token Error", getClass().getName());
                            }
                        }
                        if (C1103a.m5432a(GlobalApplication.m11493l()).m5458a(strM5906o)) {
                            arrayList.add(C0312bi.newBuilder().m1839a(c0333cc4.m2047h()).m1843a(c0333cc4.m2043d()).m1842a(c0333cc4.m2053n()).m1845b(C3159aa.m10962a().m10979a("chaton_id", "")).build());
                            i2 = i3;
                        } else {
                            this.f4611n.m5331a(c0333cc4);
                            i2 = (!z2 || C3159aa.m10962a().m10979a("chaton_id", "").equals(strM6227h)) ? i3 : i3 + 1;
                        }
                        if (z2 || (z3 && C1103a.m5432a(CommonApplication.m11493l()).m5457a(Long.valueOf(c0333cc4.m2047h())))) {
                            m5510a(z2, strM5906o, enumC1450rM6339a, c0333cc4);
                        }
                        if (z2 || z3) {
                            this.f4606i = c0333cc4;
                        }
                        if (C1370n.m6149m(GlobalApplication.m11493l().getContentResolver(), this.f4608k)) {
                            C0952c.m5143c().m5147a(Long.valueOf(c0333cc4.m2047h()), c0333cc4.m2049j(), false, null, null, this.f4608k, !C3159aa.m10962a().m10979a("chaton_id", "").equals(strM6227h));
                            C3250y.m11450b("enable translate, inboxNo : " + this.f4608k, f4605h);
                            c0333cc = c0333cc5;
                            i = i2;
                        } else {
                            c0333cc = c0333cc5;
                            i = i2;
                        }
                    }
                    i3 = i;
                    c0333cc3 = c0333cc;
                    break;
                case 2:
                    arrayList3.add(c0333cc4);
                    arrayList.add(C0312bi.newBuilder().m1839a(c0333cc4.m2047h()).m1843a(c0333cc4.m2043d()).m1842a(c0333cc4.m2053n()).m1845b(C3159aa.m10962a().m10979a("chaton_id", "")).build());
                    c0333cc = c0333cc3;
                    i = i3;
                    continue;
                    i3 = i;
                    c0333cc3 = c0333cc;
                case 3:
                    Long lValueOf = Long.valueOf(c0333cc4.m2047h());
                    String strM2040a = c0333cc4.m2040a(0);
                    if (!TextUtils.isEmpty(strM2040a) && !strM2040a.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                        map.put(lValueOf, Integer.valueOf(map.containsKey(lValueOf) ? ((Integer) map.get(lValueOf)).intValue() + 1 : 1));
                    }
                    arrayList.add(C0312bi.newBuilder().m1839a(c0333cc4.m2047h()).m1843a(c0333cc4.m2043d()).m1842a(c0333cc4.m2053n()).m1845b(c0333cc4.m2040a(0)).build());
                    break;
            }
            c0333cc = c0333cc3;
            i = i3;
            i3 = i;
            c0333cc3 = c0333cc;
        }
        ArrayList<ContentProviderOperation> arrayList4 = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            try {
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1454v.m6343a());
                builderNewUpdate.withValue("message_sever_id", entry.getKey()).withValue("count", entry.getValue());
                arrayList4.add(builderNewUpdate.build());
            } catch (Throwable th) {
                arrayList4.clear();
                throw th;
            }
        }
        try {
            if (arrayList4.size() > 0) {
                this.f4610m.applyBatch("com.sec.chaton.provider", arrayList4);
            }
        } catch (Exception e) {
            C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
        }
        arrayList4.clear();
        if (!this.f4614q && c0333cc3 != null) {
            boolean z4 = false;
            if (!C1370n.m6142f(this.f4610m, strM5906o)) {
                ArrayList<ContentProviderOperation> arrayList5 = new ArrayList<>();
                String strM6227h2 = C1381y.m6227h(this.f4610m, c0333cc3.m2043d());
                if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(strM6227h2) && !C1381y.m6211a(this.f4610m, strM6227h2, strM5906o)) {
                    C3250y.m11456e("Insert Participants(sender) : " + strM6227h2, getClass().getSimpleName());
                    arrayList5.add(C1381y.m6206a(strM5906o, strM6227h2));
                    z4 = true;
                }
                if (enumC1450rM6339a != EnumC1450r.ONETOONE || C3159aa.m10962a().m10979a("chaton_id", "").equals(strM6227h2)) {
                    int iM2045f = c0333cc3.m2045f();
                    for (int i4 = 0; i4 < iM2045f; i4++) {
                        String strM6227h3 = C1381y.m6227h(this.f4610m, c0333cc3.m2040a(i4));
                        if (!strM6227h3.equals(C3159aa.m10962a().m10979a("chaton_id", "")) && !strM6227h3.equals(C3159aa.m10962a().m10979a("old_chaton_id", ""))) {
                            C3250y.m11456e("Insert Participants(receiver) : " + strM6227h3, getClass().getSimpleName());
                            arrayList5.add(C1381y.m6206a(strM5906o, strM6227h3));
                            z4 = true;
                        }
                    }
                    z = z4;
                } else {
                    z = z4;
                }
                try {
                    if (arrayList5.size() > 0) {
                        this.f4610m.applyBatch("com.sec.chaton.provider", arrayList5);
                    }
                } catch (Exception e2) {
                    C3250y.m11442a(e2.getMessage(), getClass().getSimpleName());
                }
                C1370n.m6137c(this.f4610m, strM5906o, 11);
                c1372pM6140d.f5134m = 11;
                z4 = z;
            }
            if (z4) {
                C1335m.m5784a((Handler) null, strM5906o, this.f4609l.m1726d(), 0L);
            }
        }
        if (this.f4606i != null) {
            String strM6222f = C1381y.m6222f(this.f4610m, this.f4606i.m2043d());
            if (this.f4606i.m2051l() >= c1372pM6140d.f5128g) {
                StringBuilder sb2 = new StringBuilder();
                if (this.f4606i.m2043d().equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                    sb2.append(1).append(Config.KEYVALUE_SPLIT);
                } else {
                    sb2.append(2).append(Config.KEYVALUE_SPLIT);
                }
                sb2.append(C1373q.m6174a(this.f4606i.m2049j(), this.f4606i.m2053n().getNumber()).m6364a()).append(Config.KEYVALUE_SPLIT);
                String strM5318a = C1075eq.m5318a(this.f4606i.m2049j());
                C3250y.m11450b("onPreExecute - (lastmsg) last msg sender : " + this.f4606i.m2043d().toString(), getClass().getSimpleName());
                if (this.f4606i.m2043d().startsWith("0999")) {
                    try {
                        sb2.append(new JSONObject(strM5318a).getString("push_message")).append(Config.KEYVALUE_SPLIT);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    sb2.append(strM5318a).append(Config.KEYVALUE_SPLIT);
                }
                sb2.append(C1075eq.m5318a(strM6222f));
                c1372pM6140d.f5126e = sb2.toString();
                c1372pM6140d.f5131j = this.f4606i.m2047h();
                c1372pM6140d.f5132k = this.f4606i.m2043d();
                c1372pM6140d.f5128g = this.f4606i.m2051l();
            }
            m5509a(arrayList3, strM5906o);
            if (C1103a.m5432a(GlobalApplication.m11493l()).m5458a(strM5906o)) {
                i3 = 0;
            }
            C1370n.m6105a(this.f4610m, strM5906o, c1372pM6140d, i3);
        } else {
            m5509a(arrayList3, strM5906o);
            C1370n.m6132b(this.f4610m, strM5906o, c1372pM6140d);
        }
        C1534c c1534c2 = new C1534c();
        c1534c2.m11829d(String.format("%04d%s", 7, "0001"));
        StringBuilder sb3 = new StringBuilder();
        for (C0312bi c0312bi : arrayList) {
            c0311bhM1803b.m1798a(c0312bi);
            sb3.append(c0312bi.m1830h()).append(", ");
        }
        if (sb3.length() > 2) {
            sb3.setLength(sb3.length() - 2);
        }
        c1534c2.m6525a(sb3.toString());
        Log.wtf("CH", c1534c2.toString());
        if (C3250y.f11735c) {
            StringBuilder sb4 = new StringBuilder();
            for (int i5 = 0; i5 < c0311bhM1803b.m1809f().size(); i5++) {
                sb4.append("[" + i5 + "] Receiver : " + c0311bhM1803b.m1801a(i5).m1828f()).append(", MsgType : " + c0311bhM1803b.m1801a(i5).m1832j()).append(", MsgID : " + c0311bhM1803b.m1801a(i5).m1830h()).append(", Sender : " + c0311bhM1803b.m1801a(i5).m1826d());
            }
            C3250y.m11453c("[DeliveryChatReply]InboxNO : " + strM5906o + ", UID : " + C3159aa.m10962a().m10979a("uid", "") + ", DeliveryChatReplyItemsCount: " + c0311bhM1803b.m1810g() + ", NextPaginationKey: " + c0311bhM1803b.m1813j() + sb4.toString(), getClass().getSimpleName());
        }
        C1596x.m6751a(this.f4699c, new C1549ah().m6579a(7).m6581a(c0311bhM1803b.build()).m6584b());
        if (this.f4703g.m5904m()) {
            new Handler().postDelayed(new RunnableC1165at(this), 2000L);
        }
        return null;
    }

    /* renamed from: a */
    private void m5510a(boolean z, String str, EnumC1450r enumC1450r, C0333cc c0333cc) throws Throwable {
        KeyguardManager keyguardManager = (KeyguardManager) CommonApplication.m11493l().getSystemService("keyguard");
        C1372p c1372pM6140d = C1370n.m6140d(this.f4610m, str);
        if (c1372pM6140d == null) {
            C3250y.m11442a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return;
        }
        String strM6222f = C1381y.m6222f(this.f4610m, c0333cc.m2043d());
        if (this.f4703g.m5905n()) {
            return;
        }
        if ((!C1103a.m5432a(GlobalApplication.m11493l()).m5458a(str) || keyguardManager.inKeyguardRestrictedInputMode()) && !c0333cc.m2043d().equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            EnumC1455w enumC1455wM6174a = C1373q.m6174a(c0333cc.m2049j(), c0333cc.m2053n().getNumber());
            String strM2049j = c0333cc.m2049j();
            if (enumC1455wM6174a == EnumC1455w.POLL) {
                try {
                    strM2049j = new JSONObject(strM2049j).getJSONObject("push_message").toString();
                } catch (JSONException e) {
                    C3250y.m11443a(e, getClass().getSimpleName());
                }
            }
            C1103a.m5432a(CommonApplication.m11493l()).m5455a(c0333cc.m2043d(), strM2049j, str, c0333cc.m2047h(), enumC1455wM6174a, enumC1450r.m6342a(), this.f4609l.m1726d(), strM6222f, c1372pM6140d.f5139r, c0333cc.m2051l(), c1372pM6140d.f5136o, c1372pM6140d.f5137p, c1372pM6140d.f5129h, c1372pM6140d.f5140s, "N");
        }
    }

    /* renamed from: a */
    private void m5509a(ArrayList<C0333cc> arrayList, String str) {
        this.f4611n.m5332a(arrayList);
        if (!this.f4614q) {
            Iterator<C0333cc> it = this.f4611n.m5335d().iterator();
            while (it.hasNext()) {
                C0333cc next = it.next();
                String[] strArrSplit = next.m2049j().split("\n");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    String[] strArrM5325b = C1075eq.m5325b(str2, ",", 3);
                    if (strArrM5325b.length > 2) {
                        String str3 = strArrM5325b[1];
                        String strM6215b = C1381y.m6215b(this.f4610m, str3, strArrM5325b[2]);
                        boolean zM6211a = C1381y.m6211a(this.f4610m, str3, str);
                        EnumC1391ai enumC1391ai = EnumC1391ai.UNKNOWN;
                        if (EnumC1391ai.m6247a(strArrM5325b[0]) == EnumC1391ai.ENTER) {
                            if (!zM6211a) {
                                C1381y.m6210a(this.f4610m, str, str3, strM6215b);
                                enumC1391ai = C3159aa.m10962a().m10979a("chaton_id", "").equals(next.m2043d()) ? EnumC1391ai.INVITE : EnumC1391ai.ENTER;
                            }
                        } else if (EnumC1391ai.m6247a(strArrM5325b[0]) == EnumC1391ai.LEAVE && zM6211a) {
                            C1381y.m6219d(this.f4610m, str, str3);
                            enumC1391ai = EnumC1391ai.LEAVE;
                        }
                        if (enumC1391ai != EnumC1391ai.UNKNOWN) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC1391ai.m6248a()), str3, C1075eq.m5318a(strM6215b))).append(Config.KEYVALUE_SPLIT);
                        }
                    }
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    C1373q.m6167a(this.f4610m, str, string, next.m2051l(), Long.toString(next.m2047h()), C1381y.m6227h(this.f4610m, next.m2043d()));
                }
            }
            if (this.f4611n.m5335d().size() > 0) {
                C1370n.m6143g(this.f4610m, str);
            }
            this.f4611n.m5336e();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C0310bg c0310bg = (C0310bg) ((C1548ag) obj2).m6575c();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < c0310bg.m1776e().size(); i2++) {
                sb.append("[" + i2 + "] MsgID : " + c0310bg.m1772a(i2).m1830h()).append(", MsgType : " + c0310bg.m1772a(i2).m1832j()).append(", Receiver : " + c0310bg.m1772a(i2).m1828f()).append(", Sender : " + c0310bg.m1772a(i2).m1826d());
            }
            C3250y.m11453c("[DeliveryChatReply]InboxNO : " + this.f4608k + ", UID : " + C3159aa.m10962a().m10979a("uid", "") + ", DeliveryChatReplyItemsCount : " + c0310bg.m1777f() + ", ResultCode : " + c0310bg.m1779h().m2494d() + ", ResultMsg : " + c0310bg.m1779h().m2496f() + ", DeliveryChatReplyItemsCount :" + c0310bg.m1777f() + sb.toString(), getClass().getSimpleName());
        } else {
            C3250y.m11453c(Config.EXTRA_ERROR, getClass().getSimpleName());
        }
        Message message = new Message();
        message.what = 6;
        C0266c c0266cM1343a = new C0266c().m1344a(true).m1342a(this.f4609l.m1726d()).m1340a(EnumC0275l.SUCCESS).m1339a(this.f4612o).m1347c(this.f4606i == null ? null : this.f4606i.m2049j()).m1345b(this.f4606i == null ? null : C1381y.m6227h(CommonApplication.m11493l().getContentResolver(), this.f4606i.m2043d())).m1341a(this.f4606i != null ? C1373q.m6174a(this.f4606i.m2049j(), this.f4606i.m2053n().getNumber()) : null).m1343a(this.f4613p);
        if (this.f4609l.m1733k()) {
            c0266cM1343a.m1346b(this.f4609l.m1734l());
        } else {
            c0266cM1343a.m1346b(false);
        }
        message.obj = c0266cM1343a.m1338a();
        this.f4698b.sendMessage(message);
    }
}
