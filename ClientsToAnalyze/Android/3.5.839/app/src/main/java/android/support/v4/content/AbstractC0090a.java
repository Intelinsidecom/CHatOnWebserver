package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p008c.C0089o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

/* compiled from: AsyncTaskLoader.java */
/* renamed from: android.support.v4.content.a */
/* loaded from: classes.dex */
public abstract class AbstractC0090a<D> extends C0094f<D> {

    /* renamed from: a */
    volatile AbstractC0090a<D>.b f289a;

    /* renamed from: b */
    volatile AbstractC0090a<D>.b f290b;

    /* renamed from: c */
    long f291c;

    /* renamed from: d */
    long f292d;

    /* renamed from: e */
    Handler f293e;

    /* renamed from: d */
    public abstract D mo326d();

    /* compiled from: AsyncTaskLoader.java */
    /* renamed from: android.support.v4.content.b */
    final class b extends AbstractC0100m<Void, Void, D> implements Runnable {

        /* renamed from: a */
        D f294a;

        /* renamed from: b */
        boolean f295b;

        /* renamed from: e */
        private CountDownLatch f297e = new CountDownLatch(1);

        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.content.AbstractC0100m
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public D mo328a(Void... voidArr) {
            this.f294a = (D) AbstractC0090a.this.m327e();
            return this.f294a;
        }

        @Override // android.support.v4.content.AbstractC0100m
        /* renamed from: a */
        protected void mo330a(D d) {
            try {
                AbstractC0090a.this.m323b(this, d);
            } finally {
                this.f297e.countDown();
            }
        }

        @Override // android.support.v4.content.AbstractC0100m
        /* renamed from: a */
        protected void mo329a() {
            try {
                AbstractC0090a.this.m320a((AbstractC0090a<b>.b) this, (b) this.f294a);
            } finally {
                this.f297e.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f295b = false;
            AbstractC0090a.this.m325c();
        }
    }

    public AbstractC0090a(Context context) {
        super(context);
        this.f292d = -10000L;
    }

    @Override // android.support.v4.content.C0094f
    /* renamed from: a */
    protected void mo319a() {
        super.mo319a();
        m324b();
        this.f289a = new b();
        m325c();
    }

    /* renamed from: b */
    public boolean m324b() {
        boolean zA = false;
        if (this.f289a != null) {
            if (this.f290b != null) {
                if (this.f289a.f295b) {
                    this.f289a.f295b = false;
                    this.f293e.removeCallbacks(this.f289a);
                }
                this.f289a = null;
            } else if (this.f289a.f295b) {
                this.f289a.f295b = false;
                this.f293e.removeCallbacks(this.f289a);
                this.f289a = null;
            } else {
                zA = this.f289a.m372a(false);
                if (zA) {
                    this.f290b = this.f289a;
                }
                this.f289a = null;
            }
        }
        return zA;
    }

    /* renamed from: a */
    public void mo321a(D d) {
    }

    /* renamed from: c */
    void m325c() {
        if (this.f290b == null && this.f289a != null) {
            if (this.f289a.f295b) {
                this.f289a.f295b = false;
                this.f293e.removeCallbacks(this.f289a);
            }
            if (this.f291c > 0 && SystemClock.uptimeMillis() < this.f292d + this.f291c) {
                this.f289a.f295b = true;
                this.f293e.postAtTime(this.f289a, this.f292d + this.f291c);
            } else {
                this.f289a.m371a(AbstractC0100m.f332d, (Void[]) null);
            }
        }
    }

    /* renamed from: a */
    void m320a(AbstractC0090a<D>.b bVar, D d) {
        mo321a((AbstractC0090a<D>) d);
        if (this.f290b == bVar) {
            m356w();
            this.f292d = SystemClock.uptimeMillis();
            this.f290b = null;
            m325c();
        }
    }

    /* renamed from: b */
    void m323b(AbstractC0090a<D>.b bVar, D d) {
        if (this.f289a != bVar) {
            m320a((AbstractC0090a<AbstractC0090a<D>.b>.b) bVar, (AbstractC0090a<D>.b) d);
            return;
        }
        if (m346m()) {
            mo321a((AbstractC0090a<D>) d);
            return;
        }
        m355v();
        this.f292d = SystemClock.uptimeMillis();
        this.f289a = null;
        mo332b(d);
    }

    /* renamed from: e */
    protected D m327e() {
        return mo326d();
    }

    @Override // android.support.v4.content.C0094f
    /* renamed from: a */
    public void mo322a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo322a(str, fileDescriptor, printWriter, strArr);
        if (this.f289a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f289a);
            printWriter.print(" waiting=");
            printWriter.println(this.f289a.f295b);
        }
        if (this.f290b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f290b);
            printWriter.print(" waiting=");
            printWriter.println(this.f290b.f295b);
        }
        if (this.f291c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C0089o.m310a(this.f291c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C0089o.m309a(this.f292d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
