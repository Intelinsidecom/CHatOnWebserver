package com.samsung.android.sdk.pen.document;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.util.SpenError;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenObjectBase {
    public static final float OBJECT_MINIMUM_SIZE = 10.0f;
    public static final int RESIZE_OPTION_DISABLE = 2;
    public static final int RESIZE_OPTION_FREE = 0;
    public static final int RESIZE_OPTION_KEEP_RATIO = 1;
    public static final float SPEN_INFINITY_FLOAT = Float.MAX_VALUE;
    public static final int SPEN_INFINITY_INT = Integer.MAX_VALUE;
    public static final int TYPE_CONTAINER = 4;
    public static final int TYPE_IMAGE = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_STROKE = 1;
    public static final int TYPE_TEXT_BOX = 2;
    private int mHandle = -1;
    private final int mType;

    private native ArrayList<Object> Native_command(int i, ArrayList<Object> arrayList);

    private native boolean ObjectBase_attachFile(String str);

    private native void ObjectBase_clearChangedFlag();

    private native boolean ObjectBase_copy(SpenObjectBase spenObjectBase);

    private native boolean ObjectBase_copyExtraData(SpenObjectBase spenObjectBase);

    private native boolean ObjectBase_detachFile();

    private native boolean ObjectBase_enableClip(boolean z);

    private native boolean ObjectBase_enableMovement(boolean z);

    private native boolean ObjectBase_enableRotation(boolean z);

    private native boolean ObjectBase_enableSelection(boolean z);

    private native void ObjectBase_finalize();

    private native String ObjectBase_getAttachedFile();

    private native int ObjectBase_getCreateTimeStamp();

    private native RectF ObjectBase_getDrawnRect();

    private native byte[] ObjectBase_getExtraDataByteArray(String str);

    private native int ObjectBase_getExtraDataInt(String str);

    private native String ObjectBase_getExtraDataString(String str);

    private native String[] ObjectBase_getExtraDataStringArray(String str);

    private native int ObjectBase_getHistoryManagerId();

    private native float ObjectBase_getMaxHeight();

    private native float ObjectBase_getMaxWidth();

    private native float ObjectBase_getMinHeight();

    private native float ObjectBase_getMinWidth();

    private native RectF ObjectBase_getRect();

    private native int ObjectBase_getResizeOption();

    private native float ObjectBase_getRotation();

    private native int ObjectBase_getRuntimeHandle();

    private native byte[] ObjectBase_getSorDataByteArray(String str);

    private native int ObjectBase_getSorDataInt(String str);

    private native String ObjectBase_getSorDataString(String str);

    private native String[] ObjectBase_getSorDataStringArray(String str);

    private native String ObjectBase_getSorInfo();

    private native String ObjectBase_getSorPackageLink();

    private native boolean ObjectBase_getTemplateProperty();

    private native int ObjectBase_getType();

    private native int ObjectBase_getUserId();

    private native boolean ObjectBase_hasExtraDataByteArray(String str);

    private native boolean ObjectBase_hasExtraDataInt(String str);

    private native boolean ObjectBase_hasExtraDataString(String str);

    private native boolean ObjectBase_hasExtraDataStringArray(String str);

    private native boolean ObjectBase_hasSorDataByteArray(String str);

    private native boolean ObjectBase_hasSorDataInt(String str);

    private native boolean ObjectBase_hasSorDataString(String str);

    private native boolean ObjectBase_hasSorDataStringArray(String str);

    private native boolean ObjectBase_isChanged();

    private native boolean ObjectBase_isClippable();

    private native boolean ObjectBase_isFlipEnabled();

    private native boolean ObjectBase_isMovable();

    private native boolean ObjectBase_isRecorded();

    private native boolean ObjectBase_isRotatable();

    private native boolean ObjectBase_isSelectable();

    private native boolean ObjectBase_isVisible();

    private native boolean ObjectBase_move(float f, float f2);

    private native boolean ObjectBase_removeExtraDataByteArray(String str);

    private native boolean ObjectBase_removeExtraDataInt(String str);

    private native boolean ObjectBase_removeExtraDataString(String str);

    private native boolean ObjectBase_removeExtraDataStringArray(String str);

    private native boolean ObjectBase_removeSorDataByteArray(String str);

    private native boolean ObjectBase_removeSorDataInt(String str);

    private native boolean ObjectBase_removeSorDataString(String str);

    private native boolean ObjectBase_removeSorDataStringArray(String str);

    private native boolean ObjectBase_resize(float f, float f2);

    private native boolean ObjectBase_setCreateTimeStamp(int i);

    private native boolean ObjectBase_setExtraDataByteArray(String str, byte[] bArr, int i);

    private native boolean ObjectBase_setExtraDataInt(String str, int i);

    private native boolean ObjectBase_setExtraDataString(String str, String str2);

    private native boolean ObjectBase_setExtraDataStringArray(String str, String[] strArr, int i);

    private native boolean ObjectBase_setFlipEnabled(boolean z);

    private native boolean ObjectBase_setMaxSize(float f, float f2);

    private native boolean ObjectBase_setMinSize(float f, float f2);

    private native boolean ObjectBase_setRecorded(boolean z);

    private native boolean ObjectBase_setRect(RectF rectF, boolean z);

    private native boolean ObjectBase_setResizeOption(int i);

    private native boolean ObjectBase_setRotation(float f);

    private native boolean ObjectBase_setSorDataByteArray(String str, byte[] bArr, int i);

    private native boolean ObjectBase_setSorDataInt(String str, int i);

    private native boolean ObjectBase_setSorDataString(String str, String str2);

    private native boolean ObjectBase_setSorDataStringArray(String str, String[] strArr, int i);

    private native boolean ObjectBase_setSorInfo(String str);

    private native boolean ObjectBase_setSorPackageLink(String str);

    private native boolean ObjectBase_setUserId(int i);

    private native boolean ObjectBase_setVisibility(boolean z);

    protected void finalize() throws Throwable {
        Native_command(0, null);
        try {
            ObjectBase_finalize();
            super.finalize();
            this.mHandle = -1;
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    protected SpenObjectBase(int type) {
        this.mType = type;
    }

    private void throwUncheckedException(int errno) {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenObjectBase(" + this + ") is already closed");
        }
        SpenError.ThrowUncheckedException(errno);
    }

    public int getType() {
        return ObjectBase_getType();
    }

    public void setRect(RectF rect, boolean regionOnly) {
        boolean rnt = ObjectBase_setRect(rect, regionOnly);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public RectF getRect() {
        return ObjectBase_getRect();
    }

    public void setRecorded(boolean record) {
        boolean rnt = ObjectBase_setRecorded(record);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isRecorded() {
        return ObjectBase_isRecorded();
    }

    public void setVisibility(boolean visible) {
        boolean rnt = ObjectBase_setVisibility(visible);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isVisible() {
        return ObjectBase_isVisible();
    }

    public void setResizeOption(int option) {
        boolean rnt = ObjectBase_setResizeOption(option);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getResizeOption() {
        return ObjectBase_getResizeOption();
    }

    public void setMinSize(float width, float height) {
        boolean rnt = ObjectBase_setMinSize(width, height);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getMinWidth() {
        return ObjectBase_getMinWidth();
    }

    public float getMinHeight() {
        return ObjectBase_getMinHeight();
    }

    public void setMaxSize(float width, float height) {
        boolean rnt = ObjectBase_setMaxSize(width, height);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getMaxWidth() {
        return ObjectBase_getMaxWidth();
    }

    public float getMaxHeight() {
        return ObjectBase_getMaxHeight();
    }

    public void setRotation(float degree) {
        boolean rnt = ObjectBase_setRotation(degree);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getRotation() {
        return ObjectBase_getRotation();
    }

    public void setRotatable(boolean enable) {
        boolean rnt = ObjectBase_enableRotation(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isRotatable() {
        return ObjectBase_isRotatable();
    }

    public void setOutOfViewEnabled(boolean enable) {
        boolean rnt = ObjectBase_enableClip(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isOutOfViewEnabled() {
        return ObjectBase_isClippable();
    }

    public void setSelectable(boolean enable) {
        boolean rnt = ObjectBase_enableSelection(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isSelectable() {
        return ObjectBase_isSelectable();
    }

    public void setMovable(boolean enable) {
        boolean rnt = ObjectBase_enableMovement(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isMovable() {
        return ObjectBase_isMovable();
    }

    public void setFlipEnabled(boolean enable) {
        boolean rnt = ObjectBase_setFlipEnabled(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isFlipEnabled() {
        return ObjectBase_isFlipEnabled();
    }

    public void setSorInfo(String info) {
        boolean rnt = ObjectBase_setSorInfo(info);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getSorInfo() {
        return ObjectBase_getSorInfo();
    }

    public void setSorPackageLink(String link) {
        boolean rnt = ObjectBase_setSorPackageLink(link);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getSorPackageLink() {
        return ObjectBase_getSorPackageLink();
    }

    public boolean getTemplateProperty() {
        return ObjectBase_getTemplateProperty();
    }

    public boolean setUserId(int userId) {
        return ObjectBase_setUserId(userId);
    }

    public int getUserId() {
        return ObjectBase_getUserId();
    }

    public void setSorDataString(String key, String value) {
        boolean rnt = ObjectBase_setSorDataString(key, value);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getSorDataString(String key) {
        return ObjectBase_getSorDataString(key);
    }

    public void setSorDataInt(String key, int value) {
        boolean rnt = ObjectBase_setSorDataInt(key, value);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getSorDataInt(String key) {
        return ObjectBase_getSorDataInt(key);
    }

    public boolean hasSorDataString(String key) {
        return ObjectBase_hasSorDataString(key);
    }

    public boolean hasSorDataInt(String key) {
        return ObjectBase_hasSorDataInt(key);
    }

    public void removeSorDataString(String key) {
        boolean rnt = ObjectBase_removeSorDataString(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeSorDataInt(String key) {
        boolean rnt = ObjectBase_removeSorDataInt(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataString(String key, String value) {
        boolean rnt = ObjectBase_setExtraDataString(key, value);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getExtraDataString(String key) {
        return ObjectBase_getExtraDataString(key);
    }

    public boolean hasExtraDataString(String key) {
        return ObjectBase_hasExtraDataString(key);
    }

    public void removeExtraDataString(String key) {
        boolean rnt = ObjectBase_removeExtraDataString(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataInt(String key, int value) {
        boolean rnt = ObjectBase_setExtraDataInt(key, value);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getExtraDataInt(String key) {
        return ObjectBase_getExtraDataInt(key);
    }

    public boolean hasExtraDataInt(String key) {
        return ObjectBase_hasExtraDataInt(key);
    }

    public void removeExtraDataInt(String key) {
        boolean rnt = ObjectBase_removeExtraDataInt(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataStringArray(String key, String[] value) {
        boolean rnt;
        if (value == null) {
            rnt = ObjectBase_setExtraDataStringArray(key, value, 0);
        } else {
            rnt = ObjectBase_setExtraDataStringArray(key, value, value.length);
        }
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String[] getExtraDataStringArray(String key) {
        return ObjectBase_getExtraDataStringArray(key);
    }

    public boolean hasExtraDataStringArray(String key) {
        return ObjectBase_hasExtraDataStringArray(key);
    }

    public void removeExtraDataStringArray(String key) {
        boolean rnt = ObjectBase_removeExtraDataStringArray(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataByteArray(String key, byte[] value) {
        boolean rnt;
        if (value == null) {
            rnt = ObjectBase_setExtraDataByteArray(key, value, 0);
        } else {
            rnt = ObjectBase_setExtraDataByteArray(key, value, value.length);
        }
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public byte[] getExtraDataByteArray(String key) {
        return ObjectBase_getExtraDataByteArray(key);
    }

    public boolean hasExtraDataByteArray(String key) {
        return ObjectBase_hasExtraDataByteArray(key);
    }

    public void removeExtraDataByteArray(String key) {
        boolean rnt = ObjectBase_removeExtraDataByteArray(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void clearChangedFlag() {
        ObjectBase_clearChangedFlag();
    }

    public boolean isChanged() {
        return ObjectBase_isChanged();
    }

    public void attachFile(String filePath) {
        if (!ObjectBase_attachFile(filePath)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void detachFile() {
        if (!ObjectBase_detachFile()) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getAttachedFile() {
        return ObjectBase_getAttachedFile();
    }

    public int getRuntimeHandle() {
        return ObjectBase_getRuntimeHandle();
    }

    public RectF getDrawnRect() {
        return ObjectBase_getDrawnRect();
    }

    public void copy(SpenObjectBase source) {
        boolean rnt = ObjectBase_copy(source);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean equals(Object o) {
        return (o instanceof SpenObjectBase) && this.mHandle == ((SpenObjectBase) o).mHandle;
    }

    public int hashCode() {
        return this.mHandle;
    }
}
