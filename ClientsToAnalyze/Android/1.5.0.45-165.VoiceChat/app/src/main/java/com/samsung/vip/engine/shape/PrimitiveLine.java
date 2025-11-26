package com.samsung.vip.engine.shape;

import android.graphics.Point;

/* loaded from: classes.dex */
public class PrimitiveLine {
    public Point end;
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

    public boolean isEqual(PrimitiveLine line, boolean bIgnoreDirection) {
        return bIgnoreDirection ? (getStart().equals(line.getStart()) && getEnd().equals(line.getEnd())) || (getStart().equals(line.getEnd()) && getEnd().equals(line.getStart())) : getStart().equals(line.getStart()) && getEnd().equals(line.getEnd());
    }
}
