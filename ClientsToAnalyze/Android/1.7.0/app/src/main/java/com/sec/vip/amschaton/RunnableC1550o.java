package com.sec.vip.amschaton;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: Viewer.java */
/* renamed from: com.sec.vip.amschaton.o */
/* loaded from: classes.dex */
public class RunnableC1550o implements Runnable {

    /* renamed from: a */
    public static int f5386a = 250;

    /* renamed from: b */
    private int f5387b;

    /* renamed from: c */
    private boolean f5388c;

    /* renamed from: d */
    private Context f5389d;

    /* renamed from: i */
    private AMSDrawManager f5394i;

    /* renamed from: n */
    private PowerManager.WakeLock f5399n;

    /* renamed from: e */
    private int f5390e = AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE;

    /* renamed from: f */
    private int f5391f = AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE;

    /* renamed from: g */
    private int f5392g = 0;

    /* renamed from: h */
    private Handler f5393h = null;

    /* renamed from: j */
    private MediaPlayer f5395j = null;

    /* renamed from: k */
    private boolean f5396k = false;

    /* renamed from: l */
    private InterfaceC1547l f5397l = null;

    /* renamed from: m */
    private int f5398m = 0;

    /* renamed from: o */
    private InterfaceC1396bf f5400o = null;

    public RunnableC1550o(Context context) {
        this.f5387b = 10;
        this.f5388c = false;
        this.f5389d = context;
        this.f5399n = ((PowerManager) this.f5389d.getSystemService("power")).newWakeLock(26, "[AMS] Don't Sleep!");
        if (AMSActivity.f4630l) {
            f5386a = 250;
            this.f5387b = 1;
            this.f5388c = true;
        } else {
            f5386a = 250;
            this.f5387b = 10;
            this.f5388c = false;
        }
    }

    /* renamed from: a */
    public void m5632a(InterfaceC1547l interfaceC1547l) {
        this.f5397l = interfaceC1547l;
    }

    /* renamed from: a */
    public boolean m5634a(int i) {
        this.f5390e = i;
        this.f5391f = i;
        if (this.f5394i != null) {
            this.f5394i.m4807u();
            this.f5394i = null;
        }
        this.f5394i = new AMSDrawManager(this.f5389d, this.f5390e, this.f5391f);
        if (!this.f5394i.m4772a()) {
            return false;
        }
        this.f5394i.setPlayMode(true);
        return true;
    }

