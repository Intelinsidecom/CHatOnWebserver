package com.sec.chaton.settings.tellfriends;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import java.util.Timer;
import weibo4android.User;
import weibo4android.WeiboException;
import weibo4android.http.AccessToken;
import weibo4android.http.RequestToken;

/* compiled from: WeiboSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dt */
/* loaded from: classes.dex */
public class AsyncTaskC1446dt extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ WeiboSignIn f5340a;

    public AsyncTaskC1446dt(WeiboSignIn weiboSignIn) {
        this.f5340a = weiboSignIn;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5340a.m5045c();
        if (this.f5340a.f5129i != null) {
            this.f5340a.f5129i.cancel();
            this.f5340a.f5129i = null;
            this.f5340a.f5129i = new Timer();
        } else {
            this.f5340a.f5129i = new Timer();
        }
        this.f5340a.f5129i.schedule(new C1448dv(this.f5340a, null), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        try {
            AccessToken accessToken = C1472u.m5199a().m5204c().getAccessToken(Uri.parse(strArr[0]).getQueryParameter("oauth_verifier"));
            C1472u.m5199a().m5201a(accessToken);
            if (this.f5340a.f5121a == null) {
                this.f5340a.f5121a = C1472u.m5199a().m5203b();
            }
            User userShowUser = this.f5340a.f5121a.showUser(String.valueOf(accessToken.getUserId()));
            this.f5340a.f5126f = userShowUser.getName();
            SharedPreferences.Editor editorEdit = this.f5340a.getSharedPreferences("WeiboLogin", 0).edit();
            editorEdit.putString("weibo_access_token", accessToken.getToken());
            editorEdit.putString("weibo_access_secret_token", accessToken.getTokenSecret());
            editorEdit.putLong("weibo_userID", accessToken.getUserId());
            editorEdit.putString("weibo_userName", this.f5340a.f5126f);
            editorEdit.commit();
            this.f5340a.f5121a.setOAuthAccessToken(accessToken);
            C1472u.m5199a().m5202a((RequestToken) null);
            return true;
        } catch (WeiboException e) {
            e.printStackTrace();
            if (this.f5340a.f5125e != null) {
                this.f5340a.f5125e.sendEmptyMessage(9001);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        C1786r.m6063c("Called. OauthAccessTokenTask - onPostExecute()", getClass().getSimpleName());
        C1350ae.m5081a(this.f5340a.f5128h).m5083a(C1350ae.f5159c, String.valueOf(this.f5340a.getSharedPreferences("WeiboLogin", 0).getLong("weibo_userID", 0L)));
        if (this.f5340a.f5129i != null) {
            this.f5340a.f5129i.cancel();
        }
        if (bool.booleanValue()) {
            this.f5340a.m5053a();
        }
    }
}
