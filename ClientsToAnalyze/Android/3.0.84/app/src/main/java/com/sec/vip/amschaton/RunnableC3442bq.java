package com.sec.vip.amschaton;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: Viewer.java */
/* renamed from: com.sec.vip.amschaton.bq */
/* loaded from: classes.dex */
public class RunnableC3442bq implements Runnable {

    /* renamed from: a */
    public static int f12592a = 250;

    /* renamed from: b */
    private int f12593b;

    /* renamed from: c */
    private boolean f12594c;

    /* renamed from: d */
    private Context f12595d;

    /* renamed from: i */
    private AMSDrawManager f12600i;

    /* renamed from: n */
    private PowerManager.WakeLock f12605n;

    /* renamed from: e */
    private int f12596e = 400;

    /* renamed from: f */
    private int f12597f = 400;

    /* renamed from: g */
    private int f12598g = 0;

    /* renamed from: h */
    private Handler f12599h = null;

    /* renamed from: j */
    private MediaPlayer f12601j = null;

    /* renamed from: k */
    private boolean f12602k = false;

    /* renamed from: l */
    private InterfaceC3444bs f12603l = null;

    /* renamed from: m */
    private int f12604m = 0;

    /* renamed from: o */
    private InterfaceC3443br f12606o = null;

    public RunnableC3442bq(Context context) {
        this.f12593b = 10;
        this.f12594c = false;
        this.f12595d = context;
        this.f12605n = ((PowerManager) this.f12595d.getSystemService("power")).newWakeLock(26, "[AMS] Don't Sleep!");
        if (AMSActivity.f12277j) {
            f12592a = 250;
            this.f12593b = 1;
            this.f12594c = true;
        } else {
            f12592a = 250;
            this.f12593b = 10;
            this.f12594c = false;
        }
    }

    /* renamed from: a */
    public void m12326a(InterfaceC3444bs interfaceC3444bs) {
        this.f12603l = interfaceC3444bs;
    }

    /* renamed from: a */
    public boolean m12328a(int i) {
        this.f12596e = i;
        this.f12597f = i;
        if (this.f12600i != null) {
            this.f12600i.m12040u();
            this.f12600i = null;
        }
        this.f12600i = new AMSDrawManager(this.f12595d, this.f12596e, this.f12597f);
        if (!this.f12600i.m12005a()) {
            return false;
        }
        this.f12600i.setPlayMode(true);
        return true;
    }

