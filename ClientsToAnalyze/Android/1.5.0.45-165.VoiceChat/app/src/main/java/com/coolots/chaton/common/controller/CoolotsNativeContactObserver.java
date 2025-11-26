package com.coolots.chaton.common.controller;

import android.database.ContentObserver;
import android.os.Handler;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CoolotsNativeContactObserver extends ContentObserver {
    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        Log.m2958e("BUDDY_TRACE onChanged!!!!!! setNativeContactChanged true");
        ConfigActivity.setNativeContactChanged(true);
    }

    public CoolotsNativeContactObserver(Handler handler) {
        super(handler);
        Log.m2958e("BUDDY_TRACE CoolotsNativeContactObserver created!!!!!!  setNativeContactChanged true");
        ConfigActivity.setNativeContactChanged(true);
    }
}
