package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetMemoBlindList;
import com.sec.chaton.p033io.entry.inner.MemoBlindEntry;
import com.sec.widget.C1619g;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bl */
/* loaded from: classes.dex */
class HandlerC1041bl extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f3652a;

    HandlerC1041bl(ActivityPrivacy activityPrivacy) {
        this.f3652a = activityPrivacy;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        switch (message.what) {
            case 905:
                C0259g c0259g = (C0259g) message.obj;
                if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                    this.f3652a.f3463m.dismiss();
                    C1619g.m5889a(this.f3652a.f3454d, this.f3652a.getResources().getString(R.string.toast_network_unable), 0).show();
                    break;
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((GetMemoBlindList) c0259g.m932d()).blind.iterator();
                    while (it.hasNext()) {
                        MemoBlindEntry memoBlindEntry = (MemoBlindEntry) it.next();
                        try {
                            Long.parseLong(memoBlindEntry.value);
                            arrayList.add(memoBlindEntry.value);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    this.f3652a.f3461k.clear();
                    this.f3652a.f3461k = arrayList;
                    Intent intent = new Intent(this.f3652a.f3454d, (Class<?>) BuddyActivity2.class);
                    intent.putExtra("BUDDY_SORT_STYLE", 11);
                    intent.putExtra("ACTIVITY_PURPOSE", 9);
                    intent.putExtra("ACTIVITY_PURPOSE_ARG", arrayList);
                    this.f3652a.startActivityForResult(intent, 10);
                    break;
                }
                break;
            case 906:
                C0259g c0259g2 = (C0259g) message.obj;
                this.f3652a.f3463m.dismiss();
                if (!c0259g2.m927a() || c0259g2.m928b() == EnumC0518y.ERROR) {
                    C1619g.m5889a(this.f3652a.f3454d, this.f3652a.getResources().getString(R.string.toast_network_unable), 0).show();
                    break;
                } else {
                    C1619g.m5889a(this.f3652a.f3454d, this.f3652a.getResources().getString(R.string.toast_save_media), 0).show();
                    break;
                }
                break;
        }
    }
}
