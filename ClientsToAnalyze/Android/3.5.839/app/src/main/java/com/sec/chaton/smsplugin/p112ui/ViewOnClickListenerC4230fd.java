package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.view.View;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fd */
/* loaded from: classes.dex */
class ViewOnClickListenerC4230fd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15583a;

    ViewOnClickListenerC4230fd(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15583a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = !this.f15583a.f14977aW.isChecked();
        if (z) {
            Cursor cursor = this.f15583a.f15050p.getCursor();
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    this.f15583a.f15050p.m16326a(cursor.getLong(1), cursor.getString(0));
                } while (cursor.moveToNext());
            }
        } else {
            this.f15583a.f15050p.m16331b();
        }
        this.f15583a.f14977aW.setChecked(z);
        this.f15583a.f14953Y.invalidateViews();
        this.f15583a.invalidateOptionsMenu();
    }
}
