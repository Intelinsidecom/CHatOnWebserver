package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.os.Handler;
import android.os.Message;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gd */
/* loaded from: classes.dex */
class HandlerC4257gd extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15620a;

    HandlerC4257gd(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15620a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Cursor cursor;
        super.handleMessage(message);
        switch (message.what) {
            case 100:
                if (this.f15620a.f15050p != null && (cursor = this.f15620a.f15050p.getCursor()) != null && cursor.moveToLast()) {
                    C4110as c4110as = this.f15620a.f15050p;
                    this.f15620a.f15050p.m16324a(cursor.getInt(C4110as.f15300o.f15336b));
                    this.f15620a.f15050p.notifyDataSetChanged();
                    break;
                }
                break;
        }
    }
}
