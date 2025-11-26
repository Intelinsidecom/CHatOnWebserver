package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bn */
/* loaded from: classes.dex */
public class AsyncTaskC1386bn extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5233a;

    public AsyncTaskC1386bn(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5233a = tWFollowingsListActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(long[]... jArr) {
        int length;
        long[] jArr2 = jArr[0];
        int size = this.f5233a.f5019f.size();
        this.f5233a.f5028o = size;
        C1786r.m6063c("wholeIDList.length : " + jArr2.length + "\tfollowingsCount : " + size, getClass().getSimpleName());
        if (jArr2.length - size <= 100) {
            this.f5233a.f5038y = true;
            length = (jArr2.length - size) + size;
        } else {
            length = size + 100;
        }
        C1786r.m6063c("count : " + length, getClass().getSimpleName());
        long[] jArr3 = new long[100];
        int i = 0;
        for (int i2 = this.f5233a.f5027n * 100; i2 < length; i2++) {
            jArr3[i] = this.f5233a.f5022i[i2];
            i++;
        }
        try {
            ResponseList responseListLookupUsers = C1437dk.m5166a().m5170d().lookupUsers(jArr3);
            for (long j : jArr3) {
                for (int i3 = 0; i3 < responseListLookupUsers.size(); i3++) {
                    User user = (User) responseListLookupUsers.get(i3);
                    if (j == user.getId()) {
                        C1383bk c1383bk = new C1383bk(this.f5233a);
                        c1383bk.f5225c = user.getName();
                        c1383bk.f5224b = user.getScreenName();
                        c1383bk.f5223a = null;
                        c1383bk.f5226d = user.getProfileImageURL();
                        this.f5233a.f5020g.add(c1383bk);
                        responseListLookupUsers.remove(i3);
                    }
                }
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        if (this.f5233a.f5015a != null) {
            this.f5233a.f5015a.sendEmptyMessage(9001);
        }
        return null;
    }
}
