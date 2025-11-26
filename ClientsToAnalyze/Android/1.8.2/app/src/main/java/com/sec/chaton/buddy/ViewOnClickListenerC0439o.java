package com.sec.chaton.buddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.settings.tellfriends.C1472u;
import com.sec.chaton.settings.tellfriends.WeiboSignIn;
import com.sec.chaton.settings.tellfriends.WeiboSubMenuActivity;
import weibo4android.Weibo;
import weibo4android.http.AccessToken;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC0439o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1655a;

    ViewOnClickListenerC0439o(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1655a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SharedPreferences sharedPreferences = this.f1655a.getActivity().getSharedPreferences("WeiboLogin", 0);
        String string = sharedPreferences.getString("weibo_access_token", "");
        String string2 = sharedPreferences.getString("weibo_access_secret_token", "");
        if (string2.equals("")) {
            this.f1655a.startActivity(new Intent(this.f1655a.getActivity(), (Class<?>) WeiboSignIn.class));
            return;
        }
        AccessToken accessToken = new AccessToken(string, string2);
        Weibo weiboM5203b = C1472u.m5199a().m5203b();
        C1472u.m5199a().m5200a(weiboM5203b);
        weiboM5203b.setOAuthConsumer("1549470309", "a7d96376036a4b35a3e7a1e24632bd88");
        weiboM5203b.setToken(accessToken.getToken(), accessToken.getTokenSecret());
        C1472u.m5199a().m5201a(accessToken);
        this.f1655a.startActivity(new Intent(this.f1655a.getActivity(), (Class<?>) WeiboSubMenuActivity.class));
    }
}
