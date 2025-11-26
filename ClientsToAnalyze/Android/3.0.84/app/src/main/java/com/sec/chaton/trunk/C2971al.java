package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.trunk.database.C3047c;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.trunk.p058a.C2949a;
import com.sec.chaton.trunk.p058a.p059a.C2951b;
import com.sec.chaton.trunk.p058a.p059a.C2954e;
import com.sec.chaton.trunk.p060b.AsyncTaskC2988b;
import com.sec.chaton.trunk.p060b.C2987a;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;
import java.io.File;
import java.net.MalformedURLException;

/* compiled from: TrunkFullPresenter.java */
/* renamed from: com.sec.chaton.trunk.al */
/* loaded from: classes.dex */
public class C2971al extends AbstractC2948a {

    /* renamed from: c */
    private static final String f10754c = C2971al.class.getSimpleName();

    /* renamed from: d */
    private InterfaceC3052f f10755d;

    /* renamed from: e */
    private Activity f10756e;

    /* renamed from: f */
    private String f10757f;

    /* renamed from: g */
    private String f10758g;

    /* renamed from: h */
    private String f10759h;

    /* renamed from: i */
    private String f10760i;

    /* renamed from: j */
    private String f10761j;

    /* renamed from: k */
    private EnumC3026g f10762k;

    /* renamed from: l */
    private String f10763l;

    /* renamed from: m */
    private String f10764m;

    /* renamed from: n */
    private String f10765n;

    /* renamed from: o */
    private C2949a f10766o;

    /* renamed from: p */
    private Handler f10767p;

    /* renamed from: q */
    private C2954e f10768q;

    /* renamed from: r */
    private AsyncTaskC2988b f10769r;

    /* renamed from: s */
    private C2951b f10770s;

    /* renamed from: t */
    private Handler f10771t = new HandlerC2972am(this);

    public C2971al(InterfaceC3052f interfaceC3052f, Handler handler, String str, String str2, String str3) {
        this.f10757f = str;
        this.f10758g = str2;
        this.f10759h = str3;
        this.f10755d = interfaceC3052f;
        this.f10767p = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: f */
    protected void mo10416f() {
        super.mo10416f();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkFullPresenter.onCreate()", f10754c);
        }
        this.f10756e = this.f10755d.mo10240a();
        this.f10766o = new C2949a(this.f10756e, this.f10771t);
        this.f10755d.mo10243a(new C2973an(this));
        this.f10755d.mo10242a(new C2974ao(this));
        this.f10755d.mo10247b(new C2975ap(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: g */
    protected void mo10417g() {
        super.mo10417g();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkFullPresenter.onResume()", f10754c);
        }
        m10451n();
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: h */
    protected void mo10418h() {
        super.mo10418h();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkFullPresenter.onPause()", f10754c);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: i */
    protected void mo10419i() {
        super.mo10419i();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkFullPresenter.onDestroy()", f10754c);
        }
        if (this.f10768q != null) {
            this.f10768q.m5493c();
        }
        if (this.f10770s != null) {
            this.f10770s.m5493c();
        }
        if (this.f10769r != null) {
            this.f10769r.cancel(true);
        }
        this.f10769r = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10439a(int i, int i2) {
        if (m10415e()) {
            if (this.f10768q != null) {
                this.f10768q.m5493c();
            }
            try {
                C3044a.m10564a(this.f10756e, C3044a.m10570f(this.f10759h));
            } catch (OperationApplicationException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f10754c);
                }
            } catch (RemoteException e2) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e2, f10754c);
                }
            }
            this.f10768q = this.f10766o.m10425a(this.f10758g, this.f10759h, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10448k() {
        if (m10415e()) {
            if (this.f10770s != null) {
                this.f10770s.m5493c();
            }
            this.f10770s = this.f10766o.m10421a(this.f10758g, this.f10759h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m10449l() throws Throwable {
        if (m10415e()) {
            try {
                String strM10442b = m10442b(this.f10757f);
                String strM10538a = C3025f.m10538a(this.f10761j);
                String strM11849a = C3364o.m11849a(strM10442b, File.separator, strM10538a);
                if (this.f10769r != null && this.f10769r.getStatus() != AsyncTask.Status.FINISHED) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Cancel previous download task.", f10754c);
                    }
                    this.f10769r.cancel(true);
                }
                if (this.f10762k == EnumC3026g.IMAGE) {
                    this.f10769r = C2987a.m10482a().m10483a(this.f10771t, this.f10761j, strM10442b, strM10538a, strM11849a, true);
                } else {
                    this.f10769r = C2987a.m10482a().m10483a(this.f10771t, this.f10761j, strM10442b, strM10538a, strM11849a, false);
                }
            } catch (MalformedURLException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f10754c);
                }
                this.f10769r = null;
            }
        }
    }

    /* renamed from: m */
    private Cursor m10450m() {
        return this.f10756e.getContentResolver().query(C3047c.f10952a, null, C3364o.m11849a("item_id", " = ?"), new String[]{this.f10759h}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m10451n() {
        Cursor cursor = null;
        if (m10415e()) {
            try {
                Cursor cursorM10450m = m10450m();
                if (cursorM10450m == null) {
                    if (cursorM10450m != null) {
                        cursorM10450m.close();
                        return;
                    }
                    return;
                }
                if (cursorM10450m.moveToNext()) {
                    this.f10760i = cursorM10450m.getString(cursorM10450m.getColumnIndex("sender_uid"));
                    this.f10761j = cursorM10450m.getString(cursorM10450m.getColumnIndex("down_url"));
                    this.f10765n = cursorM10450m.getString(cursorM10450m.getColumnIndex("item_description"));
                    try {
                        String strM10438a = m10438a(this.f10757f);
                        String strM10442b = m10442b(this.f10757f);
                        String strM10538a = C3025f.m10538a(this.f10761j);
                        this.f10763l = C3364o.m11849a(strM10438a, File.separator, strM10538a);
                        this.f10764m = C3364o.m11849a(strM10442b, File.separator, strM10538a);
                    } catch (MalformedURLException e) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, f10754c);
                        }
                        this.f10764m = null;
                    }
                    this.f10762k = C3025f.m10537a(cursorM10450m.getString(cursorM10450m.getColumnIndex("content_type")), false);
                }
                if (cursorM10450m != null) {
                    cursorM10450m.close();
                }
                this.f10755d.mo10244a(this.f10760i);
                m10452o();
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: o */
    private void m10452o() {
        if (m10415e()) {
            if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("Redraw content image: ", this.f10764m), f10754c);
            }
            if (this.f10762k == EnumC3026g.IMAGE) {
                if (this.f10764m == null || this.f10764m.trim().equals("")) {
                    this.f10755d.mo10241a(this.f10762k, null, null);
                    return;
                } else {
                    this.f10755d.mo10241a(this.f10762k, new File(this.f10763l), this.f10764m);
                    return;
                }
            }
            if (this.f10762k == EnumC3026g.VIDEO) {
                if (this.f10764m == null || this.f10764m.trim().equals("")) {
                    this.f10755d.mo10241a(this.f10762k, null, null);
                } else {
                    this.f10755d.mo10241a(this.f10762k, null, this.f10764m);
                }
            }
        }
    }

    /* renamed from: a */
    private String m10438a(String str) {
        return C3364o.m11849a(C3020a.m10526a(), File.separator, str, File.separator, "thumbnail");
    }

    /* renamed from: b */
    private String m10442b(String str) {
        return C3364o.m11849a(C3020a.m10526a(), File.separator, str);
    }
}
