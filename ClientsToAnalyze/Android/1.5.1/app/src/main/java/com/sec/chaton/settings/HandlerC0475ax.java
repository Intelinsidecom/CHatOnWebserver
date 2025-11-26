package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetMemoBlindList;
import com.sec.chaton.p000io.entry.inner.MemoBlindEntry;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sec.chaton.settings.ax */
/* loaded from: classes.dex */
class HandlerC0475ax extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3166a;

    HandlerC0475ax(ActivitySettings activitySettings) {
        this.f3166a = activitySettings;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        switch (message.what) {
            case TrunkMessageControl.METHOD_DELETE_ITEM /* 905 */:
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((GetMemoBlindList) httpEntry.m1955d()).blind.iterator();
                    while (it.hasNext()) {
                        MemoBlindEntry memoBlindEntry = (MemoBlindEntry) it.next();
                        try {
                            Long.parseLong(memoBlindEntry.value);
                            arrayList.add(memoBlindEntry.value);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    this.f3166a.f3013t.clear();
                    this.f3166a.f3013t = arrayList;
                    Intent intent = new Intent(this.f3166a.f2999f, (Class<?>) BuddyActivity2.class);
                    intent.putExtra("BUDDY_SORT_STYLE", 11);
                    intent.putExtra("ACTIVITY_PURPOSE", 9);
                    intent.putExtra("ACTIVITY_PURPOSE_ARG", arrayList);
                    this.f3166a.startActivityForResult(intent, 10);
                    break;
                } else {
                    if (this.f3166a.f3015v != null) {
                        this.f3166a.f3015v.dismiss();
                    }
                    Toast.makeText(this.f3166a.f2999f, this.f3166a.getResources().getString(C0062R.string.dev_network_error), 0).show();
                    break;
                }
                break;
            case TrunkMessageControl.METHOD_REMOVE_COMMENT /* 906 */:
                HttpEntry httpEntry2 = (HttpEntry) message.obj;
                if (httpEntry2.m1950a() && httpEntry2.m1951b() != HttpResultCode.ERROR) {
                    Toast.makeText(this.f3166a.f2999f, this.f3166a.getResources().getString(C0062R.string.toast_save_media), 0).show();
                    break;
                } else {
                    if (this.f3166a.f3015v != null) {
                        this.f3166a.f3015v.dismiss();
                    }
                    Toast.makeText(this.f3166a.f2999f, this.f3166a.getResources().getString(C0062R.string.dev_network_error), 0).show();
                    break;
                }
                break;
        }
    }
}
