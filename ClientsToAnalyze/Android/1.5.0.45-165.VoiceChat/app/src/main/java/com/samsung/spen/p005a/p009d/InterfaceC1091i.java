package com.samsung.spen.p005a.p009d;

import android.content.Context;
import android.view.ViewGroup;
import com.samsung.spen.settings.SettingFillingInfo;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spen.settings.SettingTextInfo;
import com.samsung.spensdk.applistener.SettingFillingChangeListener;
import com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener;
import com.samsung.spensdk.applistener.SettingStrokeChangeListener;
import com.samsung.spensdk.applistener.SettingTextChangeListener;
import com.samsung.spensdk.applistener.SettingViewShowListener;
import java.util.HashMap;

/* renamed from: com.samsung.spen.a.d.i */
/* loaded from: classes.dex */
public interface InterfaceC1091i {
    boolean onCloseSettingView();

    boolean onCreateSettingView(Context context, HashMap<String, Integer> map, HashMap<String, String> map2);

    boolean onDeleteSettingViewDefaultDescription();

    boolean onDeleteSettingViewPresetInfo(int i, boolean z);

    void onDispose();

    boolean onGetDeleteAllPopupVisible();

    ViewGroup onGetSettingView();

    SettingFillingInfo onGetSettingViewFillingInfo();

    SettingStrokeInfo onGetSettingViewPresetInfo(int i);

    int onGetSettingViewPresetNum();

    int onGetSettingViewSizeOption(int i);

    SettingStrokeInfo onGetSettingViewStrokeInfo();

    SettingTextInfo onGetSettingViewTextInfo();

    void onHideIME();

    boolean onIsDeleteSettingViewDefaultDescription();

    boolean onIsSettingViewVisible(int i);

    void onReadyToFileLoad();

    boolean onSetDeleteAllPopupVisible(boolean z);

    void onSetOnHoverListener(Object obj);

    void onSetOnSCanvasLayoutFillingSettingListener(SettingFillingChangeListener settingFillingChangeListener);

    void onSetOnSCanvasLayoutPenEraserSettingListener(SettingStrokeChangeListener settingStrokeChangeListener);

    void onSetOnSCanvasLayoutSettingViewListener(SettingViewShowListener settingViewShowListener);

    void onSetOnSCanvasLayoutTextSettingListener(SettingTextChangeListener settingTextChangeListener);

    void onSetOnSettingViewPresetDeleteBtnClickListener(SettingPresetDeleteBtnClickListener settingPresetDeleteBtnClickListener);

    void onSetOnTouchListener(Object obj);

    boolean onSetSettingView(ViewGroup viewGroup);

    boolean onSetSettingViewFillingInfo(SettingFillingInfo settingFillingInfo);

    boolean onSetSettingViewPresetCustomDelete(boolean z);

    boolean onSetSettingViewSizeOption(int i, int i2);

    boolean onSetSettingViewStrokeInfo(SettingStrokeInfo settingStrokeInfo);

    boolean onSetSettingViewTextInfo(SettingTextInfo settingTextInfo);

    void onSetTextBoxDefaultSize(int i, int i2);

    void onSetTextIMEOptionFlagNoExtractUI(boolean z);

    boolean onShowSettingView(int i, boolean z);
}
