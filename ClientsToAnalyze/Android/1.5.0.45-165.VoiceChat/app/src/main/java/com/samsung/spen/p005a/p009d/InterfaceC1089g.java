package com.samsung.spen.p005a.p009d;

import com.samsung.samm.common.SObject;
import com.samsung.spensdk.applistener.SPenTouchIDListener;

/* renamed from: com.samsung.spen.a.d.g */
/* loaded from: classes.dex */
public interface InterfaceC1089g {
    boolean onChangeObject(int i, int i2, SObject sObject);

    boolean onDeleteObject(int i, int i2);

    boolean onDrawObject(int i, int i2, SObject sObject);

    boolean onDrawStrokePoint(int i, int i2, int i3, float f, float f2, float f3, int i4, long j, long j2);

    void onSetSPenTouchIDListener(SPenTouchIDListener sPenTouchIDListener);
}
