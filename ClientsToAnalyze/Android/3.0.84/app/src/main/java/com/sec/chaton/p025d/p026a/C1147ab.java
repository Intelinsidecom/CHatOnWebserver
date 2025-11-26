package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.chat.C1072en;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p016a.C0296at;
import com.sec.chaton.p016a.C0330c;
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
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;

/* compiled from: ChatTask.java */
/* renamed from: com.sec.chaton.d.a.ab */
/* loaded from: classes.dex */
public class C1147ab extends C1280s {

    /* renamed from: h */
    private EnumC1455w f4575h;

    /* renamed from: i */
    private EnumC1450r f4576i;

    /* renamed from: j */
    private String f4577j;

    /* renamed from: k */
    private String f4578k;

    /* renamed from: l */
    private String f4579l;

    /* renamed from: n */
    private String f4580n;

    /* renamed from: o */
    private ContentResolver f4581o;

    /* renamed from: p */
    private int f4582p;

    public C1147ab(Handler handler, long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String str3, String[] strArr, EnumC1751k enumC1751k) {
        super(handler, 1, enumC1751k);
        this.f4702f = j;
        this.f4580n = str;
        this.f4575h = enumC1455w;
        this.f4577j = str2;
        this.f4576i = enumC1450r;
        this.f4579l = str3;
        this.f4581o = CommonApplication.m11493l().getContentResolver();
        if (strArr != null && strArr.length > 0) {
            this.f4578k = strArr[0];
            this.f4582p = strArr.length;
        } else {
            this.f4578k = "";
            this.f4582p = 0;
        }
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        String str;
        super.mo5504b();
        if (!C1596x.m6753a(this.f4699c)) {
            C1370n.m6126a(this.f4581o, this.f4580n, this.f4699c);
            long jM11148a = C3193bh.m11148a();
            if (TextUtils.isEmpty(this.f4578k)) {
                str = this.f4580n;
            } else {
                str = this.f4578k;
            }
            C1759s.m7260a("ChatTask", "ConPreExecute(), REQUEST - ALLOW CHAT", new Object[0]);
            return C1304aq.m5604a().m5607a(this.f4576i, this.f4580n, str, jM11148a, this.f4577j);
        }
        C1759s.m7260a("ChatTask", "onPreExecute(), REQUEST - CHAT REQUEST (msgId(%d), chatMsg(%s))", Long.valueOf(this.f4702f), this.f4579l);
        return C1304aq.m5604a().m5606a(this.f4702f, this.f4580n, this.f4575h, this.f4576i, this.f4577j, this.f4579l, this.f4578k);
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        super.mo5502a(i, obj, obj2);
        C1759s.m7260a("ChatTask", "onPostExecute()", new Object[0]);
        Message message = new Message();
        message.what = 4;
        if (obj2 != null) {
            C1548ag c1548ag = (C1548ag) obj2;
            switch (c1548ag.m6574b()) {
                case 3:
                    C0330c c0330c = (C0330c) c1548ag.m6575c();
                    C1072en.m5301a(this.f4580n, c0330c, "ChatTask");
                    int iM2494d = c0330c.m1997f().m2494d();
                    if (iM2494d == 1000 || iM2494d == 3003) {
                        message.obj = new C0272i(true, 900, this.f4580n, this.f4702f);
                        break;
                    } else {
                        if (iM2494d == 7001) {
                            C1089fd.m5358a().m5365a(this.f4580n, this.f4578k, 0L);
                        } else if (iM2494d == 7002) {
                            C1089fd.m5358a().m5361a(this.f4698b, this.f4580n, c0330c.m1997f());
                        } else if (iM2494d == 7003) {
                            C1089fd.m5358a().m5363a(this.f4580n, c0330c.m1997f());
                        } else if (iM2494d == 2006 || iM2494d == 3008) {
                            C1370n.m6106a(CommonApplication.m11493l().getContentResolver(), this.f4580n, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                        } else {
                            C1373q.m6187b(this.f4581o, Long.valueOf(this.f4702f));
                        }
                        message.obj = new C0272i(false, iM2494d, this.f4580n, this.f4702f);
                        break;
                    }
                    break;
                case 5:
                    C0296at c0296at = (C0296at) c1548ag.m6575c();
                    C1072en.m5298a(this.f4580n, c0296at, "ChatTask");
                    int iM2494d2 = c0296at.m1606l().m2494d();
                    String strM2496f = c0296at.m1606l().m2496f();
                    if (iM2494d2 == 1000 || iM2494d2 == 1001) {
                        C1373q.m6158a(this.f4581o, Long.valueOf(c0296at.m1604j()), c0296at.m1600f(), c0296at.m1598d(), Long.valueOf(this.f4702f), this.f4582p);
                        C1370n.m6108a(this.f4581o, C3159aa.m10962a().m10979a("chaton_id", ""), this.f4580n, this.f4579l, c0296at.m1604j(), c0296at.m1600f(), c0296at.m1602h().m2698d(), Integer.valueOf(c0296at.m1602h().m2700f()), Long.valueOf(c0296at.m1598d()), this.f4582p, this.f4575h);
                        if (iM2494d2 == 1001) {
                            m5501a(strM2496f.substring(strM2496f.indexOf("[") + 1, strM2496f.indexOf("]")).trim().split(","), c0296at.m1604j());
                        }
                        message.obj = new C0272i(true, iM2494d2, this.f4702f);
                        break;
                    } else {
                        message.obj = new C0272i(false, iM2494d2, this.f4702f);
                        if (iM2494d2 == 7001) {
                            C1373q.m6187b(this.f4581o, Long.valueOf(this.f4702f));
                            C1089fd.m5358a().m5365a(this.f4580n, this.f4578k, c0296at.m1604j());
                            break;
                        } else if (iM2494d2 == 7002) {
                            C1089fd.m5358a().m5361a(this.f4698b, this.f4580n, c0296at.m1606l());
                            break;
                        } else if (iM2494d2 == 7003) {
                            C1089fd.m5358a().m5363a(this.f4580n, c0296at.m1606l());
                            break;
                        } else {
                            C1373q.m6187b(this.f4581o, Long.valueOf(this.f4702f));
                            if (iM2494d2 == 6002) {
                                if (this.f4576i == EnumC1450r.ONETOONE) {
                                    C1370n.m6107a(this.f4581o, this.f4578k, C1381y.m6220e(this.f4581o, this.f4580n, this.f4578k), c0296at.m1604j());
                                    break;
                                } else {
                                    m5501a(C1381y.m6217c(this.f4581o, this.f4580n), c0296at.m1604j());
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            this.f4698b.sendMessage(message);
            return;
        }
        C1072en.m5296a(5, this.f4580n, i, this.f4702f, this.f4577j, "ChatTask");
        if (!mo5503a() || i == 11 || i == 22 || i == 3) {
            if (!this.f4893m.m7198a() && C1589q.m6726a(i)) {
                C1373q.m6155a(this.f4581o, Long.valueOf(this.f4702f));
            } else {
                C1373q.m6187b(this.f4581o, Long.valueOf(this.f4702f));
            }
            if (C1589q.m6727b(i)) {
                C1370n.m6141e(this.f4581o, this.f4580n);
            }
        }
        message.obj = new C0272i(false, i, this.f4702f);
        this.f4698b.sendMessage(message);
    }

    /* renamed from: a */
    private void m5501a(String[] strArr, long j) {
        String strM6220e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (C1381y.m6211a(this.f4581o, str2, this.f4580n)) {
                strM6220e = C1381y.m6220e(this.f4581o, this.f4580n, str2);
                if (TextUtils.isEmpty(strM6220e)) {
                    strM6220e = str;
                }
                C3250y.m11453c("1001 error - invalidUserName:" + strM6220e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.LEAVE.m6248a()), str2, C1075eq.m5318a(strM6220e))).append(Config.KEYVALUE_SPLIT);
                C1381y.m6219d(this.f4581o, this.f4580n, str2);
            } else {
                strM6220e = str;
            }
            i++;
            str = strM6220e;
        }
        if (sb.length() > 0) {
            C1373q.m6166a(this.f4581o, this.f4580n, sb.toString(), j, C3159aa.m10962a().m10979a("chaton_id", ""));
            C1370n.m6143g(this.f4581o, this.f4580n);
            C1370n.m6136c(this.f4581o, this.f4580n);
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
