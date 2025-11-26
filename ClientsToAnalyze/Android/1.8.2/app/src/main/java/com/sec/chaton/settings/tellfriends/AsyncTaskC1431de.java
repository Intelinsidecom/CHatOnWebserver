package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import java.util.Timer;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.de */
/* loaded from: classes.dex */
public class AsyncTaskC1431de extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ TwitterSignIn f5314a;

    public AsyncTaskC1431de(TwitterSignIn twitterSignIn) {
        this.f5314a = twitterSignIn;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5314a.m5010c();
        if (this.f5314a.f5098i == null) {
            this.f5314a.f5098i = new Timer();
        } else {
            C1786r.m6063c("mTimer.purge()", getClass().getSimpleName());
            this.f5314a.f5098i.cancel();
            this.f5314a.f5098i = null;
            this.f5314a.f5098i = new Timer();
        }
        this.f5314a.f5098i.schedule(new C1432df(this.f5314a, null), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        this.f5314a.f5091b = new TwitterFactory().getInstance();
        this.f5314a.f5091b.setOAuthConsumer(str, str2);
        try {
            try {
                return this.f5314a.f5091b.getOAuthRequestToken().getToken();
            } catch (TwitterException e) {
                e.printStackTrace();
                if (this.f5314a.f5095f != null) {
                    this.f5314a.f5095f.sendEmptyMessage(9001);
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
            this.f5314a.m5018a(str);
        }
    }
}
