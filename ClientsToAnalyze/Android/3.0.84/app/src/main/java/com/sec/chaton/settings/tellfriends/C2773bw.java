package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import java.util.ArrayList;
import java.util.Iterator;
import weibo4android.User;
import weibo4android.UserWapper;
import weibo4android.WeiboException;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bw */
/* loaded from: classes.dex */
class C2773bw extends AbstractC2800p {

    /* renamed from: a */
    final /* synthetic */ C2770bt f10201a;

    /* renamed from: b */
    private long f10202b;

    /* synthetic */ C2773bw(C2770bt c2770bt, HandlerC2771bu handlerC2771bu) {
        this(c2770bt);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2773bw(C2770bt c2770bt) {
        super(c2770bt, "GetFriendsListTask");
        this.f10201a = c2770bt;
        this.f10202b = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        String message;
        long nextCursor;
        try {
            String strM9922d = C2780cc.m9922d(this.f10201a.f10300b);
            ArrayList arrayList = new ArrayList();
            do {
                UserWapper friendsStatuses2 = C2770bt.f10195d.getFriendsStatuses2(strM9922d, (int) this.f10202b, 5000);
                Iterator<User> it = friendsStatuses2.getUsers().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                nextCursor = friendsStatuses2.getNextCursor();
                this.f10202b = nextCursor;
            } while (nextCursor != 0);
            this.f10304e = -1;
            message = arrayList;
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
