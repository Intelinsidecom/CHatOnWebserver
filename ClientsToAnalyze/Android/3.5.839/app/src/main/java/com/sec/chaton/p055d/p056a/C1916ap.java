package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.util.Log;
import com.sec.chaton.chat.C1742go;
import com.sec.chaton.p046a.C0829bj;
import com.sec.chaton.p046a.C0830bk;
import com.sec.chaton.p046a.C0831bl;
import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p063i.p064a.C2405b;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: DeliveryChatReplyTask.java */
/* renamed from: com.sec.chaton.d.a.ap */
/* loaded from: classes.dex */
public class C1916ap extends AbstractC1927b {

    /* renamed from: h */
    private String f7143h;

    /* renamed from: i */
    private C1742go f7144i;

    public C1916ap(Handler handler, String str, EnumC2300t enumC2300t, String str2) {
        super(handler);
        this.f7143h = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() throws JSONException {
        this.f7144i = C1742go.m8667b(this.f7143h);
        C2405b c2405b = new C2405b();
        c2405b.m19139c(String.format("%04d%s", 7, "0001"));
        StringBuilder sb = new StringBuilder();
        C0830bk c0830bkM3676a = C0829bj.newBuilder().m3676a(C4809aa.m18104a().m18121a("uid", ""));
        Iterator<C0864cr> it = this.f7144i.m8672c().iterator();
        while (it.hasNext()) {
            C0864cr next = it.next();
            c0830bkM3676a.m3674a(C0831bl.newBuilder().m3715a(next.m4154h()).m3719a(next.m4150d()).m3718a(next.m4160n()).m3721b(C4809aa.m18104a().m18121a("chaton_id", "")).build());
            sb.append(next.m4154h()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        c2405b.m10432a(sb.toString());
        Log.wtf("CH", c2405b.toString());
        this.f7144i.m8668a();
        if (C4904y.f17873c) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < c0830bkM3676a.m3685f().size(); i++) {
                sb2.append("[" + i + "] Receiver : " + c0830bkM3676a.m3677a(i).m3704f()).append(", MsgType : " + c0830bkM3676a.m3677a(i).m3708j()).append(", MsgID : " + c0830bkM3676a.m3677a(i).m3706h()).append(", Sender : " + c0830bkM3676a.m3677a(i).m3702d());
            }
            C4904y.m18641c("ch@t[" + c0830bkM3676a.getClass().getSimpleName() + "]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", DeliveryChatReplyItemsCount: " + c0830bkM3676a.m3686g() + sb2.toString(), getClass().getSimpleName());
        }
        return new C2427ap().m10517a(7).m10519a(c0830bkM3676a.build()).m10518a(C1433g.m7529c()).m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
    }
}
