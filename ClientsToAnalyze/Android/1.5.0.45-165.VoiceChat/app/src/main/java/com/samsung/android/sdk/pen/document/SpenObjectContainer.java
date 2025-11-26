package com.samsung.android.sdk.pen.document;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.util.SpenError;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SpenObjectContainer extends SpenObjectBase {
    private native boolean ObjectContainer_IsInvisibleChildResizingEnabled();

    private native boolean ObjectContainer_appendObject(SpenObjectBase spenObjectBase);

    private native boolean ObjectContainer_appendObjectList(ArrayList<SpenObjectBase> arrayList);

    private native void ObjectContainer_clearChangedFlag();

    private native boolean ObjectContainer_copy(SpenObjectBase spenObjectBase);

    private native boolean ObjectContainer_enableUngrouping(boolean z);

    private native SpenObjectBase ObjectContainer_getObject(int i);

    private native ArrayList<SpenObjectBase> ObjectContainer_getObjectList();

    private native RectF ObjectContainer_getRect();

    private native boolean ObjectContainer_init1();

    private native boolean ObjectContainer_init2(ArrayList<SpenObjectBase> arrayList);

    private native boolean ObjectContainer_init3(ArrayList<SpenObjectBase> arrayList, boolean z);

    private native boolean ObjectContainer_isChanged();

    private native boolean ObjectContainer_isUngroupable();

    private native boolean ObjectContainer_move(float f, float f2);

    private native boolean ObjectContainer_removeObject(SpenObjectBase spenObjectBase);

    private native boolean ObjectContainer_removeObjectList(ArrayList<SpenObjectBase> arrayList);

    private native boolean ObjectContainer_resize(float f, float f2);

    private native boolean ObjectContainer_setInvisibleChildResizingEnabled(boolean z);

    private native boolean ObjectContainer_setRotation(float f);

    public SpenObjectContainer() {
        super(4);
    }

    public SpenObjectContainer(boolean isTemplateObject) {
        super(4);
        boolean rnt = ObjectContainer_init3(null, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectContainer(ArrayList<SpenObjectBase> objectList) {
        super(4);
        boolean rnt = ObjectContainer_init2(objectList);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectContainer(ArrayList<SpenObjectBase> objectList, boolean isTemplateObject) {
        super(4);
        boolean rnt = ObjectContainer_init3(objectList, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectBase createObject(int type) {
        switch (type) {
            case 1:
                return new SpenObjectStroke("");
            case 2:
                return new SpenObjectTextBox("");
            case 3:
                SpenObjectImage i = new SpenObjectImage();
                i.setImage((String) null);
                return i;
            case 4:
                return new SpenObjectContainer((ArrayList<SpenObjectBase>) null);
            default:
                return null;
        }
    }

    public void appendObject(SpenObjectBase object) {
        boolean rnt = ObjectContainer_appendObject(object);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void appendObject(ArrayList<SpenObjectBase> objectList) {
        boolean rnt = ObjectContainer_appendObjectList(objectList);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRect(RectF rect, boolean regionOnly) {
        super.setRect(rect, regionOnly);
    }

    public void removeObject(SpenObjectBase object) {
        boolean rnt = ObjectContainer_removeObject(object);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeObject(ArrayList<SpenObjectBase> objectList) {
        boolean rnt = ObjectContainer_removeObjectList(objectList);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectBase getObject(int index) {
        SpenObjectBase object = ObjectContainer_getObject(index);
        if (object == null) {
            throwUncheckedException(SpenError.getError());
        }
        return object;
    }

    public ArrayList<SpenObjectBase> getObjectList() {
        ArrayList<SpenObjectBase> rnt = ObjectContainer_getObjectList();
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public void setUngroupEnabled(boolean enable) {
        boolean rnt = ObjectContainer_enableUngrouping(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isUngroupEnabled() {
        return ObjectContainer_isUngroupable();
    }

    public boolean setInvisibleChildResizeEnabled(boolean enable) {
        return ObjectContainer_setInvisibleChildResizingEnabled(enable);
    }

    public boolean isInvisibleChildResizeEnabled() {
        return ObjectContainer_IsInvisibleChildResizingEnabled();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void clearChangedFlag() {
        ObjectContainer_clearChangedFlag();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public boolean isChanged() {
        return ObjectContainer_isChanged();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRotation(float degree) {
        boolean rnt = ObjectContainer_setRotation(degree);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(SpenObjectBase source) {
        boolean rnt = ObjectContainer_copy(source);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public RectF getRect() {
        return ObjectContainer_getRect();
    }

    private void throwUncheckedException(int errno) {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenObjectContainer(" + this + ") is already closed");
        }
        SpenError.ThrowUncheckedException(errno);
    }
}
