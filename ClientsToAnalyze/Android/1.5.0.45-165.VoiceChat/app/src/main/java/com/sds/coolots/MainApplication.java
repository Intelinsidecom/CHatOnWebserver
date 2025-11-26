package com.sds.coolots;

import android.content.Context;
import com.sds.coolots.call.RingtoneSettingDataInterface;
import com.sds.coolots.common.controller.ConfigInterface;
import com.sds.coolots.common.controller.EngineLoadInterface;
import com.sds.coolots.common.controller.NativeFormatInterface;
import com.sds.coolots.common.controller.NativeSettingInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.ResourceInterface;
import com.sds.coolots.common.coolotsinterface.ApkUpdateInterface;
import com.sds.coolots.common.coolotsinterface.CallIntentGeneratorInterface;
import com.sds.coolots.common.coolotsinterface.CallNotificationInterface;
import com.sds.coolots.common.coolotsinterface.CreditNotificationInterface;
import com.sds.coolots.common.coolotsinterface.DeleteAccountIntentGeneratorInterface;
import com.sds.coolots.common.coolotsinterface.FilePathInfoInterface;
import com.sds.coolots.common.coolotsinterface.IChatONInterface;
import com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface;
import com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator;
import com.sds.coolots.common.coolotsinterface.ScreenShareProcGeneratorInterface;
import com.sds.coolots.common.coolotsinterface.SettingDataInterface;
import com.sds.coolots.common.coolotsinterface.StoreUserUsageInterface;
import com.sds.coolots.common.util.PopUpCreatorInterface;
import com.sds.coolots.common.view.MainActivityInterface;

/* loaded from: classes.dex */
public class MainApplication {
    public static boolean LOGON;
    public static ApkUpdateInterface mApkUpdateInterface;
    public static CallIntentGeneratorInterface mCallIntentGenerator;
    public static CallNotificationInterface mCallNotification;
    public static IChatONInterface mChatONInterface;
    public static ConfigInterface mConfig;
    public static Context mContext;
    public static CreditNotificationInterface mCreditNotification;
    public static DeleteAccountIntentGeneratorInterface mDeleteAccountIntentGenerator;
    public static EngineLoadInterface mEngineLoader;
    public static FilePathInfoInterface mFilePathInfo;
    public static InformationActivityGeneratorInterface mInformationActivityGenerator;
    public static boolean mIsFinishInit;
    public static MainActivityInterface mMainActivity;
    public static NativeFormatInterface mNativeFormat;
    public static NativeInterfaceCreator mNativeInterfaceCreator;
    public static NativeSettingInterface mNativeSetting;
    public static PhoneManager mPhoneManager;
    public static PopUpCreatorInterface mPopupCreator;
    public static ResourceInterface mResources;
    public static RingtoneSettingDataInterface mRingtoneSettingData;
    public static ScreenShareProcGeneratorInterface mScreenShareProcGenerator;
    public static SettingDataInterface mSettingData;
    public static StoreUserUsageInterface mStoreUserUsage;
}
