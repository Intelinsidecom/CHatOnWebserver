package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/* compiled from: TwitterUtil.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dl */
/* loaded from: classes.dex */
public class AsyncTaskC1438dl extends AsyncTask {

    /* renamed from: a */
    IDs f5326a = null;

    /* renamed from: b */
    final /* synthetic */ C1437dk f5327b;

    public AsyncTaskC1438dl(C1437dk c1437dk) {
        this.f5327b = c1437dk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Twitter... twitterArr) {
        String name;
        TwitterException e;
        Twitter twitter = twitterArr[0];
        try {
            name = twitter.showUser(twitter.getId()).getName();
        } catch (TwitterException e2) {
            name = null;
            e = e2;
        }
        try {
            this.f5327b.f5325d = String.valueOf(twitter.getId());
        } catch (TwitterException e3) {
            e = e3;
            e.printStackTrace();
            return name;
        }
        return name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (str != null) {
            this.f5327b.f5324c = str;
        }
    }
}
