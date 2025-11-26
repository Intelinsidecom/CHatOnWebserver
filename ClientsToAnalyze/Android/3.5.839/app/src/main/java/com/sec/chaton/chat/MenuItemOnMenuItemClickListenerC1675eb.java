package com.sec.chaton.chat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ContentUris;
import android.net.Uri;
import android.os.Build;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.C4132bn;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.lang.ref.SoftReference;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.eb */
/* loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1675eb implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6235a;

    /* renamed from: b */
    private final SoftReference<C4108aq> f6236b;

    public MenuItemOnMenuItemClickListenerC1675eb(ChatFragment chatFragment, C4108aq c4108aq) {
        this.f6235a = chatFragment;
        this.f6236b = new SoftReference<>(c4108aq);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    @SuppressLint({"NewApi"})
    public boolean onMenuItemClick(MenuItem menuItem) throws Throwable {
        C4108aq c4108aq = this.f6236b.get();
        if (c4108aq == null) {
            C4904y.m18639b("msgItem is null", ChatFragment.f5461a);
            return false;
        }
        C4132bn c4132bn = new C4132bn(this.f6235a.f5624cN, this.f6235a.f5624cN, c4108aq, c4108aq.m16307j(), c4108aq.f15267b);
        long j = c4108aq.f15268c;
        switch (menuItem.getItemId()) {
            case 18:
                Uri uriM16302e = c4108aq.m16302e();
                if (c4108aq.m16309l()) {
                    uriM16302e = ContentUris.withAppendedId(C4149cd.f15441b, c4108aq.m16307j());
                }
                this.f6235a.m7898a(new DialogInterfaceOnClickListenerC1663dq(this.f6235a, uriM16302e, c4108aq.m16304g()), c4108aq.m16304g());
                break;
            case 21:
                this.f6235a.m7932a(c4108aq);
                break;
            case 24:
                if (Build.VERSION.SDK_INT < 11) {
                    ((ClipboardManager) this.f6235a.f5624cN.getSystemService("clipboard")).setText(c4108aq.f15277l);
                } else {
                    ((android.content.ClipboardManager) this.f6235a.f5624cN.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, c4108aq.f15277l));
                }
                break;
            case 25:
                c4132bn.m16384a(c4108aq.m16305h(), true, c4108aq.f15268c);
                break;
            case 28:
                C3892o.m15016a(c4108aq, true);
                break;
            case 29:
                C3892o.m15016a(c4108aq, false);
                break;
            case 30:
                Toast.makeText(CommonApplication.m18732r(), C3892o.m15009a(j, C3892o.m15027c(j)), 0).show();
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
