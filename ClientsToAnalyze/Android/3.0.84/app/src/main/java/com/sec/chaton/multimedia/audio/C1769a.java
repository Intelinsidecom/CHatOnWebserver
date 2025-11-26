package com.sec.chaton.multimedia.audio;

import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AudioEffectPool.java */
/* renamed from: com.sec.chaton.multimedia.audio.a */
/* loaded from: classes.dex */
public class C1769a {

    /* renamed from: a */
    private SoundPool f6531a;

    /* renamed from: b */
    private HashMap<String, Integer> f6532b;

    /* renamed from: c */
    private int f6533c;

    public C1769a(int i) {
        this.f6533c = 5;
        this.f6531a = new SoundPool(1, i, 0);
        this.f6533c = i;
        this.f6532b = new HashMap<>();
    }

    public C1769a(SoundPool.OnLoadCompleteListener onLoadCompleteListener) {
        this.f6533c = 5;
        this.f6531a = new SoundPool(1, this.f6533c, 0);
        this.f6531a.setOnLoadCompleteListener(onLoadCompleteListener);
        this.f6532b = new HashMap<>();
    }

    /* renamed from: a */
    public boolean m7287a(int i, String str) {
        if (this.f6532b != null && !this.f6532b.containsKey(str)) {
            try {
                this.f6532b.put(str, Integer.valueOf(this.f6531a.load(CommonApplication.m11493l(), i, 1)));
                return true;
            } catch (Resources.NotFoundException e) {
                C3250y.m11443a(e, C1769a.class.getSimpleName());
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m7288a(String str, String str2) {
        if (this.f6532b != null && !this.f6532b.containsKey(str2)) {
            try {
                this.f6532b.put(str2, Integer.valueOf(this.f6531a.load(str, 1)));
                return true;
            } catch (Exception e) {
                C3250y.m11443a(e, C1769a.class.getSimpleName());
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m7285a() {
        if (this.f6531a != null && this.f6532b != null) {
            Iterator<Map.Entry<String, Integer>> it = this.f6532b.entrySet().iterator();
            while (it.hasNext()) {
                this.f6531a.unload(it.next().getValue().intValue());
            }
            this.f6532b.clear();
            this.f6531a.release();
        }
    }

    /* renamed from: a */
    public void m7286a(String str) {
        AudioManager audioManager = (AudioManager) CommonApplication.m11493l().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (this.f6531a != null && audioManager.getStreamVolume(5) > 0 && this.f6532b != null && this.f6532b.containsKey(str)) {
            this.f6531a.autoPause();
            int streamMaxVolume = audioManager.getStreamMaxVolume(this.f6533c);
            int streamVolume = audioManager.getStreamVolume(this.f6533c);
            this.f6531a.play(this.f6532b.get(str).intValue(), streamVolume / streamMaxVolume, streamVolume / streamMaxVolume, 0, 0, 1.0f);
        }
    }
}
