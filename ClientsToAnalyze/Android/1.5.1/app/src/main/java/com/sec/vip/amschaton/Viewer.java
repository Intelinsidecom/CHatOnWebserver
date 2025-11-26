package com.sec.vip.amschaton;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class Viewer implements Runnable {

    /* renamed from: b */
    private Context f4183b;

    /* renamed from: e */
    private LinearLayout f4186e;

    /* renamed from: h */
    private AMSDrawManager f4189h;

    /* renamed from: a */
    private final int f4182a = 10;

    /* renamed from: c */
    private int f4184c = AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE;

    /* renamed from: d */
    private int f4185d = AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE;

    /* renamed from: f */
    private int f4187f = 0;

    /* renamed from: g */
    private Handler f4188g = null;

    /* renamed from: i */
    private String f4190i = null;

    /* renamed from: j */
    private MediaPlayer f4191j = null;

    /* renamed from: k */
    private Handler f4192k = null;

    /* renamed from: l */
    private boolean f4193l = false;

    /* renamed from: m */
    private OnCompletionListener f4194m = null;

    public interface OnCompletionListener {
        /* renamed from: a */
        void mo4203a();
    }

    public Viewer(Context context) {
        this.f4183b = context;
    }

    /* renamed from: i */
    private void m4188i() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f4193l = false;
        if (this.f4189h.m3846d() != 1) {
            if (this.f4189h.m3846d() == 2 || this.f4189h.m3846d() == 3) {
                this.f4190i = this.f4189h.m3847e();
                if (this.f4190i != null) {
                    this.f4191j = new MediaPlayer();
                    try {
                        this.f4191j.setDataSource(this.f4190i);
                        this.f4191j.prepare();
                        this.f4191j.setLooping(false);
                        this.f4191j.setOnPreparedListener(new C0718u(this));
                        this.f4191j.setOnCompletionListener(new C0717t(this));
                        return;
                    } catch (IOException e) {
                        this.f4191j = null;
                        e.printStackTrace();
                        return;
                    } catch (IllegalArgumentException e2) {
                        this.f4191j = null;
                        e2.printStackTrace();
                        return;
                    } catch (IllegalStateException e3) {
                        this.f4191j = null;
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            return;
        }
        AMSBGMManager aMSBGMManagerM3719a = AMSBGMManager.m3719a();
        int iM3848f = this.f4189h.m3848f();
        if (iM3848f < 0 || iM3848f >= aMSBGMManagerM3719a.m3722b()) {
            return;
        }
        this.f4191j = new MediaPlayer();
        try {
            String strM3720a = aMSBGMManagerM3719a.m3720a(iM3848f);
            if (strM3720a != null) {
                AssetFileDescriptor assetFileDescriptorOpenFd = this.f4183b.getAssets().openFd(strM3720a);
                this.f4191j.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
                this.f4191j.prepare();
                this.f4191j.setLooping(false);
                this.f4191j.setOnPreparedListener(new C0714q(this));
                this.f4191j.setOnCompletionListener(new C0716s(this));
            }
        } catch (IOException e4) {
            this.f4191j = null;
            e4.printStackTrace();
        } catch (IllegalArgumentException e5) {
            this.f4191j = null;
            e5.printStackTrace();
        } catch (IllegalStateException e6) {
            this.f4191j = null;
            e6.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m4189a() throws IllegalStateException {
        switch (this.f4187f) {
            case 0:
                if (this.f4189h.m3853k()) {
                    if (this.f4188g != null) {
                        this.f4188g.removeCallbacks(this);
                    }
                    this.f4188g = new Handler();
                    this.f4188g.postDelayed(this, 10L);
                    if (this.f4191j == null) {
                        this.f4187f = 3;
                        break;
                    } else {
                        this.f4191j.start();
                        this.f4187f = 7;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
            case 5:
            default:
                ChatONLogWriter.m3499a("play() - " + this.f4187f, getClass().getSimpleName());
                break;
            case 2:
                if (this.f4188g != null) {
                    this.f4188g.postDelayed(this, 10L);
                }
                this.f4187f = 3;
                break;
            case 4:
                if (this.f4191j != null) {
                    this.f4191j.start();
                }
                this.f4187f = 5;
                break;
            case 6:
                if (this.f4188g != null) {
                    this.f4188g.postDelayed(this, 10L);
                }
                if (this.f4191j != null) {
                    this.f4191j.start();
                }
                this.f4187f = 7;
                break;
        }
    }

    /* renamed from: a */
    public void m4190a(Handler handler) {
        this.f4192k = handler;
    }

    /* renamed from: a */
    public void m4191a(LinearLayout linearLayout, int i) {
        this.f4186e = linearLayout;
        this.f4184c = i;
        this.f4185d = i;
        this.f4189h = new AMSDrawManager(this.f4183b, this.f4184c, this.f4185d);
        this.f4189h.m3829a();
        this.f4189h.setPlayMode(true);
        this.f4186e.addView(this.f4189h);
    }

    /* renamed from: a */
    public void m4192a(OnCompletionListener onCompletionListener) {
        this.f4194m = onCompletionListener;
    }

    /* renamed from: a */
    public void m4193a(boolean z) throws IllegalStateException, IOException {
        if (this.f4188g != null) {
            this.f4188g.removeCallbacks(this);
            this.f4188g = null;
        }
        if (this.f4191j != null && this.f4193l) {
            if (this.f4191j.isPlaying()) {
                this.f4191j.pause();
            }
            this.f4191j.seekTo(0);
        }
        if (this.f4187f != 5 && this.f4187f != 4) {
            this.f4189h.m3864v();
            this.f4189h.m3852j();
        }
        if (z) {
            this.f4189h.invalidate();
        }
        this.f4187f = 0;
        if (this.f4194m != null) {
            this.f4194m.mo4203a();
        }
    }

    /* renamed from: a */
    public boolean m4194a(String str) {
        switch (this.f4189h.m3842b(str)) {
            case 3:
                ChatONLogWriter.m3499a("Load Error", getClass().getSimpleName());
                break;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m4195a(String str, boolean z) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        switch (this.f4189h.m3842b(str)) {
            case 2:
                Toast.makeText(this.f4183b, C0062R.string.ams_msg_major_version_changed, 0).show();
                break;
            case 3:
                Toast.makeText(this.f4183b, C0062R.string.ams_msg_invalid_ams_file, 0).show();
                ChatONLogWriter.m3499a("Load Error", getClass().getSimpleName());
                break;
            default:
                if (z) {
                    m4188i();
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: b */
    public void m4196b() throws IllegalStateException {
        switch (this.f4187f) {
            case 3:
                this.f4187f = 2;
                break;
            case 4:
            case 6:
            default:
                ChatONLogWriter.m3499a("pause() - " + this.f4187f, getClass().getSimpleName());
                break;
            case 5:
                if (this.f4191j != null && this.f4191j.isPlaying()) {
                    this.f4191j.pause();
                }
                this.f4187f = 4;
                break;
            case 7:
                if (this.f4191j != null && this.f4191j.isPlaying()) {
                    this.f4191j.pause();
                }
                this.f4187f = 6;
                break;
        }
    }

    /* renamed from: c */
    public void m4197c() throws IllegalStateException, IOException {
        m4193a(false);
        if (this.f4191j != null) {
            this.f4191j.release();
            this.f4191j = null;
        }
    }

    /* renamed from: d */
    public void m4198d() {
        if (this.f4189h != null) {
            this.f4189h.m3828C();
            this.f4189h = null;
        }
    }

    /* renamed from: e */
    public int m4199e() {
        return this.f4187f;
    }

    /* renamed from: f */
    public View m4200f() {
        return this.f4189h;
    }

    /* renamed from: g */
    public int m4201g() {
        if (this.f4189h == null) {
            return 0;
        }
        return this.f4189h.m3858p();
    }

    /* renamed from: h */
    public boolean m4202h() {
        if (this.f4189h == null) {
            return false;
        }
        return this.f4189h.m3826A();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4187f == 7 || this.f4187f == 3) {
            if (!this.f4189h.m3854l()) {
                switch (this.f4187f) {
                    case 3:
                        this.f4187f = 0;
                        if (this.f4194m != null) {
                            this.f4194m.mo4203a();
                            break;
                        }
                        break;
                    case 7:
                        this.f4187f = 5;
                        break;
                    default:
                        ChatONLogWriter.m3499a("AMS done.. but - " + this.f4187f, getClass().getSimpleName());
                        break;
                }
            }
            if (this.f4192k != null) {
                this.f4192k.sendEmptyMessage(this.f4189h.m3859q());
            }
            this.f4189h.invalidate();
            if (this.f4188g != null) {
                this.f4188g.postDelayed(this, 10L);
            }
        }
    }
}
