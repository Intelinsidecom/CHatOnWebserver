package com.coolots.chaton.setting.view.callalert;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.data.ChatONSettingDataInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ChatONCallAlertFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener, DisposeInterface {
    private static final String CLASSNAME = "[ChatONCallAlertFragment]";
    private final ChatONSettingDataInterface chatonSetting = ChatONSettingData.getInstance();
    private ChatOnService mChatonservice;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            addPreferencesFromResource(C0000R.xml.call_alert_setting_black);
        } else {
            addPreferencesFromResource(C0000R.xml.call_alert_setting);
        }
        setRetainInstance(true);
        updateAllData(null);
    }

    @Override // android.app.Fragment
    public void onResume() {
        if (this.mChatonservice == null) {
            this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        }
        if (this.mChatonservice.getBackgroundThema() == 1) {
            getListView().setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            getListView().setSelector(C0000R.drawable.list_bg_selector_black);
        } else {
            getListView().setBackgroundResource(C0000R.color.list_bg_normal);
            getListView().setDivider(getResources().getDrawable(C0000R.drawable.list_divider));
            getListView().setSelector(C0000R.drawable.list_bg_selector);
        }
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onPause() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    private void updateAllData(String key) {
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_ANSWER_VIBRATION)) {
            this.chatonSetting.updateCallAnswerVibration();
        }
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_CALL_END_VIBRATION)) {
            this.chatonSetting.updateCallEndVibration();
        }
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_CALL_CONNECT_TONE)) {
            this.chatonSetting.updateCallConnectTone();
        }
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_MINUTE_MINDER)) {
            this.chatonSetting.updateMinuteMinder();
        }
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_CALL_END_TONE)) {
            this.chatonSetting.updateCallEndTone();
        }
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_ALERTS_ON_CALL_KEY)) {
            this.chatonSetting.updateAlertsOnCall();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences arg0, String key) {
        updateAllData(key);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getView());
        System.gc();
    }
}
