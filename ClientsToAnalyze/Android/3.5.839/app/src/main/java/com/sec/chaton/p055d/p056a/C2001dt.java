package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.p046a.C0902eb;
import com.sec.chaton.p046a.C0905ee;
import com.sec.chaton.p046a.C0906ef;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: MirrorAcknowledgeTask.java */
/* renamed from: com.sec.chaton.d.a.dt */
/* loaded from: classes.dex */
public class C2001dt extends AbstractC1927b {

    /* renamed from: h */
    private final String f7356h;

    /* renamed from: i */
    private C0902eb f7357i;

    /* renamed from: j */
    private ContentResolver f7358j;

    /* renamed from: k */
    private String f7359k;

    public C2001dt(Handler handler, String str, C0902eb c0902eb) {
        super(handler);
        this.f7356h = "MirrorAcknowledgeTask";
        this.f7357i = c0902eb;
        this.f7358j = CommonApplication.m18732r().getContentResolver();
        this.f7359k = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() throws Throwable {
        String strM4821d = this.f7357i.m4821d();
        Long lValueOf = Long.valueOf(this.f7357i.m4823f());
        String strM4825h = this.f7357i.m4825h();
        if (C4904y.f17876f) {
            StringBuilder sb = new StringBuilder();
            sb.append("ch@t[c <~~ s]received= MsgID : ").append(lValueOf);
            sb.append(", API type : ").append(46);
            C4904y.m18647f(sb.toString(), getClass().getSimpleName());
        }
        C1734gg.m8601a(this.f7359k, this.f7357i, "MirrorAcknowledgeTask");
        if (C1813b.m8906b().m8931a(this.f7359k)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("front inbox - so do not update read status", "MirrorAcknowledgeTask");
            }
        } else {
            String strM10027a = C2204r.m10027a(strM4825h, lValueOf.longValue(), true);
            if (!TextUtils.isEmpty(strM10027a)) {
                C0991aa.m6037a().m18961c(new C1015an(new String[]{strM10027a}));
                C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
                C1813b.m8906b().m8922a(strM10027a, C1813b.f6838g);
            }
        }
        C0906ef c0906efNewBuilder = C0905ee.newBuilder();
        c0906efNewBuilder.m4878a(C4809aa.m18104a().m18121a("uid", ""));
        c0906efNewBuilder.m4881b(strM4821d);
        if (C4904y.f17876f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ch@t[c ~~> s] MsgID : ").append(lValueOf);
            sb2.append(", API type : ").append(47);
            C4904y.m18647f(sb2.toString(), getClass().getSimpleName());
        }
        C1734gg.m8602a(this.f7359k, c0906efNewBuilder.build(), "MirrorAcknowledgeTask");
        C2427ap c2427ap = new C2427ap();
        c2427ap.m10519a(c0906efNewBuilder.build()).m10517a(47);
        return c2427ap.m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
    }
}
