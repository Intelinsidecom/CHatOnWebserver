package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import java.util.ArrayList;
import weibo4android.IDs;
import weibo4android.WeiboException;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bv */
/* loaded from: classes.dex */
class C2772bv extends AbstractC2800p {

    /* renamed from: a */
    ArrayList<Long> f10199a;

    /* renamed from: b */
    final /* synthetic */ C2770bt f10200b;

    /* synthetic */ C2772bv(C2770bt c2770bt, HandlerC2771bu handlerC2771bu) {
        this(c2770bt);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2772bv(C2770bt c2770bt) {
        super(c2770bt, "GetFriendsIDsTask");
        this.f10200b = c2770bt;
        this.f10199a = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        String message;
        int nextCursor = -1;
        try {
            String strM9922d = C2780cc.m9922d(this.f10200b.f10300b);
            do {
                IDs friendsListIDS_test2 = C2770bt.f10195d.getFriendsListIDS_test2(strM9922d, nextCursor, 5000);
                for (long j : friendsListIDS_test2.getIDs()) {
                    this.f10199a.add(Long.valueOf(j));
                }
                nextCursor = (int) friendsListIDS_test2.getNextCursor();
            } while (nextCursor != 0);
            long[] jArr = new long[this.f10199a.size()];
            for (int i = 0; i < this.f10199a.size(); i++) {
                jArr[i] = this.f10199a.get(i).longValue();
            }
            this.f10304e = -1;
            message = jArr;
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.f10304e = -1005;
            message = e.getMessage();
        } catch (WeiboException e2) {
            e2.printStackTrace();
            this.f10304e = -1005;
            message = e2.getMessage();
        }
        this.f10305f = message;
        return this.f10304e;
    }
}
