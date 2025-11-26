package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class SpenColorGradationView extends ImageView {
    private Paint mBorderPaint;
    private onColorChangedListener mColorPickerColorChangeListener;
    private BitmapDrawable mCursorDrawable;
    private Rect mCursorRect;
    private String mCustom_imagepath;
    private BitmapDrawable mDrColorShadow;
    SPenImageUtil mDrawimage;
    private int mHeight;
    private Bitmap mSpectrum;
    private BitmapDrawable mSpectrumDrawable;
    private int mWidth;

    interface onColorChangedListener {
        void onColorChanged(int i, int i2, int i3);
    }

    public SpenColorGradationView(Context paramContext, String custom_imagepath, float ratio) {
        super(paramContext);
        this.mCustom_imagepath = "";
        this.mCustom_imagepath = custom_imagepath;
        this.mDrawimage = new SPenImageUtil(paramContext, this.mCustom_imagepath, ratio);
        initView();
    }

    public void close() {
        if (this.mSpectrum != null) {
            this.mSpectrum.recycle();
            this.mSpectrum = null;
        }
        this.mSpectrumDrawable = null;
        if (this.mDrColorShadow != null) {
            if (this.mDrColorShadow.getBitmap() != null) {
                this.mDrColorShadow.getBitmap().recycle();
            }
            this.mDrColorShadow = null;
        }
        if (this.mSpectrumDrawable != null) {
            if (this.mSpectrumDrawable.getBitmap() != null) {
                this.mSpectrumDrawable.getBitmap().recycle();
            }
            this.mSpectrumDrawable = null;
        }
        if (this.mCursorDrawable != null) {
            if (this.mCursorDrawable.getBitmap() != null) {
                this.mCursorDrawable.getBitmap().recycle();
            }
            this.mCursorDrawable = null;
        }
        this.mColorPickerColorChangeListener = null;
        this.mCursorDrawable = null;
        this.mCursorRect = null;
        this.mBorderPaint = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i = event.getAction();
        if (i == 2 && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int color = -1;
        int mCurX = (int) event.getX();
        int mCurY = (int) event.getY();
        if (mCurX < 0) {
            mCurX = 0;
        }
        if (mCurY < 0) {
            mCurY = 0;
        }
        if (this.mSpectrum != null) {
            if (this.mSpectrum.getWidth() <= mCurX) {
                mCurX = this.mSpectrum.getWidth() - 1;
            }
            if (this.mSpectrum.getHeight() <= mCurY) {
                mCurY = this.mSpectrum.getHeight() - 1;
            }
            color = this.mSpectrum.getPixel(mCurX, mCurY);
        }
        this.mCursorRect.set(mCurX - (this.mWidth / 2), mCurY - (this.mHeight / 2), (this.mWidth / 2) + mCurX, (this.mHeight / 2) + mCurY);
        this.mCursorDrawable.setBounds(this.mCursorRect);
        if (this.mColorPickerColorChangeListener != null) {
            if ((color & 16777215) == 16777215) {
                color = 16711422;
            }
            this.mColorPickerColorChangeListener.onColorChanged((-33554432) | (16777215 & color), mCurX, mCurY);
        }
        invalidate();
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mCursorDrawable.draw(canvas);
        canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getWidth(), getHeight(), this.mBorderPaint);
        if (this.mDrColorShadow != null) {
            this.mDrColorShadow.draw(canvas);
        }
    }

    public void setColorPickerColorChangeListener(onColorChangedListener parama) {
        this.mColorPickerColorChangeListener = parama;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            if (this.mSpectrum != null) {
                this.mSpectrum.recycle();
                this.mSpectrum = null;
            }
            this.mSpectrumDrawable = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_color_box", 192, 47);
            this.mSpectrum = this.mSpectrumDrawable.getBitmap();
            setImageBitmap(this.mSpectrum);
        }
    }

    public void selectColorForGradiation(int color, double deltaColor) {
        this.mSpectrumDrawable = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_color_box", 192, 47);
        this.mSpectrum = this.mSpectrumDrawable.getBitmap();
        setImageBitmap(this.mSpectrum);
        for (int mCurX = 0; mCurX < this.mSpectrum.getWidth(); mCurX++) {
            for (int mCurY = 0; mCurY < this.mSpectrum.getHeight(); mCurY++) {
                int color2 = this.mSpectrum.getPixel(mCurX, mCurY);
                if (equalsColor(color, color2, deltaColor)) {
                    this.mCursorRect.set(mCurX - (this.mWidth / 2), mCurY - (this.mHeight / 2), (this.mWidth / 2) + mCurX, (this.mHeight / 2) + mCurY);
                    this.mCursorDrawable.setBounds(this.mCursorRect);
                    invalidate();
                    return;
                }
            }
        }
    }

    private static boolean equalsColor(int color, int color2, double deltaColor) {
        int r1 = (color & 16711680) / 65536;
        int g1 = (color & 65280) / 256;
        int b1 = color & 255;
        int r2 = (color2 & 16711680) / 65536;
        int g2 = (color2 & 65280) / 256;
        int b2 = color2 & 255;
        return ((double) Math.abs(r1 - r2)) < deltaColor && ((double) Math.abs(g1 - g2)) < deltaColor && ((double) Math.abs(b1 - b2)) < deltaColor;
    }

    private void initView() {
        this.mCursorDrawable = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_color_select_kit", 10, 11);
        this.mWidth = this.mCursorDrawable.getIntrinsicWidth();
        this.mHeight = this.mCursorDrawable.getIntrinsicHeight();
        this.mCursorRect = new Rect(0, 0, this.mWidth, this.mHeight);
        this.mCursorDrawable.setBounds(this.mCursorRect);
        if (this.mDrawimage.setDrawableImg("snote_color_box_shadow", 192, 47) != null) {
            this.mDrColorShadow = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_color_box_shadow", 192, 47);
            Rect mGradationRect = new Rect(0, 0, this.mDrColorShadow.getIntrinsicWidth(), this.mDrColorShadow.getIntrinsicHeight());
            this.mDrColorShadow.setBounds(mGradationRect);
        }
        this.mBorderPaint = new Paint(1);
        this.mBorderPaint.setColor(-7566196);
        this.mBorderPaint.setStrokeWidth(2.0f);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }
}
