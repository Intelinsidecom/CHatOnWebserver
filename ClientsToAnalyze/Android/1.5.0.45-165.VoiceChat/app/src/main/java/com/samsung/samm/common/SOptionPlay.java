package com.samsung.samm.common;

import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class SOptionPlay {
    public static final int ANIMATION_SPEED_AUTO = 4;
    public static final int ANIMATION_SPEED_FAST = 2;
    public static final int ANIMATION_SPEED_MAX = 3;
    public static final int ANIMATION_SPEED_NORMAL = 1;
    public static final int ANIMATION_SPEED_SLOW = 0;

    /* renamed from: a */
    private boolean f422a = false;

    /* renamed from: b */
    private boolean f423b = true;

    /* renamed from: c */
    private boolean f424c = false;

    /* renamed from: d */
    private float f425d = 1.0f;

    /* renamed from: e */
    private int f426e = 4;

    /* renamed from: f */
    private boolean f427f = true;

    /* renamed from: g */
    private boolean f428g = true;

    /* renamed from: h */
    private float f429h = 1.0f;

    public void setInvisibleBGImageAnimationOption(boolean z) {
        this.f422a = z;
    }

    @Deprecated
    public void setTransparentBGImageAnimation(boolean z) {
        this.f422a = z;
    }

    public boolean getInvisibleBGImageAnimationOption() {
        return this.f422a;
    }

    @Deprecated
    public boolean getTransparentBGImageAnimation() {
        return this.f422a;
    }

    public void setPlayBGAudioOption(boolean z) {
        this.f423b = z;
    }

    @Deprecated
    public void setPlayBGAudio(boolean z) {
        this.f423b = z;
    }

    public boolean getPlayBGAudioOption() {
        return this.f423b;
    }

    @Deprecated
    public boolean getPlayBGAudio() {
        return this.f423b;
    }

    public void setRepeatBGAudioOption(boolean z) {
        this.f424c = z;
    }

    @Deprecated
    public void setRepeatBGAudio(boolean z) {
        this.f424c = z;
    }

    public boolean getRepeatBGAudioOption() {
        return this.f424c;
    }

    @Deprecated
    public boolean getRepeatBGAudio() {
        return this.f424c;
    }

    public boolean setBGAudioVolume(float f) {
        if (f < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || f > 1.0f) {
            return false;
        }
        this.f425d = f;
        return true;
    }

    public float getBGAudioVolume() {
        return this.f425d;
    }

    public boolean setAnimationSpeed(int i) {
        if (i < 0 || i > 4) {
            return false;
        }
        this.f426e = i;
        return true;
    }

    public int getAnimationSpeed() {
        return this.f426e;
    }

    public void setStopBGAudioOption(boolean z) {
        this.f427f = z;
    }

    @Deprecated
    public void setStopBGAudio(boolean z) {
        this.f427f = z;
    }

    public boolean getStopBGAudioOption() {
        return this.f427f;
    }

    @Deprecated
    public boolean getStopBGAudio() {
        return this.f427f;
    }

    public void setSoundEffectOption(boolean z) {
        this.f428g = z;
    }

    public boolean getSoundEffectOption() {
        return this.f428g;
    }

    public boolean setSoundEffectVolume(float f) {
        if (f < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || f > 1.0f) {
            return false;
        }
        this.f429h = f;
        return true;
    }

    public float getSoundEffectVolume() {
        return this.f429h;
    }
}
