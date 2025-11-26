package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.io.IOException;
import java.util.Timer;

/* compiled from: VoiceListPlayer.java */
/* renamed from: com.sec.chaton.multimedia.audio.s */
/* loaded from: classes.dex */
public class C2743s {

    /* renamed from: b */
    private static final String f9838b = C2743s.class.getSimpleName();

    /* renamed from: a */
    MediaPlayer.OnCompletionListener f9839a;

    /* renamed from: c */
    private MediaPlayer f9840c;

    /* renamed from: d */
    private AudioManager f9841d;

    /* renamed from: e */
    private Handler f9842e;

    /* renamed from: f */
    private String f9843f;

    /* renamed from: g */
    private boolean f9844g;

    /* renamed from: h */
    private int f9845h;

    /* renamed from: i */
    private Timer f9846i;

    /* renamed from: j */
    private boolean f9847j;

    /* renamed from: k */
    private AudioManager.OnAudioFocusChangeListener f9848k;

    public C2743s(Handler handler, boolean z) {
        this.f9839a = new C2745u(this);
        this.f9848k = new C2746v(this);
        this.f9842e = handler;
        this.f9841d = (AudioManager) GlobalApplication.m18732r().getSystemService("audio");
        this.f9847j = true;
    }

    public C2743s(Handler handler) {
        this.f9839a = new C2745u(this);
        this.f9848k = new C2746v(this);
        this.f9842e = handler;
        this.f9841d = (AudioManager) GlobalApplication.m18732r().getSystemService("audio");
    }

    /* renamed from: a */
    public boolean m11508a(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.f9840c == null) {
            this.f9840c = new MediaPlayer();
        }
        this.f9843f = str;
        try {
            if (this.f9840c != null) {
                m11506g();
                this.f9841d.requestAudioFocus(this.f9848k, 3, 1);
                this.f9840c.reset();
                this.f9840c.setDataSource(str);
                this.f9840c.prepare();
                this.f9840c.start();
                this.f9840c.setOnCompletionListener(this.f9839a);
                this.f9845h = this.f9840c.getDuration();
                if (this.f9842e != null && !this.f9847j) {
                    Message.obtain(this.f9842e, 1, this.f9843f).sendToTarget();
                }
                this.f9846i = new Timer(true);
                this.f9846i.scheduleAtFixedRate(new C2744t(this), 100L, 100L);
            }
            return true;
        } catch (IOException e) {
            C4904y.m18635a(e, f9838b);
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_cannot_play_audio, 0).show();
            return false;
        } catch (IllegalArgumentException e2) {
            C4904y.m18635a(e2, f9838b);
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_cannot_play_audio, 0).show();
            return false;
        } catch (IllegalStateException e3) {
            C4904y.m18635a(e3, f9838b);
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_cannot_play_audio, 0).show();
            return false;
        } catch (SecurityException e4) {
            C4904y.m18635a(e4, f9838b);
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_cannot_play_audio, 0).show();
            return false;
        }
    }

    /* renamed from: a */
    public void m11507a() throws IllegalStateException {
        if (this.f9840c != null) {
            try {
                if (this.f9840c.isPlaying()) {
                    this.f9840c.stop();
                }
                if (this.f9842e != null && !this.f9847j) {
                    Message.obtain(this.f9842e, 2, this.f9843f).sendToTarget();
                    m11504f();
                }
            } catch (IllegalArgumentException e) {
                C4904y.m18635a(e, f9838b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m11504f() {
        if (this.f9846i != null) {
            this.f9846i.cancel();
        }
    }

    /* renamed from: b */
    public void m11509b() throws IllegalStateException {
        try {
            if (this.f9840c != null) {
                if (this.f9840c.isPlaying()) {
                    this.f9840c.stop();
                }
                this.f9840c.release();
                this.f9840c = null;
            }
            if (this.f9841d != null) {
                this.f9841d.abandonAudioFocus(this.f9848k);
            }
            m11504f();
        } catch (IllegalArgumentException e) {
            C4904y.m18635a(e, f9838b);
        }
    }

    /* renamed from: g */
    private void m11506g() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        GlobalApplication.m18732r().sendBroadcast(intent);
    }

    /* renamed from: c */
    public int m11510c() {
        return this.f9845h;
    }

    /* renamed from: d */
    public boolean m11511d() {
        if (this.f9840c != null) {
            return this.f9840c.isPlaying();
        }
        return false;
    }
}
