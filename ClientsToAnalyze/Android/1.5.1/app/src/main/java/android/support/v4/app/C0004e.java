package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.app.e */
/* loaded from: classes.dex */
final class C0004e implements Loader.OnLoadCompleteListener {

    /* renamed from: a */
    final int f30a;

    /* renamed from: b */
    final Bundle f31b;

    /* renamed from: c */
    LoaderManager.LoaderCallbacks f32c;

    /* renamed from: d */
    Loader f33d;

    /* renamed from: e */
    boolean f34e;

    /* renamed from: f */
    boolean f35f;

    /* renamed from: g */
    Object f36g;

    /* renamed from: h */
    boolean f37h;

    /* renamed from: i */
    boolean f38i;

    /* renamed from: j */
    boolean f39j;

    /* renamed from: k */
    boolean f40k;

    /* renamed from: l */
    boolean f41l;

    /* renamed from: m */
    boolean f42m;

    /* renamed from: n */
    C0004e f43n;

    /* renamed from: o */
    final /* synthetic */ C0017r f44o;

    public C0004e(C0017r c0017r, int i, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        this.f44o = c0017r;
        this.f30a = i;
        this.f31b = bundle;
        this.f32c = loaderCallbacks;
    }

    /* renamed from: a */
    void m44a() {
        if (this.f38i && this.f39j) {
            this.f37h = true;
            return;
        }
        if (this.f37h) {
            return;
        }
        this.f37h = true;
        if (C0017r.f96a) {
            Log.v("LoaderManager", "  Starting: " + this);
        }
        if (this.f33d == null && this.f32c != null) {
            this.f33d = this.f32c.mo38a(this.f30a, this.f31b);
        }
        if (this.f33d != null) {
            if (this.f33d.getClass().isMemberClass() && !Modifier.isStatic(this.f33d.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f33d);
            }
            if (!this.f42m) {
                this.f33d.m150a(this.f30a, this);
                this.f42m = true;
            }
            this.f33d.m157f();
        }
    }

    @Override // android.support.v4.content.Loader.OnLoadCompleteListener
    /* renamed from: a */
    public void mo45a(Loader loader, Object obj) {
        if (C0017r.f96a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.f41l) {
            if (C0017r.f96a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                return;
            }
            return;
        }
        if (this.f44o.f97b.m22a(this.f30a) != this) {
            if (C0017r.f96a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
                return;
            }
            return;
        }
        C0004e c0004e = this.f43n;
        if (c0004e != null) {
            if (C0017r.f96a) {
                Log.v("LoaderManager", "  Switching to pending loader: " + c0004e);
            }
            this.f43n = null;
            this.f44o.f97b.m26b(this.f30a, null);
            m52f();
            this.f44o.m124a(c0004e);
            return;
        }
        if (this.f36g != obj || !this.f34e) {
            this.f36g = obj;
            this.f34e = true;
            if (this.f37h) {
                m48b(loader, obj);
            }
        }
        C0004e c0004e2 = (C0004e) this.f44o.f98c.m22a(this.f30a);
        if (c0004e2 == null || c0004e2 == this) {
            return;
        }
        c0004e2.f35f = false;
        c0004e2.m52f();
        this.f44o.f98c.m27c(this.f30a);
    }

    /* renamed from: a */
    public void m46a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f30a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f31b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f32c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f33d);
        if (this.f33d != null) {
            this.f33d.mo133a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f34e || this.f35f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f34e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f35f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f36g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f37h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f40k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f41l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f38i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f39j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f42m);
        if (this.f43n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f43n);
            printWriter.println(":");
            this.f43n.m46a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: b */
    void m47b() {
        if (C0017r.f96a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f38i = true;
        this.f39j = this.f37h;
        this.f37h = false;
        this.f32c = null;
    }

    /* renamed from: b */
    void m48b(Loader loader, Object obj) {
        if (this.f32c != null) {
            String str = null;
            if (this.f44o.f99d != null) {
                str = this.f44o.f99d.mFragments.f92s;
                this.f44o.f99d.mFragments.f92s = "onLoadFinished";
            }
            try {
                if (C0017r.f96a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.m153b(obj));
                }
                this.f32c.mo40a(loader, obj);
                this.f35f = true;
            } finally {
                if (this.f44o.f99d != null) {
                    this.f44o.f99d.mFragments.f92s = str;
                }
            }
        }
    }

    /* renamed from: c */
    void m49c() {
        if (this.f38i) {
            if (C0017r.f96a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f38i = false;
            if (this.f37h != this.f39j && !this.f37h) {
                m51e();
            }
        }
        if (this.f37h && this.f34e && !this.f40k) {
            m48b(this.f33d, this.f36g);
        }
    }

    /* renamed from: d */
    void m50d() {
        if (this.f37h && this.f40k) {
            this.f40k = false;
            if (this.f34e) {
                m48b(this.f33d, this.f36g);
            }
        }
    }

    /* renamed from: e */
    void m51e() {
        if (C0017r.f96a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f37h = false;
        if (this.f38i || this.f33d == null || !this.f42m) {
            return;
        }
        this.f42m = false;
        this.f33d.m151a((Loader.OnLoadCompleteListener) this);
        this.f33d.m159j();
    }

    /* renamed from: f */
    void m52f() {
        String str;
        if (C0017r.f96a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f41l = true;
        boolean z = this.f35f;
        this.f35f = false;
        if (this.f32c != null && this.f33d != null && this.f34e && z) {
            if (C0017r.f96a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f44o.f99d != null) {
                str = this.f44o.f99d.mFragments.f92s;
                this.f44o.f99d.mFragments.f92s = "onLoaderReset";
            } else {
                str = null;
            }
            try {
                this.f32c.mo39a(this.f33d);
            } finally {
                if (this.f44o.f99d != null) {
                    this.f44o.f99d.mFragments.f92s = str;
                }
            }
        }
        this.f32c = null;
        this.f36g = null;
        this.f34e = false;
        if (this.f33d != null) {
            if (this.f42m) {
                this.f42m = false;
                this.f33d.m151a((Loader.OnLoadCompleteListener) this);
            }
            this.f33d.m162n();
        }
        if (this.f43n != null) {
            this.f43n.m52f();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.f30a);
        sb.append(" : ");
        DebugUtils.m170a(this.f33d, sb);
        sb.append("}}");
        return sb.toString();
    }
}
