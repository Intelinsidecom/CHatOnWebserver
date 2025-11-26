package com.sec.chaton.chat;

import android.view.MenuItem;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ck */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1015ck implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnCreateContextMenuListenerC1014cj f4093a;

    MenuItemOnMenuItemClickListenerC1015ck(ViewOnCreateContextMenuListenerC1014cj viewOnCreateContextMenuListenerC1014cj) {
        this.f4093a = viewOnCreateContextMenuListenerC1014cj;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c9  */
    @Override // android.view.MenuItem.OnMenuItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onMenuItemClick(android.view.MenuItem r8) {
        /*
            r7 = this;
            r4 = 0
            java.lang.String r1 = ""
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r0 < r2) goto L91
            com.sec.chaton.chat.cj r0 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r0 = r0.f4092a
            android.app.Activity r0 = com.sec.chaton.chat.ChatFragment.m4933n(r0)
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0
            boolean r2 = r0.hasPrimaryClip()
            if (r2 == 0) goto Lc9
            android.content.ClipData r0 = r0.getPrimaryClip()
            android.content.ClipData$Item r0 = r0.getItemAt(r4)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
        L2f:
            com.sec.chaton.chat.cj r1 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r1 = r1.f4092a
            com.sec.chaton.chat.MyEditText r1 = com.sec.chaton.chat.ChatFragment.m4885d(r1)
            int r1 = r1.getSelectionStart()
            com.sec.chaton.chat.cj r2 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r2 = r2.f4092a
            com.sec.chaton.chat.MyEditText r2 = com.sec.chaton.chat.ChatFragment.m4885d(r2)
            int r2 = r2.getSelectionEnd()
            com.sec.chaton.chat.cj r3 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r3 = r3.f4092a
            android.app.Activity r3 = com.sec.chaton.chat.ChatFragment.m4933n(r3)
            com.sec.chaton.chat.cj r5 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r5 = r5.f4092a
            com.sec.chaton.chat.MyEditText r5 = com.sec.chaton.chat.ChatFragment.m4885d(r5)
            int r5 = r5.getLineHeight()
            float r5 = (float) r5
            r6 = 1067030938(0x3f99999a, float:1.2)
            float r5 = r5 * r6
            int r5 = (int) r5
            java.lang.CharSequence r3 = com.sec.chaton.multimedia.emoticon.C1835j.m7508a(r3, r0, r5)
            com.sec.chaton.chat.cj r0 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r0 = r0.f4092a
            com.sec.chaton.chat.MyEditText r0 = com.sec.chaton.chat.ChatFragment.m4885d(r0)
            android.text.Editable r0 = r0.getText()
            int r0 = r0.length()
            int r5 = r3.length()
            int r0 = r0 + r5
            int r5 = r2 - r1
            int r0 = r0 - r5
            r5 = 10000(0x2710, float:1.4013E-41)
            if (r0 <= r5) goto Lcc
            android.content.Context r0 = com.sec.common.CommonApplication.m11493l()
            r1 = 2131427377(0x7f0b0031, float:1.8476369E38)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r4)
            r0.show()
        L8f:
            r0 = 1
            return r0
        L91:
            com.sec.chaton.chat.cj r0 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r0 = r0.f4092a
            android.app.Activity r0 = com.sec.chaton.chat.ChatFragment.m4933n(r0)
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.text.ClipboardManager r0 = (android.text.ClipboardManager) r0
            boolean r2 = r0.hasText()
            if (r2 == 0) goto Lc9
            java.lang.CharSequence r2 = r0.getText()
            if (r2 == 0) goto Lb8
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r1 = r0.toString()
            r0 = r1
            goto L2f
        Lb8:
            boolean r0 = com.sec.chaton.util.C3250y.f11737e
            if (r0 == 0) goto Lc9
            java.lang.String r0 = "clipboard getText() is null"
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r0, r2)
        Lc9:
            r0 = r1
            goto L2f
        Lcc:
            com.sec.chaton.chat.cj r0 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r0 = r0.f4092a
            com.sec.chaton.chat.MyEditText r0 = com.sec.chaton.chat.ChatFragment.m4885d(r0)
            android.text.Editable r0 = r0.getEditableText()
            if (r0 == 0) goto Led
            com.sec.chaton.chat.cj r0 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r0 = r0.f4092a
            com.sec.chaton.chat.MyEditText r0 = com.sec.chaton.chat.ChatFragment.m4885d(r0)
            android.text.Editable r0 = r0.getEditableText()
            int r5 = r3.length()
            r0.replace(r1, r2, r3, r4, r5)
        Led:
            com.sec.chaton.chat.cj r0 = r7.f4093a
            com.sec.chaton.chat.ChatFragment r0 = r0.f4092a
            com.sec.chaton.chat.MyEditText r0 = com.sec.chaton.chat.ChatFragment.m4885d(r0)
            int r2 = r3.length()
            int r2 = r2 + r1
            int r3 = r3.length()
            int r1 = r1 + r3
            r0.setSelection(r2, r1)
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.MenuItemOnMenuItemClickListenerC1015ck.onMenuItemClick(android.view.MenuItem):boolean");
    }
}
