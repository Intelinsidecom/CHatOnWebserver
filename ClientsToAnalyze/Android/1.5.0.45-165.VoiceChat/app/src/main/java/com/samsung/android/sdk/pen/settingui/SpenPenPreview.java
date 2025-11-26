package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;

/* loaded from: classes.dex */
class SpenPenPreview extends View {
    private String mAdvancedSetting;
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private int mCanvasWidth;
    private int mColor;
    private Context mContext;
    private float mMax;
    private float mMin;
    private ArrayList<SpenPenPluginInfo> mPenPluginInfoList;
    private SpenPenPluginManager mPenPluginManager;
    private String mPenType;
    private float[] mPoints;
    private float[] mPressures;
    private RectF mRect;
    private float mStrokeWidth;
    private int mbottom;
    private int mleft;
    private int mright;
    private int mtop;
    private static int NUM_POINTS = 10;
    private static int CANVAS_WIDTH_VEINNA = 1600;

    public SpenPenPreview(Context context) {
        super(context);
        this.mStrokeWidth = 20.0f;
        this.mColor = -16777216;
        this.mCanvasWidth = 1080;
        this.mleft = 0;
        this.mright = 0;
        this.mtop = 0;
        this.mbottom = 0;
        this.mMin = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mMax = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mContext = context;
        this.mPoints = new float[NUM_POINTS * 2];
        this.mPressures = new float[NUM_POINTS];
        this.mRect = new RectF();
        this.mBitmapPaint = new Paint(4);
        DisplayMetrics localDisplayMetrics = context.getResources().getDisplayMetrics();
        if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {
            this.mCanvasWidth = localDisplayMetrics.widthPixels;
        } else {
            this.mCanvasWidth = localDisplayMetrics.heightPixels;
        }
    }

