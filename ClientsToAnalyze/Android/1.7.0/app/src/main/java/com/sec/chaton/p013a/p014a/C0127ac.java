package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0268ah;
import com.sec.chaton.p015b.C0277aq;
import com.sec.chaton.p015b.C0304bq;
import com.sec.chaton.p015b.EnumC0275ao;
import com.sec.chaton.p015b.EnumC0323ci;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: InitChatRoomTask.java */
/* renamed from: com.sec.chaton.a.a.ac */
/* loaded from: classes.dex */
public class C0127ac extends AbstractC0164c {

    /* renamed from: h */
    private EnumC0651d f301h;

    /* renamed from: i */
    private EnumC0665r f302i;

    /* renamed from: j */
    private String[] f303j;

    /* renamed from: k */
    private String f304k;

    /* renamed from: l */
    private ContentResolver f305l;

    /* renamed from: m */
    private String f306m;

    /* renamed from: n */
    private String f307n;

    public C0127ac(Handler handler, String str, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String[] strArr, String str2) {
        super(handler, 1);
        this.f307n = "";
        this.f391f = -1L;
        this.f306m = str;
        this.f301h = enumC0651d;
        this.f302i = enumC0665r;
        this.f303j = strArr;
        this.f304k = str2;
        this.f305l = GlobalApplication.m3100a().getContentResolver();
    }

