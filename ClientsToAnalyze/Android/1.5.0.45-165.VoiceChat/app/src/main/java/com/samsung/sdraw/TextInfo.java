package com.samsung.sdraw;

import android.graphics.RectF;
import android.text.Layout;

/* loaded from: classes.dex */
public class TextInfo extends ObjectInfo {
    public Layout.Alignment alignment;
    public int color;
    public int objectID;
    public RectF rectf;
    public int size;
    public String text;
    public String textFont;
    public int textStyle;

    public TextInfo(int color, int size, String text, RectF rectf, int objectID) {
        this.color = color;
        this.size = size;
        this.text = text;
        this.rectf = rectf;
        this.objectID = objectID;
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.textStyle = 0;
        this.textFont = m1176a();
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
    }

    public TextInfo(int color, int size, String text, RectF rectf) {
        this.color = color;
        this.size = size;
        this.text = text;
        this.rectf = rectf;
        this.objectID = -1;
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.textStyle = 0;
        this.textFont = m1176a();
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(-1);
    }

    public TextInfo(int color, int size, String text, RectF rectf, int textStyle, Layout.Alignment alignment) {
        this.color = color;
        this.size = size;
        this.text = text;
        this.rectf = rectf;
        this.objectID = -1;
        this.alignment = alignment;
        this.textStyle = textStyle;
        this.textFont = m1176a();
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
    }

    public TextInfo(int color, int size, String text, RectF rectf, int textStyle, Layout.Alignment alignment, String textFont) {
        this.color = color;
        this.size = size;
        this.text = text;
        this.rectf = rectf;
        this.objectID = -1;
        this.alignment = alignment;
        this.textStyle = textStyle;
        this.textFont = textFont;
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(this.objectID);
    }

    public TextInfo(int color, int size, String text, RectF rectf, int textStyle, Layout.Alignment alignment, String textFont, int layerID) {
        this.color = color;
        this.size = size;
        this.text = text;
        this.rectf = rectf;
        this.objectID = -1;
        this.alignment = alignment;
        this.textStyle = textStyle;
        this.textFont = textFont;
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
    }

    public void set(int color, int size, String text, RectF rectf, int objectID) {
        this.color = color;
        this.size = size;
        this.text = text;
        this.rectf = rectf;
        this.objectID = objectID;
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.textStyle = 0;
        this.textFont = m1176a();
        setLayerID(1);
        setMultiObjectID(0);
        setMultiUserID(0);
        setID(objectID);
    }

    /* renamed from: a */
    private String m1176a() {
        return "Sans serif";
    }
}
