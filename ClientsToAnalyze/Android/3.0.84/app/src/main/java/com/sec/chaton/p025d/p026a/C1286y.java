package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.p016a.C0286aj;
import com.sec.chaton.p016a.C0289am;
import com.sec.chaton.p016a.C0290an;
import com.sec.chaton.p016a.C0351cu;
import com.sec.chaton.p016a.EnumC0292ap;
import com.sec.chaton.p016a.EnumC0302az;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ChangeMemberTask.java */
/* renamed from: com.sec.chaton.d.a.y */
/* loaded from: classes.dex */
public class C1286y extends AbstractC1253e {

    /* renamed from: h */
    private String f4900h;

    /* renamed from: i */
    private String[] f4901i;

    /* renamed from: j */
    private String[] f4902j;

    /* renamed from: k */
    private ContentResolver f4903k;

    /* renamed from: l */
    private String f4904l;

    /* renamed from: m */
    private boolean f4905m;

    public C1286y(Handler handler, String str, String[] strArr, String[] strArr2, boolean z, String str2) {
        super(handler);
        this.f4702f = -1L;
        this.f4900h = str;
        this.f4901i = strArr;
        this.f4902j = strArr2;
        this.f4903k = CommonApplication.m11493l().getContentResolver();
        this.f4905m = z;
        this.f4904l = str2;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        super.mo5504b();
        if (this.f4702f == -1) {
            this.f4702f = C3193bh.m11148a();
        }
        String strM5895d = C1337o.m5813d(this.f4904l).m5895d();
        if (!TextUtils.isEmpty(strM5895d)) {
            this.f4900h = strM5895d;
        }
        C0290an c0290anNewBuilder = C0289am.newBuilder();
        c0290anNewBuilder.m1557a(this.f4702f).m1561a(EnumC0302az.BR2).m1563a(this.f4900h).m1566b(C3159aa.m10962a().m10979a("chaton_id", ""));
        if (this.f4901i.length > 0) {
            c0290anNewBuilder.m1568c(this.f4901i[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f4902j) {
            arrayList.add(str);
        }
        c0290anNewBuilder.m1562a(arrayList);
        if (this.f4905m) {
            c0290anNewBuilder.m1560a(EnumC0292ap.ADD);
        } else {
            c0290anNewBuilder.m1560a(EnumC0292ap.REMOVE);
        }
        long jM5896e = C1337o.m5813d(this.f4904l).m5896e();
        if (jM5896e > 0) {
            c0290anNewBuilder.m1565b(jM5896e);
        }
        C3250y.m11453c("ch@t[ChangeMemberRequest]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", InBoxNo : " + this.f4904l + ", SessionID : " + c0290anNewBuilder.m1573h() + ", ChatType : " + c0290anNewBuilder.m1572g() + ", MsgID : " + c0290anNewBuilder.m1571f() + ", ChangingMembersCount : " + c0290anNewBuilder.m1579n() + ", ChangingMembersList : " + C3250y.m11437a((List<? extends Object>) c0290anNewBuilder.m1578m()) + ", Sender : " + c0290anNewBuilder.m1574i() + ", LastSessionMergeTime : " + c0290anNewBuilder.m1580o() + ", ReceiverCount : " + c0290anNewBuilder.m1576k() + ", ReceiversList : " + C3250y.m11437a((List<? extends Object>) c0290anNewBuilder.m1575j()) + ", ChangeMemberType : " + c0290anNewBuilder.m1577l(), getClass().getSimpleName());
        C1549ah c1549ah = new C1549ah();
        c1549ah.m6581a(c0290anNewBuilder.build()).m6579a(31).m6580a(C0822g.m4374c());
        return c1549ah.m6584b();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        super.mo5502a(i, obj, obj2);
        Message message = new Message();
        message.what = 31;
        if (obj2 != null) {
            C0286aj c0286aj = (C0286aj) ((C1548ag) obj2).m6575c();
            C3250y.m11453c("ch@t[ChangeMemberReply]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", ResultCode : " + c0286aj.m1492f().m2494d() + ", ResultMessage : " + c0286aj.m1492f().m2496f() + ", InBoxNo : " + this.f4904l + ", ReceivedTime : " + String.valueOf(c0286aj.m1494h()) + ", MsgID : " + c0286aj.m1490d(), getClass().getSimpleName());
            int iM2494d = c0286aj.m1492f().m2494d();
            if (iM2494d == 1000 || iM2494d == 1001 || iM2494d == 3005) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f4902j) {
                    arrayList.add(str);
                }
                if (iM2494d == 1001) {
                    Matcher matcher = Pattern.compile("\\[.+?\\]").matcher(c0286aj.m1492f().m2496f());
                    while (matcher.find()) {
                        String strSubstring = matcher.group().substring(1, r0.length() - 1);
                        if (!TextUtils.isEmpty(strSubstring)) {
                            String[] strArrSplit = strSubstring.split(",");
                            for (String str2 : strArrSplit) {
                                if (arrayList.contains(str2)) {
                                    arrayList.remove(str2);
                                }
                            }
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    C1381y.m6216c(this.f4903k, this.f4904l, str3);
                    sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.INVITE.m6248a()), str3, C1075eq.m5318a(C1360d.m6037b(this.f4903k, str3))));
                    sb.append(Config.KEYVALUE_SPLIT);
                }
                C1373q.m6166a(this.f4903k, this.f4904l, sb.toString(), c0286aj.m1494h(), C3159aa.m10962a().m10979a("chaton_id", ""));
                C1370n.m6143g(this.f4903k, this.f4904l);
                C1370n.m6136c(this.f4903k, this.f4904l);
                message.obj = new C0272i(true, iM2494d);
            } else {
                if (iM2494d == 7003) {
                    C1089fd.m5358a().m5363a(this.f4904l, c0286aj.m1492f());
                } else if (iM2494d == 7006) {
                    StringBuilder sb2 = new StringBuilder("update invite list : ");
                    for (C0351cu c0351cu : c0286aj.m1492f().m2500j().m2468c()) {
                        String strM2335d = c0351cu.m2335d();
                        String strM2337f = c0351cu.m2337f();
                        sb2.append("(old:").append(strM2335d).append(",new:").append(strM2337f).append("),");
                        for (int i2 = 0; i2 < this.f4902j.length; i2++) {
                            if (this.f4902j[i2].equals(strM2335d)) {
                                this.f4902j[i2] = strM2337f;
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String str4 : this.f4902j) {
                        if (!arrayList2.contains(str4)) {
                            arrayList2.add(str4);
                        }
                    }
                    this.f4902j = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    if (C3250y.f11735c) {
                        C3250y.m11453c("7006(NON_WEB_USER_DETECTED) - " + sb2.toString(), "InviteChatTask");
                    }
                }
                message.obj = new C0272i(false, iM2494d);
            }
            this.f4698b.sendMessage(message);
            return;
        }
        if ((!mo5503a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C1370n.m6141e(this.f4903k, this.f4904l);
        }
        C3250y.m11453c("Result NULL", getClass().getSimpleName());
        message.obj = new C0272i(false, i);
        this.f4698b.sendMessage(message);
    }
}
