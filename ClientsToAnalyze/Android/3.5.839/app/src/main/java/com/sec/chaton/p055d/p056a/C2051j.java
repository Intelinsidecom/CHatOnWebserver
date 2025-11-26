package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.p046a.C0935fh;
import com.sec.chaton.p046a.C0960gf;
import com.sec.chaton.p046a.C0976l;
import com.sec.chaton.p046a.C0979o;
import com.sec.chaton.p046a.C0980p;
import com.sec.chaton.p046a.EnumC0813au;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;

/* compiled from: AnnounceChangeTask.java */
/* renamed from: com.sec.chaton.d.a.j */
/* loaded from: classes.dex */
public class C2051j extends AbstractC1927b {

    /* renamed from: h */
    private C0976l f7503h;

    /* renamed from: i */
    private String f7504i;

    /* renamed from: j */
    private ContentResolver f7505j;

    public C2051j(Handler handler, C0976l c0976l, String str) {
        super(handler);
        this.f7503h = c0976l;
        this.f7504i = str;
        this.f7505j = CommonApplication.m18732r().getContentResolver();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.f7503h.m5843g().size(); i++) {
                sb.append("[" + i + "]Member = " + this.f7503h.m5837a(i).m3289f()).append(", Name = " + this.f7503h.m5837a(i).m3291h()).append(", Status = " + this.f7503h.m5837a(i).m3287d());
            }
            C4904y.m18641c("ch@t[" + this.f7503h.getClass().getSimpleName() + "]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", MsgID : " + this.f7503h.m5840d() + ", SessionID : " + this.f7503h.m5842f() + ", GroupMemberListCount : " + this.f7503h.m5846j() + ", GroupMemberList : " + TextUtils.join(",", this.f7503h.m5845i()) + ", ChangeMemberListCount : " + this.f7503h.m5844h() + ", ChangeMemberList : " + sb.toString() + ", Inviter : " + this.f7503h.m5850n(), getClass().getSimpleName());
        }
        if (this.f7503h.m5844h() > 0) {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < this.f7503h.m5844h(); i2++) {
                String strM9685b = C2176ab.m9685b(this.f7505j, this.f7503h.m5837a(i2).m3289f(), this.f7503h.m5837a(i2).m3291h());
                if (this.f7503h.m5837a(i2).m3287d() == EnumC0813au.m3428a(0)) {
                    if (!C2176ab.m9681a(this.f7505j, this.f7503h.m5837a(i2).m3289f(), this.f7504i)) {
                        EnumC2231as enumC2231as = EnumC2231as.ENTER;
                        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f7503h.m5850n())) {
                            enumC2231as = EnumC2231as.INVITE;
                        }
                        sb2.append(String.format("%d,%s,%s", Integer.valueOf(enumC2231as.m10100a()), this.f7503h.m5837a(i2).m3289f(), C1736gi.m8632a(strM9685b))).append(Config.KEYVALUE_SPLIT);
                        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f7503h.m5837a(i2).m3289f())) {
                            C2176ab.m9676a(this.f7505j, this.f7504i, this.f7503h.m5837a(i2).m3289f(), strM9685b);
                        }
                    }
                } else if (this.f7503h.m5837a(i2).m3287d() == EnumC0813au.m3428a(1)) {
                    if (C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f7503h.m5837a(i2).m3289f())) {
                        Message message = new Message();
                        message.what = 16;
                        message.obj = new C0788l(true, 3006);
                        this.f7186b.sendMessage(message);
                    } else if (C2176ab.m9681a(this.f7505j, this.f7503h.m5837a(i2).m3289f(), this.f7504i)) {
                        sb2.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.LEAVE.m10100a()), this.f7503h.m5837a(i2).m3289f(), C1736gi.m8632a(strM9685b))).append(Config.KEYVALUE_SPLIT);
                        C2176ab.m9692d(this.f7505j, this.f7504i, this.f7503h.m5837a(i2).m3289f());
                    }
                }
            }
            if (sb2.length() > 0) {
                String strM5850n = this.f7503h.m5850n();
                if (TextUtils.isEmpty(strM5850n)) {
                    strM5850n = C4809aa.m18104a().m18121a("chaton_id", "");
                }
                C2204r.m10013a(this.f7505j, this.f7504i, sb2.toString(), this.f7503h.m5848l(), Long.toString(this.f7503h.m5840d()), strM5850n);
                C2198l.m9957j(this.f7505j, this.f7504i);
            }
            C2198l.m9949d(this.f7505j, this.f7504i);
        } else {
            C0960gf c0960gfM5854r = this.f7503h.m5854r();
            if (c0960gfM5854r != null && c0960gfM5854r.m5588d() == EnumC0813au.SESSION_TITLE_UPDATED) {
                C2198l.m9936b(this.f7505j, this.f7504i, c0960gfM5854r.m5592h());
            }
        }
        C0980p c0980pNewBuilder = C0979o.newBuilder();
        c0980pNewBuilder.m5908a(this.f7503h.m5840d()).m5911a(C0935fh.newBuilder().m5252a(1000));
        if (C4904y.f17873c) {
            C4904y.m18641c("ch@t[" + c0980pNewBuilder.getClass().getSimpleName() + "]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", MsgID : " + c0980pNewBuilder.m5920f(), getClass().getSimpleName());
        }
        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7504i}));
        return new C2427ap().m10519a(c0980pNewBuilder.build()).m10517a(17).m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
    }
}
