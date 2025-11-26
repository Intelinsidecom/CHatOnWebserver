package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p016a.C0296at;
import com.sec.chaton.p016a.C0330c;
import com.sec.chaton.p016a.C0336cf;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p025d.C1304aq;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: MediaChatTask.java */
/* renamed from: com.sec.chaton.d.a.db */
/* loaded from: classes.dex */
public class C1228db extends C1280s {

    /* renamed from: h */
    protected String f4749h;

    /* renamed from: i */
    protected String f4750i;

    /* renamed from: j */
    protected String f4751j;

    /* renamed from: k */
    protected String f4752k;

    /* renamed from: l */
    protected String f4753l;

    /* renamed from: n */
    protected String f4754n;

    /* renamed from: o */
    private String f4755o;

    /* renamed from: p */
    private String f4756p;

    /* renamed from: q */
    private EnumC1455w f4757q;

    /* renamed from: r */
    private EnumC1450r f4758r;

    /* renamed from: s */
    private String f4759s;

    /* renamed from: t */
    private String[] f4760t;

    /* renamed from: u */
    private boolean f4761u;

    /* renamed from: v */
    private String f4762v;

    /* renamed from: w */
    private ContentResolver f4763w;

    /* renamed from: x */
    private String f4764x;

    public C1228db(Handler handler, String str, long j, String str2, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str3, String[] strArr, String str4, boolean z, String str5, String str6, EnumC1751k enumC1751k) {
        super(handler, 1, enumC1751k);
        this.f4756p = str2;
        this.f4755o = str;
        this.f4757q = enumC1455w;
        this.f4758r = enumC1450r;
        this.f4759s = str3;
        this.f4760t = strArr;
        this.f4762v = str4;
        this.f4761u = z;
        this.f4751j = str5;
        this.f4763w = CommonApplication.m11493l().getContentResolver();
        this.f4702f = j;
        this.f4764x = "";
        this.f4752k = str6;
    }

