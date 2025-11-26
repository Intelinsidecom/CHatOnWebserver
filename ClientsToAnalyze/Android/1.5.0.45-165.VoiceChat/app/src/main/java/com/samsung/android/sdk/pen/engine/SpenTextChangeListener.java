package com.samsung.android.sdk.pen.engine;

import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;

/* loaded from: classes.dex */
public interface SpenTextChangeListener {
    public static final int CONTROL_STATE_NOT_CHANGED = 2;
    public static final int CONTROL_STATE_SELECTED = 0;
    public static final int CONTROL_STATE_UNSELECTED = 1;

    void onChanged(SpenSettingTextInfo spenSettingTextInfo, int i);

    void onFocusChanged(boolean z);

    void onMoreButtonDown(SpenObjectTextBox spenObjectTextBox);

    boolean onSelectionChanged(int i, int i2);
}
