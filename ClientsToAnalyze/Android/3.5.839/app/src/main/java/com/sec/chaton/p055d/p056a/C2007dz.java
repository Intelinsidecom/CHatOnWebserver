package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.C0922ev;
import com.sec.chaton.p046a.C0925ey;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PushConnectivityReceiveTask.java */
/* renamed from: com.sec.chaton.d.a.dz */
/* loaded from: classes.dex */
public class C2007dz extends AbstractC1927b {

    /* renamed from: h */
    private final String f7376h;

    /* renamed from: i */
    private C0922ev f7377i;

    public C2007dz(Handler handler, C0922ev c0922ev) {
        super(handler);
        this.f7376h = getClass().getSimpleName();
        this.f7377i = c0922ev;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        ArrayList arrayList = new ArrayList();
        Iterator<C0925ey> it = this.f7377i.m5013e().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Message message = new Message();
        message.what = 48;
        C2009ea c2009ea = new C2009ea(true, 1000);
        c2009ea.m9154a(arrayList);
        message.obj = c2009ea;
        if (C4904y.f17873c) {
            C4904y.m18641c("Receive push connectivity. buddyId:" + ((C0925ey) arrayList.get(0)).m5043d() + ", push enable:" + ((C0925ey) arrayList.get(0)).m5045f(), this.f7376h);
        }
        this.f7186b.sendMessage(message);
    }
}
