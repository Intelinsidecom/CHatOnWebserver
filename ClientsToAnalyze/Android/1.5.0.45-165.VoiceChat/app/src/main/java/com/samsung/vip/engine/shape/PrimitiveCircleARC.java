package com.samsung.vip.engine.shape;

import android.graphics.Point;

/* loaded from: classes.dex */
public class PrimitiveCircleARC {
    public Point Center;
    public int Direction;
    public int Radius;
    public Point end;
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

    public int getRadius() {
        return this.Radius;
    }

    public void setRadius(int radius) {
        this.Radius = radius;
    }
}
