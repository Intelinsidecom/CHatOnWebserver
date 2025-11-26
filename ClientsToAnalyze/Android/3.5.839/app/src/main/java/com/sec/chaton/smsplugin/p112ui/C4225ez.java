package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ez */
/* loaded from: classes.dex */
class C4225ez implements SimpleAdapter.ViewBinder {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15576a;

    C4225ez(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15576a = pluginComposeMessageActivity;
    }

    @Override // android.widget.SimpleAdapter.ViewBinder
    public boolean setViewValue(View view, Object obj, String str) {
        if (!(view instanceof ImageView)) {
            return false;
        }
        ((ImageView) view).setImageDrawable(this.f15576a.getResources().getDrawable(((Integer) obj).intValue()));
        return true;
    }
}
