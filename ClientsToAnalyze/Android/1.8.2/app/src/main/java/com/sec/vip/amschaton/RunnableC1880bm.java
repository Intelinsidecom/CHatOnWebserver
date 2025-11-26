package com.sec.vip.amschaton;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: Viewer.java */
/* renamed from: com.sec.vip.amschaton.bm */
/* loaded from: classes.dex */
public class RunnableC1880bm implements Runnable {

    /* renamed from: a */
    public static int f6869a = 250;

    /* renamed from: b */
    private int f6870b;

    /* renamed from: c */
    private boolean f6871c;

    /* renamed from: d */
    private Context f6872d;

    /* renamed from: i */
    private AMSDrawManager f6877i;

    /* renamed from: n */
    private PowerManager.WakeLock f6882n;

    /* renamed from: e */
    private int f6873e = 400;

    /* renamed from: f */
    private int f6874f = 400;

    /* renamed from: g */
    private int f6875g = 0;

    /* renamed from: h */
    private Handler f6876h = null;

    /* renamed from: j */
    private MediaPlayer f6878j = null;

    /* renamed from: k */
    private boolean f6879k = false;

    /* renamed from: l */
    private InterfaceC1882bo f6880l = null;

    /* renamed from: m */
    private int f6881m = 0;

    /* renamed from: o */
    private InterfaceC1881bn f6883o = null;

    public RunnableC1880bm(Context context) {
        this.f6870b = 10;
        this.f6871c = false;
        this.f6872d = context;
        this.f6882n = ((PowerManager) this.f6872d.getSystemService("power")).newWakeLock(26, "[AMS] Don't Sleep!");
        if (AMSActivity.f6617j) {
            f6869a = 250;
            this.f6870b = 1;
            this.f6871c = true;
        } else {
            f6869a = 250;
            this.f6870b = 10;
            this.f6871c = false;
        }
    }

    /* renamed from: a */
    public void m6504a(InterfaceC1882bo interfaceC1882bo) {
        this.f6880l = interfaceC1882bo;
    }

    /* renamed from: a */
    public boolean m6506a(int i) {
        this.f6873e = i;
        this.f6874f = i;
        if (this.f6877i != null) {
            this.f6877i.m6328u();
            this.f6877i = null;
        }
        this.f6877i = new AMSDrawManager(this.f6872d, this.f6873e, this.f6874f);
        if (!this.f6877i.m6293a()) {
            return false;
        }
        this.f6877i.setPlayMode(true);
        return true;
    }

