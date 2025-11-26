package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.p016a.C0342cl;
import com.sec.chaton.p016a.C0345co;
import com.sec.chaton.p016a.C0346cp;
import com.sec.chaton.p016a.C0351cu;
import com.sec.chaton.p016a.EnumC0354cx;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1455w;
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

/* compiled from: InviteChatTask.java */
/* renamed from: com.sec.chaton.d.a.cz */
/* loaded from: classes.dex */
public class C1225cz extends AbstractC1253e {

    /* renamed from: h */
    private EnumC1455w f4740h;

    /* renamed from: i */
    private String f4741i;

    /* renamed from: j */
    private String[] f4742j;

    /* renamed from: k */
    private String[] f4743k;

    /* renamed from: l */
    private ContentResolver f4744l;

    /* renamed from: m */
    private String f4745m;

    public C1225cz(Handler handler, EnumC1455w enumC1455w, String str, String[] strArr, String[] strArr2, String str2) {
        super(handler);
        this.f4702f = -1L;
        this.f4740h = enumC1455w;
        this.f4741i = str;
        this.f4742j = strArr;
        this.f4743k = strArr2;
        this.f4744l = CommonApplication.m11493l().getContentResolver();
        this.f4745m = str2;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        super.mo5504b();
        if (this.f4702f == -1) {
            this.f4702f = C3193bh.m11148a();
        }
        String strM5895d = C1337o.m5813d(this.f4745m).m5895d();
        if (!TextUtils.isEmpty(strM5895d)) {
            this.f4741i = strM5895d;
        }
        C0346cp c0346cpNewBuilder = C0345co.newBuilder();
        c0346cpNewBuilder.m2258a(this.f4702f).m2261a(EnumC0354cx.m2352a(this.f4740h.m6364a())).m2262a(this.f4741i).m2265b(C3159aa.m10962a().m10979a("chaton_id", ""));
        if (this.f4742j.length > 0) {
            c0346cpNewBuilder.m2267c(this.f4742j[0]);
        }
        for (String str : this.f4743k) {
            c0346cpNewBuilder.m2269d(str);
        }
        long jM5896e = C1337o.m5813d(this.f4745m).m5896e();
        if (jM5896e > 0) {
            c0346cpNewBuilder.m2264b(jM5896e);
        }
        C3250y.m11453c("ch@t[InviteChatRequest]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", InBoxNo : " + this.f4745m + ", MsgID : " + c0346cpNewBuilder.m2271f() + ", InvitingMembersCount : " + c0346cpNewBuilder.m2276k() + ", InvitingMembersList : " + C3250y.m11437a((List<? extends Object>) c0346cpNewBuilder.m2275j()) + ", Sender : " + c0346cpNewBuilder.m2272g() + ", LastSessionMergeTime : " + c0346cpNewBuilder.m2277l() + ", ReceiverCount : " + c0346cpNewBuilder.m2274i() + ", ReceiversList : " + C3250y.m11437a((List<? extends Object>) c0346cpNewBuilder.m2273h()), getClass().getSimpleName());
        C1549ah c1549ah = new C1549ah();
        c1549ah.m6581a(c0346cpNewBuilder.build()).m6579a(12).m6580a(C0822g.m4374c());
        return c1549ah.m6584b();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        super.mo5502a(i, obj, obj2);
        Message message = new Message();
        message.what = 12;
        if (obj2 != null) {
            C0342cl c0342cl = (C0342cl) ((C1548ag) obj2).m6575c();
            C3250y.m11453c("ch@t[InviteChatReply]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", ResultCode : " + c0342cl.m2196f().m2494d() + ", ResultMessage : " + c0342cl.m2196f().m2496f() + ", InBoxNo : " + this.f4745m + ", ReceivedTime : " + String.valueOf(c0342cl.m2198h()) + ", MsgID : " + c0342cl.m2194d(), getClass().getSimpleName());
            int iM2494d = c0342cl.m2196f().m2494d();
            if (iM2494d == 1000 || iM2494d == 1001 || iM2494d == 3005) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f4743k) {
                    arrayList.add(str);
                }
                if (iM2494d == 1001) {
                    Matcher matcher = Pattern.compile("\\[.+?\\]").matcher(c0342cl.m2196f().m2496f());
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
                    C1381y.m6216c(this.f4744l, this.f4745m, str3);
                    sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.INVITE.m6248a()), str3, C1075eq.m5318a(C1381y.m6222f(this.f4744l, str3))));
                    sb.append(Config.KEYVALUE_SPLIT);
                }
                C1373q.m6166a(this.f4744l, this.f4745m, sb.toString(), c0342cl.m2198h(), C3159aa.m10962a().m10979a("chaton_id", ""));
                C1370n.m6143g(this.f4744l, this.f4745m);
                C1370n.m6136c(this.f4744l, this.f4745m);
                message.obj = new C0272i(true, iM2494d);
            } else {
                if (iM2494d == 7001) {
                    C1089fd.m5358a().m5365a(this.f4745m, this.f4742j[0], c0342cl.m2198h());
                } else if (iM2494d == 7002) {
                    C1089fd.m5358a().m5361a(this.f4698b, this.f4745m, c0342cl.m2196f());
                } else if (iM2494d == 7003) {
                    C1089fd.m5358a().m5363a(this.f4745m, c0342cl.m2196f());
                } else if (iM2494d == 7006) {
                    StringBuilder sb2 = new StringBuilder("update invite list : ");
                    for (C0351cu c0351cu : c0342cl.m2196f().m2500j().m2468c()) {
                        String strM2335d = c0351cu.m2335d();
                        String strM2337f = c0351cu.m2337f();
                        sb2.append("(old:").append(strM2335d).append(",new:").append(strM2337f).append("),");
                        for (int i2 = 0; i2 < this.f4743k.length; i2++) {
                            if (this.f4743k[i2].equals(strM2335d)) {
                                this.f4743k[i2] = strM2337f;
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String str4 : this.f4743k) {
                        if (!arrayList2.contains(str4)) {
                            arrayList2.add(str4);
                        }
                    }
                    this.f4743k = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
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
            C1370n.m6141e(this.f4744l, this.f4745m);
        }
        C3250y.m11453c("Result NULL", getClass().getSimpleName());
        message.obj = new C0272i(false, i);
        this.f4698b.sendMessage(message);
    }
}
