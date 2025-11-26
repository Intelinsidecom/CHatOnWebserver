package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1753gz;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p046a.C0870cx;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.C2096bb;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2466q;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.qmlog.EnumC3124f;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: InitChatRoomTask.java */
/* renamed from: com.sec.chaton.d.a.dc */
/* loaded from: classes.dex */
public class C1984dc extends C2055n {

    /* renamed from: h */
    private EnumC2214ab f7279h;

    /* renamed from: i */
    private EnumC2300t f7280i;

    /* renamed from: j */
    private String[] f7281j;

    /* renamed from: k */
    private String f7282k;

    /* renamed from: l */
    private ContentResolver f7283l;

    /* renamed from: n */
    private String f7284n;

    public C1984dc(Handler handler, String str, long j, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2, EnumC2706n enumC2706n) {
        super(handler, 1, enumC2706n);
        this.f7190f = j;
        this.f7284n = str;
        this.f7279h = enumC2214ab;
        this.f7280i = enumC2300t;
        this.f7281j = strArr;
        this.f7282k = str2;
        this.f7283l = CommonApplication.m18732r().getContentResolver();
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        if (C2349a.m10301a("broadcast2_feature") && this.f7280i == EnumC2300t.BROADCAST) {
            this.f7280i = EnumC2300t.BROADCAST2;
        }
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12719a(this, System.currentTimeMillis());
            C3119a.m12716a().m12720a(this, this.f7190f, this.f7282k.length());
        }
        C2684ab.m11290a(getClass().getSimpleName(), "onPreExecute()", new Object[0]);
        return C2096bb.m9360a().m9364a(this.f7284n, this.f7190f, this.f7279h, this.f7280i, this.f7281j, this.f7282k);
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) throws Throwable {
        super.mo9092a(i, obj, obj2);
        C2684ab.m11290a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        Message message = new Message();
        message.what = 0;
        if (obj2 != null) {
            C0870cx c0870cx = (C0870cx) ((C2426ao) obj2).m10513c();
            C1734gg.m8597a(this.f7284n, c0870cx, getClass().getSimpleName());
            int iM5229d = c0870cx.m4258l().m5229d();
            String strM5231f = c0870cx.m4258l().m5231f();
            if (iM5229d == 1000 || iM5229d == 1001 || iM5229d == 3002) {
                HashMap map = new HashMap();
                C4904y.m18641c("buddyname retrieve end", getClass().getSimpleName());
                C2190d.m9816a(this.f7283l, this.f7281j, map);
                C4904y.m18641c("participant insert start", getClass().getSimpleName());
                int length = this.f7281j.length;
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                arrayList.add(C2176ab.m9668a(this.f7284n));
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(C2176ab.m9672a(this.f7284n, this.f7281j[i2], (String) map.get(this.f7281j[i2])));
                }
                try {
                    if (arrayList.size() > 0) {
                        this.f7283l.applyBatch("com.sec.chaton.provider", arrayList);
                    }
                } catch (Exception e) {
                    C4904y.m18634a(e.getMessage(), getClass().getSimpleName());
                    C4904y.m18641c("Fail to insert participant to DB", getClass().getSimpleName());
                }
                C4904y.m18641c("participant insert end", getClass().getSimpleName());
                C2134o.m9570a((Handler) null, this.f7284n, c0870cx.m4252f(), 0L);
                C2198l.m9924a(this.f7283l, this.f7284n, c0870cx, this.f7282k, this.f7280i, this.f7281j, this.f7279h, EnumC2301u.NORMAL);
                C2204r.m10002a(this.f7283l, Long.valueOf(c0870cx.m4254h()), c0870cx.m4252f(), c0870cx.m4250d(), Long.valueOf(this.f7190f), this.f7281j.length);
                if (iM5229d == 1001) {
                    List<String> listM5237l = c0870cx.m4258l().m5237l();
                    if (listM5237l != null) {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("1001 error blockedByReceiverList : " + listM5237l.toString(), getClass().getSimpleName());
                        }
                        Iterator<String> it = listM5237l.iterator();
                        while (it.hasNext()) {
                            C2176ab.m9692d(this.f7283l, this.f7284n, it.next());
                        }
                    }
                    if (strM5231f.indexOf("[") != -1 && strM5231f.indexOf("]") != -1) {
                        String[] strArrSplit = strM5231f.substring(strM5231f.indexOf("[") + 1, strM5231f.indexOf("]")).trim().split(",");
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : strArrSplit) {
                            String strM9693e = C2176ab.m9693e(this.f7283l, this.f7284n, str);
                            C4904y.m18641c("1001 error - invalidUserName:" + strM9693e, getClass().getSimpleName());
                            arrayList2.add(strM9693e);
                            C2176ab.m9692d(this.f7283l, this.f7284n, str);
                        }
                        message.obj = new C1985dd(this, true, c0870cx.m4252f(), iM5229d, arrayList2, this.f7190f);
                    } else {
                        message.obj = new C1985dd(this, true, c0870cx.m4252f(), iM5229d, this.f7190f);
                    }
                    C2198l.m9949d(this.f7283l, this.f7284n);
                } else {
                    message.obj = new C1985dd(this, true, c0870cx.m4252f(), iM5229d, this.f7190f);
                }
            } else {
                if (iM5229d == 7006) {
                    C1753gz.m8698a().m8704a(this.f7186b, this.f7284n, this.f7280i, c0870cx.m4258l());
                }
                message.obj = new C0788l(false, iM5229d, this.f7190f);
                C4904y.m18641c("InitChatReply : InBoxNO = " + this.f7284n + ", InitChat Fail", getClass().getSimpleName());
                if (iM5229d == 3001) {
                    C2204r.m10000a(this.f7283l, Long.valueOf(this.f7190f), Long.valueOf(C4843bh.m18322a()));
                } else {
                    C2204r.m10041b(this.f7283l, Long.valueOf(this.f7190f));
                }
                if (iM5229d == 6002) {
                    String[] strArrM9689c = C2176ab.m9689c(this.f7283l, this.f7284n);
                    ArrayList arrayList3 = new ArrayList();
                    for (String str2 : strArrM9689c) {
                        arrayList3.add(C2176ab.m9693e(this.f7283l, this.f7284n, str2));
                    }
                    if (EnumC2300t.m10208a(this.f7280i) && strArrM9689c.length > 0) {
                        m9135a(strArrM9689c, c0870cx.m4254h());
                    }
                    message.obj = new C1985dd(this, false, iM5229d, (ArrayList<String>) arrayList3, this.f7190f);
                } else if (iM5229d == 7006 && c0870cx.m4258l() != null && c0870cx.m4258l().m5235j() != null) {
                    message.obj = new C1985dd(this, false, iM5229d, c0870cx.m4258l().m5235j(), this.f7190f);
                }
            }
            this.f7186b.sendMessage(message);
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7284n}));
            if (C2349a.m10301a("chaton_qmlog_sending")) {
                C3119a.m12716a().m12721a(this, EnumC3124f.SEND, System.currentTimeMillis());
                return;
            }
            return;
        }
        if (!mo9104a() || i == 11 || i == 22 || i == 3) {
            if (!this.f7515m.m11326a() && C2466q.m10670a(i)) {
                C2204r.m9999a(this.f7283l, Long.valueOf(this.f7190f));
            } else {
                C2204r.m10041b(this.f7283l, Long.valueOf(this.f7190f));
            }
            if (i == 24 || i == 23 || i == 21) {
                C2198l.m9953f(this.f7283l, this.f7284n);
                C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7284n}));
            }
        }
        message.obj = new C0788l(false, i, this.f7190f);
        this.f7186b.sendMessage(message);
        C1734gg.m8586a(1, this.f7284n, i, this.f7190f, "", getClass().getSimpleName());
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12721a(this, EnumC3124f.SEND, -1L);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    public boolean mo9104a() {
        if (this.f7515m.m11326a() || !C2717y.m11398b()) {
            return super.mo9104a();
        }
        return false;
    }

    /* renamed from: a */
    private void m9135a(String[] strArr, long j) {
        String strM9693e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (C2176ab.m9681a(this.f7283l, str2, this.f7284n)) {
                strM9693e = C2176ab.m9693e(this.f7283l, this.f7284n, str2);
                if (TextUtils.isEmpty(strM9693e)) {
                    strM9693e = str;
                }
                C4904y.m18641c("6002 error - invalidUserName:" + strM9693e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.LEAVE.m10100a()), str2, C1736gi.m8632a(strM9693e))).append(Config.KEYVALUE_SPLIT);
                C2176ab.m9692d(this.f7283l, this.f7284n, str2);
            } else {
                strM9693e = str;
            }
            i++;
            str = strM9693e;
        }
        if (sb.length() > 0) {
            C2204r.m10007a(this.f7283l, this.f7284n, sb.toString(), j, C4809aa.m18104a().m18121a("chaton_id", ""));
            C2198l.m9949d(this.f7283l, this.f7284n);
        }
    }
}
