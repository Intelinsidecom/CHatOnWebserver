package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: VoiceListPlayer.java */
/* renamed from: com.sec.chaton.multimedia.audio.w */
/* loaded from: classes.dex */
public class C1791w {

    /* renamed from: b */
    private static final String f6630b = C1791w.class.getSimpleName();

    /* renamed from: c */
    private MediaPlayer f6632c;

    /* renamed from: e */
    private Handler f6634e;

    /* renamed from: f */
    private String f6635f;

    /* renamed from: g */
    private boolean f6636g;

    /* renamed from: a */
    MediaPlayer.OnCompletionListener f6631a = new C1792x(this);

    /* renamed from: h */
    private AudioManager.OnAudioFocusChangeListener f6637h = new C1793y(this);

    /* renamed from: d */
    private AudioManager f6633d = (AudioManager) GlobalApplication.m11493l().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);

    public C1791w(Handler handler) {
        this.f6634e = handler;
    }

    /* renamed from: a */
    public void m7381a(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.f6632c == null) {
            this.f6632c = new MediaPlayer();
        }
        this.f6635f = str;
        try {
            if (this.f6632c != null) {
                m7379d();
                this.f6633d.requestAudioFocus(this.f6637h, 3, 1);
                this.f6632c.reset();
                this.f6632c.setDataSource(str);
                this.f6632c.prepare();
                this.f6632c.start();
                this.f6632c.setOnCompletionListener(this.f6631a);
                if (this.f6634e != null) {
                    Message.obtain(this.f6634e, 1, this.f6635f).sendToTarget();
                }
            }
        } catch (IOException e) {
            C3250y.m11443a(e, f6630b);
            C3641ai.m13210a(GlobalApplication.m11493l(), R.string.toast_cannot_play_audio, 0).show();
        } catch (IllegalArgumentException e2) {
            C3250y.m11443a(e2, f6630b);
            C3641ai.m13210a(GlobalApplication.m11493l(), R.string.toast_cannot_play_audio, 0).show();
        } catch (IllegalStateException e3) {
            C3250y.m11443a(e3, f6630b);
            C3641ai.m13210a(GlobalApplication.m11493l(), R.string.toast_cannot_play_audio, 0).show();
        } catch (SecurityException e4) {
            C3250y.m11443a(e4, f6630b);
            C3641ai.m13210a(GlobalApplication.m11493l(), R.string.toast_cannot_play_audio, 0).show();
        }
    }

    /* renamed from: a */
    public void m7380a() throws IllegalStateException {
        if (this.f6632c != null) {
            try {
                if (this.f6632c.isPlaying()) {
                    this.f6632c.stop();
                }
                if (this.f6634e != null) {
                    Message.obtain(this.f6634e, 2, this.f6635f).sendToTarget();
                }
            } catch (IllegalArgumentException e) {
                C3250y.m11443a(e, f6630b);
            }
        }
    }

    /* renamed from: b */
    public void m7382b() throws IllegalStateException {
        try {
            if (this.f6632c != null) {
                if (this.f6632c.isPlaying()) {
                    this.f6632c.stop();
                }
                this.f6632c.release();
                this.f6632c = null;
            }
            if (this.f6633d != null) {
                this.f6633d.abandonAudioFocus(this.f6637h);
            }
        } catch (IllegalArgumentException e) {
            C3250y.m11443a(e, f6630b);
        }
    }

    /* renamed from: d */
    private void m7379d() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        GlobalApplication.m11493l().sendBroadcast(intent);
    }
}
