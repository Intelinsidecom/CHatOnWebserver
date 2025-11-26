package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.C0094f;
import android.support.v4.p008c.C0081d;
import android.support.v4.p008c.C0088n;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* renamed from: android.support.v4.app.ao */
/* loaded from: classes.dex */
class C0029ao extends AbstractC0027am {

    /* renamed from: a */
    static boolean f107a = false;

    /* renamed from: b */
    final C0088n<C0030ap> f108b = new C0088n<>();

    /* renamed from: c */
    final C0088n<C0030ap> f109c = new C0088n<>();

    /* renamed from: d */
    final String f110d;

    /* renamed from: e */
    FragmentActivity f111e;

    /* renamed from: f */
    boolean f112f;

    /* renamed from: g */
    boolean f113g;

    /* renamed from: h */
    boolean f114h;

    C0029ao(String str, FragmentActivity fragmentActivity, boolean z) {
        this.f110d = str;
        this.f111e = fragmentActivity;
        this.f112f = z;
    }

    /* renamed from: a */
    void m117a(FragmentActivity fragmentActivity) {
        this.f111e = fragmentActivity;
    }

    /* renamed from: c */
    private C0030ap m115c(int i, Bundle bundle, InterfaceC0028an<Object> interfaceC0028an) {
        C0030ap c0030ap = new C0030ap(this, i, bundle, interfaceC0028an);
        c0030ap.f118d = interfaceC0028an.mo112a(i, bundle);
        return c0030ap;
    }

    /* renamed from: d */
    private C0030ap m116d(int i, Bundle bundle, InterfaceC0028an<Object> interfaceC0028an) {
        try {
            this.f114h = true;
            C0030ap c0030apM115c = m115c(i, bundle, interfaceC0028an);
            m118a(c0030apM115c);
            return c0030apM115c;
        } finally {
            this.f114h = false;
        }
    }

    /* renamed from: a */
    void m118a(C0030ap c0030ap) {
        this.f108b.m299b(c0030ap.f115a, c0030ap);
        if (this.f112f) {
            c0030ap.m127a();
        }
    }

