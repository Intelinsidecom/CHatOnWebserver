package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.p008c.C0081d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* renamed from: android.support.v4.content.f */
/* loaded from: classes.dex */
public class C0094f<D> {

    /* renamed from: m */
    int f307m;

    /* renamed from: n */
    InterfaceC0095h<D> f308n;

    /* renamed from: o */
    Context f309o;

    /* renamed from: p */
    boolean f310p = false;

    /* renamed from: q */
    boolean f311q = false;

    /* renamed from: r */
    boolean f312r = true;

    /* renamed from: s */
    boolean f313s = false;

    /* renamed from: t */
    boolean f314t = false;

    /* compiled from: Loader.java */
    /* renamed from: android.support.v4.content.g */
    public final class g extends ContentObserver {
        public g() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            C0094f.this.m357x();
        }
    }

    public C0094f(Context context) {
        this.f309o = context.getApplicationContext();
    }

    /* renamed from: b */
    public void mo332b(D d) {
        if (this.f308n != null) {
            this.f308n.mo128a(this, d);
        }
    }

    /* renamed from: j */
    public Context m343j() {
        return this.f309o;
    }

    /* renamed from: k */
    public int m344k() {
        return this.f307m;
    }

    /* renamed from: a */
    public void m340a(int i, InterfaceC0095h<D> interfaceC0095h) {
        if (this.f308n != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f308n = interfaceC0095h;
        this.f307m = i;
    }

    /* renamed from: a */
    public void m341a(InterfaceC0095h<D> interfaceC0095h) {
        if (this.f308n == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.f308n != interfaceC0095h) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f308n = null;
    }

    /* renamed from: l */
    public boolean m345l() {
        return this.f310p;
    }

    /* renamed from: m */
    public boolean m346m() {
        return this.f311q;
    }

    /* renamed from: n */
    public boolean m347n() {
        return this.f312r;
    }

    /* renamed from: o */
    public final void m348o() {
        this.f310p = true;
        this.f312r = false;
        this.f311q = false;
        mo334g();
    }

    /* renamed from: g */
    protected void mo334g() {
    }

    /* renamed from: p */
    public void m349p() {
        mo319a();
    }

    /* renamed from: a */
    protected void mo319a() {
    }

    /* renamed from: q */
    public void m350q() {
        this.f310p = false;
        mo335h();
    }

    /* renamed from: h */
    protected void mo335h() {
    }

    /* renamed from: r */
    public void m351r() {
        this.f311q = true;
        m352s();
    }

    /* renamed from: s */
    protected void m352s() {
    }

    /* renamed from: t */
    public void m353t() {
        mo336i();
        this.f312r = true;
        this.f310p = false;
        this.f311q = false;
        this.f313s = false;
        this.f314t = false;
    }

    /* renamed from: i */
    protected void mo336i() {
    }

    /* renamed from: u */
    public boolean m354u() {
        boolean z = this.f313s;
        this.f313s = false;
        this.f314t |= z;
        return z;
    }

    /* renamed from: v */
    public void m355v() {
        this.f314t = false;
    }

    /* renamed from: w */
    public void m356w() {
        if (this.f314t) {
            this.f313s = true;
        }
    }

    /* renamed from: x */
    public void m357x() {
        if (this.f310p) {
            m349p();
        } else {
            this.f313s = true;
        }
    }

    /* renamed from: c */
    public String m342c(D d) {
        StringBuilder sb = new StringBuilder(64);
        C0081d.m262a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0081d.m262a(this, sb);
        sb.append(" id=");
        sb.append(this.f307m);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo322a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f307m);
        printWriter.print(" mListener=");
        printWriter.println(this.f308n);
        if (this.f310p || this.f313s || this.f314t) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f310p);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f313s);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f314t);
        }
        if (this.f311q || this.f312r) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f311q);
            printWriter.print(" mReset=");
            printWriter.println(this.f312r);
        }
    }
}
