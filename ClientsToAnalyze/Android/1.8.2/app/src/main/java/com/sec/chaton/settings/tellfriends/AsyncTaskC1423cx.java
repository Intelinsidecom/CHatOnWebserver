package com.sec.chaton.settings.tellfriends;

import android.content.res.Resources;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C2153y;
import twitter4j.TwitterException;

/* compiled from: TwitterMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cx */
/* loaded from: classes.dex */
public class AsyncTaskC1423cx extends AsyncTask {

    /* renamed from: a */
    boolean f5304a;

    /* renamed from: b */
    boolean f5305b;

    /* renamed from: c */
    final /* synthetic */ TwitterMessageActivity f5306c;

    public AsyncTaskC1423cx(TwitterMessageActivity twitterMessageActivity) {
        this.f5306c = twitterMessageActivity;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f5304a = false;
        this.f5305b = false;
        this.f5304a = true;
        if (!this.f5306c.isFinishing()) {
            this.f5306c.f5089i.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            if (!this.f5304a) {
                C1437dk.m5166a().m5170d().updateStatus(this.f5306c.f5086f.getText().toString());
            } else {
                this.f5305b = true;
            }
            return str;
        } catch (TwitterException e) {
            e.printStackTrace();
            this.f5306c.finish();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws Resources.NotFoundException {
        String string;
        if (!isCancelled() && !this.f5306c.isFinishing()) {
            if (this.f5306c.f5089i.isShowing()) {
                try {
                    this.f5306c.f5089i.dismiss();
                } catch (IllegalArgumentException e) {
                    return;
                }
            }
            if (str != null) {
                string = this.f5306c.getResources().getString(R.string.facebook_post_completed);
            } else {
                string = this.f5306c.getResources().getString(R.string.facebook_post_failed);
            }
            C2153y.m7536a(this.f5306c, string, 0).show();
            this.f5306c.f5082b = null;
            this.f5306c.finish();
            return;
        }
        this.f5306c.f5082b = null;
    }
}
