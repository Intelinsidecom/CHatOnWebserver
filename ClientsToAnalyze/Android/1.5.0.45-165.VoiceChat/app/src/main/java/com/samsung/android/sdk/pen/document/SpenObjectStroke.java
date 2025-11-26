package com.samsung.android.sdk.pen.document;

import android.graphics.PointF;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.util.SpenError;

/* loaded from: classes.dex */
public final class SpenObjectStroke extends SpenObjectBase {
    public static final int TOOL_TYPE_ERASER = 4;
    public static final int TOOL_TYPE_FINGER = 1;
    public static final int TOOL_TYPE_MOUSE = 3;
    public static final int TOOL_TYPE_SPEN = 2;
    public static final int TOOL_TYPE_UNKNOWN = 0;

    private native boolean ObjectStroke_addPoint4(PointF pointF, float f, int i);

    private native boolean ObjectStroke_copy(SpenObjectBase spenObjectBase);

    private native boolean ObjectStroke_enableCurve(boolean z);

    private native String ObjectStroke_getAdvancedPenSetting();

    private native int ObjectStroke_getColor();

    private native int ObjectStroke_getInputType();

    private native String ObjectStroke_getPenName();

    private native float ObjectStroke_getPenSize();

    private native PointF[] ObjectStroke_getPoints();

    private native float[] ObjectStroke_getPressures();

    private native int[] ObjectStroke_getTimeStamps();

    private native int ObjectStroke_getToolType();

    private native boolean ObjectStroke_init1(String str);

    private native boolean ObjectStroke_init3(String str, PointF[] pointFArr, float[] fArr, int[] iArr);

    private native boolean ObjectStroke_init4(String str, PointF[] pointFArr, float[] fArr, int[] iArr, boolean z);

    private native boolean ObjectStroke_isCurvable();

    private native boolean ObjectStroke_move(float f, float f2);

    private native boolean ObjectStroke_resize(float f, float f2);

    private native boolean ObjectStroke_setAdvancedPenSetting(String str);

    private native boolean ObjectStroke_setColor(int i);

    private native boolean ObjectStroke_setInputType(int i);

    private native boolean ObjectStroke_setPenName(String str);

    private native boolean ObjectStroke_setPenSize(float f);

    private native boolean ObjectStroke_setPoints(PointF[] pointFArr, float[] fArr, int[] iArr);

    private native boolean ObjectStroke_setRotation(float f);

    private native boolean ObjectStroke_setToolType(int i);

    public SpenObjectStroke() {
        super(1);
    }

    public SpenObjectStroke(boolean isTemplateObject) {
        super(1);
        boolean rnt = ObjectStroke_init4(null, null, null, null, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectStroke(String penName) {
        super(1);
        boolean rnt = ObjectStroke_init1(penName);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectStroke(String penName, boolean isTemplateObject) {
        super(1);
        boolean rnt = ObjectStroke_init4(penName, null, null, null, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectStroke(String penName, PointF[] points, float[] pressures, int[] timestamps) {
        super(1);
        boolean rnt = ObjectStroke_init3(penName, points, pressures, timestamps);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectStroke(String penName, PointF[] points, float[] pressures, int[] timestamps, boolean isTemplateObject) {
        super(1);
        boolean rnt = ObjectStroke_init4(penName, points, pressures, timestamps, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setPenName(String penName) {
        boolean rnt = ObjectStroke_setPenName(penName);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getPenName() {
        return ObjectStroke_getPenName();
    }

    public void setAdvancedPenSetting(String penStyle) {
        boolean rnt = ObjectStroke_setAdvancedPenSetting(penStyle);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getAdvancedPenSetting() {
        return ObjectStroke_getAdvancedPenSetting();
    }

    public void setPoints(PointF[] points, float[] pressures, int[] timestamps) {
        boolean rnt;
        if (points == null) {
            rnt = ObjectStroke_setPoints(points, pressures, timestamps);
        } else {
            if (points.length != pressures.length || points.length != timestamps.length) {
                SpenError.ThrowUncheckedException(7);
            }
            rnt = ObjectStroke_setPoints(points, pressures, timestamps);
        }
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public PointF[] getPoints() {
        return ObjectStroke_getPoints();
    }

    public float[] getPressures() {
        return ObjectStroke_getPressures();
    }

    public int[] getTimeStamps() {
        return ObjectStroke_getTimeStamps();
    }

    public void addPoint(PointF pos, float pressure, int timestamp) {
        boolean rnt = ObjectStroke_addPoint4(pos, pressure, timestamp);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRect(RectF rect, boolean regionOnly) {
        super.setRect(rect, regionOnly);
    }

    public void setColor(int color) {
        boolean rnt = ObjectStroke_setColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getColor() {
        return ObjectStroke_getColor();
    }

    public void setPenSize(float size) {
        boolean rnt = ObjectStroke_setPenSize(size);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getPenSize() {
        return ObjectStroke_getPenSize();
    }

    public void setCurveEnabled(boolean enable) {
        boolean rnt = ObjectStroke_enableCurve(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isCurveEnabled() {
        return ObjectStroke_isCurvable();
    }

    public void setToolType(int toolType) {
        if (!ObjectStroke_setToolType(toolType)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getToolType() {
        return ObjectStroke_getToolType();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRotation(float degree) {
        boolean rnt = ObjectStroke_setRotation(degree);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(SpenObjectBase source) {
        boolean rnt = ObjectStroke_copy(source);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    private void throwUncheckedException(int errno) {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenObjectStroke(" + this + ") is already closed");
        }
        SpenError.ThrowUncheckedException(errno);
    }
}
