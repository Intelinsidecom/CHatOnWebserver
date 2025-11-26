package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1753gz;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.C2695c;
import com.sec.chaton.msgsend.C2696d;
import com.sec.chaton.msgsend.EnumC2692aj;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p046a.C0927f;
import com.sec.chaton.p046a.C0944fq;
import com.sec.chaton.p046a.C0953fz;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.C2096bb;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
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
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import com.sec.common.util.log.collector.C5043h;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SerialChatTask.java */
/* renamed from: com.sec.chaton.d.a.ek */
/* loaded from: classes.dex */
public class C2019ek extends C2055n {

    /* renamed from: h */
    protected static final String f7404h = C2019ek.class.getSimpleName();

    /* renamed from: i */
    protected EnumC2300t f7405i;

    /* renamed from: j */
    protected String f7406j;

    /* renamed from: k */
    protected String f7407k;

    /* renamed from: l */
    protected String[] f7408l;

    /* renamed from: n */
    protected C2695c f7409n;

    /* renamed from: o */
    protected C2695c f7410o;

    /* renamed from: p */
    protected String f7411p;

    /* renamed from: q */
    protected ContentResolver f7412q;

    /* renamed from: r */
    protected int f7413r;

    /* renamed from: s */
    protected long f7414s;

    /* renamed from: a */
    public int m9157a(long j) {
        return this.f7410o.m11304a(j);
    }

    public C2019ek(Handler handler, long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String str3, String[] strArr, EnumC2706n enumC2706n) {
        super(handler, 1, enumC2706n);
        m9155a(j, str, enumC2300t, str2, strArr, C2695c.m11303a().m11305a(j, enumC2214ab, str3));
    }

    public C2019ek(Handler handler, long j, String str, EnumC2300t enumC2300t, String str2, String[] strArr, C2695c c2695c, EnumC2706n enumC2706n) {
        super(handler, 1, enumC2706n);
        m9155a(j, str, enumC2300t, str2, strArr, c2695c);
    }

