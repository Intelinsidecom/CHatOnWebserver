package com.coolots.chaton.setting.view.callanswer;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.controller.BargeInController;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.data.ChatONSettingDataInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class SettingCallAnswerFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener, DisposeInterface, Preference.OnPreferenceClickListener {
    private static final String CLASSNAME = "[SettingCallAnswerFragment]";
    private static final int DIALOG_PROXIMITY_ON = 100;
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
            addPreferencesFromResource(C0000R.xml.setting_call_answer_black);
        } else {
            addPreferencesFromResource(C0000R.xml.setting_call_answer);
        }
        if (MainApplication.mConfig.isCallAnswerHomeKey()) {
            CheckBoxPreference callAnswerHomeKeyPreference = (CheckBoxPreference) findPreference(ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY);
            callAnswerHomeKeyPreference.setOnPreferenceClickListener(this);
        }
        if (MainApplication.mConfig.isBargeIn()) {
            CheckBoxPreference voiceInputContrlPreference = (CheckBoxPreference) findPreference("voice_input_control");
            voiceInputContrlPreference.setOnPreferenceClickListener(this);
        }
        if (MainApplication.mConfig.isCallEndPowerKey()) {
            CheckBoxPreference callEndPowerKeyPreference = (CheckBoxPreference) findPreference(ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY);
            callEndPowerKeyPreference.setOnPreferenceClickListener(this);
        }
        if (!MainApplication.mConfig.isCallAnswerHomeKey()) {
            getPreferenceScreen().removePreference(getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY));
        }
        if (!MainApplication.mConfig.isBargeIn()) {
            getPreferenceScreen().removePreference(getPreferenceScreen().findPreference("voice_input_control"));
        }
        if (!MainApplication.mConfig.isCallEndPowerKey()) {
            getPreferenceScreen().removePreference(getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY));
        }
        setRetainInstance(true);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        updateAllData(null);
        if (this.mChatonservice == null) {
            this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        }
        if (this.mChatonservice.getBackgroundThema() == 1) {
            getListView().setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            getListView().setSelector(C0000R.drawable.list_bg_selector_black);
            getListView().setDividerHeight(1);
        } else {
            getListView().setBackgroundColor(getResources().getColor(C0000R.color.list_bg_normal));
            getListView().setDivider(getResources().getDrawable(C0000R.drawable.list_divider));
            getListView().setSelector(C0000R.drawable.list_bg_selector);
        }
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference_key) {
        if (preference_key != getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY)) {
            if (preference_key == getPreferenceScreen().findPreference("voice_input_control")) {
                if (BargeInController.getApplicationVoiceInputControlValue(getActivity())) {
                    BargeInController.setIncomingcallsviaChatOnV(getActivity(), !BargeInController.getIncomingcallsviaChatOnV(getActivity()));
                } else {
                    try {
                        Intent intent = new Intent("android.intent.action.VOICE_SETTING_BARGEIN");
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        logI("This device doesn't support voice control in ChatON V: " + e.getMessage());
                    }
                }
                updateAllData(null);
            } else if (preference_key == getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY) && !this.chatonSetting.isUseProximity()) {
                showDialog(100);
            }
        }
        return false;
    }

    protected void showDialog(int id) {
        switch (id) {
            case 100:
                ChatONDialog.Builder dialog = new ChatONDialog.Builder(getActivity());
                dialog.setTitle(getString(C0000R.string.information_str_title_1));
                dialog.setMessage(getString(C0000R.string.power_key_pop_up));
                dialog.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.callanswer.SettingCallAnswerFragment.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog2, int whichButton) {
                        boolean isUseCallEndPowerKey = SettingCallAnswerFragment.this.chatonSetting.isUseCallEndPowerKey();
                        SettingCallAnswerFragment.this.chatonSetting.setUseProximity(isUseCallEndPowerKey);
                    }
                });
                dialog.setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.callanswer.SettingCallAnswerFragment.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog2, int whichButton) {
                        boolean isUseCallEndPowerKey = SettingCallAnswerFragment.this.chatonSetting.isUseCallEndPowerKey();
                        SettingCallAnswerFragment.this.chatonSetting.setCallEndPowerKey(!isUseCallEndPowerKey);
                        SettingCallAnswerFragment.this.chatonSetting.setUseProximity(isUseCallEndPowerKey ? false : true);
                        SettingCallAnswerFragment.this.updateCheckData();
                        dialog2.dismiss();
                    }
                });
                dialog.setCancelable(true);
                dialog.create().show();
                break;
        }
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

    private void updateAllData(String key) {
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY)) {
            this.chatonSetting.updateCallAnswerHomeKey();
        }
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY)) {
            this.chatonSetting.updateCallEndPowerKey();
            this.chatonSetting.updateUseProximity();
        }
        updateCheckData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckData() {
        if (MainApplication.mConfig.isCallAnswerHomeKey()) {
            setCheckBox(ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY, this.chatonSetting.isUseCallAnswerHomeKey());
        }
        if (MainApplication.mConfig.isCallEndPowerKey()) {
            setCheckBox(ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY, this.chatonSetting.isUseCallEndPowerKey());
        }
        if (MainApplication.mConfig.isBargeIn()) {
            setCheckBox("voice_input_control", BargeInController.getApplicationVoiceInputControlValue(getActivity()) && BargeInController.getIncomingcallsviaChatOnV(getActivity()));
        }
    }

    private void setCheckBox(String key, boolean value) {
        CheckBoxPreference prefCheckBox = (CheckBoxPreference) findPreference(key);
        prefCheckBox.setChecked(value);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences arg0, String key) {
        updateAllData(key);
    }
}
