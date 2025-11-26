package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0262ab;
import com.sec.chaton.p015b.C0317cc;
import com.sec.chaton.p015b.C0322ch;
import com.sec.chaton.p015b.C0344r;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.List;

/* compiled from: AnswerBackTask.java */
/* renamed from: com.sec.chaton.a.a.q */
/* loaded from: classes.dex */
public class C0178q extends AbstractC0164c {

    /* renamed from: h */
    private C0322ch f427h;

    /* renamed from: i */
    private Handler f428i;

    /* renamed from: j */
    private List f429j;

    /* renamed from: k */
    private ContentResolver f430k;

    public C0178q(Handler handler, C0322ch c0322ch) {
        super(handler);
        this.f428i = handler;
        this.f427h = c0322ch;
        this.f430k = GlobalApplication.m3100a().getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        C0262ab c0262abNewBuilder = C0317cc.newBuilder();
        this.f429j = this.f427h.m1746c();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f429j.size(); i++) {
            ((C0344r) this.f429j.get(i)).m1958f();
            this.f430k.update(C0662o.m2996a(String.valueOf(((C0344r) this.f429j.get(i)).m1958f())), null, null, null);
            c0262abNewBuilder.m971a((C0344r) this.f429j.get(i));
        }
        for (int i2 = 0; i2 < this.f427h.m1746c().size(); i2++) {
            sb.append("[" + i2 + "]MsgID = " + this.f427h.m1744a(i2).m1958f()).append(", Receiver = " + this.f427h.m1744a(i2).m1956d());
        }
        C1341p.m4660c("ch@t[" + this.f427h.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", AnswerbackItemsCount : " + this.f427h.m1747d() + ",Items : " + sb.toString(), getClass().getSimpleName());
        c0262abNewBuilder.m972a(C1323bs.m4575a().getString("uid", ""));
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < c0262abNewBuilder.m979f().size(); i3++) {
            sb2.append("[" + i3 + "]MsgID = " + c0262abNewBuilder.m973a(i3).m1958f()).append(", Receiver = " + c0262abNewBuilder.m973a(i3).m1956d());
        }
        C1341p.m4660c("ch@t[" + c0262abNewBuilder.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", AnswerbackItemsCount : " + c0262abNewBuilder.m980g() + ",Items : " + sb2.toString(), getClass().getSimpleName());
        C0507n c0507n = new C0507n();
        c0507n.m2558a(c0262abNewBuilder.build()).m2556a(11);
        return c0507n.m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
    }
}
