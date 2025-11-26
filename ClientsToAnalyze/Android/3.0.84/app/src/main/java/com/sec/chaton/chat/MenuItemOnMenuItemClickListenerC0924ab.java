package com.sec.chaton.chat;

import android.content.ClipData;
import android.os.Build;
import android.text.ClipboardManager;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.p023a.InterfaceC0907k;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ab */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0924ab implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0907k f3860a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f3861b;

    MenuItemOnMenuItemClickListenerC0924ab(ChatFragment chatFragment, InterfaceC0907k interfaceC0907k) {
        this.f3861b = chatFragment;
        this.f3860a = interfaceC0907k;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) this.f3861b.f3672cr.getSystemService("clipboard")).setText(this.f3860a.mo5099j());
        } else {
            ((android.content.ClipboardManager) this.f3861b.f3672cr.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.f3860a.mo5099j()));
        }
        C3641ai.m13210a(this.f3861b.f3672cr, R.string.copied_to_clipboard, 0).show();
        return true;
    }
}
