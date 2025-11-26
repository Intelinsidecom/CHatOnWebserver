package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.chat.C0494bh;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0121an;
import com.sec.chaton.p007a.C0122ao;
import com.sec.chaton.p007a.C0123ap;
import com.sec.chaton.p007a.C0144bj;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.Iterator;

/* compiled from: DeliveryChatReplyTask.java */
/* renamed from: com.sec.chaton.d.a.q */
/* loaded from: classes.dex */
public class C0601q extends AbstractC0559b {

    /* renamed from: h */
    private String f2364h;

    /* renamed from: i */
    private EnumC0695j f2365i;

    /* renamed from: j */
    private String f2366j;

    /* renamed from: k */
    private C0494bh f2367k;

    /* renamed from: l */
    private ContentResolver f2368l;

    public C0601q(Handler handler, String str, EnumC0695j enumC0695j, String str2) {
        super(handler);
        this.f2364h = str;
        this.f2365i = enumC0695j;
        this.f2366j = str2;
        this.f2368l = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        this.f2367k = C0494bh.m2692b(this.f2364h);
        C0122ao c0122aoM891a = C0121an.newBuilder().m891a(C1789u.m6075a().getString("uid", ""));
        Iterator it = this.f2367k.m2696c().iterator();
        while (it.hasNext()) {
            C0144bj c0144bj = (C0144bj) it.next();
            c0122aoM891a.m889a(C0123ap.newBuilder().m927a(c0144bj.m1116h()).m931a(c0144bj.m1112d()).m930a(c0144bj.m1122n()).m933b(C1789u.m6075a().getString("msisdn", "")).build());
        }
        this.f2367k.m2693a();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c0122aoM891a.m898f().size(); i++) {
            sb.append("[" + i + "] Receiver : " + c0122aoM891a.m892a(i).m916f()).append(", MsgType : " + c0122aoM891a.m892a(i).m920j()).append(", MsgID : " + c0122aoM891a.m892a(i).m918h()).append(", Sender : " + c0122aoM891a.m892a(i).m914d());
        }
        C1786r.m6063c("ch@t[" + c0122aoM891a.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", DeliveryChatReplyItemsCount: " + c0122aoM891a.m899g() + sb.toString(), getClass().getSimpleName());
        return new C0771ac().m3294a(7).m3296a(c0122aoM891a.build()).m3295a(30000L).m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
    }
}
