package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class ImageInfo extends ObjectInfo {
    public static final int DEFAULT_STYLE = 0;
    public static final int FILLING_STYLE = 1;

    /* renamed from: a */
    private int f1059a;
    public float angle;
    public Bitmap img;
    public int objectID;
    public RectF rectf;

    public ImageInfo(Bitmap img, RectF rectf, int objectID) {
        this.img = img;
        this.rectf = rectf;
        this.objectID = objectID;
        setLayerID(1);
        setID(this.objectID);
        setStyle(0);
    }

    public ImageInfo(Bitmap img, RectF rectf) {
        this.img = img;
        this.rectf = rectf;
        this.angle = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.objectID = -1;
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
        setStyle(0);
    }

    public ImageInfo(Bitmap img, RectF rectf, float angle) {
        this.img = img;
        this.rectf = rectf;
        this.angle = angle;
        this.objectID = -1;
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
        setStyle(0);
    }

    public ImageInfo(Bitmap img, RectF rectf, float angle, int layerID) {
        this.img = img;
        this.rectf = rectf;
        this.angle = angle;
        this.objectID = -1;
        if (layerID == 2) {
            setLayerID(0);
        } else if (layerID == 4) {
            setLayerID(1);
        } else if (layerID != 0 && layerID != 1) {
            setLayerID(1);
        } else {
            setLayerID(layerID);
        }
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
        setStyle(0);
    }

    public void set(Bitmap img, RectF rectf, int objectID) {
        this.img = img;
        this.rectf = rectf;
        this.angle = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.objectID = objectID;
        setLayerID(1);
        setID(objectID);
        setStyle(0);
    }

    public Bitmap getImg() {
        return this.img;
    }

    public RectF getRect() {
        return this.rectf;
    }

    public float getAngle() {
        return this.angle;
    }

    public int getStyle() {
        return this.f1059a;
    }

    public void setStyle(int style) {
        if (style == 0 || style == 1) {
            this.f1059a = style;
        }
    }
}
