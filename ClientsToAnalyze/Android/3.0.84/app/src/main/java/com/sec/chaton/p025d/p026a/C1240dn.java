package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1740a;
import com.sec.chaton.msgsend.C1742b;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1741aa;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p016a.C0330c;
import com.sec.chaton.p016a.C0372do;
import com.sec.chaton.p016a.C0381dx;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p025d.C1304aq;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.util.List;

/* compiled from: SerialChatTask.java */
/* renamed from: com.sec.chaton.d.a.dn */
/* loaded from: classes.dex */
public class C1240dn extends C1280s {

    /* renamed from: h */
    private static final String f4795h = C1240dn.class.getSimpleName();

    /* renamed from: i */
    private EnumC1450r f4796i;

    /* renamed from: j */
    private String f4797j;

    /* renamed from: k */
    private String f4798k;

    /* renamed from: l */
    private C1740a f4799l;

    /* renamed from: n */
    private C1740a f4800n;

    /* renamed from: o */
    private String f4801o;

    /* renamed from: p */
    private ContentResolver f4802p;

    /* renamed from: q */
    private int f4803q;

    /* renamed from: a */
    public int m5560a(long j) {
        return this.f4800n.m7152a(j);
    }

    public C1240dn(Handler handler, long j, String str, EnumC1450r enumC1450r, String str2, String[] strArr, C1740a c1740a, EnumC1751k enumC1751k) {
        super(handler, 1, enumC1751k);
        this.f4702f = j;
        this.f4801o = str;
        this.f4797j = str2;
        this.f4796i = enumC1450r;
        this.f4799l = c1740a;
        this.f4800n = c1740a;
        this.f4802p = GlobalApplication.m11493l().getContentResolver();
        if (strArr != null && strArr.length > 0) {
            this.f4798k = strArr[0];
            this.f4803q = strArr.length;
        } else {
            this.f4798k = "";
            this.f4803q = 0;
        }
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        String str;
        super.mo5504b();
        C1759s.m7260a(getClass().getSimpleName(), "onPreExecute()", new Object[0]);
        if (!C1596x.m6753a(this.f4699c)) {
            C1370n.m6126a(this.f4802p, this.f4801o, this.f4699c);
            if (TextUtils.isEmpty(this.f4798k)) {
                str = this.f4801o;
            } else {
                str = this.f4798k;
            }
            C1759s.m7260a(getClass().getSimpleName(), "onPreExecute(), REQUEST - ALLOW CHAT", new Object[0]);
            return C1304aq.m5604a().m5607a(this.f4796i, this.f4801o, str, C3193bh.m11148a(), this.f4797j);
        }
        C1759s.m7260a(getClass().getSimpleName(), "onPreExecute(), REQUEST - SERIAL CHAT REQUEST (taskId(%d))", Long.valueOf(this.f4702f));
        for (C1742b c1742b : this.f4799l.m7154b()) {
            C1759s.m7260a(getClass().getSimpleName(), "  -- msgId(%d), msgType(%s), chatMsg(%s)", Long.valueOf(c1742b.m7160c()), c1742b.m7159b(), c1742b.m7158a());
        }
        return C1304aq.m5604a().m5605a(this.f4702f, this.f4801o, this.f4796i, this.f4797j, this.f4798k, this.f4799l);
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        int i2;
        int i3;
        super.mo5502a(i, obj, obj2);
        C1759s.m7260a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        if (obj2 != null) {
            C1548ag c1548ag = (C1548ag) obj2;
            switch (c1548ag.m6574b()) {
                case 3:
                    Message message = new Message();
                    message.what = 4;
                    C0330c c0330c = (C0330c) c1548ag.m6575c();
                    if (C3250y.f11735c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[AllowChatReply]").append("InboxNO : ").append(this.f4801o).append(", ").append("MsgID : ").append(c0330c.m1995d()).append(", ").append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("SessionID : ").append(this.f4797j).append(", ").append("ResultCode : ").append(c0330c.m1997f().m2494d()).append(", ").append("ResultMsg : ").append(c0330c.m1997f().m2496f());
                        C3250y.m11453c(sb.toString(), f4795h);
                    }
                    int iM2494d = c0330c.m1997f().m2494d();
                    if (iM2494d == 1000 || iM2494d == 3003) {
                        message.obj = new C0272i(true, 900, this.f4801o, this.f4702f);
                        break;
                    } else {
                        if (iM2494d == 7001) {
                            C1089fd.m5358a().m5365a(this.f4801o, this.f4798k, 0L);
                        } else if (iM2494d == 7002) {
                            C1089fd.m5358a().m5361a(this.f4698b, this.f4801o, c0330c.m1997f());
                        } else if (iM2494d == 7003) {
                            C1089fd.m5358a().m5363a(this.f4801o, c0330c.m1997f());
                        } else if (iM2494d == 2006 || iM2494d == 3008) {
                            C1370n.m6106a(GlobalApplication.m11493l().getContentResolver(), this.f4801o, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                        } else {
                            C1373q.m6154a(this.f4802p, this.f4799l, EnumC1741aa.FAILED);
                        }
                        message.obj = new C0272i(false, iM2494d, this.f4801o, this.f4702f);
                        break;
                    }
                    break;
                case 28:
                    C0372do c0372do = (C0372do) c1548ag.m6575c();
                    long jM2536d = c0372do.m2536d();
                    String strM2538f = c0372do.m2538f();
                    String strM2698d = null;
                    Integer numValueOf = null;
                    if (c0372do.m2541i() != null) {
                        strM2698d = c0372do.m2541i().m2698d();
                        numValueOf = Integer.valueOf(c0372do.m2541i().m2700f());
                    }
                    List<C0381dx> listM2539g = c0372do.m2539g();
                    Object[] array = this.f4799l.m7154b().toArray();
                    int i4 = 0;
                    int i5 = -1;
                    for (C0381dx c0381dx : listM2539g) {
                        Message message2 = new Message();
                        message2.what = 4;
                        long jM2666d = c0381dx.m2666d();
                        long jM2668f = c0381dx.m2668f();
                        C1742b c1742b = (C1742b) array[i4];
                        String strM7158a = c1742b.m7158a();
                        long jM7160c = c1742b.m7160c();
                        EnumC1455w enumC1455wM7159b = c1742b.m7159b();
                        if (C3250y.f11735c) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[SerialChatReply]").append(", ").append("[" + (i4 + 1) + "/" + listM2539g.size() + "]").append("Time : " + System.currentTimeMillis()).append(", ").append("ResultMessage : ").append(c0381dx.m2670h().m2496f()).append(", ").append("ResultCode : ").append(c0381dx.m2670h().m2494d()).append(", ").append("MsgID : ").append(jM2666d).append(", ").append("RequestID : ").append(jM2536d).append(", ").append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNO : ").append(this.f4801o).append(", ").append("SessionID : ").append(strM2538f).append(", ").append("Server_address : ").append(strM2698d != null ? strM2698d : "null").append(", ").append("Server_port : ").append(numValueOf != null ? numValueOf : "null").append(", ").append("ReceivedTime : ").append(jM2668f);
                            C3250y.m11453c(sb2.toString(), f4795h);
                        }
                        int iM2494d2 = c0381dx.m2670h().m2494d();
                        String strM2496f = c0381dx.m2670h().m2496f();
                        if (iM2494d2 != 5100) {
                            i2 = iM2494d2;
                            i3 = iM2494d2;
                        } else if (i5 >= 0) {
                            i2 = i5;
                            i3 = i5;
                        } else {
                            i2 = iM2494d2;
                            i3 = i5;
                        }
                        if (i2 == 1000 || i2 == 1001) {
                            C1373q.m6158a(this.f4802p, Long.valueOf(jM2668f), strM2538f, jM2666d, Long.valueOf(jM7160c), this.f4803q);
                            C1370n.m6108a(this.f4802p, C3159aa.m10962a().m10979a("chaton_id", ""), this.f4801o, strM7158a, jM2668f, strM2538f, strM2698d, numValueOf, Long.valueOf(jM2666d), this.f4803q, enumC1455wM7159b);
                            if (i2 == 1001) {
                                m5559a(strM2496f.substring(strM2496f.indexOf("[") + 1, strM2496f.indexOf("]")).trim().split(","), c0381dx.m2668f());
                            }
                            message2.obj = new C0272i(true, i2, jM7160c);
                        } else {
                            message2.obj = new C0272i(false, i2, jM7160c);
                            if (i2 == 7001) {
                                C1373q.m6187b(this.f4802p, Long.valueOf(jM7160c));
                                C1089fd.m5358a().m5365a(this.f4801o, this.f4798k, c0381dx.m2668f());
                            } else if (i2 == 7002) {
                                C1089fd.m5358a().m5361a(this.f4698b, this.f4801o, c0381dx.m2670h());
                            } else if (i2 == 7003) {
                                C1089fd.m5358a().m5363a(this.f4801o, c0381dx.m2670h());
                            } else {
                                C1373q.m6187b(this.f4802p, Long.valueOf(jM7160c));
                                if (i2 == 6002) {
                                    if (this.f4796i == EnumC1450r.ONETOONE) {
                                        C1370n.m6107a(this.f4802p, this.f4798k, C1381y.m6220e(this.f4802p, this.f4801o, this.f4798k), c0381dx.m2668f());
                                    } else {
                                        m5559a(C1381y.m6217c(this.f4802p, this.f4801o), c0381dx.m2668f());
                                    }
                                }
                            }
                        }
                        this.f4698b.sendMessage(message2);
                        i5 = i3;
                        i4++;
                    }
                    break;
            }
            return;
        }
        if (C3250y.f11735c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[SerialChatReply]").append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("ResultMessage : ").append("Fail").append(", ").append("ResultCode : ").append(i).append(", ").append("RequestID : ").append(this.f4702f).append(", ").append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNO : ").append(this.f4801o).append(", ").append("SessionID : ").append(this.f4797j).append(", ").append("Server_address : ").append("null").append(", ").append("Server_port : ").append("null").append(", ").append("ReceivedTime : ").append("");
            C3250y.m11453c(sb3.toString(), f4795h);
        }
        if (!mo5503a() || i == 11 || i == 22 || i == 3) {
            if (!this.f4893m.m7198a() && C1589q.m6726a(i)) {
                C1373q.m6154a(this.f4802p, this.f4799l, EnumC1741aa.PENDING);
            } else {
                C1373q.m6154a(this.f4802p, this.f4799l, EnumC1741aa.FAILED);
            }
            if (i == 24 || i == 23 || i == 21) {
                C1370n.m6141e(this.f4802p, this.f4801o);
            }
        }
        for (C1742b c1742b2 : this.f4799l.m7154b()) {
            Message message3 = new Message();
            message3.what = 4;
            message3.obj = new C0272i(false, i, c1742b2.m7160c());
            this.f4698b.sendMessage(message3);
        }
    }

    /* renamed from: a */
    private void m5559a(String[] strArr, long j) {
        String strM6220e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (C1381y.m6211a(this.f4802p, str2, this.f4801o)) {
                strM6220e = C1381y.m6220e(this.f4802p, this.f4801o, str2);
                if (TextUtils.isEmpty(strM6220e)) {
                    strM6220e = str;
                }
                C3250y.m11453c("1001 error - invalidUserName:" + strM6220e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.LEAVE.m6248a()), str2, C1075eq.m5318a(strM6220e))).append(Config.KEYVALUE_SPLIT);
                C1381y.m6219d(this.f4802p, this.f4801o, str2);
            } else {
                strM6220e = str;
            }
            i++;
            str = strM6220e;
        }
        if (sb.length() > 0) {
            C1373q.m6166a(this.f4802p, this.f4801o, sb.toString(), j, C3159aa.m10962a().m10979a("chaton_id", ""));
            C1370n.m6143g(this.f4802p, this.f4801o);
            C1370n.m6136c(this.f4802p, this.f4801o);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    public boolean mo5503a() {
        if (this.f4893m.m7198a() || !C1757q.m7251b()) {
            return super.mo5503a();
        }
        return false;
    }
}
