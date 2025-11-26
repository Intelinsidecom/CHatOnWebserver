package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader extends Loader {

    /* renamed from: o */
    volatile AsyncTaskC0019a f110o;

    /* renamed from: p */
    volatile AsyncTaskC0019a f111p;

    /* renamed from: q */
    long f112q;

    /* renamed from: r */
    long f113r;

    /* renamed from: s */
    Handler f114s;

    public AsyncTaskLoader(Context context) {
        super(context);
        this.f113r = -10000L;
    }

    /* renamed from: a */
    void m132a(AsyncTaskC0019a asyncTaskC0019a, Object obj) {
        mo135c(obj);
        if (this.f111p == asyncTaskC0019a) {
            this.f113r = SystemClock.uptimeMillis();
            this.f111p = null;
            m139u();
        }
    }

    @Override // android.support.v4.content.Loader
    /* renamed from: a */
    public void mo133a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo133a(str, fileDescriptor, printWriter, strArr);
        if (this.f110o != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f110o);
            printWriter.print(" waiting=");
            printWriter.println(this.f110o.f131b);
        }
        if (this.f111p != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f111p);
            printWriter.print(" waiting=");
            printWriter.println(this.f111p.f131b);
        }
        if (this.f112q != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.m176a(this.f112q, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.m175a(this.f113r, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* renamed from: b */
    void m134b(AsyncTaskC0019a asyncTaskC0019a, Object obj) {
        if (this.f110o != asyncTaskC0019a) {
            m132a(asyncTaskC0019a, obj);
        } else {
            if (m155d()) {
                mo135c(obj);
                return;
            }
            this.f113r = SystemClock.uptimeMillis();
            this.f110o = null;
            mo143a(obj);
        }
    }

    /* renamed from: c */
    public void mo135c(Object obj) {
    }

    @Override // android.support.v4.content.Loader
    /* renamed from: i */
    protected void mo136i() {
        super.mo136i();
        m138t();
        this.f110o = new AsyncTaskC0019a(this);
        m139u();
    }

    /* renamed from: s */
    public abstract Object mo137s();

    /* renamed from: t */
    public boolean m138t() {
        if (this.f110o == null) {
            return false;
        }
        if (this.f111p != null) {
            if (this.f110o.f131b) {
                this.f110o.f131b = false;
                this.f114s.removeCallbacks(this.f110o);
            }
            this.f110o = null;
            return false;
        }
        if (this.f110o.f131b) {
            this.f110o.f131b = false;
            this.f114s.removeCallbacks(this.f110o);
            this.f110o = null;
            return false;
        }
        boolean zCancel = this.f110o.cancel(false);
        if (zCancel) {
            this.f111p = this.f110o;
        }
        this.f110o = null;
        return zCancel;
    }

    /* renamed from: u */
    void m139u() {
        if (this.f111p != null || this.f110o == null) {
            return;
        }
        if (this.f110o.f131b) {
            this.f110o.f131b = false;
            this.f114s.removeCallbacks(this.f110o);
        }
        if (this.f112q <= 0 || SystemClock.uptimeMillis() >= this.f113r + this.f112q) {
            this.f110o.execute((Void[]) null);
        } else {
            this.f110o.f131b = true;
            this.f114s.postAtTime(this.f110o, this.f113r + this.f112q);
        }
    }

    /* renamed from: v */
    protected Object m140v() {
        return mo137s();
    }
}
