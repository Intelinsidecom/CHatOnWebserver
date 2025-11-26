package com.samsung.vip.engine.shape;

import android.graphics.Point;

/* loaded from: classes.dex */
public class PrimitiveEllipseArc {
    public Point Center;
    public int Direction;
    public float cosTheta;
    public Point end;
    public int longAxis;
    public int shortAxis;
    public float sinTheta;
    public Point start;

    public int getDirection() {
        return this.Direction;
    }

    public void setDirection(int direction) {
        this.Direction = direction;
    }

    public Point getCenter() {
        return this.Center;
    }

    public void setCenter(Point center) {
        this.Center = center;
    }

    public Point getStart() {
        return this.start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return this.end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getLongAxis() {
        return this.longAxis;
    }

    public void setLongAxis(int longAxis) {
        this.longAxis = longAxis;
    }

    public int getShortAxis() {
        return this.shortAxis;
    }

    public void setShortAxis(int shortAxis) {
        this.shortAxis = shortAxis;
    }

    public float getCosTheta() {
        return this.cosTheta;
    }

    public void setCosTheta(float cosTheta) {
        this.cosTheta = cosTheta;
    }

    public float getSinTheta() {
        return this.sinTheta;
    }

    public void setSinTheta(float sinTheta) {
        this.sinTheta = sinTheta;
    }
}
