package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0153bs;
import com.sec.chaton.p007a.C0156bv;
import com.sec.chaton.p007a.C0157bw;
import com.sec.chaton.p007a.EnumC0159by;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: InviteChatTask.java */
/* renamed from: com.sec.chaton.d.a.bf */
/* loaded from: classes.dex */
public class C0565bf extends AbstractC0559b {

    /* renamed from: h */
    private EnumC0699n f2257h;

    /* renamed from: i */
    private String f2258i;

    /* renamed from: j */
    private String[] f2259j;

    /* renamed from: k */
    private String[] f2260k;

    /* renamed from: l */
    private ContentResolver f2261l;

    /* renamed from: m */
    private String f2262m;

    public C0565bf(Handler handler, EnumC0699n enumC0699n, String str, String[] strArr, String[] strArr2, String str2) {
        super(handler);
        this.f2240f = -1L;
        this.f2257h = enumC0699n;
        this.f2258i = str;
        this.f2259j = strArr;
        this.f2260k = strArr2;
        this.f2261l = GlobalApplication.m3260b().getContentResolver();
        this.f2262m = str2;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        C1786r.m6063c("Request InviteChat", getClass().getSimpleName());
        if (this.f2240f == -1) {
            this.f2240f = C1735ar.m5918a();
        }
        C0157bw c0157bwNewBuilder = C0156bv.newBuilder();
        c0157bwNewBuilder.m1329a(this.f2240f).m1332a(EnumC0159by.m1347a(this.f2257h.m3162a())).m1333a(this.f2258i).m1335b(C1789u.m6075a().getString("msisdn", ""));
        for (String str : this.f2259j) {
            c0157bwNewBuilder.m1337c(str);
        }
        for (String str2 : this.f2260k) {
            c0157bwNewBuilder.m1339d(str2);
        }
        C1786r.m6063c("ch@t[" + c0157bwNewBuilder.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", InBoxNo : " + this.f2262m + ", MsgID : " + c0157bwNewBuilder.m1341f() + ", InvitingMembersCount : " + c0157bwNewBuilder.m1346k() + ", InvitingMembersList : " + C1786r.m6049a(c0157bwNewBuilder.m1345j()) + ", Sender : " + c0157bwNewBuilder.m1342g() + ", ReceiverCount : " + c0157bwNewBuilder.m1344i() + ", ReceiversList : " + C1786r.m6049a(c0157bwNewBuilder.m1343h()), getClass().getSimpleName());
        C0771ac c0771ac = new C0771ac();
        c0771ac.m3296a(c0157bwNewBuilder.build()).m3294a(12).m3295a(30000L);
        return c0771ac.m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 12;
        if (obj2 != null) {
            C0153bs c0153bs = (C0153bs) ((C0770ab) obj2).m3290c();
            C1786r.m6063c("ch@t[" + c0153bs.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ResultCode : " + c0153bs.m1270f().m1467d() + ", ResultMessage : " + c0153bs.m1270f().m1469f() + ", InBoxNo : " + this.f2262m + ", ReceivedTime : " + String.valueOf(c0153bs.m1272h()) + ", MsgID : " + c0153bs.m1268d(), getClass().getSimpleName());
            int iM1467d = c0153bs.m1270f().m1467d();
            if (iM1467d == 1000 || iM1467d == 1001 || iM1467d == 3005) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f2260k) {
                    C0670n.m3087c(this.f2261l, this.f2262m, str);
                    sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.INVITE.m3171a()), str, C0493bg.m2684a(C0657a.m2983c(this.f2261l, str))));
                    sb.append(";");
                }
                C0665i.m3040a(this.f2261l, this.f2262m, sb.toString(), c0153bs.m1272h(), C1789u.m6075a().getString("msisdn", ""));
                C0660d.m3027b(this.f2261l, this.f2262m);
                message.obj = new C0103d(true, iM1467d);
            } else {
                message.obj = new C0103d(false, iM1467d);
            }
            this.f2236b.sendMessage(message);
            return;
        }
        if ((this.f2239e >= f2235a || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C0660d.m3031e(this.f2261l, this.f2262m);
        }
        C1786r.m6063c("Result NULL", getClass().getSimpleName());
        message.obj = new C0103d(false, i);
        this.f2236b.sendMessage(message);
    }
}
