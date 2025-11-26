package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.C0094f;
import android.support.v4.content.InterfaceC0095h;
import android.support.v4.p008c.C0081d;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManager.java */
/* renamed from: android.support.v4.app.ap */
/* loaded from: classes.dex */
final class C0030ap implements InterfaceC0095h<Object> {

    /* renamed from: a */
    final int f115a;

    /* renamed from: b */
    final Bundle f116b;

    /* renamed from: c */
    InterfaceC0028an<Object> f117c;

    /* renamed from: d */
    C0094f<Object> f118d;

    /* renamed from: e */
    boolean f119e;

    /* renamed from: f */
    boolean f120f;

    /* renamed from: g */
    Object f121g;

    /* renamed from: h */
    boolean f122h;

    /* renamed from: i */
    boolean f123i;

    /* renamed from: j */
    boolean f124j;

    /* renamed from: k */
    boolean f125k;

    /* renamed from: l */
    boolean f126l;

    /* renamed from: m */
    boolean f127m;

    /* renamed from: n */
    C0030ap f128n;

    /* renamed from: o */
    final /* synthetic */ C0029ao f129o;

    public C0030ap(C0029ao c0029ao, int i, Bundle bundle, InterfaceC0028an<Object> interfaceC0028an) {
        this.f129o = c0029ao;
        this.f115a = i;
        this.f116b = bundle;
        this.f117c = interfaceC0028an;
    }

    /* renamed from: a */
    void m127a() {
        if (this.f123i && this.f124j) {
            this.f122h = true;
            return;
        }
        if (!this.f122h) {
            this.f122h = true;
            if (C0029ao.f107a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f118d == null && this.f117c != null) {
                this.f118d = this.f117c.mo112a(this.f115a, this.f116b);
            }
            if (this.f118d != null) {
                if (this.f118d.getClass().isMemberClass() && !Modifier.isStatic(this.f118d.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f118d);
                }
                if (!this.f127m) {
                    this.f118d.m340a(this.f115a, this);
                    this.f127m = true;
                }
                this.f118d.m348o();
            }
        }
    }

    /* renamed from: b */
    void m130b() {
        if (C0029ao.f107a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f123i = true;
        this.f124j = this.f122h;
        this.f122h = false;
        this.f117c = null;
    }

    /* renamed from: c */
    void m132c() {
        if (this.f123i) {
            if (C0029ao.f107a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f123i = false;
            if (this.f122h != this.f124j && !this.f122h) {
                m134e();
            }
        }
        if (this.f122h && this.f119e && !this.f125k) {
            m131b(this.f118d, this.f121g);
        }
    }

    /* renamed from: d */
    void m133d() {
        if (this.f122h && this.f125k) {
            this.f125k = false;
            if (this.f119e) {
                m131b(this.f118d, this.f121g);
            }
        }
    }

    /* renamed from: e */
    void m134e() {
        if (C0029ao.f107a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f122h = false;
        if (!this.f123i && this.f118d != null && this.f127m) {
            this.f127m = false;
            this.f118d.m341a(this);
            this.f118d.m350q();
        }
    }

    /* renamed from: f */
    void m135f() {
        String str;
        if (C0029ao.f107a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f126l = true;
        boolean z = this.f120f;
        this.f120f = false;
        if (this.f117c != null && this.f118d != null && this.f119e && z) {
            if (C0029ao.f107a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f129o.f111e != null) {
                String str2 = this.f129o.f111e.f45b.f231u;
                this.f129o.f111e.f45b.f231u = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f117c.mo113a(this.f118d);
            } finally {
                if (this.f129o.f111e != null) {
                    this.f129o.f111e.f45b.f231u = str;
                }
            }
        }
        this.f117c = null;
        this.f121g = null;
        this.f119e = false;
        if (this.f118d != null) {
            if (this.f127m) {
                this.f127m = false;
                this.f118d.m341a(this);
            }
            this.f118d.m353t();
        }
        if (this.f128n != null) {
            this.f128n.m135f();
        }
    }

    @Override // android.support.v4.content.InterfaceC0095h
    /* renamed from: a */
    public void mo128a(C0094f<Object> c0094f, Object obj) {
        if (C0029ao.f107a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.f126l) {
            if (C0029ao.f107a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                return;
            }
            return;
        }
        if (this.f129o.f108b.m295a(this.f115a) != this) {
            if (C0029ao.f107a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
                return;
            }
            return;
        }
        C0030ap c0030ap = this.f128n;
        if (c0030ap != null) {
            if (C0029ao.f107a) {
                Log.v("LoaderManager", "  Switching to pending loader: " + c0030ap);
            }
            this.f128n = null;
            this.f129o.f108b.m299b(this.f115a, null);
            m135f();
            this.f129o.m118a(c0030ap);
            return;
        }
        if (this.f121g != obj || !this.f119e) {
            this.f121g = obj;
            this.f119e = true;
            if (this.f122h) {
                m131b(c0094f, obj);
            }
        }
        C0030ap c0030apM295a = this.f129o.f109c.m295a(this.f115a);
        if (c0030apM295a != null && c0030apM295a != this) {
            c0030apM295a.f120f = false;
            c0030apM295a.m135f();
            this.f129o.f109c.m301c(this.f115a);
        }
        if (this.f129o.f111e != null && !this.f129o.mo110a()) {
            this.f129o.f111e.f45b.m224e();
        }
    }

    /* renamed from: b */
    void m131b(C0094f<Object> c0094f, Object obj) {
        String str;
        if (this.f117c != null) {
            if (this.f129o.f111e == null) {
                str = null;
            } else {
                String str2 = this.f129o.f111e.f45b.f231u;
                this.f129o.f111e.f45b.f231u = "onLoadFinished";
                str = str2;
            }
            try {
                if (C0029ao.f107a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + c0094f + ": " + c0094f.m342c(obj));
                }
                this.f117c.mo114a((C0094f<C0094f<Object>>) c0094f, (C0094f<Object>) obj);
                this.f120f = true;
            } finally {
                if (this.f129o.f111e != null) {
                    this.f129o.f111e.f45b.f231u = str;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.f115a);
        sb.append(" : ");
        C0081d.m262a(this.f118d, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: a */
    public void m129a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f115a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f116b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f117c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f118d);
        if (this.f118d != null) {
            this.f118d.mo322a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f119e || this.f120f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f119e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f120f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f121g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f122h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f125k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f126l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f123i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f124j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f127m);
        if (this.f128n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f128n);
            printWriter.println(":");
            this.f128n.m129a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
