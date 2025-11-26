package com.coolots.chaton.login;

import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.profile.ProfileManagerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ProfileInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* loaded from: classes.dex */
public class ChatOnVLoginManager extends LoginManager {
    public static final String CLASSNAME = "[ChatOnVLoginManager]";
    private final DBHandler mHandler = new DBHandler(this, null);

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private class DBHandler extends Handler {
        private DBHandler() {
        }

        /* synthetic */ DBHandler(ChatOnVLoginManager chatOnVLoginManager, DBHandler dBHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == MessageInfo.RegionDomainInfoAsk.getDispatchCode()) {
                ChatOnVLoginManager.this.updateProfileAfterLoginProcess();
            }
            if (msg.what != MessageInfo.ProfileAsk.getDispatchCode()) {
                return;
            }
            ChatOnVLoginManager.this.updateDatabaseForBuddySyncAfterLoginProcess();
        }
    }

    @Override // com.sds.coolots.login.LoginManager
    protected void handleAfterLoginProcess() {
        ConfigActivity.setValidDevice(true);
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().regionCodeSync(this.mHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProfileAfterLoginProcess() {
        ProfileManagerInterface profileManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager();
        ProfileInfo userProfile = profileManager.getProfileInfo();
        if (DatabaseHelper.isNeededBuddyUpdateDate) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().resetBuddyUpdatedate();
            DatabaseHelper.isNeededBuddyUpdateDate = false;
        }
        logE("<<YHT10>> profileUpdateDate() is " + userProfile.getProfileUpdateDate().getTime());
        if (userProfile.getProfileUpdateDate().getTime() == 0) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager().updateProfileInfo(this.mHandler);
        } else {
            updateDatabaseForBuddySyncAfterLoginProcess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDatabaseForBuddySyncAfterLoginProcess() {
        if (ConfigActivity.getBuddyUpdateDate().getTime() == 0) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().updateDatabaseForBuddySync();
        }
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void handleServicePolicyInfo() {
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void requestServerSearchableAsk(Handler UIhandler) {
    }

    @Override // com.sds.coolots.login.LoginManager
    protected void updateMediaSettingIfNeeded() {
    }
}
