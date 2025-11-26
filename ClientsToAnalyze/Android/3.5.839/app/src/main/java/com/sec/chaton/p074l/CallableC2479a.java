package com.sec.chaton.p074l;

import android.content.Context;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0992ab;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: DeleteBuddyProfileWorker.java */
/* renamed from: com.sec.chaton.l.a */
/* loaded from: classes.dex */
class CallableC2479a implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8886a = CallableC2479a.class.getSimpleName();

    /* renamed from: b */
    private Context f8887b;

    /* renamed from: c */
    private List<String> f8888c;

    /* renamed from: d */
    private boolean f8889d;

    public CallableC2479a(Context context, List<String> list, boolean z) {
        this.f8887b = context;
        this.f8888c = list;
        this.f8889d = z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws IOException {
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.DeleteBuddyProfileWorker", f8886a);
            if (this.f8888c != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < this.f8888c.size(); i++) {
                    String str = this.f8888c.get(i);
                    if (i == this.f8888c.size() - 1) {
                        sb.append(str);
                    } else {
                        sb.append(str + ", ");
                    }
                }
                C4904y.m18639b("Delete List: " + sb.toString(), f8886a);
            }
        }
        if (this.f8888c != null) {
            for (String str2 : this.f8888c) {
                File fileM10757a = C2496n.m10757a(this.f8887b, str2);
                if (fileM10757a.exists() && !fileM10757a.delete()) {
                    throw new IOException("Can't delete buddy profile image. " + fileM10757a);
                }
                File fileM10781c = C2496n.m10781c(this.f8887b, str2, 0);
                if (fileM10781c.exists() && !fileM10781c.delete()) {
                    throw new IOException("Can't delete buddy profile image. " + fileM10781c);
                }
            }
        }
        if (this.f8889d) {
            C0991aa.m6037a().m18962d(new C0992ab(this.f8888c));
            return null;
        }
        return null;
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return EnumC2508z.DELETE.m10808a();
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
