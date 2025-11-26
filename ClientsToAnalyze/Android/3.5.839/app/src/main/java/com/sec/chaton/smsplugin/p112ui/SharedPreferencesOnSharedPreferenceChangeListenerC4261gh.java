package com.sec.chaton.smsplugin.p112ui;

import android.content.SharedPreferences;
import android.database.Cursor;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gh */
/* loaded from: classes.dex */
class SharedPreferencesOnSharedPreferenceChangeListenerC4261gh implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15627a;

    private SharedPreferencesOnSharedPreferenceChangeListenerC4261gh(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15627a = pluginComposeMessageActivity;
    }

    /* synthetic */ SharedPreferencesOnSharedPreferenceChangeListenerC4261gh(PluginComposeMessageActivity pluginComposeMessageActivity, HandlerC4175dc handlerC4175dc) {
        this(pluginComposeMessageActivity);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("free_sms_remain_count") || str.equals("free_sms_is_available") || str.equals("pref_key_is_free_sms_enable")) {
            if (!C3847e.m14654aE()) {
                this.f15627a.f14943O.setHint(R.string.type_to_compose_sms_message);
                return;
            }
            int iIntValue = C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue();
            if (iIntValue > 0) {
                this.f15627a.f14943O.setHint(this.f15627a.getString(R.string.freesms_display_remain_count, new Object[]{Integer.valueOf(iIntValue)}));
                return;
            }
            Cursor cursor = this.f15627a.f15050p.getCursor();
            if (cursor.moveToLast()) {
                C4110as c4110as = this.f15627a.f15050p;
                C4809aa.m18104a().m18126b("free_sms_reward_noti_msgid_int", Integer.valueOf(cursor.getInt(C4110as.f15300o.f15336b)));
            }
        }
    }
}
