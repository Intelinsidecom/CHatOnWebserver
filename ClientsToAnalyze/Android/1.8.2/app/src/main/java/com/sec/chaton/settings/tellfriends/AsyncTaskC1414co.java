package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import java.util.List;
import weibo4android.User;
import weibo4android.WeiboException;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.co */
/* loaded from: classes.dex */
public class AsyncTaskC1414co extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5280a;

    public AsyncTaskC1414co(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5280a = tellFriendsWeiboActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(long[]... jArr) {
        int length;
        long[] jArr2 = jArr[0];
        int size = this.f5280a.f5060f.size();
        this.f5280a.f5070p = size;
        C1786r.m6063c("wholeIDList.length : " + jArr2.length + "\tfollowingsCount : " + size, getClass().getSimpleName());
        if (jArr2.length - size <= 100) {
            this.f5280a.f5080z = true;
            length = (jArr2.length - size) + size;
        } else {
            length = size + 100;
        }
        C1786r.m6063c("count : " + length, getClass().getSimpleName());
        try {
            List users = this.f5280a.f5058d.getFriendsStatuses2(String.valueOf(this.f5280a.getSharedPreferences("WeiboLogin", 0).getLong("weibo_userID", 0L)), this.f5280a.f5070p, 100).getUsers();
            for (int i = 0; i < users.size(); i++) {
                C1417cr c1417cr = new C1417cr(this.f5280a);
                c1417cr.f5286a = ((User) users.get(i)).getId();
                c1417cr.f5289d = ((User) users.get(i)).getName();
                c1417cr.f5288c = ((User) users.get(i)).getScreenName();
                c1417cr.f5287b = null;
                c1417cr.f5290e = ((User) users.get(i)).getProfileImageURL();
                this.f5280a.f5061g.add(c1417cr);
            }
        } catch (WeiboException e) {
            e.printStackTrace();
        }
        this.f5280a.f5056a.sendEmptyMessage(9001);
        return null;
    }
}
