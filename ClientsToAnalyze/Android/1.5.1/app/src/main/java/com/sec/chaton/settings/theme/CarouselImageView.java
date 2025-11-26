package com.sec.chaton.settings.theme;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class CarouselImageView extends ImageView implements Comparable {

    /* renamed from: a */
    private int f3252a;

    /* renamed from: b */
    private float f3253b;

    /* renamed from: c */
    private float f3254c;

    /* renamed from: d */
    private float f3255d;

    /* renamed from: e */
    private float f3256e;

    /* renamed from: f */
    private boolean f3257f;

    public CarouselImageView(Context context) {
        this(context, null, 0);
    }

    public CarouselImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarouselImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public int m3261a() {
        return this.f3252a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CarouselImageView carouselImageView) {
        return (int) (carouselImageView.f3256e - this.f3256e);
    }

    /* renamed from: b */
    public float m3263b() {
        return this.f3253b;
    }

    /* renamed from: c */
    public float m3264c() {
        return this.f3256e;
    }

    /* renamed from: d */
    public boolean m3265d() {
        return this.f3257f;
    }

    @Override // android.view.View
    public float getX() {
        return this.f3254c;
    }

    @Override // android.view.View
    public float getY() {
        return this.f3255d;
    }

    public void setCurrentAngle(float f) {
        this.f3253b = f;
    }

    public void setDrawn(boolean z) {
        this.f3257f = z;
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
    }

    public void setIndex(int i) {
        this.f3252a = i;
    }

    @Override // android.view.View
    public void setX(float f) {
        this.f3254c = f;
    }

    @Override // android.view.View
    public void setY(float f) {
        this.f3255d = f;
    }

    @Override // android.view.View
    public void setZ(float f) {
        this.f3256e = f;
    }
}
