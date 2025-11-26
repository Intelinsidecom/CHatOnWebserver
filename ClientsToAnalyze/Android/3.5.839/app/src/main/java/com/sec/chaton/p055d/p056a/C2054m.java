package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.p046a.C0793aa;
import com.sec.chaton.p046a.C0796ad;
import com.sec.chaton.p046a.C0797ae;
import com.sec.chaton.p046a.C0799ag;
import com.sec.chaton.p046a.C0800ah;
import com.sec.chaton.p046a.EnumC0822bc;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AsyncEndChatTask.java */
/* renamed from: com.sec.chaton.d.a.m */
/* loaded from: classes.dex */
public class C2054m extends AbstractC1981d {

    /* renamed from: h */
    private ArrayList<C0799ag> f7510h;

    /* renamed from: i */
    private ArrayList<String> f7511i;

    /* renamed from: j */
    private String f7512j;

    /* renamed from: k */
    private String f7513k;

    /* renamed from: l */
    private ContentResolver f7514l;

    public C2054m(Handler handler, ArrayList<String> arrayList) {
        super(handler);
        this.f7511i = (ArrayList) arrayList.clone();
        this.f7513k = C4809aa.m18104a().m18121a("uid", "");
        this.f7512j = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f7514l = CommonApplication.m18732r().getContentResolver();
        this.f7510h = null;
        this.f7190f = -1L;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        C0797ae c0797aeNewBuilder = C0796ad.newBuilder();
        if (this.f7190f == -1) {
            this.f7190f = C4843bh.m18322a();
        }
        this.f7510h = m9190a(this.f7511i);
        c0797aeNewBuilder.m3222a(this.f7190f);
        c0797aeNewBuilder.m3227a(this.f7513k);
        c0797aeNewBuilder.m3229b(this.f7512j);
        c0797aeNewBuilder.m3226a(this.f7510h);
        C4904y.m18641c("ch@t[AsyncEndChatReqeust] UID : " + this.f7513k + ", MsgID : " + this.f7190f + ", Sender : " + this.f7512j, "AsyncEndChatTask");
        return new C2427ap().m10519a(c0797aeNewBuilder.build()).m10517a(25).m10518a(C1433g.m7529c()).m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        super.mo9092a(i, obj, obj2);
        Message message = new Message();
        message.what = 25;
        if (obj2 != null) {
            C2426ao c2426ao = (C2426ao) obj2;
            switch (c2426ao.m10512b()) {
                case 26:
                    C0793aa c0793aa = (C0793aa) c2426ao.m10513c();
                    C4904y.m18641c("ch@t[AsyncEndChatReply]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ResultCode : " + c0793aa.m3174f().m5229d() + ", ResultMessage : " + c0793aa.m3174f().m5231f() + ", MsgID : " + c0793aa.m3172d(), getClass().getSimpleName());
                    int iM5229d = c0793aa.m3174f().m5229d();
                    if (iM5229d == 1000) {
                        C2198l.m9932a(this.f7514l, this.f7511i);
                        C1813b.m8906b().m8934b(C1813b.f6835d);
                        message.obj = new C0788l(true, iM5229d);
                        C0991aa.m6037a().m18961c(new C1015an((String[]) this.f7511i.toArray(new String[0])));
                        break;
                    } else {
                        message.obj = new C0788l(false, iM5229d);
                        break;
                    }
            }
            this.f7186b.sendMessage(message);
        } else {
            if ((!mo9104a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
                C2198l.m9953f(this.f7514l, this.f7511i.get(0));
                C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7511i.get(0)}));
            }
            C4904y.m18641c("Fail to send endChat message", getClass().getSimpleName());
            message.obj = new C0788l(false, i);
            this.f7186b.sendMessage(message);
        }
        this.f7511i.clear();
        this.f7510h.clear();
    }

    /* renamed from: a */
    private ArrayList<C0799ag> m9190a(ArrayList<String> arrayList) {
        ArrayList<C0799ag> arrayList2 = new ArrayList<>();
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        EnumC2300t enumC2300t = EnumC2300t.UNKNOWN;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            C0800ah c0800ahNewBuilder = C0799ag.newBuilder();
            C2201o c2201oM9951e = C2198l.m9951e(contentResolver, next);
            if (c2201oM9951e != null) {
                long j = c2201oM9951e.f7856s;
                String str = c2201oM9951e.f7846i;
                EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(c2201oM9951e.f7840c);
                c0800ahNewBuilder.m3268a(m9191b(C2176ab.m9691d(contentResolver, next)));
                c0800ahNewBuilder.m3267a(EnumC0822bc.m3576a(enumC2300tM10207a.m10210a()));
                c0800ahNewBuilder.m3269a(str);
                c0800ahNewBuilder.m3264a(j);
                arrayList2.add(c0800ahNewBuilder.build());
            }
        }
        return arrayList2;
    }

    /* renamed from: b */
    private ArrayList<String> m9191b(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2.add(arrayList.get(0));
            return arrayList2;
        }
        return arrayList;
    }
}
