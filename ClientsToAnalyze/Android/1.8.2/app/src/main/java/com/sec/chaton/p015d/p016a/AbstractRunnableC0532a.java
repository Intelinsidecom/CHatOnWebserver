package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0776c;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: AbstractHttpTask2.java */
/* renamed from: com.sec.chaton.d.a.a */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC0532a implements Runnable {

    /* renamed from: a */
    protected final C0798h f2159a;

    /* renamed from: b */
    protected Message f2160b;

    /* renamed from: c */
    protected Handler f2161c;

    /* renamed from: d */
    private String f2162d = null;

    /* renamed from: e */
    private int f2163e = 0;

    /* renamed from: a */
    public abstract String mo2707a();

    /* renamed from: a */
    public abstract void mo2708a(C0101b c0101b);

    public AbstractRunnableC0532a(Handler handler, C0798h c0798h) {
        this.f2161c = null;
        this.f2159a = c0798h;
        this.f2161c = handler;
    }

    /* renamed from: b */
    public final void m2709b() {
        this.f2163e = 1;
    }

    /* renamed from: c */
    public final void m2710c() {
        this.f2163e = 2;
    }

    /* renamed from: d */
    public final boolean m2711d() {
        return this.f2163e != 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2160b = new Message();
        C0101b c0101b = new C0101b(this.f2159a);
        c0101b.m659a(EnumC0803m.ERROR);
        this.f2160b.what = this.f2159a.m3399g();
        try {
            this.f2162d = mo2707a();
            if (this.f2163e == 0) {
                C0776c.m3304a(c0101b, this.f2162d);
            } else {
                c0101b.m659a(EnumC0803m.NO_REQUEST);
            }
            if (c0101b.m675h() == 401) {
                C0802l.m3412a().clear();
                if (!ExitAppDialogActivity.m580a()) {
                    ExitAppDialogActivity.m581b();
                    return;
                }
                return;
            }
            if (this.f2163e != 2) {
                mo2708a(c0101b);
                if (this.f2161c != null) {
                    this.f2160b.obj = c0101b;
                    this.f2161c.sendMessage(this.f2160b);
                }
            }
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
            if (this.f2161c != null && this.f2163e != 2) {
                this.f2160b.obj = c0101b;
                this.f2161c.sendMessage(this.f2160b);
            }
        }
    }

    /* renamed from: e */
    public C0101b m2712e() {
        C0101b c0101b = new C0101b(this.f2159a);
        c0101b.m659a(EnumC0803m.ERROR);
        try {
            this.f2162d = mo2707a();
            if (this.f2163e == 0) {
                C0776c.m3304a(c0101b, this.f2162d);
            } else {
                c0101b.m659a(EnumC0803m.NO_REQUEST);
            }
            if (this.f2163e != 2) {
                mo2708a(c0101b);
            }
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
        return c0101b;
    }
}
