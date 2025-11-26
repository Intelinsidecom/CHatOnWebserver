package com.samsung.spensdk.applistener;

/* loaded from: classes.dex */
public interface SettingStrokeChangeListener {
    @Deprecated
    void onClearAll(boolean z);

    void onDeleteAll(boolean z);

    void onEraserWidthChanged(int i);

    void onStrokeAlphaChanged(int i);

    void onStrokeColorChanged(int i);

    void onStrokeStyleChanged(int i);

    void onStrokeWidthChanged(int i);
}
