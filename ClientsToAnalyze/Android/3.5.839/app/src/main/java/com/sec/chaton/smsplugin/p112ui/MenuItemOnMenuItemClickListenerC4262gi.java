package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import android.view.MenuItem;
import com.sec.chaton.smsplugin.p102b.C3782a;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gi */
/* loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC4262gi implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15628a;

    /* renamed from: b */
    private final C3782a f15629b;

    MenuItemOnMenuItemClickListenerC4262gi(PluginComposeMessageActivity pluginComposeMessageActivity, C3782a c3782a) {
        this.f15628a = pluginComposeMessageActivity;
        this.f15629b = c3782a;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 12:
                Intent intent = new Intent("android.intent.action.VIEW", this.f15629b.m14268j());
                intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
                this.f15628a.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