    /* renamed from: a */
    public boolean m6507a(String str, boolean z) {
        if (this.f6877i == null) {
            C2153y.m7535a(this.f6872d, R.string.trunk_toast_loading_failed, 0).show();
            C1786r.m6054a("mAMSViewer is null", getClass().getSimpleName());
            return false;
        }
        switch (this.f6877i.m6304b(str)) {
            case 2:
                C2153y.m7535a(this.f6872d, R.string.ams_msg_major_version_changed, 0).show();
                break;
            case 3:
                C2153y.m7535a(this.f6872d, R.string.chat_view_memory_error, 0).show();
                break;
            case 4:
                C2153y.m7535a(this.f6872d, R.string.ams_msg_invalid_ams_file, 0).show();
                C1786r.m6054a("Load Error", getClass().getSimpleName());
                break;
            default:
                if (z) {
                    m6500i();
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: i */
    private void m6500i() {
    }

    /* renamed from: a */
    public void m6503a(InterfaceC1881bn interfaceC1881bn) {
        this.f6883o = interfaceC1881bn;
    }

    /* renamed from: j */
    private void m6501j() {
        if (this.f6882n.isHeld()) {
            this.f6882n.release();
        }
        if (this.f6883o != null) {
            this.f6883o.mo6516a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if ((this.f6875g == 7 || this.f6875g == 3) && this.f6877i != null) {
            if (!this.f6877i.m6316i()) {
                switch (this.f6875g) {
                    case 3:
                        this.f6875g = 0;
                        m6501j();
                        break;
                    case 7:
                        this.f6875g = 5;
                        break;
                    default:
                        C1786r.m6054a("AMS done.. but - " + this.f6875g, getClass().getSimpleName());
                        break;
                }
            }
            if (this.f6880l != null) {
                int iM6502a = m6502a();
                if (iM6502a > this.f6881m) {
                    this.f6880l.mo6517a(iM6502a);
                }
                this.f6881m = iM6502a;
            }
            this.f6877i.m6292a(this.f6871c);
            if (this.f6876h != null) {
                this.f6876h.postDelayed(this, this.f6870b);
            }
        }
    }

    /* renamed from: a */
    public int m6502a() {
        if (this.f6877i == null) {
            return 0;
        }
        return (int) (((this.f6877i.m6321n() / this.f6877i.m6320m()) * f6869a) + 0.5f);
    }

    /* renamed from: b */
    public void m6508b() throws IllegalStateException {
        this.f6882n.acquire();
        switch (this.f6875g) {
            case 0:
                if (this.f6877i == null) {
                    C2153y.m7535a(this.f6872d, R.string.trunk_toast_loading_failed, 0).show();
                    C1786r.m6054a("mAMSViewer is null", getClass().getSimpleName());
                    return;
                }
                if (this.f6877i.m6315h()) {
                    if (this.f6876h != null) {
                        this.f6876h.removeCallbacks(this);
                    }
                    this.f6876h = new Handler();
                    this.f6876h.postDelayed(this, this.f6870b);
                    if (this.f6878j != null) {
                        this.f6878j.start();
                        this.f6875g = 7;
                        break;
                    } else {
                        this.f6875g = 3;
                        break;
                    }
                } else {
                    return;
                }
            case 1:
            case 3:
            case 5:
            default:
                C1786r.m6054a("play() - " + this.f6875g, getClass().getSimpleName());
                break;
            case 2:
                if (this.f6876h != null) {
                    this.f6876h.postDelayed(this, this.f6870b);
                }
                this.f6875g = 3;
                break;
            case 4:
                if (this.f6878j != null) {
                    this.f6878j.start();
                }
                this.f6875g = 5;
                break;
            case 6:
                if (this.f6876h != null) {
                    this.f6876h.postDelayed(this, this.f6870b);
                }
                if (this.f6878j != null) {
                    this.f6878j.start();
                }
                this.f6875g = 7;
                break;
        }
        if (!C1890g.m6529a(this.f6872d) || !C1890g.m6530b(this.f6872d) || C1890g.m6531c(this.f6872d)) {
            m6512e();
        } else {
            m6513f();
        }
    }

    /* renamed from: c */
    public void m6510c() throws IllegalStateException {
        if (this.f6882n.isHeld()) {
            this.f6882n.release();
        }
        switch (this.f6875g) {
            case 3:
                this.f6875g = 2;
                break;
            case 4:
            case 6:
            default:
                C1786r.m6054a("pause() - " + this.f6875g, getClass().getSimpleName());
                break;
            case 5:
                if (this.f6878j != null && this.f6878j.isPlaying()) {
                    this.f6878j.pause();
                }
                this.f6875g = 4;
                break;
            case 7:
                if (this.f6878j != null && this.f6878j.isPlaying()) {
                    this.f6878j.pause();
                }
                this.f6875g = 6;
                break;
        }
    }

    /* renamed from: a */
    public void m6505a(boolean z) throws IllegalStateException {
        if (this.f6876h != null) {
            this.f6876h.removeCallbacks(this);
            this.f6876h = null;
        }
        if (this.f6878j != null && this.f6879k) {
            if (this.f6878j.isPlaying()) {
                this.f6878j.pause();
            }
            this.f6878j.seekTo(0);
        }
        if (this.f6877i == null) {
            C2153y.m7535a(this.f6872d, R.string.trunk_toast_loading_failed, 0).show();
            C1786r.m6054a("mAMSViewer is null", getClass().getSimpleName());
            return;
        }
        if (this.f6875g != 5 && this.f6875g != 4) {
            this.f6877i.m6322o();
            this.f6877i.m6314g();
        }
        if (z) {
            this.f6877i.m6292a(false);
        }
        this.f6875g = 0;
        m6501j();
    }

    /* renamed from: b */
    public void m6509b(boolean z) {
        if (z) {
            m6505a(false);
        }
        if (this.f6878j != null) {
            this.f6878j.release();
            this.f6878j = null;
        }
    }

    /* renamed from: d */
    public void m6511d() {
        if (this.f6877i != null) {
            this.f6877i.m6328u();
            this.f6877i = null;
        }
    }

    /* renamed from: e */
    public void m6512e() {
        if (this.f6878j != null) {
            this.f6878j.setVolume(0.0f, 0.0f);
        }
    }

    /* renamed from: f */
    public void m6513f() {
        if (this.f6878j != null) {
            this.f6878j.setVolume(1.0f, 1.0f);
        }
    }

    /* renamed from: g */
    public int m6514g() {
        return this.f6875g;
    }

    /* renamed from: h */
    public View m6515h() {
        return this.f6877i;
    }
}
