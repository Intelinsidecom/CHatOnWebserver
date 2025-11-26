package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1739gl;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p046a.C0982r;
import com.sec.chaton.p046a.C0985u;
import com.sec.chaton.p046a.C0986v;
import com.sec.chaton.p046a.C0988x;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AnswerBackTask.java */
/* renamed from: com.sec.chaton.d.a.k */
/* loaded from: classes.dex */
public class C2052k extends AbstractC1927b {

    /* renamed from: h */
    private C0982r f7506h;

    /* renamed from: i */
    private ContentResolver f7507i;

    /* renamed from: j */
    private String f7508j;

    public C2052k(Handler handler, String str, C0982r c0982r) {
        super(handler);
        this.f7506h = c0982r;
        this.f7507i = CommonApplication.m18732r().getContentResolver();
        this.f7508j = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        C0986v c0986vNewBuilder = C0985u.newBuilder();
        List<C0988x> listM5935c = this.f7506h.m5935c();
        ArrayList arrayList = new ArrayList();
        Long.valueOf(0L);
        for (C0988x c0988x : listM5935c) {
            Long lValueOf = Long.valueOf(c0988x.m6019f());
            String strM6017d = c0988x.m6017d();
            if (!TextUtils.isEmpty(strM6017d) && !strM6017d.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                arrayList.add(C1739gl.m8663a(lValueOf.longValue(), strM6017d));
            }
            c0986vNewBuilder.m5994a(c0988x);
        }
        if (C4904y.f17876f) {
            StringBuilder sb = new StringBuilder();
            sb.append("ch@t[c <~~ s]received= MsgID : ");
            for (int i = 0; i < listM5935c.size(); i++) {
                sb.append(listM5935c.get(i).m6019f() + ",");
            }
            sb.append(" API type : ").append(10);
            C4904y.m18647f(sb.toString(), getClass().getSimpleName());
        }
        C1736gi.m8647b(this.f7508j, (ArrayList<C1739gl>) arrayList);
        if (ChatFragment.m8214x()) {
            m9187c();
        }
        c0986vNewBuilder.m5995a(C4809aa.m18104a().m18121a("uid", ""));
        if (C4904y.f17872b) {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < this.f7506h.m5935c().size(); i2++) {
                sb2.append("[" + i2 + "]MsgID = " + this.f7506h.m5933a(i2).m6019f()).append(", Receiver = " + this.f7506h.m5933a(i2).m6017d());
            }
            C4904y.m18641c("ch@t[" + this.f7506h.getClass().getSimpleName() + "]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", AnswerbackItemsCount : " + this.f7506h.m5936d() + ",Items : " + sb2.toString(), getClass().getSimpleName());
            StringBuilder sb3 = new StringBuilder();
            for (int i3 = 0; i3 < c0986vNewBuilder.m6003f().size(); i3++) {
                sb3.append("[" + i3 + "]MsgID = " + c0986vNewBuilder.m5996a(i3).m6019f()).append(", Receiver = " + c0986vNewBuilder.m5996a(i3).m6017d());
            }
            C4904y.m18641c("ch@t[" + c0986vNewBuilder.getClass().getSimpleName() + "]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", AnswerbackItemsCount : " + c0986vNewBuilder.m6004g() + ",Items : " + sb3.toString(), getClass().getSimpleName());
        }
        if (C4904y.f17876f) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ch@t[c ~~> s] MsgID : ");
            for (int i4 = 0; i4 < c0986vNewBuilder.m6003f().size(); i4++) {
                sb4.append(c0986vNewBuilder.m5996a(i4).m6019f() + ",");
            }
            sb4.append(" API type : ").append(11);
            C4904y.m18647f(sb4.toString(), getClass().getSimpleName());
        }
        C2427ap c2427ap = new C2427ap();
        c2427ap.m10519a(c0986vNewBuilder.build()).m10517a(11);
        return c2427ap.m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
    }

    /* renamed from: c */
    private void m9187c() {
        ChatFragment.m8075b(false);
        new AsyncTaskC2053l(this).execute(new Void[0]);
    }
}
