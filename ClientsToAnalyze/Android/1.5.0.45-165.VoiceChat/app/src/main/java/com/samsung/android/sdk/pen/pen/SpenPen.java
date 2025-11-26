package com.samsung.android.sdk.pen.pen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;

/* loaded from: classes.dex */
public class SpenPen {
    public static final int PEN_ATTRIBUTE_ADVANCED_SETTING = 4;
    public static final int PEN_ATTRIBUTE_ALPHA = 1;
    public static final int PEN_ATTRIBUTE_COLOR = 2;
    public static final int PEN_ATTRIBUTE_CURVE = 3;
    public static final int PEN_ATTRIBUTE_SIZE = 0;
    private Context mContext;
    private ChangedListener mListener = null;
    private SpenPenInterface mPenObject;

    public interface ChangedListener {
        void onChanged(String str);
    }

    SpenPen(Context context, SpenPenInterface penObject) {
        this.mPenObject = null;
        this.mContext = null;
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        if (penObject == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'penObject' is null");
        }
        this.mContext = context;
        this.mPenObject = penObject;
    }

    SpenPenInterface getPenObject() {
        return this.mPenObject;
    }

    void close() {
        this.mContext = null;
        this.mPenObject = null;
    }

    public void draw(MotionEvent event, RectF rect) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.draw(event, rect);
    }

    public void redrawPen(MotionEvent event, RectF rect) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.redrawPen(event, rect);
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.setBitmap(bitmap);
    }

    public Bitmap getBitmap() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getBitmap();
    }

    public void setReferenceBitmap(Bitmap bitmap) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.setReferenceBitmap(bitmap);
    }

    public void setSize(float size) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.setSize(size);
    }

    public float getSize() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getSize();
    }

    public float getMinSettingValue() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getMinSettingValue();
    }

    public float getMaxSettingValue() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getMaxSettingValue();
    }

    public void setColor(int color) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.setColor(color);
    }

    public int getColor() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getColor();
    }

    public void setCurveEnabled(boolean enable) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.setCurveEnabled(enable);
    }

    public boolean isCurveEnabled() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.isCurveEnabled();
    }

    public void setAdvancedSetting(String advancedSetting) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mPenObject.setAdvancedSetting(advancedSetting);
    }

    public String getAdvancedSetting() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getAdvancedSetting();
    }

    public void showAdvancedSetting(ChangedListener listener, ViewGroup viewGroup) {
        if (listener == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'listener' is null");
        }
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : Recognition is not loaded");
        }
        this.mListener = listener;
        this.mPenObject.showAdvancedSetting(this.mContext, new SpenPenInterface.ChangeListener() { // from class: com.samsung.android.sdk.pen.pen.SpenPen.1
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface.ChangeListener
            public void onChanged(String advancedStyle) {
                SpenPen.this.mListener.onChanged(advancedStyle);
            }
        }, viewGroup);
    }

    public void hideAdvancedSetting() {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : Recognition is not loaded");
        }
        this.mPenObject.hideAdvancedSetting();
    }

    public boolean getPenAttribute(int attribute) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getPenAttribute(attribute);
    }

    public RectF getStrokeRect(SpenObjectStroke stroke) {
        if (this.mPenObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        return this.mPenObject.getStrokeRect(stroke.getPoints(), stroke.getPressures(), stroke.getTimeStamps(), stroke.getPenSize(), stroke.isCurveEnabled(), stroke.getAdvancedPenSetting());
    }
}
