package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import weibo4android.User;
import weibo4android.WeiboException;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.au */
/* loaded from: classes.dex */
public class AsyncTaskC1366au extends AsyncTask {

    /* renamed from: a */
    User f5199a = null;

    /* renamed from: b */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5200b;

    public AsyncTaskC1366au(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity) {
        this.f5200b = snsFriendsUsingChatOnActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        if (this.f5200b.f4998p == null) {
            this.f5200b.f4998p = C1472u.m5199a().m5203b();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f5200b.f4996n.size()) {
                try {
                    this.f5199a = this.f5200b.f4998p.showUser(((C1363ar) this.f5200b.f4996n.get(i2)).f5190b);
                    this.f5200b.f4991i.add(new C1342a(this.f5199a.getName(), this.f5199a.getScreenName(), this.f5199a.getProfileImageURL().toString()));
                } catch (WeiboException e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        this.f5200b.m4857j();
        this.f5200b.f4988f.notifyDataSetChanged();
    }
}
