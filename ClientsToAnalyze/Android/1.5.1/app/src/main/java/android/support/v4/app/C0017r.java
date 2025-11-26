package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.r */
/* loaded from: classes.dex */
class C0017r extends LoaderManager {

    /* renamed from: a */
    static boolean f96a = false;

    /* renamed from: b */
    final HCSparseArray f97b = new HCSparseArray();

    /* renamed from: c */
    final HCSparseArray f98c = new HCSparseArray();

    /* renamed from: d */
    FragmentActivity f99d;

    /* renamed from: e */
    boolean f100e;

    /* renamed from: f */
    boolean f101f;

    /* renamed from: g */
    boolean f102g;

    C0017r(FragmentActivity fragmentActivity, boolean z) {
        this.f99d = fragmentActivity;
        this.f100e = z;
    }

    /* renamed from: b */
    private C0004e m120b(int i, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        C0004e c0004e = new C0004e(this, i, bundle, loaderCallbacks);
        c0004e.f33d = loaderCallbacks.mo38a(i, bundle);
        return c0004e;
    }

    /* renamed from: c */
    private C0004e m121c(int i, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        try {
            this.f102g = true;
            C0004e c0004eM120b = m120b(i, bundle, loaderCallbacks);
            m124a(c0004eM120b);
            return c0004eM120b;
        } finally {
            this.f102g = false;
        }
    }

    @Override // android.support.v4.app.LoaderManager
    /* renamed from: a */
    public Loader mo37a(int i, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        if (this.f102g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C0004e c0004e = (C0004e) this.f97b.m22a(i);
        if (f96a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        if (c0004e != null) {
            C0004e c0004e2 = (C0004e) this.f98c.m22a(i);
            if (c0004e2 == null) {
                if (f96a) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + c0004e);
                }
                c0004e.f33d.m160l();
                this.f98c.m26b(i, c0004e);
            } else if (c0004e.f34e) {
                if (f96a) {
                    Log.v("LoaderManager", "  Removing last inactive loader: " + c0004e);
                }
                c0004e2.f35f = false;
                c0004e2.m52f();
                c0004e.f33d.m160l();
                this.f98c.m26b(i, c0004e);
            } else {
                if (c0004e.f37h) {
                    if (c0004e.f43n != null) {
                        if (f96a) {
                            Log.v("LoaderManager", "  Removing pending loader: " + c0004e.f43n);
                        }
                        c0004e.f43n.m52f();
                        c0004e.f43n = null;
                    }
                    if (f96a) {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                    }
                    c0004e.f43n = m120b(i, bundle, loaderCallbacks);
                    return c0004e.f43n.f33d;
                }
                if (f96a) {
                    Log.v("LoaderManager", "  Current loader is stopped; replacing");
                }
                this.f97b.m26b(i, null);
                c0004e.m52f();
            }
        }
        return m121c(i, bundle, loaderCallbacks).f33d;
    }

    /* renamed from: a */
    void m122a() {
        if (f96a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f100e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
        } else {
            this.f100e = true;
            for (int iM21a = this.f97b.m21a() - 1; iM21a >= 0; iM21a--) {
                ((C0004e) this.f97b.m30f(iM21a)).m44a();
            }
        }
    }

    /* renamed from: a */
    void m123a(FragmentActivity fragmentActivity) {
        this.f99d = fragmentActivity;
    }

    /* renamed from: a */
    void m124a(C0004e c0004e) {
        this.f97b.m26b(c0004e.f30a, c0004e);
        if (this.f100e) {
            c0004e.m44a();
        }
    }

    /* renamed from: a */
    public void m125a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f97b.m21a() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f97b.m21a(); i++) {
                C0004e c0004e = (C0004e) this.f97b.m30f(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f97b.m29e(i));
                printWriter.print(": ");
                printWriter.println(c0004e.toString());
                c0004e.m46a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f98c.m21a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f98c.m21a(); i2++) {
                C0004e c0004e2 = (C0004e) this.f98c.m30f(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f98c.m29e(i2));
                printWriter.print(": ");
                printWriter.println(c0004e2.toString());
                c0004e2.m46a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* renamed from: b */
    void m126b() {
        if (f96a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f100e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
        } else {
            for (int iM21a = this.f97b.m21a() - 1; iM21a >= 0; iM21a--) {
                ((C0004e) this.f97b.m30f(iM21a)).m51e();
            }
            this.f100e = false;
        }
    }

    /* renamed from: c */
    void m127c() {
        if (f96a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f100e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
        } else {
            this.f101f = true;
            this.f100e = false;
            for (int iM21a = this.f97b.m21a() - 1; iM21a >= 0; iM21a--) {
                ((C0004e) this.f97b.m30f(iM21a)).m47b();
            }
        }
    }

    /* renamed from: d */
    void m128d() {
        if (this.f101f) {
            if (f96a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f101f = false;
            for (int iM21a = this.f97b.m21a() - 1; iM21a >= 0; iM21a--) {
                ((C0004e) this.f97b.m30f(iM21a)).m49c();
            }
        }
    }

    /* renamed from: e */
    void m129e() {
        for (int iM21a = this.f97b.m21a() - 1; iM21a >= 0; iM21a--) {
            ((C0004e) this.f97b.m30f(iM21a)).f40k = true;
        }
    }

    /* renamed from: f */
    void m130f() {
        for (int iM21a = this.f97b.m21a() - 1; iM21a >= 0; iM21a--) {
            ((C0004e) this.f97b.m30f(iM21a)).m50d();
        }
    }

    /* renamed from: g */
    void m131g() {
        if (!this.f101f) {
            if (f96a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int iM21a = this.f97b.m21a() - 1; iM21a >= 0; iM21a--) {
                ((C0004e) this.f97b.m30f(iM21a)).m52f();
            }
        }
        if (f96a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int iM21a2 = this.f98c.m21a() - 1; iM21a2 >= 0; iM21a2--) {
            ((C0004e) this.f98c.m30f(iM21a2)).m52f();
        }
        this.f98c.m24b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.m170a(this.f99d, sb);
        sb.append("}}");
        return sb.toString();
    }
}
