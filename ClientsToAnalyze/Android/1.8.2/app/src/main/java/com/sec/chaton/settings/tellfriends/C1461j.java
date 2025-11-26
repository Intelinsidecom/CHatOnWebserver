package com.sec.chaton.settings.tellfriends;

import android.widget.AbsListView;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.j */
/* loaded from: classes.dex */
class C1461j implements AbsListView.OnScrollListener {

    /* renamed from: a */
    int f5368a;

    /* renamed from: b */
    final /* synthetic */ InviteFacebookActivity f5369b;

    C1461j(InviteFacebookActivity inviteFacebookActivity) {
        this.f5369b = inviteFacebookActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        m5196a(i);
    }

    /* renamed from: a */
    private void m5196a(int i) {
        this.f5368a = i;
        if (this.f5368a == 0 && this.f5369b.f4958o.size() > 0) {
            int i2 = this.f5369b.f4948d;
            int size = this.f5369b.f4949e + i2;
            if (size > this.f5369b.f4958o.size()) {
                size = this.f5369b.f4958o.size();
            }
            if (this.f5369b.f4952h < 5) {
                while (i2 < size) {
                    this.f5369b.m4794a(i2);
                    i2++;
                }
            } else {
                InviteFacebookActivity inviteFacebookActivity = this.f5369b;
                inviteFacebookActivity.f4953i = size + inviteFacebookActivity.f4953i;
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f5369b.f4947c = this.f5369b.f4948d;
        this.f5369b.f4948d = i;
        this.f5369b.f4949e = i2;
        if (this.f5368a != 1 && this.f5368a == 0 && this.f5369b.f4958o.size() > 0) {
            int i4 = this.f5369b.f4948d;
            int size = this.f5369b.f4949e + i4;
            if (size >= this.f5369b.f4958o.size()) {
                size = this.f5369b.f4958o.size();
            }
            while (i4 < size) {
                this.f5369b.m4794a(i4);
                i4++;
            }
        }
    }
}
