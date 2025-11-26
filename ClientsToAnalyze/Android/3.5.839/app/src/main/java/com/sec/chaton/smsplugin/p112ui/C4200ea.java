package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentUris;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5094q;
import com.sec.google.android.p134a.p135a.C5097t;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ea */
/* loaded from: classes.dex */
class C4200ea implements InterfaceC4158cm {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15533a;

    C4200ea(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15533a = pluginComposeMessageActivity;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4158cm
    /* renamed from: a */
    public void mo16448a(C5094q c5094q, boolean z) {
        if (c5094q == null) {
            this.f15533a.m15934a(-1, R.string.type_picture, (Uri) null);
            return;
        }
        C5097t c5097tM19426a = C5097t.m19426a(this.f15533a);
        Uri uriM14450c = this.f15533a.f14996ap.m14450c(true);
        if (uriM14450c == null) {
            PluginComposeMessageActivity.m16048c("ResizeImageResultCallback messageURI is null");
            return;
        }
        try {
            Uri uriM19445a = c5097tM19426a.m19445a(c5094q, ContentUris.parseId(uriM14450c));
            this.f15533a.f14996ap.m14433a(1, uriM19445a, z);
            PluginComposeMessageActivity.m16048c("ResizeImageResultCallback: dataUri=" + uriM19445a);
        } catch (C5111c e) {
            PluginComposeMessageActivity.m16048c("ResizeImageResultCallback Mmsexception = " + e);
        }
    }
}
