package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.at */
/* loaded from: classes.dex */
public class AsyncTaskC1365at extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5198a;

    public AsyncTaskC1365at(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity) {
        this.f5198a = snsFriendsUsingChatOnActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            long[] jArr = new long[this.f5198a.f4996n.size()];
            for (int i = 0; i < this.f5198a.f4996n.size(); i++) {
                jArr[i] = Long.valueOf(((C1363ar) this.f5198a.f4996n.get(i)).f5190b).longValue();
            }
            ResponseList responseListLookupUsers = C1437dk.m5166a().m5170d().lookupUsers(jArr);
            for (int i2 = 0; i2 < responseListLookupUsers.size(); i2++) {
                this.f5198a.f4991i.add(new C1342a(((User) responseListLookupUsers.get(i2)).getName(), ((User) responseListLookupUsers.get(i2)).getScreenName(), ((User) responseListLookupUsers.get(i2)).getProfileImageURL().toString()));
                ((C1342a) this.f5198a.f4991i.get(this.f5198a.f4991i.size() - 1)).m5067a(((C1363ar) this.f5198a.f4996n.get(i2)).f5191c);
            }
            return null;
        } catch (TwitterException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        this.f5198a.m4857j();
        this.f5198a.f4988f.notifyDataSetChanged();
    }
}
