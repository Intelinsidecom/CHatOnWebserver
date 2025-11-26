package com.sec.chaton.p057e.p059b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4882e;
import com.sec.chaton.util.C4904y;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

/* compiled from: PushReceivedTask.java */
/* renamed from: com.sec.chaton.e.b.n */
/* loaded from: classes.dex */
public class C2253n extends AbstractC2240a {

    /* renamed from: c */
    private static final String f8022c = C2253n.class.getSimpleName();

    /* renamed from: d */
    private String f8023d;

    /* renamed from: e */
    private String f8024e;

    /* renamed from: f */
    private String f8025f;

    /* renamed from: g */
    private boolean f8026g;

    public C2253n(InterfaceC2243d interfaceC2243d, String str, boolean z, String str2, String str3, String str4) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f8026g = z;
        this.f8023d = str2;
        this.f8025f = str4;
        this.f8024e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x06db  */
    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo8896a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p059b.C2253n.mo8896a():java.lang.Object");
    }

    /* renamed from: a */
    private byte[] m10108a(String str, String str2) {
        C4808a c4808a;
        if (!TextUtils.isEmpty(str2)) {
            try {
                c4808a = new C4808a(C4808a.m18100b(str2), C4808a.m18101c(str2));
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
                c4808a = null;
            } catch (InvalidKeyException e2) {
                e2.printStackTrace();
                c4808a = null;
            }
            if (c4808a == null) {
                C4904y.m18634a("AesCipher is null", f8022c);
                return null;
            }
            C4904y.m18641c("Base64 body : " + str, f8022c);
            C4904y.m18641c("Decoded body : " + C4882e.m18534a(str), f8022c);
            return c4808a.m18103c(C4882e.m18534a(str));
        }
        C4904y.m18634a("Fail in getting a key", f8022c);
        return null;
    }
}
