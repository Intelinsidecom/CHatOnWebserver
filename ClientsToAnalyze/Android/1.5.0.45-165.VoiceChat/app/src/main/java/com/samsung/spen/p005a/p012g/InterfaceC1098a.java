package com.samsung.spen.p005a.p012g;

import android.view.View;
import com.samsung.spen.p005a.p007b.InterfaceC1077e;
import com.samsung.spen.p005a.p009d.InterfaceC1091i;
import com.samsung.spen.settings.SettingFillingInfo;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spen.settings.SettingTextInfo;
import com.samsung.spensdk.applistener.SPenHoverListener;
import com.samsung.spensdk.applistener.SPenTouchListener;
import com.samsung.spensdk.applistener.SettingFillingChangeListener;
import com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener;
import com.samsung.spensdk.applistener.SettingStrokeChangeListener;
import com.samsung.spensdk.applistener.SettingTextChangeListener;
import com.samsung.spensdk.applistener.SettingViewShowListener;

/* renamed from: com.samsung.spen.a.g.a */
/* loaded from: classes.dex */
public interface InterfaceC1098a {
    /* renamed from: a */
    void mo1937a(View.OnTouchListener onTouchListener);

    /* renamed from: a */
    void mo1938a(InterfaceC1077e interfaceC1077e);

    /* renamed from: a */
    void mo1939a(InterfaceC1091i interfaceC1091i);

    /* renamed from: a */
    void mo1940a(SPenHoverListener sPenHoverListener);

    /* renamed from: a */
    void mo1941a(SPenTouchListener sPenTouchListener);

    /* renamed from: a */
    void mo1942a(SettingFillingChangeListener settingFillingChangeListener);

    /* renamed from: a */
    void mo1943a(SettingPresetDeleteBtnClickListener settingPresetDeleteBtnClickListener);

    /* renamed from: a */
    void mo1944a(SettingStrokeChangeListener settingStrokeChangeListener);

    /* renamed from: a */
    void mo1945a(SettingTextChangeListener settingTextChangeListener);

    /* renamed from: a */
    void mo1946a(SettingViewShowListener settingViewShowListener);

    /* renamed from: a */
    boolean mo1947a();

    /* renamed from: a */
    boolean mo1948a(int i);

    /* renamed from: a */
    boolean mo1949a(int i, int i2);

    /* renamed from: a */
    boolean mo1950a(int i, boolean z);

    /* renamed from: a */
    boolean mo1951a(SettingFillingInfo settingFillingInfo);

    /* renamed from: a */
    boolean mo1952a(SettingStrokeInfo settingStrokeInfo);

    /* renamed from: a */
    boolean mo1953a(SettingTextInfo settingTextInfo);

    /* renamed from: a */
    boolean mo1954a(boolean z);

    /* renamed from: b */
    int mo1955b(int i);

    /* renamed from: b */
    void mo1956b(int i, int i2);

    /* renamed from: b */
    void mo1957b(boolean z);

    /* renamed from: b */
    boolean mo1958b();

    /* renamed from: b */
    boolean mo1959b(int i, boolean z);

    /* renamed from: c */
    SettingStrokeInfo mo1960c(int i);

    /* renamed from: c */
    boolean mo1961c();

    /* renamed from: c */
    boolean mo1962c(boolean z);

    /* renamed from: d */
    SettingStrokeInfo mo1963d();

    /* renamed from: e */
    SettingTextInfo mo1964e();

    /* renamed from: f */
    SettingFillingInfo mo1965f();

    /* renamed from: g */
    boolean mo1966g();

    /* renamed from: h */
    void mo1967h();

    /* renamed from: i */
    void mo1968i();

    /* renamed from: j */
    void mo1969j();

    /* renamed from: k */
    int mo1970k();

    /* renamed from: l */
    boolean mo1971l();
}
