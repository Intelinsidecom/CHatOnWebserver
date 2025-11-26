package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0263ac;
import com.sec.chaton.p015b.C0267ag;
import com.sec.chaton.p015b.C0295bh;
import com.sec.chaton.p015b.C0300bm;
import com.sec.chaton.p015b.C0331e;
import com.sec.chaton.p015b.C0339m;
import com.sec.chaton.p015b.EnumC0323ci;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;

/* compiled from: EndChatTask.java */
/* renamed from: com.sec.chaton.a.a.al */
/* loaded from: classes.dex */
public class C0136al extends AbstractC0164c {

    /* renamed from: h */
    private EnumC0665r f322h;

    /* renamed from: i */
    private String f323i;

    /* renamed from: j */
    private String[] f324j;

    /* renamed from: k */
    private String f325k;

    /* renamed from: l */
    private ContentResolver f326l;

    public C0136al(Handler handler, EnumC0665r enumC0665r, String str, String str2, String[] strArr) {
        super(handler);
        this.f322h = enumC0665r;
        this.f323i = str;
        this.f325k = str2;
        this.f324j = strArr;
        this.f326l = GlobalApplication.m3100a().getContentResolver();
        this.f391f = -1L;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        if (!C0477ab.m2446a(this.f388c)) {
            C0634n.m2905a(this.f326l, this.f325k, this.f388c);
            long jM4591a = C1325bu.m4591a();
            C0295bh c0295bhNewBuilder = C0331e.newBuilder();
            c0295bhNewBuilder.m1322a(jM4591a).m1324a(EnumC0323ci.m1750a(this.f322h.m3012a())).m1331d(C1323bs.m4575a().getString("uid", "")).m1333e(C1336k.m4621a()).m1329c(C1323bs.m4575a().getString("msisdn", ""));
            if (this.f324j == null || this.f324j.length == 0) {
                c0295bhNewBuilder.m1328b(this.f325k);
            } else {
                c0295bhNewBuilder.m1328b(String.valueOf(this.f324j[0]));
            }
            if (!TextUtils.isEmpty(this.f323i)) {
                c0295bhNewBuilder.m1326a(this.f323i);
            }
            C1341p.m4660c("ch@t[AllowChatRequest]UID : " + C1323bs.m4575a().getString("uid", "") + ", ChatType : " + c0295bhNewBuilder.m1336g() + ", MsgID : " + c0295bhNewBuilder.m1335f() + ", Receiver : " + c0295bhNewBuilder.m1339j() + ", Sender : " + c0295bhNewBuilder.m1338i() + ", SessionID : " + c0295bhNewBuilder.m1337h(), getClass().getSimpleName());
            C0507n c0507n = new C0507n();
            c0507n.m2556a(2).m2558a(c0295bhNewBuilder.build()).m2557a(30000L);
            return c0507n.m2561b();
        }
        C1341p.m4658b("EndChatTask", "EndChat Start, chatType : " + this.f322h.toString() + "InBonxNO : " + this.f325k + ", SessionID : " + this.f323i);
        if (this.f391f == -1) {
            this.f391f = C1325bu.m4591a();
        }
        C0300bm c0300bmM1420c = C0267ag.newBuilder().m1412a(this.f391f).m1415a(EnumC0323ci.m1750a(this.f322h.m3012a())).m1416a(this.f323i).m1418b(C1323bs.m4575a().getString("uid", "")).m1420c(C1323bs.m4575a().getString("msisdn", ""));
        if (this.f324j != null && this.f324j.length > 0) {
            c0300bmM1420c.m1422d(this.f324j[0]);
        }
        C1341p.m4660c("ch@t[" + c0300bmM1420c.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", ChatType : " + c0300bmM1420c.m1425g() + ", MsgID : " + c0300bmM1420c.m1424f() + ", Receivers : " + C1341p.m4646a(c0300bmM1420c.m1428j()) + ", Sender : " + c0300bmM1420c.m1427i() + ", SessionID : " + c0300bmM1420c.m1426h(), getClass().getSimpleName());
        return new C0507n().m2558a(c0300bmM1420c.build()).m2556a(8).m2557a(30000L).m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 8;
        if (obj2 != null) {
            C0510q c0510q = (C0510q) obj2;
            switch (c0510q.m2573b()) {
                case 3:
                    C0263ac c0263ac = (C0263ac) c0510q.m2574c();
                    C1341p.m4660c("ch@t[" + c0263ac.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + c0263ac.m992d() + ", ResultCode : " + c0263ac.m994f().m1626d() + ", ResultMsg : " + c0263ac.m994f().m1628f(), getClass().getSimpleName());
                    int iM1626d = c0263ac.m994f().m1626d();
                    if (iM1626d == 1000) {
                        message.obj = new C0257e(true, 10000, this.f325k);
                        break;
                    } else {
                        message.obj = new C0257e(false, iM1626d, this.f325k);
                        break;
                    }
                case 9:
                    C0339m c0339m = (C0339m) c0510q.m2574c();
                    C1341p.m4660c("ch@t[" + c0339m.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", ResultCode : " + c0339m.m1942f().m1626d() + ", ResultMessage : " + c0339m.m1942f().m1628f() + ", MsgID : " + c0339m.m1940d(), getClass().getSimpleName());
                    int iM1626d2 = c0339m.m1942f().m1626d();
                    if (iM1626d2 == 1000 || iM1626d2 == 6002 || iM1626d2 == 1001 || iM1626d2 == 3006) {
                        this.f326l.delete(C0662o.f2289a, "message_inbox_no=?", new String[]{this.f325k});
                        this.f326l.delete(C0671x.f2315a, "inbox_no=?", new String[]{this.f325k});
                        this.f326l.delete(C0654g.f2279a, "participants_inbox_no=?", new String[]{this.f325k});
                        message.obj = new C0257e(true, iM1626d2);
                        break;
                    } else {
                        C1341p.m4659c("reply.getResult().getResultCode():" + iM1626d2);
                        message.obj = new C0257e(false, iM1626d2);
                        break;
                    }
            }
            this.f387b.sendMessage(message);
            return;
        }
        if ((!m703b() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C0634n.m2914d(this.f326l, this.f325k);
        }
        C1341p.m4660c("Fail to send endChat message", getClass().getSimpleName());
        message.obj = new C0257e(false, i);
        this.f387b.sendMessage(message);
    }
}
