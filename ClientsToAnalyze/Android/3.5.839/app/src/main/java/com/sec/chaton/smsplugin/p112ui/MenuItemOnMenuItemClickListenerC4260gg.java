package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentUris;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.Toast;
import com.sec.chaton.smsplugin.p111h.C3896s;
import java.lang.ref.SoftReference;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gg */
/* loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC4260gg implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15625a;

    /* renamed from: b */
    private final SoftReference<C4108aq> f15626b;

    public MenuItemOnMenuItemClickListenerC4260gg(PluginComposeMessageActivity pluginComposeMessageActivity, C4108aq c4108aq) {
        this.f15625a = pluginComposeMessageActivity;
        this.f15626b = new SoftReference<>(c4108aq);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) throws Throwable {
        C4108aq c4108aq = this.f15626b.get();
        if (c4108aq == null) {
            C3896s.m15044b("msgItem == null", "Mms/compose");
            return false;
        }
        C4132bn c4132bn = new C4132bn(this.f15625a, this.f15625a, c4108aq, c4108aq.m16307j(), c4108aq.f15267b);
        long j = c4108aq.f15268c;
        switch (menuItem.getItemId()) {
            case 14:
                this.f15625a.m15959a(c4108aq);
                this.f15625a.m15903R();
                break;
            case 17:
                this.f15625a.m15960a(c4108aq, this.f15625a.f14935G, true);
                break;
            case 18:
                Uri uriWithAppendedId = c4108aq.f15283r;
                if (c4108aq.m16309l()) {
                    uriWithAppendedId = ContentUris.withAppendedId(C4149cd.f15441b, c4108aq.m16307j());
                }
                this.f15625a.m15936a(new DialogInterfaceOnClickListenerC4251fy(this.f15625a, uriWithAppendedId, c4108aq.f15273h), c4108aq.f15273h);
                break;
            case 21:
                this.f15625a.m16057d(c4108aq);
                break;
            case 24:
                this.f15625a.m16066e(c4108aq.f15277l);
                break;
            case 25:
                c4132bn.m16384a(c4108aq.f15287v, true, c4108aq.f15268c);
                break;
            case 28:
                this.f15625a.m15961a(c4108aq, true);
                break;
            case 29:
                this.f15625a.m15961a(c4108aq, false);
                break;
            case 30:
                Toast.makeText(this.f15625a, this.f15625a.m15921a(j, this.f15625a.m16049c(j)), 0).show();
                break;
            case 35:
                c4132bn.m16385a(c4108aq);
                break;
            case 36:
                c4132bn.m16387b(c4108aq);
                break;
        }
        return false;
    }
}
