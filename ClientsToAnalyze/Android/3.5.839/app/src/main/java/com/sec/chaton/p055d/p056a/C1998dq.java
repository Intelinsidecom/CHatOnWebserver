package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1753gz;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p046a.C0815aw;
import com.sec.chaton.p046a.C0870cx;
import com.sec.chaton.p046a.C0927f;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.C2096bb;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2466q;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.qmlog.EnumC3124f;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaChatTask.java */
/* renamed from: com.sec.chaton.d.a.dq */
/* loaded from: classes.dex */
public class C1998dq extends C2055n {

    /* renamed from: h */
    protected String f7333h;

    /* renamed from: i */
    protected String f7334i;

    /* renamed from: j */
    protected String f7335j;

    /* renamed from: k */
    protected String f7336k;

    /* renamed from: l */
    protected String f7337l;

    /* renamed from: n */
    protected String f7338n;

    /* renamed from: o */
    protected int f7339o;

    /* renamed from: p */
    private String f7340p;

    /* renamed from: q */
    private String f7341q;

    /* renamed from: r */
    private EnumC2214ab f7342r;

    /* renamed from: s */
    private EnumC2300t f7343s;

    /* renamed from: t */
    private String f7344t;

    /* renamed from: u */
    private String[] f7345u;

    /* renamed from: v */
    private String f7346v;

    /* renamed from: w */
    private boolean f7347w;

    /* renamed from: x */
    private String f7348x;

    /* renamed from: y */
    private ContentResolver f7349y;

    /* renamed from: z */
    private String f7350z;

    public C1998dq(Handler handler, String str, long j, String str2, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str3, String[] strArr, String str4, boolean z, String str5, String str6, EnumC2706n enumC2706n) {
        super(handler, 1, enumC2706n);
        this.f7339o = -1;
        this.f7341q = str2;
        this.f7340p = str;
        this.f7342r = enumC2214ab;
        this.f7343s = enumC2300t;
        this.f7344t = str3;
        this.f7345u = strArr;
        this.f7348x = str4;
        this.f7347w = z;
        this.f7335j = str5;
        this.f7349y = CommonApplication.m18732r().getContentResolver();
        this.f7190f = j;
        this.f7350z = "";
        this.f7336k = str6;
        if (this.f7345u != null && this.f7345u.length > 0) {
            this.f7346v = this.f7345u[0];
        }
    }

    public C1998dq(Handler handler, String str, long j, String str2, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str3, String[] strArr, String str4, boolean z, String str5, String str6, String str7, EnumC2706n enumC2706n) {
        super(handler, 1, enumC2706n);
        this.f7339o = -1;
        this.f7341q = str2;
        this.f7340p = str;
        this.f7342r = enumC2214ab;
        this.f7343s = enumC2300t;
        this.f7344t = str3;
        this.f7345u = strArr;
        this.f7348x = str4;
        this.f7347w = z;
        this.f7335j = str5;
        this.f7349y = GlobalApplication.m18732r().getContentResolver();
        this.f7190f = j;
        this.f7350z = "";
        this.f7336k = str6;
        this.f7337l = str7;
        if (this.f7345u != null && this.f7345u.length > 0) {
            this.f7346v = this.f7345u[0];
        }
    }

    /* renamed from: d */
    public String m9147d() {
        return this.f7350z;
    }