    public C0127ac(Handler handler, String str, long j, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String[] strArr, String str2) {
        super(handler, 1);
        this.f307n = "";
        this.f391f = j;
        this.f306m = str;
        this.f301h = enumC0651d;
        this.f302i = enumC0665r;
        this.f303j = strArr;
        this.f304k = str2;
        this.f305l = GlobalApplication.m3100a().getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        if (this.f391f == -1) {
            this.f391f = C1325bu.m4591a();
            C0635o.m2930a(this.f305l, String.valueOf(this.f391f), this.f306m, this.f301h, this.f304k, this.f303j.length);
        } else {
            C0635o.m2947c(this.f305l, Long.valueOf(this.f391f));
        }
        C0304bq c0304bqM1485e = C0268ah.newBuilder().m1471a(this.f391f).m1474a(EnumC0275ao.m1170a(this.f301h.m2978a())).m1475a(EnumC0323ci.m1750a(this.f302i.m3012a())).m1476a(C1323bs.m4575a().getString("uid", "")).m1479b(C1336k.m4621a()).m1481c(C1323bs.m4575a().getString("msisdn", "")).m1485e(this.f304k);
        for (String str : this.f303j) {
            c0304bqM1485e.m1483d(str);
            this.f307n += " " + str;
        }
        C1341p.m4660c("InitChatRequest : InBoxNo=" + this.f306m + " MsgID = " + this.f391f + " ChatType = " + this.f302i + " Receiver = " + this.f307n + "ChatMsg = " + this.f304k, getClass().getName());
        C1341p.m4660c("ch@t[" + c0304bqM1485e.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", InBoxNo : " + this.f306m + ", ChatType : " + c0304bqM1485e.m1488h().getNumber() + ", MsgID : " + c0304bqM1485e.m1486f() + ", ChatMsg : " + c0304bqM1485e.m1491k() + ", Sender : " + c0304bqM1485e.m1489i() + ", Receivers : " + C1341p.m4646a(c0304bqM1485e.m1490j()), getClass().getSimpleName());
        return new C0507n().m2556a(0).m2558a(c0304bqM1485e.build()).m2557a(15000L).m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        Message message = new Message();
        message.what = 0;
        if (obj2 != null) {
            C0277aq c0277aq = (C0277aq) ((C0510q) obj2).m2574c();
            C1341p.m4660c("ch@t[" + c0277aq.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", ResultCode : " + c0277aq.m1209l().m1626d() + ", ResultMessage : " + c0277aq.m1209l().m1628f() + ", InBoxNo : " + this.f306m + ", MsgReceivedTime : " + c0277aq.m1205h() + ", MsgID : " + c0277aq.m1201d() + ", ServerInfo(address) : " + (c0277aq.m1207j() != null ? c0277aq.m1207j().m1559d() : "null(broadcast)") + ", ServerInfo(port) : " + (c0277aq.m1207j() != null ? Integer.valueOf(c0277aq.m1207j().m1561f()) : "null(broadcast)") + ", SessionID : " + c0277aq.m1203f(), getClass().getSimpleName());
            int iM1626d = c0277aq.m1209l().m1626d();
            String strM1628f = c0277aq.m1209l().m1628f();
            if (iM1626d == 1000 || iM1626d == 1001 || iM1626d == 3002) {
                HashMap map = new HashMap();
                C1341p.m4660c("buddyname retrieve end", getClass().getSimpleName());
                C0633m.m2885a(this.f305l, this.f303j, map);
                C1341p.m4660c("participant insert start", getClass().getSimpleName());
                int length = this.f303j.length;
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(C0631k.m2861a(this.f306m, this.f303j[i2], (String) map.get(this.f303j[i2])));
                }
                try {
                    if (arrayList.size() > 0) {
                        this.f305l.applyBatch("com.sec.chaton.provider", arrayList);
                    }
                } catch (Exception e) {
                    C1341p.m4651a(e.getMessage(), getClass().getSimpleName());
                    C1341p.m4660c("Fail to insert participant to DB", getClass().getSimpleName());
                }
                C1341p.m4660c("participant insert end", getClass().getSimpleName());
                C0634n.m2898a(this.f305l, this.f306m, c0277aq, this.f304k, this.f302i, this.f303j, this.f301h);
                C0635o.m2923a(this.f305l, Long.valueOf(c0277aq.m1205h()), c0277aq.m1203f(), c0277aq.m1201d(), Long.valueOf(this.f391f), this.f303j.length);
                if (iM1626d == 1001) {
                    String[] strArrSplit = strM1628f.substring(strM1628f.indexOf("[") + 1, strM1628f.indexOf("]")).trim().split(",");
                    ArrayList arrayList2 = new ArrayList();
                    for (String str : strArrSplit) {
                        String strM2872e = C0631k.m2872e(this.f305l, this.f306m, str);
                        C1341p.m4660c("1001 error - invalidUserName:" + strM2872e, getClass().getSimpleName());
                        arrayList2.add(strM2872e);
                        C0631k.m2871d(this.f305l, this.f306m, str);
                    }
                    if (this.f302i == EnumC0665r.BROADCAST) {
                        C0634n.m2909b(this.f305l, this.f306m);
                    } else {
                        C0634n.m2889a(this.f305l, this.f306m);
                    }
                    message.obj = new C0176o(this, true, c0277aq.m1203f(), iM1626d, arrayList2, this.f391f);
                } else {
                    message.obj = new C0176o(this, true, c0277aq.m1203f(), iM1626d, this.f391f);
                }
            } else {
                message.obj = new C0257e(false, iM1626d, this.f391f);
                C1341p.m4660c("InitChatReply : InBoxNO = " + this.f306m + ", InitChat Fail", getClass().getSimpleName());
                if (iM1626d == 3001) {
                    C0635o.m2920a(this.f305l, Long.valueOf(this.f391f), Long.valueOf(C1325bu.m4591a()));
                } else {
                    C0635o.m2919a(this.f305l, Long.valueOf(this.f391f));
                }
            }
            this.f387b.sendMessage(message);
            return;
        }
        if (!m703b() || i == 11 || i == 22 || i == 3) {
            C0635o.m2919a(this.f305l, Long.valueOf(this.f391f));
            if (i == 24 || i == 23 || i == 21) {
                C0634n.m2914d(this.f305l, this.f306m);
            }
        }
        message.obj = new C0257e(false, i);
        this.f387b.sendMessage(message);
        C1341p.m4660c("InitChatReply : InBoxNO = " + this.f306m + ", InitChat Fail", getClass().getSimpleName());
    }
}
