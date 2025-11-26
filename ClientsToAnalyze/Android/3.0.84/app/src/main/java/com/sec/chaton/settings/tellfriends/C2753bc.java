package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.ArrayList;
import twitter4j.IDs;
import twitter4j.TwitterException;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bc */
/* loaded from: classes.dex */
class C2753bc extends AbstractC2800p {

    /* renamed from: a */
    ArrayList<Long> f10155a;

    /* renamed from: b */
    final /* synthetic */ C2751ba f10156b;

    /* synthetic */ C2753bc(C2751ba c2751ba, HandlerC2752bb handlerC2752bb) {
        this(c2751ba);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2753bc(C2751ba c2751ba) {
        super(c2751ba, "GetFriendsIDsTask");
        this.f10156b = c2751ba;
        this.f10155a = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        String message;
        long nextCursor = -1;
        do {
            try {
                IDs friendsIDs = C2751ba.f10150e.getFriendsIDs(nextCursor);
                for (long j : friendsIDs.getIDs()) {
                    this.f10155a.add(Long.valueOf(j));
                }
                nextCursor = friendsIDs.getNextCursor();
            } catch (NullPointerException e) {
                e.printStackTrace();
                this.f10304e = DlcApi.RC_SVC_NOT_CONNECTED;
                message = e.getMessage();
            } catch (TwitterException e2) {
                e2.printStackTrace();
                this.f10304e = -1001;
                message = e2.getMessage();
            }
        } while (nextCursor != 0);
        long[] jArr = new long[this.f10155a.size()];
        for (int i = 0; i < this.f10155a.size(); i++) {
            jArr[i] = this.f10155a.get(i).longValue();
        }
        this.f10304e = -1;
        message = jArr;
        this.f10305f = message;
        return this.f10304e;
    }
}
