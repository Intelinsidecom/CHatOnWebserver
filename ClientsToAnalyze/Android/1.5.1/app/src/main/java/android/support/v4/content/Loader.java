package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class Loader {

    /* renamed from: a */
    int f122a;

    /* renamed from: b */
    OnLoadCompleteListener f123b;

    /* renamed from: c */
    Context f124c;

    /* renamed from: d */
    boolean f125d = false;

    /* renamed from: e */
    boolean f126e = false;

    /* renamed from: f */
    boolean f127f = true;

    /* renamed from: g */
    boolean f128g = false;

    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Loader.this.m164q();
        }
    }

    public interface OnLoadCompleteListener {
        /* renamed from: a */
        void mo45a(Loader loader, Object obj);
    }

    public Loader(Context context) {
        this.f124c = context.getApplicationContext();
    }

    /* renamed from: a */
    public Context m149a() {
        return this.f124c;
    }

    /* renamed from: a */
    public void m150a(int i, OnLoadCompleteListener onLoadCompleteListener) {
        if (this.f123b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f123b = onLoadCompleteListener;
        this.f122a = i;
    }

    /* renamed from: a */
    public void m151a(OnLoadCompleteListener onLoadCompleteListener) {
        if (this.f123b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.f123b != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f123b = null;
    }

    /* renamed from: a */
    public void mo143a(Object obj) {
        if (this.f123b != null) {
            this.f123b.mo45a(this, obj);
        }
    }

    /* renamed from: a */
    public void mo133a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f122a);
        printWriter.print(" mListener=");
        printWriter.println(this.f123b);
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f125d);
        printWriter.print(" mContentChanged=");
        printWriter.print(this.f128g);
        printWriter.print(" mAbandoned=");
        printWriter.print(this.f126e);
        printWriter.print(" mReset=");
        printWriter.println(this.f127f);
    }

    /* renamed from: b */
    public int m152b() {
        return this.f122a;
    }

    /* renamed from: b */
    public String m153b(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m170a(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: c */
    public boolean m154c() {
        return this.f125d;
    }

    /* renamed from: d */
    public boolean m155d() {
        return this.f126e;
    }

    /* renamed from: e */
    public boolean m156e() {
        return this.f127f;
    }

    /* renamed from: f */
    public final void m157f() {
        this.f125d = true;
        this.f127f = false;
        this.f126e = false;
        mo145g();
    }

    /* renamed from: g */
    protected void mo145g() {
    }

    /* renamed from: h */
    public void m158h() {
        mo136i();
    }

    /* renamed from: i */
    protected void mo136i() {
    }

    /* renamed from: j */
    public void m159j() {
        this.f125d = false;
        mo146k();
    }

    /* renamed from: k */
    protected void mo146k() {
    }

    /* renamed from: l */
    public void m160l() {
        this.f126e = true;
        m161m();
    }

    /* renamed from: m */
    protected void m161m() {
    }

    /* renamed from: n */
    public void m162n() {
        mo147o();
        this.f127f = true;
        this.f125d = false;
        this.f126e = false;
        this.f128g = false;
    }

    /* renamed from: o */
    protected void mo147o() {
    }

    /* renamed from: p */
    public boolean m163p() {
        boolean z = this.f128g;
        this.f128g = false;
        return z;
    }

    /* renamed from: q */
    public void m164q() {
        if (this.f125d) {
            m158h();
        } else {
            this.f128g = true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m170a(this, sb);
        sb.append(" id=");
        sb.append(this.f122a);
        sb.append("}");
        return sb.toString();
    }
}
