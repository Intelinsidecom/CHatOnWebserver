package com.samsung.vip.engine.shape;

import android.graphics.Point;

/* loaded from: classes.dex */
public class PrimitiveArrow {
    public Point end;
    public Point left;
    public Point right;
    public Point start;

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

    public Point getRight() {
        return this.right;
    }

    public void setRight(Point right) {
        this.right = right;
    }

    public Point getLeft() {
        return this.left;
    }

    public void setLeft(Point left) {
        this.left = left;
    }
}
