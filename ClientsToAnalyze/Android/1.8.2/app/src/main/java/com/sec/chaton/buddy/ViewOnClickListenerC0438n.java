package com.sec.chaton.buddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.settings.tellfriends.C1437dk;
import com.sec.chaton.settings.tellfriends.TwitterSignIn;
import com.sec.chaton.settings.tellfriends.TwitterSubMenuActivity;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0438n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1654a;

    ViewOnClickListenerC0438n(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1654a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SharedPreferences sharedPreferences = this.f1654a.getActivity().getSharedPreferences("TwitterLogin", 0);
        String string = sharedPreferences.getString("twitter_access_token", "");
        String string2 = sharedPreferences.getString("twitter_access_secret_token", "");
        if (string2.equals("")) {
            this.f1654a.startActivity(new Intent(this.f1654a.getActivity(), (Class<?>) TwitterSignIn.class));
            return;
        }
        AccessToken accessToken = new AccessToken(string, string2);
        Twitter twitterFactory = new TwitterFactory().getInstance();
        twitterFactory.setOAuthConsumer("FiKaUrK1VKFB5pBaW77aPQ", "yd4oZTePGns9RyeuqXMYMUU1f70VS16sf8WhiCdwSM");
        twitterFactory.setOAuthAccessToken(accessToken);
        C1437dk.m5166a().m5167a(twitterFactory);
        this.f1654a.startActivity(new Intent(this.f1654a.getActivity(), (Class<?>) TwitterSubMenuActivity.class));
    }
}
