package com.samsung.android.sdk.pen.document;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.util.SpenError;

/* loaded from: classes.dex */
public final class SpenObjectImage extends SpenObjectBase {
    public static final int BORDER_TYPE_DOT = 3;
    public static final int BORDER_TYPE_IMAGE = 4;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SHADOW = 2;
    public static final int BORDER_TYPE_SQUARE = 1;

    private native void Bitmap_saveImageTest();

    private native void ObjectImage_clearChangedFlag();

    private native boolean ObjectImage_copy(SpenObjectBase spenObjectBase);

    private native int ObjectImage_getBorderType();

    private native Rect ObjectImage_getCropRect();

    private native RectF ObjectImage_getDrawnRect();

    private native String ObjectImage_getHintText();

    private native int ObjectImage_getHintTextColor();

    private native float ObjectImage_getHintTextFontSize();

    private native float ObjectImage_getHintTextVerticalOffset();

    private native Bitmap ObjectImage_getImage();

    private native Bitmap ObjectImage_getImageBorder();

    private native float ObjectImage_getImageBorderBottomWidth();

    private native float ObjectImage_getImageBorderLeftWidth();

    private native Rect ObjectImage_getImageBorderNinePatchRect();

    private native String ObjectImage_getImageBorderPath();

    private native float ObjectImage_getImageBorderRightWidth();

    private native float ObjectImage_getImageBorderTopWidth();

    private native String ObjectImage_getImagePath();

    private native int ObjectImage_getLineBorderColor();

    private native float ObjectImage_getLineBorderWidth();

    private native Rect ObjectImage_getNinePatchRect();

    private native boolean ObjectImage_getTransparency();

    private native boolean ObjectImage_init(boolean z);

    private native boolean ObjectImage_isChanged();

    private native boolean ObjectImage_isHintTextVisiable();

    private native boolean ObjectImage_setBorderType(int i);

    private native boolean ObjectImage_setCropRect(Rect rect);

    private native boolean ObjectImage_setHintText(String str);

    private native boolean ObjectImage_setHintTextColor(int i);

    private native boolean ObjectImage_setHintTextFontSize(float f);

    private native boolean ObjectImage_setHintTextVerticalOffset(float f);

    private native boolean ObjectImage_setHintTextVisibility(boolean z);

    private native boolean ObjectImage_setImage(Bitmap bitmap);

    private native boolean ObjectImage_setImage2(String str);

    private native boolean ObjectImage_setImage3(Bitmap bitmap, Rect rect);

    private native boolean ObjectImage_setImage4(String str, Rect rect);

    private native boolean ObjectImage_setImageBorder(Bitmap bitmap, Rect rect);

    private native boolean ObjectImage_setImageBorderWidth(float f, float f2, float f3, float f4);

    private native boolean ObjectImage_setLineBorderColor(int i);

    private native boolean ObjectImage_setLineBorderWidth(float f);

    private native boolean ObjectImage_setTransparency(boolean z);

    public SpenObjectImage() {
        super(3);
    }

    public SpenObjectImage(boolean isTemplateObject) {
        super(3);
        boolean rnt = ObjectImage_init(isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setImage(Bitmap image) {
        if (image != null && image.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        boolean rnt = ObjectImage_setImage(image);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setImage(String filePath) {
        boolean rnt = ObjectImage_setImage2(filePath);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setImage(Bitmap image, Rect ninePatchRect) {
        if (image != null && image.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        boolean rnt = ObjectImage_setImage3(image, ninePatchRect);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setImage(String filePath, Rect ninePatchRect) {
        boolean rnt = ObjectImage_setImage4(filePath, ninePatchRect);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public Rect getNinePatchRect() {
        return ObjectImage_getNinePatchRect();
    }

    public Bitmap getImage() {
        return ObjectImage_getImage();
    }

    public String getImagePath() {
        return ObjectImage_getImagePath();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRect(RectF rect, boolean regionOnly) {
        super.setRect(rect, regionOnly);
    }

    public void setImageBorder(Bitmap image, Rect ninePatchRect) {
        if (image != null && image.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        boolean rnt = ObjectImage_setImageBorder(image, ninePatchRect);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public Bitmap getImageBorder() {
        String path = ObjectImage_getImageBorderPath();
        if (path == null) {
            return null;
        }
        return BitmapFactory.decodeFile(path);
    }

    public String getImageBorderPath() {
        return ObjectImage_getImageBorderPath();
    }

    public Rect getImageBorderNinePatchRect() {
        return ObjectImage_getImageBorderNinePatchRect();
    }

    public void setCropRect(Rect cropRect) {
        boolean rnt = ObjectImage_setCropRect(cropRect);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public Rect getCropRect() {
        return ObjectImage_getCropRect();
    }

    public void setLineBorderColor(int color) {
        boolean rnt = ObjectImage_setLineBorderColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getLineBorderColor() {
        return ObjectImage_getLineBorderColor();
    }

    public void setLineBorderWidth(float width) {
        boolean rnt = ObjectImage_setLineBorderWidth(width);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getLineBorderWidth() {
        return ObjectImage_getLineBorderWidth();
    }

    public void setImageBorderWidth(float left, float top, float right, float bottom) {
        boolean rnt = ObjectImage_setImageBorderWidth(left, top, right, bottom);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getImageBorderLeftWidth() {
        return ObjectImage_getImageBorderLeftWidth();
    }

    public float getImageBorderTopWidth() {
        return ObjectImage_getImageBorderTopWidth();
    }

    public float getImageBorderRightWidth() {
        return ObjectImage_getImageBorderRightWidth();
    }

    public float getImageBorderBottomWidth() {
        return ObjectImage_getImageBorderBottomWidth();
    }

    public void setBorderType(int type) {
        boolean rnt = ObjectImage_setBorderType(type);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getBorderType() {
        return ObjectImage_getBorderType();
    }

    public void setHintText(String hintText) {
        boolean rnt = ObjectImage_setHintText(hintText);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getHintText() {
        return ObjectImage_getHintText();
    }

    public void setHintTextEnabled(boolean visible) {
        boolean rnt = ObjectImage_setHintTextVisibility(visible);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isHintTextEnabled() {
        return ObjectImage_isHintTextVisiable();
    }

    public void setTransparency(boolean transparency) {
        boolean rnt = ObjectImage_setTransparency(transparency);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean getTransparency() {
        return ObjectImage_getTransparency();
    }

    public void setHintTextColor(int color) {
        boolean rnt = ObjectImage_setHintTextColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getHintTextColor() {
        return ObjectImage_getHintTextColor();
    }

    public void setHintTextFontSize(float size) {
        boolean rnt = ObjectImage_setHintTextFontSize(size);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getHintTextFontSize() {
        return ObjectImage_getHintTextFontSize();
    }

    public void setHintTextVerticalOffset(float offset) {
        boolean rnt = ObjectImage_setHintTextVerticalOffset(offset);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getHintTextVerticalOffset() {
        return ObjectImage_getHintTextVerticalOffset();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void clearChangedFlag() {
        ObjectImage_clearChangedFlag();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public boolean isChanged() {
        return ObjectImage_isChanged();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public RectF getDrawnRect() {
        return ObjectImage_getDrawnRect();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(SpenObjectBase source) {
        boolean rnt = ObjectImage_copy(source);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    private void throwUncheckedException(int errno) {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenObjectImage(" + this + ") is already closed");
        }
        SpenError.ThrowUncheckedException(errno);
    }
}
