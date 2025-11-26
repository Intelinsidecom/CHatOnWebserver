package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.trunk.database.DatabaseConstant;

/* renamed from: com.sec.chaton.chat.b */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0140b implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONContract.MessageTable.MsgContentType f939a;

    /* renamed from: b */
    final /* synthetic */ String f940b;

    /* renamed from: c */
    final /* synthetic */ String f941c;

    /* renamed from: d */
    final /* synthetic */ String f942d;

    /* renamed from: e */
    final /* synthetic */ ChatFragment f943e;

    MenuItemOnMenuItemClickListenerC0140b(ChatFragment chatFragment, ChatONContract.MessageTable.MsgContentType msgContentType, String str, String str2, String str3) {
        this.f943e = chatFragment;
        this.f939a = msgContentType;
        this.f940b = str;
        this.f941c = str2;
        this.f942d = str3;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f943e.f768aL.hideSoftInputFromWindow(this.f943e.f801as.getWindowToken(), 0);
        Intent intent = new Intent(this.f943e.getActivity(), (Class<?>) ChatForwardActivity.class);
        intent.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, this.f939a.m2197a());
        intent.putExtra("inboxNO", this.f943e.f822s);
        if (this.f939a == ChatONContract.MessageTable.MsgContentType.TEXT || this.f939a == ChatONContract.MessageTable.MsgContentType.GEO) {
            intent.putExtra("download_uri", this.f940b);
        } else {
            intent.putExtra("download_uri", this.f941c);
        }
        if (this.f939a == ChatONContract.MessageTable.MsgContentType.CALENDAR || this.f939a == ChatONContract.MessageTable.MsgContentType.CONTACT) {
            intent.putExtra("sub_content", this.f942d);
        }
        this.f943e.startActivity(intent);
        return true;
    }
}
