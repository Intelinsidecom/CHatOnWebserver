package com.coolots.chaton.common.controller;

import android.app.Service;
import android.content.IntentFilter;
import com.coolots.chaton.call.util.ChatONAddBuddyReceiver;
import com.coolots.chaton.common.util.ChatONClearCoverReceiver;
import com.coolots.chaton.service.PackageAddedReceiver;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class BroadcastReceiverManager implements DisposeInterface {
    private static final String CLASSNAME = "[BroadcastReceiverManager]";
    private Service mService;
    private PackageAddedReceiver mPackageAddedReceiver = null;
    private ChatONClearCoverReceiver mChatONClearCoverReceiver = null;
    private ChatONAddBuddyReceiver mChatONAddBuddyReceiver = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public BroadcastReceiverManager(Service service) {
        this.mService = null;
        this.mService = service;
    }

    public void registerReceiver() {
        logI("haeri=registerReceiver()");
        registPackageAddedReceiver();
        registClearCoverReceiver();
        registAddBuddyReceiver();
    }

    private void registPackageAddedReceiver() {
        logI("haeri=registPackageAddedReceiver()---1");
        this.mPackageAddedReceiver = new PackageAddedReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addCategory("android.intent.category.DEFAULT");
        intentFilter.addDataScheme("package");
        this.mService.registerReceiver(this.mPackageAddedReceiver, intentFilter);
    }

    private void registClearCoverReceiver() {
        logI("haeri=registClearCoverReceiver()---2");
        this.mChatONClearCoverReceiver = new ChatONClearCoverReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.samsung.cover.OPEN");
        this.mService.registerReceiver(this.mChatONClearCoverReceiver, intentFilter);
    }

    private void registAddBuddyReceiver() {
        logI("haeri=registAddBuddyReceiver()---3");
        this.mChatONAddBuddyReceiver = new ChatONAddBuddyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChatONAddBuddyReceiver.ADD_BUDDY_RESULT);
        intentFilter.addDataScheme("com.coolots.chaton");
        this.mService.registerReceiver(this.mChatONAddBuddyReceiver, intentFilter);
    }

    public void unregisterReceiver() {
        logI("haeri=unregisterReceiver()");
        if (this.mPackageAddedReceiver != null) {
            this.mService.unregisterReceiver(this.mPackageAddedReceiver);
        }
        if (this.mChatONAddBuddyReceiver != null) {
            this.mService.unregisterReceiver(this.mChatONAddBuddyReceiver);
        }
        if (this.mChatONClearCoverReceiver != null) {
            this.mService.unregisterReceiver(this.mChatONClearCoverReceiver);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("haeri=dispose()");
        this.mPackageAddedReceiver = null;
        this.mChatONAddBuddyReceiver = null;
        this.mChatONClearCoverReceiver = null;
        this.mService = null;
    }
}
