package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1753gz;
import com.sec.chaton.p046a.C0805am;
import com.sec.chaton.p046a.C0808ap;
import com.sec.chaton.p046a.C0809aq;
import com.sec.chaton.p046a.C0892ds;
import com.sec.chaton.p046a.EnumC0811as;
import com.sec.chaton.p046a.EnumC0822bc;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2190d;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ChangeMemberTask.java */
/* renamed from: com.sec.chaton.d.a.u */
/* loaded from: classes.dex */
public class C2062u extends AbstractC1981d {

    /* renamed from: h */
    private String f7532h;

    /* renamed from: i */
    private String[] f7533i;

    /* renamed from: j */
    private String[] f7534j;

    /* renamed from: k */
    private ContentResolver f7535k;

    /* renamed from: l */
    private String f7536l;

    /* renamed from: m */
    private boolean f7537m;

    public C2062u(Handler handler, String str, String[] strArr, String[] strArr2, boolean z, String str2) {
        super(handler);
        this.f7190f = -1L;
        this.f7532h = str;
        this.f7533i = strArr;
        this.f7534j = strArr2;
        this.f7535k = CommonApplication.m18732r().getContentResolver();
        this.f7537m = z;
        this.f7536l = str2;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        if (this.f7190f == -1) {
            this.f7190f = C4843bh.m18322a();
        }
        if (C2142w.m9606c(this.f7536l) != null) {
            String strM9650h = C2142w.m9606c(this.f7536l).m9650h();
            if (!TextUtils.isEmpty(strM9650h)) {
                this.f7532h = strM9650h;
            }
        }
        C0809aq c0809aqNewBuilder = C0808ap.newBuilder();
        c0809aqNewBuilder.m3399a(this.f7190f).m3403a(EnumC0822bc.BR2).m3405a(this.f7532h).m3409b(C4809aa.m18104a().m18121a("chaton_id", ""));
        if (this.f7533i.length > 0) {
            c0809aqNewBuilder.m3412c(this.f7533i[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f7534j) {
            arrayList.add(str);
        }
        c0809aqNewBuilder.m3404a(arrayList);
        if (this.f7537m) {
            c0809aqNewBuilder.m3402a(EnumC0811as.ADD);
        } else {
            c0809aqNewBuilder.m3402a(EnumC0811as.REMOVE);
        }
        if (C2142w.m9606c(this.f7536l) != null) {
            long jM9651i = C2142w.m9606c(this.f7536l).m9651i();
            if (jM9651i > 0) {
                c0809aqNewBuilder.m3408b(jM9651i);
            }
        }
        C4904y.m18641c("ch@t[ChangeMemberRequest]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", InBoxNo : " + this.f7536l + ", SessionID : " + c0809aqNewBuilder.m3418h() + ", ChatType : " + c0809aqNewBuilder.m3417g() + ", MsgID : " + c0809aqNewBuilder.m3416f() + ", ChangingMembersCount : " + c0809aqNewBuilder.m3424n() + ", ChangingMembersList : " + TextUtils.join(",", c0809aqNewBuilder.m3423m()) + ", Sender : " + c0809aqNewBuilder.m3419i() + ", LastSessionMergeTime : " + c0809aqNewBuilder.m3425o() + ", ReceiverCount : " + c0809aqNewBuilder.m3421k() + ", ReceiversList : " + TextUtils.join(",", c0809aqNewBuilder.m3420j()) + ", ChangeMemberType : " + c0809aqNewBuilder.m3422l(), getClass().getSimpleName());
        C2427ap c2427ap = new C2427ap();
        c2427ap.m10519a(c0809aqNewBuilder.build()).m10517a(31).m10518a(C1433g.m7529c());
        return c2427ap.m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        super.mo9092a(i, obj, obj2);
        Message message = new Message();
        message.what = 31;
        if (obj2 != null) {
            C0805am c0805am = (C0805am) ((C2426ao) obj2).m10513c();
            C4904y.m18641c("ch@t[ChangeMemberReply]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ResultCode : " + c0805am.m3321f().m5229d() + ", ResultMessage : " + c0805am.m3321f().m5231f() + ", InBoxNo : " + this.f7536l + ", ReceivedTime : " + String.valueOf(c0805am.m3323h()) + ", MsgID : " + c0805am.m3319d(), getClass().getSimpleName());
            int iM5229d = c0805am.m3321f().m5229d();
            if (this.f7537m) {
                if (iM5229d == 1000 || iM5229d == 1001 || iM5229d == 3005) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : this.f7534j) {
                        arrayList.add(str);
                    }
                    if (iM5229d == 1001) {
                        Matcher matcher = Pattern.compile("\\[.+?\\]").matcher(c0805am.m3321f().m5231f());
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
                        C2176ab.m9688c(this.f7535k, this.f7536l, str3);
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.INVITE.m10100a()), str3, C1736gi.m8632a(C2190d.m9827c(this.f7535k, str3))));
                        sb.append(Config.KEYVALUE_SPLIT);
                    }
                    C2204r.m10007a(this.f7535k, this.f7536l, sb.toString(), c0805am.m3323h(), C4809aa.m18104a().m18121a("chaton_id", ""));
                    C2198l.m9949d(this.f7535k, this.f7536l);
                    message.obj = new C0788l(true, iM5229d);
                } else {
                    if (iM5229d == 7003) {
                        C1753gz.m8698a().m8702a(this.f7536l, c0805am.m3321f());
                    } else if (iM5229d == 7006) {
                        StringBuilder sb2 = new StringBuilder("update invite list : ");
                        for (C0892ds c0892ds : c0805am.m3321f().m5235j().m4985c()) {
                            String strM4668d = c0892ds.m4668d();
                            String strM4670f = c0892ds.m4670f();
                            sb2.append("(old:").append(strM4668d).append(",new:").append(strM4670f).append("),");
                            for (int i2 = 0; i2 < this.f7534j.length; i2++) {
                                if (this.f7534j[i2].equals(strM4668d)) {
                                    this.f7534j[i2] = strM4670f;
                                }
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (String str4 : this.f7534j) {
                            if (!arrayList2.contains(str4)) {
                                arrayList2.add(str4);
                            }
                        }
                        this.f7534j = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                        if (C4904y.f17873c) {
                            C4904y.m18641c("7006(NON_WEB_USER_DETECTED) - " + sb2.toString(), "ChangeMemberTask");
                        }
                    }
                    message.obj = new C0788l(false, iM5229d);
                }
            } else if (iM5229d == 1000 || iM5229d == 1001 || iM5229d == 3005) {
                StringBuilder sb3 = new StringBuilder();
                for (int i3 = 0; i3 < this.f7534j.length; i3++) {
                    C2176ab.m9692d(this.f7535k, this.f7536l, this.f7534j[i3]);
                    sb3.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.LEAVE.m10100a()), this.f7534j[i3], C1736gi.m8632a(C2176ab.m9695f(this.f7535k, this.f7534j[i3])))).append(Config.KEYVALUE_SPLIT);
                }
                String string = sb3.toString();
                if (!TextUtils.isEmpty(string)) {
                    C2204r.m10007a(this.f7535k, this.f7536l, string, c0805am.m3323h(), C4809aa.m18104a().m18121a("chaton_id", ""));
                }
                C2198l.m9949d(this.f7535k, this.f7536l);
                message.obj = new C0788l(true, iM5229d);
            } else {
                if (iM5229d == 7003) {
                    C1753gz.m8698a().m8702a(this.f7536l, c0805am.m3321f());
                }
                message.obj = new C0788l(false, iM5229d);
            }
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7536l}));
            this.f7186b.sendMessage(message);
            return;
        }
        if ((!mo9104a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C2198l.m9953f(this.f7535k, this.f7536l);
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7536l}));
        }
        C4904y.m18641c("Result NULL", getClass().getSimpleName());
        message.obj = new C0788l(false, i);
        this.f7186b.sendMessage(message);
    }
}
