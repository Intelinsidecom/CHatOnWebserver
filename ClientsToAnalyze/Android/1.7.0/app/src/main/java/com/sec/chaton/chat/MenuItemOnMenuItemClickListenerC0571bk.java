package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.p025d.EnumC0651d;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bk */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0571bk implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC0651d f1984a;

    /* renamed from: b */
    final /* synthetic */ String f1985b;

    /* renamed from: c */
    final /* synthetic */ String f1986c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f1987d;

    MenuItemOnMenuItemClickListenerC0571bk(ChatFragment chatFragment, EnumC0651d enumC0651d, String str, String str2) {
        this.f1987d = chatFragment;
        this.f1984a = enumC0651d;
        this.f1985b = str;
        this.f1986c = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f1987d.f1834bf.hideSoftInputFromWindow(ChatFragment.f1726aC.getWindowToken(), 0);
        Intent intent = new Intent(this.f1987d.getActivity(), (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", this.f1984a.m2978a());
        intent.putExtra("inboxNO", this.f1987d.f1861t);
        if (this.f1984a == EnumC0651d.TEXT || this.f1984a == EnumC0651d.GEO) {
            intent.putExtra("download_uri", this.f1985b);
        } else {
            intent.putExtra("download_uri", this.f1986c);
            intent.putExtra("sub_content", this.f1985b);
        }
        this.f1987d.startActivity(intent);
        return true;
    }
}