    /* renamed from: a */
    public boolean m5635a(String str, boolean z) {
        switch (this.f5394i.m4783b(str)) {
            case 2:
                C1619g.m5888a(this.f5389d, R.string.ams_msg_major_version_changed, 0).show();
                break;
            case 3:
                C1619g.m5888a(this.f5389d, R.string.ams_msg_invalid_ams_file, 0).show();
                C1341p.m4651a("Load Error", getClass().getSimpleName());
                break;
            default:
                if (z) {
                    m5628j();
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: j */
    private void m5628j() {
    }

    /* renamed from: a */
    public void m5631a(InterfaceC1396bf interfaceC1396bf) {
        this.f5400o = interfaceC1396bf;
    }

    /* renamed from: k */
    private void m5629k() {
        if (this.f5399n.isHeld()) {
            this.f5399n.release();
        }
        if (this.f5400o != null) {
            this.f5400o.mo5003a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5392g == 7 || this.f5392g == 3) {
            if (!this.f5394i.m4795i()) {
                switch (this.f5392g) {
                    case 3:
                        this.f5392g = 0;
                        m5629k();
                        break;
                    case 7:
                        this.f5392g = 5;
                        break;
                    default:
                        C1341p.m4651a("AMS done.. but - " + this.f5392g, getClass().getSimpleName());
                        break;
                }
            }
            if (this.f5397l != null) {
                int iM5630a = m5630a();
                if (iM5630a > this.f5398m) {
                    this.f5397l.mo5270a(iM5630a);
                }
                this.f5398m = iM5630a;
            }
            this.f5394i.m4771a(this.f5388c);
            if (this.f5393h != null) {
                this.f5393h.postDelayed(this, this.f5387b);
            }
        }
    }

    /* renamed from: a */
    public int m5630a() {
        return (int) (((this.f5394i.m4800n() / this.f5394i.m4799m()) * f5386a) + 0.5f);
    }

    /* renamed from: b */
    public void m5636b() {
        this.f5399n.acquire();
        switch (this.f5392g) {
            case 0:
                if (this.f5394i.m4794h()) {
                    if (this.f5393h != null) {
                        this.f5393h.removeCallbacks(this);
                    }
                    this.f5393h = new Handler();
                    this.f5393h.postDelayed(this, this.f5387b);
                    if (this.f5395j != null) {
                        this.f5395j.start();
                        this.f5392g = 7;
                        break;
                    } else {
                        this.f5392g = 3;
                        break;
                    }
                } else {
                    return;
                }
            case 1:
            case 3:
            case 5:
            default:
                C1341p.m4651a("play() - " + this.f5392g, getClass().getSimpleName());
                break;
            case 2:
                if (this.f5393h != null) {
                    this.f5393h.postDelayed(this, this.f5387b);
                }
                this.f5392g = 3;
                break;
            case 4:
                if (this.f5395j != null) {
                    this.f5395j.start();
                }
                this.f5392g = 5;
                break;
            case 6:
                if (this.f5393h != null) {
                    this.f5393h.postDelayed(this, this.f5387b);
                }
                if (this.f5395j != null) {
                    this.f5395j.start();
                }
                this.f5392g = 7;
                break;
        }
        if (!C1383at.m4964a(this.f5389d) || !C1383at.m4965b(this.f5389d) || C1383at.m4966c(this.f5389d)) {
            m5640f();
        } else {
            m5641g();
        }
    }

    /* renamed from: c */
    public void m5637c() {
        if (this.f5399n.isHeld()) {
            this.f5399n.release();
        }
        switch (this.f5392g) {
            case 3:
                this.f5392g = 2;
                break;
            case 4:
            case 6:
            default:
                C1341p.m4651a("pause() - " + this.f5392g, getClass().getSimpleName());
                break;
            case 5:
                if (this.f5395j != null && this.f5395j.isPlaying()) {
                    this.f5395j.pause();
                }
                this.f5392g = 4;
                break;
            case 7:
                if (this.f5395j != null && this.f5395j.isPlaying()) {
                    this.f5395j.pause();
                }
                this.f5392g = 6;
                break;
        }
    }

    /* renamed from: a */
    public void m5633a(boolean z) {
        if (this.f5393h != null) {
            this.f5393h.removeCallbacks(this);
            this.f5393h = null;
        }
        if (this.f5395j != null && this.f5396k) {
            if (this.f5395j.isPlaying()) {
                this.f5395j.pause();
            }
            this.f5395j.seekTo(0);
        }
        if (this.f5392g != 5 && this.f5392g != 4) {
            this.f5394i.m4801o();
            this.f5394i.m4793g();
        }
        if (z) {
            this.f5394i.m4771a(false);
        }
        this.f5392g = 0;
        m5629k();
    }

    /* renamed from: d */
    public void m5638d() {
        m5633a(false);
        if (this.f5395j != null) {
            this.f5395j.release();
            this.f5395j = null;
        }
    }

    /* renamed from: e */
    public void m5639e() {
        if (this.f5394i != null) {
            this.f5394i.m4807u();
            this.f5394i = null;
        }
    }

    /* renamed from: f */
    public void m5640f() {
        if (this.f5395j != null) {
            this.f5395j.setVolume(0.0f, 0.0f);
        }
    }

    /* renamed from: g */
    public void m5641g() {
        if (this.f5395j != null) {
            this.f5395j.setVolume(1.0f, 1.0f);
        }
    }

    /* renamed from: h */
    public int m5642h() {
        return this.f5392g;
    }

    /* renamed from: i */
    public View m5643i() {
        return this.f5394i;
    }
}
