package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.C0883dj;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: IsTypingReceiveTask.java */
/* renamed from: com.sec.chaton.d.a.dh */
/* loaded from: classes.dex */
public class C1989dh extends AbstractC1927b {

    /* renamed from: h */
    private C0883dj f7300h;

    /* renamed from: i */
    private String f7301i;

    public C1989dh(Handler handler, C0883dj c0883dj, String str) {
        super(handler);
        this.f7300h = c0883dj;
        this.f7301i = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        String strM4534h = this.f7300h.m4534h();
        int iM4540n = this.f7300h.m4540n();
        String strM4536j = this.f7300h.m4536j();
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            sb.append("[Received]").append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNO : ").append(this.f7301i).append(", ").append("ChatType : ").append(this.f7300h.m4530d()).append(", ").append("SessionID : ").append(this.f7300h.m4532f()).append(", ").append("Sender : ").append(strM4534h).append(", ").append("State : ").append(strM4536j).append(", ").append("ContentType : ").append(this.f7300h.m4538l()).append(", ").append("RefreshTime : ").append(String.valueOf(iM4540n));
            C4904y.m18641c(sb.toString(), "IsTypingReceiveTask");
        }
        Message message = new Message();
        message.what = 24;
        message.obj = new C1990di(this, true, 1000, strM4534h, iM4540n, strM4536j);
        this.f7186b.sendMessage(message);
    }
}
