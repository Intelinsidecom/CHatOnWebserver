package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.C0966gl;
import com.sec.chaton.p046a.C0969go;
import com.sec.chaton.p046a.C0970gp;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;

/* compiled from: UndoMessageTask.java */
/* renamed from: com.sec.chaton.d.a.fb */
/* loaded from: classes.dex */
public class C2037fb extends AbstractC1927b {

    /* renamed from: h */
    private final String f7442h;

    /* renamed from: i */
    private C0966gl f7443i;

    public C2037fb(Handler handler, C0966gl c0966gl) {
        super(handler);
        this.f7442h = "UndoMessageTask";
        this.f7443i = c0966gl;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() throws Throwable {
        C1734gg.m8587a(this.f7443i, "UndoMessageTask");
        C2204r.m10029a(this.f7443i.m5663h(), this.f7443i.m5661f());
        C1813b.m8906b().m8920a(C1813b.f6835d, false, true);
        C1828q.m8956a().m8960a(this.f7443i.m5663h(), GlobalApplication.m18732r().getString(R.string.message_is_recalled));
        C0970gp c0970gpM5726a = C0969go.newBuilder().m5729a(C4809aa.m18104a().m18121a("uid", "")).m5732b(C4822an.m18228d()).m5734c(this.f7443i.m5659d()).m5736d(this.f7443i.m5661f()).m5738e(C4809aa.m18104a().m18121a("chaton_id", "")).m5726a(this.f7443i.m5663h());
        C1734gg.m8588a(c0970gpM5726a.build(), "UndoMessageTask");
        return new C2427ap().m10517a(52).m10519a(c0970gpM5726a.build()).m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
    }
}
