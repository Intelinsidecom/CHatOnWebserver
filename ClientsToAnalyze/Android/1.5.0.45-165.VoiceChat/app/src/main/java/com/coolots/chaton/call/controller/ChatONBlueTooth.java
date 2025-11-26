package com.coolots.chaton.call.controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IVoIPInterface;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.telephony.ITelephonyExt;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface;
import com.sds.coolots.common.util.Log;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONBlueTooth implements BlueToothControllerInterface {
    public static final String BR_ACTION_AUDIO_STATE = "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED";
    public static final String BR_ACTION_CONNECTION = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    private static final String CLASSNAME = "[ChatONBlueTooth]";
    private static final boolean IS_BT_USE = true;
    public static final String TYPE_DEVICE_WATCH_STRING = "WA";
    private BluetoothDevice device;
    private BluetoothAdapter mAdapter;
    private BluetoothHeadset mBluetoothHeadset;
    private int mBluetoothHeadsetAudioState;
    private int mBluetoothHeadsetState;
    private boolean mConnectBlueTooth;
    private ITelephonyExt mITelephonyExtInterface;
    private IVoIPInterface mIVoIPInterface;
    private boolean mIsBTFunctionUse;
    private BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() { // from class: com.coolots.chaton.call.controller.ChatONBlueTooth.1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            ChatONBlueTooth.this.mBluetoothHeadset = (BluetoothHeadset) proxy;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int profile) {
            ChatONBlueTooth.this.mBluetoothHeadset = null;
        }
    };
    private boolean mUseBlueTooth;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ChatONBlueTooth() {
        this.mIVoIPInterface = null;
        this.mITelephonyExtInterface = null;
        this.mIsBTFunctionUse = true;
        if (this.mIVoIPInterface == null) {
            this.mIVoIPInterface = IVoIPInterface.Stub.asInterface(ServiceManager.checkService("voip"));
        }
        if (this.mIVoIPInterface == null) {
            logE("<<YHT4>> mIVoIPInterface is null");
            this.mIsBTFunctionUse = false;
        }
        if (this.mITelephonyExtInterface == null) {
            this.mITelephonyExtInterface = ITelephonyExt.Stub.asInterface(ServiceManager.checkService("phoneext"));
        }
        if (this.mITelephonyExtInterface == null) {
            logE("<<YHT4>> mITelephonyExtInterface is null");
            this.mIsBTFunctionUse = false;
        }
        this.mConnectBlueTooth = false;
        this.mUseBlueTooth = false;
        this.mBluetoothHeadsetState = 0;
        this.mBluetoothHeadsetAudioState = 10;
        if (Build.VERSION.SDK_INT >= 18) {
            this.mAdapter = BluetoothAdapter.getDefaultAdapter();
            this.mAdapter.getProfileProxy(MainApplication.mContext, this.mProfileListener, 1);
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isWatch() {
        if (Build.VERSION.SDK_INT >= 18 && this.mBluetoothHeadset != null) {
            List<BluetoothDevice> deviceList = this.mBluetoothHeadset.getConnectedDevices();
            if (deviceList.size() == 1) {
                Iterator i = deviceList.iterator();
                while (i.hasNext()) {
                    this.device = i.next();
                    String type = this.mBluetoothHeadset.getSamsungHandsfreeDeviceType(this.device);
                    logI("WATCH_AUDIO " + type);
                    if (TYPE_DEVICE_WATCH_STRING.equals(type)) {
                        logI("WATCH_AUDIO BT Device is Watch");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isInstalledWatchApp() {
        return isInstalled(MainApplication.mContext, "com.samsung.appcessory.chatonw.providerforcanada") || isInstalled(MainApplication.mContext, "com.samsung.appcessory.chatonw.provider");
    }

    private boolean isInstalled(Context context, String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getApplicationInfo(packageName, 128);
            logI(String.valueOf(packageName) + "isInstalled() true");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            logI(String.valueOf(packageName) + "isInstalled() false");
            return false;
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public void findBlueToothState() {
        if (this.mIsBTFunctionUse) {
            logE("findBlueToothState()");
            this.mConnectBlueTooth = false;
            try {
                if (this.mIVoIPInterface.canUseBTInVoIP(MainApplication.mContext.getApplicationInfo().packageName)) {
                    logE("mIVoIPInterface.canUseBTInVoIP() return true");
                    if (this.mITelephonyExtInterface.isHeadsetConnected()) {
                        logI("BlueTooth is connected!");
                        this.mConnectBlueTooth = true;
                        this.mBluetoothHeadsetState = 2;
                    }
                }
            } catch (Exception e) {
                logE("<<YHT4>> FAIL TO findBlueToothState!!");
                e.printStackTrace();
            } catch (NoSuchMethodError e2) {
                logE("<<YHT4>> FAIL TO findBlueToothState!! No Such Method Error");
                e2.printStackTrace();
            }
        }
    }

    public static Intent getBlueToothSettingPageIntent() {
        Intent intent = new Intent("android.bluetooth.devicepicker.action.LAUNCH");
        intent.putExtra("android.bluetooth.devicepicker.extra.NEED_AUTH", true);
        intent.putExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 5);
        intent.putExtra("android.bluetooth.FromHeadsetActivity", true);
        return intent;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public void setBlueToothState(boolean useBlueTooth) {
        if (this.mIsBTFunctionUse) {
            logI("setBlueToothState(" + useBlueTooth + ")");
            if (!this.mConnectBlueTooth) {
                this.mUseBlueTooth = false;
                return;
            }
            try {
                this.mIVoIPInterface.setBTUserWantsAudioOn(useBlueTooth);
                this.mUseBlueTooth = useBlueTooth;
                logE("mIVoIPInterface.setBTUserWantsAudioOn(" + useBlueTooth + ")");
            } catch (RemoteException e) {
                logE("RemoteException");
                e.printStackTrace();
            } catch (NoSuchMethodError e2) {
                logE("NoSuchMethodError");
                e2.printStackTrace();
            }
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isBlueToothStateDisconnected() {
        logI("isBlueToothStateDisconnected() " + (this.mBluetoothHeadsetState == 0));
        return this.mBluetoothHeadsetState == 0;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isBlueToothStateConnected() {
        logI("isBlueToothStateConnected() " + (this.mBluetoothHeadsetState == 2));
        return this.mBluetoothHeadsetState == 2;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isBlueToothAudioStateDisconnected() {
        logI("isBlueToothAudioStateDisconnected() " + (this.mBluetoothHeadsetAudioState == 10));
        return this.mBluetoothHeadsetAudioState == 10;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isBlueToothAudioStateConnected() {
        logI("isBlueToothAudioStateConnected() " + (this.mBluetoothHeadsetAudioState == 12));
        return this.mBluetoothHeadsetAudioState == 12;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public void addAction(IntentFilter intentFilter) {
        if (this.mIsBTFunctionUse) {
            intentFilter.addAction(BR_ACTION_CONNECTION);
            intentFilter.addAction(BR_ACTION_AUDIO_STATE);
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public int checkBRAction(Intent intent) {
        if (!this.mIsBTFunctionUse) {
            return 0;
        }
        String action = intent.getAction();
        if (action.equals(BR_ACTION_CONNECTION)) {
            this.mBluetoothHeadsetState = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            logI("mBluetoothHeadsetState = " + this.mBluetoothHeadsetState);
            if (this.mBluetoothHeadsetState == 2) {
                logI("BluetoothHeadset.STATE_CONNECTED");
                this.mConnectBlueTooth = true;
                this.mUseBlueTooth = false;
                return 1;
            }
            if (this.mBluetoothHeadsetState != 0) {
                return 0;
            }
            logI("BluetoothHeadset.STATE_DISCONNECTED");
            this.mConnectBlueTooth = false;
            this.mUseBlueTooth = false;
            return 2;
        }
        if (!action.equals(BR_ACTION_AUDIO_STATE)) {
            return 0;
        }
        this.mBluetoothHeadsetAudioState = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
        logI("mBluetoothHeadsetAudioState = " + this.mBluetoothHeadsetAudioState);
        if (this.mBluetoothHeadsetAudioState == 12) {
            logI("BluetoothHeadset.STATE_AUDIO_CONNECTED");
            this.mConnectBlueTooth = true;
            this.mUseBlueTooth = true;
            return 3;
        }
        if (this.mBluetoothHeadsetAudioState != 10) {
            return 0;
        }
        logI("BluetoothHeadset.STATE_AUDIO_DISCONNECTED");
        this.mUseBlueTooth = false;
        return 4;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isConnectBlueTooth() {
        return this.mConnectBlueTooth;
    }

    @Override // com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface
    public boolean isUseBlueTooth() {
        return this.mUseBlueTooth;
    }
}
