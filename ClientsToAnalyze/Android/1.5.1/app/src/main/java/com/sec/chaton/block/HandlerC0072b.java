package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetBlockBuddyList;
import com.sec.chaton.p000io.entry.inner.BlockBuddy;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;

/* renamed from: com.sec.chaton.block.b */
/* loaded from: classes.dex */
class HandlerC0072b extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockActivity f376a;

    HandlerC0072b(BlockActivity blockActivity) {
        this.f376a = blockActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        switch (message.what) {
            case 601:
                BlockActivity.f346b.dismiss();
                if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
                    Toast.makeText(this.f376a, C0062R.string.toast_setting_communication_failed, 1).show();
                    this.f376a.finish();
                    break;
                } else if (httpEntry.m1951b() != HttpResultCode.NO_CONTENT) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = ((GetBlockBuddyList) httpEntry.m1955d()).buddy;
                    if (arrayList2 != null) {
                        if (arrayList2.size() == 0) {
                            this.f376a.f354j.setVisibility(0);
                            break;
                        } else {
                            this.f376a.f354j.setVisibility(8);
                            for (int i = 0; i < arrayList2.size(); i++) {
                                ChatONLogWriter.m3511e("NO : " + ((BlockBuddy) arrayList2.get(i)).value + ", Name : " + ((BlockBuddy) arrayList2.get(i)).name + ", ORGNUM : " + ((BlockBuddy) arrayList2.get(i)).orgnum, getClass().getSimpleName());
                                arrayList.add(new C0071a(this.f376a, C0062R.drawable.contacts_default_image, ((BlockBuddy) arrayList2.get(i)).value, ((BlockBuddy) arrayList2.get(i)).name, ((BlockBuddy) arrayList2.get(i)).orgnum));
                            }
                            this.f376a.f351g.clear();
                            this.f376a.f351g.addAll(arrayList);
                            this.f376a.f353i.notifyDataSetChanged();
                            break;
                        }
                    } else {
                        this.f376a.f354j.setVisibility(0);
                        break;
                    }
                } else {
                    this.f376a.f354j.setVisibility(0);
                    break;
                }
                break;
            case 603:
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f376a.f352h.m1989a();
                    BlockActivity.f346b.show();
                    break;
                }
                break;
        }
    }
}
