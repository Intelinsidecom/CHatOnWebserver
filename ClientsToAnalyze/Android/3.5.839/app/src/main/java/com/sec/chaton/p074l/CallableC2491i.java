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
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.Callable;

/* compiled from: GetGroupProfileWorker.java */
/* renamed from: com.sec.chaton.l.i */
/* loaded from: classes.dex */
class CallableC2491i implements InterfaceC2493k, Callable<Bitmap> {

    /* renamed from: a */
    private Context f8935a;

    /* renamed from: b */
    private String f8936b;

    /* renamed from: c */
    private int f8937c;

    /* renamed from: d */
    private EnumC2508z f8938d;

    public CallableC2491i(Context context, String str, EnumC2508z enumC2508z, int i) {
        this.f8935a = context;
        this.f8936b = str;
        this.f8938d = enumC2508z;
        this.f8937c = i;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() throws IOException {
        String string;
        String strM18595a;
        File fileM10787d = C2496n.m10787d(this.f8935a, this.f8936b, this.f8937c);
        if (!fileM10787d.exists()) {
            String strM18450b = C4865cc.m18450b(EnumC4868cf.FILE);
            if (TextUtils.isEmpty(strM18450b)) {
                throw new IOException("Contact server address is invalid.");
            }
            if (this.f8937c != 0) {
                string = new StringBuffer().append("imei=").append(C4822an.m18228d()).append("&groupname=").append(this.f8936b).append("&r=").append(String.valueOf(System.currentTimeMillis())).append("&size=").append(String.valueOf(this.f8937c)).toString();
            } else {
                string = new StringBuffer().append("imei=").append(C4822an.m18228d()).append("&groupname=").append(this.f8936b).append("&r=").append(String.valueOf(System.currentTimeMillis())).toString();
            }
            try {
                strM18595a = GlobalApplication.m10284c().m18595a();
            } catch (Exception e) {
                C4904y.m18634a("Encryption Error", "HttpMessageControl");
            }
            if (TextUtils.isEmpty(strM18595a)) {
                throw new IOException("Fail in getting a key");
            }
            string = C4808a.m18098a(new C4808a(C4808a.m18100b(strM18595a), C4808a.m18101c(strM18595a)).m18102b(string.getBytes()));
            String str = strM18450b + "/buddy/group/" + URLEncoder.encode(this.f8936b, "UTF-8") + "/image";
            C4977a c4977a = new C4977a();
            c4977a.m18930a(EnumC4988d.GET);
            c4977a.mo10630a(str);
            c4977a.m18935b("uid", C4809aa.m18104a().m18121a("uid", ""));
            c4977a.m18935b("param", string);
            c4977a.m18898a(fileM10787d);
            c4977a.m18899c(true);
            if (new C4979c(c4977a).call().m18953m() == 204) {
                return C2496n.f8946a;
            }
        } else if (fileM10787d.length() == 0) {
            return C2496n.f8946a;
        }
        return new C4999c().m18976a(fileM10787d).m18975a(Bitmap.Config.RGB_565).m18969a();
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return this.f8938d.m10808a();
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
