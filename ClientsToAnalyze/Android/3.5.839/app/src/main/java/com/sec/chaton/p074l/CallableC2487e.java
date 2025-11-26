package com.sec.chaton.p074l;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.p126d.p127a.EnumC4988d;
import com.sec.common.p126d.p127a.p128a.C4977a;
import com.sec.common.p126d.p127a.p128a.C4979c;
import com.sec.common.p131f.C4999c;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: GetBuddyProfileWorker.java */
/* renamed from: com.sec.chaton.l.e */
/* loaded from: classes.dex */
class CallableC2487e implements InterfaceC2493k, Callable<Bitmap> {

    /* renamed from: a */
    private Context f8920a;

    /* renamed from: b */
    private String f8921b;

    /* renamed from: c */
    private int f8922c;

    /* renamed from: d */
    private EnumC2508z f8923d;

    public CallableC2487e(Context context, String str, EnumC2508z enumC2508z, int i) {
        this.f8920a = context;
        this.f8921b = str;
        this.f8923d = enumC2508z;
        this.f8922c = i;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() throws IOException {
        File fileM10781c = C2496n.m10781c(this.f8920a, this.f8921b, this.f8922c);
        if (!fileM10781c.exists()) {
            String strM18450b = C4865cc.m18450b(EnumC4868cf.CONTACT);
            if (TextUtils.isEmpty(strM18450b)) {
                throw new IOException("Contact server address is invalid.");
            }
            String str = strM18450b + "/check/" + this.f8921b + "/image";
            C4977a c4977a = new C4977a();
            c4977a.m18930a(EnumC4988d.GET);
            c4977a.mo10630a(str);
            c4977a.m18935b("uid", C4809aa.m18104a().m18121a("uid", ""));
            c4977a.m18935b("imei", C4822an.m18228d());
            c4977a.m18935b("mode", "nonbuddy");
            if (this.f8922c != 0) {
                c4977a.m18935b("size", String.valueOf(this.f8922c));
            }
            c4977a.m18935b("r", String.valueOf(System.currentTimeMillis()));
            c4977a.m18898a(fileM10781c);
            c4977a.m18899c(true);
            if (new C4979c(c4977a).call().m18953m() == 204) {
                return C2496n.f8946a;
            }
        } else if (fileM10781c.length() == 0) {
            return C2496n.f8946a;
        }
        return new C4999c().m18976a(fileM10781c).m18975a(Bitmap.Config.RGB_565).m18969a();
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return this.f8923d.m10808a();
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
}
