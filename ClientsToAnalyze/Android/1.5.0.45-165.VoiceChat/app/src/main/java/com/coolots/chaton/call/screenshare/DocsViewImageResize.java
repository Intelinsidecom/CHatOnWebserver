package com.coolots.chaton.call.screenshare;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class DocsViewImageResize implements DisposeInterface {
    private static final String CLASSNAME = "[DocsViewImageResize] ";
    private static final int DOCS_VIEW_HEIGHT = 1845;
    private static final int DOCS_VIEW_WIDTH = 1080;
    private Bitmap mBackground;
    private Canvas mBackgroundCanvas;
    private int mLeftMargin;
    private Bitmap mResize;
    private Bitmap mResult;
    private Bitmap mTarget;
    private int mTargetHeight;
    private int mTargetWidth;
    private int mTopMargin;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public DocsViewImageResize(String filePath) {
        initialize();
        onCreateBackGroundBitmap();
        onCreateTargetBitmap(filePath);
        this.mResult = getResutBitmap();
    }

    public void setResultBitmap(Bitmap result) {
        this.mResult = result;
    }

    public Bitmap getResutBitmap() {
        return this.mResult;
    }

    private void initialize() {
        this.mResult = null;
        this.mBackground = null;
        this.mBackgroundCanvas = null;
        this.mTarget = null;
        this.mResize = null;
        this.mTargetWidth = 0;
        this.mTargetHeight = 0;
        this.mLeftMargin = 0;
        this.mTopMargin = 0;
    }

    private void onCreateBackGroundBitmap() {
        this.mBackground = Bitmap.createBitmap(DOCS_VIEW_WIDTH, DOCS_VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
    }

    private void onCreateTargetBitmap(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inPurgeable = true;
        options.inDither = true;
        this.mTarget = BitmapFactory.decodeFile(filePath, options);
        setTargetSize();
        setResizeBitmap();
    }

    private void setTargetSize() {
        this.mTargetWidth = this.mTarget.getWidth();
        this.mTargetHeight = this.mTarget.getHeight();
    }

    private void setResizeBitmap() {
        int resizeBitmapWidth = 0;
        int resizeBitmapHeight = 0;
        if (this.mTargetWidth > DOCS_VIEW_WIDTH && this.mTargetHeight > DOCS_VIEW_HEIGHT) {
            float tempWidthRate = 1080.0f / this.mTargetWidth;
            float tempHeightRate = 1845.0f / this.mTargetHeight;
            if (tempWidthRate <= tempHeightRate) {
                resizeBitmapWidth = (int) (this.mTargetWidth * tempWidthRate);
                resizeBitmapHeight = (int) (this.mTargetHeight * tempWidthRate);
            } else {
                resizeBitmapWidth = (int) (this.mTargetWidth * tempHeightRate);
                resizeBitmapHeight = (int) (this.mTargetHeight * tempHeightRate);
            }
        } else if (this.mTargetWidth <= DOCS_VIEW_WIDTH && this.mTargetHeight <= DOCS_VIEW_HEIGHT) {
            resizeBitmapHeight = this.mTargetHeight;
            resizeBitmapWidth = this.mTargetWidth;
        } else if (this.mTargetWidth >= DOCS_VIEW_WIDTH) {
            float resizeRate = 1080.0f / this.mTargetWidth;
            resizeBitmapHeight = (int) (this.mTargetHeight * resizeRate);
            resizeBitmapWidth = (int) (this.mTargetWidth * resizeRate);
        } else if (this.mTargetHeight >= DOCS_VIEW_HEIGHT) {
            float resizeRate2 = 1845.0f / this.mTargetHeight;
            resizeBitmapHeight = (int) (this.mTargetHeight * resizeRate2);
            resizeBitmapWidth = (int) (this.mTargetWidth * resizeRate2);
        }
        setCombineBitmap(resizeBitmapWidth, resizeBitmapHeight);
    }

    private void setCombineBitmap(int resizeBitmapWidth, int resizeBitmapHeight) {
        this.mBackgroundCanvas = new Canvas(this.mBackground);
        Paint paint = new Paint();
        this.mResize = Bitmap.createScaledBitmap(this.mTarget, resizeBitmapWidth, resizeBitmapHeight, true);
        setResizeBitmapMargin(resizeBitmapWidth, resizeBitmapHeight);
        this.mBackgroundCanvas.drawBitmap(this.mResize, this.mLeftMargin, this.mTopMargin, paint);
        setResultBitmap(this.mBackground);
    }

    private void setResizeBitmapMargin(int resizeBitmapWidth, int resizeBitmapHeight) {
        this.mLeftMargin = Math.abs((1080 - resizeBitmapWidth) / 2);
        this.mTopMargin = Math.abs((1845 - resizeBitmapHeight) / 2);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mResult != null) {
            this.mResult = null;
        }
        if (this.mBackground != null) {
            this.mBackground = null;
        }
        if (this.mBackgroundCanvas != null) {
            this.mBackgroundCanvas = null;
        }
        if (this.mTarget != null) {
            this.mTarget = null;
        }
        if (this.mResize != null) {
            this.mResize = null;
        }
    }
}
