package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.util.C3250y;
import java.util.Timer;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ax */
/* loaded from: classes.dex */
public class AsyncTaskC2747ax extends AsyncTask<String, Void, AccessToken> {

    /* renamed from: a */
    final /* synthetic */ DialogC2741ar f10144a;

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f10144a.f10133k.isShowing()) {
            this.f10144a.f10133k.show();
        }
        if (this.f10144a.f10138p == null) {
            this.f10144a.f10138p = new Timer();
        } else {
            C3250y.m11453c("mTimer.cancel()", getClass().getSimpleName());
            this.f10144a.f10138p.cancel();
            this.f10144a.f10138p = null;
            this.f10144a.f10138p = new Timer();
        }
        this.f10144a.f10138p.schedule(new C2746aw(this.f10144a, null), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AccessToken doInBackground(String... strArr) {
        TwitterException e;
        AccessToken oAuthAccessToken;
        C3250y.m11453c("Called. OauthAccessTokenTask - doInBackground()", getClass().getSimpleName());
        try {
            oAuthAccessToken = this.f10144a.f10129g.getOAuthAccessToken(strArr[0]);
        } catch (TwitterException e2) {
            e = e2;
            oAuthAccessToken = null;
        }
        try {
            this.f10144a.f10129g.setOAuthAccessToken(oAuthAccessToken);
        } catch (TwitterException e3) {
            e = e3;
            e.printStackTrace();
            this.f10144a.f10132j.mo540a(new C2785a(e.getErrorMessage(), -1001, null));
            this.f10144a.m9828b();
            return oAuthAccessToken;
        }
        return oAuthAccessToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(AccessToken accessToken) {
        C3250y.m11453c("Called. OauthAccessTokenTask - onPostExecute()", getClass().getSimpleName());
        if (this.f10144a.f10138p != null) {
            this.f10144a.f10138p.cancel();
        }
        this.f10144a.f10132j.mo541a(accessToken);
        this.f10144a.dismiss();
    }
}
