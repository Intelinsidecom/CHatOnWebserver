package com.samsung.sdraw;

/* loaded from: classes.dex */
public class StrokeInfo extends ObjectInfo {
    public int alpha;
    public int color;
    public long[] event_time;
    public int meta_state;
    public int objectID;
    public android.graphics.PointF[] points;
    public float[] pressure;
    public int type;
    public float width;

    public StrokeInfo(int type, int color, int alpha, float width, float[] pressure, android.graphics.PointF[] points, int meta_state, long[] event_time, int objectID) {
        this.type = type;
        this.color = 16777215 & color;
        this.alpha = alpha;
        this.width = width;
        this.pressure = pressure;
        this.points = points;
        this.meta_state = meta_state;
        this.event_time = event_time;
        this.objectID = objectID;
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
    }

    public StrokeInfo(int type, int color, int alpha, float width, float[] pressure, android.graphics.PointF[] points, int meta_state, long[] event_time) {
        this.type = type;
        this.color = 16777215 & color;
        this.alpha = alpha;
        this.width = width;
        this.pressure = pressure;
        this.points = points;
        this.meta_state = meta_state;
        this.event_time = event_time;
        this.objectID = -1;
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
    }

    public StrokeInfo(int layerID, int type, int color, int alpha, float width, float[] pressure, android.graphics.PointF[] points, int meta_state, long[] event_time) {
        this.type = type;
        this.color = 16777215 & color;
        this.alpha = alpha;
        this.width = width;
        this.pressure = pressure;
        this.points = points;
        this.meta_state = meta_state;
        this.event_time = event_time;
        this.objectID = -1;
        if (layerID == 0) {
            setLayerID(0);
        } else if (layerID == 3) {
            setLayerID(1);
        } else if (layerID != 0 && layerID != 1) {
            setLayerID(1);
        } else {
            setLayerID(layerID);
        }
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
    }

    public void set(int type, int color, int alpha, float width, float[] pressure, android.graphics.PointF[] points, int meta_state, long[] event_time, int objectID) {
        this.type = type;
        this.alpha = alpha;
        this.width = width;
        this.meta_state = meta_state;
        this.color = 16777215 & color;
        this.pressure = pressure;
        this.points = points;
        this.event_time = event_time;
        this.objectID = objectID;
        setID(objectID);
    }
}
