package com.sec.chaton.p074l;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.p126d.p127a.EnumC4988d;
import com.sec.common.p126d.p127a.p128a.C4977a;
import com.sec.common.p126d.p127a.p128a.C4979c;
import com.sec.common.p131f.C4999c;
import com.sec.common.util.C5052r;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: GetMyProfileWorker.java */
/* renamed from: com.sec.chaton.l.j */
/* loaded from: classes.dex */
class CallableC2492j implements InterfaceC2493k, Callable<Bitmap> {

    /* renamed from: a */
    private Context f8939a;

    /* renamed from: b */
    private int f8940b;

    /* renamed from: c */
    private EnumC2508z f8941c;

    public CallableC2492j(Context context, EnumC2508z enumC2508z, int i) {
        this.f8939a = context;
        this.f8941c = enumC2508z;
        this.f8940b = i;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() throws Throwable {
        String strM19199a;
        File fileM10756a = C2496n.m10756a(this.f8939a, this.f8940b);
        if (!fileM10756a.exists()) {
            String strM18450b = C4865cc.m18450b(EnumC4868cf.FILE);
            if (TextUtils.isEmpty(strM18450b)) {
                throw new IOException("contact server address is invalid.");
            }
            String str = strM18450b + "/profileimage";
            if (this.f8940b != 0) {
                strM19199a = C5052r.m19199a("imei", "=", C4822an.m18228d(), "&", "size", "=", String.valueOf(this.f8940b));
            } else {
                strM19199a = C5052r.m19199a("imei", "=", C4822an.m18228d());
            }
            C4977a c4977a = new C4977a();
            c4977a.m18930a(EnumC4988d.GET);
            c4977a.mo10630a(str);
            c4977a.m18935b("uid", C4809aa.m18104a().m18121a("uid", ""));
            c4977a.m18935b("param", m10744a(strM19199a));
            c4977a.m18935b("r", String.valueOf(System.currentTimeMillis()));
            c4977a.m18898a(fileM10756a);
            c4977a.m18899c(true);
            if (new C4979c(c4977a).call().m18953m() == 204) {
                return C2496n.f8946a;
            }
        } else if (fileM10756a.length() == 0) {
            return C2496n.f8946a;
        }
        return new C4999c().m18976a(fileM10756a).m18975a(Bitmap.Config.RGB_565).m18969a();
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return this.f8941c.m10808a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2493k interfaceC2493k) {
        long jMo10714b = mo10714b() - interfaceC2493k.mo10714b();
        if (jMo10714b < 0) {
            return -1;
        }
        if (jMo10714b == 0) {
            return 0;
        }
        return 1;
    }

    /* renamed from: a */
    private String m10744a(String str) throws IOException {
        try {
            String strM18595a = GlobalApplication.m10284c().m18595a();
            if (TextUtils.isEmpty(strM18595a)) {
                throw new IOException("Fail in getting a key");
            }
            String strM18098a = C4808a.m18098a(new C4808a(C4808a.m18100b(strM18595a), C4808a.m18101c(strM18595a)).m18102b(str.getBytes()));
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("paramBefore: " + str, ", paramAfter: ", strM18098a), "GetMyProfileWorker");
            }
            return strM18098a;
        } catch (Exception e) {
            throw new IOException("Encryption Error");
        }
    }
}
