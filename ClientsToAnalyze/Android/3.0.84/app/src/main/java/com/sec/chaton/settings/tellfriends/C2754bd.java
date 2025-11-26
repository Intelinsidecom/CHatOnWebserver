package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.ArrayList;
import java.util.List;
import twitter4j.IDs;
import twitter4j.TwitterException;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bd */
/* loaded from: classes.dex */
class C2754bd extends AbstractC2800p {

    /* renamed from: a */
    ArrayList<Long> f10157a;

    /* renamed from: b */
    final /* synthetic */ C2751ba f10158b;

    /* renamed from: c */
    private int f10159c;

    /* synthetic */ C2754bd(C2751ba c2751ba, HandlerC2752bb handlerC2752bb) {
        this(c2751ba);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2754bd(C2751ba c2751ba) {
        super(c2751ba, "GetFriendsListTask");
        this.f10158b = c2751ba;
        this.f10157a = new ArrayList<>();
        this.f10159c = 0;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        Object message;
        try {
            if (this.f10157a.isEmpty()) {
                long nextCursor = -1;
                do {
                    IDs friendsIDs = C2751ba.f10150e.getFriendsIDs(nextCursor);
                    for (long j : friendsIDs.getIDs()) {
                        this.f10157a.add(Long.valueOf(j));
                    }
                    nextCursor = friendsIDs.getNextCursor();
                } while (nextCursor != 0);
            }
            int iM9863c = m9863c() * 100;
            int size = iM9863c + 100 < this.f10157a.size() ? iM9863c + 100 : this.f10157a.size();
            this.f10158b.m10014b("startIndex = " + iM9863c + " endIndex = " + size);
            List<Long> listSubList = this.f10157a.subList(m9863c() * 100, size);
            long[] jArr = new long[100];
            for (int i = 0; i < listSubList.size(); i++) {
                jArr[i] = listSubList.get(i).longValue();
            }
            message = C2751ba.f10150e.lookupUsers(jArr);
            m9864d();
            this.f10304e = -1;
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.f10304e = DlcApi.RC_SVC_NOT_CONNECTED;
            message = e.getMessage();
        } catch (TwitterException e2) {
            e2.printStackTrace();
            this.f10304e = -1001;
            message = e2.getMessage();
        }
        this.f10305f = message;
        return this.f10304e;
    }

    /* renamed from: c */
    private int m9863c() {
        return this.f10159c;
    }

    /* renamed from: d */
    private void m9864d() {
        this.f10159c++;
    }

    /* renamed from: b */
    public boolean m9865b() {
        return (!this.f10157a.isEmpty() && m9863c() * 100 < this.f10157a.size()) || this.f10157a.isEmpty();
    }
}
