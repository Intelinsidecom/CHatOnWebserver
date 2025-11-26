package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.p016a.C0369dl;
import com.sec.chaton.p016a.C0394i;
import com.sec.chaton.p016a.C0397l;
import com.sec.chaton.p016a.C0398m;
import com.sec.chaton.p016a.EnumC0294ar;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.List;

/* compiled from: AnnounceChangeTask.java */
/* renamed from: com.sec.chaton.d.a.o */
/* loaded from: classes.dex */
public class C1276o extends AbstractC1199c {

    /* renamed from: h */
    private C0394i f4881h;

    /* renamed from: i */
    private String f4882i;

    /* renamed from: j */
    private ContentResolver f4883j;

    public C1276o(Handler handler, C0394i c0394i, String str) {
        super(handler);
        this.f4881h = c0394i;
        this.f4882i = str;
        this.f4883j = CommonApplication.m11493l().getContentResolver();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.f4881h.m2837g().size(); i++) {
                sb.append("[" + i + "]Member = " + this.f4881h.m2831a(i).m1462f()).append(", Name = " + this.f4881h.m2831a(i).m1464h()).append(", Status = " + this.f4881h.m2831a(i).m1460d());
            }
            C3250y.m11453c("ch@t[" + this.f4881h.getClass().getSimpleName() + "]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", MsgID : " + this.f4881h.m2834d() + ", SessionID : " + this.f4881h.m2836f() + ", GroupMemberListCount : " + this.f4881h.m2840j() + ", GroupMemberList : " + C3250y.m11437a((List<? extends Object>) this.f4881h.m2839i()) + ", ChangeMemberListCount : " + this.f4881h.m2838h() + ", ChangeMemberList : " + sb.toString() + ", Inviter : " + this.f4881h.m2844n(), getClass().getSimpleName());
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < this.f4881h.m2838h(); i2++) {
            String strM6215b = C1381y.m6215b(this.f4883j, this.f4881h.m2831a(i2).m1462f(), this.f4881h.m2831a(i2).m1464h());
            if (this.f4881h.m2831a(i2).m1460d() == EnumC0294ar.m1583a(0)) {
                if (!C1381y.m6211a(this.f4883j, this.f4881h.m2831a(i2).m1462f(), this.f4882i)) {
                    EnumC1391ai enumC1391ai = EnumC1391ai.ENTER;
                    if (C3159aa.m10962a().m10979a("chaton_id", "").equals(this.f4881h.m2844n())) {
                        enumC1391ai = EnumC1391ai.INVITE;
                    }
                    sb2.append(String.format("%d,%s,%s", Integer.valueOf(enumC1391ai.m6248a()), this.f4881h.m2831a(i2).m1462f(), C1075eq.m5318a(strM6215b))).append(Config.KEYVALUE_SPLIT);
                    C1381y.m6210a(this.f4883j, this.f4882i, this.f4881h.m2831a(i2).m1462f(), strM6215b);
                }
            } else if (this.f4881h.m2831a(i2).m1460d() == EnumC0294ar.m1583a(1)) {
                if (C3159aa.m10962a().m10979a("chaton_id", "").equals(this.f4881h.m2831a(i2).m1462f())) {
                    Message message = new Message();
                    message.what = 16;
                    message.obj = new C0272i(true, 3006);
                    this.f4698b.sendMessage(message);
                } else if (C1381y.m6211a(this.f4883j, this.f4881h.m2831a(i2).m1462f(), this.f4882i)) {
                    sb2.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.LEAVE.m6248a()), this.f4881h.m2831a(i2).m1462f(), C1075eq.m5318a(strM6215b))).append(Config.KEYVALUE_SPLIT);
                    C1381y.m6219d(this.f4883j, this.f4882i, this.f4881h.m2831a(i2).m1462f());
                }
            }
        }
        if (sb2.length() > 0) {
            String strM2844n = this.f4881h.m2844n();
            if (TextUtils.isEmpty(strM2844n)) {
                strM2844n = C3159aa.m10962a().m10979a("chaton_id", "");
            }
            C1373q.m6167a(this.f4883j, this.f4882i, sb2.toString(), this.f4881h.m2842l(), Long.toString(this.f4881h.m2834d()), strM2844n);
            C1370n.m6143g(this.f4883j, this.f4882i);
        }
        C1370n.m6136c(this.f4883j, this.f4882i);
        C0398m c0398mNewBuilder = C0397l.newBuilder();
        c0398mNewBuilder.m2886a(this.f4881h.m2834d()).m2889a(C0369dl.newBuilder().m2507a(1000));
        if (C3250y.f11735c) {
            C3250y.m11453c("ch@t[" + c0398mNewBuilder.getClass().getSimpleName() + "]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", MsgID : " + c0398mNewBuilder.m2896f(), getClass().getSimpleName());
        }
        return new C1549ah().m6581a(c0398mNewBuilder.build()).m6579a(17).m6584b();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) {
    }
}
