package com.renren.android;

import android.content.SharedPreferences;

/* compiled from: AccessTokenManager.java */
/* renamed from: com.renren.android.a */
/* loaded from: classes.dex */
class SharedPreferencesOnSharedPreferenceChangeListenerC0707a implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f1637a;

    /* renamed from: b */
    final /* synthetic */ AccessTokenManager f1638b;

    SharedPreferencesOnSharedPreferenceChangeListenerC0707a(AccessTokenManager accessTokenManager, SharedPreferences sharedPreferences) {
        this.f1638b = accessTokenManager;
        this.f1637a = sharedPreferences;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String string = this.f1637a.getString("renren_sdk_config_prop_session_key", null);
        String string2 = this.f1637a.getString("renren_sdk_config_prop_session_secret", null);
        long j = this.f1637a.getLong("renren_sdk_config_prop_user_id", 0L);
        if ((this.f1638b.sessionKey != null && !this.f1638b.sessionKey.equals(string)) || ((this.f1638b.sessionSecret != null && !this.f1638b.sessionKey.equals(string2)) || ((this.f1638b.sessionKey == null && string != null) || ((this.f1638b.sessionSecret == null && string2 != null) || this.f1638b.uid != j)))) {
            this.f1638b.m2238i();
        }
    }
}
