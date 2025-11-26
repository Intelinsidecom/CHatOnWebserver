package com.coolots.chaton.setting.view.callsettings;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.data.ChatONSettingDataInterface;
import com.coolots.chaton.setting.view.ringtone.InterfaceRingtone;
import com.coolots.chaton.setting.view.ringtone.RadioButtonRingtoneListDialog;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.RefreshProfileAsk;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.ChangeRingtone;
import com.sds.coolots.call.model.RingtoneInfo;
import com.sds.coolots.common.controller.EngineSettingCallbackInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SettingCallSettingsFragment extends PreferenceFragment implements InterfaceRingtone, SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceClickListener, DisposeInterface, EngineSettingCallbackInterface {
    private static final String CLASSNAME = "[SettingCallSettingsFragment]";
    private static final int DIALOG_LIST_RINGTONE = 300;
    private static final int DIALOG_POWERKEY_END_ON = 100;
    private static final int DIALOG_VIDEO_CALL_QUALITY = 200;
    private static final int RINGTONE_TYPE_CHATONV_DEVICE = 2;
    private static final int RINGTONE_TYPE_DEFAULT_DEVICE = 1;
    private static final int RINGTONE_TYPE_USER_PSERSONAL = 4;
    private static final int RINGTONE_TYPE_USER_SELECTED_LIST = 3;
    private ChatOnService mChatonservice;
    ContentResolver mContentResolver;
    Context mContext;
    private Dialog mDialog;
    private CheckBox mHighQualityCheckBox;
    private CheckBox mLowQualityCheckBox;
    private RadioButtonRingtoneListDialog mRingToneListDialog;
    private String ringtoneName = null;
    private final ChatONSettingDataInterface chatonSetting = ChatONSettingData.getInstance();

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public SettingCallSettingsFragment() {
        logI("SettingCallSettingsFragment()");
    }

    public SettingCallSettingsFragment(Context context) {
        logI("SettingCallSettingsFragment(context)");
        this.mContext = context;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logI("onCreate()");
        this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            addPreferencesFromResource(C0000R.xml.link_with_chaton_call_setting_black);
        } else {
            addPreferencesFromResource(C0000R.xml.link_with_chaton_call_setting);
        }
        PreferenceScreen rejectMsgPreference = (PreferenceScreen) findPreference("pref_reject_messages_key");
        rejectMsgPreference.setOnPreferenceClickListener(this);
        PreferenceScreen ringtonePreference = (PreferenceScreen) findPreference(ChatONSettingDataInterface.PREF_RINGTONE_KEY);
        ringtonePreference.setOnPreferenceClickListener(this);
        CheckBoxPreference vibrateWhenRingingPreference = (CheckBoxPreference) findPreference(ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING);
        vibrateWhenRingingPreference.setOnPreferenceClickListener(this);
        PreferenceScreen callAnsweringEndingPreference = (PreferenceScreen) findPreference("pref_call_answering_ending_key");
        callAnsweringEndingPreference.setOnPreferenceClickListener(this);
        CheckBoxPreference proximityPreference = (CheckBoxPreference) findPreference(ChatONSettingDataInterface.PREF_PROXIMITY_KEY);
        proximityPreference.setOnPreferenceClickListener(this);
        PreferenceScreen callAlertPreference = (PreferenceScreen) findPreference("pref_call_alert_key");
        callAlertPreference.setOnPreferenceClickListener(this);
        PreferenceScreen dataUsagePreference = (PreferenceScreen) findPreference("pref_data_usage");
        dataUsagePreference.setOnPreferenceClickListener(this);
        PreferenceScreen videoCallQualityPreference = (PreferenceScreen) findPreference(ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY);
        videoCallQualityPreference.setOnPreferenceClickListener(this);
        if (!MainApplication.mConfig.isAlertWhenRinging()) {
            getPreferenceScreen().removePreference(getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING));
        }
        if (!MainApplication.mConfig.isCallAnswerHomeKey() && !MainApplication.mConfig.isBargeIn() && !MainApplication.mConfig.isCallEndPowerKey()) {
            getPreferenceScreen().removePreference(getPreferenceScreen().findPreference("pref_call_answering_ending_key"));
        }
        logI("chatonSetting.getVibrateWhenRinging() = " + this.chatonSetting.getVibrateWhenRinging() + " chatonSetting.isUseProximity() = " + this.chatonSetting.isUseProximity());
        this.mRingToneListDialog = new RadioButtonRingtoneListDialog(getResources().getString(C0000R.string.preference_3_1_5_title), 0, this);
    }

    @Override // android.app.Fragment
    public void onResume() throws IOException {
        super.onResume();
        logI("onResume()");
        updateAllData(null);
        if (this.mChatonservice == null) {
            this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        }
        if (this.mChatonservice.getBackgroundThema() == 1) {
            getListView().setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            getListView().setSelector(C0000R.drawable.list_bg_selector_black);
            getListView().setDivider(getResources().getDrawable(C0000R.drawable.list_divider_black_h));
        } else {
            getListView().setBackgroundResource(C0000R.color.list_bg_normal);
            getListView().setDivider(getResources().getDrawable(C0000R.drawable.list_divider));
            getListView().setSelector(C0000R.drawable.list_bg_selector);
        }
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        EngineInterface.getInstance().setEngineSettingCallback(this);
        getPreferenceScreen().setOnPreferenceClickListener(this);
        this.mContext = getActivity().getApplicationContext();
        putTotalDataUsage();
        updateCheckData();
    }

    private void putTotalDataUsage() {
        String totalDataUsageValue = getDataKbyte(MainApplication.mPhoneManager.getDataUsageManager().getTotalDU());
        String summary = String.valueOf(getString(C0000R.string.preference_6_2_summary, new Object[]{totalDataUsageValue})) + " Kbytes";
        findPreference("pref_data_usage").setSummary(summary);
    }

    private String getDataKbyte(long byteNum) {
        return Long.toString(changeKbyte(byteNum));
    }

    private long changeKbyte(long byteNum) {
        return byteNum / 1024;
    }

    @Override // android.app.Fragment
    public void onPause() {
        logI("onPause()");
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        EngineInterface.getInstance().setEngineSettingCallback(null);
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference_key) {
        if (preference_key == getPreferenceScreen().findPreference("pref_reject_messages_key")) {
            Intent intent = new Intent("com.coolots.chaton.USER_SETTING_SUBPAGE_REJECT_MESSAGE");
            startActivity(intent);
        } else if (preference_key == getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_RINGTONE_KEY)) {
            showDialog(300);
        } else if (preference_key != getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING)) {
            if (preference_key == getPreferenceScreen().findPreference("pref_call_answering_ending_key")) {
                Intent intent2 = new Intent("com.coolots.chaton.USER_SETTING_SUBPAGE_CALL_ANSWER");
                startActivity(intent2);
            } else if (preference_key == getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_PROXIMITY_KEY)) {
                if (this.chatonSetting.isUseCallEndPowerKey()) {
                    showDialog(100);
                }
            } else if (preference_key == getPreferenceScreen().findPreference("pref_call_alert_key")) {
                Intent intent3 = new Intent("com.coolots.chaton.USER_SETTING_SUBPAGE_CALL_ALERT");
                startActivity(intent3);
            } else if (preference_key == getPreferenceScreen().findPreference("pref_data_usage")) {
                Intent intent4 = new Intent("com.coolots.chaton.USER_SETTING_SUBPAGE_DATA_USGAE");
                startActivity(intent4);
            } else if (preference_key == getPreferenceScreen().findPreference(ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY)) {
                showDialog(200);
            }
        }
        return false;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getView());
        if (this.mRingToneListDialog != null) {
            this.mRingToneListDialog.dispose();
            this.mRingToneListDialog = null;
        }
        System.gc();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && data != null) {
            super.onActivityResult(requestCode, resultCode, data);
            logE("ringtone ActivityResult Data : " + data.getData().toString());
            Uri userRingtoneUri = Uri.parse(data.getDataString());
            handleRingtonePicked(userRingtoneUri, 1);
        }
    }

    public void handleRingtonePicked(Uri pickedUri, int ringtoneType) {
        this.mContentResolver = getActivity().getContentResolver();
        if (pickedUri == null || RingtoneManager.isDefault(pickedUri)) {
            logI("handleRingtonePicked() : Not changed");
            return;
        }
        logI("handleRingtonePicked updating media DB");
        if (pickedUri.getScheme().equals("file") && (pickedUri = updateMediaDB(pickedUri)) == null) {
            logI("handleRingtonePicked - pickedUri is null");
            return;
        }
        ContentValues values = new ContentValues();
        values.put("is_ringtone", "1");
        try {
            this.mContentResolver.update(pickedUri, values, null, null);
            logI("handleRingtonePicked - pickedUri(" + pickedUri + "), ringtoneType(" + ringtoneType + ")");
            ChatONSettingData.getInstance().setRingtoneData(4, 0, pickedUri.toString());
        } catch (Exception e) {
            logE("handleRingtonePicked(IllegalArgumentException): pickedUri is" + pickedUri.getAuthority());
        }
    }

    private Uri updateMediaDB(Uri originalUri) {
        int dotPos;
        logI("UpdateMediaDB");
        String filePath = originalUri.getPath();
        String extension = MimeTypeMap.getFileExtensionFromUrl(filePath);
        if (TextUtils.isEmpty(extension) && (dotPos = filePath.lastIndexOf(46)) >= 0) {
            extension = filePath.substring(dotPos + 1);
        }
        try {
            String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase());
            logI("updateMediaDB - extension(" + extension + "), mimeType(" + mimeType + ")");
            if (mimeType == null && extension.equals("3ga")) {
                logI("updateMediaDB - no mimeType, but it's audio file extension - " + extension);
            } else if (mimeType != null && !mimeType.startsWith(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                logI("updateMediaDB - mimeType is not audio - return null");
                return null;
            }
            File newSoundFile = new File(filePath);
            ContentValues values = new ContentValues();
            values.put("_data", newSoundFile.getAbsolutePath());
            values.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, newSoundFile.getName());
            values.put("mime_type", "audio/*");
            values.put("_size", Long.valueOf(newSoundFile.length()));
            Uri tempUri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
            this.mContentResolver.delete(tempUri, "_data=\"" + newSoundFile.getAbsolutePath() + "\"", null);
            Uri newUri = this.mContentResolver.insert(tempUri, values);
            logI("updateMediaDB - tempUri(" + tempUri + "), newUri(" + newUri + ")");
            return newUri;
        } catch (Exception e) {
            logE("updateMediaDB - exception is Occured - return null : " + e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAllData(String key) throws IOException {
        logI("updateAllData()");
        this.mContext = getActivity().getApplicationContext();
        if (!ModelInfoUtil.IS_MODEL_SCAMERA) {
            if (key == null || key.equals(ChatONSettingDataInterface.PREF_PROXIMITY_KEY)) {
                this.chatonSetting.updateUseProximity();
                this.chatonSetting.updateCallEndPowerKey();
            }
            if (key == null || key.equals(ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY)) {
                this.chatonSetting.updateVideoCallQuality();
            }
            if (key == null || key.equals(ChatONSettingDataInterface.PREF_RINGTONE_KEY)) {
                updateTextRingtoneData();
            }
            if (key == null || key.equals(ChatONSettingDataInterface.PREF_DRIVING_MODE_KEY)) {
                this.chatonSetting.updateUseDrivingMode();
            }
            if (key == null || key.equals(ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING)) {
                this.chatonSetting.updateVibrateWhenRinging();
            }
            updateTextData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckData() {
        setCheckBox(ChatONSettingDataInterface.PREF_PROXIMITY_KEY, this.chatonSetting.isUseProximity());
        if (MainApplication.mConfig.isAlertWhenRinging()) {
            setCheckBox(ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING, this.chatonSetting.getVibrateWhenRinging());
        }
    }

    private void setCheckBox(String key, boolean value) {
        CheckBoxPreference prefCheckBox = (CheckBoxPreference) findPreference(key);
        prefCheckBox.setChecked(value);
    }

    private void updateTextData() {
        PreferenceScreen prefScreen = (PreferenceScreen) findPreference(ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY);
        if (this.chatonSetting.isUseHighQuality()) {
            prefScreen.setSummary(C0000R.string.high_quality);
        } else {
            prefScreen.setSummary(C0000R.string.low_quality);
        }
    }

    public void updateTextRingtoneData() throws IOException {
        PreferenceScreen prefScreenRingtone = (PreferenceScreen) findPreference(ChatONSettingDataInterface.PREF_RINGTONE_KEY);
        Log.m2967v("mhc-updateTextRingtoneData");
        RingtoneInfo mRingtoneInfo = new RingtoneInfo(ChatONSettingData.getInstance().getRingtoneData());
        switch (mRingtoneInfo.getType()) {
            case 1:
            case 2:
                this.ringtoneName = (String) getResources().getText(C0000R.string.ringtone_default_name);
                break;
            case 3:
                if (mRingtoneInfo.getIndex() == -1) {
                    this.ringtoneName = (String) getResources().getText(C0000R.string.ringtone_silent);
                    break;
                } else {
                    ArrayList<String> totalList = ChangeRingtone.getRingtoneList();
                    String tempRingtoneName = getRingtoneTitle(mRingtoneInfo.getIndex());
                    this.ringtoneName = (String) getResources().getText(C0000R.string.ringtone_default_name);
                    for (int i = 0; i < totalList.size(); i++) {
                        if (tempRingtoneName.equals(totalList.get(i).toString())) {
                            this.ringtoneName = tempRingtoneName;
                        }
                    }
                    break;
                }
            case 4:
                this.ringtoneName = getRingtoneTitle(mRingtoneInfo.getPath());
                break;
            default:
                this.ringtoneName = (String) getResources().getText(C0000R.string.ringtone_default_name);
                break;
        }
        prefScreenRingtone.setSummary(this.ringtoneName);
        logI("RingtoneName - type : " + mRingtoneInfo.getType() + ", " + this.ringtoneName);
    }

    private String getRingtoneTitle(int ringtoneIndex) {
        logI("getRingtoneTitle : " + ringtoneIndex);
        RingtoneManager mRingtoneManager = new RingtoneManager(MainApplication.mContext.getApplicationContext());
        mRingtoneManager.setType(1);
        mRingtoneManager.setIncludeDrm(true);
        mRingtoneManager.getCursor();
        return mRingtoneManager.getRingtone(ringtoneIndex).getTitle(this.mContext);
    }

    private String getRingtoneTitle(String ringtoneUri) {
        Uri uri = Uri.parse(ringtoneUri);
        if (RingtoneManager.getRingtone(this.mContext, uri) != null) {
            logI("getRingtoneTitle - getTitle : " + RingtoneManager.getRingtone(this.mContext, uri).getTitle(this.mContext));
            return RingtoneManager.getRingtone(this.mContext, uri).getTitle(this.mContext);
        }
        logI("getRingtoneTitle - null!!! >> setRingtoneData : ChatON V Default Ringtone");
        ChatONSettingData.getInstance().setRingtoneData(2, 0, null);
        return (String) getResources().getText(C0000R.string.ringtone_default_name);
    }

    private void showDialog(int type) {
        switch (type) {
            case 100:
                ChatONDialog.Builder dialog = new ChatONDialog.Builder(getActivity());
                dialog.setTitle(getString(C0000R.string.information_str_title_1));
                dialog.setMessage(getString(C0000R.string.proximity_pop_up));
                dialog.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.callsettings.SettingCallSettingsFragment.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog2, int whichButton) {
                        boolean isUseProximity = SettingCallSettingsFragment.this.chatonSetting.isUseProximity();
                        SettingCallSettingsFragment.this.chatonSetting.setUseProximity(isUseProximity);
                    }
                });
                dialog.setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.callsettings.SettingCallSettingsFragment.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog2, int whichButton) {
                        boolean isUseProximity = SettingCallSettingsFragment.this.chatonSetting.isUseProximity();
                        SettingCallSettingsFragment.this.chatonSetting.setUseProximity(!isUseProximity);
                        SettingCallSettingsFragment.this.chatonSetting.setCallEndPowerKey(isUseProximity ? false : true);
                        SettingCallSettingsFragment.this.updateCheckData();
                        dialog2.dismiss();
                    }
                });
                dialog.setCancelable(true);
                dialog.create().show();
                break;
            case 200:
                LayoutInflater layout = getActivity().getLayoutInflater();
                View view = layout.inflate(C0000R.layout.video_call_quality_dialog_layout, (ViewGroup) null);
                LinearLayout layout_high = (LinearLayout) view.findViewById(C0000R.id.high_quality_layout);
                LinearLayout layout_low = (LinearLayout) view.findViewById(C0000R.id.low_quality_layout);
                View.OnClickListener layoutClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.callsettings.SettingCallSettingsFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case C0000R.id.high_quality_layout /* 2131493478 */:
                                SettingCallSettingsFragment.this.mHighQualityCheckBox.setChecked(true);
                                SettingCallSettingsFragment.this.mLowQualityCheckBox.setChecked(false);
                                break;
                            case C0000R.id.low_quality_layout /* 2131493480 */:
                                SettingCallSettingsFragment.this.mHighQualityCheckBox.setChecked(false);
                                SettingCallSettingsFragment.this.mLowQualityCheckBox.setChecked(true);
                                break;
                        }
                    }
                };
                layout_high.setOnClickListener(layoutClickListener);
                layout_low.setOnClickListener(layoutClickListener);
                this.mHighQualityCheckBox = (CheckBox) view.findViewById(C0000R.id.radio_btn1);
                this.mLowQualityCheckBox = (CheckBox) view.findViewById(C0000R.id.radio_btn2);
                if (this.chatonSetting.isUseHighQuality()) {
                    this.mHighQualityCheckBox.setChecked(true);
                    this.mLowQualityCheckBox.setChecked(false);
                } else {
                    this.mHighQualityCheckBox.setChecked(false);
                    this.mLowQualityCheckBox.setChecked(true);
                }
                this.mDialog = new ChatONDialog.Builder(getActivity()).setTitle(C0000R.string.preference_5_4_title).setPositiveButton(C0000R.string.ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.callsettings.SettingCallSettingsFragment.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog2, int which) throws IOException {
                        if (SettingCallSettingsFragment.this.mLowQualityCheckBox.isChecked()) {
                            SettingCallSettingsFragment.this.chatonSetting.setVideoCallQuality(false);
                        }
                        if (SettingCallSettingsFragment.this.mHighQualityCheckBox.isChecked()) {
                            SettingCallSettingsFragment.this.chatonSetting.setVideoCallQuality(true);
                        }
                        dialog2.dismiss();
                        SettingCallSettingsFragment.this.updateAllData(ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY);
                    }
                }).setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.callsettings.SettingCallSettingsFragment.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog2, int which) {
                        dialog2.dismiss();
                    }
                }).setView(view).create();
                this.mDialog.setCancelable(true);
                this.mDialog.show();
                break;
            case 300:
                this.mRingToneListDialog.setRingToneName(this.ringtoneName);
                this.mRingToneListDialog.show(getFragmentManager().beginTransaction(), "ringtonedialog");
                break;
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences arg0, String key) throws IOException {
        logI("onSharedPreferenceChanged() key: " + key);
        updateAllData(key);
    }

    @Override // com.sds.coolots.common.controller.EngineSettingCallbackInterface
    public boolean handleContactMessage(MsgBody msgBody) {
        logI("handleContactMessage()");
        if (msgBody instanceof RefreshProfileAsk) {
            logI("RefreshProfileAsk");
            ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager().handleRefreshProfileAsk((RefreshProfileAsk) msgBody);
            return false;
        }
        return false;
    }

    @Override // com.coolots.chaton.setting.view.ringtone.InterfaceRingtone
    public void lauchRingtoneList() {
        Intent ringtonePickerIntent = new Intent("android.intent.action.GET_CONTENT");
        ringtonePickerIntent.setType("audio/*");
        startActivityForResult(ringtonePickerIntent, 5);
    }
}
