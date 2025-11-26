package com.sec.chaton.settings.tellfriends;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import twitter4j.IDs;
import twitter4j.Twitter;

/* compiled from: TwitterUtil.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dm */
/* loaded from: classes.dex */
public class AsyncTaskC1439dm extends AsyncTask {

    /* renamed from: a */
    IDs f5328a = null;

    /* renamed from: b */
    final /* synthetic */ C1437dk f5329b;

    public AsyncTaskC1439dm(C1437dk c1437dk) {
        this.f5329b = c1437dk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Drawable doInBackground(Twitter... twitterArr) throws IOException {
        Drawable drawable;
        Exception exc;
        Twitter twitter = twitterArr[0];
        try {
            InputStream inputStream = (InputStream) new URL(twitter.showUser(twitter.getId()).getProfileImageURL().toString()).getContent();
            Drawable drawableCreateFromStream = Drawable.createFromStream(inputStream, "srcName");
            try {
                inputStream.close();
                return drawableCreateFromStream;
            } catch (Exception e) {
                drawable = drawableCreateFromStream;
                exc = e;
                exc.printStackTrace();
                return drawable;
            }
        } catch (Exception e2) {
            drawable = null;
            exc = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Drawable drawable) {
        this.f5329b.f5323b = drawable;
    }
}
