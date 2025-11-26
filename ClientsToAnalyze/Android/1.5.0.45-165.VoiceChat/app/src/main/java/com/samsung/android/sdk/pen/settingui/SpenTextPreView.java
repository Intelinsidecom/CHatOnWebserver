package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import com.samsung.android.sdk.pen.util.SpenFont;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;

/* loaded from: classes.dex */
class SpenTextPreView extends View {
    protected static final int TEXT_PREVIEW_WIDTH = 222;
    private int CANVAS_WIDTH_VEINNA;
    private boolean isCheckUnderLine;
    private int mBold;
    private int mColor;
    private float mOnePoint;
    private final Paint mPaint;
    private float mPreviewOffset;
    private final Rect mTextRect;
    private float mTextSize;
    private float mTextSkewValue;
    private Typeface mTypeFace;
    private float mWidth;
    private float maxFontSize;

    public SpenTextPreView(Context context) {
        super(context);
        this.mColor = -16777216;
        this.mTextSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mBold = 0;
        this.mTextSkewValue = -0.0f;
        this.isCheckUnderLine = false;
        this.mTypeFace = Typeface.SERIF;
        this.mPaint = new Paint();
        this.mTextRect = new Rect();
        this.mOnePoint = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.maxFontSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mPreviewOffset = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mWidth = 1080.0f;
        this.CANVAS_WIDTH_VEINNA = 1600;
    }

    public SpenTextPreView(Context mContext, int mCanvasWidth) {
        super(mContext);
        this.mColor = -16777216;
        this.mTextSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mBold = 0;
        this.mTextSkewValue = -0.0f;
        this.isCheckUnderLine = false;
        this.mTypeFace = Typeface.SERIF;
        this.mPaint = new Paint();
        this.mTextRect = new Rect();
        this.mOnePoint = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.maxFontSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mPreviewOffset = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mWidth = 1080.0f;
        this.CANVAS_WIDTH_VEINNA = 1600;
        DisplayMetrics localDisplayMetrics = mContext.getResources().getDisplayMetrics();
        this.mOnePoint = localDisplayMetrics.density;
        ArrayList<String> mFontList = (ArrayList) SpenFont.getFontList();
        String maxFontName = "";
        float maxLength = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        float fontPointPixel = (float) (mCanvasWidth / 360.0d);
        ArrayList<Integer> fontSizeList = getFontSizeList();
        for (int i = 0; i < mFontList.size(); i++) {
            this.mPaint.setTextSize(30.0f);
            this.mPaint.setTypeface(SpenFont.getTypeFace(i));
            this.mPaint.getTextBounds("ABC abc", 0, "ABC abc".length(), this.mTextRect);
            this.mPaint.setAntiAlias(true);
            if (this.mTextRect.width() > maxLength) {
                maxLength = this.mTextRect.width();
                String maxFontName2 = mFontList.get(i);
                maxFontName = maxFontName2;
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= fontSizeList.size()) {
                break;
            }
            this.mPaint.setTextSize(fontSizeList.get(i2).intValue() * fontPointPixel);
            this.mPaint.setTypeface(SpenFont.getTypeFace(maxFontName));
            this.mPaint.getTextBounds("ABC abc", 0, "ABC abc".length(), this.mTextRect);
            this.mPaint.setAntiAlias(true);
            if (this.mTextRect.width() < 212.0f * this.mOnePoint) {
                i2++;
            } else {
                this.maxFontSize = fontSizeList.get(i2).intValue() * fontPointPixel;
                break;
            }
        }
        if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {
            this.mWidth = localDisplayMetrics.widthPixels;
        } else {
            this.mWidth = localDisplayMetrics.heightPixels;
        }
    }

    protected ArrayList<Integer> getFontSizeList() {
        ArrayList<Integer> fontList = new ArrayList<>();
        for (int txtSize = 8; txtSize < 21; txtSize++) {
            fontList.add(Integer.valueOf(txtSize));
        }
        for (int txtSize2 = 22; txtSize2 < 33; txtSize2 += 2) {
            fontList.add(Integer.valueOf(txtSize2));
        }
        for (int txtSize3 = 36; txtSize3 < 65; txtSize3 += 4) {
            fontList.add(Integer.valueOf(txtSize3));
        }
        return fontList;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = "ABC abc";
        this.mPaint.setColor(this.mColor);
        this.mPaint.setTextAlign(Paint.Align.LEFT);
        this.mPaint.setTextSize(this.mTextSize);
        this.mPaint.setTypeface(this.mTypeFace);
        this.mPaint.setFlags(this.mBold);
        this.mPaint.setTextSkewX(this.mTextSkewValue);
        this.mPaint.setUnderlineText(this.isCheckUnderLine);
        this.mPaint.getTextBounds("ABC abc", 0, "ABC abc".length(), this.mTextRect);
        if (this.mTextSize >= this.maxFontSize) {
            str = "AB ab";
            this.mPaint.getTextBounds("AB ab", 0, "AB ab".length(), this.mTextRect);
        }
        if (this.mTextSize >= 195.0f && this.mWidth == this.CANVAS_WIDTH_VEINNA) {
            str = "Aa";
            this.mPaint.getTextBounds("Aa", 0, "Aa".length(), this.mTextRect);
            if (this.isCheckUnderLine) {
                this.mPreviewOffset = 10.0f;
            } else {
                this.mPreviewOffset = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
        }
        this.mPaint.setAntiAlias(true);
        canvas.drawText(str, (getWidth() / 2) - (this.mTextRect.width() / 2), ((getHeight() / 2) + (this.mTextRect.height() / 2)) - this.mPreviewOffset, this.mPaint);
    }

    public int getPreviewTextColor() {
        return this.mColor;
    }

    public void setPreviewTextColor(int color) {
        this.mColor = color;
    }

    public void setPreviewUnderLine(boolean enable) {
        this.isCheckUnderLine = enable;
    }

    public void setPreviewTextSize(float textSize) {
        this.mTextSize = textSize;
    }

    public void setPreviewTextSkewX(boolean enable) {
        if (enable) {
            this.mTextSkewValue = -0.3f;
        } else {
            this.mTextSkewValue = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
    }

    public void setPreviewBold(boolean enable) {
        if (enable) {
            this.mBold = 32;
        } else {
            this.mBold = 0;
        }
    }

    public void setPreviewTypeface(Typeface typeface) {
        this.mTypeFace = typeface;
    }

    public char getTextStyle() {
        char nTextStyle = 0;
        if ((this.mBold & 32) != 0) {
            nTextStyle = (char) 1;
        }
        if (this.mTextSkewValue != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            nTextStyle = (char) (nTextStyle | 2);
        }
        if (this.isCheckUnderLine) {
            return (char) (nTextStyle | 4);
        }
        return nTextStyle;
    }
}
