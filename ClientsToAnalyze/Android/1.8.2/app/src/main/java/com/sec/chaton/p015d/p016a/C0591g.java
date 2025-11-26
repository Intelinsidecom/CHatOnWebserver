package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0171cj;
import com.sec.chaton.p007a.C0182i;
import com.sec.chaton.p007a.C0185l;
import com.sec.chaton.p007a.C0186m;
import com.sec.chaton.p007a.EnumC0108aa;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: AnnounceChangeTask.java */
/* renamed from: com.sec.chaton.d.a.g */
/* loaded from: classes.dex */
public class C0591g extends AbstractC0559b {

    /* renamed from: h */
    private C0182i f2342h;

    /* renamed from: i */
    private String f2343i;

    /* renamed from: j */
    private ContentResolver f2344j;

    public C0591g(Handler handler, C0182i c0182i, String str) {
        super(handler);
        this.f2342h = c0182i;
        this.f2343i = str;
        this.f2344j = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f2342h.m1606g().size(); i++) {
            sb.append("[" + i + "]Member = " + this.f2342h.m1600a(i).m1772f()).append(", Name = " + this.f2342h.m1600a(i).m1774h()).append(", Status = " + this.f2342h.m1600a(i).m1770d());
        }
        C1786r.m6063c("ch@t[" + this.f2342h.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + this.f2342h.m1603d() + ", SessionID : " + this.f2342h.m1605f() + ", GroupMemberListCount : " + this.f2342h.m1609j() + ", GroupMemberList : " + C1786r.m6049a(this.f2342h.m1608i()) + ", ChangeMemberListCount : " + this.f2342h.m1607h() + ", ChangeMemberList : " + sb.toString() + ", Inviter : " + this.f2342h.m1613n(), getClass().getSimpleName());
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < this.f2342h.m1607h(); i2++) {
            String strM3084b = C0670n.m3084b(this.f2344j, this.f2342h.m1600a(i2).m1772f(), this.f2342h.m1600a(i2).m1774h());
            if (this.f2342h.m1600a(i2).m1770d() == EnumC0108aa.m690a(0)) {
                if (!C0670n.m3083a(this.f2344j, this.f2342h.m1600a(i2).m1772f(), this.f2343i)) {
                    sb2.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.ENTER.m3171a()), this.f2342h.m1600a(i2).m1772f(), C0493bg.m2684a(strM3084b))).append(";");
                    C0670n.m3082a(this.f2344j, this.f2343i, this.f2342h.m1600a(i2).m1772f(), strM3084b);
                }
            } else if (this.f2342h.m1600a(i2).m1770d() == EnumC0108aa.m690a(1) && C0670n.m3083a(this.f2344j, this.f2342h.m1600a(i2).m1772f(), this.f2343i)) {
                sb2.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.LEAVE.m3171a()), this.f2342h.m1600a(i2).m1772f(), C0493bg.m2684a(strM3084b))).append(";");
                C0670n.m3090d(this.f2344j, this.f2343i, this.f2342h.m1600a(i2).m1772f());
            }
        }
        if (sb2.length() > 0) {
            String strM1613n = this.f2342h.m1613n();
            if (TextUtils.isEmpty(strM1613n)) {
                strM1613n = C1789u.m6075a().getString("msisdn", "");
            }
            C0665i.m3041a(this.f2344j, this.f2343i, sb2.toString(), this.f2342h.m1611l(), Long.toString(this.f2342h.m1603d()), strM1613n);
        }
        C0660d.m3027b(this.f2344j, this.f2343i);
        C0186m c0186mNewBuilder = C0185l.newBuilder();
        c0186mNewBuilder.m1655a(this.f2342h.m1603d()).m1658a(C0171cj.newBuilder().m1476a(1000));
        C1786r.m6063c("ch@t[" + c0186mNewBuilder.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0186mNewBuilder.m1665f(), getClass().getSimpleName());
        return new C0771ac().m3296a(c0186mNewBuilder.build()).m3294a(17).m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
    }
}