    public void close() {
        this.mContext = null;
        this.mPoints = null;
        this.mPressures = null;
        this.mPenType = null;
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mPenPluginInfoList != null) {
            this.mPenPluginInfoList.clear();
            this.mPenPluginInfoList = null;
        }
        this.mRect = null;
        this.mBitmapPaint = null;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            int width = right - left;
            int height = bottom - top;
            float widthUnit = width / 16.0f;
            float heighUnit = height / 16.0f;
            this.mleft = left;
            this.mtop = top;
            this.mright = right;
            this.mbottom = bottom;
            this.mPoints[0] = left + (1.0f * widthUnit);
            this.mPoints[1] = top + (14.0f * heighUnit);
            this.mPoints[(NUM_POINTS * 2) - 2] = left + (16.0f * widthUnit);
            this.mPoints[(NUM_POINTS * 2) - 1] = top + (14.0f * heighUnit);
            float dp = (this.mPoints[(NUM_POINTS * 2) - 2] - this.mPoints[0]) / (NUM_POINTS - 1);
            for (int i = 2; i < (NUM_POINTS * 2) - 2; i += 2) {
                this.mPoints[i] = this.mPoints[i - 2] + dp;
                this.mPoints[i + 1] = this.mPoints[1];
            }
            this.mPressures[0] = 0.7f;
            for (int i2 = 1; i2 < NUM_POINTS; i2++) {
                this.mPressures[i2] = this.mPressures[i2 - 1] - 0.025f;
            }
        }
    }

    private void checkResolution() {
        int width = this.mright - this.mleft;
        int height = this.mbottom - this.mtop;
        float widthUnit = width / 16.0f;
        float heighUnit = height / 16.0f;
        this.mPoints[0] = this.mleft + (1.0f * widthUnit);
        if (this.mCanvasWidth == CANVAS_WIDTH_VEINNA && (this.mPenType.contains("Marker") || this.mPenType.contains(".Brush"))) {
            int penPluginIndex = this.mPenPluginManager.getPenPluginIndexByPenName(this.mPenType);
            float min = this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getMinSettingValue();
            this.mMax = ((10.0f + min) * this.mCanvasWidth) / 360.0f;
            this.mMin = (this.mCanvasWidth * min) / 360.0f;
            float delta = ((this.mStrokeWidth - this.mMin) * 10.0f) / (this.mMax - this.mMin);
            this.mPoints[1] = (this.mtop - delta) + (14.0f * heighUnit);
            this.mPoints[(NUM_POINTS * 2) - 1] = (this.mtop - delta) + (14.0f * heighUnit);
        } else {
            this.mPoints[1] = this.mtop + (14.0f * heighUnit);
            this.mPoints[(NUM_POINTS * 2) - 1] = this.mtop + (14.0f * heighUnit);
        }
        this.mPoints[(NUM_POINTS * 2) - 2] = this.mleft + (16.0f * widthUnit);
        float dp = (this.mPoints[(NUM_POINTS * 2) - 2] - this.mPoints[0]) / (NUM_POINTS - 1);
        for (int i = 2; i < (NUM_POINTS * 2) - 2; i += 2) {
            this.mPoints[i] = this.mPoints[i - 2] + dp;
            this.mPoints[i + 1] = this.mPoints[1];
        }
        this.mPressures[0] = 0.7f;
        for (int i2 = 1; i2 < NUM_POINTS; i2++) {
            this.mPressures[i2] = this.mPressures[i2 - 1] - 0.025f;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
        }
        this.mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int penPluginIndex = this.mPenPluginManager.getPenPluginIndexByPenName(this.mPenType);
        if (penPluginIndex != -1) {
            if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() == null) {
                this.mPenPluginManager.loadPenPlugin(this.mContext, this.mPenType);
                if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() == null) {
                    return;
                }
            }
            this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setBitmap(this.mBitmap);
            if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(4)) {
                this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setAdvancedSetting(this.mAdvancedSetting);
            }
            this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setSize(this.mStrokeWidth);
            this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(this.mColor);
            this.mBitmap.eraseColor(0);
            checkResolution();
            long time = 0;
            float startShift = (this.mStrokeWidth / 2.0f) * this.mPressures[0];
            float endShift = (this.mStrokeWidth / 2.0f) * this.mPressures[NUM_POINTS - 1];
            if (this.mPenType.contains("Marker")) {
                startShift = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                endShift = this.mStrokeWidth / 2.0f;
                if (this.mPoints[(NUM_POINTS * 2) - 2] - endShift < this.mPoints[(NUM_POINTS * 2) - 4]) {
                    this.mPoints[(NUM_POINTS * 2) - 4] = (this.mPoints[(NUM_POINTS * 2) - 2] - endShift) - 1.0f;
                }
            }
            if (this.mPenType.contains(".Brush")) {
                endShift = (this.mStrokeWidth / 2.0f) * this.mPressures[0];
            }
            for (int i = 0; i < NUM_POINTS; i++) {
                if (i == 0) {
                    time = System.currentTimeMillis();
                    MotionEvent event = MotionEvent.obtain(time, time, 0, this.mPoints[i * 2] + startShift, this.mPoints[(i * 2) + 1], this.mPressures[i], this.mStrokeWidth, 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                    this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().draw(event, this.mRect);
                    event.recycle();
                } else if (i == NUM_POINTS - 1) {
                    long currentTime = time + ((NUM_POINTS - i) * 5);
                    MotionEvent event2 = MotionEvent.obtain(time, currentTime, 1, this.mPoints[i * 2] - endShift, this.mPoints[(i * 2) + 1], this.mPressures[i], this.mStrokeWidth, 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                    this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().draw(event2, this.mRect);
                    event2.recycle();
                } else {
                    long currentTime2 = time + ((NUM_POINTS - i) * 5);
                    MotionEvent event3 = MotionEvent.obtain(time, currentTime2, 2, this.mPoints[i * 2], this.mPoints[(i * 2) + 1], this.mPressures[i], this.mStrokeWidth, 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                    this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().draw(event3, this.mRect);
                    event3.recycle();
                }
            }
            this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setBitmap(null);
            canvas.drawBitmap(this.mBitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mBitmapPaint);
        }
    }

    public void setStrokeSize(float width) {
        this.mStrokeWidth = width;
    }

    public void setStrokeAlpha(int alpha) {
        this.mColor = (alpha << 24) | (this.mColor & 16777215);
    }

    public void setStrokeColor(int color) {
        this.mColor = color;
    }

    public void setPenType(String penType) {
        this.mPenType = penType;
    }

    public void setStrokeAdvancedSetting(String adnvance) {
        this.mAdvancedSetting = adnvance;
    }

    public void setPenPlugin(SpenPenPluginManager penPluginManager) {
        this.mPenPluginManager = penPluginManager;
        this.mPenPluginInfoList = this.mPenPluginManager.getPenPluginInfoList();
    }
}
