package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import weibo4android.http.AccessToken;

/* compiled from: TellFriendsPreferenceAct.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ce */
/* loaded from: classes.dex */
class C1404ce implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsPreferenceAct f5267a;

    C1404ce(TellFriendsPreferenceAct tellFriendsPreferenceAct) {
        this.f5267a = tellFriendsPreferenceAct;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        SharedPreferences sharedPreferences = this.f5267a.getActivity().getSharedPreferences("WeiboLogin", 0);
        String string = sharedPreferences.getString("weibo_access_token", "");
        String string2 = sharedPreferences.getString("weibo_access_secret_token", "");
        if (string2.equals("")) {
            this.f5267a.startActivity(new Intent(this.f5267a.f5044e, (Class<?>) WeiboSignIn.class));
            return true;
        }
        AccessToken accessToken = new AccessToken(string, string2);
        this.f5267a.f5043d = C1472u.m5199a().m5203b();
        C1472u.m5199a().m5200a(this.f5267a.f5043d);
        this.f5267a.f5043d.setOAuthConsumer("1549470309", "a7d96376036a4b35a3e7a1e24632bd88");
        this.f5267a.f5043d.setToken(accessToken.getToken(), accessToken.getTokenSecret());
        C1472u.m5199a().m5201a(accessToken);
        this.f5267a.startActivity(new Intent(this.f5267a.f5044e, (Class<?>) WeiboSubMenuActivity.class));
        return true;
    }
}