    /* renamed from: e */
    public boolean m9148e() {
        String strSubstring = this.f7341q;
        if (this.f7341q != null && this.f7341q.startsWith(".")) {
            strSubstring = this.f7341q.substring(1);
        }
        switch (C1999dr.f7351a[this.f7342r.ordinal()]) {
            case 1:
                this.f7333h = SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
                break;
            case 2:
                this.f7333h = "audio";
                break;
            case 3:
                this.f7333h = "calendar";
                break;
            case 4:
                this.f7333h = "contact";
                break;
            case 5:
                this.f7333h = "geo";
                break;
            case 6:
                this.f7333h = "video";
                break;
            case 7:
                this.f7333h = "doc";
                this.f7334i = strSubstring;
                break;
            case 8:
                this.f7333h = "file";
                this.f7334i = strSubstring;
                break;
            case 9:
                this.f7333h = "ams";
                break;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.f7342r == EnumC2214ab.GEO || this.f7342r == EnumC2214ab.ANICON) {
            this.f7350z = this.f7335j;
        } else {
            if (TextUtils.isEmpty(this.f7348x)) {
                return false;
            }
            String str = this.f7336k;
            if (!TextUtils.isEmpty(this.f7337l)) {
                str = this.f7337l;
            }
            if (TextUtils.isEmpty(str)) {
                sb.append(this.f7333h + "\n");
                sb2.append(this.f7333h + "\n");
                if (!TextUtils.isEmpty(strSubstring)) {
                    sb.append(strSubstring + "\n");
                    sb2.append(strSubstring + "\n");
                }
                sb.append(this.f7348x + "\n");
                sb2.append(this.f7348x + "\n");
            } else {
                sb.append("mixed\n");
                sb.append(this.f7333h + "\n");
                sb.append(this.f7348x + "\n");
                sb2.append("mixed\n");
                sb2.append(this.f7333h + "\n");
                sb2.append(this.f7348x + "\n");
            }
            if (this.f7342r == EnumC2214ab.CONTACT || this.f7342r == EnumC2214ab.CALENDAR || this.f7342r == EnumC2214ab.DOCUMENT || this.f7342r == EnumC2214ab.FILE) {
                sb.append(this.f7335j);
                sb2.append(this.f7335j);
            }
            if (!TextUtils.isEmpty(str)) {
                sb.append("\n" + str);
                sb2.append("\n" + this.f7336k);
            }
            this.f7350z = sb.toString();
        }
        this.f7334i = this.f7350z;
        if (EnumC2214ab.GEO != this.f7342r && EnumC2214ab.ANICON != this.f7342r) {
            C2204r.m10006a(this.f7349y, (String) null, (String) null, Long.valueOf(this.f7190f), sb2.toString(), this.f7337l, this.f7343s, C4873ck.m18500a());
            C2716x.m11388b(this.f7340p, this.f7190f, this.f7350z);
        }
        return true;
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        if (!m9148e()) {
            return null;
        }
        if (this.f7347w) {
            if (C2349a.m10301a("broadcast2_feature") && this.f7343s == EnumC2300t.BROADCAST) {
                this.f7343s = EnumC2300t.BROADCAST2;
            }
            if (C2349a.m10301a("chaton_qmlog_sending")) {
                C3119a.m12716a().m12719a(this, System.currentTimeMillis());
                C3119a.m12716a().m12720a(this, this.f7190f, this.f7350z.length());
            }
            this.f7339o = 106;
            return C2096bb.m9360a().m9364a(this.f7340p, this.f7190f, this.f7342r, this.f7343s, this.f7345u, this.f7350z);
        }
        if (!C2417af.m10450a(this.f7187c)) {
            C2198l.m9929a(this.f7349y, this.f7340p, this.f7187c);
            long jM18322a = C4843bh.m18322a();
            if (this.f7345u == null || this.f7345u.length == 0) {
                this.f7338n = this.f7340p;
            } else {
                this.f7338n = String.valueOf(this.f7346v);
            }
            this.f7339o = 102;
            return C2096bb.m9360a().m9363a(this.f7343s, this.f7340p, this.f7338n, jM18322a, this.f7344t);
        }
        String str = "";
        if (!TextUtils.isEmpty(this.f7346v)) {
            str = this.f7346v;
        }
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12719a(this, System.currentTimeMillis());
            C3119a.m12716a().m12720a(this, this.f7190f, this.f7350z.length());
        }
        this.f7339o = 102;
        return C2096bb.m9360a().m9361a(this.f7190f, this.f7340p, this.f7342r, this.f7343s, this.f7344t, this.f7350z, str);
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) throws Throwable {
        List<String> listM5236k;
        String strM8702a;
        super.mo9092a(i, obj, obj);
        C2684ab.m11290a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        Message message = new Message();
        if (obj2 != null) {
            C2426ao c2426ao = (C2426ao) obj2;
            switch (c2426ao.m10512b()) {
                case 1:
                    message.what = 106;
                    C0870cx c0870cx = (C0870cx) c2426ao.m10513c();
                    if (C4904y.f17873c) {
                        C4904y.m18641c("[InitChatReply]MsgID : " + c0870cx.m4250d() + ", InboxNO : " + this.f7340p + ", UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ResultCode : " + c0870cx.m4258l().m5229d() + ", ResultMessage : " + c0870cx.m4258l().m5231f() + ", MsgReceivedTime : " + c0870cx.m4254h() + ", ServerInfo(address) : " + (c0870cx.m4256j() != null ? c0870cx.m4256j().m5561d() : "null(broadcast)") + ", ServerInfo(port) : " + (c0870cx.m4256j() != null ? Integer.valueOf(c0870cx.m4256j().m5563f()) : "null(broadcast)") + ", SessionID : " + c0870cx.m4252f(), getClass().getSimpleName());
                    }
                    int iM5229d = c0870cx.m4258l().m5229d();
                    String strM5231f = c0870cx.m4258l().m5231f();
                    if (iM5229d == 1000 || iM5229d == 1001 || iM5229d == 3002) {
                        HashMap map = new HashMap();
                        C4904y.m18641c("buddyname retrieve end", getClass().getSimpleName());
                        C2190d.m9816a(this.f7349y, this.f7345u, map);
                        C4904y.m18641c("participant insert start", getClass().getSimpleName());
                        int length = this.f7345u.length;
                        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                        arrayList.add(C2176ab.m9668a(this.f7340p));
                        for (int i2 = 0; i2 < length; i2++) {
                            arrayList.add(C2176ab.m9672a(this.f7340p, this.f7345u[i2], (String) map.get(this.f7345u[i2])));
                        }
                        try {
                            if (arrayList.size() > 0) {
                                this.f7349y.applyBatch("com.sec.chaton.provider", arrayList);
                            }
                        } catch (Exception e) {
                            C4904y.m18634a(e.getMessage(), getClass().getSimpleName());
                            C4904y.m18641c("Fail to insert participant to DB", getClass().getSimpleName());
                        }
                        C4904y.m18641c("participant insert end", getClass().getSimpleName());
                        C2134o.m9570a((Handler) null, this.f7340p, c0870cx.m4252f(), 0L);
                        C2198l.m9924a(this.f7349y, this.f7340p, c0870cx, this.f7350z, this.f7343s, this.f7345u, this.f7342r, EnumC2301u.NORMAL);
                        C2204r.m10002a(this.f7349y, Long.valueOf(c0870cx.m4254h()), c0870cx.m4252f(), c0870cx.m4250d(), Long.valueOf(this.f7190f), this.f7345u.length);
                        if (iM5229d == 1001) {
                            List<String> listM5237l = c0870cx.m4258l().m5237l();
                            if (listM5237l != null) {
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("1001 error blockedByReceiverList : " + listM5237l.toString(), getClass().getSimpleName());
                                }
                                Iterator<String> it = listM5237l.iterator();
                                while (it.hasNext()) {
                                    C2176ab.m9692d(this.f7349y, this.f7340p, it.next());
                                }
                            }
                            if (strM5231f.indexOf("[") != -1 && strM5231f.indexOf("]") != -1) {
                                String[] strArrSplit = strM5231f.substring(strM5231f.indexOf("[") + 1, strM5231f.indexOf("]")).trim().split(",");
                                ArrayList arrayList2 = new ArrayList();
                                for (String str : strArrSplit) {
                                    String strM9693e = C2176ab.m9693e(this.f7349y, this.f7340p, str);
                                    C4904y.m18641c("1001 error - invalidUserName:" + strM9693e, getClass().getSimpleName());
                                    arrayList2.add(strM9693e);
                                    C2176ab.m9692d(this.f7349y, this.f7340p, str);
                                }
                                message.obj = new C2000ds(this, true, c0870cx.m4252f(), iM5229d, arrayList2, this.f7190f);
                            } else {
                                message.obj = new C2000ds(this, true, c0870cx.m4252f(), iM5229d, this.f7190f);
                            }
                            C2198l.m9949d(this.f7349y, this.f7340p);
                        } else {
                            message.obj = new C2000ds(this, true, c0870cx.m4252f(), iM5229d, this.f7190f);
                        }
                        this.f7186b.sendMessage(message);
                        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7340p}));
                    } else {
                        if (iM5229d == 7006) {
                            C1753gz.m8698a().m8704a(this.f7186b, this.f7340p, this.f7343s, c0870cx.m4258l());
                        }
                        message.obj = new C2000ds(this, false, (String) null, iM5229d, this.f7190f);
                        if (iM5229d == 3001) {
                            C2204r.m10000a(this.f7349y, Long.valueOf(this.f7190f), Long.valueOf(C4843bh.m18322a()));
                        } else {
                            C2204r.m10041b(this.f7349y, Long.valueOf(this.f7190f));
                        }
                        if (iM5229d == 6002) {
                            String[] strArrM9689c = C2176ab.m9689c(this.f7349y, this.f7340p);
                            ArrayList arrayList3 = new ArrayList();
                            for (String str2 : strArrM9689c) {
                                arrayList3.add(C2176ab.m9693e(this.f7349y, this.f7340p, str2));
                            }
                            if (EnumC2300t.m10208a(this.f7343s) && strArrM9689c.length > 0) {
                                m9145a(strArrM9689c, c0870cx.m4254h());
                            }
                            message.obj = new C2000ds(this, false, iM5229d, (ArrayList<String>) arrayList3, this.f7190f);
                        } else if (iM5229d == 7006 && c0870cx.m4258l() != null && c0870cx.m4258l().m5235j() != null) {
                            message.obj = new C2000ds(this, false, iM5229d, c0870cx.m4258l().m5235j(), this.f7190f);
                        }
                        this.f7186b.sendMessage(message);
                    }
                    if (C2349a.m10301a("chaton_qmlog_sending")) {
                        C3119a.m12716a().m12721a(this, EnumC3124f.SEND, System.currentTimeMillis());
                        break;
                    }
                    break;
                case 3:
                    message.what = 102;
                    C0927f c0927f = (C0927f) c2426ao.m10513c();
                    if (this.f7343s == EnumC2300t.TOPIC) {
                        C2176ab.m9679a(c0927f, this.f7340p, this.f7344t);
                    } else {
                        C2176ab.m9686b(c0927f, this.f7340p, this.f7344t);
                    }
                    if (C4904y.f17873c) {
                        C4904y.m18641c("[AllowChatReply]MsgID : " + c0927f.m5083d() + ", InboxNO : " + this.f7340p + ", UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ResultCode : " + c0927f.m5085f().m5229d() + ", ResultMsg : " + c0927f.m5085f().m5231f(), getClass().getSimpleName());
                    }
                    int iM5229d2 = c0927f.m5085f().m5229d();
                    if (iM5229d2 == 1000 || iM5229d2 == 3003) {
                        message.obj = new C0788l(true, 900, this.f7340p, this.f7190f);
                    } else {
                        if (iM5229d2 == 2006 || iM5229d2 == 3008) {
                            C2198l.m9909a(CommonApplication.m18732r().getContentResolver(), this.f7340p, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                            strM8702a = null;
                        } else if (iM5229d2 == 7001) {
                            C1753gz.m8698a().m8706a(this.f7340p, this.f7338n, 0L);
                            strM8702a = null;
                        } else if (iM5229d2 == 7002) {
                            strM8702a = C1753gz.m8698a().m8701a(this.f7186b, this.f7340p, c0927f.m5085f());
                        } else if (iM5229d2 == 7003) {
                            strM8702a = C1753gz.m8698a().m8702a(this.f7340p, c0927f.m5085f());
                        } else {
                            C2204r.m10041b(this.f7349y, Long.valueOf(this.f7190f));
                            strM8702a = null;
                        }
                        if (!TextUtils.isEmpty(strM8702a)) {
                            this.f7346v = strM8702a;
                        }
                        message.obj = new C0788l(false, iM5229d2, this.f7340p, this.f7190f);
                        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7340p}));
                    }
                    this.f7186b.sendMessage(message);
                    break;
                case 5:
                    message.what = 102;
                    C0815aw c0815aw = (C0815aw) c2426ao.m10513c();
                    if (C4904y.f17873c) {
                        C4904y.m18641c("[ChatReply]MsgID : " + c0815aw.m3444d() + ", InboxNO : " + this.f7340p + ", UID : " + C4809aa.m18104a().m18121a("uid", "") + ", MsgReceivedTime : " + c0815aw.m3450j() + ", SessionID : " + c0815aw.m3446f() + ", ResultCode : " + c0815aw.m3452l().m5229d() + ", ResultMsg : " + c0815aw.m3452l().m5231f() + ", ServerInfo(address) : " + (c0815aw.m3448h() != null ? c0815aw.m3448h().m5561d() : "null") + ", ServerInfo(port) : " + (c0815aw.m3448h() != null ? Integer.valueOf(c0815aw.m3448h().m5563f()) : "null"), getClass().getSimpleName());
                    }
                    int iM5229d3 = c0815aw.m3452l().m5229d();
                    String strM5231f2 = c0815aw.m3452l().m5231f();
                    if (iM5229d3 == 1000 || iM5229d3 == 1001) {
                        int length2 = 0;
                        if (this.f7345u != null) {
                            length2 = this.f7345u.length;
                        }
                        C2204r.m10002a(this.f7349y, Long.valueOf(c0815aw.m3450j()), c0815aw.m3446f(), c0815aw.m3444d(), Long.valueOf(this.f7190f), length2);
                        C2198l.m9912a(this.f7349y, C4809aa.m18104a().m18121a("chaton_id", ""), this.f7340p, this.f7334i, c0815aw.m3450j(), c0815aw.m3446f(), c0815aw.m3448h().m5561d(), Integer.valueOf(C4844bi.m18323a().m18328c().m18332b()), Long.valueOf(c0815aw.m3444d()), length2, this.f7342r);
                        if (iM5229d3 == 1001) {
                            m9145a(strM5231f2.substring(strM5231f2.indexOf("[") + 1, strM5231f2.indexOf("]")).trim().split(","), c0815aw.m3450j());
                            if (this.f7343s == EnumC2300t.BROADCAST2 && (listM5236k = c0815aw.m3452l().m5236k()) != null) {
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("1001 error blockedReciversList : " + listM5236k.toString(), "MediaChatTask");
                                }
                                String str3 = "";
                                if (this.f7345u != null && this.f7345u.length > 0) {
                                    str3 = this.f7345u[0];
                                }
                                if (this.f7345u != null && this.f7345u.length > listM5236k.size()) {
                                    String[] strArr = this.f7345u;
                                    int length3 = strArr.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < length3) {
                                            String str4 = strArr[i3];
                                            if (listM5236k.contains(str4)) {
                                                i3++;
                                            } else {
                                                str3 = str4;
                                            }
                                        }
                                    }
                                } else {
                                    str3 = "";
                                }
                                if (this.f7191g == null) {
                                    this.f7191g = C2142w.m9593a(this.f7340p, this.f7343s);
                                }
                                this.f7191g.mo9241a(this.f7344t, new String[]{str3}, (String[]) listM5236k.toArray(new String[0]), false);
                            }
                        }
                        message.obj = new C0788l(true, iM5229d3, this.f7190f);
                        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7340p}));
                    } else {
                        String strM8702a2 = null;
                        message.obj = new C0788l(false, iM5229d3, this.f7190f);
                        if (iM5229d3 == 7001) {
                            C2204r.m10041b(this.f7349y, Long.valueOf(this.f7190f));
                            C1753gz.m8698a().m8706a(this.f7340p, this.f7345u[0], c0815aw.m3450j());
                        } else if (iM5229d3 == 7002) {
                            strM8702a2 = C1753gz.m8698a().m8701a(this.f7186b, this.f7340p, c0815aw.m3452l());
                        } else if (iM5229d3 == 7003) {
                            strM8702a2 = C1753gz.m8698a().m8702a(this.f7340p, c0815aw.m3452l());
                        } else {
                            C2204r.m10041b(this.f7349y, Long.valueOf(this.f7190f));
                            if (iM5229d3 == 6002) {
                                if (this.f7343s == EnumC2300t.ONETOONE) {
                                    if (this.f7345u != null && this.f7345u.length > 0) {
                                        C2198l.m9910a(this.f7349y, this.f7345u[0], C2176ab.m9693e(this.f7349y, this.f7340p, this.f7345u[0]), c0815aw.m3450j());
                                    }
                                } else {
                                    m9145a(C2176ab.m9689c(this.f7349y, this.f7340p), c0815aw.m3450j());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(strM8702a2)) {
                            this.f7346v = strM8702a2;
                        }
                    }
                    C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7340p}));
                    this.f7186b.sendMessage(message);
                    if (C2349a.m10301a("chaton_qmlog_sending")) {
                        C3119a.m12716a().m12721a(this, EnumC3124f.SEND, System.currentTimeMillis());
                        break;
                    }
                    break;
            }
            return;
        }
        if (!mo9104a() || i == 11 || i == 22 || i == 3) {
            if (!this.f7515m.m11326a() && C2466q.m10670a(i)) {
                C2204r.m9999a(this.f7349y, Long.valueOf(this.f7190f));
            } else {
                C2204r.m10041b(this.f7349y, Long.valueOf(this.f7190f));
            }
            m9192a(i, this.f7340p);
        }
        message.what = this.f7339o;
        message.obj = new C0788l(false, i, this.f7190f);
        this.f7186b.sendMessage(message);
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12721a(this, EnumC3124f.SEND, -1L);
        }
    }

    /* renamed from: a */
    private void m9145a(String[] strArr, long j) {
        String strM9693e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (C2176ab.m9681a(this.f7349y, str2, this.f7340p)) {
                strM9693e = C2176ab.m9693e(this.f7349y, this.f7340p, str2);
                if (TextUtils.isEmpty(strM9693e)) {
                    strM9693e = str;
                }
                C4904y.m18641c("1001 error - invalidUserName:" + strM9693e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.LEAVE.m10100a()), str2, C1736gi.m8632a(strM9693e))).append(Config.KEYVALUE_SPLIT);
                C2176ab.m9692d(this.f7349y, this.f7340p, str2);
            } else {
                strM9693e = str;
            }
            i++;
            str = strM9693e;
        }
        if (sb.length() > 0) {
            C2204r.m10007a(this.f7349y, this.f7340p, sb.toString(), j, C4809aa.m18104a().m18121a("chaton_id", ""));
            C2198l.m9957j(this.f7349y, this.f7340p);
            C2198l.m9949d(this.f7349y, this.f7340p);
        }
    }

    /* renamed from: a */
    public static boolean m9146a(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || str.trim().length() <= 0 || (strArrSplit = str.split("\n")) == null || strArrSplit.length <= 4 || TextUtils.isEmpty(strArrSplit[2]) || TextUtils.isEmpty(strArrSplit[3]) || TextUtils.isEmpty(strArrSplit[4])) ? false : true;
    }
}
