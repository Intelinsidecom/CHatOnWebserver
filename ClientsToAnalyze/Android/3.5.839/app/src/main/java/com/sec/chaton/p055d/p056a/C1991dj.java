package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.C0883dj;
import com.sec.chaton.p046a.C0884dk;
import com.sec.chaton.p046a.EnumC0822bc;
import com.sec.chaton.p046a.EnumC0824be;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: IsTypingSendTask.java */
/* renamed from: com.sec.chaton.d.a.dj */
/* loaded from: classes.dex */
public class C1991dj extends AbstractC1927b {

    /* renamed from: h */
    private EnumC2300t f7306h;

    /* renamed from: i */
    private EnumC1992dk f7307i;

    /* renamed from: j */
    private int f7308j;

    /* renamed from: k */
    private String f7309k;

    /* renamed from: l */
    private String f7310l;

    /* renamed from: m */
    private String f7311m;

    public C1991dj(Handler handler, String str, EnumC2300t enumC2300t, EnumC1992dk enumC1992dk, int i, String str2, String str3) {
        super(handler, 1);
        this.f7306h = enumC2300t;
        this.f7307i = enumC1992dk;
        this.f7308j = i;
        this.f7309k = str2;
        this.f7310l = str3;
        this.f7311m = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        C0884dk c0884dkM4561c = C0883dj.newBuilder().m4554a(EnumC0822bc.m3576a(this.f7306h.m10210a())).m4555a(EnumC0824be.m3578a(this.f7307i.m9142a())).m4551a(this.f7308j).m4559b(C4809aa.m18104a().m18121a("chaton_id", "")).m4557a(this.f7309k).m4561c(this.f7310l);
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            sb.append("[Send]").append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNO : ").append(this.f7311m).append(", ").append("ChatType : ").append(c0884dkM4561c.m4564f()).append(", ").append("SessionID : ").append(c0884dkM4561c.m4565g()).append(", ").append("Sender : ").append(c0884dkM4561c.m4566h()).append(", ").append("State : ").append(c0884dkM4561c.m4567i()).append(", ").append("ContentType : ").append(c0884dkM4561c.m4568j()).append(", ").append("RefreshTime : ").append(c0884dkM4561c.m4569k());
            C4904y.m18641c(sb.toString(), "IsTypingSendTask");
        }
        return new C2427ap().m10517a(24).m10519a(c0884dkM4561c.build()).m10518a(C1433g.m7530d()).m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onPostExecute", "IsTypingSendTask");
        }
        if (this.f7186b != null) {
            Message message = new Message();
            message.what = 109;
            message.obj = new C0788l(true, i, -1L);
            this.f7186b.sendMessage(message);
        }
    }
}
