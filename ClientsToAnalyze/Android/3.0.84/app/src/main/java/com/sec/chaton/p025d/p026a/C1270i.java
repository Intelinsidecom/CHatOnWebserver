package com.sec.chaton.p025d.p026a;

import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.chat.C1072en;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p016a.C0330c;
import com.sec.chaton.p016a.C0369dl;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p025d.C1304aq;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: AllowChatTask.java */
/* renamed from: com.sec.chaton.d.a.i */
/* loaded from: classes.dex */
public class C1270i extends C1280s {

    /* renamed from: h */
    long f4871h;

    /* renamed from: i */
    EnumC1450r f4872i;

    /* renamed from: j */
    String f4873j;

    /* renamed from: k */
    String f4874k;

    /* renamed from: l */
    String f4875l;

    public C1270i(Handler handler, EnumC1450r enumC1450r, String str, String str2, long j, String str3) {
        this(handler, enumC1450r, str, str2, j, str3, EnumC1751k.f6455d);
    }

    public C1270i(Handler handler, EnumC1450r enumC1450r, String str, String str2, long j, String str3, EnumC1751k enumC1751k) {
        super(handler, enumC1751k);
        this.f4872i = enumC1450r;
        this.f4874k = str2;
        this.f4871h = j;
        this.f4873j = str3;
        this.f4875l = str;
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        super.mo5504b();
        C1759s.m7260a(getClass().getSimpleName(), "onPreExecute()", new Object[0]);
        return C1304aq.m5604a().m5607a(this.f4872i, this.f4875l, this.f4874k, this.f4871h, this.f4873j);
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        super.mo5502a(i, obj, obj2);
        C1759s.m7260a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        Message message = new Message();
        message.what = 2;
        if (obj2 != null) {
            C0330c c0330c = (C0330c) ((C1548ag) obj2).m6575c();
            C1072en.m5301a(this.f4875l, c0330c, getClass().getSimpleName());
            int iM2494d = c0330c.m1997f().m2494d();
            if (iM2494d == 1000 || iM2494d == 3003) {
                message.obj = new C0272i(true, iM2494d, this.f4875l);
            } else {
                if (iM2494d == 2006 || iM2494d == 3008) {
                    C1370n.m6106a(CommonApplication.m11493l().getContentResolver(), this.f4875l, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                } else if (iM2494d != 3006) {
                    if (iM2494d == 7001) {
                        C1089fd.m5358a().m5365a(this.f4875l, this.f4874k, 0L);
                    } else if (iM2494d == 7002) {
                        C1089fd.m5358a().m5361a(this.f4698b, this.f4875l, c0330c.m1997f());
                    } else if (iM2494d == 7003) {
                        C1089fd.m5358a().m5363a(this.f4875l, c0330c.m1997f());
                    }
                }
                message.obj = new C0272i(false, iM2494d, this.f4875l);
            }
            this.f4698b.sendMessage(message);
            return;
        }
        if ((!mo5503a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C1370n.m6141e(CommonApplication.m11493l().getContentResolver(), this.f4875l);
        }
        if (C3250y.f11735c) {
            C1072en.m5301a(this.f4875l, C0330c.newBuilder().m2375a(this.f4871h).m2379a(C0369dl.newBuilder().m2507a(i).m2512a("Fail to send allowChat message")).build(), getClass().getSimpleName());
        }
        message.obj = new C0272i(false, i, this.f4875l);
        this.f4698b.sendMessage(message);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    public boolean mo5503a() {
        if (this.f4893m.m7198a() || !C1757q.m7251b()) {
            return super.mo5503a();
        }
        return false;
    }
}
