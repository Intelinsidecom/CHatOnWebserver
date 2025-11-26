package com.samsung.vip.engine.shape;

import android.graphics.Point;

/* loaded from: classes.dex */
public class PrimitiveEllipse {
    public Point Center;
    public float CosTheta;
    public int LongAxis;
    public int ShortAxis;
    public float SinTheta;

    public Point getCenter() {
        return this.Center;
    }

    public void setCenter(Point center) {
        this.Center = center;
    }

    public int getLongAxis() {
        return this.LongAxis;
    }

    public void setLongAxis(int longAxis) {
        this.LongAxis = longAxis;
    }

    public int getShortAxis() {
        return this.ShortAxis;
    }

    public void setShortAxis(int shortAxis) {
        this.ShortAxis = shortAxis;
    }

    public float getCosTheta() {
        return this.CosTheta;
    }

    public void setCosTheta(float cosTheta) {
        this.CosTheta = cosTheta;
    }

    public float getSinTheta() {
        return this.SinTheta;
    }

    public void setSinTheta(float sinTheta) {
        this.SinTheta = sinTheta;
    }
}
