package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/* compiled from: TellFriendsPreferenceAct.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cd */
/* loaded from: classes.dex */
class C1403cd implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsPreferenceAct f5266a;

    C1403cd(TellFriendsPreferenceAct tellFriendsPreferenceAct) {
        this.f5266a = tellFriendsPreferenceAct;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        SharedPreferences sharedPreferences = this.f5266a.getActivity().getSharedPreferences("TwitterLogin", 0);
        String string = sharedPreferences.getString("twitter_access_token", "");
        String string2 = sharedPreferences.getString("twitter_access_secret_token", "");
        if (string2.equals("")) {
            this.f5266a.startActivity(new Intent(this.f5266a.f5044e, (Class<?>) OauthSignin.class));
            return true;
        }
        AccessToken accessToken = new AccessToken(string, string2);
        this.f5266a.f5042c = new TwitterFactory().getInstance();
        this.f5266a.f5042c.setOAuthConsumer("FiKaUrK1VKFB5pBaW77aPQ", "yd4oZTePGns9RyeuqXMYMUU1f70VS16sf8WhiCdwSM");
        this.f5266a.f5042c.setOAuthAccessToken(accessToken);
        C1437dk.m5166a().m5167a(this.f5266a.f5042c);
        this.f5266a.startActivity(new Intent(this.f5266a.f5044e, (Class<?>) TwitterSubMenuActivity.class));
        return true;
    }
}
