package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import android.widget.AbsListView;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cf */
/* loaded from: classes.dex */
class C1405cf implements AbsListView.OnScrollListener {

    /* renamed from: a */
    int f5268a;

    /* renamed from: b */
    final /* synthetic */ TellFriendsWeiboActivity f5269b;

    C1405cf(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5269b = tellFriendsWeiboActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f5268a = i;
        if (this.f5268a == 0 && this.f5269b.f5062h.size() > 0) {
            int i2 = this.f5269b.f5050A;
            int i3 = this.f5269b.f5051B + i2;
            int size = i3 > this.f5269b.f5062h.size() ? this.f5269b.f5062h.size() : i3;
            for (int i4 = i2; i4 < size; i4++) {
                C1416cq c1416cq = (C1416cq) this.f5269b.f5062h.get(i4);
                C1417cr c1417cr = (C1417cr) this.f5269b.f5060f.get(i4);
                if (c1417cr.f5287b == null) {
                    this.f5269b.f5078x = new AsyncTaskC1415cp(this.f5269b);
                    if (this.f5269b.f5054G) {
                        this.f5269b.f5078x.execute(c1417cr.f5290e.toString(), c1416cq.f5282a, Integer.toString(i4));
                    } else {
                        this.f5269b.f5078x.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, c1417cr.f5290e.toString(), c1416cq.f5282a, Integer.toString(i4));
                    }
                } else {
                    c1416cq.f5282a.setBackgroundDrawable(c1417cr.f5287b);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f5269b.f5050A = i;
        this.f5269b.f5051B = i2;
        if (this.f5269b.f5071q) {
            this.f5269b.f5071q = false;
            if (this.f5269b.f5059e == null) {
                this.f5269b.m4989a();
                return;
            }
            return;
        }
        if (this.f5268a == 1) {
            if (this.f5269b.f5051B + i == i3) {
                this.f5269b.f5074t = false;
                this.f5269b.f5072r = true;
                return;
            } else if (i == 0) {
                this.f5269b.f5074t = true;
                this.f5269b.f5072r = false;
                return;
            } else {
                this.f5269b.f5074t = false;
                this.f5269b.f5072r = false;
                return;
            }
        }
        if (i != 0 && this.f5269b.f5051B + i == i3 && this.f5269b.f5059e == null && !this.f5269b.f5080z) {
            this.f5269b.m4992b();
        }
        if (this.f5268a == 0 && this.f5269b.f5062h.size() > 0) {
            int i4 = this.f5269b.f5050A;
            int i5 = this.f5269b.f5051B + i4;
            int size = i5 >= this.f5269b.f5062h.size() ? this.f5269b.f5062h.size() : i5;
            for (int i6 = i4; i6 < size; i6++) {
                C1416cq c1416cq = (C1416cq) this.f5269b.f5062h.get(i6);
                C1417cr c1417cr = (C1417cr) this.f5269b.f5060f.get(i6);
                if (c1417cr.f5287b == null) {
                    AsyncTaskC1415cp asyncTaskC1415cp = new AsyncTaskC1415cp(this.f5269b);
                    if (this.f5269b.f5054G) {
                        asyncTaskC1415cp.execute(c1417cr.f5290e.toString(), c1416cq.f5282a, Integer.toString(i6));
                    } else {
                        asyncTaskC1415cp.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, c1417cr.f5290e.toString(), c1416cq.f5282a, Integer.toString(i6));
                    }
                } else {
                    c1416cq.f5282a.setBackgroundDrawable(c1417cr.f5287b);
                }
            }
        }
    }
}