    @Override // android.support.v4.app.AbstractC0027am
    /* renamed from: a */
    public <D> C0094f<D> mo108a(int i, Bundle bundle, InterfaceC0028an<D> interfaceC0028an) {
        if (this.f114h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C0030ap c0030apM295a = this.f108b.m295a(i);
        if (f107a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (c0030apM295a == null) {
            c0030apM295a = m116d(i, bundle, interfaceC0028an);
            if (f107a) {
                Log.v("LoaderManager", "  Created new loader " + c0030apM295a);
            }
        } else {
            if (f107a) {
                Log.v("LoaderManager", "  Re-using existing loader " + c0030apM295a);
            }
            c0030apM295a.f117c = interfaceC0028an;
        }
        if (c0030apM295a.f119e && this.f112f) {
            c0030apM295a.m131b(c0030apM295a.f118d, c0030apM295a.f121g);
        }
        return (C0094f<D>) c0030apM295a.f118d;
    }

    @Override // android.support.v4.app.AbstractC0027am
    /* renamed from: b */
    public <D> C0094f<D> mo111b(int i, Bundle bundle, InterfaceC0028an<D> interfaceC0028an) {
        if (this.f114h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C0030ap c0030apM295a = this.f108b.m295a(i);
        if (f107a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        if (c0030apM295a != null) {
            C0030ap c0030apM295a2 = this.f109c.m295a(i);
            if (c0030apM295a2 != null) {
                if (c0030apM295a.f119e) {
                    if (f107a) {
                        Log.v("LoaderManager", "  Removing last inactive loader: " + c0030apM295a);
                    }
                    c0030apM295a2.f120f = false;
                    c0030apM295a2.m135f();
                    c0030apM295a.f118d.m351r();
                    this.f109c.m299b(i, c0030apM295a);
                } else if (!c0030apM295a.f122h) {
                    if (f107a) {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    this.f108b.m299b(i, null);
                    c0030apM295a.m135f();
                } else {
                    if (c0030apM295a.f128n != null) {
                        if (f107a) {
                            Log.v("LoaderManager", "  Removing pending loader: " + c0030apM295a.f128n);
                        }
                        c0030apM295a.f128n.m135f();
                        c0030apM295a.f128n = null;
                    }
                    if (f107a) {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                    }
                    c0030apM295a.f128n = m115c(i, bundle, interfaceC0028an);
                    return (C0094f<D>) c0030apM295a.f128n.f118d;
                }
            } else {
                if (f107a) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + c0030apM295a);
                }
                c0030apM295a.f118d.m351r();
                this.f109c.m299b(i, c0030apM295a);
            }
        }
        return (C0094f<D>) m116d(i, bundle, interfaceC0028an).f118d;
    }

    @Override // android.support.v4.app.AbstractC0027am
    /* renamed from: a */
    public void mo109a(int i) {
        if (this.f114h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (f107a) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        int iM305g = this.f108b.m305g(i);
        if (iM305g >= 0) {
            C0030ap c0030apM304f = this.f108b.m304f(iM305g);
            this.f108b.m302d(iM305g);
            c0030apM304f.m135f();
        }
        int iM305g2 = this.f109c.m305g(i);
        if (iM305g2 >= 0) {
            C0030ap c0030apM304f2 = this.f109c.m304f(iM305g2);
            this.f109c.m302d(iM305g2);
            c0030apM304f2.m135f();
        }
        if (this.f111e != null && !mo110a()) {
            this.f111e.f45b.m224e();
        }
    }

    /* renamed from: b */
    void m120b() {
        if (f107a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f112f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
        } else {
            this.f112f = true;
            for (int iM297b = this.f108b.m297b() - 1; iM297b >= 0; iM297b--) {
                this.f108b.m304f(iM297b).m127a();
            }
        }
    }

    /* renamed from: c */
    void m121c() {
        if (f107a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f112f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
        } else {
            for (int iM297b = this.f108b.m297b() - 1; iM297b >= 0; iM297b--) {
                this.f108b.m304f(iM297b).m134e();
            }
            this.f112f = false;
        }
    }

    /* renamed from: d */
    void m122d() {
        if (f107a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f112f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
        } else {
            this.f113g = true;
            this.f112f = false;
            for (int iM297b = this.f108b.m297b() - 1; iM297b >= 0; iM297b--) {
                this.f108b.m304f(iM297b).m130b();
            }
        }
    }

    /* renamed from: e */
    void m123e() {
        if (this.f113g) {
            if (f107a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f113g = false;
            for (int iM297b = this.f108b.m297b() - 1; iM297b >= 0; iM297b--) {
                this.f108b.m304f(iM297b).m132c();
            }
        }
    }

    /* renamed from: f */
    void m124f() {
        for (int iM297b = this.f108b.m297b() - 1; iM297b >= 0; iM297b--) {
            this.f108b.m304f(iM297b).f125k = true;
        }
    }

    /* renamed from: g */
    void m125g() {
        for (int iM297b = this.f108b.m297b() - 1; iM297b >= 0; iM297b--) {
            this.f108b.m304f(iM297b).m133d();
        }
    }

    /* renamed from: h */
    void m126h() {
        if (!this.f113g) {
            if (f107a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int iM297b = this.f108b.m297b() - 1; iM297b >= 0; iM297b--) {
                this.f108b.m304f(iM297b).m135f();
            }
            this.f108b.m300c();
        }
        if (f107a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int iM297b2 = this.f109c.m297b() - 1; iM297b2 >= 0; iM297b2--) {
            this.f109c.m304f(iM297b2).m135f();
        }
        this.f109c.m300c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0081d.m262a(this.f111e, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: a */
    public void m119a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f108b.m297b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f108b.m297b(); i++) {
                C0030ap c0030apM304f = this.f108b.m304f(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f108b.m303e(i));
                printWriter.print(": ");
                printWriter.println(c0030apM304f.toString());
                c0030apM304f.m129a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f109c.m297b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f109c.m297b(); i2++) {
                C0030ap c0030apM304f2 = this.f109c.m304f(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f109c.m303e(i2));
                printWriter.print(": ");
                printWriter.println(c0030apM304f2.toString());
                c0030apM304f2.m129a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // android.support.v4.app.AbstractC0027am
    /* renamed from: a */
    public boolean mo110a() {
        int iM297b = this.f108b.m297b();
        boolean z = false;
        for (int i = 0; i < iM297b; i++) {
            C0030ap c0030apM304f = this.f108b.m304f(i);
            z |= c0030apM304f.f122h && !c0030apM304f.f120f;
        }
        return z;
    }
}
