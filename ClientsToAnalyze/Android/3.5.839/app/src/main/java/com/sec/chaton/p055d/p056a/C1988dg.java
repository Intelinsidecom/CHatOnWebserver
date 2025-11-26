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
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1753gz;
import com.sec.chaton.p046a.C0877dd;
import com.sec.chaton.p046a.C0880dg;
import com.sec.chaton.p046a.C0881dh;
import com.sec.chaton.p046a.C0892ds;
import com.sec.chaton.p046a.EnumC0908eh;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: InviteChatTask.java */
/* renamed from: com.sec.chaton.d.a.dg */
/* loaded from: classes.dex */
public class C1988dg extends AbstractC1981d {

    /* renamed from: h */
    private EnumC2214ab f7293h;

    /* renamed from: i */
    private String f7294i;

    /* renamed from: j */
    private String[] f7295j;

    /* renamed from: k */
    private String f7296k;

    /* renamed from: l */
    private String[] f7297l;

    /* renamed from: m */
    private ContentResolver f7298m;

    /* renamed from: n */
    private String f7299n;

    public C1988dg(Handler handler, EnumC2214ab enumC2214ab, String str, String[] strArr, String[] strArr2, String str2) {
        super(handler);
        this.f7190f = -1L;
        this.f7293h = enumC2214ab;
        this.f7294i = str;
        this.f7295j = strArr;
        this.f7297l = strArr2;
        this.f7298m = CommonApplication.m18732r().getContentResolver();
        this.f7299n = str2;
        if (this.f7295j != null && this.f7295j.length > 0) {
            this.f7296k = this.f7295j[0];
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        if (this.f7190f == -1) {
            this.f7190f = C4843bh.m18322a();
        }
        String strM9650h = C2142w.m9606c(this.f7299n).m9650h();
        if (!TextUtils.isEmpty(strM9650h)) {
            this.f7294i = strM9650h;
        }
        C0881dh c0881dhNewBuilder = C0880dg.newBuilder();
        c0881dhNewBuilder.m4488a(this.f7190f).m4492a(EnumC0908eh.m4887a(this.f7293h.m10076a())).m4493a(this.f7294i).m4497b(C4809aa.m18104a().m18121a("chaton_id", ""));
        if (!TextUtils.isEmpty(this.f7296k)) {
            c0881dhNewBuilder.m4500c(this.f7296k);
        }
        for (String str : this.f7297l) {
            c0881dhNewBuilder.m4502d(str);
        }
        long jM9651i = C2142w.m9606c(this.f7299n).m9651i();
        if (jM9651i > 0) {
            c0881dhNewBuilder.m4496b(jM9651i);
        }
        C4904y.m18641c("ch@t[InviteChatRequest]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", InBoxNo : " + this.f7299n + ", MsgID : " + c0881dhNewBuilder.m4505f() + ", InvitingMembersCount : " + c0881dhNewBuilder.m4511k() + ", InvitingMembersList : " + TextUtils.join(",", c0881dhNewBuilder.m4510j()) + ", Sender : " + c0881dhNewBuilder.m4507g() + ", LastSessionMergeTime : " + c0881dhNewBuilder.m4512l() + ", ReceiverCount : " + c0881dhNewBuilder.m4509i() + ", ReceiversList : " + TextUtils.join(",", c0881dhNewBuilder.m4508h()), getClass().getSimpleName());
        C2427ap c2427ap = new C2427ap();
        c2427ap.m10519a(c0881dhNewBuilder.build()).m10517a(12).m10518a(C1433g.m7529c());
        return c2427ap.m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        String strM8702a;
        super.mo9092a(i, obj, obj2);
        Message message = new Message();
        message.what = 12;
        if (obj2 != null) {
            C0877dd c0877dd = (C0877dd) ((C2426ao) obj2).m10513c();
            C4904y.m18641c("ch@t[InviteChatReply]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ResultCode : " + c0877dd.m4402f().m5229d() + ", ResultMessage : " + c0877dd.m4402f().m5231f() + ", InBoxNo : " + this.f7299n + ", ReceivedTime : " + String.valueOf(c0877dd.m4404h()) + ", MsgID : " + c0877dd.m4400d(), getClass().getSimpleName());
            int iM5229d = c0877dd.m4402f().m5229d();
            if (iM5229d == 1000 || iM5229d == 1001 || iM5229d == 3005) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f7297l) {
                    arrayList.add(str);
                }
                if (iM5229d == 1001) {
                    List<String> listM5237l = c0877dd.m4402f().m5237l();
                    if (listM5237l != null) {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("1001 error blockedByReceiverList : " + listM5237l.toString(), getClass().getSimpleName());
                        }
                        Iterator<String> it = listM5237l.iterator();
                        while (it.hasNext()) {
                            arrayList.remove(it.next());
                        }
                    }
                    Matcher matcher = Pattern.compile("\\[.+?\\]").matcher(c0877dd.m4402f().m5231f());
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
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str3 = (String) it2.next();
                    if (!C2176ab.m9681a(this.f7298m, str3, this.f7299n)) {
                        arrayList2.add(C2176ab.m9670a(this.f7299n, str3));
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.INVITE.m10100a()), str3, C1736gi.m8632a(C2176ab.m9695f(this.f7298m, str3))));
                        sb.append(Config.KEYVALUE_SPLIT);
                    } else if (C2176ab.m9701i(this.f7298m, str3, this.f7299n).equals(EnumC1109f.INVITING.m7095a())) {
                        arrayList2.add(C2176ab.m9690d(str3, this.f7299n, EnumC1109f.NONE.m7095a()));
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.INVITE.m10100a()), str3, C1736gi.m8632a(C2176ab.m9695f(this.f7298m, str3))));
                        sb.append(Config.KEYVALUE_SPLIT);
                        if (C4904y.f17872b) {
                            C4904y.m18639b("After invite contact buddy[" + str3 + "] is finished.", C1988dg.class.getSimpleName());
                        }
                    }
                }
                try {
                    if (arrayList2.size() > 0) {
                        this.f7298m.applyBatch("com.sec.chaton.provider", arrayList2);
                        C2204r.m10007a(this.f7298m, this.f7299n, sb.toString(), c0877dd.m4404h(), C4809aa.m18104a().m18121a("chaton_id", ""));
                        C2198l.m9957j(this.f7298m, this.f7299n);
                        C2198l.m9949d(this.f7298m, this.f7299n);
                    }
                } catch (Exception e) {
                    C4904y.m18634a(e.getMessage(), getClass().getSimpleName());
                }
                message.obj = new C0788l(true, iM5229d);
            } else {
                if (iM5229d == 7001) {
                    C1753gz.m8698a().m8706a(this.f7299n, this.f7296k, c0877dd.m4404h());
                    strM8702a = null;
                } else if (iM5229d == 7002) {
                    strM8702a = C1753gz.m8698a().m8701a(this.f7186b, this.f7299n, c0877dd.m4402f());
                } else if (iM5229d == 7003) {
                    strM8702a = C1753gz.m8698a().m8702a(this.f7299n, c0877dd.m4402f());
                } else {
                    if (iM5229d == 7006) {
                        StringBuilder sb2 = new StringBuilder("update invite list : ");
                        for (C0892ds c0892ds : c0877dd.m4402f().m5235j().m4985c()) {
                            String strM4668d = c0892ds.m4668d();
                            String strM4670f = c0892ds.m4670f();
                            sb2.append("(old:").append(strM4668d).append(",new:").append(strM4670f).append("),");
                            for (int i2 = 0; i2 < this.f7297l.length; i2++) {
                                if (this.f7297l[i2].equals(strM4668d)) {
                                    this.f7297l[i2] = strM4670f;
                                }
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        for (String str4 : this.f7297l) {
                            if (!arrayList3.contains(str4)) {
                                arrayList3.add(str4);
                            }
                        }
                        this.f7297l = (String[]) arrayList3.toArray(new String[arrayList3.size()]);
                        if (C4904y.f17873c) {
                            C4904y.m18641c("7006(NON_WEB_USER_DETECTED) - " + sb2.toString(), "InviteChatTask");
                        }
                    }
                    strM8702a = null;
                }
                if (!TextUtils.isEmpty(strM8702a)) {
                    this.f7296k = strM8702a;
                }
                message.obj = new C0788l(false, iM5229d);
            }
            this.f7186b.sendMessage(message);
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7299n}));
            return;
        }
        if ((!mo9104a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C2198l.m9953f(this.f7298m, this.f7299n);
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7299n}));
        }
        C4904y.m18641c("Result NULL", getClass().getSimpleName());
        message.obj = new C0788l(false, i);
        this.f7186b.sendMessage(message);
    }
}
