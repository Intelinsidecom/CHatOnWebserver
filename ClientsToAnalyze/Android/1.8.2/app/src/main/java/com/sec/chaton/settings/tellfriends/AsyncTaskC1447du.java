package com.sec.chaton.settings.tellfriends;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import java.util.Timer;
import weibo4android.WeiboException;
import weibo4android.http.RequestToken;

/* compiled from: WeiboSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.du */
/* loaded from: classes.dex */
public class AsyncTaskC1447du extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ WeiboSignIn f5341a;

    public AsyncTaskC1447du(WeiboSignIn weiboSignIn) {
        this.f5341a = weiboSignIn;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5341a.m5045c();
        if (this.f5341a.f5129i != null) {
            this.f5341a.f5129i.cancel();
            this.f5341a.f5129i = null;
            this.f5341a.f5129i = new Timer();
        } else {
            this.f5341a.f5129i = new Timer();
        }
        this.f5341a.f5129i.schedule(new C1448dv(this.f5341a, null), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        this.f5341a.f5121a = C1472u.m5199a().m5203b();
        this.f5341a.f5121a.setOAuthConsumer("1549470309", "a7d96376036a4b35a3e7a1e24632bd88");
        try {
            try {
                RequestToken requestTokenM5204c = C1472u.m5199a().m5204c();
                if (requestTokenM5204c == null) {
                    requestTokenM5204c = this.f5341a.f5121a.getOAuthRequestToken("chaton://WeiboSubMenuActivity");
                }
                Uri uri = Uri.parse(requestTokenM5204c.getAuthenticationURL() + "&from=chaton");
                C1472u.m5199a().m5202a(requestTokenM5204c);
                return uri.toString();
            } catch (WeiboException e) {
                e.printStackTrace();
                if (this.f5341a.f5125e != null) {
                    this.f5341a.f5125e.sendEmptyMessage(9001);
                }
                return "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (str.equals("")) {
            C1786r.m6054a("Incorrect Request Token!", getClass().getSimpleName());
        } else {
            this.f5341a.m5054a(str);
        }
    }
}
