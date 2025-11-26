package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenControlContainer extends SpenControlBase {
    public SpenControlContainer(Context context, SpenPageDoc pageDoc) {
        super(context, pageDoc);
    }

    public void setObject(SpenObjectContainer objectContainer) {
        if (objectContainer != null) {
            this.mRotateAngle = objectContainer.getRotation();
            ArrayList<SpenObjectBase> objectList = new ArrayList<>();
            objectList.add(objectContainer);
            setObjectList(objectList);
        }
    }

    public SpenObjectContainer getObject() {
        return (SpenObjectContainer) getObjectList().get(0);
    }
}
