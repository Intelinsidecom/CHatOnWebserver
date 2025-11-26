package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import twitter4j.IDs;
import twitter4j.TwitterException;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bs */
/* loaded from: classes.dex */
public class AsyncTaskC1391bs extends AsyncTask {

    /* renamed from: a */
    IDs f5245a = null;

    /* renamed from: b */
    final /* synthetic */ TWFollowingsListActivity f5246b;

    public AsyncTaskC1391bs(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5246b = tWFollowingsListActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(Long... lArr) {
        long jLongValue = lArr[0].longValue();
        long jLongValue2 = lArr[1].longValue();
        try {
            if (this.f5246b.f5017d == null) {
                this.f5246b.f5017d = C1437dk.m5166a().m5170d();
                this.f5246b.f5026m = this.f5246b.f5017d.showUser(this.f5246b.f5017d.getId()).getFriendsCount();
            }
            this.f5245a = this.f5246b.f5017d.getFriendsIDs(jLongValue);
            this.f5246b.f5025l = this.f5245a.getNextCursor();
            this.f5246b.f5022i = this.f5245a.getIDs();
        } catch (TwitterException e) {
            e.printStackTrace();
            jLongValue2 = 3;
        }
        return Long.valueOf(jLongValue2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        if (this.f5246b.f5026m != 0) {
            if (l.longValue() == 1) {
                this.f5246b.m4926a(this.f5246b.f5022i, true);
                return;
            } else if (l.longValue() == 0) {
                this.f5246b.m4926a(this.f5246b.f5022i, false);
                return;
            } else {
                if (l.longValue() == 3) {
                }
                return;
            }
        }
        ((LinearLayout) this.f5246b.findViewById(R.id.no_list_layout)).setVisibility(0);
        if (this.f5246b.f5016c != null && this.f5246b.f5016c.isShowing()) {
            this.f5246b.f5016c.dismiss();
            this.f5246b.f5016c = null;
        }
        if (l.longValue() == 3) {
            this.f5246b.m4906f();
        }
    }
}
