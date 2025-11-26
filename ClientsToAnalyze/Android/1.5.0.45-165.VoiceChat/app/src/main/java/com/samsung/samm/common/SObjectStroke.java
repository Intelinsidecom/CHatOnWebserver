package com.samsung.samm.common;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class SObjectStroke extends SObject {
    public static final byte SAMM_DEFAULT_MAX_ERASERSIZE = 89;
    public static final byte SAMM_DEFAULT_MAX_STROKESIZE = 72;
    public static final byte SAMM_DEFAULT_MIN_STROKESIZE = 1;
    public static final int SAMM_METASTATE_ERASER = 2;
    public static final int SAMM_METASTATE_HAND = 0;
    public static final int SAMM_METASTATE_PEN = 1;

    @Deprecated
    public static final byte SAMM_PENSTYLE_BEAUTIFY = 5;

    @Deprecated
    public static final byte SAMM_PENSTYLE_BRUSH = 6;

    @Deprecated
    public static final byte SAMM_PENSTYLE_CRAYON = 1;

    @Deprecated
    public static final byte SAMM_PENSTYLE_CUSTOME = 100;

    @Deprecated
    public static final byte SAMM_PENSTYLE_DOTLINE = 3;

    @Deprecated
    public static final byte SAMM_PENSTYLE_ERASER = 4;

    @Deprecated
    public static final byte SAMM_PENSTYLE_MARKER = 2;

    @Deprecated
    public static final byte SAMM_PENSTYLE_PENCIL = 0;

    @Deprecated
    public static final byte SAMM_PENSTYLE_SHINY = 2;
    public static final byte SAMM_STROKE_STYLE_BEAUTIFY = 5;
    public static final byte SAMM_STROKE_STYLE_BRUSH = 6;
    public static final byte SAMM_STROKE_STYLE_CHINESE_BRUSH = 7;
    public static final byte SAMM_STROKE_STYLE_CRAYON = 1;
    public static final byte SAMM_STROKE_STYLE_CUSTOME = 100;
    public static final byte SAMM_STROKE_STYLE_DOTLINE = 3;
    public static final byte SAMM_STROKE_STYLE_ERASER = 4;
    public static final byte SAMM_STROKE_STYLE_MARKER = 2;
    public static final byte SAMM_STROKE_STYLE_PENCIL = 0;
    public static final byte SAMM_STROKE_STYLE_SOLID = 0;

    /* renamed from: a */
    private int f413a;

    /* renamed from: b */
    private PointF[] f414b;

    /* renamed from: c */
    private float[] f415c;

    /* renamed from: d */
    private float f416d;

    public SObjectStroke() {
        this.mColor = -16777216;
        this.mSize = 10.0f;
        this.f416d = 72.0f;
        this.mStyle = 0;
        this.f414b = null;
        this.f415c = null;
    }

    @Override // com.samsung.samm.common.SObject
    public boolean setStyle(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 100) {
            this.mStyle = i;
            return true;
        }
        Log.e("SAMMLibrary", "Undefined Stroke Style : " + i);
        return false;
    }

    public int getPointNum() {
        if (this.f414b != null) {
            return this.f414b.length;
        }
        return 0;
    }

    public PointF[] getPoints() {
        if (this.f414b == null) {
            return null;
        }
        PointF[] pointFArr = new PointF[this.f414b.length];
        for (int i = 0; i < this.f414b.length; i++) {
            pointFArr[i] = this.f414b[i];
        }
        return pointFArr;
    }

    public void setPoints(PointF[] pointFArr) {
        if (pointFArr == null || pointFArr.length <= 0) {
            this.f414b = null;
        } else {
            this.f414b = new PointF[pointFArr.length];
            for (int i = 0; i < pointFArr.length; i++) {
                this.f414b[i] = pointFArr[i];
            }
        }
        if (this.mRect == null) {
            m153a();
        }
    }

    public int getPressureNum() {
        if (this.f415c != null) {
            return this.f415c.length;
        }
        return 0;
    }

    public float[] getPressures() {
        if (this.f415c == null) {
            return null;
        }
        float[] fArr = new float[this.f415c.length];
        for (int i = 0; i < this.f415c.length; i++) {
            fArr[i] = this.f415c[i];
        }
        return fArr;
    }

    public void setPressures(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            this.f415c = null;
            return;
        }
        this.f415c = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            this.f415c[i] = fArr[i];
        }
    }

    public int getMetaData() {
        return this.f413a;
    }

    public void setMetaData(int i) {
        this.f413a = i;
    }

    /* renamed from: a */
    private void m153a() {
        this.mRect = m154b();
    }

    /* renamed from: b */
    private RectF m154b() {
        float f = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        if (this.f414b == null || this.f414b.length <= 0) {
            return new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i = 0; i < this.f414b.length; i++) {
            if (f4 > this.f414b[i].x || i == 0) {
                f4 = this.f414b[i].x;
            }
            if (f3 > this.f414b[i].y || i == 0) {
                f3 = this.f414b[i].y;
            }
            if (f2 < this.f414b[i].x || i == 0) {
                f2 = this.f414b[i].x;
            }
            if (f < this.f414b[i].y || i == 0) {
                f = this.f414b[i].y;
            }
        }
        float f5 = this.f416d / 2.0f;
        return new RectF(f4 - f5, f3 - f5, f2 + f5, f + f5);
    }

    @Override // com.samsung.samm.common.SObject
    public SObject copyObject() {
        SObjectStroke sObjectStroke = new SObjectStroke();
        copyObjectGeneral(sObjectStroke);
        sObjectStroke.setPoints(getPoints());
        sObjectStroke.setPressures(getPressures());
        sObjectStroke.setMetaData(getMetaData());
        return sObjectStroke;
    }

    @Override // com.samsung.samm.common.SObject
    public boolean changeObject(SObject sObject) {
        if (!super.changeObjectGeneral(sObject)) {
            return false;
        }
        SObjectStroke sObjectStroke = (SObjectStroke) sObject;
        setPoints(sObjectStroke.getPoints());
        setPressures(sObjectStroke.getPressures());
        setMetaData(sObjectStroke.getMetaData());
        return true;
    }

    @Override // com.samsung.samm.common.SObject
    public String getObjectInfo() {
        return "Number of Points = " + getPointNum();
    }
}
