package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetBlockBuddyList;
import com.sec.chaton.p033io.entry.inner.BlockBuddy;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.util.ArrayList;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.c */
/* loaded from: classes.dex */
class HandlerC0356c extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1038a;

    HandlerC0356c(BlockFragment blockFragment) {
        this.f1038a = blockFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 601:
                BlockFragment.f1026b.dismiss();
                this.f1038a.f1030f.setEmptyView(this.f1038a.f1034j);
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    if (c0259g.m928b() != EnumC0518y.NO_CONTENT) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = ((GetBlockBuddyList) c0259g.m932d()).buddy;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= arrayList2.size()) {
                                    this.f1038a.f1031g.clear();
                                    this.f1038a.f1031g.addAll(arrayList);
                                    this.f1038a.f1033i.notifyDataSetChanged();
                                    break;
                                } else {
                                    C1341p.m4662e("NO : " + ((BlockBuddy) arrayList2.get(i2)).value + ", Name : " + ((BlockBuddy) arrayList2.get(i2)).name + ", ORGNUM : " + ((BlockBuddy) arrayList2.get(i2)).orgnum, getClass().getSimpleName());
                                    arrayList.add(new C0359f(this.f1038a, ((BlockBuddy) arrayList2.get(i2)).value, ((BlockBuddy) arrayList2.get(i2)).name, ((BlockBuddy) arrayList2.get(i2)).orgnum));
                                    i = i2 + 1;
                                }
                            }
                        }
                    }
                } else {
                    C1619g.m5888a(this.f1038a.getActivity(), R.string.popup_no_network_connection, 1).show();
                    this.f1038a.getActivity().finish();
                    break;
                }
                break;
            case 603:
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    this.f1038a.f1032h.m796a();
                    BlockFragment.f1026b.show();
                    break;
                }
                break;
        }
    }
}
