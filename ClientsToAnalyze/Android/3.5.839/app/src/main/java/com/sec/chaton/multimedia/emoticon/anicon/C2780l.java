package com.sec.chaton.multimedia.emoticon.anicon;

import android.media.AudioManager;
import android.media.MediaPlayer;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.io.IOException;

/* compiled from: AniconPlusTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.l */
/* loaded from: classes.dex */
public class C2780l {

    /* renamed from: b */
    private static final String f10069b = C2780l.class.getSimpleName();

    /* renamed from: e */
    private static final C2780l f10070e = new C2780l();

    /* renamed from: d */
    private MediaPlayer f10073d;

    /* renamed from: c */
    private Object f10072c = null;

    /* renamed from: a */
    C2782n f10071a = null;

    private C2780l() {
    }

    /* renamed from: a */
    public static C2780l m11679a() {
        return f10070e;
    }

    /* renamed from: a */
    public void m11683a(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        AudioManager audioManager = (AudioManager) GlobalApplication.m18732r().getSystemService("audio");
        if (audioManager.getRingerMode() == 0) {
            C4904y.m18639b("[AniconId, Silent mode] ", getClass().getName());
            return;
        }
        m11684b();
        if (C3460d.m13785e(GlobalApplication.m18732r(), str) != null && C3460d.m13777b() && this.f10071a == null) {
            this.f10071a = new C2782n(this);
            this.f10071a.m11687a(1);
            this.f10071a.m11688a(str);
            this.f10071a.start();
        }
        if (audioManager.getRingerMode() == 1) {
            C4904y.m18639b("[AniconId, Vibrate mode] ", f10069b);
        } else {
            m11685b(str);
        }
    }

    /* renamed from: b */
    public void m11684b() {
        if (this.f10073d != null) {
            try {
                this.f10073d.stop();
            } catch (IllegalStateException e) {
                C4904y.m18635a(e, f10069b);
            }
        }
        if (this.f10071a != null) {
            this.f10071a.m11686a();
            if (C4904y.f17872b) {
                C4904y.m18639b("[mVibratorThread is not null] ", f10069b);
            }
        }
    }

    /* renamed from: b */
    public boolean m11685b(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        File fileM13783d = C3460d.m13783d(GlobalApplication.m18732r(), str);
        if (fileM13783d == null) {
            return false;
        }
        if (this.f10073d == null) {
            this.f10073d = new MediaPlayer();
        }
        try {
            if (this.f10073d != null) {
                this.f10073d.reset();
                this.f10073d.setDataSource(fileM13783d.getPath());
                this.f10073d.prepare();
                this.f10073d.start();
            }
            return true;
        } catch (IOException e) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18635a(e, f10069b);
            return false;
        } catch (IllegalArgumentException e2) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18635a(e2, f10069b);
            return false;
        } catch (IllegalStateException e3) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18635a(e3, f10069b);
            return false;
        } catch (SecurityException e4) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18635a(e4, f10069b);
            return false;
        }
    }
}
