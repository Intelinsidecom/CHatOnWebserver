package com.sec.chaton.chat;

import android.view.MenuItem;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.g */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0590g implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnCreateContextMenuListenerC0526ab f2024a;

    MenuItemOnMenuItemClickListenerC0590g(ViewOnCreateContextMenuListenerC0526ab viewOnCreateContextMenuListenerC0526ab) {
        this.f2024a = viewOnCreateContextMenuListenerC0526ab;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0079  */
    @Override // android.view.MenuItem.OnMenuItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onMenuItemClick(android.view.MenuItem r6) {
        /*
            r5 = this;
            java.lang.String r1 = ""
            int r0 = com.sec.chaton.p029f.C0684a.f2330a
            r2 = 11
            if (r0 < r2) goto L5a
            com.sec.chaton.chat.ab r0 = r5.f2024a
            com.sec.chaton.chat.ChatFragment r0 = r0.f1876a
            android.support.v4.app.FragmentActivity r0 = r0.getActivity()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0
            r0.getPrimaryClip()
            boolean r2 = r0.hasPrimaryClip()
            if (r2 == 0) goto L79
            android.content.ClipData r0 = r0.getPrimaryClip()
            r1 = 0
            android.content.ClipData$Item r0 = r0.getItemAt(r1)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
        L32:
            com.sec.chaton.multimedia.a.c r1 = new com.sec.chaton.multimedia.a.c
            com.sec.chaton.chat.ab r2 = r5.f2024a
            com.sec.chaton.chat.ChatFragment r2 = r2.f1876a
            android.support.v4.app.FragmentActivity r2 = r2.getActivity()
            android.content.res.Resources r2 = r2.getResources()
            android.widget.EditText r3 = com.sec.chaton.chat.ChatFragment.m2655j()
            int r3 = r3.getLineHeight()
            float r3 = (float) r3
            r4 = 1067030938(0x3f99999a, float:1.2)
            float r3 = r3 * r4
            int r3 = (int) r3
            r1.<init>(r2, r0, r3)
            android.widget.EditText r0 = com.sec.chaton.chat.ChatFragment.m2655j()
            r1.m3202a(r0)
            r0 = 1
            return r0
        L5a:
            com.sec.chaton.chat.ab r0 = r5.f2024a
            com.sec.chaton.chat.ChatFragment r0 = r0.f1876a
            android.support.v4.app.FragmentActivity r0 = r0.getActivity()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.text.ClipboardManager r0 = (android.text.ClipboardManager) r0
            boolean r2 = r0.hasText()
            if (r2 == 0) goto L79
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L32
        L79:
            r0 = r1
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.MenuItemOnMenuItemClickListenerC0590g.onMenuItemClick(android.view.MenuItem):boolean");
    }
}
