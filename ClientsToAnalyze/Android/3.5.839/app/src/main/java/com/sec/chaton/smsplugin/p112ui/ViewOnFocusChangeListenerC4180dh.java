package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import com.sec.chaton.smsplugin.p102b.C3789h;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dh */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC4180dh implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15502a;

    ViewOnFocusChangeListenerC4180dh(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15502a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        int size;
        if (!z) {
            if (this.f15502a.m16111x()) {
                C3789h c3789hM16168a = ((RecipientsEditor) view).m16168a(false);
                if (c3789hM16168a.size() > 0) {
                    if (this.f15502a.f14996ap.m14463m() != null) {
                        size = this.f15502a.f14996ap.m14462l().size() + c3789hM16168a.m14313c().length;
                    } else {
                        size = c3789hM16168a.m14313c().length;
                    }
                    if (!this.f15502a.m16032b(size)) {
                        if (this.f15502a.f14996ap.m14463m() == null) {
                            this.f15502a.f14996ap.m14441a(new ArrayList(Arrays.asList(c3789hM16168a.m14313c())));
                        } else if (c3789hM16168a.m14313c().length > 0) {
                            for (String str : c3789hM16168a.m14313c()) {
                                this.f15502a.f14996ap.m14440a(str);
                            }
                        }
                        this.f15502a.m16109w();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f15502a.m16125f();
        }
    }
}
