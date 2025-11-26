package com.sec.chaton.localbackup.chatview;

import android.content.ClipData;
import android.os.Build;
import android.text.ClipboardManager;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.p */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2537p implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9127a;

    /* renamed from: b */
    final /* synthetic */ ChatViewFragment f9128b;

    MenuItemOnMenuItemClickListenerC2537p(ChatViewFragment chatViewFragment, String str) {
        this.f9128b = chatViewFragment;
        this.f9127a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) this.f9128b.f9078f.getSystemService("clipboard")).setText(this.f9127a);
        } else {
            ((android.content.ClipboardManager) this.f9128b.f9078f.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.f9127a));
        }
        C5179v.m19810a(this.f9128b.f9078f, R.string.copied_to_clipboard, 0).show();
        return true;
    }
}
