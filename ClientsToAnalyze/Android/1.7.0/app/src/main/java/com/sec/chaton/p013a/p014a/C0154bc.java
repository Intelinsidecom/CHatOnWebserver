package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0269ai;
import com.sec.chaton.p015b.C0313bz;
import com.sec.chaton.p015b.C0314c;
import com.sec.chaton.p015b.C0328cn;
import com.sec.chaton.p015b.EnumC0274an;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: AnnounceChangeTask.java */
/* renamed from: com.sec.chaton.a.a.bc */
/* loaded from: classes.dex */
public class C0154bc extends AbstractC0164c {

    /* renamed from: h */
    private C0314c f369h;

    /* renamed from: i */
    private String f370i;

    /* renamed from: j */
    private ContentResolver f371j;

    public C0154bc(Handler handler, C0314c c0314c, String str) {
        super(handler);
        this.f369h = c0314c;
        this.f370i = str;
        this.f371j = GlobalApplication.m3100a().getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f369h.m1652g().size(); i++) {
            sb.append("[" + i + "]Member = " + this.f369h.m1646a(i).m1925f()).append(", Name = " + this.f369h.m1646a(i).m1927h()).append(", Status = " + this.f369h.m1646a(i).m1923d());
        }
        C1341p.m4660c("ch@t[" + this.f369h.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + this.f369h.m1649d() + ", SessionID : " + this.f369h.m1651f() + ", GroupMemberListCount : " + this.f369h.m1655j() + ", GroupMemberList : " + C1341p.m4646a(this.f369h.m1654i()) + ", ChangeMemberListCount : " + this.f369h.m1653h() + ", ChangeMemberList : " + sb.toString() + ", Inviter : " + this.f369h.m1659n(), getClass().getSimpleName());
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < this.f369h.m1653h(); i2++) {
            String strM2866b = C0631k.m2866b(this.f371j, this.f369h.m1646a(i2).m1925f(), this.f369h.m1646a(i2).m1927h());
            if (this.f369h.m1646a(i2).m1923d() == EnumC0274an.m1169a(0)) {
                if (!C0631k.m2864a(this.f371j, this.f369h.m1646a(i2).m1925f(), this.f370i)) {
                    sb2.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.ENTER.m3010a()), this.f369h.m1646a(i2).m1925f(), C0520a.m2713a(strM2866b))).append(";");
                    C0631k.m2863a(this.f371j, this.f370i, this.f369h.m1646a(i2).m1925f(), strM2866b);
                }
            } else if (this.f369h.m1646a(i2).m1923d() == EnumC0274an.m1169a(1) && C0631k.m2864a(this.f371j, this.f369h.m1646a(i2).m1925f(), this.f370i)) {
                sb2.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.LEAVE.m3010a()), this.f369h.m1646a(i2).m1925f(), C0520a.m2713a(strM2866b))).append(";");
                C0631k.m2871d(this.f371j, this.f370i, this.f369h.m1646a(i2).m1925f());
            }
        }
        if (sb2.length() > 0) {
            String strM1659n = this.f369h.m1659n();
            if (TextUtils.isEmpty(strM1659n)) {
                strM1659n = C1323bs.m4575a().getString("msisdn", "");
            }
            C0635o.m2929a(this.f371j, this.f370i, sb2.toString(), this.f369h.m1657l(), Long.toString(this.f369h.m1649d()), strM1659n);
            C0634n.m2916f(this.f371j, this.f370i);
        }
        C0634n.m2889a(this.f371j, this.f370i);
        C0269ai c0269aiNewBuilder = C0328cn.newBuilder();
        c0269aiNewBuilder.m1126a(this.f369h.m1649d()).m1128a(C0313bz.newBuilder().m1609a(1000));
        C1341p.m4660c("ch@t[" + c0269aiNewBuilder.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + c0269aiNewBuilder.m1136f(), getClass().getSimpleName());
        return new C0507n().m2558a(c0269aiNewBuilder.build()).m2556a(17).m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
    }
}
