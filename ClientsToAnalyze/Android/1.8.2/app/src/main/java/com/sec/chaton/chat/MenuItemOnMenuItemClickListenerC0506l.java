package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.p017e.EnumC0699n;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.l */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0506l implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC0699n f2105a;

    /* renamed from: b */
    final /* synthetic */ String f2106b;

    /* renamed from: c */
    final /* synthetic */ String f2107c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f2108d;

    MenuItemOnMenuItemClickListenerC0506l(ChatFragment chatFragment, EnumC0699n enumC0699n, String str, String str2) {
        this.f2108d = chatFragment;
        this.f2105a = enumC0699n;
        this.f2106b = str;
        this.f2107c = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f2108d.f1846bI.hideSoftInputFromWindow(this.f2108d.f1800aO.getWindowToken(), 0);
        Intent intent = new Intent(this.f2108d.getActivity(), (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", this.f2105a.m3162a());
        intent.putExtra("inboxNO", this.f2108d.f1912z);
        if (this.f2105a == EnumC0699n.TEXT || this.f2105a == EnumC0699n.GEO) {
            intent.putExtra("download_uri", this.f2106b);
        } else {
            intent.putExtra("download_uri", this.f2107c);
            intent.putExtra("sub_content", this.f2106b);
        }
        this.f2108d.startActivity(intent);
        return true;
    }
}
