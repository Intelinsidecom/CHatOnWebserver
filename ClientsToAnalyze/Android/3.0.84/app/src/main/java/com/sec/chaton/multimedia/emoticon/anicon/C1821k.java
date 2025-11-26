package com.sec.chaton.multimedia.emoticon.anicon;

import android.media.AudioManager;
import android.media.MediaPlayer;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.io.IOException;

/* compiled from: AniconPlusTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.k */
/* loaded from: classes.dex */
public class C1821k {

    /* renamed from: b */
    private static final String f6794b = C1821k.class.getSimpleName();

    /* renamed from: e */
    private static final C1821k f6795e = new C1821k();

    /* renamed from: d */
    private MediaPlayer f6798d;

    /* renamed from: c */
    private Object f6797c = null;

    /* renamed from: a */
    C1823m f6796a = null;

    private C1821k() {
    }

    /* renamed from: a */
    public static C1821k m7478a() {
        return f6795e;
    }

    /* renamed from: a */
    public void m7482a(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        AudioManager audioManager = (AudioManager) GlobalApplication.m11493l().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager.getRingerMode() == 0) {
            C3250y.m11450b("[AniconId, Silent mode] ", getClass().getName());
            return;
        }
        m7483b();
        if (C2646u.m9669e(GlobalApplication.m11493l(), str) != null && C2646u.m9660b() && this.f6796a == null) {
            this.f6796a = new C1823m(this);
            this.f6796a.m7486a(1);
            this.f6796a.m7487a(str);
            this.f6796a.start();
        }
        if (audioManager.getRingerMode() == 1) {
            C3250y.m11450b("[AniconId, Vibrate mode] ", f6794b);
        } else {
            m7484b(str);
        }
    }

    /* renamed from: b */
    public void m7483b() {
        if (this.f6798d != null) {
            try {
                this.f6798d.stop();
            } catch (IllegalStateException e) {
                C3250y.m11443a(e, f6794b);
            }
        }
        if (this.f6796a != null) {
            this.f6796a.m7485a();
            C3250y.m11450b("[mVibratorThread is not null] ", f6794b);
        }
    }

    /* renamed from: b */
    public boolean m7484b(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        File fileM9667d = C2646u.m9667d(GlobalApplication.m11493l(), str);
        if (fileM9667d == null) {
            return false;
        }
        if (this.f6798d == null) {
            this.f6798d = new MediaPlayer();
        }
        try {
            if (this.f6798d != null) {
                this.f6798d.reset();
                this.f6798d.setDataSource(fileM9667d.getPath());
                this.f6798d.prepare();
                this.f6798d.start();
            }
            return true;
        } catch (IOException e) {
            C3250y.m11443a(e, f6794b);
            return false;
        } catch (IllegalArgumentException e2) {
            C3250y.m11443a(e2, f6794b);
            return false;
        } catch (IllegalStateException e3) {
            C3250y.m11443a(e3, f6794b);
            return false;
        } catch (SecurityException e4) {
            C3250y.m11443a(e4, f6794b);
            return false;
        }
    }
}
