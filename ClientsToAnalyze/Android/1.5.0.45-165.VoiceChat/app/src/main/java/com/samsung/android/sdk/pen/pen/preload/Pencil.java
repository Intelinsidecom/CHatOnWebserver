package com.samsung.android.sdk.pen.pen.preload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import com.samsung.android.sdk.pen.util.SpenError;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Pencil implements SpenPenInterface {
    private Bitmap mBitmap;
    public final int nativePencil = native_init();

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList);

    private static native boolean native_construct(int i);

    private static native boolean native_draw(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native boolean native_end(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native void native_finalize(int i);

    private static native String native_getAdvancedSetting(int i);

    private static native int native_getColor(int i);

    private static native float native_getMaxSettingValue(int i);

    private static native float native_getMinSettingValue(int i);

    private static native boolean native_getPenAttribute(int i, int i2);

    private static native boolean native_getProperty(int i, Bundle bundle);

    private static native float native_getSize(int i);

    private static native RectF native_getStrokeRect(int i, PointF[] pointFArr, float[] fArr, int[] iArr, float f, boolean z, String str);

    private static native int native_init();

    private static native boolean native_isCurveEnabled(int i);

    private static native boolean native_move(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native void native_onLoad(int i);

    private static native void native_onUnload(int i);

    private static native boolean native_redraw(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native boolean native_setAdvancedSetting(int i, String str);

    private static native boolean native_setBitmap(int i, Bitmap bitmap);

    private static native boolean native_setColor(int i, int i2);

    private static native boolean native_setCurveEnabled(int i, boolean z);

    private static native boolean native_setProperty(int i, Bundle bundle);

    private static native boolean native_setReferenceBitmap(int i, Bitmap bitmap);

    private static native boolean native_setSize(int i, float f);

    private static native boolean native_start(int i, MotionEvent motionEvent, RectF rectF, int i2);

    public void construct() {
        native_construct(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) {
        native_onLoad(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public String getPrivateKeyHint() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(String key) {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
        this.mBitmap = null;
        native_onUnload(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(Bundle propertyMap) {
        native_setProperty(this.nativePencil, propertyMap);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(Bundle propertyMap) {
        native_getProperty(this.nativePencil, propertyMap);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return this.nativePencil;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void draw(MotionEvent event, RectF rect) {
        if (this.mBitmap != null) {
            if (this.mBitmap.isRecycled()) {
                this.mBitmap = null;
                return;
            }
            this.mBitmap.setPixel(0, 0, 0);
            if (!native_draw(this.nativePencil, event, rect, event.getToolType(0))) {
                SpenError.ThrowUncheckedException(SpenError.getError(), toString());
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void redrawPen(MotionEvent allEvent, RectF rect) {
        if (this.mBitmap != null) {
            if (this.mBitmap.isRecycled()) {
                this.mBitmap = null;
                return;
            }
            this.mBitmap.setPixel(0, 0, 0);
            if (!native_redraw(this.nativePencil, allEvent, rect, allEvent.getToolType(0))) {
                SpenError.ThrowUncheckedException(SpenError.getError(), toString());
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (this.mBitmap != null && !native_setBitmap(this.nativePencil, this.mBitmap)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setReferenceBitmap(Bitmap bitmap) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setSize(float size) {
        if (!native_setSize(this.nativePencil, size)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getSize() {
        return native_getSize(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMinSettingValue() {
        return native_getMinSettingValue(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMaxSettingValue() {
        return native_getMaxSettingValue(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setColor(int color) {
        if (!native_setColor(this.nativePencil, color)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public int getColor() {
        return native_getColor(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setCurveEnabled(boolean curve) {
        if (!native_setCurveEnabled(this.nativePencil, curve)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean isCurveEnabled() {
        return native_isCurveEnabled(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setAdvancedSetting(String advancedSetting) {
        if (!native_setAdvancedSetting(this.nativePencil, advancedSetting)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public String getAdvancedSetting() {
        return native_getAdvancedSetting(this.nativePencil);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void showAdvancedSetting(Context context, SpenPenInterface.ChangeListener listener, ViewGroup viewGroup) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void hideAdvancedSetting() {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public RectF getStrokeRect(PointF[] points, float[] pressures, int[] timestamps, float size, boolean isCurvable, String advanced) {
        return native_getStrokeRect(this.nativePencil, points, pressures, timestamps, size, isCurvable, advanced);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean getPenAttribute(int attribute) {
        return native_getPenAttribute(this.nativePencil, attribute);
    }
}
