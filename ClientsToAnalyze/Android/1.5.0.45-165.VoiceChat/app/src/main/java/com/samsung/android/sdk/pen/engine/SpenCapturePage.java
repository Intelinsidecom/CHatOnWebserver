package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Log;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.util.SpenError;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenCapturePage {
    private static final String TAG = "SpenCapturePage";
    private SpenPageDoc mPageDoc;
    private Bitmap mCanvasLayer = null;
    private int mBitmapWidth = 0;
    private int mBitmapHeight = 0;
    private boolean mIsHyperText = false;
    private int mNativeCapture = native_init();

    private static native boolean native_captureRect(int i, Bitmap bitmap, RectF rectF);

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList, int i3);

    private static native boolean native_construct(int i, Context context);

    private static native void native_finalize(int i);

    private static native int native_init();

    private static native void native_setCanvasBitmap(int i, int i2, Bitmap bitmap);

    private static native boolean native_setPageDoc(int i, SpenPageDoc spenPageDoc);

    private static native boolean native_setScreenSize(int i, int i2, int i3);

    public SpenCapturePage(Context context) {
        if (!native_construct(this.mNativeCapture, context)) {
            SpenError.ThrowUncheckedException(8);
        }
    }

    public void setPageDoc(SpenPageDoc pageDoc) {
        if (this.mNativeCapture != 0) {
            if (pageDoc != null && !pageDoc.isValid()) {
                Log.d(TAG, "setPageDoc is closed");
                return;
            }
            createBitmap(pageDoc);
            this.mPageDoc = pageDoc;
            native_setScreenSize(this.mNativeCapture, this.mBitmapWidth, this.mBitmapHeight);
            native_setPageDoc(this.mNativeCapture, pageDoc);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void compressPage(java.lang.String r13, float r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.pen.engine.SpenCapturePage.compressPage(java.lang.String, float):void");
    }

    public Bitmap captureRect(RectF rect) {
        if (this.mNativeCapture == 0) {
            return null;
        }
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        try {
            Bitmap bitmap = Bitmap.createBitmap((int) rect.width(), (int) rect.height(), Bitmap.Config.ARGB_8888);
            if (native_captureRect(this.mNativeCapture, bitmap, rect)) {
                return bitmap;
            }
        } catch (Throwable th) {
            Log.e(TAG, "Failed to create bitmap w = " + rect.width() + " h = " + rect.height());
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        return null;
    }

    public Bitmap capturePage(float ratio) {
        if (this.mCanvasLayer == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(this.mCanvasLayer, (int) (this.mBitmapWidth * ratio), (int) (this.mBitmapHeight * ratio), true);
    }

    public void close() {
        if (this.mNativeCapture != 0) {
            native_finalize(this.mNativeCapture);
            this.mNativeCapture = 0;
            if (this.mCanvasLayer != null && !this.mCanvasLayer.isRecycled()) {
                this.mCanvasLayer.recycle();
                this.mCanvasLayer = null;
            }
            this.mPageDoc = null;
        }
    }

    public void setHyperTextViewEnabled(boolean enable) {
        if (this.mNativeCapture != 0) {
            this.mIsHyperText = enable;
            native_command(this.mNativeCapture, 1, null, this.mIsHyperText ? 1 : 0);
        }
    }

    public boolean isHyperTextViewEnabled() {
        return this.mIsHyperText;
    }

    private void createBitmap(SpenPageDoc pageDoc) {
        if (this.mNativeCapture != 0 && pageDoc != null && pageDoc.isValid()) {
            int width = this.mBitmapWidth;
            int height = this.mBitmapHeight;
            this.mBitmapWidth = pageDoc.getWidth();
            this.mBitmapHeight = pageDoc.getHeight();
            if (this.mBitmapWidth == 0) {
                SpenError.ThrowUncheckedException(6, "The width of pageDoc is 0");
                return;
            }
            if (this.mBitmapHeight == 0) {
                SpenError.ThrowUncheckedException(6, "The height of pageDoc is 0");
                return;
            }
            Log.e(TAG, "createBitmap Width=" + this.mBitmapWidth + " Height=" + this.mBitmapHeight);
            if (width != this.mBitmapWidth || height != this.mBitmapHeight) {
                if (this.mCanvasLayer != null && !this.mCanvasLayer.isRecycled()) {
                    this.mCanvasLayer.recycle();
                }
                this.mCanvasLayer = Bitmap.createBitmap(this.mBitmapWidth, this.mBitmapHeight, Bitmap.Config.ARGB_8888);
                native_setCanvasBitmap(this.mNativeCapture, pageDoc.getLayerIdByIndex(0), this.mCanvasLayer);
            }
        }
    }
}
