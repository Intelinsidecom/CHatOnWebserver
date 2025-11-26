package com.sec.chaton.p055d.p056a;

import android.app.KeyguardManager;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1742go;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C2780l;
import com.sec.chaton.p046a.C0826bg;
import com.sec.chaton.p046a.C0829bj;
import com.sec.chaton.p046a.C0830bk;
import com.sec.chaton.p046a.C0831bl;
import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.p046a.p047a.C0783g;
import com.sec.chaton.p046a.p047a.EnumC0791o;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2292l;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p063i.p064a.C2405b;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.EnumC3465i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.io.IOException;
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
public class C1917aq extends AbstractC1927b {

    /* renamed from: h */
    public static final String f7145h = C1917aq.class.getSimpleName();

    /* renamed from: i */
    C0864cr f7146i;

    /* renamed from: j */
    ArrayList<C0864cr> f7147j;

    /* renamed from: k */
    private String f7148k;

    /* renamed from: l */
    private C0826bg f7149l;

    /* renamed from: m */
    private ContentResolver f7150m;

    /* renamed from: n */
    private C1742go f7151n;

    /* renamed from: o */
    private int f7152o;

    /* renamed from: p */
    private ArrayList<String> f7153p;

    /* renamed from: q */
    private boolean f7154q;

    public C1917aq(Handler handler, String str, C0826bg c0826bg, C2142w c2142w) {
        super(handler);
        this.f7152o = 0;
        this.f7154q = false;
        this.f7148k = str;
        this.f7149l = c0826bg;
        this.f7150m = CommonApplication.m18732r().getContentResolver();
        this.f7191g = c2142w;
        this.f7152o = 0;
        this.f7153p = new ArrayList<>();
        this.f7146i = null;
        this.f7147j = new ArrayList<>();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() throws IllegalStateException, JSONException, IOException, SecurityException, RemoteException, IllegalArgumentException, OperationApplicationException {
        boolean z;
        C0864cr c0864cr;
        int i;
        String str;
        boolean z2;
        boolean z3;
        int i2;
        String strM9657p = this.f7148k;
        if (this.f7191g.m9654m()) {
            strM9657p = this.f7191g.m9657p();
        }
        this.f7151n = C1742go.m8667b(strM9657p);
        EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(this.f7149l.m3601f().getNumber());
        C1734gg.m8592a(this.f7148k, this.f7149l, getClass().getSimpleName());
        C2201o c2201oM9951e = C2198l.m9951e(this.f7150m, strM9657p);
        if (c2201oM9951e == null) {
            C4904y.m18634a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return null;
        }
        C0830bk c0830bkM3679b = C0829bj.newBuilder().m3676a(C4809aa.m18104a().m18121a("uid", "")).m3679b(100);
        if (!TextUtils.isEmpty(this.f7149l.m3609n())) {
            c0830bkM3679b.m3681b(this.f7149l.m3609n());
            this.f7154q = true;
        }
        C2405b c2405b = new C2405b();
        c2405b.m19139c(String.format("%04d%s", 6, "0001"));
        StringBuilder sb = new StringBuilder();
        ArrayList<C0831bl> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C0864cr c0864cr2 : this.f7149l.m3602g()) {
            arrayList2.add(c0864cr2);
            sb.append(c0864cr2.m4154h()).append(", ");
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        c2405b.m10432a(sb.toString());
        Log.wtf("CH", c2405b.toString());
        Collections.sort(arrayList2, new C1918ar(this));
        ArrayList<C0864cr> arrayList3 = new ArrayList<>();
        int i3 = 0;
        C0864cr c0864cr3 = null;
        HashMap map = new HashMap();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C0864cr c0864cr4 = (C0864cr) it.next();
            switch (c0864cr4.m4160n().getNumber()) {
                case 0:
                case 1:
                case 4:
                    EnumC2214ab enumC2214abM10020a = C2204r.m10020a(c0864cr4.m4156j(), c0864cr4.m4160n().getNumber());
                    String[] strArrSplit = c0864cr4.m4156j().split("\n");
                    if (enumC2214abM10020a.m10078c() && strArrSplit.length < 5) {
                        if (C4904y.f17872b) {
                            c0864cr4.m4156j();
                            long jM4154h = c0864cr4.m4154h();
                            C4904y.m18639b("[throw away message] this one is not valid to process and show", f7145h);
                            C4904y.m18639b(" message id : " + jM4154h, f7145h);
                            c0864cr = c0864cr3;
                            i = i3;
                        }
                    } else {
                        if (enumC2214abM10020a == EnumC2214ab.ANICON) {
                            String strM13781c = C3460d.m13781c(strArrSplit[2]);
                            if (!TextUtils.isEmpty(strM13781c)) {
                                EnumC3465i enumC3465iM13788h = C3460d.m13788h(GlobalApplication.m18732r(), strM13781c);
                                if (C1813b.m8906b().m8931a(strM9657p)) {
                                    if (enumC3465iM13788h != EnumC3465i.NORMAL) {
                                        C2780l.m11679a().m11683a(strM13781c);
                                    } else {
                                        C3460d.f12913a.put(strM13781c, true);
                                    }
                                } else {
                                    C3460d.f12913a.clear();
                                    C3460d.f12913a.put(strM13781c, true);
                                }
                            }
                        }
                        C0864cr c0864cr5 = c0864cr3 == null ? c0864cr4 : c0864cr3;
                        if ((enumC2214abM10020a == EnumC2214ab.CONTACT || enumC2214abM10020a == EnumC2214ab.CALENDAR || enumC2214abM10020a == EnumC2214ab.DOCUMENT || enumC2214abM10020a == EnumC2214ab.FILE) && strArrSplit.length >= 6) {
                            str = strArrSplit[5];
                        } else {
                            str = null;
                        }
                        if (enumC2214abM10020a == EnumC2214ab.IMAGE && C3460d.m13778b(c0864cr4.m4156j())) {
                            enumC2214abM10020a = EnumC2214ab.ANICON;
                        }
                        String strM9697g = C2176ab.m9697g(this.f7150m, c0864cr4.m4150d());
                        String strM9963p = C2198l.m9963p(GlobalApplication.m18732r().getContentResolver(), this.f7148k);
                        String strM9964q = C2198l.m9964q(GlobalApplication.m18732r().getContentResolver(), this.f7148k);
                        if (!C2198l.m9962o(GlobalApplication.m18732r().getContentResolver(), this.f7148k)) {
                            strM9963p = null;
                            strM9964q = null;
                        }
                        EnumC2292l enumC2292lM10024a = C2204r.m10024a(this.f7150m, this.f7149l.m3599d(), enumC2214abM10020a, c0864cr4, strM9657p, strM9697g, str, enumC2300tM10207a, strM9964q, strM9963p, null, false);
                        if (enumC2292lM10024a == EnumC2292l.INSERT) {
                            z2 = true;
                            this.f7152o++;
                            this.f7153p.add(strM9697g);
                            z3 = false;
                        } else if (enumC2292lM10024a != EnumC2292l.UPDATE) {
                            z2 = false;
                            z3 = false;
                        } else {
                            z3 = true;
                            z2 = false;
                        }
                        if (enumC2214abM10020a != EnumC2214ab.TEXT && (enumC2214abM10020a == EnumC2214ab.IMAGE || enumC2214abM10020a == EnumC2214ab.AUDIO)) {
                            if ((z2 || z3) && strArrSplit.length >= 5) {
                                String str2 = strArrSplit[2];
                                String str3 = strArrSplit[3];
                                long jM4154h2 = c0864cr4.m4154h();
                                Handler handler = new Handler(Looper.getMainLooper());
                                handler.post(new RunnableC1919as(this, enumC2214abM10020a, jM4154h2, handler, c0864cr4.m4156j(), strM9657p, enumC2300tM10207a, strM9697g, str2, str3));
                            } else if (strArrSplit.length >= 4) {
                                C4904y.m18639b("No need to update and insert: " + strArrSplit[3], getClass().getName());
                            } else {
                                C4904y.m18634a("Token Error", getClass().getName());
                            }
                        }
                        if (C1813b.m8906b().m8931a(strM9657p)) {
                            arrayList.add(C0831bl.newBuilder().m3715a(c0864cr4.m4154h()).m3719a(c0864cr4.m4150d()).m3718a(c0864cr4.m4160n()).m3721b(C4809aa.m18104a().m18121a("chaton_id", "")).build());
                            i2 = i3;
                        } else {
                            this.f7151n.m8669a(c0864cr4);
                            i2 = (!z2 || C4809aa.m18104a().m18121a("chaton_id", "").equals(strM9697g)) ? i3 : i3 + 1;
                        }
                        if (z2 || (z3 && C1828q.m8956a().m8966a(Long.valueOf(c0864cr4.m4154h())))) {
                            m9096a(z2, strM9657p, enumC2300tM10207a, c0864cr4);
                        }
                        if (z2 || z3) {
                            this.f7146i = c0864cr4;
                        }
                        if (C2198l.m9962o(GlobalApplication.m18732r().getContentResolver(), this.f7148k)) {
                            C1850c.m9024d().m9027a(Long.valueOf(c0864cr4.m4154h()), c0864cr4.m4156j(), false, null, null, this.f7148k, !C4809aa.m18104a().m18121a("chaton_id", "").equals(strM9697g));
                            C4904y.m18639b("enable translate, inboxNo : " + this.f7148k, f7145h);
                            c0864cr = c0864cr5;
                            i = i2;
                        } else {
                            c0864cr = c0864cr5;
                            i = i2;
                        }
                    }
                    i3 = i;
                    c0864cr3 = c0864cr;
                    break;
                case 2:
                    arrayList3.add(c0864cr4);
                    arrayList.add(C0831bl.newBuilder().m3715a(c0864cr4.m4154h()).m3719a(c0864cr4.m4150d()).m3718a(c0864cr4.m4160n()).m3721b(C4809aa.m18104a().m18121a("chaton_id", "")).build());
                    c0864cr = c0864cr3;
                    i = i3;
                    continue;
                    i3 = i;
                    c0864cr3 = c0864cr;
                case 3:
                    Long lValueOf = Long.valueOf(c0864cr4.m4154h());
                    String strM4147a = c0864cr4.m4147a(0);
                    if (!TextUtils.isEmpty(strM4147a) && !strM4147a.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                        map.put(lValueOf, Integer.valueOf(map.containsKey(lValueOf) ? ((Integer) map.get(lValueOf)).intValue() + 1 : 1));
                    }
                    arrayList.add(C0831bl.newBuilder().m3715a(c0864cr4.m4154h()).m3719a(c0864cr4.m4150d()).m3718a(c0864cr4.m4160n()).m3721b(c0864cr4.m4147a(0)).build());
                    break;
            }
            c0864cr = c0864cr3;
            i = i3;
            i3 = i;
            c0864cr3 = c0864cr;
        }
        ArrayList<ContentProviderOperation> arrayList4 = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2306z.m10213a());
            builderNewUpdate.withValue("message_sever_id", entry.getKey()).withValue(VKApiConst.COUNT, entry.getValue());
            arrayList4.add(builderNewUpdate.build());
        }
        try {
            try {
                if (arrayList4.size() > 0) {
                    this.f7150m.applyBatch("com.sec.chaton.provider", arrayList4);
                }
            } catch (Throwable th) {
                arrayList4.clear();
                throw th;
            }
        } catch (Exception e) {
            C4904y.m18634a(e.getMessage(), getClass().getSimpleName());
        }
        arrayList4.clear();
        if (!this.f7154q && c0864cr3 != null) {
            boolean z4 = false;
            if (!C2198l.m9955h(this.f7150m, strM9657p)) {
                ArrayList<ContentProviderOperation> arrayList5 = new ArrayList<>();
                String strM9697g2 = C2176ab.m9697g(this.f7150m, c0864cr3.m4150d());
                if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(strM9697g2) && !C2176ab.m9681a(this.f7150m, strM9697g2, strM9657p)) {
                    m9095a(arrayList5, strM9657p, c0864cr3.m4150d(), strM9697g2);
                    z4 = true;
                }
                if (enumC2300tM10207a != EnumC2300t.ONETOONE || C4809aa.m18104a().m18121a("chaton_id", "").equals(strM9697g2)) {
                    int iM4152f = c0864cr3.m4152f();
                    for (int i4 = 0; i4 < iM4152f; i4++) {
                        String strM9697g3 = C2176ab.m9697g(this.f7150m, c0864cr3.m4147a(i4));
                        if (!strM9697g3.equals(C4809aa.m18104a().m18121a("chaton_id", "")) && !strM9697g3.equals(C4809aa.m18104a().m18121a("old_chaton_id", ""))) {
                            m9095a(arrayList5, strM9657p, c0864cr3.m4147a(i4), strM9697g3);
                            z4 = true;
                        }
                    }
                    z = z4;
                } else {
                    z = z4;
                }
                try {
                    if (arrayList5.size() > 0) {
                        this.f7150m.applyBatch("com.sec.chaton.provider", arrayList5);
                    }
                } catch (Exception e2) {
                    C4904y.m18634a(e2.getMessage(), getClass().getSimpleName());
                }
                C2198l.m9943c(this.f7150m, strM9657p, 11);
                c2201oM9951e.f7850m = 11;
                z4 = z;
            }
            if (z4) {
                C2134o.m9570a((Handler) null, strM9657p, this.f7149l.m3599d(), 0L);
            }
        }
        if (this.f7146i != null) {
            String strM9695f = C2176ab.m9695f(this.f7150m, this.f7146i.m4150d());
            if (this.f7146i.m4158l() >= c2201oM9951e.f7844g) {
                StringBuilder sb2 = new StringBuilder();
                if (this.f7146i.m4150d().equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                    sb2.append(1).append(Config.KEYVALUE_SPLIT);
                } else {
                    sb2.append(2).append(Config.KEYVALUE_SPLIT);
                }
                sb2.append(C2204r.m10020a(this.f7146i.m4156j(), this.f7146i.m4160n().getNumber()).m10076a()).append(Config.KEYVALUE_SPLIT);
                String strM8632a = C1736gi.m8632a(this.f7146i.m4156j());
                C4904y.m18639b("onPreExecute - (lastmsg) last msg sender : " + this.f7146i.m4150d().toString(), getClass().getSimpleName());
                if (this.f7146i.m4150d().startsWith("0999")) {
                    try {
                        sb2.append(new JSONObject(strM8632a).getString("push_message")).append(Config.KEYVALUE_SPLIT);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    sb2.append(strM8632a).append(Config.KEYVALUE_SPLIT);
                }
                sb2.append(C1736gi.m8632a(strM9695f));
                c2201oM9951e.f7842e = sb2.toString();
                c2201oM9951e.f7847j = this.f7146i.m4154h();
                c2201oM9951e.f7848k = this.f7146i.m4150d();
                c2201oM9951e.f7844g = this.f7146i.m4158l();
            }
            m9094a(arrayList3, strM9657p);
            if (C1813b.m8906b().m8931a(strM9657p)) {
                i3 = 0;
            }
            C2198l.m9908a(this.f7150m, strM9657p, c2201oM9951e, i3);
        } else {
            m9094a(arrayList3, strM9657p);
            C2198l.m9935b(this.f7150m, strM9657p, c2201oM9951e);
        }
        C2405b c2405b2 = new C2405b();
        c2405b2.m19139c(String.format("%04d%s", 7, "0001"));
        StringBuilder sb3 = new StringBuilder();
        for (C0831bl c0831bl : arrayList) {
            c0830bkM3679b.m3674a(c0831bl);
            sb3.append(c0831bl.m3706h()).append(", ");
        }
        if (sb3.length() > 2) {
            sb3.setLength(sb3.length() - 2);
        }
        c2405b2.m10432a(sb3.toString());
        Log.wtf("CH", c2405b2.toString());
        if (C4904y.f17873c) {
            StringBuilder sb4 = new StringBuilder();
            for (int i5 = 0; i5 < c0830bkM3679b.m3685f().size(); i5++) {
                sb4.append("[" + i5 + "] Receiver : " + c0830bkM3679b.m3677a(i5).m3704f()).append(", MsgType : " + c0830bkM3679b.m3677a(i5).m3708j()).append(", MsgID : " + c0830bkM3679b.m3677a(i5).m3706h()).append(", Sender : " + c0830bkM3679b.m3677a(i5).m3702d());
            }
            C4904y.m18641c("[DeliveryChatReply]InboxNO : " + strM9657p + ", UID : " + C4809aa.m18104a().m18121a("uid", "") + ", DeliveryChatReplyItemsCount: " + c0830bkM3679b.m3686g() + ", NextPaginationKey: " + c0830bkM3679b.m3689j() + sb4.toString(), getClass().getSimpleName());
        }
        C2417af.m10449a(this.f7187c, new C2427ap().m10517a(7).m10519a(c0830bkM3679b.build()).m10522b());
        if (this.f7191g.m9654m()) {
            new Handler().postDelayed(new RunnableC1920at(this), 2000L);
        }
        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7148k}));
        C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
        return null;
    }

    /* renamed from: a */
    private void m9096a(boolean z, String str, EnumC2300t enumC2300t, C0864cr c0864cr) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        KeyguardManager keyguardManager = (KeyguardManager) CommonApplication.m18732r().getSystemService("keyguard");
        C2201o c2201oM9951e = C2198l.m9951e(this.f7150m, str);
        if (c2201oM9951e == null) {
            C4904y.m18634a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return;
        }
        String strM9695f = C2176ab.m9695f(this.f7150m, c0864cr.m4150d());
        if (this.f7191g.m9655n()) {
            return;
        }
        if ((!C1813b.m8906b().m8931a(str) || keyguardManager.inKeyguardRestrictedInputMode()) && !c0864cr.m4150d().equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            EnumC2214ab enumC2214abM10020a = C2204r.m10020a(c0864cr.m4156j(), c0864cr.m4160n().getNumber());
            String strM4156j = c0864cr.m4156j();
            if (enumC2214abM10020a == EnumC2214ab.POLL) {
                try {
                    strM4156j = new JSONObject(strM4156j).getJSONObject("push_message").toString();
                } catch (JSONException e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
            EnumC2301u enumC2301u = EnumC2301u.NORMAL;
            if (c0864cr.m4150d().startsWith("0999")) {
                enumC2301u = EnumC2301u.LIVE;
            }
            C1813b.m8906b().m8926a(c0864cr.m4150d(), strM4156j, str, c0864cr.m4154h(), enumC2214abM10020a, enumC2300t.m10210a(), this.f7149l.m3599d(), strM9695f, c2201oM9951e.f7855r, c0864cr.m4158l(), c2201oM9951e.f7852o, c2201oM9951e.f7853p, c2201oM9951e.f7845h, c2201oM9951e.f7856s, "N", enumC2301u);
        }
    }

    /* renamed from: a */
    private void m9095a(ArrayList<ContentProviderOperation> arrayList, String str, String str2, String str3) {
        C4904y.m18646e("insertParticipant() inboxNo : " + str + ", oldBuddyNo : " + str2 + ", newBuddyNo : " + str3, f7145h);
        if (str3 != null && !str3.equals(str2) && TextUtils.isEmpty(this.f7149l.m3599d()) && C2176ab.m9681a(this.f7150m, str2, str)) {
            C4904y.m18646e("insertParticipant() - old buddyNo is exist : " + str2 + ", skip insert", f7145h);
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", str2);
            arrayList.add(C2204r.m10011a("message_sender=? AND message_inbox_no =?", new String[]{str3, str}, contentValues));
            return;
        }
        C4904y.m18646e("insertParticipant() - Insert Participants : " + str3, f7145h);
        arrayList.add(C2176ab.m9670a(str, str3));
    }

    /* renamed from: a */
    private void m9094a(ArrayList<C0864cr> arrayList, String str) {
        this.f7151n.m8670a(arrayList);
        if (!this.f7154q) {
            Iterator<C0864cr> it = this.f7151n.m8673d().iterator();
            while (it.hasNext()) {
                C0864cr next = it.next();
                String[] strArrSplit = next.m4156j().split("\n");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    String[] strArrM8650b = C1736gi.m8650b(str2, ",", 3);
                    if (strArrM8650b.length > 2) {
                        String str3 = strArrM8650b[1];
                        String strM9685b = C2176ab.m9685b(this.f7150m, str3, strArrM8650b[2]);
                        boolean zM9681a = C2176ab.m9681a(this.f7150m, str3, str);
                        EnumC2231as enumC2231as = EnumC2231as.UNKNOWN;
                        if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.ENTER) {
                            if (!zM9681a) {
                                C2176ab.m9676a(this.f7150m, str, str3, strM9685b);
                                enumC2231as = C4809aa.m18104a().m18121a("chaton_id", "").equals(next.m4150d()) ? EnumC2231as.INVITE : EnumC2231as.ENTER;
                            }
                        } else if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.LEAVE && zM9681a) {
                            C2176ab.m9692d(this.f7150m, str, str3);
                            enumC2231as = EnumC2231as.LEAVE;
                        }
                        if (enumC2231as != EnumC2231as.UNKNOWN) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC2231as.m10100a()), str3, C1736gi.m8632a(strM9685b))).append(Config.KEYVALUE_SPLIT);
                        }
                    }
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    C2204r.m10013a(this.f7150m, str, string, next.m4158l(), Long.toString(next.m4154h()), C2176ab.m9697g(this.f7150m, next.m4150d()));
                }
            }
            if (this.f7151n.m8673d().size() > 0) {
                C2198l.m9957j(this.f7150m, str);
            }
            this.f7151n.m8674e();
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C0829bj c0829bj = (C0829bj) ((C2426ao) obj2).m10513c();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < c0829bj.m3652e().size(); i2++) {
                sb.append("[" + i2 + "] MsgID : " + c0829bj.m3648a(i2).m3706h()).append(", MsgType : " + c0829bj.m3648a(i2).m3708j()).append(", Receiver : " + c0829bj.m3648a(i2).m3704f()).append(", Sender : " + c0829bj.m3648a(i2).m3702d());
            }
            C4904y.m18641c("[DeliveryChatReply]InboxNO : " + this.f7148k + ", UID : " + C4809aa.m18104a().m18121a("uid", "") + ", DeliveryChatReplyItemsCount : " + c0829bj.m3653f() + ", ResultCode : " + c0829bj.m3655h().m5229d() + ", ResultMsg : " + c0829bj.m3655h().m5231f() + ", DeliveryChatReplyItemsCount :" + c0829bj.m3653f() + sb.toString(), getClass().getSimpleName());
        } else {
            C4904y.m18641c(Config.EXTRA_ERROR, getClass().getSimpleName());
        }
        Message message = new Message();
        message.what = 6;
        C0783g c0783gM3128a = new C0783g().m3129a(true).m3127a(this.f7149l.m3599d()).m3125a(EnumC0791o.SUCCESS).m3124a(this.f7152o).m3132c(this.f7146i == null ? null : this.f7146i.m4156j()).m3130b(this.f7146i == null ? null : C2176ab.m9697g(CommonApplication.m18732r().getContentResolver(), this.f7146i.m4150d())).m3126a(this.f7146i != null ? C2204r.m10020a(this.f7146i.m4156j(), this.f7146i.m4160n().getNumber()) : null).m3128a(this.f7153p);
        if (this.f7149l.m3606k()) {
            c0783gM3128a.m3131b(this.f7149l.m3607l());
        } else {
            c0783gM3128a.m3131b(false);
        }
        message.obj = c0783gM3128a.m3123a();
        this.f7186b.sendMessage(message);
    }
}
