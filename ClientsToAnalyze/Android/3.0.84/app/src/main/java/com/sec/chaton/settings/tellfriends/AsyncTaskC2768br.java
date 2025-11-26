package com.sec.chaton.settings.tellfriends;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import java.util.Timer;
import weibo4android.WeiboException;
import weibo4android.http.AccessToken;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.br */
/* loaded from: classes.dex */
public class AsyncTaskC2768br extends AsyncTask<String, Void, AccessToken> {

    /* renamed from: a */
    final /* synthetic */ DialogC2762bl f10192a;

    public AsyncTaskC2768br(DialogC2762bl dialogC2762bl) {
        this.f10192a = dialogC2762bl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AccessToken doInBackground(String... strArr) {
        WeiboException e;
        AccessToken accessToken;
        DialogC2762bl.m9883b("Called. GetAccessTokenTask - doInBackground()");
        try {
            accessToken = this.f10192a.f10176h.getAccessToken(Uri.parse(strArr[0]).getQueryParameter("oauth_verifier"));
        } catch (WeiboException e2) {
            e = e2;
            accessToken = null;
        }
        try {
            this.f10192a.f10175g.setOAuthAccessToken(accessToken);
        } catch (WeiboException e3) {
            e = e3;
            e.printStackTrace();
            this.f10192a.f10179k.mo540a(new C2785a(e.getMessage(), -1005, null));
            this.f10192a.dismiss();
            return accessToken;
        }
        return accessToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(AccessToken accessToken) {
        DialogC2762bl.m9883b("Called. GetAccessTokenTask - onPostExecute()");
        if (this.f10192a.f10185q != null) {
            this.f10192a.f10185q.cancel();
        }
        this.f10192a.f10179k.mo541a(accessToken);
        this.f10192a.dismiss();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f10192a.f10180l.isShowing()) {
            this.f10192a.f10180l.show();
        }
        if (this.f10192a.f10185q != null) {
            DialogC2762bl.m9883b("mTimer.cancel()");
            this.f10192a.f10185q.cancel();
            this.f10192a.f10185q = null;
            this.f10192a.f10185q = new Timer();
        } else {
            this.f10192a.f10185q = new Timer();
        }
        this.f10192a.f10185q.schedule(new C2767bq(this.f10192a, null), 30000L);
    }
}
