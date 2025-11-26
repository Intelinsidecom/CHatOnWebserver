package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import twitter4j.TwitterException;

/* compiled from: TwitterSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dj */
/* loaded from: classes.dex */
public class AsyncTaskC1436dj extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ TwitterSubMenuActivity f5320a;

    public AsyncTaskC1436dj(TwitterSubMenuActivity twitterSubMenuActivity) {
        this.f5320a = twitterSubMenuActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String name;
        try {
            this.f5320a.f5102c = C1437dk.m5166a().m5170d();
            name = this.f5320a.f5102c.showUser(this.f5320a.f5102c.getId()).getName();
        } catch (TwitterException e) {
            e.printStackTrace();
            name = null;
        }
        this.f5320a.m5031e();
        if (name == null) {
            return null;
        }
        return name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (str != null) {
            this.f5320a.f5106g.setText(str);
        } else {
            C1786r.m6061b("getmyNameTask : name is null", getClass().getSimpleName());
        }
    }
}
