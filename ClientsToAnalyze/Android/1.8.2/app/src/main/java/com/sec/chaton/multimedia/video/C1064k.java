package com.sec.chaton.multimedia.video;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import java.io.File;

/* compiled from: VideoRecordManager.java */
/* renamed from: com.sec.chaton.multimedia.video.k */
/* loaded from: classes.dex */
public class C1064k {

    /* renamed from: a */
    private String f3951a;

    /* renamed from: b */
    private MediaRecorder f3952b = new MediaRecorder();

    /* renamed from: c */
    private EnumC1065l f3953c = EnumC1065l.BEFORE_START;

    /* renamed from: d */
    private Camera f3954d;

    /* renamed from: a */
    public synchronized EnumC1065l m4087a() {
        return this.f3953c;
    }

    /* renamed from: a */
    void m4088a(Camera camera) {
        this.f3954d = camera;
        if (this.f3954d != null) {
            this.f3954d.unlock();
        }
    }

    /* renamed from: a */
    public synchronized void m4089a(String str, SurfaceHolder surfaceHolder, MediaRecorder.OnInfoListener onInfoListener) {
        if (this.f3952b == null) {
            this.f3952b = new MediaRecorder();
            if (this.f3954d != null) {
                this.f3954d.unlock();
            }
        }
        if (this.f3953c == EnumC1065l.BEFORE_START) {
            try {
                this.f3952b.reset();
            } catch (Exception e) {
                C1786r.m6055a((Throwable) e);
            }
            try {
                m4086b(str, surfaceHolder, onInfoListener);
                this.f3951a = str;
                this.f3952b.prepare();
                this.f3953c = EnumC1065l.READY_TO_START;
            } catch (IllegalStateException e2) {
                C1786r.m6055a((Throwable) e2);
            } catch (Exception e3) {
                C1786r.m6055a((Throwable) e3);
            }
        } else if (this.f3953c != EnumC1065l.READY_TO_START) {
            if (this.f3953c == EnumC1065l.RECORDING) {
                try {
                    this.f3952b.reset();
                    new File(this.f3951a).delete();
                } catch (Exception e4) {
                    C1786r.m6055a((Throwable) e4);
                }
                m4086b(str, surfaceHolder, onInfoListener);
                this.f3951a = str;
                this.f3952b.prepare();
                this.f3953c = EnumC1065l.READY_TO_START;
            } else {
                if (this.f3953c == EnumC1065l.TERMINATED) {
                    try {
                        this.f3952b.reset();
                    } catch (Exception e5) {
                        C1786r.m6055a((Throwable) e5);
                    }
                }
                m4086b(str, surfaceHolder, onInfoListener);
                this.f3951a = str;
                this.f3952b.prepare();
                this.f3953c = EnumC1065l.READY_TO_START;
            }
        }
    }

    /* renamed from: b */
    public synchronized void m4090b() {
        if (this.f3953c != EnumC1065l.BEFORE_START) {
            if (this.f3953c == EnumC1065l.READY_TO_START) {
                try {
                    this.f3952b.start();
                    this.f3953c = EnumC1065l.RECORDING;
                } catch (IllegalStateException e) {
                    C1786r.m6055a((Throwable) e);
                }
            } else if (this.f3953c == EnumC1065l.RECORDING || this.f3953c == EnumC1065l.TERMINATED) {
            }
        }
    }

    /* renamed from: c */
    public synchronized String m4091c() {
        String str = null;
        synchronized (this) {
            if (this.f3953c == EnumC1065l.BEFORE_START) {
                this.f3953c = EnumC1065l.TERMINATED;
            } else if (this.f3953c == EnumC1065l.READY_TO_START) {
                m4092d();
            } else if (this.f3953c == EnumC1065l.RECORDING) {
                try {
                    this.f3952b.stop();
                    this.f3952b.release();
                    this.f3952b = null;
                    if (this.f3954d != null) {
                        this.f3954d.lock();
                    }
                    this.f3953c = EnumC1065l.TERMINATED;
                    str = this.f3951a;
                } catch (IllegalStateException e) {
                    C1786r.m6055a((Throwable) e);
                }
            } else if (this.f3953c == EnumC1065l.TERMINATED) {
            }
        }
        return str;
    }

    /* renamed from: d */
    public synchronized void m4092d() {
        if (this.f3953c == EnumC1065l.BEFORE_START) {
            this.f3953c = EnumC1065l.TERMINATED;
        } else if (this.f3953c == EnumC1065l.READY_TO_START || this.f3953c == EnumC1065l.RECORDING || this.f3953c != EnumC1065l.TERMINATED) {
            try {
                this.f3952b.reset();
                this.f3952b.release();
                this.f3952b = null;
                if (this.f3954d != null) {
                    this.f3954d.lock();
                }
                new File(this.f3951a).delete();
                this.f3953c = EnumC1065l.TERMINATED;
            } catch (Exception e) {
                C1786r.m6055a((Throwable) e);
            }
        }
    }

    protected void finalize() throws Throwable {
        m4092d();
        super.finalize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a7 -> B:52:0x0053). Please report as a decompilation issue!!! */
    /* renamed from: b */
    private void m4086b(String str, SurfaceHolder surfaceHolder, MediaRecorder.OnInfoListener onInfoListener) throws IllegalStateException {
        if (onInfoListener != null) {
            this.f3952b.setOnInfoListener(onInfoListener);
        }
        this.f3952b.setCamera(this.f3954d);
        try {
            this.f3952b.setAudioSource(5);
        } catch (Exception e) {
            this.f3952b.setAudioSource(0);
        }
        try {
            this.f3952b.setVideoSource(1);
        } catch (Exception e2) {
            this.f3952b.setVideoSource(0);
        }
        Display defaultDisplay = ((WindowManager) GlobalApplication.m3260b().getSystemService("window")).getDefaultDisplay();
        if (640 > defaultDisplay.getWidth() && 480 > defaultDisplay.getHeight() && C1721ad.m5886m()) {
            CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
            if (camcorderProfile.videoFrameWidth <= 640 && camcorderProfile.videoFrameHeight <= 480) {
                this.f3952b.setProfile(camcorderProfile);
            } else {
                this.f3952b.setProfile(CamcorderProfile.get(0));
            }
        } else {
            try {
                this.f3952b.setOutputFormat(2);
            } catch (Exception e3) {
                this.f3952b.setOutputFormat(0);
            }
            try {
                this.f3952b.setVideoSize(640, 480);
            } catch (IllegalStateException e4) {
                C1786r.m6056a(e4, getClass().getName());
            }
            this.f3952b.setVideoEncodingBitRate(3000000);
            try {
                this.f3952b.setAudioEncoder(3);
            } catch (Exception e5) {
                this.f3952b.setAudioEncoder(0);
            }
            try {
                if (C1721ad.m5885l()) {
                    this.f3952b.setVideoEncoder(2);
                } else {
                    this.f3952b.setVideoEncoder(3);
                }
            } catch (Exception e6) {
                this.f3952b.setVideoEncoder(0);
            }
        }
        this.f3952b.setOutputFile(str);
        if (surfaceHolder != null) {
            this.f3952b.setPreviewDisplay(surfaceHolder.getSurface());
        }
    }

    /* renamed from: e */
    public synchronized String m4093e() {
        return this.f3951a;
    }
}
