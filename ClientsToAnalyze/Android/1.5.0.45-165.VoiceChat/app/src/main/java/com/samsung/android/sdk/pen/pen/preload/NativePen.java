package com.samsung.android.sdk.pen.pen.preload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NativePen implements SpenPenInterface {
    public final int nativeNativePen = native_init();

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList);

    private static native boolean native_construct(int i);

    private static native void native_finalize(int i);

    private static native int native_init();

    private static native void native_setobject(int i, Object obj);

    public void construct() {
        native_construct(this.nativeNativePen);
    }

    public void setObject(Object object) {
        native_setobject(this.nativeNativePen, object);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return this.nativeNativePen;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(Bundle arg0) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(Bundle arg0) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public String getPrivateKeyHint() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(String key) {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void draw(MotionEvent event, RectF rect) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void redrawPen(MotionEvent allEvent, RectF rect) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public Bitmap getBitmap() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setBitmap(Bitmap bitmap) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setReferenceBitmap(Bitmap bitmap) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setSize(float size) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getSize() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMinSettingValue() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMaxSettingValue() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setColor(int color) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public int getColor() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setCurveEnabled(boolean curve) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean isCurveEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setAdvancedSetting(String advancedSetting) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public String getAdvancedSetting() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void showAdvancedSetting(Context context, SpenPenInterface.ChangeListener listener, ViewGroup viewGroup) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void hideAdvancedSetting() {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public RectF getStrokeRect(PointF[] points, float[] pressures, int[] timestamps, float size, boolean isCurvable, String advanced) {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean getPenAttribute(int attribute) {
        return false;
    }
}
