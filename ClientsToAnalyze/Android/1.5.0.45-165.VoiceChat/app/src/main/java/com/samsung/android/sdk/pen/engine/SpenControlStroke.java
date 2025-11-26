package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenControlStroke extends SpenControlBase {
    public SpenControlStroke(Context context, SpenPageDoc pageDoc) {
        super(context, pageDoc);
    }

    public void setObject(SpenObjectStroke objectStroke) {
        this.mRotateAngle = objectStroke.getRotation();
        ArrayList<SpenObjectBase> objectList = new ArrayList<>();
        objectList.add(objectStroke);
        setObjectList(objectList);
    }

    public SpenObjectStroke getObject() {
        return (SpenObjectStroke) getObjectList().get(0);
    }
}
