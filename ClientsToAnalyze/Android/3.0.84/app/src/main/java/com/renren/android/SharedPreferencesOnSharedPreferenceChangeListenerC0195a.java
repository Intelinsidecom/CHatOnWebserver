package com.renren.android;

import android.content.SharedPreferences;

/* compiled from: AccessTokenManager.java */
/* renamed from: com.renren.android.a */
/* loaded from: classes.dex */
class SharedPreferencesOnSharedPreferenceChangeListenerC0195a implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f401a;

    /* renamed from: b */
    final /* synthetic */ AccessTokenManager f402b;

    SharedPreferencesOnSharedPreferenceChangeListenerC0195a(AccessTokenManager accessTokenManager, SharedPreferences sharedPreferences) {
        this.f402b = accessTokenManager;
        this.f401a = sharedPreferences;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String string = this.f401a.getString("renren_sdk_config_prop_session_key", null);
        String string2 = this.f401a.getString("renren_sdk_config_prop_session_secret", null);
        long j = this.f401a.getLong("renren_sdk_config_prop_user_id", 0L);
        if ((this.f402b.sessionKey != null && !this.f402b.sessionKey.equals(string)) || ((this.f402b.sessionSecret != null && !this.f402b.sessionKey.equals(string2)) || ((this.f402b.sessionKey == null && string != null) || ((this.f402b.sessionSecret == null && string2 != null) || this.f402b.uid != j)))) {
            this.f402b.m506i();
        }
    }
}
