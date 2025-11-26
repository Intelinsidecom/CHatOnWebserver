package com.sec.chaton.chat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Build;
import android.text.ClipboardManager;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.p054a.InterfaceC1541n;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ar */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1571ar implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1541n f5993a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f5994b;

    MenuItemOnMenuItemClickListenerC1571ar(ChatFragment chatFragment, InterfaceC1541n interfaceC1541n) {
        this.f5994b = chatFragment;
        this.f5993a = interfaceC1541n;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    @SuppressLint({"NewApi"})
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) this.f5994b.f5624cN.getSystemService("clipboard")).setText(this.f5993a.mo8391l());
        } else {
            ((android.content.ClipboardManager) this.f5994b.f5624cN.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.f5993a.mo8391l()));
        }
        C5179v.m19810a(this.f5994b.f5624cN, R.string.copied_to_clipboard, 0).show();
        return true;
    }
}
