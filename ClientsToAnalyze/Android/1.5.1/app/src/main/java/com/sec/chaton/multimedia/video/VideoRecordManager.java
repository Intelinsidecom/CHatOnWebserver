package com.sec.chaton.multimedia.video;

import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;

/* loaded from: classes.dex */
public class VideoRecordManager {

    /* renamed from: a */
    private String f2408a;

    /* renamed from: b */
    private MediaRecorder f2409b = new MediaRecorder();

    /* renamed from: c */
    private State f2410c = State.BEFORE_START;

    public enum State {
        BEFORE_START,
        READY_TO_START,
        RECORDING,
        TERMINATED
    }

    /* renamed from: b */
    private void m2691b(String str, SurfaceHolder surfaceHolder, MediaRecorder.OnInfoListener onInfoListener) throws IllegalStateException {
        if (onInfoListener != null) {
            this.f2409b.setOnInfoListener(onInfoListener);
        }
        if (surfaceHolder != null) {
            this.f2409b.setPreviewDisplay(surfaceHolder.getSurface());
        }
        try {
            this.f2409b.setAudioSource(1);
        } catch (Exception e) {
            this.f2409b.setAudioSource(0);
        }
        try {
            this.f2409b.setVideoSource(1);
        } catch (Exception e2) {
            this.f2409b.setVideoSource(0);
        }
        try {
            this.f2409b.setOutputFormat(2);
        } catch (Exception e3) {
            this.f2409b.setOutputFormat(0);
        }
        this.f2409b.setVideoSize(640, 480);
        this.f2409b.setVideoEncodingBitRate(3000000);
        try {
            this.f2409b.setAudioEncoder(3);
        } catch (Exception e4) {
            this.f2409b.setAudioEncoder(0);
        }
        try {
            this.f2409b.setVideoEncoder(2);
        } catch (Exception e5) {
            this.f2409b.setVideoEncoder(0);
        }
        this.f2409b.setOutputFile(str);
    }

    /* renamed from: a */
    public synchronized State m2692a() {
        return this.f2410c;
    }

    /* renamed from: a */
    public synchronized void m2693a(String str, SurfaceHolder surfaceHolder, MediaRecorder.OnInfoListener onInfoListener) {
        if (this.f2410c == State.BEFORE_START) {
            try {
                this.f2409b.reset();
            } catch (Exception e) {
                ChatONLogWriter.m3500a((Throwable) e);
            }
            try {
                m2691b(str, surfaceHolder, onInfoListener);
                this.f2408a = str;
                this.f2409b.prepare();
                this.f2410c = State.READY_TO_START;
            } catch (IllegalStateException e2) {
                ChatONLogWriter.m3500a((Throwable) e2);
            }
        } else if (this.f2410c != State.READY_TO_START) {
            if (this.f2410c == State.RECORDING) {
                try {
                    this.f2409b.reset();
                    new File(this.f2408a).delete();
                } catch (Exception e3) {
                    ChatONLogWriter.m3500a((Throwable) e3);
                }
                m2691b(str, surfaceHolder, onInfoListener);
                this.f2408a = str;
                this.f2409b.prepare();
                this.f2410c = State.READY_TO_START;
            } else {
                if (this.f2410c == State.TERMINATED) {
                    try {
                        this.f2409b.reset();
                    } catch (Exception e4) {
                        ChatONLogWriter.m3500a((Throwable) e4);
                    }
                }
                m2691b(str, surfaceHolder, onInfoListener);
                this.f2408a = str;
                this.f2409b.prepare();
                this.f2410c = State.READY_TO_START;
            }
        }
    }

    /* renamed from: b */
    public synchronized void m2694b() {
        if (this.f2410c != State.BEFORE_START) {
            if (this.f2410c == State.READY_TO_START) {
                try {
                    this.f2409b.start();
                    this.f2410c = State.RECORDING;
                } catch (IllegalStateException e) {
                    ChatONLogWriter.m3500a((Throwable) e);
                }
            } else if (this.f2410c == State.RECORDING || this.f2410c == State.TERMINATED) {
            }
        }
    }

    /* renamed from: c */
    public synchronized String m2695c() {
        String str;
        str = null;
        if (this.f2410c == State.BEFORE_START) {
            this.f2410c = State.TERMINATED;
        } else if (this.f2410c == State.READY_TO_START) {
            m2696d();
        } else if (this.f2410c == State.RECORDING) {
            try {
                this.f2409b.stop();
                this.f2410c = State.TERMINATED;
                str = this.f2408a;
            } catch (IllegalStateException e) {
                ChatONLogWriter.m3500a((Throwable) e);
            }
        } else if (this.f2410c == State.TERMINATED) {
        }
        return str;
    }

    /* renamed from: d */
    public synchronized void m2696d() {
        if (this.f2410c == State.BEFORE_START) {
            this.f2410c = State.TERMINATED;
        } else if (this.f2410c == State.READY_TO_START || this.f2410c == State.RECORDING || this.f2410c != State.TERMINATED) {
            try {
                this.f2409b.reset();
                this.f2409b.release();
                new File(this.f2408a).delete();
                this.f2410c = State.TERMINATED;
            } catch (Exception e) {
                ChatONLogWriter.m3500a((Throwable) e);
            }
        }
    }

    /* renamed from: e */
    public synchronized String m2697e() {
        return this.f2408a;
    }

    protected void finalize() throws Throwable {
        m2696d();
        super.finalize();
    }
}
