package com.coolots.chaton.setting.view.datausage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingDataInterface;
import com.coolots.chaton.setting.view.datausage.DataUsageInfoManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.calllog.model.CallDataUsage;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SettingDataUsageFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener, DisposeInterface {
    private static final String CLASSNAME = "[ChatONSettingMainFragment]";
    private ChatOnService mChatonservice;
    private TextView mDataUsage;
    private long mEndPeriodTime;
    private boolean mIsWifi;
    private long mStartPeriodTime;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mChatonservice == null) {
            this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        }
        if (this.mChatonservice.getBackgroundThema() == 1) {
            getListView().setBackgroundResource(C0000R.color.tw_light_color001);
            getListView().setSelector(C0000R.color.tw_light_color001);
        } else {
            getListView().setBackgroundResource(C0000R.color.list_bg_normal);
            getListView().setDivider(getResources().getDrawable(C0000R.drawable.list_divider));
            getListView().setSelector(C0000R.color.list_bg_normal);
        }
        updateAllData(null);
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        this.mDataUsage = (TextView) getActivity().findViewById(C0000R.id.data_usage_cycle_name);
        this.mDataUsage.setSelected(true);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            addPreferencesFromResource(C0000R.xml.setting_data_usage_black);
        } else {
            addPreferencesFromResource(C0000R.xml.setting_data_usage);
        }
        this.mDataUsage = (TextView) getActivity().findViewById(C0000R.id.data_usage_cycle_name);
        this.mDataUsage.setSelected(true);
    }

    public void updateAllData(String key) {
        if (key == null || key.equals(ChatONSettingDataInterface.PREF_DATA_USAGE_KEY)) {
            updateDataSummary();
        }
    }

    private void updateDataSummary() {
        long j = 2592000 * 1000;
        CallDataUsage dataUsage = DataUsageInfoManager.getCallDataUsage(this.mStartPeriodTime, this.mEndPeriodTime, this.mIsWifi);
        if (dataUsage != null) {
            String lastVoice = getDataKbyte(dataUsage.getLastVoiceDU());
            String lastVideo = getDataKbyte(dataUsage.getLastVideoDU());
            String dialVoice = getDataKbyte(dataUsage.getDialledVoiceDU());
            String dialVideo = getDataKbyte(dataUsage.getDialledVideoDU());
            String receiveVoice = getDataKbyte(dataUsage.getRecvVoiceDU());
            String receiveVideo = getDataKbyte(dataUsage.getRecvVideoDU());
            String allVoice = getDataKbyte(dataUsage.getDialledVoiceDU() + dataUsage.getRecvVoiceDU());
            String allVideo = getDataKbyte(dataUsage.getDialledVideoDU() + dataUsage.getRecvVideoDU());
            Map<String, String> dataInfo = new HashMap<>();
            dataInfo.put(ChatONSettingDataInterface.PREF_LAST_VOICE_KEY, lastVoice);
            dataInfo.put(ChatONSettingDataInterface.PREF_LAST_VIDEO_KEY, lastVideo);
            dataInfo.put(ChatONSettingDataInterface.PREF_DIAL_VOICE_KEY, dialVoice);
            dataInfo.put(ChatONSettingDataInterface.PREF_DIAL_VIDEO_KEY, dialVideo);
            dataInfo.put(ChatONSettingDataInterface.PREF_RECEIVE_VOICE_KEY, receiveVoice);
            dataInfo.put(ChatONSettingDataInterface.PREF_RECEIVE_VIDEO_KEY, receiveVideo);
            dataInfo.put(ChatONSettingDataInterface.PREF_ALL_VOICE_KEY, allVoice);
            dataInfo.put(ChatONSettingDataInterface.PREF_ALL_VIDEO_KEY, allVideo);
            for (String key : dataInfo.keySet()) {
                String summary = dataInfo.get(key);
                setPreferenceScreenSummary(key, summary);
            }
        }
    }

    public void setFrgmentPeoriod(DataUsageInfoManager.CycleTimeData cycleTimeData) {
        this.mStartPeriodTime = getLongTimeWithDay(cycleTimeData.startYear, cycleTimeData.startMon, cycleTimeData.startDay);
        this.mEndPeriodTime = getLongTimeWithDay(cycleTimeData.endYear, cycleTimeData.endMon, cycleTimeData.endDay);
    }

    private long getLongTimeWithDay(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        long time = cal.getTime().getTime();
        return time;
    }

    private void setPreferenceScreenSummary(String key, String summary) {
        PreferenceScreen prefScreen;
        if (key != null && !key.isEmpty() && (prefScreen = (PreferenceScreen) getPreferenceScreen().findPreference(key)) != null && summary != null && !summary.isEmpty()) {
            prefScreen.setSummary(String.valueOf(summary) + " Kbytes");
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences arg0, String key) {
        updateAllData(key);
    }

    @Override // android.app.Fragment
    public void onPause() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
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

    public void setIsWifi(boolean flag) {
        this.mIsWifi = flag;
    }

    private String getDataKbyte(long byteNum) {
        return Long.toString(changeKbyte(byteNum));
    }

    private long changeKbyte(long byteNum) {
        return byteNum / 1024;
    }
}