    /* renamed from: a */
    private void m9155a(long j, String str, EnumC2300t enumC2300t, String str2, String[] strArr, C2695c c2695c) {
        this.f7190f = j;
        this.f7411p = str;
        this.f7406j = str2;
        this.f7405i = enumC2300t;
        this.f7409n = c2695c;
        this.f7410o = c2695c;
        this.f7408l = strArr;
        this.f7412q = GlobalApplication.m18732r().getContentResolver();
        if (strArr != null && strArr.length > 0) {
            this.f7407k = strArr[0];
            this.f7413r = strArr.length;
        } else {
            this.f7407k = "";
            this.f7413r = 0;
        }
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        String str;
        super.mo9093b();
        C2684ab.m11290a(getClass().getSimpleName(), "onPreExecute()", new Object[0]);
        if (!C2417af.m10450a(this.f7187c)) {
            C2198l.m9929a(this.f7412q, this.f7411p, this.f7187c);
            if (TextUtils.isEmpty(this.f7407k)) {
                str = this.f7411p;
            } else {
                str = this.f7407k;
            }
            C2684ab.m11290a(getClass().getSimpleName(), "onPreExecute(), REQUEST - ALLOW CHAT", new Object[0]);
            return C2096bb.m9360a().m9363a(this.f7405i, this.f7411p, str, C4843bh.m18322a(), this.f7406j);
        }
        this.f7414s = System.currentTimeMillis();
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12719a(this, this.f7414s);
        }
        C2684ab.m11290a(getClass().getSimpleName(), "onPreExecute(), REQUEST - SERIAL CHAT REQUEST (taskId(%d))", Long.valueOf(this.f7190f));
        for (C2696d c2696d : this.f7409n.m11307b()) {
            C2684ab.m11290a(getClass().getSimpleName(), "  -- msgId(%d), msgType(%s), chatMsg(%s)", Long.valueOf(c2696d.m11311c()), c2696d.m11310b(), c2696d.m11309a());
            if (C2349a.m10301a("chaton_qmlog_sending")) {
                C3119a.m12716a().m12720a(this, c2696d.m11311c(), c2696d.m11309a().length());
            }
        }
        return C2096bb.m9360a().m9362a(this.f7190f, this.f7411p, this.f7405i, this.f7406j, this.f7407k, this.f7409n);
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) throws Throwable {
        List<String> listM5236k;
        String strM8702a;
        super.mo9092a(i, obj, obj2);
        C2684ab.m11290a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        if (obj2 != null) {
            C2426ao c2426ao = (C2426ao) obj2;
            switch (c2426ao.m10512b()) {
                case 3:
                    Message message = new Message();
                    message.what = 4;
                    C0927f c0927f = (C0927f) c2426ao.m10513c();
                    if (this.f7405i == EnumC2300t.TOPIC) {
                        C2176ab.m9679a(c0927f, this.f7411p, this.f7406j);
                    } else {
                        C2176ab.m9686b(c0927f, this.f7411p, this.f7406j);
                    }
                    C1734gg.m8603a(this.f7411p, c0927f, f7404h);
                    int iM5229d = c0927f.m5085f().m5229d();
                    if (iM5229d == 1000 || iM5229d == 3003) {
                        message.obj = new C0788l(true, 900, this.f7411p, this.f7190f);
                    } else {
                        if (iM5229d == 7001) {
                            C1753gz.m8698a().m8706a(this.f7411p, this.f7407k, 0L);
                            strM8702a = null;
                        } else if (iM5229d == 7002) {
                            strM8702a = C1753gz.m8698a().m8701a(this.f7186b, this.f7411p, c0927f.m5085f());
                        } else if (iM5229d == 7003) {
                            strM8702a = C1753gz.m8698a().m8702a(this.f7411p, c0927f.m5085f());
                        } else if (iM5229d == 2006 || iM5229d == 3008) {
                            C2198l.m9909a(GlobalApplication.m18732r().getContentResolver(), this.f7411p, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                            strM8702a = null;
                        } else {
                            C2204r.m9998a(this.f7412q, this.f7409n, EnumC2692aj.FAILED);
                            strM8702a = null;
                        }
                        message.obj = new C0788l(false, iM5229d, this.f7411p, this.f7190f);
                        if (!TextUtils.isEmpty(strM8702a)) {
                            this.f7407k = strM8702a;
                        }
                        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7411p}));
                    }
                    this.f7186b.sendMessage(message);
                    break;
                case 28:
                    C0944fq c0944fq = (C0944fq) c2426ao.m10513c();
                    long jM5352d = c0944fq.m5352d();
                    String strM5354f = c0944fq.m5354f();
                    String strM5561d = null;
                    Integer numValueOf = null;
                    if (c0944fq.m5357i() != null) {
                        strM5561d = c0944fq.m5357i().m5561d();
                        numValueOf = Integer.valueOf(c0944fq.m5357i().m5563f());
                    }
                    List<C0953fz> listM5355g = c0944fq.m5355g();
                    Object[] array = this.f7409n.m11307b().toArray();
                    if (array == null || array.length <= 0) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("exception. localChatMsgList is null or empty. > " + array, f7404h);
                            break;
                        }
                    } else {
                        C2020el c2020el = new C2020el(this);
                        int i2 = 0;
                        int i3 = -1;
                        for (C0953fz c0953fz : listM5355g) {
                            Message message2 = new Message();
                            message2.what = 4;
                            long jM5503d = c0953fz.m5503d();
                            long jM5505f = c0953fz.m5505f();
                            C2696d c2696d = (C2696d) array[i2];
                            String strM11309a = c2696d.m11309a();
                            long jM11311c = c2696d.m11311c();
                            EnumC2214ab enumC2214abM11310b = c2696d.m11310b();
                            if (C4904y.f17873c) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("[SerialChatReply]").append(", ").append("[" + (i2 + 1) + "/" + listM5355g.size() + "]").append("Time : " + System.currentTimeMillis()).append(", ").append("ResultMessage : ").append(c0953fz.m5507h().m5231f()).append(", ").append("ResultCode : ").append(c0953fz.m5507h().m5229d()).append(", ").append("MsgID : ").append(jM5503d).append(", ").append("RequestID : ").append(jM5352d).append(", ").append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNO : ").append(this.f7411p).append(", ").append("SessionID : ").append(strM5354f).append(", ").append("Server_address : ").append(strM5561d != null ? strM5561d : "null").append(", ").append("Server_port : ").append(numValueOf != null ? numValueOf : "null").append(", ").append("ReceivedTime : ").append(jM5505f);
                                C4904y.m18641c(sb.toString(), f7404h);
                            }
                            int iM5229d2 = c0953fz.m5507h().m5229d();
                            String strM5231f = c0953fz.m5507h().m5231f();
                            int i4 = iM5229d2 == 5100 ? i3 : iM5229d2;
                            if (iM5229d2 == 1000 || iM5229d2 == 1001) {
                                c2020el.m9160a(C2204r.m10044b(this.f7412q, Long.valueOf(jM5505f), strM5354f, jM5503d, Long.valueOf(jM11311c), this.f7413r));
                                c2020el.m9161a(this.f7412q, C4809aa.m18104a().m18121a("chaton_id", ""), this.f7411p, strM11309a, jM5505f, strM5354f, strM5561d, numValueOf, Long.valueOf(jM5503d), this.f7413r, enumC2214abM11310b);
                                if (iM5229d2 == 1001) {
                                    m9158a(strM5231f.substring(strM5231f.indexOf("[") + 1, strM5231f.indexOf("]")).trim().split(","), c0953fz.m5505f());
                                    if (this.f7405i == EnumC2300t.BROADCAST2 && (listM5236k = c0953fz.m5507h().m5236k()) != null) {
                                        if (C4904y.f17873c) {
                                            C4904y.m18641c("1001 error blockedReciversList : " + listM5236k.toString(), f7404h);
                                        }
                                        if (this.f7408l != null && this.f7408l.length > listM5236k.size()) {
                                            String[] strArr = this.f7408l;
                                            int length = strArr.length;
                                            int i5 = 0;
                                            while (true) {
                                                if (i5 < length) {
                                                    String str = strArr[i5];
                                                    if (listM5236k.contains(str)) {
                                                        i5++;
                                                    } else {
                                                        this.f7407k = str;
                                                    }
                                                }
                                            }
                                        } else {
                                            this.f7407k = "";
                                        }
                                        if (this.f7191g == null) {
                                            this.f7191g = C2142w.m9593a(this.f7411p, this.f7405i);
                                        }
                                        this.f7191g.mo9241a(strM5354f, new String[]{this.f7407k}, (String[]) listM5236k.toArray(new String[0]), false);
                                    }
                                }
                                message2.obj = new C0788l(true, iM5229d2, jM11311c);
                            } else {
                                ArrayList<ContentProviderOperation> arrayListM9159a = c2020el.m9159a();
                                if (arrayListM9159a != null) {
                                    try {
                                        GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayListM9159a);
                                    } catch (OperationApplicationException e) {
                                        if (C4904y.f17875e) {
                                            C4904y.m18635a(e, f7404h);
                                        }
                                    } catch (RemoteException e2) {
                                        if (C4904y.f17875e) {
                                            C4904y.m18635a(e2, f7404h);
                                        }
                                    }
                                }
                                c2020el.m9162b();
                                String strM8702a2 = null;
                                message2.obj = new C0788l(false, iM5229d2, jM11311c, i4);
                                if (iM5229d2 == 7001) {
                                    C2204r.m10041b(this.f7412q, Long.valueOf(jM11311c));
                                    C1753gz.m8698a().m8706a(this.f7411p, this.f7407k, c0953fz.m5505f());
                                } else if (iM5229d2 == 7002) {
                                    strM8702a2 = C1753gz.m8698a().m8701a(this.f7186b, this.f7411p, c0953fz.m5507h());
                                } else if (iM5229d2 == 7003) {
                                    strM8702a2 = C1753gz.m8698a().m8702a(this.f7411p, c0953fz.m5507h());
                                } else if (iM5229d2 == 5100) {
                                    if (i4 == 7001) {
                                        C2204r.m10041b(this.f7412q, Long.valueOf(jM11311c));
                                    } else if (i4 != 7002 && i4 != 7003) {
                                        C2204r.m10041b(this.f7412q, Long.valueOf(jM11311c));
                                    }
                                } else {
                                    C2204r.m10041b(this.f7412q, Long.valueOf(jM11311c));
                                    if (iM5229d2 == 6002) {
                                        if (this.f7405i == EnumC2300t.ONETOONE) {
                                            C2198l.m9910a(this.f7412q, this.f7407k, C2176ab.m9693e(this.f7412q, this.f7411p, this.f7407k), c0953fz.m5505f());
                                        } else {
                                            m9158a(C2176ab.m9689c(this.f7412q, this.f7411p), c0953fz.m5505f());
                                        }
                                    }
                                }
                                if (!TextUtils.isEmpty(strM8702a2)) {
                                    this.f7407k = strM8702a2;
                                }
                            }
                            this.f7186b.sendMessage(message2);
                            i3 = i4;
                            i2++;
                        }
                        ArrayList<ContentProviderOperation> arrayListM9159a2 = c2020el.m9159a();
                        if (arrayListM9159a2 != null) {
                            try {
                                GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayListM9159a2);
                            } catch (OperationApplicationException e3) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e3, f7404h);
                                }
                            } catch (RemoteException e4) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e4, f7404h);
                                }
                            }
                        }
                        c2020el.m9162b();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        m9156b(jCurrentTimeMillis);
                        if (C2349a.m10301a("chaton_qmlog_sending")) {
                            C3119a.m12716a().m12721a(this, EnumC3124f.SEND, jCurrentTimeMillis);
                        }
                        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7411p}));
                        break;
                    }
                    break;
            }
            return;
        }
        if (C4904y.f17873c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[SerialChatReply]").append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("ResultMessage : ").append("Fail").append(", ").append("ResultCode : ").append(i).append(", ").append("RequestID : ").append(this.f7190f).append(", ").append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNO : ").append(this.f7411p).append(", ").append("SessionID : ").append(this.f7406j).append(", ").append("Server_address : ").append("null").append(", ").append("Server_port : ").append("null").append(", ").append("ReceivedTime : ").append("");
            C4904y.m18641c(sb2.toString(), f7404h);
        }
        if (!mo9104a() || i == 11 || i == 22 || i == 3) {
            if (!this.f7515m.m11326a() && C2466q.m10670a(i)) {
                C2204r.m9998a(this.f7412q, this.f7409n, EnumC2692aj.PENDING);
            } else {
                C2204r.m9998a(this.f7412q, this.f7409n, EnumC2692aj.FAILED);
            }
            m9192a(i, this.f7411p);
        }
        for (C2696d c2696d2 : this.f7409n.m11307b()) {
            Message message3 = new Message();
            message3.what = 4;
            message3.obj = new C0788l(false, i, c2696d2.m11311c());
            this.f7186b.sendMessage(message3);
        }
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12721a(this, EnumC3124f.SEND, -1L);
        }
        m9156b(-1L);
    }

    /* renamed from: b */
    private void m9156b(long j) {
        String str = "transferfail";
        long j2 = j - this.f7414s;
        if (0 < j2 && j2 <= 3000) {
            str = "1sectorcount";
        } else if (3000 < j2 && j2 <= 6000) {
            str = "2sectorcount";
        } else if (6000 < j2 && j2 <= 9000) {
            str = "3sectorcount";
        } else if (9000 < j2 && j2 <= 12000) {
            str = "4sectorcount";
        } else if (12000 < j2 && j2 <= 15000) {
            str = "5sectorcount";
        } else if (15000 < j2 && j2 <= 20000) {
            str = "6sectorcount";
        }
        C5043h.m19179a().m19182a(str);
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("writeTimeMessageSentToLog - Sector : ", str), f7404h);
        }
    }

    /* renamed from: a */
    protected void m9158a(String[] strArr, long j) {
        String strM9693e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (C2176ab.m9681a(this.f7412q, str2, this.f7411p)) {
                strM9693e = C2176ab.m9693e(this.f7412q, this.f7411p, str2);
                if (TextUtils.isEmpty(strM9693e)) {
                    strM9693e = str;
                }
                C4904y.m18641c("1001 error - invalidUserName:" + strM9693e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.LEAVE.m10100a()), str2, C1736gi.m8632a(strM9693e))).append(Config.KEYVALUE_SPLIT);
                C2176ab.m9692d(this.f7412q, this.f7411p, str2);
            } else {
                strM9693e = str;
            }
            i++;
            str = strM9693e;
        }
        if (sb.length() > 0) {
            C2204r.m10007a(this.f7412q, this.f7411p, sb.toString(), j, C4809aa.m18104a().m18121a("chaton_id", ""));
            C2198l.m9957j(this.f7412q, this.f7411p);
            C2198l.m9949d(this.f7412q, this.f7411p);
        }
    }
}
