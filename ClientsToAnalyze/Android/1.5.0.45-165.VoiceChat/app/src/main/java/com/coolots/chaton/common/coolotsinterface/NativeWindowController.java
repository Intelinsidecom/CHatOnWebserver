package com.coolots.chaton.common.coolotsinterface;

import android.app.ActivityManagerNative;
import android.os.RemoteException;
import com.sds.coolots.common.coolotsinterface.NativeWindowControllerInterface;

/* loaded from: classes.dex */
public class NativeWindowController implements NativeWindowControllerInterface {
    @Override // com.sds.coolots.common.coolotsinterface.NativeWindowControllerInterface
    public void closeSystemDialogs() {
        try {
            ActivityManagerNative.getDefault().closeSystemDialogs((String) null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
