package com.sec.chaton.multimedia.audio;

import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AudioEffectPool.java */
/* renamed from: com.sec.chaton.multimedia.audio.a */
/* loaded from: classes.dex */
public class C2723a {

    /* renamed from: a */
    private SoundPool f9758a;

    /* renamed from: b */
    private HashMap<String, Integer> f9759b;

    /* renamed from: c */
    private int f9760c;

    public C2723a(int i) {
        this.f9760c = 5;
        this.f9758a = new SoundPool(1, i, 0);
        this.f9760c = i;
        this.f9759b = new HashMap<>();
    }

    public C2723a(SoundPool.OnLoadCompleteListener onLoadCompleteListener) {
        this.f9760c = 5;
        this.f9758a = new SoundPool(1, this.f9760c, 0);
        this.f9758a.setOnLoadCompleteListener(onLoadCompleteListener);
        this.f9759b = new HashMap<>();
    }

    /* renamed from: a */
    public boolean m11427a(int i, String str) {
        if (this.f9759b != null && !this.f9759b.containsKey(str)) {
            try {
                this.f9759b.put(str, Integer.valueOf(this.f9758a.load(CommonApplication.m18732r(), i, 1)));
                return true;
            } catch (Resources.NotFoundException e) {
                C4904y.m18635a(e, C2723a.class.getSimpleName());
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m11428a(String str, String str2) {
        if (this.f9759b != null && !this.f9759b.containsKey(str2)) {
            try {
                this.f9759b.put(str2, Integer.valueOf(this.f9758a.load(str, 1)));
                return true;
            } catch (Exception e) {
                C4904y.m18635a(e, C2723a.class.getSimpleName());
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m11425a() {
        if (this.f9758a != null && this.f9759b != null) {
            Iterator<Map.Entry<String, Integer>> it = this.f9759b.entrySet().iterator();
            while (it.hasNext()) {
                this.f9758a.unload(it.next().getValue().intValue());
            }
            this.f9759b.clear();
            this.f9758a.release();
        }
    }

    /* renamed from: a */
    public void m11426a(String str) {
        AudioManager audioManager = (AudioManager) CommonApplication.m18732r().getSystemService("audio");
        if (this.f9758a != null && audioManager.getStreamVolume(5) > 0 && this.f9759b != null && this.f9759b.containsKey(str)) {
            this.f9758a.autoPause();
            int streamMaxVolume = audioManager.getStreamMaxVolume(this.f9760c);
            int streamVolume = audioManager.getStreamVolume(this.f9760c);
            this.f9758a.play(this.f9759b.get(str).intValue(), streamVolume / streamMaxVolume, streamVolume / streamMaxVolume, 0, 0, 1.0f);
        }
    }
}
