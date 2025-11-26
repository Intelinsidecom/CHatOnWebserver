package com.samsung.sdraw;

import android.graphics.Point;
import android.graphics.RectF;
import android.text.Editable;
import android.text.Layout;

/* renamed from: com.samsung.sdraw.bu */
/* loaded from: classes.dex */
interface InterfaceC1035bu {
    void createTextBox(Point point);

    void createTextBox(RectF rectF, Editable editable, TextInfo textInfo);

    int getObjectID();

    Layout.Alignment getTextBoxAlignment();

    int getTextBoxHeight();

    Point getTextBoxPosition();

    Editable getTextBoxText();

    int getTextBoxWidth();

    boolean isShowTextBox();

    void restoreTextSettingInfo();

    void setObjectID(int i);

    void showTextBox(boolean z);
}
