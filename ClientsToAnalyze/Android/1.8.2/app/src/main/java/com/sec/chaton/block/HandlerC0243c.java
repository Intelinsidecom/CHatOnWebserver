package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetBlockBuddyList;
import com.sec.chaton.p028io.entry.inner.BlockBuddy;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: BlockActivity.java */
/* renamed from: com.sec.chaton.block.c */
/* loaded from: classes.dex */
class HandlerC0243c extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockActivity f812a;

    HandlerC0243c(BlockActivity blockActivity) {
        this.f812a = blockActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 601:
                if (this.f812a.f792p && BlockActivity.f781b != null && BlockActivity.f781b.isShowing()) {
                    this.f812a.f792p = false;
                    return;
                }
                if (BlockActivity.f781b != null && BlockActivity.f781b.isShowing()) {
                    BlockActivity.f781b.dismiss();
                }
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    this.f812a.f788l.clear();
                    if (c0101b.m665b() != EnumC0803m.NO_CONTENT) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = ((GetBlockBuddyList) c0101b.m671d()).buddy;
                        if (arrayList2 != null) {
                            for (int i = 0; i < arrayList2.size(); i++) {
                                C1786r.m6066e("NO : " + ((BlockBuddy) arrayList2.get(i)).value + ", Name : " + ((BlockBuddy) arrayList2.get(i)).name + ", ORGNUM : " + ((BlockBuddy) arrayList2.get(i)).orgnum, getClass().getSimpleName());
                                BlockFragment blockFragment = this.f812a.f784e;
                                blockFragment.getClass();
                                arrayList.add(new C0253m(blockFragment, R.drawable.contacts_default_image, ((BlockBuddy) arrayList2.get(i)).value, ((BlockBuddy) arrayList2.get(i)).name, ((BlockBuddy) arrayList2.get(i)).orgnum));
                            }
                        }
                        this.f812a.f788l.addAll(arrayList);
                        this.f812a.f790n.notifyDataSetChanged();
                        break;
                    }
                } else {
                    Toast.makeText(this.f812a.getApplicationContext(), R.string.toast_setting_communication_failed, 1).show();
                    this.f812a.finish();
                    break;
                }
                break;
            case 603:
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    this.f812a.f789m.m2844a();
                    BlockActivity.f781b.show();
                    break;
                }
                break;
        }
        this.f812a.invalidateOptionsMenu();
    }
}
