package com.sec.chaton.ignore;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.getBuddyIgnoreList;
import com.sec.chaton.p028io.entry.inner.MemoBlindEntry;
import com.sec.widget.C2153y;
import java.util.ArrayList;
import twitter4j.MediaEntity;

/* compiled from: IgnoreFragment.java */
/* renamed from: com.sec.chaton.ignore.g */
/* loaded from: classes.dex */
class HandlerC0828g extends Handler {

    /* renamed from: a */
    final /* synthetic */ IgnoreFragment f3042a;

    HandlerC0828g(IgnoreFragment ignoreFragment) {
        this.f3042a = ignoreFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case MediaEntity.Size.CROP /* 101 */:
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    this.f3042a.f3021h.m2889a();
                    IgnoreFragment.f3015b.show();
                    break;
                }
                break;
            case 102:
                IgnoreFragment.f3015b.dismiss();
                this.f3042a.f3019f.setEmptyView(this.f3042a.f3023j);
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    if (c0101b.m665b() != EnumC0803m.NO_CONTENT) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = ((getBuddyIgnoreList) c0101b.m671d()).ignore;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= arrayList2.size()) {
                                    this.f3042a.f3020g.clear();
                                    this.f3042a.f3020g.addAll(arrayList);
                                    this.f3042a.f3022i.notifyDataSetChanged();
                                    break;
                                } else {
                                    arrayList.add(new C0829h(this.f3042a, ((MemoBlindEntry) arrayList2.get(i2)).value));
                                    i = i2 + 1;
                                }
                            }
                        }
                    }
                } else {
                    C2153y.m7535a(this.f3042a.getActivity(), R.string.popup_no_network_connection, 1).show();
                    this.f3042a.getActivity().finish();
                    break;
                }
                break;
        }
    }
}