    /* renamed from: a */
    public boolean m12329a(String str, boolean z) {
        if (this.f12600i == null) {
            C3641ai.m13210a(this.f12595d, R.string.trunk_toast_loading_failed, 0).show();
            C3250y.m11442a("mAMSViewer is null", getClass().getSimpleName());
            return false;
        }
        switch (this.f12600i.m12002a(str)) {
            case 2:
                C3641ai.m13210a(this.f12595d, R.string.ams_msg_major_version_changed, 0).show();
                break;
            case 3:
                C3641ai.m13210a(this.f12595d, R.string.chat_view_memory_error, 0).show();
                break;
            case 4:
                C3641ai.m13210a(this.f12595d, R.string.ams_msg_invalid_ams_file, 0).show();
                C3250y.m11442a("Load Error", getClass().getSimpleName());
                break;
            default:
                if (z) {
                    m12322i();
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: i */
    private void m12322i() {
    }

    /* renamed from: a */
    public void m12325a(InterfaceC3443br interfaceC3443br) {
        this.f12606o = interfaceC3443br;
    }

    /* renamed from: j */
    private void m12323j() {
        if (this.f12605n.isHeld()) {
            this.f12605n.release();
        }
        if (this.f12606o != null) {
            this.f12606o.mo12338a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if ((this.f12598g == 7 || this.f12598g == 3) && this.f12600i != null) {
            if (!this.f12600i.m12028i()) {
                switch (this.f12598g) {
                    case 3:
                        this.f12598g = 0;
                        m12323j();
                        break;
                    case 7:
                        this.f12598g = 5;
                        break;
                    default:
                        C3250y.m11442a("AMS done.. but - " + this.f12598g, getClass().getSimpleName());
                        break;
                }
            }
            if (this.f12603l != null) {
                int iM12324a = m12324a();
                if (iM12324a > this.f12604m) {
                    this.f12603l.mo12339a(iM12324a);
                }
                this.f12604m = iM12324a;
            }
            this.f12600i.m12004a(this.f12594c);
            if (this.f12599h != null) {
                this.f12599h.postDelayed(this, this.f12593b);
            }
        }
    }

    /* renamed from: a */
    public int m12324a() {
        if (this.f12600i == null) {
            return 0;
        }
        return (int) (((this.f12600i.m12033n() / this.f12600i.m12032m()) * f12592a) + 0.5f);
    }

    /* renamed from: b */
    public void m12330b() throws IllegalStateException {
        this.f12605n.acquire();
        switch (this.f12598g) {
            case 0:
                if (this.f12600i == null) {
                    C3641ai.m13210a(this.f12595d, R.string.trunk_toast_loading_failed, 0).show();
                    C3250y.m11442a("mAMSViewer is null", getClass().getSimpleName());
                    return;
                }
                if (this.f12600i.m12027h()) {
                    if (this.f12599h != null) {
                        this.f12599h.removeCallbacks(this);
                    }
                    this.f12599h = new Handler();
                    this.f12599h.postDelayed(this, this.f12593b);
                    if (this.f12601j != null) {
                        this.f12601j.start();
                        this.f12598g = 7;
                        break;
                    } else {
                        this.f12598g = 3;
                        break;
                    }
                } else {
                    return;
                }
            case 1:
            case 3:
            case 5:
            default:
                C3250y.m11442a("play() - " + this.f12598g, getClass().getSimpleName());
                break;
            case 2:
                if (this.f12599h != null) {
                    this.f12599h.postDelayed(this, this.f12593b);
                }
                this.f12598g = 3;
                break;
            case 4:
                if (this.f12601j != null) {
                    this.f12601j.start();
                }
                this.f12598g = 5;
                break;
            case 6:
                if (this.f12599h != null) {
                    this.f12599h.postDelayed(this, this.f12593b);
                }
                if (this.f12601j != null) {
                    this.f12601j.start();
                }
                this.f12598g = 7;
                break;
        }
        if (!C3575h.m12764a(this.f12595d) || !C3575h.m12765b(this.f12595d) || C3575h.m12766c(this.f12595d)) {
            m12334e();
        } else {
            m12335f();
        }
    }

    /* renamed from: c */
    public void m12332c() throws IllegalStateException {
        if (this.f12605n.isHeld()) {
            this.f12605n.release();
        }
        switch (this.f12598g) {
            case 3:
                this.f12598g = 2;
                break;
            case 4:
            case 6:
            default:
                C3250y.m11442a("pause() - " + this.f12598g, getClass().getSimpleName());
                break;
            case 5:
                if (this.f12601j != null && this.f12601j.isPlaying()) {
                    this.f12601j.pause();
                }
                this.f12598g = 4;
                break;
            case 7:
                if (this.f12601j != null && this.f12601j.isPlaying()) {
                    this.f12601j.pause();
                }
                this.f12598g = 6;
                break;
        }
    }

    /* renamed from: a */
    public void m12327a(boolean z) throws IllegalStateException {
        if (this.f12599h != null) {
            this.f12599h.removeCallbacks(this);
            this.f12599h = null;
        }
        if (this.f12601j != null && this.f12602k) {
            if (this.f12601j.isPlaying()) {
                this.f12601j.pause();
            }
            this.f12601j.seekTo(0);
        }
        if (this.f12600i == null) {
            C3641ai.m13210a(this.f12595d, R.string.trunk_toast_loading_failed, 0).show();
            C3250y.m11442a("mAMSViewer is null", getClass().getSimpleName());
            return;
        }
        if (this.f12598g != 5 && this.f12598g != 4) {
            this.f12600i.m12034o();
            this.f12600i.m12026g();
        }
        if (z) {
            this.f12600i.m12004a(false);
        }
        this.f12598g = 0;
        m12323j();
    }

    /* renamed from: b */
    public void m12331b(boolean z) throws IllegalStateException {
        if (z) {
            m12327a(false);
        }
        if (this.f12601j != null) {
            this.f12601j.release();
            this.f12601j = null;
        }
    }

    /* renamed from: d */
    public void m12333d() {
        if (this.f12600i != null) {
            this.f12600i.m12040u();
            this.f12600i = null;
        }
    }

    /* renamed from: e */
    public void m12334e() {
        if (this.f12601j != null) {
            this.f12601j.setVolume(0.0f, 0.0f);
        }
    }

    /* renamed from: f */
    public void m12335f() {
        if (this.f12601j != null) {
            this.f12601j.setVolume(1.0f, 1.0f);
        }
    }

    /* renamed from: g */
    public int m12336g() {
        return this.f12598g;
    }

    /* renamed from: h */
    public View m12337h() {
        return this.f12600i;
    }
}
