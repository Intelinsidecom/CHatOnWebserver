package com.samsung.android.sdk.pen.pen.preload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class RedPen implements SpenPenInterface {
    private Bitmap bitmap;
    private Canvas canvas;
    private final Paint mPaint = new Paint();
    private final Path mPath;

    /* renamed from: mX */
    private float f402mX;

    /* renamed from: mY */
    private float f403mY;

    public RedPen() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-16776961);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(4.0f);
        this.mPath = new Path();
        this.f402mX = -1.0f;
        this.f403mY = -1.0f;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return 0;
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
        if (this.bitmap != null) {
            if (this.bitmap.isRecycled()) {
                this.bitmap = null;
            }
            this.bitmap.setPixel(0, 0, 0);
            switch (event.getAction()) {
                case 0:
                    Log.v("SAMSUNG", "SAMSUNG ggg = x = " + event.getX() + "y = " + event.getY() + "pressure = " + event.getPressure());
                    Log.v("SAMSUNG", "SAMSUNG JAVA MotionEvent size = " + event.getX());
                    this.mPath.reset();
                    this.mPath.moveTo(event.getX(), event.getY());
                    this.f402mX = event.getX();
                    this.f403mY = event.getY();
                    this.mPath.computeBounds(rect, false);
                    break;
                case 1:
                    this.mPath.lineTo(this.f402mX, this.f403mY);
                    this.canvas.drawPath(this.mPath, this.mPaint);
                    this.mPath.computeBounds(rect, false);
                    break;
                case 2:
                    this.mPath.quadTo(this.f402mX, this.f403mY, (event.getX() + this.f402mX) / 2.0f, (event.getY() + this.f403mY) / 2.0f);
                    this.canvas.drawPath(this.mPath, this.mPaint);
                    this.f402mX = event.getX();
                    this.f403mY = event.getY();
                    this.mPath.computeBounds(rect, false);
                    break;
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        if (bitmap != null) {
            this.canvas = new Canvas(this.bitmap);
            Log.v("SAMSUNG", "SAMSUNG JAVA SetBitmap width =" + bitmap.getWidth() + "height = " + bitmap.getHeight());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setSize(float size) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getSize() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setColor(int color) {
        Log.v("SAMSUNG", "SAMSUNG JAVA SetColor" + color);
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
    public RectF getStrokeRect(PointF[] points, float[] pressures, int[] timestamps, float size, boolean isCurvable, String advanced) {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean getPenAttribute(int attribute) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void hideAdvancedSetting() {
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
    public void redrawPen(MotionEvent allEvent, RectF rect) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setReferenceBitmap(Bitmap bitmap) {
    }
}
