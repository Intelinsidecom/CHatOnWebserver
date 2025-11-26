package com.sec.chaton.settings.tellfriends;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.aa */
/* loaded from: classes.dex */
public class AsyncTaskC1346aa extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ OauthSignin f5153a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Twitter doInBackground(String... strArr) {
        C1786r.m6063c("Called. OauthAccessTokenTask - doInBackground()", getClass().getSimpleName());
        try {
            AccessToken oAuthAccessToken = this.f5153a.f4972b.getOAuthAccessToken(strArr[0]);
            SharedPreferences.Editor editorEdit = this.f5153a.getSharedPreferences("TwitterLogin", 0).edit();
            editorEdit.putString("twitter_access_token", oAuthAccessToken.getToken());
            editorEdit.putString("twitter_access_secret_token", oAuthAccessToken.getTokenSecret());
            editorEdit.commit();
            this.f5153a.f4972b.setOAuthAccessToken(oAuthAccessToken);
            C1437dk.m5166a().m5167a(this.f5153a.f4972b);
        } catch (TwitterException e) {
            e.printStackTrace();
            this.f5153a.f4976f.sendEmptyMessage(9001);
        }
        return this.f5153a.f4972b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Twitter twitter) {
        C1786r.m6063c("Called. OauthAccessTokenTask - onPostExecute()", getClass().getSimpleName());
        if (this.f5153a.f4979j != null) {
            this.f5153a.f4979j.cancel();
        }
        this.f5153a.m4830a();
    }
}
