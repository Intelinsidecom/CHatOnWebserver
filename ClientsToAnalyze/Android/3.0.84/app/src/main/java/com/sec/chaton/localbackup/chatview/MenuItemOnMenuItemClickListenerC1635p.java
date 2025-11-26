package com.sec.chaton.localbackup.chatview;

import android.content.ClipData;
import android.os.Build;
import android.text.ClipboardManager;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.p */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1635p implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6083a;

    /* renamed from: b */
    final /* synthetic */ ChatViewFragment f6084b;

    MenuItemOnMenuItemClickListenerC1635p(ChatViewFragment chatViewFragment, String str) {
        this.f6084b = chatViewFragment;
        this.f6083a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) this.f6084b.f6034f.getSystemService("clipboard")).setText(this.f6083a);
        } else {
            ((android.content.ClipboardManager) this.f6084b.f6034f.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.f6083a));
        }
        C3641ai.m13210a(this.f6084b.f6034f, R.string.copied_to_clipboard, 0).show();
        return true;
    }
}