    public C1228db(Handler handler, String str, long j, String str2, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str3, String[] strArr, String str4, boolean z, String str5, String str6, String str7, EnumC1751k enumC1751k) {
        super(handler, 1, enumC1751k);
        this.f4756p = str2;
        this.f4755o = str;
        this.f4757q = enumC1455w;
        this.f4758r = enumC1450r;
        this.f4759s = str3;
        this.f4760t = strArr;
        this.f4762v = str4;
        this.f4761u = z;
        this.f4751j = str5;
        this.f4763w = GlobalApplication.m11493l().getContentResolver();
        this.f4702f = j;
        this.f4764x = "";
        this.f4752k = str6;
        this.f4753l = str7;
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        super.mo5504b();
        String strSubstring = this.f4756p;
        if (this.f4756p != null && this.f4756p.startsWith(".")) {
            strSubstring = this.f4756p.substring(1);
        }
        switch (this.f4757q) {
            case IMAGE:
                this.f4749h = SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
                break;
            case AUDIO:
                this.f4749h = SlookAirButtonRecentMediaAdapter.AUDIO_TYPE;
                break;
            case CALENDAR:
                this.f4749h = "calendar";
                break;
            case CONTACT:
                this.f4749h = "contact";
                break;
            case GEO:
                this.f4749h = "geo";
                break;
            case VIDEO:
                this.f4749h = SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
                break;
            case DOCUMENT:
                this.f4749h = "doc";
                this.f4750i = strSubstring;
                break;
            case FILE:
                this.f4749h = "file";
                this.f4750i = strSubstring;
                break;
            case AMS:
                this.f4749h = "ams";
                break;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.f4757q == EnumC1455w.GEO || this.f4757q == EnumC1455w.ANICON) {
            this.f4764x = this.f4751j;
        } else {
            if (TextUtils.isEmpty(this.f4762v)) {
                return null;
            }
            String str = this.f4752k;
            if (!TextUtils.isEmpty(this.f4753l)) {
                str = this.f4753l;
            }
            if (TextUtils.isEmpty(str)) {
                sb.append(this.f4749h + "\n");
                sb2.append(this.f4749h + "\n");
                if (!TextUtils.isEmpty(strSubstring)) {
                    sb.append(strSubstring + "\n");
                    sb2.append(strSubstring + "\n");
                }
                sb.append(this.f4762v + "\n");
                sb2.append(this.f4762v + "\n");
            } else {
                sb.append("mixed\n");
                sb.append(this.f4749h + "\n");
                sb.append(this.f4762v + "\n");
                sb2.append("mixed\n");
                sb2.append(this.f4749h + "\n");
                sb2.append(this.f4762v + "\n");
            }
            if (this.f4757q == EnumC1455w.CONTACT || this.f4757q == EnumC1455w.CALENDAR || this.f4757q == EnumC1455w.DOCUMENT || this.f4757q == EnumC1455w.FILE) {
                sb.append(this.f4751j);
                sb2.append(this.f4751j);
            }
            if (!TextUtils.isEmpty(str)) {
                sb.append("\n" + str);
                sb2.append("\n" + this.f4752k);
            }
            this.f4764x = sb.toString();
        }
        this.f4750i = this.f4764x;
        if (EnumC1455w.GEO != this.f4757q && EnumC1455w.ANICON != this.f4757q) {
            C1373q.m6162a(this.f4763w, (String) null, (String) null, Long.valueOf(this.f4702f), sb2.toString(), this.f4753l, this.f4758r, C3223ck.m11327a());
            C1756p.m7243b(this.f4755o, this.f4702f, this.f4764x);
        }
        if (this.f4761u) {
            if (C1493a.m6463a("broadcast2_feature") && this.f4758r == EnumC1450r.BROADCAST) {
                this.f4758r = EnumC1450r.BROADCAST2;
            }
            return C1304aq.m5604a().m5608a(this.f4755o, this.f4702f, this.f4757q, this.f4758r, this.f4760t, this.f4764x);
        }
        if (!C1596x.m6753a(this.f4699c)) {
            C1370n.m6126a(this.f4763w, this.f4755o, this.f4699c);
            long jM11148a = C3193bh.m11148a();
            if (this.f4760t == null || this.f4760t.length == 0) {
                this.f4754n = this.f4755o;
            } else {
                this.f4754n = String.valueOf(this.f4760t[0]);
            }
            return C1304aq.m5604a().m5607a(this.f4758r, this.f4755o, this.f4754n, jM11148a, this.f4759s);
        }
        String str2 = "";
        if (this.f4760t != null && this.f4760t.length > 0) {
            str2 = this.f4760t[0];
        }
        return C1304aq.m5604a().m5606a(this.f4702f, this.f4755o, this.f4757q, this.f4758r, this.f4759s, this.f4764x, str2);
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws Resources.NotFoundException, RemoteException, OperationApplicationException {
        super.mo5502a(i, obj, obj);
        C1759s.m7260a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        Message message = new Message();
        if (obj2 != null) {
            C1548ag c1548ag = (C1548ag) obj2;
            switch (c1548ag.m6574b()) {
                case 1:
                    message.what = 106;
                    C0336cf c0336cf = (C0336cf) c1548ag.m6575c();
                    if (C3250y.f11735c) {
                        C3250y.m11453c("[InitChatReply]MsgID : " + c0336cf.m2088d() + ", InboxNO : " + this.f4755o + ", UID : " + C3159aa.m10962a().m10979a("uid", "") + ", ResultCode : " + c0336cf.m2096l().m2494d() + ", ResultMessage : " + c0336cf.m2096l().m2496f() + ", MsgReceivedTime : " + c0336cf.m2092h() + ", ServerInfo(address) : " + (c0336cf.m2094j() != null ? c0336cf.m2094j().m2698d() : "null(broadcast)") + ", ServerInfo(port) : " + (c0336cf.m2094j() != null ? Integer.valueOf(c0336cf.m2094j().m2700f()) : "null(broadcast)") + ", SessionID : " + c0336cf.m2090f(), getClass().getSimpleName());
                    }
                    int iM2494d = c0336cf.m2096l().m2494d();
                    String strM2496f = c0336cf.m2096l().m2496f();
                    if (iM2494d == 1000 || iM2494d == 1001 || iM2494d == 3002) {
                        HashMap map = new HashMap();
                        C3250y.m11453c("buddyname retrieve end", getClass().getSimpleName());
                        C1360d.m6033a(this.f4763w, this.f4760t, map);
                        C3250y.m11453c("participant insert start", getClass().getSimpleName());
                        int length = this.f4760t.length;
                        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                        arrayList.add(C1381y.m6204a(this.f4755o));
                        for (int i2 = 0; i2 < length; i2++) {
                            arrayList.add(C1381y.m6207a(this.f4755o, this.f4760t[i2], (String) map.get(this.f4760t[i2])));
                        }
                        try {
                            if (arrayList.size() > 0) {
                                this.f4763w.applyBatch("com.sec.chaton.provider", arrayList);
                            }
                        } catch (Exception e) {
                            C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                            C3250y.m11453c("Fail to insert participant to DB", getClass().getSimpleName());
                        }
                        C3250y.m11453c("participant insert end", getClass().getSimpleName());
                        C1335m.m5784a((Handler) null, this.f4755o, c0336cf.m2090f(), 0L);
                        C1370n.m6119a(this.f4763w, this.f4755o, c0336cf, this.f4764x, this.f4758r, this.f4760t, this.f4757q);
                        C1373q.m6158a(this.f4763w, Long.valueOf(c0336cf.m2092h()), c0336cf.m2090f(), c0336cf.m2088d(), Long.valueOf(this.f4702f), this.f4760t.length);
                        if (iM2494d == 1001) {
                            String[] strArrSplit = strM2496f.substring(strM2496f.indexOf("[") + 1, strM2496f.indexOf("]")).trim().split(",");
                            ArrayList arrayList2 = new ArrayList();
                            for (String str : strArrSplit) {
                                String strM6220e = C1381y.m6220e(this.f4763w, this.f4755o, str);
                                C3250y.m11453c("1001 error - invalidUserName:" + strM6220e, getClass().getSimpleName());
                                arrayList2.add(strM6220e);
                                C1381y.m6219d(this.f4763w, this.f4755o, str);
                            }
                            C1370n.m6136c(this.f4763w, this.f4755o);
                            message.obj = new C1230dd(this, true, c0336cf.m2090f(), iM2494d, arrayList2, this.f4702f);
                        } else {
                            message.obj = new C1230dd(this, true, c0336cf.m2090f(), iM2494d, this.f4702f);
                        }
                        this.f4698b.sendMessage(message);
                        break;
                    } else {
                        if (iM2494d == 7006) {
                            C1089fd.m5358a().m5362a(this.f4698b, this.f4755o, this.f4758r, c0336cf.m2096l());
                        }
                        message.obj = new C1230dd(this, false, (String) null, iM2494d, this.f4702f);
                        if (iM2494d == 3001) {
                            C1373q.m6156a(this.f4763w, Long.valueOf(this.f4702f), Long.valueOf(C3193bh.m11148a()));
                        } else {
                            C1373q.m6187b(this.f4763w, Long.valueOf(this.f4702f));
                        }
                        if (iM2494d == 6002) {
                            String[] strArrM6217c = C1381y.m6217c(this.f4763w, this.f4755o);
                            ArrayList arrayList3 = new ArrayList();
                            for (String str2 : strArrM6217c) {
                                arrayList3.add(C1381y.m6220e(this.f4763w, this.f4755o, str2));
                            }
                            if (EnumC1450r.m6340a(this.f4758r) && strArrM6217c.length > 0) {
                                m5554a(strArrM6217c, c0336cf.m2092h());
                            }
                            message.obj = new C1230dd(this, false, iM2494d, (ArrayList<String>) arrayList3, this.f4702f);
                        } else if (iM2494d == 7006 && c0336cf.m2096l() != null && c0336cf.m2096l().m2500j() != null) {
                            message.obj = new C1230dd(this, false, iM2494d, c0336cf.m2096l().m2500j(), this.f4702f);
                        }
                        this.f4698b.sendMessage(message);
                        break;
                    }
                    break;
                case 3:
                    message.what = 102;
                    C0330c c0330c = (C0330c) c1548ag.m6575c();
                    if (C3250y.f11735c) {
                        C3250y.m11453c("[AllowChatReply]MsgID : " + c0330c.m1995d() + ", InboxNO : " + this.f4755o + ", UID : " + C3159aa.m10962a().m10979a("uid", "") + ", ResultCode : " + c0330c.m1997f().m2494d() + ", ResultMsg : " + c0330c.m1997f().m2496f(), getClass().getSimpleName());
                    }
                    int iM2494d2 = c0330c.m1997f().m2494d();
                    if (iM2494d2 == 1000 || iM2494d2 == 3003) {
                        message.obj = new C0272i(true, 900, this.f4755o, this.f4702f);
                    } else {
                        if (iM2494d2 == 2006 || iM2494d2 == 3008) {
                            C1370n.m6106a(CommonApplication.m11493l().getContentResolver(), this.f4755o, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                        } else if (iM2494d2 == 7001) {
                            C1089fd.m5358a().m5365a(this.f4755o, this.f4754n, 0L);
                        } else if (iM2494d2 == 7002) {
                            C1089fd.m5358a().m5361a(this.f4698b, this.f4755o, c0330c.m1997f());
                        } else if (iM2494d2 == 7003) {
                            C1089fd.m5358a().m5363a(this.f4755o, c0330c.m1997f());
                        } else {
                            C1373q.m6187b(this.f4763w, Long.valueOf(this.f4702f));
                        }
                        message.obj = new C0272i(false, iM2494d2, this.f4755o, this.f4702f);
                    }
                    this.f4698b.sendMessage(message);
                    break;
                case 5:
                    message.what = 102;
                    C0296at c0296at = (C0296at) c1548ag.m6575c();
                    if (C3250y.f11735c) {
                        C3250y.m11453c("[ChatReply]MsgID : " + c0296at.m1598d() + ", InboxNO : " + this.f4755o + ", UID : " + C3159aa.m10962a().m10979a("uid", "") + ", MsgReceivedTime : " + c0296at.m1604j() + ", SessionID : " + c0296at.m1600f() + ", ResultCode : " + c0296at.m1606l().m2494d() + ", ResultMsg : " + c0296at.m1606l().m2496f() + ", ServerInfo(address) : " + (c0296at.m1602h() != null ? c0296at.m1602h().m2698d() : "null") + ", ServerInfo(port) : " + (c0296at.m1602h() != null ? Integer.valueOf(c0296at.m1602h().m2700f()) : "null"), getClass().getSimpleName());
                    }
                    int iM2494d3 = c0296at.m1606l().m2494d();
                    String strM2496f2 = c0296at.m1606l().m2496f();
                    if (iM2494d3 == 1000 || iM2494d3 == 1001) {
                        C1373q.m6158a(this.f4763w, Long.valueOf(c0296at.m1604j()), c0296at.m1600f(), c0296at.m1598d(), Long.valueOf(this.f4702f), this.f4760t.length);
                        C1370n.m6108a(this.f4763w, C3159aa.m10962a().m10979a("chaton_id", ""), this.f4755o, this.f4750i, c0296at.m1604j(), c0296at.m1600f(), c0296at.m1602h().m2698d(), Integer.valueOf(C3194bi.m11149a().m11154c().m11158b()), Long.valueOf(c0296at.m1598d()), this.f4760t.length, this.f4757q);
                        if (iM2494d3 == 1001) {
                            m5554a(strM2496f2.substring(strM2496f2.indexOf("[") + 1, strM2496f2.indexOf("]")).trim().split(","), c0296at.m1604j());
                        }
                        message.obj = new C0272i(true, iM2494d3, this.f4702f);
                    } else {
                        message.obj = new C0272i(false, iM2494d3, this.f4702f);
                        if (iM2494d3 == 7001) {
                            C1373q.m6187b(this.f4763w, Long.valueOf(this.f4702f));
                            C1089fd.m5358a().m5365a(this.f4755o, this.f4760t[0], c0296at.m1604j());
                        } else if (iM2494d3 == 7002) {
                            C1089fd.m5358a().m5361a(this.f4698b, this.f4755o, c0296at.m1606l());
                        } else if (iM2494d3 == 7003) {
                            C1089fd.m5358a().m5363a(this.f4755o, c0296at.m1606l());
                        } else {
                            C1373q.m6187b(this.f4763w, Long.valueOf(this.f4702f));
                            if (iM2494d3 == 6002) {
                                if (this.f4758r == EnumC1450r.ONETOONE) {
                                    C1370n.m6107a(this.f4763w, this.f4760t[0], C1381y.m6220e(this.f4763w, this.f4755o, this.f4760t[0]), c0296at.m1604j());
                                } else {
                                    m5554a(C1381y.m6217c(this.f4763w, this.f4755o), c0296at.m1604j());
                                }
                            }
                        }
                    }
                    this.f4698b.sendMessage(message);
                    break;
            }
            return;
        }
        if (!mo5503a() || i == 11 || i == 22 || i == 3) {
            if (!this.f4893m.m7198a() && C1589q.m6726a(i)) {
                C1373q.m6155a(this.f4763w, Long.valueOf(this.f4702f));
            } else {
                C1373q.m6187b(this.f4763w, Long.valueOf(this.f4702f));
            }
            if (i == 24 || i == 23 || i == 21) {
                C1370n.m6141e(this.f4763w, this.f4755o);
            }
        }
        message.obj = new C0272i(false, i, this.f4702f);
        this.f4698b.sendMessage(message);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    public boolean mo5503a() {
        if (this.f4893m.m7198a() || !C1757q.m7251b()) {
            return super.mo5503a();
        }
        return false;
    }

    /* renamed from: a */
    private void m5554a(String[] strArr, long j) {
        String strM6220e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (C1381y.m6211a(this.f4763w, str2, this.f4755o)) {
                strM6220e = C1381y.m6220e(this.f4763w, this.f4755o, str2);
                if (TextUtils.isEmpty(strM6220e)) {
                    strM6220e = str;
                }
                C3250y.m11453c("1001 error - invalidUserName:" + strM6220e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.LEAVE.m6248a()), str2, C1075eq.m5318a(strM6220e))).append(Config.KEYVALUE_SPLIT);
                C1381y.m6219d(this.f4763w, this.f4755o, str2);
            } else {
                strM6220e = str;
            }
            i++;
            str = strM6220e;
        }
        if (sb.length() > 0) {
            C1373q.m6166a(this.f4763w, this.f4755o, sb.toString(), j, C3159aa.m10962a().m10979a("chaton_id", ""));
            C1370n.m6143g(this.f4763w, this.f4755o);
            C1370n.m6136c(this.f4763w, this.f4755o);
        }
    }
}
