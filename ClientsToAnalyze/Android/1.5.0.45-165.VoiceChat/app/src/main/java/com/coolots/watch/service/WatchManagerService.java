package com.coolots.watch.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.watch.service.IWatchManagerService;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class WatchManagerService extends Service {
    IWatchManagerService.Stub mBinder = new IWatchManagerService.Stub() { // from class: com.coolots.watch.service.WatchManagerService.1
        @Override // com.coolots.watch.service.IWatchManagerService
        public boolean setMuteCallStateFromWatch(int callID, boolean muteCall) throws RemoteException {
            return ((VAppPhoneManager) MainApplication.mPhoneManager).getWatchManager().setMuteCallStateFromWatch(callID, muteCall);
        }

        @Override // com.coolots.watch.service.IWatchManagerService
        public boolean receiveCallFromWatch(int callID) throws RemoteException {
            return ((VAppPhoneManager) MainApplication.mPhoneManager).getWatchManager().receiveCallFromWatch(callID);
        }

        @Override // com.coolots.watch.service.IWatchManagerService
        public int p2pCallOutFromWatch(String buddy) throws RemoteException {
            return ((VAppPhoneManager) MainApplication.mPhoneManager).getWatchManager().p2pCallOutFromWatch(buddy);
        }

        @Override // com.coolots.watch.service.IWatchManagerService
        public boolean hangupCallFromWatch(int callID) throws RemoteException {
            return ((VAppPhoneManager) MainApplication.mPhoneManager).getWatchManager().hangupCallFromWatch(callID);
        }

        @Override // com.coolots.watch.service.IWatchManagerService
        public int conferenceCallOutFromWatch(List<String> participants, String groupName) throws RemoteException {
            return ((VAppPhoneManager) MainApplication.mPhoneManager).getWatchManager().conferenceCallOutFromWatch(participants, groupName);
        }

        @Override // com.coolots.watch.service.IWatchManagerService
        public List<String> getRejectWithMessageList() throws RemoteException {
            return ((VAppPhoneManager) MainApplication.mPhoneManager).getWatchManager().getRejectWithMessageList();
        }
    };

    private void logE(String message) {
        Log.m2958e("[SWatch] - WatchManagerService  " + message);
    }

    private void logI(String message) {
        Log.m2963i("[SWatch] - WatchManagerService  " + message);
    }

    @Override // android.app.Service
    public void onCreate() {
        logI("WatchManagerService created");
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        logI("WatchManagerService onBind");
        return this.mBinder;
    }
}
