package com.sec.chaton.settings.theme;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

/* loaded from: classes.dex */
public class Rotator {

    /* renamed from: a */
    private int f3269a;

    /* renamed from: b */
    private float f3270b;

    /* renamed from: c */
    private float f3271c;

    /* renamed from: d */
    private float f3272d;

    /* renamed from: e */
    private float f3273e;

    /* renamed from: f */
    private float f3274f;

    /* renamed from: g */
    private long f3275g;

    /* renamed from: h */
    private int f3276h;

    /* renamed from: i */
    private float f3277i;

    /* renamed from: j */
    private float f3278j;

    /* renamed from: k */
    private float f3279k;

    /* renamed from: n */
    private float f3282n;

    /* renamed from: o */
    private final float f3283o;

    /* renamed from: m */
    private float f3281m = 0.0f;

    /* renamed from: l */
    private boolean f3280l = true;

    public Rotator(Context context) {
        this.f3283o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * ViewConfiguration.getScrollFriction();
    }

    /* renamed from: a */
    private float m3274a(float f) {
        float f2 = this.f3278j * f;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f) * this.f3279k;
    }

    /* renamed from: a */
    public final float m3275a() {
        return this.f3274f;
    }

    /* renamed from: a */
    public void m3276a(float f, float f2, float f3, float f4) {
        this.f3269a = 1;
        this.f3280l = false;
        this.f3282n = f2;
        this.f3276h = (int) ((1000.0f * f2) / this.f3283o);
        this.f3275g = AnimationUtils.currentAnimationTimeMillis();
        this.f3270b = f;
        this.f3281m = 1.0f;
        int i = (int) ((f2 * f2) / (2.0f * this.f3283o));
        this.f3273e = f3;
        this.f3272d = f4;
        this.f3271c = Math.round(i * this.f3281m) + f;
        this.f3271c = Math.min(this.f3271c, this.f3272d);
        this.f3271c = Math.max(this.f3271c, this.f3273e);
    }

    /* renamed from: a */
    public void m3277a(float f, float f2, int i) {
        this.f3269a = 0;
        this.f3280l = false;
        this.f3276h = i;
        this.f3275g = AnimationUtils.currentAnimationTimeMillis();
        this.f3270b = f;
        this.f3271c = f + f2;
        this.f3277i = f2;
        this.f3278j = 8.0f;
        this.f3279k = 1.0f;
        this.f3279k = 1.0f / m3274a(1.0f);
    }

    /* renamed from: a */
    public final void m3278a(boolean z) {
        this.f3280l = z;
    }

    /* renamed from: b */
    public boolean m3279b() {
        if (this.f3280l) {
            return false;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f3275g);
        if (iCurrentAnimationTimeMillis < this.f3276h) {
            switch (this.f3269a) {
                case 0:
                    int i = iCurrentAnimationTimeMillis / this.f3276h;
                    this.f3274f = Math.round(i * this.f3277i) + this.f3270b;
                    break;
                case 1:
                    float f = iCurrentAnimationTimeMillis / 1000.0f;
                    float f2 = (this.f3282n * f) - ((f * (this.f3283o * f)) / 2.0f);
                    this.f3274f = Math.round(f2 * this.f3281m) + this.f3270b;
                    this.f3274f = Math.min(this.f3274f, this.f3272d);
                    this.f3274f = Math.max(this.f3274f, this.f3273e);
                    break;
            }
        } else {
            this.f3274f = this.f3271c;
            this.f3280l = true;
        }
        return true;
    }
}
