package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.List;

/* loaded from: classes.dex */
class SpenToolTip {
    private Context mContext;
    private Paint mEraserPaint;
    private List<SpenPenInfo> mPenList;
    private SpenPenManager mPenManager;
    private Paint mPenPaint;
    private PointF[] mPoints;
    private float[] mPressures;
    private Resources mSdkResources;
    private Bitmap mPenBitmap = null;
    private Bitmap mEraserBitmap = null;
    private Bitmap mSpoidBitmap = null;

    SpenToolTip(Context context) {
        this.mSdkResources = null;
        this.mContext = context;
        try {
            PackageManager manager = this.mContext.getPackageManager();
            this.mSdkResources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.mPenManager = new SpenPenManager(context);
        this.mPoints = new PointF[3];
        this.mPressures = new float[3];
        this.mPenPaint = new Paint();
        this.mPenPaint.setAntiAlias(true);
        this.mEraserPaint = new Paint();
        this.mEraserPaint.setStyle(Paint.Style.STROKE);
        this.mEraserPaint.setStrokeWidth(4.0f);
        this.mEraserPaint.setColor(-16777216);
        this.mEraserPaint.setAlpha(255);
        this.mEraserPaint.setAntiAlias(true);
        this.mPoints[0] = new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 150.0f);
        this.mPoints[1] = new PointF(50.0f, 150.0f);
        this.mPoints[2] = new PointF(100.0f, 150.0f);
        this.mPressures[0] = 1.0f;
        this.mPressures[1] = 0.8f;
        this.mPressures[2] = 0.6f;
    }

    public void close() {
        if (this.mPenList != null) {
            this.mPenList.clear();
            this.mPenList = null;
        }
        if (this.mPenBitmap != null) {
            this.mPenBitmap.recycle();
            this.mPenBitmap = null;
        }
        if (this.mEraserBitmap != null) {
            this.mEraserBitmap.recycle();
            this.mEraserBitmap = null;
        }
        if (this.mSpoidBitmap != null) {
            this.mSpoidBitmap.recycle();
            this.mSpoidBitmap = null;
        }
        if (this.mPenManager != null) {
            this.mPenManager.close();
            this.mPenManager = null;
        }
        this.mContext = null;
        if (this.mSdkResources != null) {
            this.mSdkResources.flushLayoutCache();
            this.mSdkResources = null;
        }
        if (this.mPoints != null) {
            this.mPoints[0] = null;
            this.mPoints[1] = null;
            this.mPoints[2] = null;
            this.mPoints = null;
        }
        this.mPressures = null;
        this.mPenPaint = null;
        this.mEraserPaint = null;
    }

    public Drawable getDrawableImage(String name, int color, float size) {
        if (this.mPenList == null) {
            this.mPenList = this.mPenManager.getPenInfoList();
            if (this.mPenList == null) {
                return null;
            }
        }
        for (int pos = 0; pos < this.mPenList.size(); pos++) {
            SpenPenInfo info = this.mPenList.get(pos);
            if (name.compareTo(info.className) == 0) {
                BitmapDrawable drawable = (BitmapDrawable) setDrawableImg(info.iconImageUri);
                if (this.mPenBitmap == null) {
                    this.mPenBitmap = Bitmap.createBitmap(100, 300, Bitmap.Config.ARGB_8888);
                }
                Rect dst = new Rect();
                Canvas canvas = new Canvas(this.mPenBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                try {
                    SpenPen pen = this.mPenManager.createPen(info);
                    if (info.className.compareTo(SpenPenManager.SPEN_MAGIC_PEN) == 0) {
                        BitmapDrawable magic = (BitmapDrawable) setDrawableImg("snote_popup_pensetting_preview_alpha");
                        dst.set(0, ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO, 100, (int) (150.0f + size));
                        this.mPenPaint.setAlpha((color >> 24) & 255);
                        if (magic != null) {
                            canvas.drawBitmap(magic.getBitmap(), (Rect) null, dst, this.mPenPaint);
                        }
                        this.mPenPaint.setAlpha(255);
                        pen.setBitmap(this.mPenBitmap);
                    } else {
                        pen.setColor(color);
                        if (info.className.compareTo(SpenPenManager.SPEN_INK_PEN) == 0) {
                            size = (float) (size * 1.5d);
                        } else if (info.className.compareTo(SpenPenManager.SPEN_CHINESE_BRUSH) == 0) {
                            size = (float) (size * 1.2d);
                        }
                        pen.setSize(3.0f * size);
                        pen.setBitmap(this.mPenBitmap);
                        RectF rect = new RectF();
                        long time = System.currentTimeMillis();
                        MotionEvent event = MotionEvent.obtain(time, time, 0, this.mPoints[0].x, this.mPoints[0].y, this.mPressures[0], size, 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                        pen.draw(event, rect);
                        event.recycle();
                        long currentTime = time + 5;
                        MotionEvent event2 = MotionEvent.obtain(time, currentTime, 2, this.mPoints[1].x, this.mPoints[1].y, this.mPressures[1], size, 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                        pen.draw(event2, rect);
                        event2.recycle();
                        long currentTime2 = time + 10;
                        MotionEvent event3 = MotionEvent.obtain(time, currentTime2, 1, this.mPoints[2].x, this.mPoints[2].y, this.mPressures[2], size, 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                        pen.draw(event3, rect);
                        event3.recycle();
                    }
                    pen.setBitmap(null);
                    this.mPenManager.destroyPen(pen);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                dst.set(0, 0, 100, 250);
                if (drawable != null) {
                    canvas.drawBitmap(drawable.getBitmap(), (Rect) null, dst, this.mPenPaint);
                }
                return new BitmapDrawable(this.mSdkResources, this.mPenBitmap);
            }
        }
        return null;
    }

    public Drawable getDrawableEraserImage(float size) {
        if (this.mEraserBitmap == null) {
            this.mEraserBitmap = Bitmap.createBitmap(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.mEraserBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.drawCircle(102.0f, 102.0f, size, this.mEraserPaint);
        return new BitmapDrawable(this.mSdkResources, this.mEraserBitmap);
    }

    public Drawable getDrawableRemoverImage(int size) {
        if (this.mEraserBitmap == null) {
            this.mEraserBitmap = Bitmap.createBitmap(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.mEraserBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.drawCircle(102.0f, 102.0f, size, this.mEraserPaint);
        return new BitmapDrawable(this.mSdkResources, this.mEraserBitmap);
    }

    public Drawable getDrawableHoverImage() {
        Drawable drawable = setDrawableImg("snote_toolbar_icon_spoid_hover");
        if (drawable == null) {
            return null;
        }
        if (this.mSpoidBitmap == null) {
            this.mSpoidBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        }
        Bitmap iconBitmap = ((BitmapDrawable) drawable).getBitmap();
        if (iconBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(this.mSpoidBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Rect dstRect = new Rect();
        dstRect.set(43, 0, 100, 57);
        canvas.drawBitmap(iconBitmap, (Rect) null, dstRect, (Paint) null);
        return new BitmapDrawable(this.mSdkResources, this.mSpoidBitmap);
    }

    Drawable setDrawableImg(String drawableName) {
        int mDrawableResID = this.mSdkResources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
        if (mDrawableResID == 0) {
            return null;
        }
        return this.mSdkResources.getDrawable(mDrawableResID);
    }
}
