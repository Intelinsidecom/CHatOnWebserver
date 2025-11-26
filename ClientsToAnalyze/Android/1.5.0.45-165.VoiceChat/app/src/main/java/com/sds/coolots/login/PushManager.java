package com.sds.coolots.login;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.model.StoreEPInfoAsk;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.PushReceiveInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.adaptor.C1274f;
import com.sds.coolots.login.model.C1286e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class PushManager implements PushManagerInterface {

    /* renamed from: b */
    private static final int f3158b = -1;

    /* renamed from: c */
    private static final int f3159c = -2;
    protected PushReceiveInterface mCallback;
    protected short mDeviceID;
    protected String mPushType;
    protected String mRegistCode;
    protected boolean mRegistState;
    protected String mUserID;
    protected ArrayList mListReceivedMsg = new ArrayList();

    /* renamed from: a */
    private final Object f3160a = new Object();

    /* renamed from: d */
    private final Handler f3161d = new HandlerC1281g(this, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3029a() {
        if (!PhoneManager.isNetworkConnected(MainApplication.mContext) || MainApplication.mConfig.getProfileUserID() == null || MainApplication.mConfig.getProfileUserID().equals("")) {
            return;
        }
        Log.m2958e("[YHT] handleRegistResult!!! regCode:" + this.mRegistCode);
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            new C1274f(this.mPushType, this.mRegistCode, this.f3161d).start();
            return;
        }
        if (this.mRegistCode == null || this.mRegistCode.equals("")) {
            return;
        }
        if (this.mPushType.equals(StoreEPInfoAsk.EP_TYPE_SPP)) {
            if (this.mRegistCode.equals(MainApplication.mConfig.getSPPPushRegID())) {
                Log.m2963i("LOGINOPTIMIZATION matched with saved Reg ID - Skip StoreEPInfoAsk - SPP");
            } else {
                Log.m2963i("LOGINOPTIMIZATION it's not matched with saved Reg ID - Do StoreEPInfoAsk - SPP");
                new C1274f(this.mPushType, this.mRegistCode, this.f3161d).start();
            }
        }
        if (this.mPushType.equals(StoreEPInfoAsk.EP_TYPE_GCM)) {
            if (this.mRegistCode.equals(MainApplication.mConfig.getGCMPushRegID())) {
                Log.m2963i("LOGINOPTIMIZATION matched with saved Reg ID - Skip StoreEPInfoAsk - GCM");
            } else {
                Log.m2963i("LOGINOPTIMIZATION it's not matched with saved Reg ID - Do StoreEPInfoAsk - GCM");
                new C1274f(this.mPushType, this.mRegistCode, this.f3161d).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3030a(int i) {
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public C1286e getFirstSavedPushMessage() {
        synchronized (this.f3160a) {
            if (this.mListReceivedMsg.isEmpty()) {
                return null;
            }
            C1286e c1286e = new C1286e();
            c1286e.f3232a = ((C1286e) this.mListReceivedMsg.get(0)).f3232a;
            c1286e.f3233b = ((C1286e) this.mListReceivedMsg.get(0)).f3233b;
            this.mListReceivedMsg.remove(0);
            return c1286e;
        }
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public PushReceiveInterface getReceiveInterface() {
        return this.mCallback;
    }

    public void handleReceivedMessage(int i, String str) {
        boolean z = false;
        if (this.mCallback == null || !MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            if (!MainApplication.mPhoneManager.getLoginManager().isDuringLogin()) {
                MainApplication.mPhoneManager.getLoginManager().login();
            }
            synchronized (this.f3160a) {
                this.mListReceivedMsg.add(new C1286e(i, str));
            }
            return;
        }
        if ((!MainApplication.mConfig.isUseWifiOnly() || PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) && !MainApplication.mConfig.isDormantMode()) {
            z = true;
        }
        this.mCallback.onReceivePushMessage(i, str, z);
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public void onReceivePushMessage(int i, String str) {
        Message message = new Message();
        message.what = -2;
        message.arg1 = i;
        message.obj = str;
        this.f3161d.sendMessage(message);
    }

    protected abstract void register();

    @Override // com.sds.coolots.login.PushManagerInterface
    public void registerDevice(String str, Short sh, PushReceiveInterface pushReceiveInterface) {
        if (str.equals(this.mUserID) && sh.shortValue() == this.mDeviceID && this.mRegistState) {
            return;
        }
        this.mUserID = str;
        this.mDeviceID = sh.shortValue();
        this.mCallback = pushReceiveInterface;
        register();
        while (true) {
            C1286e firstSavedPushMessage = getFirstSavedPushMessage();
            if (firstSavedPushMessage == null) {
                return;
            }
            boolean z = true;
            if (MainApplication.mConfig.isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
                z = false;
            } else if (MainApplication.mConfig.isDormantMode()) {
                z = false;
            }
            this.mCallback.onReceivePushMessage(firstSavedPushMessage.f3232a, firstSavedPushMessage.f3233b, z);
        }
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public void setRegisterStatus(boolean z, String str) {
        Log.m2958e("[YHT] setRegisterStatus!!! code:" + str);
        this.f3161d.sendEmptyMessage(-1);
        this.mRegistState = z;
        this.mRegistCode = str;
    }

    protected abstract void unregister();

    @Override // com.sds.coolots.login.PushManagerInterface
    public void unregisterDevice() {
        Log.m2958e("[YHT] unregisterDevice!!!");
        unregister();
        this.mRegistState = false;
        this.mRegistCode = "";
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            return;
        }
        m3029a();
    }
}
