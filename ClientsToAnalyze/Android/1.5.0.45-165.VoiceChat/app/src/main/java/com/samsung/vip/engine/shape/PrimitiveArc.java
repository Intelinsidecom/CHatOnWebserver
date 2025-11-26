package com.samsung.vip.engine.shape;

import android.graphics.PointF;

/* loaded from: classes.dex */
public class PrimitiveArc {
    private PointF mCenter;
    private float mMaxRadius;
    private float mMinRadius;
    private float mOrientation;
    private float mStartAngle;
    private float mSweepAngle;

    public PointF getCenter() {
        return this.mCenter;
    }

    public void setCenter(PointF center) {
        this.mCenter = center;
    }

    public float getMaxRadius() {
        return this.mMaxRadius;
    }

    public void setMaxRadius(float radius) {
        this.mMaxRadius = radius;
    }

    public float getMinRadius() {
        return this.mMinRadius;
    }

    public void setMinRadius(float radius) {
        this.mMinRadius = radius;
    }

    public float getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(float orientation) {
        this.mOrientation = orientation;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public void setStartAngle(float startAngle) {
        this.mStartAngle = startAngle;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.mSweepAngle = sweepAngle;
    }
}
