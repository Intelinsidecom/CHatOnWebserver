package com.samsung.android.sdk.pen.plugin.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public interface SpenPenInterface extends SpenPluginInterface {
    public static final int PEN_ATTRIBUTE_ADVANCED_SETTING = 4;
    public static final int PEN_ATTRIBUTE_ALPHA = 1;
    public static final int PEN_ATTRIBUTE_COLOR = 2;
    public static final int PEN_ATTRIBUTE_CURVE = 3;
    public static final int PEN_ATTRIBUTE_SIZE = 0;

    public interface ChangeListener {
        void onChanged(String str);
    }

    void draw(MotionEvent motionEvent, RectF rectF);

    String getAdvancedSetting();

    Bitmap getBitmap();

    int getColor();

    float getMaxSettingValue();

    float getMinSettingValue();

    boolean getPenAttribute(int i);

    float getSize();

    RectF getStrokeRect(PointF[] pointFArr, float[] fArr, int[] iArr, float f, boolean z, String str);

    void hideAdvancedSetting();

    boolean isCurveEnabled();

    void redrawPen(MotionEvent motionEvent, RectF rectF);

    void setAdvancedSetting(String str);

    void setBitmap(Bitmap bitmap);

    void setColor(int i);

    void setCurveEnabled(boolean z);

    void setReferenceBitmap(Bitmap bitmap);

    void setSize(float f);

    void showAdvancedSetting(Context context, ChangeListener changeListener, ViewGroup viewGroup);
}
