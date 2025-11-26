package com.sec.chaton.settings.tellfriends;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import java.util.Timer;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dd */
/* loaded from: classes.dex */
public class AsyncTaskC1430dd extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ TwitterSignIn f5313a;

    public AsyncTaskC1430dd(TwitterSignIn twitterSignIn) {
        this.f5313a = twitterSignIn;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5313a.m5010c();
        if (this.f5313a.f5098i == null) {
            this.f5313a.f5098i = new Timer();
        } else {
            C1786r.m6063c("mTimer.cancel()", getClass().getSimpleName());
            this.f5313a.f5098i.cancel();
            this.f5313a.f5098i = null;
            this.f5313a.f5098i = new Timer();
        }
        this.f5313a.f5098i.schedule(new C1432df(this.f5313a, null), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Twitter doInBackground(String... strArr) {
        C1786r.m6063c("Called. OauthAccessTokenTask - doInBackground()", getClass().getSimpleName());
        try {
            AccessToken oAuthAccessToken = this.f5313a.f5091b.getOAuthAccessToken(strArr[0]);
            SharedPreferences.Editor editorEdit = this.f5313a.getSharedPreferences("TwitterLogin", 0).edit();
            editorEdit.putString("twitter_access_token", oAuthAccessToken.getToken());
            editorEdit.putString("twitter_access_secret_token", oAuthAccessToken.getTokenSecret());
            editorEdit.commit();
            this.f5313a.f5091b.setOAuthAccessToken(oAuthAccessToken);
            C1437dk.m5166a().m5167a(this.f5313a.f5091b);
            C1350ae.m5081a(this.f5313a.f5097h).m5083a(C1350ae.f5158b, C1437dk.m5166a().m5169c());
        } catch (TwitterException e) {
            e.printStackTrace();
            if (this.f5313a.f5095f != null) {
                this.f5313a.f5095f.sendEmptyMessage(9001);
            }
        }
        return this.f5313a.f5091b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Twitter twitter) {
        C1786r.m6063c("Called. OauthAccessTokenTask - onPostExecute()", getClass().getSimpleName());
        C1350ae.m5081a(this.f5313a.f5097h).m5083a(C1350ae.f5158b, C1437dk.m5166a().m5169c());
        if (this.f5313a.f5098i != null) {
            this.f5313a.f5098i.cancel();
        }
        this.f5313a.m5017a();
    }
}
