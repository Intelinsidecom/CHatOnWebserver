package com.samsung.sdraw;

import android.graphics.Point;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class PointF extends android.graphics.PointF {
    public PointF() {
    }

    public PointF(android.graphics.PointF point) {
        set(point.x, point.y);
    }

    public PointF(Point point) {
        set(point.x, point.y);
    }

    public PointF(float x, float y) {
        set(x, y);
    }

    public PointF(String[] point) {
        set(Float.parseFloat(point[0]), Float.parseFloat(point[1]));
    }

    public static boolean isNearlyZero(float x) {
        return Math.abs(x) < 1.2357884E-4f;
    }

    public static float calculateDistance(PointF a, PointF b) {
        return calculateDistance(a.x, a.y, b.x, b.y);
    }

    public static float calculateDistance(float x0, float y0, float x1, float y1) {
        float f = x0 - x1;
        float f2 = y0 - y1;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public static boolean isClockWise(float x0, float y0, float x1, float y1) {
        return (x0 * y1) - (y0 * x1) > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    public static float calculateDegree(float x0, float y0, float x1, float y1) {
        return (float) ((Math.atan2(x1 - x0, y1 - y0) * 180.0d) / 3.141592653589793d);
    }

    public static float calculateDelta(float x0, float y0, float x1, float y1) {
        float f = x1 - x0;
        float f2 = y1 - y0;
        return Math.abs(f) >= Math.abs(f2) ? f : f2;
    }

    public static boolean calculateDirection(float x0, float y0, float x1, float y1) {
        return Math.abs(x1 - x0) >= Math.abs(y1 - y0);
    }

    public void translate(float dx, float dy) {
        offset(dx, dy);
    }

    public void rotate(float theta) {
        float fCos = (float) Math.cos((theta / 180.0f) * 3.141592653589793d);
        float fSin = (float) Math.sin((theta / 180.0f) * 3.141592653589793d);
        set((this.x * fCos) - (this.y * fSin), (fCos * this.y) + (fSin * this.x));
    }
}
