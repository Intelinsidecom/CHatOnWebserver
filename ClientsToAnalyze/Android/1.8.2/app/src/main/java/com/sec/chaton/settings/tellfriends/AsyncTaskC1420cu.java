package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import weibo4android.IDs;
import weibo4android.WeiboException;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cu */
/* loaded from: classes.dex */
public class AsyncTaskC1420cu extends AsyncTask {

    /* renamed from: a */
    IDs f5299a = null;

    /* renamed from: b */
    IDs f5300b = null;

    /* renamed from: c */
    final /* synthetic */ TellFriendsWeiboActivity f5301c;

    public AsyncTaskC1420cu(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5301c = tellFriendsWeiboActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(Long... lArr) {
        long j;
        long jLongValue = lArr[0].longValue();
        long jLongValue2 = lArr[1].longValue();
        String strValueOf = String.valueOf(this.f5301c.getSharedPreferences("WeiboLogin", 0).getLong("weibo_userID", 0L));
        try {
            if (this.f5301c.f5058d == null) {
                this.f5301c.f5058d = C1472u.m5199a().m5203b();
                this.f5301c.f5068n = this.f5301c.f5058d.showUser(strValueOf).getFriendsCount();
            }
            this.f5299a = this.f5301c.f5058d.getFriendsListIDS_test2(strValueOf, (int) jLongValue, 5000);
            this.f5301c.f5067m = this.f5299a.getNextCursor();
            int i = (int) this.f5301c.f5067m;
            this.f5301c.f5063i = this.f5299a.getIDs();
            if (i != 0) {
                while (i == 0) {
                    this.f5300b = this.f5301c.f5058d.getFriendsListIDS_test2(strValueOf, i, 5000);
                    this.f5301c.f5064j = this.f5300b.getIDs();
                    int i2 = 0;
                    for (int i3 = i; i3 < this.f5301c.f5064j.length + i; i3++) {
                        if (i2 != this.f5301c.f5064j.length) {
                            this.f5301c.f5063i[i3] = this.f5301c.f5064j[i2];
                            i2++;
                        }
                    }
                    this.f5301c.f5067m = this.f5300b.getNextCursor();
                    i = (int) this.f5301c.f5067m;
                }
            }
            j = jLongValue2;
        } catch (WeiboException e) {
            e.printStackTrace();
            j = 3;
        }
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        if (this.f5301c.f5068n == 0) {
            ((LinearLayout) this.f5301c.findViewById(R.id.no_list_layout)).setVisibility(0);
            if (this.f5301c.f5057c != null && this.f5301c.f5057c.isShowing()) {
                this.f5301c.f5057c.dismiss();
                this.f5301c.f5057c = null;
            }
            this.f5301c.m4968g();
            return;
        }
        if (l.longValue() == 1) {
            this.f5301c.m4991a(this.f5301c.f5063i, true);
        } else if (l.longValue() == 0) {
            this.f5301c.m4991a(this.f5301c.f5063i, false);
        } else {
            if (l.longValue() == 3) {
            }
        }
    }
}
