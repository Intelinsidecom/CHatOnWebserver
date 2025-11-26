package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import android.widget.AbsListView;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bd */
/* loaded from: classes.dex */
class C1376bd implements AbsListView.OnScrollListener {

    /* renamed from: a */
    int f5215a;

    /* renamed from: b */
    final /* synthetic */ TWFollowingsListActivity f5216b;

    C1376bd(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5216b = tWFollowingsListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f5215a = i;
        if (this.f5215a == 0 && this.f5216b.f5021h.size() > 0) {
            int i2 = this.f5216b.f5039z;
            int i3 = this.f5216b.f5011A + i2;
            int size = i3 > this.f5216b.f5021h.size() ? this.f5216b.f5021h.size() : i3;
            for (int i4 = i2; i4 < size; i4++) {
                C1390br c1390br = (C1390br) this.f5216b.f5021h.get(i4);
                C1383bk c1383bk = (C1383bk) this.f5216b.f5019f.get(i4);
                if (c1383bk.f5223a == null && !this.f5216b.isFinishing()) {
                    this.f5216b.f5036w = new AsyncTaskC1389bq(this.f5216b);
                    if (this.f5216b.f5014E) {
                        this.f5216b.f5036w.execute(c1383bk.f5226d.toString(), c1390br.f5241a, Integer.toString(i4));
                    } else {
                        this.f5216b.f5036w.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, c1383bk.f5226d.toString(), c1390br.f5241a, Integer.toString(i4));
                    }
                } else {
                    c1390br.f5241a.setBackgroundDrawable(c1383bk.f5223a);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f5216b.f5039z = i;
        this.f5216b.f5011A = i2;
        if (this.f5216b.f5029p) {
            this.f5216b.f5029p = false;
            if (this.f5216b.f5018e == null) {
                this.f5216b.m4924a();
                return;
            }
            return;
        }
        if (this.f5215a == 1) {
            if (this.f5216b.f5011A + i == i3) {
                this.f5216b.f5032s = false;
                this.f5216b.f5030q = true;
                return;
            } else if (i == 0) {
                this.f5216b.f5032s = true;
                this.f5216b.f5030q = false;
                return;
            } else {
                this.f5216b.f5032s = false;
                this.f5216b.f5030q = false;
                return;
            }
        }
        if (i != 0 && this.f5216b.f5011A + i == i3 && this.f5216b.f5018e == null && !this.f5216b.f5038y) {
            this.f5216b.m4927b();
        }
        if (this.f5215a == 0 && this.f5216b.f5021h.size() > 0) {
            int i4 = this.f5216b.f5039z;
            int i5 = this.f5216b.f5011A + i4;
            int size = i5 >= this.f5216b.f5021h.size() ? this.f5216b.f5021h.size() : i5;
            for (int i6 = i4; i6 < size; i6++) {
                C1390br c1390br = (C1390br) this.f5216b.f5021h.get(i6);
                C1383bk c1383bk = (C1383bk) this.f5216b.f5019f.get(i6);
                if (c1383bk.f5223a == null && !this.f5216b.isFinishing()) {
                    this.f5216b.f5036w = new AsyncTaskC1389bq(this.f5216b);
                    if (this.f5216b.f5014E) {
                        this.f5216b.f5036w.execute(c1383bk.f5226d.toString(), c1390br.f5241a, Integer.toString(i6));
                    } else {
                        this.f5216b.f5036w.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, c1383bk.f5226d.toString(), c1390br.f5241a, Integer.toString(i6));
                    }
                } else {
                    c1390br.f5241a.setBackgroundDrawable(c1383bk.f5223a);
                }
            }
        }
    }
}
