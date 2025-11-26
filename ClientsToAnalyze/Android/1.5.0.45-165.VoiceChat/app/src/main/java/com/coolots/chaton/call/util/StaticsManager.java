package com.coolots.chaton.call.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import com.coolots.chaton.join.adaptor.StoreUserUsageAdaptor;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.StoreUserUsageAsk;
import com.coolots.p2pmsg.model.StoreUserUsageRep;
import com.coolots.p2pmsg.model.UsageInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.coolotsinterface.StoreUserUsageInterface;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class StaticsManager implements StoreUserUsageInterface {
    private static final String COUNT_FUNEFFECTS_ANIMATED_EMOTION = "CFE_000003";
    private static final String COUNT_FUNEFFECTS_CARTOONVIEW = "CFE_000001";
    private static final String COUNT_FUNEFFECTS_THEMEVIEW = "CFE_000002";
    private static final String COUNT_SHAREEFFECTS_SHARECAMERA = "CSE_000002";
    private static final String COUNT_SHAREEFFECTS_SHARESCREEN = "CSE_000001";
    private static final String PREF_FUNEFFECTS_ANIMATED_EMOTION = "pref_funeffects_animatedemotion";
    private static final String PREF_FUNEFFECTS_CARTOONVIEW = "pref_funeffects_cartoonview";
    private static final String PREF_FUNEFFECTS_THEMEVIEW = "pref_funeffects_themeview";
    private static final String PREF_SHAREEFFECTS_SHARECAMERA = "pref_shareeffects_sharecamera";
    private static final String PREF_SHAREEFFECTS_SHARESCREEN = "pref_shareeffects_sharescreen";
    private static StaticsManager instance = new StaticsManager();
    public static Context mContext;
    private StoreUserUsageHandler mHandler;
    private boolean mFunEffectsCartoonViewFlag = false;
    private boolean mFunEffectsThemeViewFlag = false;
    private boolean mFunEffectsAnimatedEmotionsFlag = false;
    private boolean mShareEffectsShareScreenFlag = false;
    private boolean mShareEffectsShareCameraFlag = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i("[StaticsManager]" + message);
    }

    private StaticsManager() {
        Log.m2963i("[StaticsManager] new Instance");
    }

    public static StaticsManager getInstance() {
        return instance;
    }

    public void initBeforeCallStart() {
        this.mFunEffectsCartoonViewFlag = false;
        this.mFunEffectsThemeViewFlag = false;
        this.mFunEffectsAnimatedEmotionsFlag = false;
        this.mShareEffectsShareScreenFlag = false;
        this.mShareEffectsShareCameraFlag = false;
    }

    public void setFunEffectsCartoonViewFlag() {
        this.mFunEffectsCartoonViewFlag = true;
    }

    public void setFunEffectsThemeViewFlag() {
        this.mFunEffectsThemeViewFlag = true;
    }

    public void setFunEffectsAnimatedEmotionFlag() {
        this.mFunEffectsAnimatedEmotionsFlag = true;
    }

    public void setShareEffectsShareScreenFlag() {
        this.mShareEffectsShareScreenFlag = true;
    }

    public void setShareEffectsShareCameraFlag() {
        this.mShareEffectsShareCameraFlag = true;
    }

    public void saveVideoFunctionFlags() {
        if (this.mFunEffectsCartoonViewFlag) {
            int value = getIntSharedPreference(PREF_FUNEFFECTS_CARTOONVIEW) + 1;
            putSharedPreference(PREF_FUNEFFECTS_CARTOONVIEW, value);
        }
        if (this.mFunEffectsThemeViewFlag) {
            int value2 = getIntSharedPreference(PREF_FUNEFFECTS_THEMEVIEW) + 1;
            putSharedPreference(PREF_FUNEFFECTS_THEMEVIEW, value2);
        }
        if (this.mFunEffectsAnimatedEmotionsFlag) {
            int value3 = getIntSharedPreference(PREF_FUNEFFECTS_ANIMATED_EMOTION) + 1;
            putSharedPreference(PREF_FUNEFFECTS_ANIMATED_EMOTION, value3);
        }
        if (this.mShareEffectsShareScreenFlag) {
            int value4 = getIntSharedPreference(PREF_SHAREEFFECTS_SHARESCREEN) + 1;
            putSharedPreference(PREF_SHAREEFFECTS_SHARESCREEN, value4);
        }
        if (this.mShareEffectsShareCameraFlag) {
            int value5 = getIntSharedPreference(PREF_SHAREEFFECTS_SHARECAMERA) + 1;
            putSharedPreference(PREF_SHAREEFFECTS_SHARECAMERA, value5);
        }
        sendToServerStaticsData();
    }

    public int getCartoonViewFlags() {
        return getIntSharedPreference(PREF_FUNEFFECTS_CARTOONVIEW);
    }

    public int getThemeViewFlags() {
        return getIntSharedPreference(PREF_FUNEFFECTS_THEMEVIEW);
    }

    public int getAnimatedEmotionsFlags() {
        return getIntSharedPreference(PREF_FUNEFFECTS_ANIMATED_EMOTION);
    }

    public int getShareScreenFlags() {
        return getIntSharedPreference(PREF_SHAREEFFECTS_SHARESCREEN);
    }

    public int getShareCameraFlags() {
        return getIntSharedPreference(PREF_SHAREEFFECTS_SHARECAMERA);
    }

    private void putSharedPreference(String key, int value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
        logI("putSharedPreference: key: " + key + ", value: " + value);
    }

    private int getIntSharedPreference(String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        int value = prefs.getInt(key, 0);
        logI("getIntSharedPreference: key: " + key + ", value: " + value);
        return value;
    }

    @Override // com.sds.coolots.common.coolotsinterface.StoreUserUsageInterface
    public void sendToServerStaticsData() {
        logI("sendToServerStaticsData");
        this.mHandler = new StoreUserUsageHandler(this, null);
        StoreUserUsageAsk ask = new StoreUserUsageAsk();
        List<UsageInfo> usageInfoList = new ArrayList<>();
        usageInfoList.add(new UsageInfo(COUNT_FUNEFFECTS_CARTOONVIEW, getIntSharedPreference(PREF_FUNEFFECTS_CARTOONVIEW)));
        usageInfoList.add(new UsageInfo(COUNT_FUNEFFECTS_THEMEVIEW, getIntSharedPreference(PREF_FUNEFFECTS_THEMEVIEW)));
        usageInfoList.add(new UsageInfo(COUNT_FUNEFFECTS_ANIMATED_EMOTION, getIntSharedPreference(PREF_FUNEFFECTS_ANIMATED_EMOTION)));
        usageInfoList.add(new UsageInfo(COUNT_SHAREEFFECTS_SHARESCREEN, getIntSharedPreference(PREF_SHAREEFFECTS_SHARESCREEN)));
        usageInfoList.add(new UsageInfo(COUNT_SHAREEFFECTS_SHARECAMERA, getIntSharedPreference(PREF_SHAREEFFECTS_SHARECAMERA)));
        ask.setUsageInfoList(usageInfoList);
        StoreUserUsageAdaptor adaptor = new StoreUserUsageAdaptor(ask, this.mHandler);
        if (getIntSharedPreference(PREF_FUNEFFECTS_CARTOONVIEW) == 1 || getIntSharedPreference(PREF_FUNEFFECTS_ANIMATED_EMOTION) == 1 || getIntSharedPreference(PREF_FUNEFFECTS_THEMEVIEW) == 1 || getIntSharedPreference(PREF_SHAREEFFECTS_SHARECAMERA) == 1 || getIntSharedPreference(PREF_SHAREEFFECTS_SHARESCREEN) == 1) {
            adaptor.start();
        }
    }

    private class StoreUserUsageHandler extends Handler {
        private StoreUserUsageHandler() {
        }

        /* synthetic */ StoreUserUsageHandler(StaticsManager staticsManager, StoreUserUsageHandler storeUserUsageHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            StaticsManager.this.logI("StoreUserUsageHandler()");
            if (msg.what == MessageInfo.StoreUserUsageAsk.getDispatchCode() && msg.arg1 == 0 && (msg.obj instanceof StoreUserUsageRep)) {
                StaticsManager.this.clearSavedData();
            }
            super.handleMessage(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSavedData() {
        logI("clearSavedData()");
        putSharedPreference(PREF_FUNEFFECTS_CARTOONVIEW, 0);
        putSharedPreference(PREF_FUNEFFECTS_ANIMATED_EMOTION, 0);
        putSharedPreference(PREF_FUNEFFECTS_THEMEVIEW, 0);
        putSharedPreference(PREF_SHAREEFFECTS_SHARECAMERA, 0);
        putSharedPreference(PREF_SHAREEFFECTS_SHARESCREEN, 0);
    }
}
