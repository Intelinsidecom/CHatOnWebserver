package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class FillColorInfo extends ObjectInfo {

    /* renamed from: a */
    private Bitmap f1044a;
    public String cachePath;
    public int color;
    public RectF fillingBound;

    /* renamed from: x */
    public int f1045x;

    /* renamed from: y */
    public int f1046y;

    public FillColorInfo(int color, int x, int y) {
        this.color = 16777215 & color;
        this.f1045x = x;
        this.f1046y = y;
        this.fillingBound = null;
        this.cachePath = null;
        setLayerID(1);
        setID(-1);
    }

    public FillColorInfo(int layerID, int color, int x, int y) {
        this.color = 16777215 & color;
        this.f1045x = x;
        this.f1046y = y;
        this.fillingBound = null;
        this.cachePath = null;
        setLayerID(layerID);
        setID(-1);
    }

    public FillColorInfo(int layerID, int color, int x, int y, RectF fillingBound) {
        this.color = 16777215 & color;
        this.f1045x = x;
        this.f1046y = y;
        this.fillingBound = fillingBound;
        this.cachePath = null;
        setLayerID(layerID);
        setID(-1);
    }

    public FillColorInfo(int color, int x, int y, String cachePath) {
        this.color = 16777215 & color;
        this.f1045x = x;
        this.f1046y = y;
        this.fillingBound = null;
        this.cachePath = cachePath;
        setLayerID(1);
        setID(-1);
    }

    public FillColorInfo(int layerID, int color, int x, int y, String cachePath) {
        this.color = 16777215 & color;
        this.f1045x = x;
        this.f1046y = y;
        this.fillingBound = null;
        this.cachePath = cachePath;
        setLayerID(layerID);
        setID(-1);
    }

    public FillColorInfo(int layerID, int color, int x, int y, RectF fillingBound, String cachePath) {
        this.color = 16777215 & color;
        this.f1045x = x;
        this.f1046y = y;
        this.fillingBound = fillingBound;
        this.cachePath = cachePath;
        setLayerID(layerID);
        setID(-1);
    }

    public void setFilledBitmap(Bitmap filledBitmap) {
        if (filledBitmap != null) {
            this.f1044a = Bitmap.createBitmap(filledBitmap);
        } else {
            this.f1044a = null;
        }
    }

    public Bitmap getFilledBitmap() {
        return this.f1044a;
    }
}
